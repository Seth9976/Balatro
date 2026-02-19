package com.google.android.gms.internal.drive;

public abstract class t {
    private int a;
    private int b;
    private boolean c;

    private t() {
        this.a = 100;
        this.b = 0x7FFFFFFF;
        this.c = false;
    }

    t(u u0) {
    }

    static t a(byte[] arr_b, int v, int v1, boolean z) {
        t t0 = new v(arr_b, 0, v1, false, null);
        try {
            t0.c(v1);
            return t0;
        }
        catch(o0 o00) {
            throw new IllegalArgumentException(o00);
        }
    }

    public abstract int b();

    public abstract int c(int arg1);
}

