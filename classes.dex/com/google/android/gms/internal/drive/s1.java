package com.google.android.gms.internal.drive;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class s1 {
    private final v1 a;
    private final ConcurrentMap b;
    private static final s1 c;

    static {
        s1.c = new s1();
    }

    private s1() {
        this.b = new ConcurrentHashMap();
        this.a = new y0();
    }

    public static s1 a() {
        return s1.c;
    }

    public final u1 b(Class class0) {
        m0.d(class0, "messageType");
        u1 u10 = (u1)this.b.get(class0);
        if(u10 == null) {
            u10 = this.a.a(class0);
            m0.d(class0, "messageType");
            m0.d(u10, "schema");
            u1 u11 = (u1)this.b.putIfAbsent(class0, u10);
            return u11 == null ? u10 : u11;
        }
        return u10;
    }

    public final u1 c(Object object0) {
        return this.b(object0.getClass());
    }
}

