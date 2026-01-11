package addressbook.ui;

import addressbook.repository.InMemoryContactRepository;
import addressbook.service.AddressBookService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookSystemUI
{
    private final Map<String, AddressBookUI> books = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        int choice;

        do {
            System.out.println("\n1. Create Address Book");
            System.out.println("2. Open Address Book");
            System.out.println("3. Exit");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> createBook();
                case 2 -> openBook();
            }
        } while (choice != 3);
    }

    private void createBook() {
        System.out.print("Book Name: ");
        String name = sc.nextLine();

        books.put(name, new AddressBookUI(
                new AddressBookService(new InMemoryContactRepository())
        ));
        System.out.println("Address Book Created!");
    }

    private void openBook() {
        System.out.print("Book Name: ");
        String name = sc.nextLine();

        AddressBookUI ui = books.get(name);
        if (ui != null) ui.menu();
        else System.out.println("Not found!");
    }
}
