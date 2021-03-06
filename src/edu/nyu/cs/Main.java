package edu.nyu.cs;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class Main {
    public static int getInput() {
        System.out.println("Main Window:");
        System.out.println("============");
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int choice = 0;
        while(true) {
            try {
                System.out.println("Choose one of the following options: ");
                System.out.println("(1) Add a new contact");
                System.out.println("(2) Search for contact");
                System.out.println("(3) Display all contacts");
                System.out.println("(4) Quit");
                System.out.println();
                System.out.println("Enter your choice: ");
                choice = sc.nextInt();
                if (choice < 1 || choice > 4) {
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

    public static void main(String[] args) {
	// write your code here
        AddressBook myBook = new AddressBook();
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while (choice != 4) {
            choice = getInput();
            if (choice == 1) {
                myBook.addContact();
                try {
                    System.in.read();
                } catch (Exception e) {
                }
                continue;
            } else if (choice == 2) {
                int deleteOrNot = myBook.searchContact();
                if (deleteOrNot == 1) {
                    try {
                        System.in.read();
                    } catch (Exception e) {
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (choice == 3) {
                myBook.displayContactList(myBook.getContactList());
                System.out.println("Press Enter to go back to the main window.");
                try {
                    System.in.read();
                } catch (Exception e) {
                }
                continue;
            } else {
                System.out.println("Thank you for using");
            }
        }
    }
}
