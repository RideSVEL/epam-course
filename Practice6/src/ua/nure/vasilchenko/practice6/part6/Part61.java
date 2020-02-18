package ua.nure.vasilchenko.practice6.part6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part61 {

    private List<Word> words = new ArrayList<>();

    public Part61(String input) {
        start(input);
        outputFrequency();
    }

    private void start(String input) {
        String[] temp = input.split("\r?\n");
        for (String value : temp) {
            String[] buff = value.split(" ");
            for (String s : buff) {
                add(new Word(s));
            }
        }
        Collections.sort(words);
    }

    private void outputFrequency() {
        List<Word> wordList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            wordList.add(words.get(i));
        }
        wordList.sort(new Comparators.CompareByWord());
        for (Word word : wordList) {
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
}