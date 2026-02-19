package p0;

import a3.a;
import l0.b;
import l0.d;
import q0.f;

public final class g implements b {
    private final a a;

    public g(a a0) {
        this.a = a0;
    }

    public static f a(t0.a a0) {
        return (f)d.c(p0.f.a(a0), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g b(a a0) {
        return new g(a0);
    }

    public f c() {
        return g.a(((t0.a)this.a.get()));
    }

    @Override  // a3.a
    public Object get() {
        return this.c();
    }
}

