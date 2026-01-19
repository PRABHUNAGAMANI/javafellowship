package addressbookservice.main;

import addressbookservice.dao.*;
import addressbookservice.model.*;
import addressbookservice.service.*;

import java.util.Scanner;

public class AddressBookApp
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        AddressBookService addressService =
                new AddressBookServiceImpl(new AddressBookDAOImpl());

        ContactTypeService contactTypeService =
                new ContactTypeServiceImpl(new ContactTypeDAOImpl());

        PersonTypeService personTypeService =
                new PersonTypeServiceImpl(new PersonTypeDAOImpl());

        int mainChoice;

        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1.Address Book");
            System.out.println("2.Contact Type");
            System.out.println("3.Person Type");
            System.out.println("4.Exit");
            System.out.print("Choose option: ");

            mainChoice = sc.nextInt();

            switch (mainChoice)
            {
                /* ================= ADDRESS BOOK ================= */
                case 1 -> {
                    int abChoice;
                    do {
                        System.out.println("\n--- Address Book Menu ---");
                        System.out.println("1.Add Contact");
                        System.out.println("2.View Contacts");
                        System.out.println("3.Update Contact");
                        System.out.println("4.Delete Contact");
                        System.out.println("5.Back");
                        System.out.print("Choose option: ");

                        abChoice = sc.nextInt();

                        switch (abChoice)
                        {
                            case 1 -> {
                                AddressBook p = new AddressBook();
                                sc.nextLine();

                                System.out.print("First Name: ");
                                p.setFirstName(sc.nextLine());

                                System.out.print("Last Name: ");
                                p.setLastName(sc.nextLine());

                                System.out.print("City: ");
                                p.setCity(sc.nextLine());

                                System.out.print("State: ");
                                p.setState(sc.nextLine());

                                System.out.print("Phone: ");
                                p.setPhone(sc.nextLine());

                                System.out.print("Email: ");
                                p.setEmail(sc.nextLine());

                                addressService.addContact(p);
                                System.out.println("Contact Added");
                            }

                            case 2 ->
                                    addressService.viewContacts()
                                            .forEach(System.out::println);

                            case 3 -> {
                                AddressBook p = new AddressBook();

                                System.out.print("ID: ");
                                p.setId(sc.nextInt());
                                sc.nextLine();

                                System.out.print("New First Name: ");
                                p.setFirstName(sc.nextLine());

                                System.out.print("New Last Name: ");
                                p.setLastName(sc.nextLine());

                                System.out.print("City: ");
                                p.setCity(sc.nextLine());

                                System.out.print("State: ");
                                p.setState(sc.nextLine());

                                addressService.updateContact(p);
                                System.out.println("Contact Updated");
                            }

                            case 4 -> {
                                System.out.print("ID: ");
                                addressService.deleteContact(sc.nextInt());
                                System.out.println("Contact Deleted");
                            }
                        }
                    } while (abChoice != 5);
                }

                /* ================= CONTACT TYPE ================= */
                case 2 -> {
                    int ctChoice;
                    do {
                        System.out.println("\n--- Contact Type Menu ---");
                        System.out.println("1.Add Type");
                        System.out.println("2.View Types");
                        System.out.println("3.Update Type");
                        System.out.println("4.Delete Type");
                        System.out.println("5.Back");
                        System.out.print("Choose option: ");

                        ctChoice = sc.nextInt();

                        switch (ctChoice)
                        {
                            case 1 -> {
                                ContactType ct = new ContactType();
                                sc.nextLine();

                                System.out.print("Type Name: ");
                                ct.setTypeName(sc.nextLine());

                                contactTypeService.addContactType(ct);
                                System.out.println("Type Added");
                            }

                            case 2 ->
                                    contactTypeService.getAllContactTypes()
                                            .forEach(System.out::println);

                            case 3 -> {
                                ContactType ct = new ContactType();

                                System.out.print("Type ID: ");
                                ct.setTypeId(sc.nextInt());
                                sc.nextLine();

                                System.out.print("New Type Name: ");
                                ct.setTypeName(sc.nextLine());

                                contactTypeService.updateContactType(ct);
                                System.out.println("Type Updated");
                            }

                            case 4 -> {
                                System.out.print("Type ID: ");
                                contactTypeService.deleteContactType(sc.nextInt());
                                System.out.println("Type Deleted");
                            }
                        }
                    } while (ctChoice != 5);
                }

                /* ================= PERSON TYPE ================= */
                case 3 -> {
                    int ptChoice;
                    do {
                        System.out.println("\n--- Person Type Menu ---");
                        System.out.println("1.Assign Type");
                        System.out.println("2.View Mappings");
                        System.out.println("3.Update Mapping");
                        System.out.println("4.Delete Mapping");
                        System.out.println("5.Back");
                        System.out.print("Choose option: ");

                        ptChoice = sc.nextInt();

                        switch (ptChoice)
                        {
                            case 1 -> {
                                PersonType pt = new PersonType();

                                System.out.print("Person ID: ");
                                pt.setPersonId(sc.nextInt());

                                System.out.print("Type ID: ");
                                pt.setTypeId(sc.nextInt());

                                personTypeService.assignType(pt);
                                System.out.println("Type Assigned");
                            }

                            case 2 ->
                                    personTypeService.viewMappings()
                                            .forEach(System.out::println);

                            case 3 -> {
                                System.out.print("Person ID: ");
                                int pid = sc.nextInt();

                                System.out.print("Old Type ID: ");
                                int oldTid = sc.nextInt();

                                System.out.print("New Type ID: ");
                                int newTid = sc.nextInt();

                                personTypeService.updateType(pid, oldTid, newTid);
                                System.out.println("Mapping Updated");
                            }

                            case 4 -> {
                                System.out.print("Person ID: ");
                                int pid = sc.nextInt();

                                System.out.print("Type ID: ");
                                int tid = sc.nextInt();

                                personTypeService.removeType(pid, tid);
                                System.out.println("Mapping Deleted");
                            }
                        }
                    } while (ptChoice != 5);
                }

                case 4 -> System.out.println("Application Closed");

                default -> System.out.println("Invalid Option");
            }

        } while (mainChoice != 4);
    }
}
