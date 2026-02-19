package com.google.android.gms.internal.play_billing;

abstract class h2 {
    private static final h2 a;
    private static final h2 b;

    static {
        h2.a = new d2(null);
        h2.b = new f2(null);
    }

    h2(g2 g20) {
    }

    abstract void a(Object arg1, long arg2);

    abstract void b(Object arg1, Object arg2, long arg3);

    static h2 c() {
        return h2.a;
    }

    static h2 d() {
        return h2.b;
    }
}

