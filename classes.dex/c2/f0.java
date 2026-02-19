package c2;

import d1.b;
import g2.d;
import g2.h;
import g2.i;

public final class f0 implements d {
    public final i a;

    public f0(i i0) {
        this.a = i0;
    }

    @Override  // g2.d
    public final void a(h h0) {
        i i0 = this.a;
        if(h0.q()) {
            i0.e(h0.c(((s2)h0.n()).a()));
            return;
        }
        Exception exception0 = h0.m();
        if(!(exception0 instanceof b)) {
            p1.a(exception0);
            i0.d(exception0);
            return;
        }
        i0.e(h0.b(((b)exception0).a()));
    }
}

