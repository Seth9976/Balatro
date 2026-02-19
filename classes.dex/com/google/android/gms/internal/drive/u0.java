package com.google.android.gms.internal.drive;

abstract class u0 {
    private static final u0 a;
    private static final u0 b;

    static {
        u0.a = new w0(null);
        u0.b = new x0(null);
    }

    private u0() {
    }

    u0(v0 v00) {
    }

    abstract void a(Object arg1, long arg2);

    abstract void b(Object arg1, Object arg2, long arg3);

    static u0 c() {
        return u0.a;
    }

    static u0 d() {
        return u0.b;
    }
}

