package addressbook.ui;

import addressbook.model.ContactPerson;
import addressbook.service.AddressBookService;

import java.util.Scanner;

public class AddressBookUI
{
    private final AddressBookService service;
    private final Scanner sc = new Scanner(System.in);

    public AddressBookUI(AddressBookService service) {
        this.service = service;
    }

    public void menu() {
        int choice;

        do {
            System.out.println("\n1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Delete Contact");
            System.out.println("4. Exit");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addContact();
                case 2 -> service.getAll().forEach(System.out::println);
                case 3 -> deleteContact();
            }
        } while (choice != 4);
    }

    private void addContact() {
        System.out.print("First Name: ");
        String fn = sc.nextLine();
        System.out.print("Last Name: ");
        String ln = sc.nextLine();
        System.out.print("City: ");
        String city = sc.nextLine();

        service.add(new ContactPerson(fn, ln, "", city, "", "", "", ""));
        System.out.println("Contact added!");
    }

    private void deleteContact() {
        System.out.print("First Name: ");
        String fn = sc.nextLine();
        System.out.print("Last Name: ");
        String ln = sc.nextLine();

        System.out.println(service.delete(fn, ln)
                ? "Deleted successfully"
                : "Contact not found");
    }
}
