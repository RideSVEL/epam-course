package ua.nure.vasilchenko.practice5;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Part1.main(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.join();
        Thread t2 = new Thread(() -> {
            try {
                Part2.main(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        t2.join();

        Thread t3 = new Thread(() -> {
            try {
                Part3.main(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.start();
        t3.join();

        Thread t4 = new Thread(() -> {
            try {
                Part4.main(null);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        t4.start();
        t4.join();

        Thread t5 = new Thread(() -> {
            try {
                Part5.main(null);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        t5.start();
        t5.join();
        Part6.main(null);
    }
}
