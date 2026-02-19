package com.google.android.gms.internal.play_billing;

final class f2 extends h2 {
    f2(e2 e20) {
        super(null);
    }

    @Override  // com.google.android.gms.internal.play_billing.h2
    final void a(Object object0, long v) {
        ((u1)c4.k(object0, v)).b();
    }

    @Override  // com.google.android.gms.internal.play_billing.h2
    final void b(Object object0, Object object1, long v) {
        u1 u10 = (u1)c4.k(object0, v);
        u1 u11 = (u1)c4.k(object1, v);
        int v1 = u10.size();
        int v2 = u11.size();
        if(v1 > 0 && v2 > 0) {
            if(!u10.c()) {
                u10 = u10.d(v2 + v1);
            }
            u10.addAll(u11);
        }
        if(v1 > 0) {
            u11 = u10;
        }
        c4.x(object0, v, u11);
    }
}

