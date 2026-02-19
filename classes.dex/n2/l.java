package n2;

import java.math.BigInteger;
import java.util.Objects;

public final class l extends g {
    private final Object e;

    public l(Boolean boolean0) {
        Objects.requireNonNull(boolean0);
        this.e = boolean0;
    }

    public l(Number number0) {
        Objects.requireNonNull(number0);
        this.e = number0;
    }

    public l(String s) {
        Objects.requireNonNull(s);
        this.e = s;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            if(l.class == class0) {
                if(this.e == null) {
                    return ((l)object0).e == null;
                }
                if(l.x(this) && l.x(((l)object0))) {
                    return this.u().longValue() == ((l)object0).u().longValue();
                }
                Object object1 = this.e;
                if(object1 instanceof Number && ((l)object0).e instanceof Number) {
                    double f = this.u().doubleValue();
                    double f1 = ((l)object0).u().doubleValue();
                    return f == f1 || Double.isNaN(f) && Double.isNaN(f1);
                }
                return object1.equals(((l)object0).e);
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        long v;
        if(this.e == null) {
            return 0x1F;
        }
        if(l.x(this)) {
            v = this.u().longValue();
            return (int)(v >>> 0x20 ^ v);
        }
        Object object0 = this.e;
        if(object0 instanceof Number) {
            v = Double.doubleToLongBits(this.u().doubleValue());
            return (int)(v >>> 0x20 ^ v);
        }
        return object0.hashCode();
    }

    // 去混淆评级： 低(20)
    public boolean t() {
        return this.w() ? ((Boolean)this.e).booleanValue() : Boolean.parseBoolean(this.v());
    }

    public Number u() {
        Object object0 = this.e;
        if(object0 instanceof Number) {
            return (Number)object0;
        }
        if(!(object0 instanceof String)) {
            throw new UnsupportedOperationException("Primitive is neither a number nor a string");
        }
        return new p2.g(((String)object0));
    }

    public String v() {
        Object object0 = this.e;
        if(object0 instanceof String) {
            return (String)object0;
        }
        if(this.y()) {
            return this.u().toString();
        }
        if(!this.w()) {
            throw new AssertionError("Unexpected value type: " + this.e.getClass());
        }
        return ((Boolean)this.e).toString();
    }

    public boolean w() {
        return this.e instanceof Boolean;
    }

    // 去混淆评级： 中等(60)
    private static boolean x(l l0) {
        return l0.e instanceof Number && (((Number)l0.e) instanceof BigInteger || ((Number)l0.e) instanceof Long || ((Number)l0.e) instanceof Integer || ((Number)l0.e) instanceof Short || ((Number)l0.e) instanceof Byte);
    }

    public boolean y() {
        return this.e instanceof Number;
    }

    public boolean z() {
        return this.e instanceof String;
    }
}

