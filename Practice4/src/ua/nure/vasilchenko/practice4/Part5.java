package ua.nure.vasilchenko.practice4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Scanner;

public class Part5 {

    public static final String NO_SUCH_VALUES = "No such values";

    public static String enProperties(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream("src/resources_en.properties");
        properties.load(in);
        in.close();
        return properties.getProperty(key, NO_SUCH_VALUES);
    }

    public static String ruProperties(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream("src/resources_ru.properties");
        BufferedReader inBuf = new BufferedReader(new InputStreamReader(in, "Cp1251"));
        properties.load(inBuf);
        inBuf.close();
        return properties.getProperty(key, NO_SUCH_VALUES);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String temp;
        while (true) {
            temp = scanner.nextLine();
            if ("stop".equals(temp)) {
                break;
            }
            String[] buff = temp.split(" ");
            if (buff.length >= 2) {
                if ("en".equals(buff[1])) {
                    System.out.println(enProperties(buff[0]));
                } else if ("ru".equals(buff[1])) {
                    System.out.println(ruProperties(buff[0]));
                } else {
                    System.out.println(enProperties(buff[0]));
                }
            } else {
                System.out.println(NO_SUCH_VALUES);
            }
        }
    }
}
