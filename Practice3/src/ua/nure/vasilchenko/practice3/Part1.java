package ua.nure.vasilchenko.practice3;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Part1 {
    public static final String NAME_FILES = "part1.txt";
    public static final String DELIMITER = "\r?\n";
    public static final String SIGN = " ==> ";
    public static final int HUNDRED = 100;
    public static final int THOUSAND = 1000;
    public static final int TEN = 10;
    public static final int FOUR_NUMBERS = 9999;


    public static void main(String[] args) {
        System.out.println(convert1(Util.readFile(NAME_FILES)));
        System.out.println(convert2(Util.readFile(NAME_FILES)));
        System.out.println(convert3(Util.readFile(NAME_FILES)));
        System.out.println(convert4(Util.readFile(NAME_FILES)));
    }

    public static String convert1(String input) {
        String[] strings = input.split(DELIMITER);
        String[] elements;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < strings.length; i++) {
            elements = strings[i].split(";");
            sb.append(elements[0]).append(": ").append(elements[2]).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String convert2(String input) {
        String[] strings = input.split(DELIMITER);
        String[] elements;
        String[] nameLastName;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < strings.length; i++) {
            elements = strings[i].split(";");
            nameLastName = elements[1].split(" ");
            sb.append(nameLastName[1]).append(" ").append(nameLastName[0])
                    .append(" (email: ").append(elements[2]).append(")\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String convert3(String input) {
        String[] buff = input.split(DELIMITER);
        String[] buff2;
        String[] temp;
        StringBuilder result = new StringBuilder();
        String[] domen;
        String[] buff3;
        String[] test;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder resultLast = new StringBuilder();
        for (int i = 1; i < buff.length; i++) {
            temp = buff[i].split(";");
            domen = temp[2].split("@");
            stringBuilder.append(domen[1]).append(" ");
            result.append(temp[2]).append(SIGN).append(temp[0]).append("\n");
        }
        test = stringBuilder.toString().split(" ");
        String[] uniqe = Util.checkOriginal(test);
        buff2 = result.toString().split("\n");
        for (int i = 0; i < uniqe.length; i++) {
            Pattern pattern = Pattern.compile("@" + uniqe[i]);
            resultLast.append(uniqe[i]).append(SIGN);
            for (String s : buff2) {
                Matcher matcher = pattern.matcher(s);
                if (matcher.find()) {
                    buff3 = s.split(SIGN);
                    resultLast.append(buff3[1]).append(", ");
                }
            }
            resultLast.delete(resultLast.length() - 2, resultLast.length());
            if (i != uniqe.length - 1) {
                resultLast.append("\n");
            }
        }
        return resultLast.toString();
    }

    public static String convert4(String input) {
        StringBuilder result;
        String[] buff = input.split(DELIMITER);
        result = new StringBuilder(buff[0] + ";Password" + "\r\n");

        for (int i = 1; i < buff.length; i++) {
            SecureRandom secureRandom = new SecureRandom();
            int temp = secureRandom.nextInt(FOUR_NUMBERS);
            if (temp < TEN) {
                result.append(buff[i]).append(";").append("000").append(temp).append("\r\n");
            } else if (temp < HUNDRED) {
                result.append(buff[i]).append(";").append("00").append(temp).append("\r\n");
            } else if (temp < THOUSAND) {
                result.append(buff[i]).append(";").append("0").append(temp).append("\r\n");
            } else {
                result.append(buff[i]).append(";").append(temp).append("\r\n");
            }
        }
        return result.toString();
    }

}
