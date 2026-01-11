package addressbook.repository;

import addressbook.model.ContactPerson;

import java.util.ArrayList;
import java.util.List;

public class InMemoryContactRepository implements ContactRepository
{
    private final List<ContactPerson> contacts = new ArrayList<>();

    @Override
    public void add(ContactPerson contact) {
        contacts.add(contact);
    }

    @Override
    public boolean update(ContactPerson updated) {
        for (ContactPerson c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(updated.getFirstName())
                    && c.getLastName().equalsIgnoreCase(updated.getLastName())) {

                c.setAddress(updated.toString());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String firstName, String lastName) {
        return contacts.removeIf(c ->
                c.getFirstName().equalsIgnoreCase(firstName)
                        && c.getLastName().equalsIgnoreCase(lastName));
    }

    @Override
    public List<ContactPerson> findAll() {
        return contacts;
    }
}
