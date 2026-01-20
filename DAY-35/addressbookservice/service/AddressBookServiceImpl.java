package addressbookservice.service;

import addressbookservice.dao.AddressBookDAO;
import addressbookservice.model.AddressBook;

import java.util.List;

public class AddressBookServiceImpl implements AddressBookService
{
    private final AddressBookDAO dao;

    public AddressBookServiceImpl(AddressBookDAO dao) {
        this.dao = dao;
    }

    @Override
    public void addContact(AddressBook person) {
        dao.addPerson(person);
    }

    @Override
    public List<AddressBook> viewContacts() {
        return dao.getAllPersons();
    }

    @Override
    public void updateContact(AddressBook person) {
        dao.updatePerson(person);
    }

    @Override
    public void deleteContact(int id) {
        dao.deletePerson(id);
    }
}
