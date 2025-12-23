package addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook
{

    private ArrayList<ContactPerson> contacts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);


    public void addContactFromConsole()
    {

        System.out.print("ENTER FIRST NAME : ");
        String firstName = sc.nextLine();

        System.out.print("ENTER LAST NAME : ");
        String lastName = sc.nextLine();

        System.out.print("ENTER ADDRESS : ");
        String address = sc.nextLine();

        System.out.print("ENTER CITY : ");
        String city = sc.nextLine();

        System.out.print("ENTER STATE : ");
        String state = sc.nextLine();

        System.out.print("ENTER PINCODE : ");
        String zip = sc.nextLine();

        System.out.print("ENTER PHONE NUMBER : ");
        String phone = sc.nextLine();

        System.out.print("ENTER EMAIL ID : ");
        String email = sc.nextLine();

        ContactPerson newContact = new ContactPerson(firstName, lastName, address, city, state, zip, phone, email);

        contacts.add(newContact);
        System.out.println("Contact added successfully!");
    }

    public void displayContacts()
    {
        if (contacts.isEmpty()) {
            System.out.println("NO CONTACTS FOUND.");
            return;
        }

        System.out.println("CONTACT LIST");
        for (ContactPerson c : contacts) {
            System.out.println(c);
        }
        System.out.println();
    }

    public void editContact()
    {
        System.out.print("ENTER FIRST NAME TO EDIT : ");
        String firstName = sc.nextLine();

        System.out.print("ENTER LAST NAME TO EDIT : ");
        String lastName = sc.nextLine();

        for (ContactPerson c : contacts)
        {
            if (c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName))
            {

                System.out.println("EDITING CONTACT");

                System.out.print("NEW ADDRESS : ");
                c.setAddress(sc.nextLine());

                System.out.print("NEW CITY : ");
                c.setCity(sc.nextLine());

                System.out.print("NEW STATE : ");
                c.setState(sc.nextLine());

                System.out.print("NEW PINCODE : ");
                c.setZip(sc.nextLine());

                System.out.print("NEW PHONE NUMBER : ");
                c.setPhoneNumber(sc.nextLine());

                System.out.print("NEW EMAIL : ");
                c.setEmail(sc.nextLine());

                System.out.println("CONTACT UPDATED SUCCESSFULLY ");
                return;
            }
        }

        System.out.println("CONTACT NOT FOUND! ");
    }

    public void deleteContact()
    {
        System.out.print("ENTER FIRST NAME TO DELETE : ");
        String firstName = sc.nextLine();
        System.out.print("ENTER LAST NAME TO DELETE : ");
        String lastName = sc.nextLine();
        boolean removed = contacts.removeIf(c -> c.getFirstName().equalsIgnoreCase(firstName) &&
                                     c.getLastName().equalsIgnoreCase(lastName));

        if (removed)
        {
            System.out.println("CONTACT DELETED SUCCESSFULLY!");
        }
        else
        {
            System.out.println("CONTACT NOT FOUND!");
        }
    }

    public void viewPersonsByCity()
    {
        System.out.print("ENTER CITY : ");
        String city = sc.nextLine();
        System.out.println(" PERSONS IN CITY : " + city);
        contacts.stream()
                .filter(c -> c.getCity().equalsIgnoreCase(city))
                .forEach(System.out::println);
        System.out.println();
    }

    public void viewPersonsByState()
    {
        System.out.print("ENTER STATE : ");
        String state = sc.nextLine();
        System.out.println("PERSONS IN STATE : "+state);
        contacts.stream()
                .filter(c -> c.getState().equalsIgnoreCase(state))
                .forEach(System.out::println);
        System.out.println();
    }

    public void countContactsByCity()
    {
        System.out.print("ENTER CITY : ");
        String city = sc.nextLine();
        long count = contacts.stream()
                .filter(c -> c.getCity().equalsIgnoreCase(city))
                .count();
        System.out.println("NUMBER OF CONTACTS IN CITY '" + city + "' : " + count);
    }

    public void countContactsByState()
    {
        System.out.print("ENTER STATE : ");
        String state = sc.nextLine();
        long count = contacts.stream()
                .filter(c -> c.getState().equalsIgnoreCase(state))
                .count();
        System.out.println("NUMBER OF CONTACT IN STATE '" + state + "' : " + count);
    }


    public void menu()
    {
        int choice;

        do {
            System.out.println("ADDRESS BOOK SYSTEM");
            System.out.println("--------------------");
            System.out.println("1. ADD CONTACT");
            System.out.println("2. DISPLAY CONTACTS");
            System.out.println("3. EDIT CONTACT");
            System.out.println("4. DELETE CONTACT");
            System.out.println("5. EXIT");
            System.out.println("6. VIEW PERSONS BY CITY");
            System.out.println("7. VIEW PERSONS BY STATE");
            System.out.println("8. COUNT PERSONS BY STATE");
            System.out.println("9. COUNT PERSONS BY STATE");
            System.out.print("ENTER YOUR CHOICE : ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addContactFromConsole();
                    break;

                case 2:
                    displayContacts();
                    break;

                case 3:
                    editContact();
                    break;

                case 4:
                    deleteContact();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;
                case 6:
                    viewPersonsByCity();
                    break;
                case 7:
                    viewPersonsByState();
                    break;
                case 8:
                    countContactsByCity();
                    break;
                case 9:
                    countContactsByState();
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 7);
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.menu();
    }
}
