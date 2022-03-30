/*

Sofia Pareja

Unit 5 - Data Abstraction Assignment

*/
import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;


    Customer(){
        //create default constructor
        checkBalance = 0;
        savingBalance = 0;
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        this.deposits = new ArrayList<Deposit>();
        this.withdraws = new ArrayList<Withdraw>();

    }

    public double deposit(double amt, Date date, String account){
        //requires: amt > 0, account == checking or saving
        //modifies: this, deposits
        // effects: adds deposit to list of deposits
        Deposit Deposit1 = new Deposit(amt, date, account);
        deposits.add(Deposit1);
     ;
        if (account == CHECKING){
            checkBalance += amt;
        }
        else{
            savingBalance += amt;
        }
        //your code here
        return 0;
    }

    public double withdraw(double amt, Date date, String account){
        // requires: amt > 0, account == checking or saving
        // modifies: this, withdrawals,
        // effects: adds withdrawal to list of withdrawals if there is enough money in the account
        Withdraw Withdraw1 = new Withdraw(amt,date,account);
        if (checkOverdraft(amt,account) == true){
            withdraws.add(Withdraw1);
            if (account == CHECKING){
                checkBalance -= amt;
            }
            else{
                savingBalance -= amt;
            }
        }
        else{
            return -1;
        }


        //your code here
        return 0;
    }
    private boolean checkOverdraft(double amt, String account){
        if (account == SAVING){
            if (amt>savingBalance){
                return false;
            }
            else{
                return true;
            }
        }
        else if (account == CHECKING){
            if (amt > savingBalance - OVERDRAFT){
                return false;
            }
            else{
                return true;
            }
        }
        return false;
    }


    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }



}
