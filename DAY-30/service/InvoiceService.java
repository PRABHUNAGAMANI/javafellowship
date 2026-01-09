package service;

import model.InvoiceSummary;
import repository.RideRepository;

public class InvoiceService {

    private final RideRepository repository;
    private final InvoiceGenerator generator;

    public InvoiceService(RideRepository repository) {
        this.repository = repository;
        this.generator = new InvoiceGenerator();
    }

    public InvoiceSummary getInvoice(String userId) {
        return generator.calculateInvoice(repository.getRides(userId));
    }
}
