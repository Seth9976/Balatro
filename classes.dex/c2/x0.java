package c2;

import e1.j;
import g1.q;
import q1.d;
import q1.i;
import v1.a;
import v1.b;

public final class x0 implements j {
    public final a a;

    public x0(a a0) {
        this.a = a0;
    }

    @Override  // e1.j
    public final void a(Object object0, Object object1) {
        b b0 = this.a.Z();
        q.l(!b0.u(), "Snapshot already closed");
        n1.a a0 = b0.a();
        b0.b();
        ((i)((d)object0).C()).h0(a0);
        ((g2.i)object1).c(null);
    }
}

