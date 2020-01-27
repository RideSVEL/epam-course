package ua.nure.vasilchenko.practice1;

public class Part5 {

    private static void usage() {
        System.out.println("Usage: java " + "ua.nure.vasilchenko.practice1.Part4 X");
    }

    public static void main(final String[] args) {
        if (args.length != 1) {
            usage();
            return;
        }
        int sum = 0;
        int x = Integer.parseInt(args[0]);
        while (x != 0) {
            sum += (x % 10);
            x /= 10;
        }
        System.out.println(sum);
    }
}
