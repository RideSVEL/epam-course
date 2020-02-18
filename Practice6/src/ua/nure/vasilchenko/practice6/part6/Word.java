package ua.nure.vasilchenko.practice6.part6;

import java.util.Objects;

public class Word implements Comparable<Word> {

    private String say;
    private int frequency;
    private int length;

    public Word(String say) {
        this.say = say;
        frequency = 1;
        length = say.length();
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void incFrequency() {
        frequency++;
    }

    @Override
    public String toString() {
        return say + " ==> " + frequency;
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
        return -(this.frequency - o.frequency);
    }

}
