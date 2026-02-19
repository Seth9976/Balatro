package i1;

import android.content.Context;
import d1.a.a;
import d1.a.g;
import d1.e;
import g1.t;
import g1.v;
import g1.w;
import g2.h;

public final class d extends e implements v {
    private static final g k;
    private static final a l;
    private static final d1.a m;
    public static final int n;

    static {
        g a$g0 = new g();
        d.k = a$g0;
        c c0 = new c();
        d.l = c0;
        d.m = new d1.a("ClientTelemetry.API", c0, a$g0);
    }

    public d(Context context0, w w0) {
        super(context0, d.m, w0, d1.e.a.c);
    }

    @Override  // g1.v
    public final h a(t t0) {
        com.google.android.gms.common.api.internal.d.a d$a0 = com.google.android.gms.common.api.internal.d.a();
        d$a0.d(new c1.c[]{a2.d.a});
        d$a0.c(false);
        d$a0.b(new b(t0));
        return this.f(d$a0.a());
    }
}

