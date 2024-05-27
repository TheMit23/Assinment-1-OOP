package Assignment1.ScalarTypes;

public class IntegerScalar implements Scalar, Comparable<IntegerScalar>{
    private int number;

    public IntegerScalar(int number) {
        this.number = number;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    @Override
    public Scalar neg() {
        return this.mulInteger(new IntegerScalar(-1));
    }

    @Override
    public Scalar power(int exponent) {
        return new IntegerScalar((int) Math.pow(getNumber(), exponent));
    }

    @Override
    public int sign() {
        if (number > 0) {
            return 1;
        } else if (number < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        boolean equal = false;
        if (o instanceof RationalScalar) {
            return ((RationalScalar) o).equals(this);
        }
        if (o instanceof IntegerScalar) {
            return ((IntegerScalar) o).number == number;
        }
        return false;
    }

    public String toString() {
        return "" + number;
    }

    public int compareTo(IntegerScalar s) {
        return Integer.compare(this.number, s.getNumber());
    }

    @Override
    public Scalar addRational(RationalScalar s) {
        return s.addInteger(this);
    }

    @Override
    public Scalar addInteger(IntegerScalar s) {
        return new IntegerScalar(this.getNumber() + s.getNumber());
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        return new IntegerScalar(this.number * s.getNumber());
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        return s.mulInteger(this);
    }

    public int getNumber() {
        return this.number;
    }


}
