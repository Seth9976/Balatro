package c2;

import d1.a.d;
import g1.o;

public final class i2 implements d {
    public final int e;
    public final String f;

    i2(int v, String s, h2 h20) {
        this.e = v;
        this.f = s;
    }

    public static a2 a() {
        return new a2(null);
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        if(object0 == this) {
            return true;
        }
        return object0 instanceof i2 ? this.e == ((i2)object0).e && o.a(this.f, ((i2)object0).f) : false;
    }

    @Override
    public final int hashCode() {
        return o.b(new Object[]{this.e, this.f});
    }
}

