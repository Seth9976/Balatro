package com.google.android.gms.internal.drive;

final class n extends r {
    private final int j;
    private final int k;

    n(byte[] arr_b, int v, int v1) {
        super(arr_b);
        i.s(v, v + v1, arr_b.length);
        this.j = v;
        this.k = v1;
    }

    @Override  // com.google.android.gms.internal.drive.r
    protected final int A() {
        return this.j;
    }

    @Override  // com.google.android.gms.internal.drive.r
    public final int size() {
        return this.k;
    }

    @Override  // com.google.android.gms.internal.drive.r
    public final byte x(int v) {
        int v1 = this.size();
        if((v1 - (v + 1) | v) < 0) {
            throw v >= 0 ? new ArrayIndexOutOfBoundsException("Index > length: " + v + ", " + v1) : new ArrayIndexOutOfBoundsException("Index < 0: " + v);
        }
        return this.i[this.j + v];
    }

    @Override  // com.google.android.gms.internal.drive.r
    final byte y(int v) {
        return this.i[this.j + v];
    }
}

