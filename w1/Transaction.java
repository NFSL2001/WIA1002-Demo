package w1;

import java.text.DateFormat;
import java.util.Date;

public class Transaction {
    private Date date = new Date();
    private char type;
    private double amount, balance;
    private String description;
    
    public Transaction(char type, double amount, double balance, String description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString(){
        String move = "Deposit of ";
        if(this.type == 'W'){
            move = "Withdrawal of ";
        }
        String str = move + Double.toString(this.amount) + " remaining " + Double.toString(this.balance) + " at " + DateFormat.getDateInstance().format(this.date);
        return str;
    }
}
