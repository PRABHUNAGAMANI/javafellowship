package test;

import model.*;
import org.junit.Test;
import repository.RideRepository;
import service.InvoiceGenerator;
import service.InvoiceService;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class InvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTimeShouldReturnFare() {
        InvoiceGenerator generator = new InvoiceGenerator();
        Ride ride = new Ride(2.0, 5, RideType.NORMAL);

        double fare = generator.calculateFare(ride);

        assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        InvoiceGenerator generator = new InvoiceGenerator();
        Ride[] rides = {
                new Ride(2.0, 5, RideType.NORMAL),
                new Ride(1.0, 3, RideType.NORMAL)
        };

        double totalFare = generator.calculateFare(rides);

        assertEquals(38, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenerator generator = new InvoiceGenerator();
        Ride[] rides = {
                new Ride(2.0, 5, RideType.NORMAL),
                new Ride(1.0, 3, RideType.NORMAL)
        };

        InvoiceSummary summary = generator.calculateInvoice(rides);

        assertEquals(2, summary.totalRides);
        assertEquals(38, summary.totalFare, 0.0);
        assertEquals(19, summary.averageFare, 0.0);
    }

    @Test
    public void givenUserId_ShouldReturnInvoice() {
        RideRepository repo = new RideRepository();
        InvoiceService service = new InvoiceService(repo);

        repo.addRides("user1", Arrays.asList(
                new Ride(2.0, 5, RideType.NORMAL),
                new Ride(1.0, 3, RideType.NORMAL)
        ));

        InvoiceSummary summary = service.getInvoice("user1");

        assertEquals(2, summary.totalRides);
        assertEquals(38, summary.totalFare, 0.0);
    }

    @Test
    public void givenPremiumRide_ShouldCalculatePremiumFare() {
        InvoiceGenerator generator = new InvoiceGenerator();
        Ride ride = new Ride(2.0, 5, RideType.PREMIUM);

        double fare = generator.calculateFare(ride);

        assertEquals(40, fare, 0.0);
    }
}
