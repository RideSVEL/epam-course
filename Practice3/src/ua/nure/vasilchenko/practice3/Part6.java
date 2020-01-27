package ua.nure.vasilchenko.practice3;

public class Part6 {
    public static void main(String[] args) {
        System.out.println(convert(Util.readFile("part6.txt")));
    }

    public static String convert(String input) {
        String[] strings = input.split("\r?\n");
        int[] indexes = new int[strings.length];
        String[][] words = new String[strings.length][];
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            words[i] = strings[i].split(" ");
            count += words[i].length;
        }
        String [] temp = new String[count];
        count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length; j++) {
                temp[count++] = words[i][j];
            }
            indexes[i] = count - 1;
        }
        for (int i = 0; i < temp.length; i++) {
            boolean repeat = false;
            for (int j = i; j < temp.length - 1; j++) {
                if ((temp[i].charAt(0) != '_') && (temp[i].equals(temp[j + 1]))) {
                        repeat = true;
                        StringBuilder buff = new StringBuilder();
                        buff.append("_").append(temp[j + 1]);
                        temp[j + 1] = buff.toString();
                }
            }
            if (repeat) {
                StringBuilder buff = new StringBuilder();
                buff.append("_").append(temp[i]);
                temp[i] = buff.toString();
            }
        }
       StringBuilder sb = new StringBuilder();
        count = 0;
        for (int i = 0; i < temp.length; i++) {
            sb.append(temp[i]);
            if (i == indexes[count]) {
                sb.append("\n");
                count++;
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
