package addressbookservice.dao;

import addressbookservice.model.AddressBook;

import java.util.List;

public interface AddressBookDAO
{
    void addPerson(AddressBook person);
    List<AddressBook> getAllPersons();
    void updatePerson(AddressBook person);
    void deletePerson(int id);
}
