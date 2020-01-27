package ua.nure.vasilchenko.practice4;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static String latn(String input) {
        StringBuilder result1 = new StringBuilder();
        Pattern latin = Pattern.compile("\\b\\w+\\b");
        Matcher m = latin.matcher(input);
        while (m.find()) {
            result1.append(input, m.start(), m.end()).append(" ");
        }
        if (!"".contentEquals(result1)) {
            result1.deleteCharAt(result1.length() - 1);
        }
        return result1.toString();
    }

    public static String cyrl(String input) {
        StringBuilder result2 = new StringBuilder();
        Pattern cyrillic = Pattern.compile("\\b[а-яА-Яёєїі]+\\b");
        Matcher m = cyrillic.matcher(input);
        while (m.find()) {
            result2.append(input, m.start(), m.end()).append(" ");
        }
        if (!"".contentEquals(result2)) {
            result2.deleteCharAt(result2.length() - 1);
        }
        return result2.toString();
    }

    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String swit;
        while (loop) {
            swit = scanner.next();
            switch (swit.toLowerCase(Locale.ENGLISH)) {
                case "latn":
                    System.out.println(swit + ": " + latn(Util.readFile("part6.txt")));
                    break;
                case "cyrl":
                    System.out.println(swit + ": " + cyrl(Util.readFile("part6.txt")));
                    break;
                case "stop":
                    loop = false;
                    break;
                default:
                    System.out.println(swit + ": Incorrect input");
            }
        }
    }
}
