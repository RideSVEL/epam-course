package ua.nure.vasilchenko.practice4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;


public class Part4 implements Iterable<String> {
    private String[] word;

    public Part4() {
        String input = Util.readFile("part4.txt");
        Pattern pattern = Pattern.compile("[.!?]");
        word = pattern.split(input);
        for (int i = 0; i < word.length; i++) {
            word[i] = word[i].replaceAll("\\r?\\n", "");
            word[i] = word[i].trim() + ".";
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }

    public class MyIterator implements Iterator<String> {

        private int position;

        @Override
        public boolean hasNext() {
            return position < word.length;
        }

        @Override
        public String next() {
            if (this.hasNext()) {
                return word[position++];
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Part4 part4 = new Part4();
        for (String s : part4) {
            System.out.println(s);
        }
    }
}
