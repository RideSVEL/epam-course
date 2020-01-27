package ua.nure.vasilchenko.practice3;


public class Part2 {
    public static void main(String[] args) {
        System.out.println(convert(Util.readFile("part2.txt")));

    }

    public static String convert(String input) {
        String[] masStr = input.split("[\\s,\\-.'!?]+");
        String min = masStr[0];
        String max = masStr[0];
        StringBuilder minSB = new StringBuilder();
        StringBuilder maxSB = new StringBuilder();
        for (int i = 1; i < masStr.length; ++i) {
            if (min.length() > masStr[i].length()) {
                min = masStr[i];
            } else if (max.length() < masStr[i].length()) {
                max = masStr[i];
            }
        }
        for (int i = 0; i < masStr.length; ++i) {
            if (min.length() == masStr[i].length()) {
                minSB.append(masStr[i]).append(" ");
            } else if (max.length() == masStr[i].length()) {
                maxSB.append(masStr[i]).append(" ");
            }
        }
        String[] temp = Util.checkOriginal(minSB.toString().split(" "));
        String[] temp2 = Util.checkOriginal(maxSB.toString().split(" "));
        StringBuilder result = new StringBuilder("Min: ");
        for (String s : temp) {
            result.append(s).append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("\n").append("Max: ");
        for (String s : temp2) {
            result.append(s).append(", ");
        }
        result.delete(result.length() - 2, result.length());
        return result.toString();
    }

}
