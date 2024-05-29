package Classes;

import Classes.Scalars.IntegerScalar;
import Classes.Scalars.RationalScalar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerScalarTest {
    private IntegerScalar objPos;
    private IntegerScalar objNeg;
    private IntegerScalar obj0;
    private IntegerScalar obj1;
    private RationalScalar objRat1;
    private RationalScalar objRat2;
    private RationalScalar objRat3;


    @BeforeEach
    public void initTest() {
        objPos = new IntegerScalar(2);
        objNeg = new IntegerScalar(-2);
        obj0 = new IntegerScalar(0);
        obj1 = new IntegerScalar(1);
        objRat1 = new RationalScalar(3, 5);
        objRat2 = new RationalScalar(-1, 2);
        objRat3 = new RationalScalar(23, 23);
    }


    //testing add----------------------------------------------------------------
    @Test
    public void testAdd1() {
        Assertions.assertEquals(new IntegerScalar(4), objPos.add(objPos));
    }

    @Test
    public void testAdd2() {
        Assertions.assertEquals(new IntegerScalar(2), objPos.add(obj0));
    }

    @Test
    public void testAdd3() {
        Assertions.assertEquals(new IntegerScalar(0), objPos.add(objNeg));
    }

    @Test
    public void testAdd4() {
        Assertions.assertEquals(new IntegerScalar(-2), objNeg.add(obj0));
    }

    @Test
    public void testAdd5() {
        Assertions.assertEquals(new IntegerScalar(-4), objNeg.add(objNeg));
    }

    @Test
    public void testAdd6() {
        Assertions.assertEquals(new RationalScalar(-7, 5), objNeg.add(objRat1));
    }

    @Test
    public void testAdd7() {
        Assertions.assertEquals(new RationalScalar(-1, 2), obj0.add(objRat2));
    }

    @Test
    public void testAdd8() {
        Assertions.assertEquals(new RationalScalar(3, 1), objPos.add(objRat3));
    }

    //testing mul--------------------------------------------------------------
    @Test
    public void testMul1() {
        Assertions.assertEquals(new IntegerScalar(4), objPos.mul(objPos));
    }

    @Test
    public void testMul2() {
        Assertions.assertEquals(new IntegerScalar(0), objPos.mul(obj0));
    }

    @Test
    public void testMul3() {
        Assertions.assertEquals(new IntegerScalar(-4), objPos.mul(objNeg));
    }

    @Test
    public void testMul4() {
        Assertions.assertEquals(new IntegerScalar(0), objNeg.mul(obj0));
    }

    @Test
    public void testMul5() {
        Assertions.assertEquals(new IntegerScalar(4), objNeg.mul(objNeg));
    }

    @Test
    public void testMul6() {
        Assertions.assertEquals(new RationalScalar(-6, 5), objNeg.mul(objRat1));
    }

    @Test
    public void testMul7() {
        Assertions.assertEquals(new RationalScalar(0, 1), obj0.mul(objRat2));
    }

    @Test
    public void testMul8() {
        Assertions.assertEquals(new RationalScalar(2, 1), objPos.mul(objRat3));
    }

    //testing neg--------------------------------------------------------
    @Test
    public void testNeg1() {
        Assertions.assertEquals(new IntegerScalar(2), objNeg.neg());
    }

    @Test
    public void testNeg2() {
        Assertions.assertEquals(new IntegerScalar(0), obj0.neg());
    }

    @Test
    public void testNeg3() {
        Assertions.assertEquals(new IntegerScalar(-2), objPos.neg());
    }

    //testing power-------------------------------------------------------
    @Test
    public void testPow1() {
        Assertions.assertEquals(new IntegerScalar(8), objPos.power(3));
    }

    @Test
    public void testPow2() {
        Assertions.assertEquals(new IntegerScalar(1), obj1.power(5));
    }

    @Test
    public void testPow3() {
        Assertions.assertEquals(new IntegerScalar(0), obj0.power(5));
    }

    @Test
    public void testPow4() {
        Assertions.assertEquals(new IntegerScalar(-8), objNeg.power(3));
    }

    @Test
    public void testPow5() {
        Assertions.assertEquals(new IntegerScalar(16), objNeg.power(4));
    }
    @Test
    public void testPow6() {
        Assertions.assertEquals(new IntegerScalar(1), objNeg.power(0));
    }


    //testing sign--------------------------------------------------------
    @Test
    public void testsign1() {
        Assertions.assertEquals(-1, objNeg.sign());
    }

    @Test
    public void testsign2() {
        Assertions.assertEquals(0, obj0.sign());
    }

    @Test
    public void testsign3() {
        Assertions.assertEquals(1, objPos.sign());
    }

    //testing equals-------------------------------------------------------
    @Test
    public void testEquals1() {
        Assertions.assertEquals(true, objPos.equals(objPos));
    }

    @Test
    public void testEquals2() {
        Assertions.assertEquals(true, objNeg.equals(objNeg));
    }

    @Test
    public void testEquals3() {
        Assertions.assertEquals(true, obj0.equals(obj0));
    }

    @Test
    public void testEquals4() {
        Assertions.assertEquals(false, objNeg.equals(objPos));
    }
    @Test
    public void testEquals5() {
        Assertions.assertEquals(true, obj0.mul(objRat1).equals(obj0));
    }
    //testing string--------------------------------------------------------
    @Test
    public void teststring1() {
        Assertions.assertEquals("-2", objNeg.toString());
    }

    @Test
    public void teststring2() {
        Assertions.assertEquals("0", obj0.toString());
    }

    @Test
    public void teststrimng3() {
        Assertions.assertEquals("2", objPos.toString());
    }

}