package edu.nyu.cs;
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
                System.out.println("(1) Add a new contact.");
                System.out.println("(2) Search for contact.");
                System.out.println("(3) Display all contacts.");
                System.out.println("(4) Quit.");
                System.out.println("Enter your choice: ");
                choice = sc.nextInt();
                if (choice < 1 || choice > 4) {
                    System.out.println("Please choose from the list.");
                    continue;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
                sc.next(); // clear the wrong scanner input
                continue;
            }
        }
        return choice;
    }

    public static void main(String[] args) {
	// write your code here
        int choice = getInput();
    }
}
