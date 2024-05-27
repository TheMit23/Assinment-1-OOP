package Assignment1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerScalarTest {
    private IntegerScalar obj;


    @BeforeEach
    public void initTest(){
        obj = new IntegerScalar(1);

    }

    @Test
    public  void testadd(){
        Assertions.assertEquals(new IntegerScalar(1),obj.add(new IntegerScalar(0)));
    }

    @Test
    public  void testmul(){
        Assertions.assertEquals(new IntegerScalar(1),obj.add(new IntegerScalar(0)));
    }


}