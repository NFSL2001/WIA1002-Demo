package w1;

import java.text.DateFormat;
import java.util.Date;

public class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated = new Date();

    public Account(){}

    public Account(int id, double balance){
        this.id = id;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public String getDateCreated(){
        return DateFormat.getDateInstance().format(dateCreated);
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest(){
        return getMonthlyInterestRate() / 100 * balance;
    }

    public double withdraw(double amount){
        if(this.balance >= amount && amount > 0){
            this.balance = this.balance - amount;
        } else {
            System.err.println("Failed");
        }
        return this.balance;
    }
    
    public double deposit(double amount){
        if(amount > 0){
            this.balance = this.balance + amount;
        } else {
            System.err.println("Failed");
        }
        return this.balance;
    }

    public static void main(String[] args) {
        Account acc = new Account(1122, 20000);
        acc.setAnnualInterestRate(4.5);

        acc.withdraw(2500);
        acc.deposit(3000);

        System.out.printf("Balance: %.2f\n", acc.getBalance());
        System.out.printf("Monthly interest: %.2f%%\n", acc.getMonthlyInterest());
        System.out.printf("Date created: %s\n", acc.getDateCreated());
    }
}
