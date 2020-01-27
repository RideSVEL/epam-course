package ua.nure.vasilchenko.practice4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static String convert(String input) {
        StringBuilder sb = new StringBuilder(input);
        Pattern p = Pattern.compile("\\b\\p{L}{4,}");
        Matcher m = p.matcher(input);
        while (m.find()) {
            char[] array = sb.substring(m.start(), m.end()).toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (Character.isUpperCase(array[i])) {
                    sb.setCharAt(m.start() + i, Character.toLowerCase(array[i]));
                } else {
                    sb.setCharAt(m.start() + i, Character.toUpperCase(array[i]));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert(Util.readFile("part1.txt")));
    }
}
