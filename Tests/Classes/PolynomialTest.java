package Classes;

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
        assertEquals(new RationalScalar(7168, 3125), p3.evaluate(new RationalScalar(4,5)));
        assertEquals(new RationalScalar(1, 2), p8.evaluate(new IntegerScalar(0)));
    }

    @Test
    void derivative() {
        assertEquals(Polynomial.build("2 6"), p1.derivative());
        assertEquals(Polynomial.build("2 6"), p7.derivative());
        assertEquals(Polynomial.build(" "), p4.derivative());
//        assertEquals(Polynomial.build("1 4 5"), p8.derivative());
        assertEquals(Polynomial.build("-2 6"), p5.derivative());
//        assertEquals(Polynomial.build("0"), p6.derivative());
    }

    @Test
    void testEquals() {
    }

    @Test
    void testToString() {
    }
}