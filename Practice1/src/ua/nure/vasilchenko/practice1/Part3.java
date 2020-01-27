package ua.nure.vasilchenko.practice1;

public class Part3 {

    public static void main(String[] args) {
        if (args.length == 0) {
            usage();
            return;
        }
        int count = args.length;
        for (int i = 0; i < count; i++) {
            System.out.print(args[i]);
            if (i != count - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private static void usage() {
        System.out.println("Enter at least one command line argument");
    }

}
