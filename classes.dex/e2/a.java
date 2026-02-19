package e2;

import d1.a.d;
import g1.o;

public final class a implements d {
    private final boolean e;
    private final boolean f;
    private final String g;
    private final boolean h;
    private final String i;
    private final String j;
    private final boolean k;
    private final Long l;
    private final Long m;
    public static final a n;

    static {
        a.n = new a(false, false, null, false, null, null, false, null, null, null);
    }

    a(boolean z, boolean z1, String s, boolean z2, String s1, String s2, boolean z3, Long long0, Long long1, f f0) {
        this.e = false;
        this.f = false;
        this.g = null;
        this.h = false;
        this.k = false;
        this.i = null;
        this.j = null;
        this.l = null;
        this.m = null;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof a)) {
            return false;
        }
        a a0 = (a)object0;
        return o.a(null, null) && o.a(null, null) && o.a(null, null) && o.a(null, null) && o.a(null, null);
    }

    @Override
    public final int hashCode() {
        return o.b(new Object[]{Boolean.FALSE, Boolean.FALSE, null, Boolean.FALSE, Boolean.FALSE, null, null, null, null});
    }
}

