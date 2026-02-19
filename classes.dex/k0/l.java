package k0;

import a3.a;
import android.content.Context;
import l0.b;

public final class l implements b {
    private final a a;
    private final a b;

    public l(a a0, a a1) {
        this.a = a0;
        this.b = a1;
    }

    public static l a(a a0, a a1) {
        return new l(a0, a1);
    }

    public k b() {
        return l.c(((Context)this.a.get()), this.b.get());
    }

    public static k c(Context context0, Object object0) {
        return new k(context0, ((i)object0));
    }

    @Override  // a3.a
    public Object get() {
        return this.b();
    }
}

