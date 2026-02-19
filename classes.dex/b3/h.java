package b3;

import java.io.Serializable;
import k3.f;

public final class h implements Serializable {
    private final Object e;
    private final Object f;

    public h(Object object0, Object object1) {
        this.e = object0;
        this.f = object1;
    }

    public final Object a() {
        return this.e;
    }

    public final Object b() {
        return this.f;
    }

    public final Object c() {
        return this.e;
    }

    public final Object d() {
        return this.f;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h)) {
            return false;
        }
        return f.a(this.e, ((h)object0).e) ? f.a(this.f, ((h)object0).f) : false;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.e == null ? 0 : this.e.hashCode();
        Object object0 = this.f;
        if(object0 != null) {
            v = object0.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    public String toString() {
        return '(' + this.e + ", " + this.f + ')';
    }
}

