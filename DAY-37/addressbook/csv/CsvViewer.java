package addressbook.csv;

import addressbook.model.Contact;

import java.util.List;

public class CsvViewer
{
    public static void view()
    {
        ContactCsvRepository repo = new ContactCsvRepositoryImpl();
        List<Contact> contacts = repo.readAll();

        if (contacts.isEmpty())
        {
            System.out.println("NO CONTACTS IN CSV FILE");
            return;
        }

        System.out.println("FIRST NAME | LAST NAME | ADDRESS | CITY | STATE | PINCODE | PHONE");
        System.out.println("----------------------------------------------------------------------");

        for (Contact c : contacts)
        {
            System.out.println(
                    c.getFirstName() + " | " +
                            c.getLastName() + " | " +
                            c.getAddress() + " | " +
                            c.getCity() + " | " +
                            c.getState() + " | " +
                            c.getZip() + " | " +
                            c.getPhoneNumber()
            );
        }
    }
}
