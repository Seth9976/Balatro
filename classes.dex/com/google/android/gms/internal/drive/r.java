package com.google.android.gms.internal.drive;

import java.nio.charset.Charset;

class r extends q {
    protected final byte[] i;

    r(byte[] arr_b) {
        arr_b.getClass();
        this.i = arr_b;
    }

    protected int A() {
        return 0;
    }

    @Override  // com.google.android.gms.internal.drive.i
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof i)) {
            return false;
        }
        if(this.size() != ((i)object0).size()) {
            return false;
        }
        if(this.size() == 0) {
            return true;
        }
        if(object0 instanceof r) {
            int v = this.v();
            int v1 = ((r)object0).v();
            return v == 0 || v1 == 0 || v == v1 ? this.z(((r)object0), 0, this.size()) : false;
        }
        return object0.equals(this);
    }

    @Override  // com.google.android.gms.internal.drive.i
    protected final int n(int v, int v1, int v2) {
        return m0.b(v, this.i, this.A(), v2);
    }

    @Override  // com.google.android.gms.internal.drive.i
    public final i o(int v, int v1) {
        int v2 = i.s(0, v1, this.size());
        return v2 == 0 ? i.f : new n(this.i, this.A(), v2);
    }

    @Override  // com.google.android.gms.internal.drive.i
    protected final String p(Charset charset0) {
        return new String(this.i, this.A(), this.size(), charset0);
    }

    @Override  // com.google.android.gms.internal.drive.i
    final void q(h h0) {
        h0.a(this.i, this.A(), this.size());
    }

    @Override  // com.google.android.gms.internal.drive.i
    public int size() {
        return this.i.length;
    }

    @Override  // com.google.android.gms.internal.drive.i
    public final boolean u() {
        int v = this.A();
        return t2.h(this.i, v, this.size() + v);
    }

    @Override  // com.google.android.gms.internal.drive.i
    public byte x(int v) {
        return this.i[v];
    }

    @Override  // com.google.android.gms.internal.drive.i
    byte y(int v) {
        return this.i[v];
    }

    @Override  // com.google.android.gms.internal.drive.q
    final boolean z(i i0, int v, int v1) {
        if(v1 > i0.size()) {
            throw new IllegalArgumentException("Length too large: " + v1 + this.size());
        }
        if(v1 > i0.size()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + v1 + ", " + i0.size());
        }
        if(i0 instanceof r) {
            byte[] arr_b = this.i;
            byte[] arr_b1 = ((r)i0).i;
            int v2 = this.A();
            int v3 = this.A();
            for(int v4 = ((r)i0).A(); v3 < v2 + v1; ++v4) {
                if(arr_b[v3] != arr_b1[v4]) {
                    return false;
                }
                ++v3;
            }
            return true;
        }
        return i0.o(0, v1).equals(this.o(0, v1));
    }
}

