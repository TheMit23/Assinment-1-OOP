package Classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RationalScalarTest {
    private IntegerScalar objPos;
    private IntegerScalar objNeg;
    private IntegerScalar obj0;
    private IntegerScalar obj1;
    private RationalScalar objRat1;
    private RationalScalar objRat2;
    private RationalScalar objRat3;
    private RationalScalar objRat4;
    private RationalScalar objRat5;
    private RationalScalar objRat6;
    private RationalScalar objRat7;


    @BeforeEach
    public void initTest() {
        objPos = new IntegerScalar(5);
        objNeg = new IntegerScalar(-10);
        obj0 = new IntegerScalar(0);
        obj1 = new IntegerScalar(1);
        objRat1 = new RationalScalar(7, 9);
        objRat2 = new RationalScalar(-1, 4);
        objRat3 = new RationalScalar(-30, -30);
        objRat4 = new RationalScalar(100, 5);
        objRat5 = new RationalScalar(20, -5);
        objRat6 = new RationalScalar(0, 5);
        objRat7 = new RationalScalar(0, -5);
    }

    @Test
    void reduce() {
        Assertions.assertEquals(new RationalScalar(7, 9), objRat1.reduce());
        Assertions.assertEquals(new RationalScalar(-1, 4), objRat2.reduce());
        Assertions.assertEquals(new RationalScalar(1, 1), objRat3.reduce());
        Assertions.assertEquals(new RationalScalar(20, 1), objRat4.reduce());
        Assertions.assertEquals(new RationalScalar(-4, 1), objRat5.reduce());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("7/9", objRat1.toString());
        Assertions.assertEquals("-1/4", objRat2.toString());
        Assertions.assertEquals("1", objRat3.toString());
        Assertions.assertEquals("20", objRat4.toString());
        Assertions.assertEquals("-4", objRat5.toString());

    }

    @Test
    void add() {
        Assertions.assertEquals(new RationalScalar(14, 9), objRat1.add(objRat1));
        Assertions.assertEquals(new RationalScalar(19, 36), objRat1.add(objRat2));
        Assertions.assertEquals(new RationalScalar(21, 1), objRat3.add(objRat4));
        Assertions.assertEquals(new RationalScalar(-4, 1), objRat5.add(obj0));
        Assertions.assertEquals(new RationalScalar(52, 9), objRat1.add(objPos));

    }

    @Test
    void mul() {
        Assertions.assertEquals(new RationalScalar(-7, 36), objRat1.mul(objRat2));
        Assertions.assertEquals(new RationalScalar(7, 9), objRat1.mul(obj1));
        Assertions.assertEquals(new RationalScalar(0, 1), objRat2.mul(obj0));
        Assertions.assertEquals(new RationalScalar(-200, 1), objRat4.mul(objNeg));
        Assertions.assertEquals(new RationalScalar(40, 1), objRat5.mul(objNeg));
    }

    @Test
    void neg() {
        Assertions.assertEquals(new RationalScalar(-7, 9), objRat1.neg());
        Assertions.assertEquals(new RationalScalar(1, 4), objRat2.neg());
        Assertions.assertEquals(new RationalScalar(-1, 1), objRat3.neg());
        Assertions.assertEquals(new RationalScalar(-20, 1), objRat4.neg());
        Assertions.assertEquals(new RationalScalar(4, 1), objRat5.neg());
    }

    @Test
    void power() {
        Assertions.assertEquals(new RationalScalar(49, 81), objRat1.power(2));
        Assertions.assertEquals(new RationalScalar(-1, 64), objRat2.power(3));
        Assertions.assertEquals(new RationalScalar(1, 1), objRat3.power(2));
        Assertions.assertEquals(new RationalScalar(400, 1), objRat4.power(2));
        Assertions.assertEquals(new RationalScalar(1, 1), objRat5.power(0));
    }

    @Test
    void sign() {
        Assertions.assertEquals(1, objRat1.sign());
        Assertions.assertEquals(-1, objRat2.sign());
        Assertions.assertEquals(1, objRat3.sign());
        Assertions.assertEquals(1, objRat4.sign());
        Assertions.assertEquals(-1, objRat5.sign());
        Assertions.assertEquals(0, obj0.mul(objRat1).sign());
    }

    @Test
    void testEquals() {
        Assertions.assertEquals(true, objRat1.equals(new RationalScalar(7, 9)));
        Assertions.assertEquals(false, objRat1.equals(new RationalScalar(7, 8)));
        Assertions.assertEquals(true, objRat2.equals(new RationalScalar(-1, 4)));
        Assertions.assertEquals(false, objRat2.equals(new RationalScalar(-1, 5)));
        Assertions.assertEquals(true, objRat3.equals(new RationalScalar(1, 1)));
        Assertions.assertEquals(true, objRat5.equals(new IntegerScalar(-4)));
        Assertions.assertEquals(true, objRat6.equals(objRat7));


    }
}