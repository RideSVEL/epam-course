package ua.nure.vasilchenko.practice5;

public class Part1 {

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        thread1.start();
        thread1.join();
        Thread thread2 = new Thread(new Thread2());
        thread2.start();
        thread2.join();
        Thread thread3 = new Thread(Part1::threadMethod);
        thread3.start();
        thread3.join();
    }


    public static class Thread1 extends Thread {
        @Override
        public void run() {
            threadMethod();
        }
    }

    public static class Thread2 implements Runnable {
        @Override
        public void run() {
            threadMethod();
        }
    }

    private static void threadMethod() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(333);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
