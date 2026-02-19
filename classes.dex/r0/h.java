package r0;

import a3.a;
import android.content.Context;
import l0.b;
import l0.d;

public final class h implements b {
    private final a a;

    public h(a a0) {
        this.a = a0;
    }

    public static h a(a a0) {
        return new h(a0);
    }

    public String b() {
        return h.c(((Context)this.a.get()));
    }

    public static String c(Context context0) {
        return (String)d.c(f.b(context0), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override  // a3.a
    public Object get() {
        return this.b();
    }
}

