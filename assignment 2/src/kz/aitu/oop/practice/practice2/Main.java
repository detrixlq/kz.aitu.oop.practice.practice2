package kz.aitu.oop.practice.practice2;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Train train = new Train();
        // Create passenger cars and add them to the train
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter the passenger car capacity: ");
            int capacity = sc.nextInt();
            train.addPassengerCar(new PassengerCar(i+1, capacity));
        }
        // Add passenger data entered by the user
        while (true) {
            System.out.println("Enter passenger name (Enter 'q' to quit): ");
            String name = sc.nextLine();
            if (name.equals("q")) {
                break;
            }
            System.out.println("Enter passenger ticket number: ");
            String ticketNumber = sc.nextLine();
            System.out.println("Enter passenger car number: ");
            int passengerCarNumber = sc.nextInt();
            Passenger passenger = new Passenger(train.totalPassengers, name, ticketNumber, new PassengerCar(passengerCarNumber, 0));
            train.addPassenger(passenger);
        }
        System.out.println("Total passenger count: " + train.totalPassengers);
    }
}
