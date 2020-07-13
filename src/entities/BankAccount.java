package entities;

public class BankAccount {

    private String holderName;
    private int document;
    private double balance = 0.0;

    public BankAccount(String holderName, int document) {
        this.holderName = holderName;
        this.document = document;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double deposit){
        this.balance = balance + deposit;
    }

    public void withdraw(double withdraw){
        this.balance = balance - withdraw;
    }

    @Override
    public String toString() {
        return ", holder name: " + holderName  +
                ", document: " + document +
                ", balance: " + balance;
    }
}
