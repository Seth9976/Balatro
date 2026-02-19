package r0;

import l0.b;
import l0.d;

public final class j implements b {
    static abstract class a {
        private static final j a;

        static {
            a.a = new j();
        }
    }

    public static j a() {
        return a.a;
    }

    public e b() {
        return j.c();
    }

    public static e c() {
        return (e)d.c(f.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override  // a3.a
    public Object get() {
        return this.b();
    }
}

