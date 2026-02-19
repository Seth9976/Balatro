package q1;

import com.google.android.gms.common.data.DataHolder;
import g2.i;
import p1.f0;
import p1.h;
import p1.r.b;
import v1.d;
import v1.f;

final class c extends a {
    private final i a;

    c(i i0) {
        this.a = i0;
    }

    @Override  // q1.a
    public final void y(DataHolder dataHolder0, n1.a a0) {
        d d0;
        int v;
        v = dataHolder0.n0();
        try(f f0 = new f(dataHolder0)) {
            d0 = f0.getCount() > 0 ? new d(new v1.i(f0.n(0)), new v1.c(a0)) : null;
        }
        switch(v) {
            case 0: {
                p1.r.a r$a0 = new p1.r.a(d0, null);
                this.a.c(r$a0);
                return;
            }
            case 4002: {
                if(d0 != null && d0.t() != null) {
                    p1.r.c r$c0 = new p1.r.c(f0.a(4002), d0.t());
                    this.a.b(r$c0);
                    return;
                }
                v = 4002;
            }
        }
        h.a(this.a, v);
    }

    @Override  // q1.a
    public final void z(DataHolder dataHolder0, String s, n1.a a0, n1.a a1, n1.a a2) {
        d d1;
        d d0;
        try(f f0 = new f(dataHolder0)) {
            if(f0.getCount() < 2 || s == null || a2 == null) {
                this.a.c(null);
                return;
            }
            d0 = new d(new v1.i(f0.n(0)), new v1.c(a0));
            d1 = new d(new v1.i(f0.n(1)), new v1.c(a1));
        }
        p1.r.a r$a0 = new p1.r.a(null, new b(d0, s, d1, new v1.c(a2)));
        this.a.c(r$a0);
    }
}

