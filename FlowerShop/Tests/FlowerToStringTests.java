import com.example.flowershop.Flower;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
/*
This file tests the toString method from the FLower class using Junit. All of the other tests are in separate files.
 */
public class FlowerToStringTests {
    public Flower testFlower;

    @Before
    public void setup(){
        testFlower = new Flower("test","red",100,1,100);
    }

    @Test

    public void testingFlowerToString(){
        assertEquals(testFlower.toString(),"red test; qty: 100; bulk price: $100.0; retail price: $1.0");
    }
}
