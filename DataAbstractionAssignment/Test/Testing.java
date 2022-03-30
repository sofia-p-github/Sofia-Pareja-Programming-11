
/*

Sofia Pareja

Unit 5 - Data Abstraction Assignment

*/
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Testing {

    Customer testCustomer;

    @Before
    public void setup(){
        testCustomer = new Customer("John Smith",1,0,0 );
    }

    @Test
    public void testDepositChecking(){

        assertEquals(testCustomer.deposit(10.0,new Date( ),Customer.CHECKING), 0, 0);


    }

    @Test
    public void testDepositToStringChecking(){
        // This is a dummy deposit, just to check the toString() method
        Deposit Deposit1 = new Deposit(10.0,new Date( ),Customer.CHECKING);
        assertEquals(Deposit1.toString(), "Deposit of: $10.0 Date: " + new Date() + " into account: Checking");
    }

    @Test
    public void testWithdrawChecking(){
        testCustomer.deposit(10.0,new Date( ),Customer.CHECKING);

        assertEquals(testCustomer.withdraw(10.0,new Date( ),Customer.CHECKING),0,0);


    }

    @Test
    public void testWithdrawalToStringChecking(){
        // This is a dummy withdrawal, just to check the toString() method
        Withdraw Withdraw1 = new Withdraw(10.0,new Date( ),Customer.CHECKING);
        assertEquals(Withdraw1.toString(), "Withdrawal of : 10.0 Date: " + new Date() + " into account: Checking");

    }

    @Test
    public void testWithdrawOverdraft(){

        assertEquals(testCustomer.withdraw(100.0,new Date(),Customer.CHECKING),0,0);

    }

    @Test
    public void testWithdrawInsufficientFundsChecking(){

        testCustomer.deposit(5.0,new Date(),Customer.CHECKING);
        assertEquals(testCustomer.withdraw(110.0,new Date(),Customer.CHECKING),-1,0);

    }

    @Test
    public void testDepositSaving(){
        //

       assertEquals(testCustomer.deposit(10.0,new Date( ),Customer.SAVING),0,0);



    }

    @Test
    public void testWithdrawSaving(){
        testCustomer.deposit(10.0,new Date( ),Customer.SAVING);

        assertEquals(testCustomer.withdraw(10.0,new Date( ),Customer.SAVING),0,0);

    }
    @Test
    public void testWithdrawInsufficientFundsSaving(){

        testCustomer.deposit(10.0, new Date(), Customer.SAVING);
        assertEquals(testCustomer.withdraw(110.0,new Date(),Customer.SAVING),-1,0);

    }

    @Test
    public void testDepositToStringSaving(){
        // This is a dummy deposit, just to check the toString() method
        Deposit Deposit1 = new Deposit(10.0,new Date( ),Customer.SAVING);
        assertEquals(Deposit1.toString(), "Deposit of: $10.0 Date: " + new Date() + " into account: Saving");
    }

    @Test
    public void testWithdrawalToStringSaving(){
        // This is a dummy withdrawal, just to check the toString() method
        Withdraw Withdraw1 = new Withdraw(10.0,new Date( ),Customer.SAVING);
        assertEquals(Withdraw1.toString(), "Withdrawal of : 10.0 Date: " + new Date() + " into account: Saving");

    }





}
