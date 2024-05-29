package Classes.Polinomials;


import Classes.Scalars.IntegerScalar;
import Classes.Scalars.RationalScalar;
import Classes.Scalars.Scalar;

import java.util.TreeMap;

import static java.lang.Integer.parseInt;

public class Polynomial {
    private TreeMap<Integer, Monomial> monomials;

    public Polynomial() {
        monomials = new TreeMap<>();
    }

    public Polynomial(TreeMap<Integer, Monomial> monomials) {
        this.monomials = new TreeMap<>();
        this.monomials.putAll(monomials);
    }

    public static Polynomial build(String input) {
        TreeMap<Integer, Monomial> monomials = new TreeMap<>();
        Integer key = 0;
        for (String str : input.split("\\s+")) {
            if (str.contains("/")) {
                String[] s = str.split("/");
                monomials.put(key, new Monomial(key, new RationalScalar(parseInt(s[0]), parseInt(s[1]))));
            } else {
                monomials.put(key, new Monomial(key, new IntegerScalar(parseInt(str))));
            }
            key++;
        }
        return new Polynomial(monomials);
    }

    public Polynomial add(Polynomial p) {
        TreeMap<Integer, Monomial> result, toAdd;
        if (this.monomials.size() < p.monomials.size()) {
            result = new TreeMap<>(p.monomials);
            toAdd = new TreeMap<>(this.monomials);
        } else {
            result = new TreeMap<>(this.monomials);
            toAdd = new TreeMap<>(p.monomials);
        }
        for (Integer key : toAdd.keySet()) {
            result.put(key, result.get(key).add(toAdd.get(key)));
        }
        return new Polynomial(result);
    }

    public Polynomial mul(Polynomial p) {
        TreeMap<Integer, Monomial> monomials = new TreeMap<>();
        Integer newKey = 0;
        for (Integer key1 : this.monomials.keySet()) {
            for (Integer key2 : p.monomials.keySet()) {
                Monomial m = this.monomials.get(key1).mul(p.monomials.get(key2));
                newKey = m.getExponent();
                if (monomials.containsKey(newKey)) {
                    monomials.put((newKey), monomials.get(newKey).add(m));
                } else {
                    monomials.put(newKey, m);
                }
            }
        }
        for (Integer i = 0; i < newKey; i++) {
            if (!monomials.containsKey(i)) {
                monomials.put(i, new Monomial(i, new IntegerScalar(0)));
            }
        }
        return new Polynomial(monomials);
    }

    public Scalar evaluate(Scalar s) {
        Scalar result = new RationalScalar(0, 1);
        for (Integer key : monomials.keySet()) {
            result = result.add(monomials.get(key).evaluate(s));
        }
        return result;
    }

    public Polynomial derivative() {
        TreeMap<Integer, Monomial> monomials = new TreeMap<>();
        for (Integer key : this.monomials.keySet()) {
            if (key != 0) {
                Monomial m = this.monomials.get(key).derivative();
                monomials.put(m.getExponent(), m);
            }
        }
        return new Polynomial(monomials);
    }

    public boolean equals(Object o) {
        if (o instanceof Polynomial) {
            Polynomial p = (Polynomial) o;
            return p.toString().equals(this.toString());
        }
        return false;
    }

    public String toString() {
        String result = "";
        for (Integer key : monomials.keySet()) {
            Monomial m = monomials.get(key);
            if (!m.getCoefficient().equals(new IntegerScalar(0))) {
                if (!result.equals("") && m.sign() == 1)
                    result += "+";
                result += m.toString();
            }
        }
        return result;
    }
}
