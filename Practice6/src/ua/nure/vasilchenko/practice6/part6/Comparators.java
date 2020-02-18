package ua.nure.vasilchenko.practice6.part6;

import java.io.Serializable;
import java.util.Comparator;

public final class Comparators {

    private Comparators() {
        throw new IllegalStateException("Utility class");
    }

    public static class CompareByWord implements Comparator<Word>, Serializable {
        private static final long serialVersionUID = 1;
        @Override
        public int compare(Word o1, Word o2) {
            return o2.getSay().compareTo(o1.getSay());
        }
    }

    public static class CompareByLength implements Comparator<Word>, Serializable {
        private static final long serialVersionUID = 1;
        @Override
        public int compare(Word o1, Word o2) {
            return -(o1.getLength() - o2.getLength());
        }
    }
}
