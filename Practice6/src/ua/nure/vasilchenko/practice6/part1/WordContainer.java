package ua.nure.vasilchenko.practice6.part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordContainer {
    private List<Word> words = new ArrayList<>();

    public WordContainer() {
        String[] temp = read();
        for (String s : temp) {
            if ("stop".equals(s)) {
                break;
            } else {
                add(new Word(s));
            }
        }
        Collections.sort(words);
    }

    private static String[] read() {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            if (!"stop".equals(temp)) {
                sb.append(temp).append(" ");
            } else {
                break;
            }
        }
        scanner.close();
        return sb.toString().split(" ");
    }

    public void output() {
        for (Word word : words) {
            System.out.println(word);
        }
    }

    private void add(Word word) {
        boolean confirm = false;
        for (Word w : words) {
            if (w.equals(word)) {
                confirm = true;
                w.incFrequency();
                break;
            }
        }
        if (!confirm) {
            words.add(word);
        }
    }

    public static void main(String[] args) {
        WordContainer wordContainer = new WordContainer();
        wordContainer.output();
    }
}
