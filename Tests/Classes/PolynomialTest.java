package Classes;

import Classes.Polinomials.Polynomial;
import Classes.Scalars.IntegerScalar;
import Classes.Scalars.RationalScalar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {
    private Polynomial p1;
    private Polynomial p2;
    private Polynomial p3;
    private Polynomial p4;
    private Polynomial p5;
    private Polynomial p6;
    private Polynomial p7;
    private Polynomial p8;
    private Polynomial p9;
    private Polynomial p10;
    private Polynomial p11;
    private Polynomial p12;
    private Polynomial p13;
    private Polynomial p14;
    private Polynomial p15;

    @BeforeEach
    public void initTest() {
        p1 = Polynomial.build("1 2 3");
        p2 = Polynomial.build("0 1 2 3");
        p3 = Polynomial.build("0 0 0 0 0 7");
        p4 = Polynomial.build("5");
        p5 = Polynomial.build("1 -2 3");
        p6 = Polynomial.build("0 1/2 3 -5/3");
        p7 = Polynomial.build("1  2   3");
        p8 = Polynomial.build("1/2  2       5");
        p9 = Polynomial.build("0 1");
        p10 = Polynomial.build("0 1 5");
        p11 = Polynomial.build("0 0 -5");
        p12 = Polynomial.build("1 1");
        p13 = Polynomial.build("0 5");
        p14 = Polynomial.build("0 5 5");
        p15 = Polynomial.build("0 0 0");







    }

    @Test
    void add() {
        assertEquals(Polynomial.build("1 3 5 3"), p1.add(p2));
        assertEquals(Polynomial.build("1 2 3 0 0 7"), p1.add(p3));
        assertEquals(Polynomial.build("6 2 3"), p1.add(p4));
        assertEquals(Polynomial.build("3/2 4 8"), p8.add(p7));
        assertEquals(Polynomial.build("1 -3/2 6 -5/3"), p6.add(p5));
        assertEquals(Polynomial.build("5 0 0 0 0 7"), p3.add(p4));
    }

    @Test
    void mul() {
        assertEquals(Polynomial.build("0 1 4 10 12 9"), p1.mul(p2));
        assertEquals(Polynomial.build("0 0 0 0 0 7 14 21"), p1.mul(p3));
        assertEquals(Polynomial.build("5 10 15"), p1.mul(p4));
        assertEquals(Polynomial.build("1/2 3 21/2 16 15"), p8.mul(p7));
        assertEquals(Polynomial.build("5 -10 15"), p4.mul(p5));
        assertEquals(Polynomial.build("0 0 0 0 0 35"), p3.mul(p4));
    }

    @Test
    void evaluate() {
        assertEquals(new IntegerScalar(6), p1.evaluate(new IntegerScalar(1)));
        assertEquals(new RationalScalar(15, 2), p8.evaluate(new IntegerScalar(1)));
        assertEquals(new RationalScalar(7168, 3125), p3.evaluate(new RationalScalar(4, 5)));
        assertEquals(new RationalScalar(1, 2), p8.evaluate(new IntegerScalar(0)));
    }

    @Test
    void derivative() {
        assertEquals(Polynomial.build("2 6"), p1.derivative());
        assertEquals(Polynomial.build("2 6"), p7.derivative());
        assertEquals(Polynomial.build("0"), p4.derivative());
        assertEquals(Polynomial.build("2 10"), p8.derivative());
        assertEquals(Polynomial.build("-2 6"), p5.derivative());
        assertEquals(Polynomial.build("1/2 6 -5"), p6.derivative());
        assertEquals(Polynomial.build("0"), p15.derivative());

    }

    @Test
    void testEquals() {
        assertEquals(true, p9.equals(p10.add(p11)));
        assertEquals(true, p1.equals(p1));
        assertEquals(true, p1.equals(p7));
        assertEquals(false, p1.equals(p5));
        assertEquals(true, p14.equals(p12.mul(p13)));
    }

    @Test
    void testToString() {
        assertEquals("x", p10.add(p11).toString());
        assertEquals("1/2+2x+5x^2", p8.toString());
        assertEquals("1+2x+3x^2", p7.toString());
        assertEquals("1+2x+3x^2", p1.toString());
        assertEquals("7x^5", p3.toString());
        assertEquals("5", p4.toString());
        assertEquals("-5x^2", p11.toString());
        assertEquals("1-2x+3x^2", p5.toString());
    }
}
