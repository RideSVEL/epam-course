package ua.nure.vasilchenko.practice1;

public class Part4 {

    public static void main(final String[] args) {
        if (args.length != 2) {
            usage();
            return;
        }
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        long nods = gcd(x, y);
        System.out.println(nods);
    }

    private static void usage() {
        System.out.println("Usage: java " + "ua.nure.vasilchenko.practice1.Part4 X Y");
    }

    private static long gcd(final long a, final long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
