package ua.nure.vasilchenko.practice1;

public class Part6 {

    public static void main(final String[] args) {
        if (args.length != 1) {
            usage();
            return;
        }
        int x = Integer.parseInt(args[0]);
        int[] prosto;
        prosto = zapolnenieProsto(x);
        for (int i = 0; i < prosto.length; i++) {
            System.out.print(prosto[i]);
            if (i < (prosto.length - 1)) {
                System.out.print(" ");
            }
        }
    }

    private static void usage() {
        System.out.println("Usage: java " + "ua.nure.vasilchenko.practice1.Part6 X");
    }

    private static int[] zapolnenieProsto(final int size) {
        int[] array = new int[size];
        array[0] = 2;
        int i = 1;
        int x = 3;
        boolean temp = true;
        while (array[size - 1] == 0) {
            for (int j = 2; j < x; j++) {
                if ((x % j) == 0) {
                    temp = false;
                    break;
                }
            }
            if (temp) {
                array[i] = x;
                i++;
            }
            temp = true;
            x++;
        }
        return array;
    }
}
