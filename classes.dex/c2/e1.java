package c2;

import p1.r;
import v1.a;
import v1.b;
import v1.g;

public final class e1 implements r {
    private final h a;

    public e1(h h0) {
        this.a = h0;
    }

    @Override  // p1.r
    public final g2.h a(a a0) {
        y0 y00 = new y0(a0);
        return this.a.b(y00);
    }

    @Override  // p1.r
    public final g2.h b(a a0, g g0) {
        d1 d10 = new d1(a0, g0);
        return this.a.b(d10);
    }

    @Override  // p1.r
    public final g2.h c(String s, String s1, g g0, b b0) {
        z0 z00 = new z0(s, s1, g0, b0);
        return this.a.b(z00);
    }

    @Override  // p1.r
    public final g2.h d(String s, boolean z, int v) {
        b1 b10 = new b1(s, z, v);
        return this.a.b(b10);
    }
}

