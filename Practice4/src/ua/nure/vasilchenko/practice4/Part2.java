package ua.nure.vasilchenko.practice4;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;

public class Part2 {

    public static final int NUMBER_FIFTY = 50;
    public static final String PATH_TO_FILE = "part2.txt";

    private static String generateNumbers() {
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            sb.append(secureRandom.nextInt(NUMBER_FIFTY));
            if (i != 9) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void writeString2File(String input, String name) throws IOException {
        File file = new File(name);
        if (!file.exists()) {
            file.createNewFile();
        }
        PrintWriter pw = new PrintWriter(file);
        pw.print(input);
        pw.close();
    }

    public static void sorting(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }


    public static String convert() throws IOException {
        writeString2File(generateNumbers(), PATH_TO_FILE);
        String[] temp = Util.readFile(PATH_TO_FILE).split(" ");
        int[] numbers = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            numbers[i] = Integer.parseInt(temp[i]);
        }
        sorting(numbers);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        writeString2File(sb.toString(), "part2_sorted.txt");
        return "input ==> " + Util.readFile(PATH_TO_FILE) +
                System.lineSeparator() +
                "output ==> " + Util.readFile("part2_sorted.txt");
    }

    public static void main(String[] args) throws IOException {
        System.out.println(convert());
    }
}
