package ua.nure.vasilchenko.practice6.part1;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Part1 {
    private static final InputStream STD_IN = System.in;

    public static void main(String[] args) {
        System.setIn(new ByteArrayInputStream(
                ("Du^hast^mich^Du^hast^Du^hast^mich^gefragt^stop").replace("^", System.lineSeparator()).getBytes()));
        WordContainer.main(args);
        System.setIn(STD_IN);
    }
}
