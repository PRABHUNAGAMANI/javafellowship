package addressbookservice.service;

import addressbookservice.model.AddressBook;

import java.util.List;

public interface AddressBookService
{
    void addContact(AddressBook person);
    List<AddressBook> viewContacts();
    void updateContact(AddressBook person);
    void deleteContact(int id);
}
