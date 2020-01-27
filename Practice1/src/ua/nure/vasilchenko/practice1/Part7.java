package ua.nure.vasilchenko.practice1;

public class Part7 {
    private static final String TEMP = " ==> ";
    private static final int NUMBERING64 = 64;
    private static final int NUMBERING26 = 26;

    public static void main(String[] args) {
        System.out.println("A" + TEMP + str2int("A") + TEMP + int2str(str2int("A")));
        System.out.println("B" + TEMP + str2int("B") + TEMP + int2str(str2int("B")));
        System.out.println("Z" + TEMP + str2int("Z") + TEMP + int2str(str2int("Z")));
        System.out.println("AA" + TEMP + str2int("AA") + TEMP + int2str(str2int("AA")));
        System.out.println("AZ" + TEMP + str2int("AZ") + TEMP + int2str(str2int("AZ")));
        System.out.println("BA" + TEMP + str2int("BA") + TEMP + int2str(str2int("BA")));
        System.out.println("ZZ" + TEMP + str2int("ZZ") + TEMP + int2str(str2int("ZZ")));
        System.out.println("AAA" + TEMP + str2int("AAA") + TEMP + int2str(str2int("AAA")));
    }

    private static int str2int(final String number) {
        int res = 0;
        for (int i = 0, j = number.length() - 1; i < number.length(); i++, j--) {
            res += (number.charAt(j) - NUMBERING64) * Math.pow(NUMBERING26, i);
        }
        return res;
    }

    private static String int2str(final int number) {
        StringBuilder chars = new StringBuilder();
        StringBuilder charsMirror = new StringBuilder();
        int modul;
        int divident = number;
        while (divident != 0) {
            modul = divident % NUMBERING26;
            if (modul == 0) {
                chars.append("Z");
                divident = (divident - 1) / NUMBERING26;
            } else {
                chars.append((char) (modul + NUMBERING64));
                divident = (divident - modul) / NUMBERING26;
            }
        }
        for (int i = 0; i < chars.length(); i++) {
            charsMirror.append(chars.charAt(chars.length() - i - 1));
        }
        return charsMirror.toString();
    }

    public static String rightColumn(final String number) {
        String chars;
        int num;
        num = str2int(number);
        num++;
        chars = int2str(num);
        return chars;
    }


}
