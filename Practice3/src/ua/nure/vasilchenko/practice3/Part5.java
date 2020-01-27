package ua.nure.vasilchenko.practice3;

import java.util.Locale;

public class Part5 {
    public static final int THOUSAND = 1000;
    public static final int NINE_HUNDRED = 900;
    public static final int FIVE_HUNDRED = 500;
    public static final int FOUR_HUNDRED = 400;
    public static final int HUNDRED = 100;
    public static final int NINETY = 90;
    public static final int FIFTY = 50;
    public static final int FORTY = 40;
    public static final int TEN = 10;
    public static final int NINE = 9;
    public static final int FIVE = 5;
    public static final int FOUR = 4;
    public static final int ONE = 1;

    private static String[] romanSimbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X"
            , "IX", "V", "IV", "I"};
    private static int[] arabicSimbols = {THOUSAND, NINE_HUNDRED, FIVE_HUNDRED, FOUR_HUNDRED
            , HUNDRED, NINETY, FIFTY, FORTY, TEN, NINE, FIVE, FOUR, ONE};

    public static int roman2Decimal(String romanNumber) {
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase(Locale.ENGLISH);
        for (int x = romanNumeral.length() - 1; x >= 0; x--) {
            char convertToDecimal = romanNumeral.charAt(x);
            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(THOUSAND, lastNumber, decimal);
                    lastNumber = THOUSAND;
                    break;
                case 'D':
                    decimal = processDecimal(FIVE_HUNDRED, lastNumber, decimal);
                    lastNumber = FIVE_HUNDRED;
                    break;
                case 'C':
                    decimal = processDecimal(HUNDRED, lastNumber, decimal);
                    lastNumber = HUNDRED;
                    break;
                case 'L':
                    decimal = processDecimal(FIFTY, lastNumber, decimal);
                    lastNumber = FIFTY;
                    break;
                case 'X':
                    decimal = processDecimal(TEN, lastNumber, decimal);
                    lastNumber = TEN;
                    break;
                case 'V':
                    decimal = processDecimal(FIVE, lastNumber, decimal);
                    lastNumber = FIVE;
                    break;
                case 'I':
                    decimal = processDecimal(ONE, lastNumber, decimal);
                    lastNumber = ONE;
                    break;
                default:
                    break;
            }
        }
        return decimal;
    }

    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= HUNDRED; i++) {
            System.out.println(i + " --> " + decimal2Roman(i) + " --> " + roman2Decimal(decimal2Roman(i)));
        }
    }

    public static String decimal2Roman(int aNumber) {
        StringBuilder numeric = new StringBuilder();
        int bitDepth;
        int index = 0;
        while (index < arabicSimbols.length) {
            bitDepth = aNumber / arabicSimbols[index];
            for (int i = 0; i < bitDepth; i++) {
                numeric.append(romanSimbols[index]);
            }
            aNumber -= bitDepth * arabicSimbols[index];
            index++;
        }
        return numeric.toString();
    }
}
