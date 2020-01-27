package ua.nure.vasilchenko.practice4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Demo {
    private static final InputStream STD_IN = System.in;

    public static void main(String[] args) throws IOException {

        Part1.main(args);
        Part2.main(args);
        System.setIn(new ByteArrayInputStream(
                "char^String^int^double^stop".replace("^", System.lineSeparator()).getBytes()));
        Part3.main(args);
        System.setIn(STD_IN);
        Part4.main(args);
        System.setIn(new ByteArrayInputStream(
                "table ru^table en^apple ru^stop".replace("^", System.lineSeparator()).getBytes()));
        Part5.main(args);
        System.setIn(STD_IN);
        System.setIn(new ByteArrayInputStream(
                "Latn^Cyrl^asdf^latn^cyrl^stop".replace("^", System.lineSeparator()).getBytes()));
        Part6.main(args);
        System.setIn(STD_IN);
    }
}
