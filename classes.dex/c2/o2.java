package c2;

import android.content.Context;
import com.google.android.gms.common.api.internal.d;
import d1.a.a;
import d1.a.g;
import d1.e;
import g2.h;

final class o2 extends e implements k2 {
    private static final g k;
    private static final a l;
    private static final d1.a m;

    static {
        g a$g0 = new g();
        o2.k = a$g0;
        m2 m20 = new m2();
        o2.l = m20;
        o2.m = new d1.a("GamesConnect.API", m20, a$g0);
    }

    o2(Context context0, i2 i20) {
        super(context0, o2.m, i20, d1.e.a.c);
    }

    @Override  // c2.k2
    public final h c(q2 q20, boolean z) {
        d d0 = d.a().b(new l2(this, q20)).e(6737).c(z).a();
        return z ? this.i(d0) : this.f(d0);
    }
}

