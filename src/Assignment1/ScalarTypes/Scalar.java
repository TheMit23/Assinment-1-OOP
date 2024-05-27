package Assignment1.ScalarTypes;

public interface Scalar {
    public Scalar add(Scalar s);
    public Scalar mul(Scalar s);
    public Scalar neg();
    public Scalar power(int exponent);
    public int sign();
    public boolean equals(Object o);
    public Scalar addRational(RationalScalar s);
    public Scalar addInteger(IntegerScalar s);
    public Scalar mulInteger(IntegerScalar s);
    public Scalar mulRational(RationalScalar s);
}
