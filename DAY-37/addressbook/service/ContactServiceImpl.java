package addressbook.service;

import addressbook.csv.ContactCsvRepository;
import addressbook.csv.ContactCsvRepositoryImpl;
import addressbook.dao.ContactDAO;
import addressbook.dao.ContactDAOImpl;
import addressbook.json.ContactJsonRepository;
import addressbook.json.ContactJsonRepositoryImpl;
import addressbook.model.Contact;

public class ContactServiceImpl implements ContactService
{
    private final ContactDAO contactDao=new ContactDAOImpl();
    private final ContactJsonRepository jsonRepo = new ContactJsonRepositoryImpl();
    private final ContactCsvRepository csvRepo = new ContactCsvRepositoryImpl();

    @Override
    public void addContact(Contact contact)
    {
        if(contact.getPhoneNumber().length() !=10)
        {
            throw new RuntimeException("INVALID PHONE NUMBER ");
        }
        contactDao.insertOperation(contact);
        System.out.println("CONTACT ADDED SUCCESSFULLY");
    }

    @Override
    public void viewContact()
    {
        contactDao.fetchOperation();
    }

    @Override
    public void updateContact(int id, Contact contact)
    {
        contactDao.updateOperation(id,contact);
    }

    @Override
    public void deleteContact(int id)
    {
        contactDao.deleteOperation(id);
    }

    @Override
    public void sortContactsByNameAsc()
    {
        contactDao.sortByNameAsc();
    }

    @Override
    public void sortContactsByNameDesc()
    {
        contactDao.sortByNameDsc();
    }

    @Override
    public void viewContactsByState(String state) {
        contactDao.viewByState(state);
    }

    @Override
    public void addContactToFile(Contact contact)
    {
        if (contact.getPhoneNumber().length() != 10)
        {
            throw new RuntimeException("INVALID PHONE NUMBER");
        }

        contactDao.insertOperation(contact); // DB SAVE
        jsonRepo.save(contact);              // JSON AUTO SAVE
        csvRepo.save(contact);

        System.out.println("CONTACT SAVED TO DB AND JSON");
    }
}
