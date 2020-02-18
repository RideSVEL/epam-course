package ua.nure.vasilchenko.practice6.part3;

public class Part3 {
    public static void main(String[] args) {
        Parking parking = new Parking(4);
        System.out.println(parking.arrive(2));
        System.out.println(parking.arrive(3));
        System.out.println(parking.arrive(2));
        System.out.println(parking.arrive(2));
        System.out.println(parking.arrive(2));
        System.out.println(parking.depart(1));
        System.out.println(parking.depart(1));
        parking.print();
    }

}
