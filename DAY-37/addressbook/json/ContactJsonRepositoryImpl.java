package addressbook.json;

import addressbook.model.Contact;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ContactJsonRepositoryImpl implements ContactJsonRepository
{
    private static final String FILE_PATH = "DAY-37/addressbook/contact.json";
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void save(Contact contact)
    {
        try
        {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs(); // IMPORTANT
            List<Contact> contacts = readAll();
            contacts.add(contact);
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(FILE_PATH), contacts);
        }
        catch (Exception e)
        {
            throw new RuntimeException("FAILED TO SAVE CONTACT TO JSON", e);
        }
    }

    @Override
    public List<Contact> readAll()
    {
        try
        {
            File file = new File(FILE_PATH);
            if (!file.exists())
                return new ArrayList<>();

            return mapper.readValue(
                    file,
                    new TypeReference<List<Contact>>() {}
            );
        }
        catch (Exception e)
        {
            throw new RuntimeException("FAILED TO READ JSON FILE", e);
        }
    }
}
