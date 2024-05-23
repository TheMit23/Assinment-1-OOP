package Assignment1;

public class Integer implements Scalar {
    private int number;

    public Integer(int number) {
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
        return this.mulInteger(new Integer(-1));
    }

    @Override
    public Scalar power(int exponent) {
        return new Integer((int) Math.pow(getNumber(), exponent));
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
        boolean equal=false;
        if(o instanceof Rational){
            return ((Rational)o).equals(this);
        }
        if(o instanceof Integer){
            return ((Integer) o).number==number;
        }
    }

    public String toString() {
        return ""+number;
    }



    @Override
    public Scalar addRational(Rational s) {
        return s.addInteger(this);
    }

    @Override
    public Scalar addInteger(Integer s) {
        return new Integer(this.getNumber() + s.getNumber());
    }

    @Override
    public Scalar mulInteger(Integer s) {
        return new Integer(this.number * s.getNumber());
    }

    @Override
    public Scalar mulRational(Rational s) {
        return s.mulInteger(this);
    }

    public int getNumber() {
        return this.number;
    }


}
