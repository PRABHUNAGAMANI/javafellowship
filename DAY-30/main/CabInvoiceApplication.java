package main;

import model.*;
import repository.RideRepository;
import service.InvoiceGenerator;
import service.InvoiceService;

import java.util.*;

public class CabInvoiceApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InvoiceGenerator generator = new InvoiceGenerator();
        RideRepository repository = new RideRepository();

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter number of rides: ");
        int numberOfRides = scanner.nextInt();

        List<Ride> rideList = new ArrayList<>();

        for (int i = 1; i <= numberOfRides; i++) {

            System.out.println("\nRide " + i);

            System.out.print("Enter ride type (NORMAL / PREMIUM): ");
            RideType rideType = RideType.valueOf(scanner.next().toUpperCase());

            System.out.print("Enter distance (km): ");
            double distance = scanner.nextDouble();

            System.out.print("Enter time (minutes): ");
            int time = scanner.nextInt();

            Ride ride = new Ride(distance, time, rideType);
            rideList.add(ride);

            double fare = generator.calculateFare(ride);
            System.out.println("Fare for this ride: " + fare);
        }

        repository.addRides(userId, rideList);

        InvoiceService service = new InvoiceService(repository);
        InvoiceSummary summary = service.getInvoice(userId);

        System.out.println("\n----- INVOICE SUMMARY -----");
        System.out.println("Total Rides: " + summary.totalRides);
        System.out.println("Total Fare: " + summary.totalFare);
        System.out.println("Average Fare: " + summary.averageFare);

        repository.addRides(userId, rideList);

        scanner.close();
    }
}
