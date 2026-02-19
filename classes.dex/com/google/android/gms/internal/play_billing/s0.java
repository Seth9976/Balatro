package com.google.android.gms.internal.play_billing;

final class s0 extends u0 {
    private final byte[] b;
    private int c;
    private int d;
    private int e;

    s0(byte[] arr_b, int v, int v1, boolean z, r0 r00) {
        super(null);
        this.e = 0x7FFFFFFF;
        this.b = arr_b;
        this.c = 0;
    }

    public final int c(int v) {
        int v1 = this.e;
        this.e = 0;
        int v2 = this.c + this.d;
        this.c = v2;
        if(v2 > 0) {
            this.d = v2;
            this.c = 0;
            return v1;
        }
        this.d = 0;
        return v1;
    }
}

