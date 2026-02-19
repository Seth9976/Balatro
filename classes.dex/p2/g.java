package p2;

import java.math.BigDecimal;

public final class g extends Number {
    private final String e;

    public g(String s) {
        this.e = s;
    }

    @Override
    public double doubleValue() {
        return Double.parseDouble(this.e);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 instanceof g) {
            String s = ((g)object0).e;
            return this.e == s || this.e.equals(s);
        }
        return false;
    }

    @Override
    public float floatValue() {
        return Float.parseFloat(this.e);
    }

    @Override
    public int hashCode() {
        return this.e.hashCode();
    }

    @Override
    public int intValue() {
        try {
            return Integer.parseInt(this.e);
        }
        catch(NumberFormatException unused_ex) {
            try {
                return (int)Long.parseLong(this.e);
            }
            catch(NumberFormatException unused_ex) {
                return new BigDecimal(this.e).intValue();
            }
        }
    }

    @Override
    public long longValue() {
        try {
            return Long.parseLong(this.e);
        }
        catch(NumberFormatException unused_ex) {
            return new BigDecimal(this.e).longValue();
        }
    }

    @Override
    public String toString() {
        return this.e;
    }
}

