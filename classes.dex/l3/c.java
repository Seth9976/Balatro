package l3;

import e3.b;
import java.io.Serializable;
import k3.d;

public abstract class c {
    public static final class a extends c implements Serializable {
        private a() {
        }

        public a(d d0) {
        }

        @Override  // l3.c
        public int b() {
            return c.f.b();
        }
    }

    public static final a e;
    private static final c f;

    static {
        c.e = new a(null);
        c.f = b.a.b();
    }

    public abstract int b();
}

