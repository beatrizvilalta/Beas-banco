package application;

import entities.BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option = selectOptionInMenu();

        List<BankAccount> bankAccountList = new ArrayList<>();

        selectCase(bankAccountList, option);

        sc.close();
    }


    public static int selectOptionInMenu() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose an option: ");
        System.out.println("1 - Register account");
        System.out.println("2 - List of accounts");
        System.out.println("3 - Account data");
        System.out.println("4 - Balance inquiry");
        System.out.println("5 - Deposit");
        System.out.println("6 - Withdraw");
        System.out.println("7 - Edit account");
        System.out.println("8 - Remove account");
        System.out.println("0 - Exit");

        return sc.nextInt();
    }

    public static void selectCase(List<BankAccount> bankAccountList, int option){

        while (option != 0) {
            switch (option) {
                case 1:
                    registerAccount(bankAccountList);
                    System.out.println();
                    option = selectOptionInMenu();
                    System.out.println();
                    break;

                case 2:
                    showAccountList(bankAccountList);
                    System.out.println();
                    option = selectOptionInMenu();
                    System.out.println();
                    break;

                case 3:
                    showAccountData(bankAccountList);
                    System.out.println();
                    option = selectOptionInMenu();
                    System.out.println();
                    break;


                case 4:
                    showBalance(bankAccountList);
                    System.out.println();
                    option = selectOptionInMenu();
                    System.out.println();
                    break;

                case 5:
                    makeDeposit(bankAccountList);
                    System.out.println();
                    option = selectOptionInMenu();
                    System.out.println();
                    break;

                case 6:
                    makeWithdraw(bankAccountList);
                    System.out.println();
                    option = selectOptionInMenu();
                    System.out.println();
                    break;

                case 7:
                    editAccount(bankAccountList);
                    System.out.println();
                    option = selectOptionInMenu();
                    System.out.println();
                    break;

                case 8:
                    removeAccount((bankAccountList));
                    System.out.println();
                    option = selectOptionInMenu();
                    System.out.println();
                    break;

                default:
                    System.out.println("ERROR: Code not identified. Try again: ");
                    option = selectOptionInMenu();
                    System.out.println();
            }
        }

    }


    // Case 1 register account
    public static List<BankAccount> registerAccount(List<BankAccount> bankAccountList) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Enter your document number: ");
        int documentNumber = sc.nextInt();

        BankAccount currentBankAccount = new BankAccount(name, documentNumber);
        bankAccountList.add(currentBankAccount);

        System.out.println("Account created with success!");
        System.out.println();
        System.out.println("Account data: ");
        System.out.print("Account number #" + (bankAccountList.indexOf(currentBankAccount) + 1));
        System.out.println(currentBankAccount.toString());
        return bankAccountList;
    }

    // Case 2 list of accounts
    public static void showAccountList(List<BankAccount> bankAccountList) {
        System.out.println("List of accounts: ");
        for (BankAccount currentBankAccount : bankAccountList) {
            System.out.println();
            System.out.print("Account number #" + (bankAccountList.indexOf(currentBankAccount) + 1));
            System.out.println(currentBankAccount.toString());
        }
    }

    //Case 3 account data
    public static void showAccountData(List<BankAccount> bankAccountList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your account number: ");
        int typedAccount = sc.nextInt();

        for (BankAccount currentAccount : bankAccountList) {
            if (typedAccount == (bankAccountList.indexOf(currentAccount) + 1)) {
                System.out.println("Account data: ");
                System.out.print("Account number #" + (bankAccountList.indexOf(currentAccount) + 1));
                System.out.println(currentAccount.toString());
            }
        }
    }


    //Case 4 balance inquiry
    public static void showBalance(List<BankAccount> bankAccountList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your account number: ");
        int typedAccount = sc.nextInt();

        for (BankAccount currentAccount : bankAccountList) {
            if ((typedAccount == bankAccountList.indexOf(currentAccount) + 1)) {
                System.out.println("Balance = " + currentAccount.getBalance());
            }
        }
    }

    //Case 5 deposit
    public static void makeDeposit(List<BankAccount> bankAccountList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your account number: ");
        int typedAccount = sc.nextInt();

        for (BankAccount currentAccount : bankAccountList) {
            if (typedAccount == (bankAccountList.indexOf(currentAccount) + 1)) {
                System.out.println("Enter the deposit value: ");
                double deposit = sc.nextDouble();
                currentAccount.deposit(deposit);
                System.out.println("Deposit made with success!");
                System.out.println("Do you want to check your total balance? ");
                sc.nextLine();
                String answer = sc.nextLine();
                if (answer.equals("yes")) {
                    System.out.println("Balance = " + currentAccount.getBalance());
                }
            }
        }
    }

    //Case 6 withdraw
    public static void makeWithdraw(List<BankAccount> bankAccountList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your account number: ");
        int typedAccount = sc.nextInt();

        for (BankAccount currentAccount : bankAccountList) {
            if (typedAccount == (bankAccountList.indexOf(currentAccount) + 1)) {
                System.out.println("Enter the withdraw value: ");
                double withdraw = sc.nextDouble();
                currentAccount.withdraw(withdraw);
                System.out.println("Withdraw made with success!");
                System.out.println("Do you want to check your total balance? ");
                sc.nextLine();
                String answer = sc.nextLine();
                if (answer.equals("yes")) {
                    System.out.println("Balance = " + currentAccount.getBalance());
                }
            }
        }
    }

    // Case 7 edit account
    public static void editAccount(List<BankAccount> bankAccountList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account number you want to edit: ");
        int typedAccount = sc.nextInt();

        for (BankAccount currentAccount : bankAccountList) {
            if (typedAccount == (bankAccountList.indexOf(currentAccount) + 1)) {
                System.out.println("Which data do you want to edti?");
                System.out.println("1 - Name");
                System.out.println("2 - Document");
                int codeData = sc.nextInt();
                switch (codeData) {
                    case 1:
                        System.out.println("Enter your name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        currentAccount.setHolderName(name);
                        break;

                    case 2:
                        System.out.println("Enter your document: ");
                        int document = sc.nextInt();
                        currentAccount.setDocument(document);
                        break;

                    default:
                        System.out.println("Error: code not identified");
                        break;

                }
            }
        }
    }

    //Case 8
    public static void removeAccount(List<BankAccount> bankAccountList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account number you want to remove: ");
        int typedAccount = sc.nextInt();

       if (bankAccountList.size() == 0) {
           System.out.println("ERROR. There is no account to remove.");
       } else{
           for (BankAccount currentAccount : bankAccountList) {
               if (typedAccount == bankAccountList.indexOf(currentAccount) + 1) {
                   bankAccountList.remove(currentAccount);
                   System.out.println("Account removed with success!");
                   break;
               }
           }
       }
    }
}

