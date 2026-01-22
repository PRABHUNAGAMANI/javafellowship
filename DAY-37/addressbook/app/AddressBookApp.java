package addressbook.app;

import addressbook.csv.CsvViewer;
import addressbook.db.DBInitializer;
import addressbook.json.JsonViewer;
import addressbook.model.Contact;
import addressbook.service.ContactService;
import addressbook.service.ContactServiceImpl;

import java.util.Scanner;

public class AddressBookApp
{
    public static void main(String[] args)
    {
        DBInitializer.initialize();

        ContactService service = new ContactServiceImpl();
        Scanner scan = new Scanner(System.in);

        while (true)
        {
            System.out.println(" ADDRESS BOOK");
            System.out.println("-------------------------------------");
            System.out.println("1. ADD CONTACT");
            System.out.println("2. VIEW CONTACTS");
            System.out.println("3. UPDATE CONTACTS");
            System.out.println("4. DELETE CONTACT");
            System.out.println("5. SORT CONTACT BY NAME IN ASCENDING");
            System.out.println("6. SORT CONTACT BY NAME IN DESCENDING");
            System.out.println("7. VIEW CONTACTS BY STATE");
            System.out.println("8. VIEW RECORDS FROM JSON FILE");
            System.out.println("9. VIEW RECORDS FROM CSV FILE");
            System.out.println("10. EXIT");

            int choice = scan.nextInt();
            scan.nextLine();

            switch(choice)
            {
                case 1 ->
                {
                    Contact c=new Contact();
                    System.out.println("FIRST NAME : ");
                    c.setFirstName(scan.nextLine());

                    System.out.println("LAST NAME : ");
                    c.setLastName(scan.nextLine());

                    System.out.println("ADDRESS : ");
                    c.setAddress(scan.nextLine());

                    System.out.println("CITY : ");
                    c.setCity(scan.nextLine());

                    System.out.println("STATE : ");
                    c.setState(scan.nextLine());

                    System.out.println("ZIP : ");
                    c.setZip(scan.nextLine());

                    System.out.println("PHONE NUMBER : ");
                    c.setPhoneNumber(scan.nextLine());

                   // service.addContact(c);
                    service.addContactToFile(c);
                    break;
                }
                case 2 ->
                {
                    service.viewContact();
                    break;
                }
                case 3 ->
                {
                    System.out.println("ENTER ID TO UPDATE");
                    System.out.println("-------------------------");
                    int id=scan.nextInt();
                    scan.nextLine();

                    Contact c=new Contact();

                    System.out.print("First Name: ");
                    c.setFirstName(scan.nextLine());

                    System.out.print("Last Name: ");
                    c.setLastName(scan.nextLine());

                    System.out.print("Address: ");
                    c.setAddress(scan.nextLine());

                    System.out.print("City: ");
                    c.setCity(scan.nextLine());

                    System.out.print("State: ");
                    c.setState(scan.nextLine());

                    System.out.print("Zip: ");
                    c.setZip(scan.nextLine());

                    System.out.print("Phone Number: ");
                    c.setPhoneNumber(scan.nextLine());

                    service.updateContact(id,c);
                    break;
                }
                case 4 ->
                {
                    System.out.println("ENTER THE ID TO DELETE");
                    System.out.println("---------------------------");
                    int id=scan.nextInt();
                    scan.nextLine();

                    service.deleteContact(id);
                    break;
                }
                case 5 ->
                {
                    service.sortContactsByNameAsc();
                    break;
                }
                case 6 ->
                {
                    service.sortContactsByNameDesc();
                    break;
                }
                case 7 ->
                {
                    System.out.print("ENTER STATE: ");
                    String state = scan.nextLine();
                    service.viewContactsByState(state);
                    break;
                }
                case 8 ->
                {
                    System.out.println("RECORDS FROM JSON FILE");
                    System.out.println("----------------------");
                    JsonViewer.view();
                    break;
                }
                case 9 ->
                {
                    System.out.println("RECORDS FROM CSV FILE");
                    System.out.println("---------------------");
                    CsvViewer.view();
                    break;
                }
                case 10 ->
                {
                    System.exit(0);
                }
            }
        }
    }
}

