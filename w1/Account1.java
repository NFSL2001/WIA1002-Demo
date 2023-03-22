package w1;

import java.util.ArrayList;

public class Account1 extends Account {
    private String name;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account1(String name, int id, double balance){
        this.name = name;
        this.setId(id);
        this.setBalance(balance);
    }

    public double withdraw(double amount){
        if(this.getBalance() >= amount && amount > 0){
            this.setBalance(this.getBalance() - amount);
        } else {
            System.err.println("Failed");
            return -1;
        }
        this.transactions.add(
            new Transaction('W', amount, this.getBalance(), "Withdrawal")
            );
        return this.getBalance();
    }
    
    public double deposit(double amount){
        if(amount > 0){
            this.setBalance(this.getBalance() + amount);
        } else {
            System.err.println("Failed");
            return -1;
        }
        this.transactions.add(
            new Transaction('D', amount, this.getBalance(), "Depositted")
            );
        return this.getBalance();
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public static void main(String[] args) {
        Account1 acc = new Account1("George", 1122, 1000);
        acc.setAnnualInterestRate(1.5);

        acc.deposit(30);
        acc.deposit(40);
        acc.deposit(50);
        acc.withdraw(5);
        acc.withdraw(4);
        acc.withdraw(2);

        System.out.println("=== Account summary ===");
        System.out.printf("Name: %s\n", acc.name);
        System.out.printf("Monthly interest rate: %.2f%%\n", acc.getAnnualInterestRate());
        System.out.printf("Balance: %.2f\n", acc.getBalance());
        System.out.println("Transaction history:");
        for(Transaction transaction: acc.getTransactions()){
            System.out.println(transaction);
        }
    }
}
