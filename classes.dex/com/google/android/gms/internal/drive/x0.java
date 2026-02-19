package com.google.android.gms.internal.drive;

final class x0 extends u0 {
    private x0() {
        super(null);
    }

    x0(v0 v00) {
    }

    @Override  // com.google.android.gms.internal.drive.u0
    final void a(Object object0, long v) {
        x0.e(object0, v).l();
    }

    @Override  // com.google.android.gms.internal.drive.u0
    final void b(Object object0, Object object1, long v) {
        n0 n00 = x0.e(object0, v);
        n0 n01 = x0.e(object1, v);
        int v1 = n00.size();
        int v2 = n01.size();
        if(v1 > 0 && v2 > 0) {
            if(!n00.h()) {
                n00 = n00.j(v2 + v1);
            }
            n00.addAll(n01);
        }
        if(v1 > 0) {
            n01 = n00;
        }
        r2.g(object0, v, n01);
    }

    private static n0 e(Object object0, long v) {
        return (n0)r2.G(object0, v);
    }
}

