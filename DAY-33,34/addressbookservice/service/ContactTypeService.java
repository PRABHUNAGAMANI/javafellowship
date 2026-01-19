package addressbookservice.service;

import addressbookservice.model.ContactType;

import java.util.List;

public interface ContactTypeService
{
    void addContactType(ContactType type);
    List<ContactType> getAllContactTypes();
    void updateContactType(ContactType type);
    void deleteContactType(int typeId);

}
