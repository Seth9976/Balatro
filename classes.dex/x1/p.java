package x1;

import android.content.Context;
import c1.c;
import c1.j;
import com.google.android.gms.common.api.Status;
import d1.a.a;
import d1.a.d;
import d1.a.g;
import d1.e;
import g2.h;
import g2.k;
import w0.b;

public final class p extends e implements b {
    private final Context k;
    private final j l;
    private static final g m;
    private static final a n;
    private static final d1.a o;

    static {
        g a$g0 = new g();
        p.m = a$g0;
        n n0 = new n();
        p.n = n0;
        p.o = new d1.a("AppSet.API", n0, a$g0);
    }

    p(Context context0, j j0) {
        super(context0, p.o, d.a, d1.e.a.c);
        this.k = context0;
        this.l = j0;
    }

    @Override  // w0.b
    public final h b() {
        return this.l.g(this.k, 212800000) == 0 ? this.g(com.google.android.gms.common.api.internal.d.a().d(new c[]{w0.h.a}).b(new m(this)).c(false).e(27601).a()) : k.a(new d1.b(new Status(17)));
    }
}

