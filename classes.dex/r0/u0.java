package r0;

import a3.a;
import android.content.Context;
import l0.b;

public final class u0 implements b {
    private final a a;
    private final a b;
    private final a c;

    public u0(a a0, a a1, a a2) {
        this.a = a0;
        this.b = a1;
        this.c = a2;
    }

    public static u0 a(a a0, a a1, a a2) {
        return new u0(a0, a1, a2);
    }

    public t0 b() {
        return u0.c(((Context)this.a.get()), ((String)this.b.get()), ((int)(((Integer)this.c.get()))));
    }

    public static t0 c(Context context0, String s, int v) {
        return new t0(context0, s, v);
    }

    @Override  // a3.a
    public Object get() {
        return this.b();
    }
}

