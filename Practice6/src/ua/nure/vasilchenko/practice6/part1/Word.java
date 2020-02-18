package ua.nure.vasilchenko.practice6.part1;

import java.util.Objects;

public class Word implements Comparable<Word> {

    private String say;
    private int frequency;

    public Word(String say) {
        this.say = say;
        frequency = 1;
    }

    public void incFrequency() {
        frequency++;
    }

    @Override
    public String toString() {
        return say + " : " + frequency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(say, frequency);
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == obj.getClass()) {
            Word w = (Word) obj;
            return say.equals(w.say);
        }
        return false;
    }

    @Override
    public int compareTo(Word o) {
        int result = -(this.frequency - o.frequency);
        if (result == 0) {
            result = this.say.compareTo(o.say);
        }
        return result;
    }
}


