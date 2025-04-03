package com.BankConsoleApp.java;
import com.AccountType.java.AccountType;
import com.BankService.java.BankService;
import java.util.Scanner;

public class BankConsoleApp {
    public static void run() {
        BankService bankService = new BankService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome to Bank System");
            System.out.println("1. Create Account");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String holder = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    System.out.print("Enter Account Type (SAVINGS/CURRENT): ");
                    AccountType type = AccountType.valueOf(scanner.next().toUpperCase());
                    bankService.addAccount(accNo, holder, balance, type);
                    break;
                case 2:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice! Try Again.");
            }
        }
    }
}
