package ua.nure.vasilchenko.practice6;

import ua.nure.vasilchenko.practice6.part3.Part3;
import ua.nure.vasilchenko.practice6.part1.Part1;
import ua.nure.vasilchenko.practice6.part2.Part2;
import ua.nure.vasilchenko.practice6.part4.Part4;
import ua.nure.vasilchenko.practice6.part5.Part5;
import ua.nure.vasilchenko.practice6.part6.Part6;

public class Demo {

    public static void main(String[] args) {
        System.out.println("=== Part 1 ===");
        Part1.main(args);
        System.out.println("=== Part 2 ===");
        Part2.main(args);
        System.out.println("=== Part 3 ===");
        Part3.main(args);
        System.out.println("=== Part 4 ===");
        Part4.main(args);
        System.out.println("\n=== Part 5 ===");
        Part5.main(args);
        System.out.println("=== Part 6, frequency ===");
        Part6.main(new String[]{"--input","part6.txt" ,"-t" , "frequency"});
        System.out.println("=== Part 6, length ===");
        Part6.main(new String[]{"--input","part6.txt" ,"-t" , "length"});
        System.out.println("=== Part 6, duplicates ===");
        Part6.main(new String[]{"--input","part6.txt" ,"-t" , "duplicates"});
    }
}
