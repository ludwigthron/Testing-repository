package com.test.morse;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainScreen extends JFrame {

    private final JTextField textFieldWord;
    private final JTextField textFieldMorseCode;
    private final JTextArea textArea;

    MorseCode morseCode;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainScreen frame = new MainScreen();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainScreen() {
        setTitle("Morse Code");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 370);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(6, 6, 480, 370);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblEnterAWord = new JLabel("Enter a word/digits");
        lblEnterAWord.setBounds(6, 6, 209, 16);
        panel.add(lblEnterAWord);

        textFieldWord = new JTextField();
        textFieldWord.setBounds(3, 23, 358, 22);
        panel.add(textFieldWord);
        textFieldWord.setColumns(10);

        JLabel lblEnterAMorseCode = new JLabel(
                "Enter a morse code (separated by ' ')");
        lblEnterAMorseCode.setBounds(6, 57, 250, 16);
        panel.add(lblEnterAMorseCode);

        textFieldMorseCode = new JTextField();
        textFieldMorseCode.setBounds(3, 74, 358, 22);
        panel.add(textFieldMorseCode);
        textFieldMorseCode.setColumns(10);

        JButton btnNewButton = new JButton("Encrypt");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                morseCode = new MorseCode();
                String result = morseCode.encrypt(textFieldWord.getText());
                textArea.setText(result);
            }
        });
        btnNewButton.setBounds(376, 20, 76, 29);
        panel.add(btnNewButton);

        JButton btnDecrypt = new JButton("Decrypt");
        btnDecrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                morseCode = new MorseCode();
                String result = morseCode.decrypt(textFieldMorseCode.getText());
                textArea.setText(result);
            }
        });
        btnDecrypt.setBounds(376, 71, 76, 29);
        panel.add(btnDecrypt);

        textArea = new JTextArea();
        textArea.setBounds(6, 112, 436, 210);
        panel.add(textArea);
    }
}
