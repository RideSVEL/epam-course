package ua.nure.vasilchenko.practice5;

public class Part3 {
    private int counter;
    private int counter2;
    private int sleep;
    private int ciklNum;
    private Thread[] threads;

    public Part3(int threadsNum, int ciklNum, int sleep) {
        this.ciklNum = ciklNum;
        this.sleep = sleep;
        threads = new Thread[threadsNum];
    }

    public void reset() {
        counter = 0;
        counter2 = 0;
    }

    public void test() throws InterruptedException {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < ciklNum; j++) {
                    System.out.printf("%s %s%n", counter, counter2);
                    counter++;
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    counter2++;
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public void testSync() throws InterruptedException {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < ciklNum; j++) {
                    synchronized (this) {
                        System.out.printf("%s %s%n", counter, counter2);
                        counter++;
                        try {
                            Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        counter2++;
                    }
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Part3 p = new Part3(5, 5, 20);
        p.test();
        p.reset();
        p.testSync();
    }
}
