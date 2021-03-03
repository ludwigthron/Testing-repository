package com.test.morse;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class MorseCode {
    /**
     * This BiMap is used to connect two strings so that we can translate between them.
     */

    public BiMap<String, String> morseCodeTranslations;

    public MorseCode() {
        morseCodeTranslations = HashBiMap.create();
        morseCodeTranslations.put("A", ".- ");
        morseCodeTranslations.put("B", "-... ");
        morseCodeTranslations.put("C", "-.-. ");
        morseCodeTranslations.put("D", "-.. ");
        morseCodeTranslations.put("E", ". ");
        morseCodeTranslations.put("F", "..-. ");
        morseCodeTranslations.put("G", "--. ");
        morseCodeTranslations.put("H", ".... ");
        morseCodeTranslations.put("I", ".. ");
        morseCodeTranslations.put("J", ".--- ");
        morseCodeTranslations.put("K", "-.- ");
        morseCodeTranslations.put("L", ".-.. ");
        morseCodeTranslations.put("M", "-- ");
        morseCodeTranslations.put("N", "-. ");
        morseCodeTranslations.put("O", "--- ");
        morseCodeTranslations.put("P", ".--. ");
        morseCodeTranslations.put("Q", "--.- ");
        morseCodeTranslations.put("R", ".-. ");
        morseCodeTranslations.put("S", "... ");
        morseCodeTranslations.put("T", "- ");
        morseCodeTranslations.put("U", "..- ");
        morseCodeTranslations.put("V", "...- ");
        morseCodeTranslations.put("W", ".-- ");
        morseCodeTranslations.put("X", "-..- ");
        morseCodeTranslations.put("Y", "-.-- ");
        morseCodeTranslations.put("Z", "--.. ");
        morseCodeTranslations.put("0", "----- ");
        morseCodeTranslations.put("1", ".---- ");
        morseCodeTranslations.put("2", "..--- ");
        morseCodeTranslations.put("3", "...-- ");
        morseCodeTranslations.put("4", "....- ");
        morseCodeTranslations.put("5", "..... ");
        morseCodeTranslations.put("6", "-.... ");
        morseCodeTranslations.put("7", "--... ");
        morseCodeTranslations.put("8", "---.. ");
        morseCodeTranslations.put("9", "----. ");
        morseCodeTranslations.put(".", ".-.-.- ");
        morseCodeTranslations.put(",", "--..-- ");
        morseCodeTranslations.put("?", "..--.. ");
        morseCodeTranslations.put(" ", " ");
    }

    /**
     * This function makes it so we can encrypt our english to morse code.
     */

    public String encrypt(String string) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char character = Character.toUpperCase(string.charAt(i));
            result.append(morseCodeTranslations.get(Character.toString(character)));
        }

        return result.toString();
    }

    /**
     * This function makes it so we can decrypt our morse code to english.
     */

    public String decrypt(String morseCode) {
        String[] characters = morseCode.split(" ");
        StringBuilder result = new StringBuilder();

        for (String character : characters) {
            result.append(morseCodeTranslations.inverse().get(character + " "));
        }

        return result.toString();
    }
}
