package Assignment1;

public interface Scalar {
    Scalar add(Scalar s);
    Scalar mul(Scalar s);
    Scalar neg();
    Scalar power(int exponent);
    int sign();
    boolean equals(Object o);
    Scalar addRational(Rational s);
    Scalar addInteger(Integer s);
    Scalar mulInteger(Integer s);
    Scalar mulRational(Rational s);
}
