package com.google.android.gms.internal.drive;

final class y0 implements v1 {
    private final h1 a;
    private static final h1 b;

    static {
        y0.b = new z0();
    }

    public y0() {
        this(new a1(new h1[]{k0.c(), y0.c()}));
    }

    private y0(h1 h10) {
        this.a = (h1)m0.d(h10, "messageInfoFactory");
    }

    @Override  // com.google.android.gms.internal.drive.v1
    public final u1 a(Class class0) {
        w1.H(class0);
        g1 g10 = this.a.b(class0);
        boolean z = g10.c();
        Class class1 = l0.class;
        if(z) {
            return class1.isAssignableFrom(class0) ? n1.h(w1.z(), d0.b(), g10.b()) : n1.h(w1.x(), d0.c(), g10.b());
        }
        if(class1.isAssignableFrom(class0)) {
            o1 o10 = q1.b();
            u0 u00 = u0.d();
            l2 l20 = w1.z();
            return y0.b(g10) ? m1.i(class0, g10, o10, u00, l20, d0.b(), f1.b()) : m1.i(class0, g10, o10, u00, l20, null, f1.b());
        }
        o1 o11 = q1.a();
        u0 u01 = u0.c();
        return y0.b(g10) ? m1.i(class0, g10, o11, u01, w1.x(), d0.c(), f1.a()) : m1.i(class0, g10, o11, u01, w1.y(), null, f1.a());
    }

    private static boolean b(g1 g10) {
        return g10.a() == c.i;
    }

    private static h1 c() {
        try {
            return (h1)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance").invoke(null);
        }
        catch(Exception unused_ex) {
            return y0.b;
        }
    }
}

