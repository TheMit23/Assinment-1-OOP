package Assignment1;


public class Rational implements Scalar {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational reduce() {
        int a=numerator;
        int b=denominator;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        if(denominator<0){
            this.numerator = this.numerator*(-1);
            this.denominator = this.denominator*(-1);
        }
        return new Rational(numerator/a,denominator/a);
    }

    public String toString() {
        return null;//need to do
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
        return this.mulInteger(new Integer(-1));
    }

    @Override
    public Scalar power(int exponent) {
        int newNumerator = (int) Math.pow(getNumerator(), exponent);
        int newDenominator = (int) Math.pow(getNumerator(), exponent);
        return new Rational(newNumerator, newDenominator);

    }

    @Override
    public int sign() {
        if (numerator*denominator>0) {
            return 1;
        } else if (numerator*denominator < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        Rational rational =new Rational(this.reduce());
        if(o instanceof Rational){
            Rational other =new Rational((Rational) o.reduce());
            if(other.getDenominator()==rational.getDenominator()&other.getNumerator()==rational.getNumerator()){
                return true;
            }
            return false;
        }
        if(o instanceof Integer){

            Rational other =new Rational(((Integer) o).getNumber(),1);
            if(other.getDenominator()==rational.getDenominator()&other.getNumerator()==rational.getNumerator()){
                return true;
            }
            return false;
        }
    }

    @Override
    public Scalar addRational(Rational s) {
        int newNumerator = s.getDenominator() * this.numerator + s.getNumerator() * this.getDenominator();
        int newDenominator = s.getDenominator() * this.getDenominator();
        return new Rational(newNumerator, newDenominator);

    }

    @Override
    public Scalar addInteger(Integer s) {
        int newNumerator = s.getNumber() * denominator + numerator;
        return new Rational(newNumerator, denominator);
    }

    @Override
    public Scalar mulInteger(Integer s) {
        int newNumerator = s.getNumber() * numerator;
        return new Rational(newNumerator, denominator);

    }

    @Override
    public Scalar mulRational(Rational s) {
        int newNumerator = this.numerator * s.getNumerator();
        int newDenominator = s.getDenominator() * this.getDenominator();
        return new Rational(newNumerator, newDenominator);

    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
