package addressbook.csv;

import addressbook.model.Contact;

import java.util.List;

public interface ContactCsvRepository
{
    public void save(Contact contact);
    public List<Contact> readAll();
}
