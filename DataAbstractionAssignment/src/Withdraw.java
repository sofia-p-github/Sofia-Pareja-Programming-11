/*

Sofia Pareja

Unit 5 - Data Abstraction Assignment

*/
import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        //your code here
        // requires: amount > 0, account is checking or saving
        //modifies:this
        //effects: prints out amount withdrawn, date withdrawn, and which account it was withdrawn from
        return "Withdrawal of : " + amount + " Date: " + date + " into account: " + account;
    }
}
