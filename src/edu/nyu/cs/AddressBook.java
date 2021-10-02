package edu.nyu.cs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private List<Contact> contactList;
    private int size;
    private int lastId;

    public AddressBook() {
        this.size = 0;
        this.contactList = new ArrayList<Contact>();
        this.lastId = 0;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public int getSize() {
        return size;
    }

    public int getLastId() {
        return lastId;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }

    public void addContact() {
        System.out.println("Main Window --> Add a new contact window: (Enter the following information)");
        System.out.println("==========================================================================");
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Number: ");
        String number = sc.nextLine();
        System.out.println("Note: ");
        String note = sc.nextLine();
        Contact newContact = new Contact(name, email, number, note, this.lastId + 1);
        this.size++;
        this.lastId++;
        this.contactList.add(newContact);
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Saved successfully...Press Enter to go back to the Main Window");
    }

    public int searchContact() {
        System.out.println("Main Window --> Search for contact window: (Choose one of the following options");
        System.out.println("===============================================================================");
        int choice = getSearchChoice();
        int deleteOrNot = 0;
        List<Contact> result = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        if (choice == 1) {
            System.out.println("Main Window --> Search for contact window --> Search by name");
            System.out.println("============================================================");
            System.out.println("(1) Enter name: ");
            String nameToSearch = sc.nextLine();
            result = searchByName(nameToSearch);
            if (result == null || result.size() == 0) {
                System.out.println("No contact found");
            } else {
                displayContactList(result);
                System.out.println();
                deleteOrNot = this.getDeleteChoice();
                if (deleteOrNot == 1) {
                    System.out.println("Main Window --> Search for contact window --> Search by name --> Delete a contact");
                    System.out.println("==================================================================================");
                    deleteContact();
                }
            }
        } else if (choice == 2) {
            System.out.println("Main Window --> Search for contact window --> Search by email");
            System.out.println("============================================================");
            System.out.println("(2) Enter email: ");
            String emailToSearch = sc.nextLine();
            result = searchByEmail(emailToSearch);
            if (result == null || result.size() == 0) {
                System.out.println("No contact found");
            } else {
                displayContactList(result);
                System.out.println();
                deleteOrNot = this.getDeleteChoice();
                if (deleteOrNot == 1) {
                    System.out.println("Main Window --> Search for contact window --> Search by email --> Delete a contact");
                    System.out.println("==================================================================================");
                    deleteContact();
                }
            }
        } else {
            System.out.println("Main Window --> Search for contact window --> Search by phone");
            System.out.println("============================================================");
            System.out.println("(3) Enter phone number: ");
            String numberToSearch = sc.nextLine();
            result = searchByNumber(numberToSearch);
            if (result == null || result.size() == 0) {
                System.out.println("No contact found");
            } else {
                displayContactList(result);
                System.out.println();
                deleteOrNot = this.getDeleteChoice();
                if (deleteOrNot == 1) {
                    System.out.println("Main Window --> Search for contact window --> Search by phone --> Delete a contact");
                    System.out.println("==================================================================================");
                    deleteContact();
                }
            }
        }
        return deleteOrNot;

    }

    public void deleteContact() {
        this.size--;
        Scanner sc = new Scanner(System.in);
        int toDelete = 0;
        while (true) {
            try {
                System.out.println("Enter the contact ID: ");
                toDelete = sc.nextInt();
                break;
            } catch (Exception E) {
                System.out.println("Invalid input. Please choose from the list.");
                sc.next();
            }
        }
        Contact delete = new Contact();
        for (Contact c : this.contactList) {
            if (c.getId() == toDelete) {
                delete = c;
            }
        }
        this.contactList.remove(delete);
        System.out.println("Deleted...Press Enter to go back to the Main Window");

    }


    private int getSearchChoice() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while(true) {
            try {
                System.out.println("(1) Search by name");
                System.out.println("(2) Search by email");
                System.out.println("(3) Search by phone");
                System.out.println();
                System.out.println("Enter your choice: ");
                choice = sc.nextInt();
                if (choice < 1 || choice > 3) {
                    System.out.println("Please choose from the list.");
                    System.out.println();
                    continue;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please choose from the list.");
                System.out.println();
                sc.next(); // clear the wrong scanner input
                continue;
            }
        }
        return choice;
    }

    private List<Contact> searchByName(String name) {
        // search
        List<Contact> searchResult = new ArrayList<>();
        for (Contact c : contactList) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                searchResult.add(c);
            }
        }
        return searchResult;
    }

    private List<Contact> searchByEmail(String Email) {
        // search
        List<Contact> searchResult = new ArrayList<>();
        for (Contact c : contactList) {
            if (c.getEmail().toLowerCase().equals(Email.toLowerCase())) {
                searchResult.add(c);
            }
        }
        return searchResult;

    }

    private List<Contact> searchByNumber(String number) {
        // search
        List<Contact> searchResult = new ArrayList<>();
        for (Contact c : contactList) {
            if (c.getNumber().equals(number)) {
                searchResult.add(c);
            }
        }
        return searchResult;
    }

    private int getDeleteChoice() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while(true) {
            try {
                System.out.println("Choose one of these options: ");
                System.out.println("(1) To delete a contact");
                System.out.println("(2) Back to main window");
                System.out.println();
                System.out.println("Enter your choice: ");
                choice = sc.nextInt();
                if (choice < 1 || choice > 2) {
                    System.out.println("Please choose from the list.");
                    System.out.println();
                    continue;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please choose from the list.");
                System.out.println();
                sc.next(); // clear the wrong scanner input
                continue;
            }
        }
        return choice;
    }

    public void displayContactList(List<Contact> toDisplay) {
        toDisplay.sort(new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("ID" + " | " + String.format("%-20s", "Name") + " | " + String.format("%-25s", "Email") + " | " +
                String.format("%-20s", "Phone") + " | " + "Note\n");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (Contact c : toDisplay) {
            System.out.printf(c.getId() + " | " + String.format("%-20s", c.getName()) + " | "
                    + String.format("%-25s", c.getEmail()) + " | " +
                    String.format("%-20s", c.getNumber()) + " | " + c.getNote() + "\n");
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }
}
