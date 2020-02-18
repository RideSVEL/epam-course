package ua.nure.vasilchenko.practice6.part3;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private List<Integer> parkingPlaces = new ArrayList<>();
    private int size;

    public Parking(int n) {
        this.size = n;
        for (int i = 0; i < n; i++) {
            parkingPlaces.add(0);
        }
    }

    boolean arrive(int index) {
        if (index > (size - 1)) {
            throw new IllegalArgumentException();
        }
        for (int i = index; i < parkingPlaces.size(); i++) {
            if (parkingPlaces.get(i) == 0) {
                parkingPlaces.set(i, 1);
                return true;
            }
        }
        for (int i = 0; i < index; i++) {
            if (parkingPlaces.get(i) == 0) {
                parkingPlaces.set(i, 1);
                return true;
            }
        }
        return false;
    }


    boolean depart(int index) {
        if (index > (size - 1)) {
            throw new IllegalArgumentException();
        }
        if (parkingPlaces.get(index) == 1) {
            parkingPlaces.set(index, 0);
            return true;
        }
        return false;
    }


     void print() {
        for (Integer i : parkingPlaces) {
            System.out.print(i);
        }
         System.out.println();
    }

}
