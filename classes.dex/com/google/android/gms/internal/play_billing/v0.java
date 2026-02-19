package com.google.android.gms.internal.play_billing;

final class v0 extends y0 {
    private final byte[] d;
    private final int e;
    private int f;

    v0(byte[] arr_b, int v, int v1) {
        super(null);
        if((arr_b.length - v1 | v1) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", ((int)arr_b.length), 0, v1));
        }
        this.d = arr_b;
        this.f = 0;
        this.e = v1;
    }

    public final void A(byte[] arr_b, int v, int v1) {
        try {
            System.arraycopy(arr_b, 0, this.d, this.f, v1);
            this.f += v1;
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new w0(String.format("Pos: %d, limit: %d, len: %d", this.f, this.e, v1), indexOutOfBoundsException0);
        }
    }

    public final void B(String s) {
        int v;
        try {
            v = this.f;
            int v1 = y0.w(s.length());
            if(v1 == y0.w(s.length() * 3)) {
                int v2 = v + v1;
                this.f = v2;
                int v3 = h4.b(s, this.d, v2, this.e - v2);
                this.f = v;
                this.q(v3 - v - v1);
                this.f = v3;
                return;
            }
            this.q(h4.c(s));
            this.f = h4.b(s, this.d, this.f, this.e - this.f);
        }
        catch(g4 g40) {
            this.f = v;
            this.a(s, g40);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new w0(indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final int c() {
        return this.e - this.f;
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void d(byte b) {
        try {
            int v = this.f;
            this.f = v + 1;
            this.d[v] = b;
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new w0(String.format("Pos: %d, limit: %d, len: %d", this.f, this.e, 1), indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void e(int v, boolean z) {
        this.q(v << 3);
        this.d(((byte)z));
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void f(int v, q0 q00) {
        this.q(v << 3 | 2);
        this.q(q00.o());
        q00.s(this);
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void g(int v, int v1) {
        this.q(v << 3 | 5);
        this.h(v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void h(int v) {
        try {
            int v1 = this.f + 1;
            this.d[this.f] = (byte)(v & 0xFF);
            this.d[v1] = (byte)(v >> 8 & 0xFF);
            this.d[v1 + 1] = (byte)(v >> 16 & 0xFF);
            this.f = v1 + 3;
            this.d[v1 + 2] = (byte)(v >> 24 & 0xFF);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new w0(String.format("Pos: %d, limit: %d, len: %d", this.f, this.e, 1), indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void i(int v, long v1) {
        this.q(v << 3 | 1);
        this.j(v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void j(long v) {
        try {
            int v1 = this.f + 1;
            this.d[this.f] = (byte)(((int)v) & 0xFF);
            this.d[v1] = (byte)(((int)(v >> 8)) & 0xFF);
            this.d[v1 + 1] = (byte)(((int)(v >> 16)) & 0xFF);
            this.d[v1 + 2] = (byte)(((int)(v >> 24)) & 0xFF);
            this.d[v1 + 3] = (byte)(((int)(v >> 0x20)) & 0xFF);
            this.d[v1 + 4] = (byte)(((int)(v >> 40)) & 0xFF);
            this.d[v1 + 5] = (byte)(((int)(v >> 0x30)) & 0xFF);
            this.f = v1 + 7;
            this.d[v1 + 6] = (byte)(((int)(v >> 56)) & 0xFF);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new w0(String.format("Pos: %d, limit: %d, len: %d", this.f, this.e, 1), indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void k(int v, int v1) {
        this.q(v << 3);
        this.l(v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void l(int v) {
        if(v >= 0) {
            this.q(v);
            return;
        }
        this.s(((long)v));
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void m(byte[] arr_b, int v, int v1) {
        this.A(arr_b, 0, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void n(int v, String s) {
        this.q(v << 3 | 2);
        this.B(s);
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void o(int v, int v1) {
        this.q(v << 3 | v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void p(int v, int v1) {
        this.q(v << 3);
        this.q(v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void q(int v) {
        try {
            while(true) {
                if((v & 0xFFFFFF80) == 0) {
                    int v1 = this.f;
                    this.f = v1 + 1;
                    this.d[v1] = (byte)v;
                    return;
                }
                int v2 = this.f;
                this.f = v2 + 1;
                this.d[v2] = (byte)((v | 0x80) & 0xFF);
                v >>>= 7;
            }
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new w0(String.format("Pos: %d, limit: %d, len: %d", this.f, this.e, 1), indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void r(int v, long v1) {
        this.q(v << 3);
        this.s(v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.y0
    public final void s(long v) {
        try {
            while(true) {
                if((v & 0xFFFFFFFFFFFFFF80L) == 0L) {
                    int v1 = this.f;
                    this.f = v1 + 1;
                    this.d[v1] = (byte)(((int)v));
                    return;
                }
                int v2 = this.f;
                this.f = v2 + 1;
                this.d[v2] = (byte)((((int)v) | 0x80) & 0xFF);
                v >>>= 7;
            }
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new w0(String.format("Pos: %d, limit: %d, len: %d", this.f, this.e, 1), indexOutOfBoundsException0);
        }
    }
}

