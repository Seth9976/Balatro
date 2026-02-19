package j0;

import a3.a;
import l0.b;
import p0.e;
import q0.r;

public final class v implements b {
    private final a a;
    private final a b;
    private final a c;
    private final a d;
    private final a e;

    public v(a a0, a a1, a a2, a a3, a a4) {
        this.a = a0;
        this.b = a1;
        this.c = a2;
        this.d = a3;
        this.e = a4;
    }

    public static v a(a a0, a a1, a a2, a a3, a a4) {
        return new v(a0, a1, a2, a3, a4);
    }

    public t b() {
        return v.c(((t0.a)this.a.get()), ((t0.a)this.b.get()), ((e)this.c.get()), ((r)this.d.get()), ((q0.v)this.e.get()));
    }

    public static t c(t0.a a0, t0.a a1, e e0, r r0, q0.v v0) {
        return new t(a0, a1, e0, r0, v0);
    }

    @Override  // a3.a
    public Object get() {
        return this.b();
    }
}

