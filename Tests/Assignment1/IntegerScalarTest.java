package Assignment1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerScalarTest {
    private IntegerScalar obj;


    @BeforeEach
    public void initTest(){
        obj = new IntegerScalar(2);


    }

    @Test
    public  void testAdd(){
        Assertions.assertEquals(new IntegerScalar(2),obj.add(new IntegerScalar(0)));
    }

    @Test
    public  void testMul(){
        Assertions.assertEquals(new IntegerScalar(0),obj.mul(new IntegerScalar(0)));
    }

    @Test
    public void testNeg(){
        Assertions.assertEquals(new IntegerScalar(-2),obj.neg());
    }

    @Test
    public void testPower(){
        Assertions.assertEquals(new IntegerScalar(4),obj.power(2));
    }

    @Test
    public void testSign(){
        Assertions.assertEquals(1,obj.sign());
    }


}