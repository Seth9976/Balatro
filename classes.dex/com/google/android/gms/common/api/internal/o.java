package com.google.android.gms.common.api.internal;

import c1.c;
import e1.b;
import e1.q;

final class o {
    private final b a;
    private final c b;

    o(b b0, c c0, q q0) {
        this.a = b0;
        this.b = c0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 != null && object0 instanceof o && g1.o.a(this.a, ((o)object0).a) && g1.o.a(this.b, ((o)object0).b);
    }

    @Override
    public final int hashCode() {
        return g1.o.b(new Object[]{this.a, this.b});
    }

    @Override
    public final String toString() {
        return g1.o.c(this).a("key", this.a).a("feature", this.b).toString();
    }
}

