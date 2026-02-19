package c2;

import android.app.Activity;
import android.app.Application;
import g2.h;
import g2.i;
import m1.b;
import q1.q;

final class g0 implements d0 {
    private final Application a;
    private final q b;
    private final n c;

    g0(Application application0, q q0, n n0) {
        this.a = application0;
        this.b = q0;
        this.c = n0;
    }

    @Override  // c2.d0
    public final h a(q2 q20) {
        boolean z = q20.a() == 0 && !b.a(this.a);
        h h0 = this.c().c(q20, z);
        i i0 = new i();
        h0.l(f2.a(), (h h0) -> {
            if(!h0.q()) {
                Exception exception0 = h0.m();
                if(exception0 instanceof d1.b && ((d1.b)exception0).b() == 20) {
                    f1.a("GamesAuthenticator", "Service connection suspended during the first sign-in attempt. Trying again.");
                    return this.c().c(q20, z);
                }
            }
            return h0;
        }).d(f2.a(), new f0(i0));
        return i0.a();
    }

    // 检测为 Lambda 实现
    final h b(q2 q20, boolean z, h h0) [...]

    private final k2 c() {
        Activity activity0 = this.b.a();
        return activity0 == null ? j2.a(this.c.a, this.c.b) : j2.a(activity0, this.c.b);
    }
}

