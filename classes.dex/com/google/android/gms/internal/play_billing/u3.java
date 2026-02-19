package com.google.android.gms.internal.play_billing;

final class u3 extends s3 {
    @Override  // com.google.android.gms.internal.play_billing.s3
    final int a(Object object0) {
        return ((t3)object0).a();
    }

    @Override  // com.google.android.gms.internal.play_billing.s3
    final int b(Object object0) {
        return ((t3)object0).b();
    }

    @Override  // com.google.android.gms.internal.play_billing.s3
    final Object c(Object object0) {
        t3 t30 = ((n1)object0).zzc;
        if(t30 == t3.c()) {
            t30 = t3.f();
            ((n1)object0).zzc = t30;
        }
        return t30;
    }

    @Override  // com.google.android.gms.internal.play_billing.s3
    final Object d(Object object0) {
        return ((n1)object0).zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.s3
    final Object e(Object object0, Object object1) {
        if(!t3.c().equals(object1)) {
            if(t3.c().equals(object0)) {
                return t3.e(((t3)object0), ((t3)object1));
            }
            ((t3)object0).d(((t3)object1));
        }
        return object0;
    }

    @Override  // com.google.android.gms.internal.play_billing.s3
    final void f(Object object0, int v, long v1) {
        ((t3)object0).j(v << 3, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.s3
    final void g(Object object0) {
        ((n1)object0).zzc.h();
    }

    @Override  // com.google.android.gms.internal.play_billing.s3
    final void h(Object object0, Object object1) {
        ((n1)object0).zzc = (t3)object1;
    }

    @Override  // com.google.android.gms.internal.play_billing.s3
    final void i(Object object0, k4 k40) {
        ((t3)object0).k(k40);
    }

    @Override  // com.google.android.gms.internal.play_billing.s3
    final void j(Object object0, k4 k40) {
        ((t3)object0).l(k40);
    }
}

