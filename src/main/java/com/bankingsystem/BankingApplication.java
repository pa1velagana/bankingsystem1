package com.bankingsystem;
import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private int accountId;
    private String customerName;
    private String address;
    private double balance;

    public Account(int accountId, String customerName, String address, double balance) {
        this.accountId = accountId;
        this.customerName = customerName;
        this.address = address;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

public class BankingApplication {
    private static ArrayList<Account> accounts = new ArrayList<Account>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\nBanking Application Menu:");
            System.out.println("1. Add New Account");
            System.out.println("2. Change Address of the Customer");
            System.out.println("3. Check Account Balance");
            System.out.println("4. Update Account Balance");
            System.out.println("5. Summary of All Accounts");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    addNewAccount(scanner);
                    break;
                case 2:
                    changeAddress(scanner);
                    break;
                case 3:
                    checkAccountBalance(scanner);
                    break;
                case 4:
                    updateAccountBalance(scanner);
                    break;
                case 5:
                    summaryOfAllAccounts();
                    break;
                case 6:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid choice.");
                    break;
            }

        } while (choice != 6);

        scanner.close();
    }

    private static void addNewAccount(Scanner scanner) {
        System.out.println("\nAdding a new account...");
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter initial amount: ");
        double initialAmount = scanner.nextDouble();
        scanner.nextLine(); // consume the newline character

        // generate a new account ID
        int accountId = accounts.size() + 1;

        // create a new account object and add it to the accounts list
        Account account = new Account(accountId, customerName, "", initialAmount);
        accounts.add(account);

        System.out.println("Account created successfully. Account ID is: " + accountId);
    }

    private static void changeAddress(Scanner scanner) {
        System.out.println("\nChanging the address of the customer...");
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        // find the account object in the accounts list
        Account account = findAccountById(accountId);

        if (account == null) {
            System.out.println("Account not found with ID: " + accountId);
            return;
        }

        System.out.print("Enter new address: ");
        String address = scanner.nextLine();

        // update the account object with the new address
        account.setAddress(address);

        System.out.println("Address updated successfully.");
    }

    private static void checkAccountBalance(Scanner scanner) {
        System.out.println("\nChecking the account balance...");
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        // find the account object in the accounts list
        Account account = findAccountById(accountId);

        if (account == null) {
            System.out.println("Account not found with ID: " + accountId);
            return;
        }

        System.out.println("Account balance is: " + account.getBalance());
    }

    private static void updateAccountBalance(Scanner scanner) {
        System.out.println("\nUpdating the account balance...");
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        // find the account object in the accounts list
        Account account = findAccountById(accountId);

        if (account == null) {
            System.out.println("Account not found with ID: " + accountId);
            return;
        }

        System.out.print("Enter amount to update to the balance: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume the newline character

        // update the account object with the new balance
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);

        System.out.println("Account balance updated successfully. New balance is: " + newBalance);
    }

    private static void summaryOfAllAccounts() {
        System.out.println("\nSummary of all accounts:");

        if (accounts.size() == 0) {
            System.out.println("No accounts found!");
            return;
        }

        for (Account account : accounts) {
            System.out.println("Account ID: " + account.getAccountId() + ", Customer Name: " + account.getCustomerName()
                    + ", Address: " + account.getAddress() + ", Balance: " + account.getBalance());
        }
    }

    private static Account findAccountById(int accountId) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }

        return null;
    }
}