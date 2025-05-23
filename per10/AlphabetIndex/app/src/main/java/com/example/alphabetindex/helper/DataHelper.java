package com.example.alphabetindex.helper;

import java.util.ArrayList;

public class DataHelper {

    public static ArrayList<String> getAlphabetFullData() {
        ArrayList<String> list = new ArrayList<>();

        String[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        for (String letter : letters) {
            for (int i = 1; i <= 5; i++) {
                list.add(letter + " item " + i);
            }
        }

        return list;
    }

    public static ArrayList<String> getAlphabetNotFullData() {
        ArrayList<String> list = new ArrayList<>();

        String[] partialLetters = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N","O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y","Z"
        };

        for (String letter : partialLetters) {
            for (int i = 1; i <= 5; i++) {
                list.add(letter + " item " + i);
            }
        }

        return list;
    }
}