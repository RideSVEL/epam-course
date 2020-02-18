package ua.nure.vasilchenko.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

    public static long removeByIndex(List<Integer> list, int k) {
        long start = System.currentTimeMillis();
        int position = 0;
        while (list.size() != 1) {
            position += k - 1;
            position %= list.size();
            list.remove(position);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long removeByIterator(List<Integer> list, int k) {
        long start = System.currentTimeMillis();
        Iterator<Integer> it = list.iterator();
        while (list.size() != 1) {
            for (int i = 0; i < k; i++) {
                if (!it.hasNext()) {
                    it = list.iterator();
                }
                it.next();
            }
            it.remove();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static void init(List<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        init(arrayList, 10000);
        init(linkedList, 10000);
        System.out.println("ArrayList#Index: " + removeByIndex(arrayList, 4) + " ms");
        System.out.println("LinkedList#Index: " + removeByIndex(linkedList, 4) + " ms");
        init(arrayList, 10000);
        init(linkedList, 10000);
        System.out.println("ArrayList#Iterator: " + removeByIterator(arrayList, 4) + " ms");
        System.out.println("LinkedList#Iterator: " + removeByIterator(linkedList, 4) + " ms");
    }
}
