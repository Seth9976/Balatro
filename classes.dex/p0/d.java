package p0;

import a3.a;
import java.util.concurrent.Executor;
import k0.e;
import l0.b;
import q0.x;

public final class d implements b {
    private final a a;
    private final a b;
    private final a c;
    private final a d;
    private final a e;

    public d(a a0, a a1, a a2, a a3, a a4) {
        this.a = a0;
        this.b = a1;
        this.c = a2;
        this.d = a3;
        this.e = a4;
    }

    public static d a(a a0, a a1, a a2, a a3, a a4) {
        return new d(a0, a1, a2, a3, a4);
    }

    public c b() {
        return d.c(((Executor)this.a.get()), ((e)this.b.get()), ((x)this.c.get()), ((r0.d)this.d.get()), ((s0.b)this.e.get()));
    }

    public static c c(Executor executor0, e e0, x x0, r0.d d0, s0.b b0) {
        return new c(executor0, e0, x0, d0, b0);
    }

    @Override  // a3.a
    public Object get() {
        return this.b();
    }
}

