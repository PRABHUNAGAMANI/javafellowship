package addressbookservice.service;

import addressbookservice.dao.ContactTypeDAO;
import addressbookservice.model.ContactType;

import java.util.List;

public class ContactTypeServiceImpl implements ContactTypeService {

    private final ContactTypeDAO dao;

    public ContactTypeServiceImpl(ContactTypeDAO dao) {
        this.dao = dao;
    }

    @Override
    public void addContactType(ContactType type) {
        dao.addContactType(type);
    }

    @Override
    public List<ContactType> getAllContactTypes() {
        return dao.getAllContactTypes();
    }

    @Override
    public void updateContactType(ContactType type) {
        dao.updateContactType(type);
    }

    @Override
    public void deleteContactType(int typeId) {
        dao.deleteContactType(typeId);
    }
}
