package org.example.util;

public class Util {
    public static String toTitleCase(String strIn) {
        if (strIn == null || strIn.isEmpty()) {
            return strIn;
        }

        String[] words = strIn.split(" ");
        String result = "";

        for (String word : words) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
        }

        return result;
    }
}
