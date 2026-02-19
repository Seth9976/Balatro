package g1;

import com.google.android.gms.common.api.Status;
import d1.b;
import d1.g.a;
import d1.g;
import d1.k;
import g2.i;
import java.util.concurrent.TimeUnit;

final class j0 implements a {
    final g a;
    final i b;
    final g1.p.a c;
    final l0 d;

    j0(g g0, i i0, g1.p.a p$a0, l0 l00) {
        this.a = g0;
        this.b = i0;
        this.c = p$a0;
        this.d = l00;
        super();
    }

    @Override  // d1.g$a
    public final void a(Status status0) {
        if(status0.o0()) {
            k k0 = this.a.d(0L, TimeUnit.MILLISECONDS);
            Object object0 = this.c.a(k0);
            this.b.c(object0);
            return;
        }
        b b0 = g1.b.a(status0);
        this.b.b(b0);
    }
}

