package kz.aitu.oop.practice.practice2;

import java.util.ArrayList;
import java.sql.*;

class Vehicle {
    int wheels;
    int weight;

    public Vehicle(int wheels, int weight) {
        this.wheels = wheels;
        this.weight = weight;
    }
}

class Locomotive extends Vehicle {
    int horsepower;
    String fuelType;

    public Locomotive(int wheels, int weight, int horsepower, String fuelType) {
        super(wheels, weight);
        this.horsepower = horsepower;
        this.fuelType = fuelType;
    }
}

class PassengerCar {
    int id;
    int capacity;
    int passengers;

    public PassengerCar(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.passengers = 0;
    }

    public void addPassenger(Passenger passenger) {
        if (passengers < capacity) {
            passengers++;
            passenger.passengerCar = this;
        } else {
            System.out.println("Passenger car is full!");
        }
    }
}

class Train {
    ArrayList<PassengerCar> cars;
    int totalCapacity;
    int totalPassengers;

    public Train() {
        cars = new ArrayList<PassengerCar>();
        totalCapacity = 0;
        totalPassengers = 0;
    }

    public void addPassengerCar(PassengerCar car) {
        cars.add(car);
        totalCapacity += car.capacity;
    }

    public void addPassenger(Passenger passenger) {
        for (PassengerCar car : cars) {
            if (car.id == passenger.passengerCar.id) {
                car.addPassenger(passenger);
                totalPassengers++;
                break;
            }
        }
    }
}
class Passenger {
        int id;
        String name;
        String ticketNumber;
        PassengerCar passengerCar;

public Passenger(int id, String name, String ticketNumber, PassengerCar passengerCar) {
        this.id = id;
        this.name = name;
        this.ticketNumber = ticketNumber;
        this.passengerCar = passengerCar;
        }
        }
class Database {
    Connection conn;

    public Database(String hostname, int port, String dbname, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://"+hostname+":"+port+"/"+dbname, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




//    public ArrayList<Passenger> getPassengers() {
//        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM passengers");
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                passengers.add(new Passenger(id, name, age));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return passengers;
//    }

//    public void addPassengerToCar(Passenger passenger, PassengerCar car) {
//        if (car.passengers < car.capacity) {
//            car.passengers++;
//            try {
//                PreparedStatement stmt = conn.prepareStatement("INSERT INTO passengers_on_train (passenger_id, car_id) VALUES (?, ?)");
//                stmt.setInt(1, passenger.id);
//                stmt.setInt(2, car.id);
//                stmt.executeUpdate();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("kz.aitu.oop.practice.practice2.Passenger car is full!");
//        }
//    }



