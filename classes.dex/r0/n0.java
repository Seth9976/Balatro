package r0;

import a3.a;
import l0.b;

public final class n0 implements b {
    private final a a;
    private final a b;
    private final a c;
    private final a d;
    private final a e;

    public n0(a a0, a a1, a a2, a a3, a a4) {
        this.a = a0;
        this.b = a1;
        this.c = a2;
        this.d = a3;
        this.e = a4;
    }

    public static n0 a(a a0, a a1, a a2, a a3, a a4) {
        return new n0(a0, a1, a2, a3, a4);
    }

    public m0 b() {
        return n0.c(((t0.a)this.a.get()), ((t0.a)this.b.get()), this.c.get(), this.d.get(), this.e);
    }

    public static m0 c(t0.a a0, t0.a a1, Object object0, Object object1, a a2) {
        return new m0(a0, a1, ((e)object0), ((t0)object1), a2);
    }

    @Override  // a3.a
    public Object get() {
        return this.b();
    }
}

