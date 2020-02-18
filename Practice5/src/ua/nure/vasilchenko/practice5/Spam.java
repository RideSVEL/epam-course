package ua.nure.vasilchenko.practice5;

import java.util.Scanner;

public class Spam {
    private Thread[] threads;

    public Spam(String[] messages, int[] times) {
        threads = new Thread[messages.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Worker(messages[i], times[i]);
        }
    }

    public void start() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public void stop() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    private static class Worker extends Thread {
        private String message;
        private long time;

        public Worker(String message, long time) {
            this.message = message;
            this.time = time;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    sleep(time);
                } catch (InterruptedException e) {
                    return;
                }
                System.out.println(message);
            }
        }
    }

    public static void main(String[] args) {
        String[] messages = new String[]{"@@@", "bbbbbbb", "jjjj"};
        int[] times = new int[]{800, 600, 400};
        Spam spam = new Spam(messages, times);
        spam.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();
        spam.stop();
    }
}

