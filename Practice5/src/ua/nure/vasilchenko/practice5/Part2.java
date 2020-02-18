package ua.nure.vasilchenko.practice5;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Part2 {
    private static final InputStream STD_IN = System.in;
    private static final InputStream YOUR_OWN_INPUT_STREAM = new ByteArrayInputStream(new byte[] {'\n'});

    public static void main(String[] args) throws InterruptedException {

        System.setIn(YOUR_OWN_INPUT_STREAM);
        Thread t = new Thread(() -> Spam.main(null));
        t.start();
        Thread.sleep(2000);

        t.join();
        System.setIn(STD_IN);
    }
}
