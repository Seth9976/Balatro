package t0;

import l0.b;
import l0.d;

public final class c implements b {
    static abstract class a {
        private static final c a;

        static {
            a.a = new c();
        }
    }

    public static c a() {
        return a.a;
    }

    public static t0.a b() {
        return (t0.a)d.c(t0.b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public t0.a c() {
        return c.b();
    }

    @Override  // a3.a
    public Object get() {
        return this.c();
    }
}

