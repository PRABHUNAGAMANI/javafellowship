package service;

import model.InvoiceSummary;
import model.Ride;

public class InvoiceGenerator {

    public double calculateFare(Ride ride) {
        double fare = ride.distance * ride.rideType.costPerKm
                + ride.time * ride.rideType.costPerMinute;
        return Math.max(fare, ride.rideType.minimumFare);
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride);
        }
        return totalFare;
    }

    public InvoiceSummary calculateInvoice(Ride[] rides) {
        double totalFare = calculateFare(rides);
        return new InvoiceSummary(rides.length, totalFare);
    }
}
