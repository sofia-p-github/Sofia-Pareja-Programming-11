import com.example.flowershop.FlowerCart;
import com.example.flowershop.FlowerCustomer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/*
This file tests the equals method from the FLowerCart class using Junit. All of the other tests are in separate files.
 */



public class FlowerCartEqualsTests {
    public FlowerCart FlowerCartOriginal;
    public FlowerCart testFlowerCart1;
    public FlowerCart testFlowerCart2;
    public FlowerCart testFlowerCart3;
    public FlowerCart testFlowerCart4;
    public FlowerCustomer FlowerCustomerOriginal;
    public FlowerCustomer testFlowerCustomer;

    @Before

    public void setup(){
        FlowerCustomerOriginal = new FlowerCustomer("test","red",100,1,100);
        testFlowerCustomer = new FlowerCustomer("test","blue",100,1,100);
        FlowerCartOriginal = new FlowerCart(FlowerCustomerOriginal,5);
        testFlowerCart1 = new FlowerCart(FlowerCustomerOriginal,5);
        testFlowerCart2 = new FlowerCart(FlowerCustomerOriginal, 6);
        testFlowerCart3 = new FlowerCart(testFlowerCustomer, 5);
        testFlowerCart4 = new FlowerCart(testFlowerCustomer,6);
    }

    @Test

    public void testingCartFlowerEqualsBoth(){
        assertTrue(FlowerCartOriginal.equals(testFlowerCart1));
    }

    @Test
    public void testingCartFlowerDifferentQty(){
        assertFalse(FlowerCartOriginal.equals(testFlowerCart2));
    }

    @Test
    public void testingCartFlowerDifferentFlowerCustomer(){
        assertFalse(FlowerCartOriginal.equals(testFlowerCart3));
    }

    @Test
    public void testingCartFlowerDifferentBoth(){
        assertFalse(FlowerCartOriginal.equals(testFlowerCart4));
    }


}
