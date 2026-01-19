package addressbookservice.dao;

import addressbookservice.model.ContactType;

import java.util.List;

public interface ContactTypeDAO
{
    void addContactType(ContactType type);
    List<ContactType> getAllContactTypes();
    void updateContactType(ContactType type);
    void deleteContactType(int typeId);
}
