package Assignment1;


import java.util.TreeMap;

import static java.lang.Integer.parseInt;

public class Polynomial {
    private TreeMap<IntegerScalar, Monomial> monomials;

    public Polynomial() {
        monomials = new TreeMap<>();
    }

    public Polynomial(TreeMap<IntegerScalar, Monomial> monomials) {
        this.monomials = monomials;
    }

    static Polynomial build(String input) {
        TreeMap<IntegerScalar, Monomial> monomials = new TreeMap<>();
        IntegerScalar key = new IntegerScalar(0);
        for (String str : input.split("\\s+")) {
            if (str.contains("/")) {
                String[] s = str.split("/");
                monomials.put(key, new Monomial(key.getNumber(), new RationalScalar(parseInt(s[0]), parseInt(s[1]))));
            } else if (!str.equals("0")) {
                monomials.put(key, new Monomial(key.getNumber(), new IntegerScalar(parseInt(str))));
            }
            key.add(new IntegerScalar(1));
        }
        return new Polynomial(monomials);
    }

    public Polynomial add(Polynomial p) {
        TreeMap<IntegerScalar, Monomial> monomials = new TreeMap<>();
        for (IntegerScalar key : this.monomials.keySet()) {
            if (p.monomials.containsKey(key)) {
                Monomial m = this.monomials.get(key).add(p.monomials.get(key));
                monomials.put(key, m);
            } else {
                monomials.put(key, this.monomials.get(key));
            }
        }
        for (IntegerScalar key : p.monomials.keySet()) {
            if (!this.monomials.containsKey(key)) {
                monomials.put(key, p.monomials.get(key));
            }
        }
        return new Polynomial(monomials);
    }

    public Polynomial mul(Polynomial p) {
        TreeMap<IntegerScalar, Monomial> monomials = new TreeMap<>();
        for (IntegerScalar key1 : this.monomials.keySet()) {
            for (IntegerScalar key2 : p.monomials.keySet()) {
                Monomial m = this.monomials.get(key1).mul(p.monomials.get(key2));
                IntegerScalar newKey = new IntegerScalar(key1.getNumber() + key2.getNumber());
                if (monomials.containsKey(newKey)) {
                    monomials.put((newKey), monomials.get(newKey).add(m));
                } else {
                    monomials.put(newKey, m);
                }
            }
        }
        return new Polynomial(monomials);
    }

    public Scalar evaluate(Scalar s) {
        Scalar result = new IntegerScalar(0);
        for (IntegerScalar key : monomials.keySet()) {
            result = result.add(monomials.get(key).evaluate(s));
        }
        return result;
    }

    public Polynomial derivative() {
        TreeMap<IntegerScalar, Monomial> monomials = new TreeMap<>();
        for (IntegerScalar key : this.monomials.keySet()) {
            Monomial m = this.monomials.get(key).derivative();
            if (!m.equals(new Monomial(0, new IntegerScalar(0)))) {
                monomials.put(new IntegerScalar(key.getNumber() - 1), m);
            }
        }
        return new Polynomial(monomials);
    }

    public boolean equals(Object o) {
        if (o instanceof Polynomial) {
            Polynomial p = (Polynomial) o;
            if (this.monomials.size() != p.monomials.size()) {
                return false;
            } else {
                for (IntegerScalar key : this.monomials.keySet()) {
                    if (!p.monomials.containsKey(key)) {
                        return false;
                    }
                    if (!this.monomials.get(key).equals(p.monomials.get(key))) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }

    public String toString() {
        String result = "";
        for (IntegerScalar key : monomials.keySet()) {
            result += monomials.get(key).toString() + " ";
        }
        return result;
    }
}
