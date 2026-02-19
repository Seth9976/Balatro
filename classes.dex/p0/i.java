package p0;

import a3.a;
import android.content.Context;
import l0.b;
import q0.f;
import q0.x;
import r0.d;

public final class i implements b {
    private final a a;
    private final a b;
    private final a c;
    private final a d;

    public i(a a0, a a1, a a2, a a3) {
        this.a = a0;
        this.b = a1;
        this.c = a2;
        this.d = a3;
    }

    public static i a(a a0, a a1, a a2, a a3) {
        return new i(a0, a1, a2, a3);
    }

    public x b() {
        return i.c(((Context)this.a.get()), ((d)this.b.get()), ((f)this.c.get()), ((t0.a)this.d.get()));
    }

    public static x c(Context context0, d d0, f f0, t0.a a0) {
        return (x)l0.d.c(h.a(context0, d0, f0, a0), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override  // a3.a
    public Object get() {
        return this.b();
    }
}

