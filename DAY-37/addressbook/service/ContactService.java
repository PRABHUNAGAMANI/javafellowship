package addressbook.service;

import addressbook.model.Contact;

public interface ContactService
{
    public void addContact(Contact contact);
    public void viewContact();
    public void updateContact(int id, Contact contact);
    public void deleteContact(int id);
    public void sortContactsByNameAsc();
    public void sortContactsByNameDesc();
    public void viewContactsByState(String state);
    public void addContactToFile(Contact contact);
}
