package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;

class n0 extends m0 {
    protected final byte[] i;

    n0(byte[] arr_b) {
        super(null);
        arr_b.getClass();
        this.i = arr_b;
    }

    @Override  // com.google.android.gms.internal.play_billing.q0
    public byte e(int v) {
        return this.i[v];
    }

    @Override  // com.google.android.gms.internal.play_billing.q0
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof q0)) {
            return false;
        }
        if(this.o() != ((q0)object0).o()) {
            return false;
        }
        if(this.o() == 0) {
            return true;
        }
        if(object0 instanceof n0) {
            int v = this.v();
            int v1 = ((n0)object0).v();
            if(v != 0 && v1 != 0 && v != v1) {
                return false;
            }
            int v2 = this.o();
            if(v2 > ((n0)object0).o()) {
                throw new IllegalArgumentException("Length too large: " + v2 + this.o());
            }
            if(v2 > ((n0)object0).o()) {
                throw new IllegalArgumentException("Ran off end of other: 0, " + v2 + ", " + ((n0)object0).o());
            }
            byte[] arr_b = this.i;
            byte[] arr_b1 = ((n0)object0).i;
            ((n0)object0).y();
            int v3 = 0;
            for(int v4 = 0; v3 < v2; ++v4) {
                if(arr_b[v3] != arr_b1[v4]) {
                    return false;
                }
                ++v3;
            }
            return true;
        }
        return object0.equals(this);
    }

    @Override  // com.google.android.gms.internal.play_billing.q0
    byte n(int v) {
        return this.i[v];
    }

    @Override  // com.google.android.gms.internal.play_billing.q0
    public int o() {
        return this.i.length;
    }

    @Override  // com.google.android.gms.internal.play_billing.q0
    protected final int p(int v, int v1, int v2) {
        return v1.b(v, this.i, 0, v2);
    }

    @Override  // com.google.android.gms.internal.play_billing.q0
    public final q0 q(int v, int v1) {
        int v2 = q0.u(0, v1, this.o());
        return v2 == 0 ? q0.f : new j0(this.i, 0, v2);
    }

    @Override  // com.google.android.gms.internal.play_billing.q0
    protected final String r(Charset charset0) {
        int v = this.o();
        return new String(this.i, 0, v, charset0);
    }

    @Override  // com.google.android.gms.internal.play_billing.q0
    final void s(f0 f00) {
        int v = this.o();
        ((v0)f00).A(this.i, 0, v);
    }

    @Override  // com.google.android.gms.internal.play_billing.q0
    public final boolean t() {
        int v = this.o();
        return h4.e(this.i, 0, v);
    }

    protected int y() {
        return 0;
    }
}

