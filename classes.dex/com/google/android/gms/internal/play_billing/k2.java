package com.google.android.gms.internal.play_billing;

final class k2 implements d3 {
    private final p2 a;
    private static final p2 b;

    static {
        k2.b = new i2();
    }

    public k2() {
        p2 p20;
        p2[] arr_p2;
        try {
            arr_p2 = new p2[]{k1.c(), null};
            p20 = (p2)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance").invoke(null);
        }
        catch(Exception unused_ex) {
            p20 = k2.b;
        }
        arr_p2[1] = p20;
        j2 j20 = new j2(arr_p2);
        super();
        this.a = j20;
    }

    @Override  // com.google.android.gms.internal.play_billing.d3
    public final c3 a(Class class0) {
        s3 s30;
        h2 h20;
        w2 w20;
        e3.y(class0);
        o2 o20 = this.a.a(class0);
        boolean z = o20.b();
        Class class1 = n1.class;
        if(z) {
            return class1.isAssignableFrom(class0) ? v2.j(e3.u(), f1.b(), o20.a()) : v2.j(e3.t(), f1.a(), o20.a());
        }
        if(class1.isAssignableFrom(class0)) {
            w20 = x2.b();
            h20 = h2.d();
            s30 = e3.u();
            return k2.b(o20) ? u2.A(class0, o20, w20, h20, s30, f1.b(), n2.b()) : u2.A(class0, o20, w20, h20, s30, null, n2.b());
        }
        w20 = x2.a();
        h20 = h2.c();
        s30 = e3.t();
        return k2.b(o20) ? u2.A(class0, o20, w20, h20, s30, f1.a(), n2.a()) : u2.A(class0, o20, w20, h20, s30, null, n2.a());
    }

    private static boolean b(o2 o20) {
        return o20.c() - 1 != 1;
    }
}

