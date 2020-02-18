package ua.nure.vasilchenko.practice6.part6;

import java.util.ArrayList;
import java.util.List;

public class Part62 {

    private List<Word> words = new ArrayList<>();

    public Part62(String input) {
        start(input);
        outputLength();
    }


    private void start(String input) {
        String[] temp = input.split("\r?\n");
        for (String value : temp) {
            String[] buff = value.split(" ");
            for (String s : buff) {
                add(new Word(s));
            }
        }
        words.sort(new Comparators.CompareByLength());
    }


    private void outputLength() {
        for (int i = 0; i < 3; i++) {
            System.out.println(words.get(i).getSay() + " ==> " + words.get(i).getLength());
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
