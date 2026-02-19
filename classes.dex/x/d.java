package x;

import k3.f;

public final class d extends a {
    public d() {
        this(null, 1, null);
    }

    public d(a a0) {
        f.e(a0, "initialExtras");
        super();
        this.a().putAll(a0.a());
    }

    public d(a a0, int v, k3.d d0) {
        if((v & 1) != 0) {
            a0 = x.a.a.b;
        }
        this(a0);
    }

    public final void b(b a$b0, Object object0) {
        f.e(a$b0, "key");
        this.a().put(a$b0, object0);
    }
}

