package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MonomialTest {
    private Monomial m1;
    private Monomial m2;
    private Monomial m3;
    private Monomial m4;
    private Monomial m5;
    private Monomial m6;
    private Monomial m7;
    private Monomial m8;
    private Monomial m9;
    private Monomial m10;
    private Monomial m11;
    private Monomial m12;



    @BeforeEach
    public void initTest() {
        m1 = new Monomial(2, new IntegerScalar(-2));
        m2 = new Monomial(2, new IntegerScalar(3));
        m3 = new Monomial(3, new RationalScalar(2,4));
        m4 = new Monomial(3, new RationalScalar(-3,7));
        m5 = new Monomial(2, new RationalScalar(2,2));
        m6 = new Monomial(3, new RationalScalar(0,7));
        m7 = new Monomial(0, new IntegerScalar(10));
        m8 = new Monomial(1, new IntegerScalar(6));
        m9 = new Monomial(2, new IntegerScalar(1));
        m10 = new Monomial(1, new IntegerScalar(-2));
        m11 = new Monomial(7, new IntegerScalar(-1));
        m12 = new Monomial(2, new IntegerScalar(3));
    }

    @Test
    void add() {
        assertEquals(new Monomial(2, new IntegerScalar(1)), m1.add(m2));
        assertEquals(new Monomial(3, new RationalScalar(1, 14)), m3.add(m4));
        assertEquals(null, m5.add(m6));
        assertEquals(new Monomial(2, new RationalScalar(-1, 1)), m5.add(m1));
    }

    @Test
    void mul() {
        assertEquals(new Monomial(4, new IntegerScalar(-6)), m1.mul(m2));
        assertEquals(new Monomial(6, new RationalScalar(-3, 14)), m3.mul(m4));
        assertEquals(new Monomial(5, new RationalScalar(0, 1)), m5.mul(m6));
        assertEquals(new Monomial(4, new RationalScalar(-2, 1)), m5.mul(m1));
        assertEquals(new Monomial(1, new IntegerScalar ( 60)), m7.mul(m8));
    }

    @Test
    void evaluate() {
        assertEquals(new IntegerScalar(-98), m1.evaluate(new IntegerScalar(7)));
        assertEquals(new IntegerScalar(10), m7.evaluate(new RationalScalar(3,7)));
        assertEquals(new RationalScalar(-375, 7), m4.evaluate(new IntegerScalar(5)));
        assertEquals(new RationalScalar(4, 1), m3.evaluate(new IntegerScalar(2)));
        assertEquals(new RationalScalar(-18,49), m1.evaluate(new RationalScalar(3,7)));
        assertEquals(new IntegerScalar(3), m12.evaluate(new IntegerScalar(1)));
    }

    @Test
    void derivative() {
        assertEquals(new Monomial(1, new IntegerScalar(-4)), m1.derivative());
        assertEquals(new Monomial(2, new RationalScalar(3, 2)), m3.derivative());
        assertEquals(new Monomial(0, new IntegerScalar(6)), m8.derivative());
        assertEquals(new Monomial(0, new IntegerScalar(0)), m7.derivative());
    }

    @Test
    void sign() {
        assertEquals(-1, m1.sign());
        assertEquals(1, m8.sign());
        assertEquals(0, m6.sign());
    }

    @Test
    void testEquals() {
        assertEquals(true, m9.equals(m5));
        assertEquals(false, m1.equals(m2));
        assertEquals(false, m1.equals(m10));
    }

    @Test
    void testToString() {
        assertEquals("x^2", m9.toString());
        assertEquals("-2x^2", m1.toString());
        assertEquals("10", m7.toString());
        assertEquals("6x", m8.toString());
        assertEquals("1/2x^3", m3.toString());
        assertEquals("-x^7", m11.toString());

    }
}