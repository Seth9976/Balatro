package com.google.android.gms.internal.drive;

final class n2 extends l2 {
    @Override  // com.google.android.gms.internal.drive.l2
    final void a(Object object0, f3 f30) {
        ((m2)object0).e(f30);
    }

    @Override  // com.google.android.gms.internal.drive.l2
    final void b(Object object0, f3 f30) {
        ((m2)object0).b(f30);
    }

    @Override  // com.google.android.gms.internal.drive.l2
    final void c(Object object0) {
        ((l0)object0).zzrq.f();
    }

    @Override  // com.google.android.gms.internal.drive.l2
    final void d(Object object0, Object object1) {
        n2.i(object0, ((m2)object1));
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.internal.drive.l2
    final Object e(Object object0, Object object1) {
        return ((m2)object1).equals(m2.h()) ? ((m2)object0) : m2.a(((m2)object0), ((m2)object1));
    }

    @Override  // com.google.android.gms.internal.drive.l2
    final int f(Object object0) {
        return ((m2)object0).g();
    }

    @Override  // com.google.android.gms.internal.drive.l2
    final Object g(Object object0) {
        return ((l0)object0).zzrq;
    }

    @Override  // com.google.android.gms.internal.drive.l2
    final int h(Object object0) {
        return ((m2)object0).i();
    }

    private static void i(Object object0, m2 m20) {
        ((l0)object0).zzrq = m20;
    }
}

