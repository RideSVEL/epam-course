package ua.nure.vasilchenko.practice3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

    private static final String ENCODING = "Cp1251";

    public static String readFile(String path) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, ENCODING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public static String[] checkOriginal(String[] strings) {
        int count = 0;
        int number = 0;
      for (int i = 0; i < strings.length; i++) {
            if ("null".equals(strings[i])) {
                continue;
            }
            for (int j = i; j < strings.length - 1; j++) {
                if (strings[i].equals(strings[j + 1])) {
                    strings[j + 1] = "null";
                    count++;
                }
            }
        }
        String[] result = new String[strings.length - count];
        for (String string : strings) {
            if (!"null".equals(string)) {
                result[number++] = string;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(readFile("part1.txt"));
    }

}
