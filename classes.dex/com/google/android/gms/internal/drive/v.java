package com.google.android.gms.internal.drive;

final class v extends t {
    private final byte[] d;
    private final boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    private v(byte[] arr_b, int v, int v1, boolean z) {
        super(null);
        this.j = 0x7FFFFFFF;
        this.d = arr_b;
        this.f = v1 + v;
        this.h = v;
        this.i = v;
        this.e = z;
    }

    v(byte[] arr_b, int v, int v1, boolean z, u u0) {
        this(arr_b, v, v1, z);
    }

    @Override  // com.google.android.gms.internal.drive.t
    public final int b() {
        return this.h - this.i;
    }

    @Override  // com.google.android.gms.internal.drive.t
    public final int c(int v) {
        if(v < 0) {
            throw o0.b();
        }
        int v1 = v + this.b();
        int v2 = this.j;
        if(v1 > v2) {
            throw o0.a();
        }
        this.j = v1;
        int v3 = this.f + this.g;
        this.f = v3;
        int v4 = v3 - this.i;
        if(v4 > v1) {
            int v5 = v4 - v1;
            this.g = v5;
            this.f = v3 - v5;
            return v2;
        }
        this.g = 0;
        return v2;
    }
}

