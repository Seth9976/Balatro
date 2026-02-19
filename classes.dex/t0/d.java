package t0;

import l0.b;

public final class d implements b {
    static abstract class a {
        private static final d a;

        static {
            a.a = new d();
        }
    }

    public static d a() {
        return a.a;
    }

    public t0.a b() {
        return d.c();
    }

    public static t0.a c() {
        return (t0.a)l0.d.c(t0.b.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override  // a3.a
    public Object get() {
        return this.b();
    }
}

