package ua.nure.vasilchenko.practice5;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Part5 {

    public static final String PATH_OUTPUT = "part5.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File(PATH_OUTPUT);

        Files.deleteIfExists(Paths.get(PATH_OUTPUT));
        file.createNewFile();
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            Thread[] threads = new Thread[10];
            for (int i = 0; i < threads.length; ++i) {
                threads[i] = new Writer(i, raf);
            }
            for (int i = 0; i < threads.length; i++) {
                threads[i].start();
            }
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        }
        Scanner in = new Scanner(new File(PATH_OUTPUT), "UTF-8");
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
        in.close();
    }
}




