package k0;

import a3.a;
import android.content.Context;
import l0.b;

public final class j implements b {
    private final a a;
    private final a b;
    private final a c;

    public j(a a0, a a1, a a2) {
        this.a = a0;
        this.b = a1;
        this.c = a2;
    }

    public static j a(a a0, a a1, a a2) {
        return new j(a0, a1, a2);
    }

    public i b() {
        return j.c(((Context)this.a.get()), ((t0.a)this.b.get()), ((t0.a)this.c.get()));
    }

    public static i c(Context context0, t0.a a0, t0.a a1) {
        return new i(context0, a0, a1);
    }

    @Override  // a3.a
    public Object get() {
        return this.b();
    }
}

