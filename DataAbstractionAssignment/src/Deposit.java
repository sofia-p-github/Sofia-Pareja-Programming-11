/*

Sofia Pareja

Unit 5 - Data Abstraction Assignment

*/
import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        //your code here

        // requires: amount > 0, account is checking or saving
        //modifies:this
        //effects: prints out amount deposited, date deposited, and which account it was deposited to
        return "Deposit of: $" + amount + " Date: " + date + " into account: " + account;
    }
}
