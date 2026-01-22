package addressbook.json;

import addressbook.model.Contact;

import java.util.List;

public interface ContactJsonRepository
{
    void save(Contact contact);
    List<Contact> readAll();
}
