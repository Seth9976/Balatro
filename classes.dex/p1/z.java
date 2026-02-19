package p1;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import d1.a.a;
import d1.a.f;
import d1.f.b;
import g1.e;
import q1.d;
import q1.k;
import q1.q;

abstract class z extends a {
    z(y y0) {
    }

    @Override  // d1.a$a
    public final f a(Context context0, Looper looper0, e e0, Object object0, d1.f.a f$a0, b f$b0) {
        d0 d00 = (d0)object0;
        if(d00 == null) {
            d00 = new b0(null).e();
        }
        f a$f0 = new d(context0, looper0, e0, d00, f$a0, f$b0, k.a());
        if(d00.t.c()) {
            ((d)a$f0).n0(q.b(((Application)context0.getApplicationContext())));
        }
        return a$f0;
    }
}

