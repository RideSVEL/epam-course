package ua.nure.vasilchenko.practice1;

public class Part2 {

    public static void main(final String[] args) {
        int x = 0;
        for (String arg : args) {
            x += Integer.parseInt(arg);
        }
        System.out.print(x);
    }

}
