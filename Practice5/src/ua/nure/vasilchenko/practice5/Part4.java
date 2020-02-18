package ua.nure.vasilchenko.practice5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Part4 {

    private int[][] numbers;

    public Part4() {
        String[] lines = (Util.readFile("part4.txt")).split("\r?\n");
        String[][] mass = new String[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            mass[i] = lines[i].split(" ");
        }
        numbers = new int[mass.length][mass[0].length];
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                numbers[i][j] = Integer.parseInt(mass[i][j]);
            }
        }
    }

    private int getMaxWithoutParallelization() throws InterruptedException {
        int max = numbers[0][0];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                Thread.sleep(1);
                max = Math.max(max, numbers[i][j]);
            }
        }
        return max;
    }

    private int getMaxWithParallelization() throws InterruptedException, ExecutionException {
        ExecutorService exc = Executors.newFixedThreadPool(numbers.length);
        Future<Integer>[] futures = new Future[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            futures[i] = exc.submit(new Find(numbers[i]));
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            max = Math.max(max, futures[i].get());
        }
        exc.shutdown();
        return max;
    }

    static class Find implements Callable<Integer> {
        private int[] column;

        public Find(int[] column) {
            this.column = column;
        }

        @Override
        public Integer call() throws InterruptedException {
            int max = column[0];
            final int[] arr = column;
            for (int i = 1; i < arr.length; i++) {
                Thread.sleep(1);
                max = Math.max(max, arr[i]);
            }
            return max;
        }

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Part4 part4 = new Part4();
        long start = System.currentTimeMillis();
        System.out.println(part4.getMaxWithParallelization());
        long end = System.currentTimeMillis();
        System.out.println((end - start));
        start = System.currentTimeMillis();
        System.out.println(part4.getMaxWithoutParallelization());
        end = System.currentTimeMillis();
        System.out.println((end - start));

    }
}