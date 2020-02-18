package ua.nure.vasilchenko.practice6.part6;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Part63 {

    private int counter;
    private List<Word> words = new ArrayList<>();

    public Part63(String input) {
        start(input);
        outputDuplicates();
    }

    private void start(String input) {
        String[] temp = input.split("\r?\n");
        for (String value : temp) {
            String[] buff = value.split(" ");
            for (String s : buff) {
                add(new Word(s));
            }
        }
    }

    private void outputDuplicates() {
        for (Word word : words) {
            if (word.getFrequency() > 1 && counter < 3) {
                StringBuilder sb = new StringBuilder();
                sb.append(word.getSay().toUpperCase(Locale.ENGLISH));
                System.out.println(sb.reverse().toString());
                counter++;
            }
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
}
