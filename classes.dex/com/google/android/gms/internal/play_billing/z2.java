package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class z2 {
    private final d3 a;
    private final ConcurrentMap b;
    private static final z2 c;

    static {
        z2.c = new z2();
    }

    private z2() {
        this.b = new ConcurrentHashMap();
        this.a = new k2();
    }

    public static z2 a() {
        return z2.c;
    }

    public final c3 b(Class class0) {
        v1.c(class0, "messageType");
        c3 c30 = (c3)this.b.get(class0);
        if(c30 == null) {
            c30 = this.a.a(class0);
            v1.c(class0, "messageType");
            c3 c31 = (c3)this.b.putIfAbsent(class0, c30);
            return c31 == null ? c30 : c31;
        }
        return c30;
    }
}

