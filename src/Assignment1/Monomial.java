package Assignment1;


public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    public Monomial add(Monomial m) {
        if (this.exponent == m.exponent) {
            return new Monomial(this.exponent, this.coefficient.add(m.coefficient));
        } else {
            return null;
        }
    }

    public Monomial mul(Monomial m) {
        return new Monomial(this.exponent + m.exponent, this.coefficient.mul(m.coefficient));
    }

    public Scalar evaluate(Scalar s) {
        return this.coefficient.mul(s.power(this.exponent));
    }

    public Monomial derivative() {
        if (this.exponent == 0) {
            return new Monomial(0, new IntegerScalar(0));
        }
        return new Monomial(this.exponent - 1, this.coefficient.mul(new IntegerScalar(this.exponent)));
    }

    public int sign() {
        return coefficient.sign();
    }

    public boolean equals(Object o) {
        if (o instanceof Monomial) {
            Monomial m = (Monomial) o;
            return this.exponent == m.exponent && this.coefficient.equals(m.coefficient);
        }
        return false;
    }

    public int getExponent() {
        return exponent;
    }

    public String toString() {
        if (coefficient.equals(new IntegerScalar(0))) {
            return "0";
        }
        if (exponent == 0) {
            return coefficient.toString();
        }
        if (exponent == 1) {
            return coefficient.toString() + "x";
        }
        if (coefficient.equals(new IntegerScalar(1))) {
            return "x^" + exponent;
        }
        if (coefficient.equals(new IntegerScalar(-1))) {
            return "-x^" + exponent;
        }
        return coefficient.toString() + "x^" + exponent;
    }
}
