package ua.nure.vasilchenko.practice5;


public class Part6 {

    private static final Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            synchronized (MONITOR) {
                System.out.println("BLOCKED");
                System.out.println("WAITING");
                System.out.println("TERMINATED");
            }
        });
        t.start();
        t.join();
    }
}
