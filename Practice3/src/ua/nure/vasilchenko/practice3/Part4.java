package ua.nure.vasilchenko.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class Part4 {
    public static final int NUMBER_SEVEN = 7;
    public static final int NUMBER_EIGHT = 8;

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            StringBuilder temp = new StringBuilder();
            temp.append(Integer.toHexString(b));
            if (temp.length() == 8) {
                int length = Integer.toHexString((b * (-1))).length();
                if ("MD5".equals(algorithm)) {
                    temp.delete(0, NUMBER_EIGHT - length);
                } else {
                    if (length == 1) {
                        temp.delete(0, NUMBER_SEVEN - length);
                    } else {
                        temp.delete(0, NUMBER_EIGHT - length);
                    }
                }
            } else if (temp.length() == 1) {
                temp.append("0");
                temp.reverse();
            }
            sb.append(temp);
        }

        return sb.toString().toUpperCase(Locale.ENGLISH);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("asdf", "MD5"));
        System.out.println(hash("asdf", "SHA-256"));
    }
}
