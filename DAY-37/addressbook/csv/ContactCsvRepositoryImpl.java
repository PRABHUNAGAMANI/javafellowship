package addressbook.csv;

import addressbook.model.Contact;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ContactCsvRepositoryImpl implements ContactCsvRepository
{
    private static final String FILE_PATH = "DAY-37/addressbook/contacts.csv";

    @Override
    public void save(Contact contact)
    {
        try
        {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs();

            boolean isNewFile = !file.exists();

            try (FileWriter fw = new FileWriter(file, true))
            {
                if (isNewFile)
                {
                    fw.write("FirstName,LastName,Address,City,State,Zip,Phone\n");
                }

                fw.write(
                        contact.getFirstName() + "," +
                                contact.getLastName() + "," +
                                contact.getAddress() + "," +
                                contact.getCity() + "," +
                                contact.getState() + "," +
                                contact.getZip() + "," +
                                contact.getPhoneNumber() + "\n"
                );
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("FAILED TO SAVE CONTACT TO CSV", e);
        }
    }

    @Override
    public List<Contact> readAll()
    {
        List<Contact> contacts = new ArrayList<>();

        File file = new File(FILE_PATH);
        if (!file.exists())
            return contacts;

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(",");

                Contact c = new Contact();
                c.setFirstName(data[0]);
                c.setLastName(data[1]);
                c.setAddress(data[2]);
                c.setCity(data[3]);
                c.setState(data[4]);
                c.setZip(data[5]);
                c.setPhoneNumber(data[6]);

                contacts.add(c);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("FAILED TO READ CSV FILE", e);
        }

        return contacts;
    }
}

