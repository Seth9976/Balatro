package com.google.android.gms.internal.play_billing;

final class j0 extends n0 {
    private final int j;

    j0(byte[] arr_b, int v, int v1) {
        super(arr_b);
        q0.u(0, v1, arr_b.length);
        this.j = v1;
    }

    @Override  // com.google.android.gms.internal.play_billing.n0
    public final byte e(int v) {
        int v1 = this.j;
        if((v1 - (v + 1) | v) < 0) {
            throw v >= 0 ? new ArrayIndexOutOfBoundsException("Index > length: " + v + ", " + v1) : new ArrayIndexOutOfBoundsException("Index < 0: " + v);
        }
        return this.i[v];
    }

    @Override  // com.google.android.gms.internal.play_billing.n0
    final byte n(int v) {
        return this.i[v];
    }

    @Override  // com.google.android.gms.internal.play_billing.n0
    public final int o() {
        return this.j;
    }

    @Override  // com.google.android.gms.internal.play_billing.n0
    protected final int y() {
        return 0;
    }
}

