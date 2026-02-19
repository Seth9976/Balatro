package q0;

import a3.a;
import java.util.concurrent.Executor;
import l0.b;
import r0.d;

public final class w implements b {
    private final a a;
    private final a b;
    private final a c;
    private final a d;

    public w(a a0, a a1, a a2, a a3) {
        this.a = a0;
        this.b = a1;
        this.c = a2;
        this.d = a3;
    }

    public static w a(a a0, a a1, a a2, a a3) {
        return new w(a0, a1, a2, a3);
    }

    public v b() {
        return w.c(((Executor)this.a.get()), ((d)this.b.get()), ((x)this.c.get()), ((s0.b)this.d.get()));
    }

    public static v c(Executor executor0, d d0, x x0, s0.b b0) {
        return new v(executor0, d0, x0, b0);
    }

    @Override  // a3.a
    public Object get() {
        return this.b();
    }
}

