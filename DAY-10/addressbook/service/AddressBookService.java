package addressbook.service;

import addressbook.model.ContactPerson;
import addressbook.repository.ContactRepository;

import java.util.List;

public class AddressBookService
{
    private final ContactRepository repository;

    public AddressBookService(ContactRepository repository) {
        this.repository = repository;
    }

    public void add(ContactPerson contact) {
        repository.add(contact);
    }

    public boolean delete(String firstName, String lastName) {
        return repository.delete(firstName, lastName);
    }

    public List<ContactPerson> getAll() {
        return repository.findAll();
    }
}
