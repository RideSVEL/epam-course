package ua.nure.vasilchenko.practice5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class Util {

    private Util() {
        throw new IllegalStateException("Utility class");
    }

    public static String readFile(String path) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, "Cp1251");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return res;
    }



}
