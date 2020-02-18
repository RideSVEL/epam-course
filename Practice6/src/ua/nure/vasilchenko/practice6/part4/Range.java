package ua.nure.vasilchenko.practice6.part4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {


    List<Integer> list = new ArrayList<>();
    boolean reverse;

    public Range(int n, int m) {
        for (int i = n; i <= m; i++) {
            list.add(i);
        }
    }

    public Range(int n, int m, boolean reverse) {
        for (int i = n; i <= m; i++) {
            list.add(i);
        }
        this.reverse = reverse;
    }

    @Override
    public Iterator<Integer> iterator() {
        if (reverse) {
            return new DescendingIterator();
        }
        return new MyIterator();
    }

    class MyIterator implements Iterator<Integer> {
        private int position;

        @Override
        public boolean hasNext() {
            return position < list.size();
        }

        @Override
        public Integer next() {
            if (this.hasNext()) {
                return list.get(position++);
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    class DescendingIterator implements Iterator<Integer> {
        private int position = list.size() - 1;

        @Override
        public boolean hasNext() {
            return position >= 0;
        }

        @Override
        public Integer next() {
            if (this.hasNext()) {
                return list.get(position--);
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}

