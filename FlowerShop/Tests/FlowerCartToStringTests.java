import com.example.flowershop.FlowerCart;
import com.example.flowershop.FlowerCustomer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/*
This file tests the toString method from the FLowerCart class using Junit. All of the other tests are in separate files.
 */
public class FlowerCartToStringTests {
    public FlowerCart testFlowerCart;
    public FlowerCustomer testFlowerCustomer;

    @Before

    public void setup(){
        testFlowerCustomer = new FlowerCustomer("test","red",100,1,100);
        testFlowerCart = new FlowerCart(testFlowerCustomer,5);
    }

    @Test

    public void testingCartFlowerToString(){
        assertEquals(testFlowerCart.toString(),"5 red tests $1.0 ea." );
    }

}
