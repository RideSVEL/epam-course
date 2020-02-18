package ua.nure.vasilchenko.practice5;

public class tests {

    private static final Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                synchronized (MONITOR) {
                    MONITOR.wait();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        t.start();
        System.out.println(t.getState()+" 1");
        //System.out.println(t.getState()+" 2");

       synchronized (MONITOR) {
            MONITOR.notifyAll();
        }
        System.out.println(t.getState()+" 2");
        System.out.println(t.getState() + "3");
        t.join();
        System.out.println(t.getState());

    }
}
