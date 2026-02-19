package j0;

import java.util.concurrent.Executor;
import l0.b;
import l0.d;

public final class k implements b {
    static abstract class a {
        private static final k a;

        static {
            a.a = new k();
        }
    }

    public static k a() {
        return a.a;
    }

    public static Executor b() {
        return (Executor)d.c(j.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Executor c() {
        return k.b();
    }

    @Override  // a3.a
    public Object get() {
        return this.c();
    }
}

