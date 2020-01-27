package ua.nure.vasilchenko.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static final String PATH_TO_FILE = "part3.txt";

    public static String checkString(String input) {
        StringBuilder temp = new StringBuilder(input);
        StringBuilder result = new StringBuilder();
        Pattern strings = Pattern.compile("\\b\\p{L}{2,}");
        Matcher m = strings.matcher(temp);
        while (m.find()) {
            result.append(temp.substring(m.start(), m.end())).append(" ");
        }
        if (!"".contentEquals(result)) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    public static String checkChar(String input) {
        StringBuilder temp = new StringBuilder(input);
        StringBuilder result = new StringBuilder();
        Pattern strings = Pattern.compile("\\b\\p{L}\\b");
        Matcher m = strings.matcher(temp);
        while (m.find()) {
            result.append(temp.substring(m.start(), m.end())).append(" ");
        }
        if (!"".contentEquals(result)) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    public static String checkInt(String input) {
        StringBuilder temp = new StringBuilder(input);
        StringBuilder buff = new StringBuilder(temp);
        StringBuilder result = new StringBuilder();
        Pattern integerNumber = Pattern.compile("[-+]?[0-9]+");
        Pattern doubleNumber = Pattern.compile("[0-9]*[.,][0-9]*");
        Matcher m = doubleNumber.matcher(temp);
        int count = 0;
        while (m.find()) {
            buff.delete(m.start() - count, m.end() - count);
            count += m.end() - m.start();
        }
        m.reset();
        m = integerNumber.matcher(buff);
        while (m.find()) {
            result.append(buff.substring(m.start(), m.end())).append(" ");
        }
        if (!"".contentEquals(result)) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    public static String checkDouble(String input) {
        StringBuilder temp = new StringBuilder(input);
        StringBuilder result = new StringBuilder();
        Pattern doubleNumber = Pattern.compile("[0-9]*[.,][0-9]*");
        Matcher m = doubleNumber.matcher(temp);
        while (m.find()) {
            result.append(temp.substring(m.start(), m.end())).append(" ");
        }
        if (!"".contentEquals(result)) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    public static String checkEmpty(String input) {
        if ("".equals(input)) {
            return "No such values";
        } else {
            return input;
        }
    }

    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String swit;
        while (loop) {
            swit = scanner.nextLine();
            switch (swit) {
                case "String":
                    System.out.println(checkEmpty(checkString(Util.readFile(PATH_TO_FILE))));
                    break;
                case "int":
                    System.out.println(checkEmpty(checkInt(Util.readFile(PATH_TO_FILE))));
                    break;
                case "double":
                    System.out.println(checkEmpty(checkDouble(Util.readFile(PATH_TO_FILE))));
                    break;
                case "char":
                    System.out.println(checkEmpty(checkChar(Util.readFile(PATH_TO_FILE))));
                    break;
                case "stop":
                    loop = false;
                    break;
                default:
                    System.out.println("Incorrect input");
            }
        }
    }
}
