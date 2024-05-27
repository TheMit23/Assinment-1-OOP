package Assignment1;



public class RationalScalar implements Scalar {
    private int numerator;
    private int denominator;

    public RationalScalar(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }

    public RationalScalar reduce() {
        int a = numerator;
        int b = denominator;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        this.numerator = this.numerator / a;
        this.denominator = this.denominator / a;
        if (denominator < 0) {
            this.numerator = this.numerator * (-1);
            this.denominator = this.denominator * (-1);
        }
        return this;
    }

    public String toString() {
        if (denominator == 1) {
            return "" + numerator;
        }
        return numerator + "/" + denominator;
    }

    @Override
    public Scalar add(Scalar s) {
        return null;
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulRational(this);
    }

    @Override
    public Scalar neg() {
        return this.mulInteger(new IntegerScalar(-1));
    }

    @Override
    public Scalar power(int exponent) {
        int newNumerator = (int) Math.pow(getNumerator(), exponent);
        int newDenominator = (int) Math.pow(getNumerator(), exponent);
        return new RationalScalar(newNumerator, newDenominator);

    }

    @Override
    public int sign() {
        if (numerator * denominator > 0) {
            return 1;
        } else if (numerator * denominator < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RationalScalar) {
            if (((RationalScalar) o).getDenominator() == this.getDenominator() && ((RationalScalar) o).getNumerator() == this.getNumerator()) {
                return true;
            }
        }
        if (o instanceof IntegerScalar) {
            if ((this.getDenominator() == 1) && ((IntegerScalar) o).getNumber() == this.getNumerator()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Scalar addRational(RationalScalar s) {
        int newNumerator = s.getDenominator() * this.numerator + s.getNumerator() * this.getDenominator();
        int newDenominator = s.getDenominator() * this.getDenominator();
        return new RationalScalar(newNumerator, newDenominator);

    }

    @Override
    public Scalar addInteger(IntegerScalar s) {
        int newNumerator = s.getNumber() * denominator + numerator;
        return new RationalScalar(newNumerator, denominator);
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        int newNumerator = s.getNumber() * numerator;
        return new RationalScalar(newNumerator, denominator);

    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        int newNumerator = this.numerator * s.getNumerator();
        int newDenominator = s.getDenominator() * this.getDenominator();
        return new RationalScalar(newNumerator, newDenominator);

    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
