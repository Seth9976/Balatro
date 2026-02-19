package n3;

import c3.v;
import e3.c;
import java.util.Iterator;
import k3.d;

public class a implements Iterable {
    public static final class n3.a.a {
        private n3.a.a() {
        }

        public n3.a.a(d d0) {
        }

        public final a a(int v, int v1, int v2) {
            return new a(v, v1, v2);
        }
    }

    private final int e;
    private final int f;
    private final int g;
    public static final n3.a.a h;

    static {
        a.h = new n3.a.a(null);
    }

    public a(int v, int v1, int v2) {
        switch(v2) {
            case 0x80000000: {
                throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            }
            case 0: {
                throw new IllegalArgumentException("Step must be non-zero.");
            }
            default: {
                this.e = v;
                this.f = c.b(v, v1, v2);
                this.g = v2;
            }
        }
    }

    public final int e() {
        return this.e;
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof a && (this.isEmpty() && ((a)object0).isEmpty() || this.e == ((a)object0).e && this.f == ((a)object0).f && this.g == ((a)object0).g);
    }

    // 去混淆评级： 低(20)
    @Override
    public int hashCode() {
        return this.isEmpty() ? -1 : (this.e * 0x1F + this.f) * 0x1F + this.g;
    }

    public boolean isEmpty() {
        return this.g <= 0 ? this.e < this.f : this.e > this.f;
    }

    @Override
    public Iterator iterator() {
        return this.p();
    }

    public final int n() {
        return this.f;
    }

    public final int o() {
        return this.g;
    }

    public v p() {
        return new b(this.e, this.f, this.g);
    }

    @Override
    public String toString() {
        int v;
        StringBuilder stringBuilder0;
        if(this.g > 0) {
            stringBuilder0 = new StringBuilder();
            stringBuilder0.append(this.e);
            stringBuilder0.append("..");
            stringBuilder0.append(this.f);
            stringBuilder0.append(" step ");
            v = this.g;
        }
        else {
            stringBuilder0 = new StringBuilder();
            stringBuilder0.append(this.e);
            stringBuilder0.append(" downTo ");
            stringBuilder0.append(this.f);
            stringBuilder0.append(" step ");
            v = -this.g;
        }
        stringBuilder0.append(v);
        return stringBuilder0.toString();
    }
}

