package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class w extends h {
    static final class a extends w {
        private final byte[] d;
        private final int e;
        private final int f;
        private int g;

        a(byte[] arr_b, int v, int v1) {
            super(null);
            if(arr_b == null) {
                throw new NullPointerException("buffer");
            }
            if((v1 | arr_b.length - v1) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", ((int)arr_b.length), 0, v1));
            }
            this.d = arr_b;
            this.e = 0;
            this.g = 0;
            this.f = v1;
        }

        private final void B0(byte[] arr_b, int v, int v1) {
            try {
                System.arraycopy(arr_b, v, this.d, this.g, v1);
                this.g += v1;
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", this.g, this.f, v1), indexOutOfBoundsException0);
            }
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void F(int v, int v1) {
            this.z0(v << 3 | v1);
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void H(int v, i i0) {
            this.F(1, 3);
            this.a0(2, v);
            this.h(3, i0);
            this.F(1, 4);
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void I(int v, boolean z) {
            this.F(v, 0);
            this.P(((byte)z));
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void J(i1 i10) {
            this.z0(i10.a());
            i10.f(this);
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void P(byte b) {
            try {
                int v = this.g;
                this.g = v + 1;
                this.d[v] = b;
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", this.g, this.f, 1), indexOutOfBoundsException0);
            }
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void Q(int v, int v1) {
            this.F(v, 0);
            this.y0(v1);
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void R(int v, long v1) {
            this.F(v, 1);
            this.r0(v1);
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final int T() {
            return this.f - this.g;
        }

        @Override  // com.google.android.gms.internal.drive.h
        public final void a(byte[] arr_b, int v, int v1) {
            this.B0(arr_b, v, v1);
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void a0(int v, int v1) {
            this.F(v, 0);
            this.z0(v1);
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void e0(int v, int v1) {
            this.F(v, 5);
            this.n(v1);
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void g(int v, long v1) {
            this.F(v, 0);
            this.n0(v1);
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void h(int v, i i0) {
            this.F(v, 2);
            this.l(i0);
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void i(int v, i1 i10) {
            this.F(1, 3);
            this.a0(2, v);
            this.F(3, 2);
            this.J(i10);
            this.F(1, 4);
        }

        @Override  // com.google.android.gms.internal.drive.w
        final void j(int v, i1 i10, u1 u10) {
            this.F(v, 2);
            int v1 = ((c)i10).h();
            if(v1 == -1) {
                v1 = u10.a(((c)i10));
                ((c)i10).i(v1);
            }
            this.z0(v1);
            u10.b(i10, this.a);
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void k(int v, String s) {
            this.F(v, 2);
            this.o0(s);
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void l(i i0) {
            this.z0(i0.size());
            i0.q(this);
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void n(int v) {
            try {
                int v1 = this.g + 1;
                this.d[this.g] = (byte)v;
                this.d[v1] = (byte)(v >> 8);
                this.d[v1 + 1] = (byte)(v >> 16);
                this.g = v1 + 3;
                this.d[v1 + 2] = (byte)(v >>> 24);
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", this.g, this.f, 1), indexOutOfBoundsException0);
            }
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void n0(long v) {
            if(this.T() >= 10) {
                while((v & 0xFFFFFFFFFFFFFF80L) != 0L) {
                    int v1 = this.g;
                    this.g = v1 + 1;
                    r2.i(this.d, ((long)v1), ((byte)(((int)v) & 0x7F | 0x80)));
                    v >>>= 7;
                }
                int v2 = this.g;
                this.g = v2 + 1;
                r2.i(this.d, ((long)v2), ((byte)(((int)v))));
                return;
            }
            try {
                while(true) {
                    if((v & 0xFFFFFFFFFFFFFF80L) == 0L) {
                        int v3 = this.g;
                        this.g = v3 + 1;
                        this.d[v3] = (byte)(((int)v));
                        return;
                    }
                    int v4 = this.g;
                    this.g = v4 + 1;
                    this.d[v4] = (byte)(((int)v) & 0x7F | 0x80);
                    v >>>= 7;
                }
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", this.g, this.f, 1), indexOutOfBoundsException0);
            }
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void o0(String s) {
            int v;
            try {
                v = this.g;
                int v1 = w.q(s.length());
                if(v1 == w.q(s.length() * 3)) {
                    int v2 = v + v1;
                    this.g = v2;
                    int v3 = this.T();
                    int v4 = t2.b(s, this.d, v2, v3);
                    this.g = v;
                    this.z0(v4 - v - v1);
                    this.g = v4;
                    return;
                }
                this.z0(t2.a(s));
                int v5 = this.g;
                int v6 = this.T();
                this.g = t2.b(s, this.d, v5, v6);
            }
            catch(w2 w20) {
                this.g = v;
                this.m(s, w20);
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                throw new b(indexOutOfBoundsException0);
            }
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void r0(long v) {
            try {
                int v1 = this.g + 1;
                this.d[this.g] = (byte)(((int)v));
                this.d[v1] = (byte)(((int)(v >> 8)));
                this.d[v1 + 1] = (byte)(((int)(v >> 16)));
                this.d[v1 + 2] = (byte)(((int)(v >> 24)));
                this.d[v1 + 3] = (byte)(((int)(v >> 0x20)));
                this.d[v1 + 4] = (byte)(((int)(v >> 40)));
                this.d[v1 + 5] = (byte)(((int)(v >> 0x30)));
                this.g = v1 + 7;
                this.d[v1 + 6] = (byte)(((int)(v >> 56)));
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", this.g, this.f, 1), indexOutOfBoundsException0);
            }
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void y0(int v) {
            if(v >= 0) {
                this.z0(v);
                return;
            }
            this.n0(((long)v));
        }

        @Override  // com.google.android.gms.internal.drive.w
        public final void z0(int v) {
            if(this.T() >= 5) {
                if((v & 0xFFFFFF80) == 0) {
                    int v1 = this.g;
                    this.g = v1 + 1;
                    r2.i(this.d, ((long)v1), ((byte)v));
                    return;
                }
                int v2 = this.g;
                this.g = v2 + 1;
                r2.i(this.d, ((long)v2), ((byte)(v | 0x80)));
                if((v >>> 7 & 0xFFFFFF80) == 0) {
                    int v3 = this.g;
                    this.g = v3 + 1;
                    r2.i(this.d, ((long)v3), ((byte)(v >>> 7)));
                    return;
                }
                int v4 = this.g;
                this.g = v4 + 1;
                r2.i(this.d, ((long)v4), ((byte)(v >>> 7 | 0x80)));
                int v5 = v >>> 7 >>> 7;
                if((v5 & 0xFFFFFF80) == 0) {
                    int v6 = this.g;
                    this.g = v6 + 1;
                    r2.i(this.d, ((long)v6), ((byte)v5));
                    return;
                }
                int v7 = this.g;
                this.g = v7 + 1;
                r2.i(this.d, ((long)v7), ((byte)(v5 | 0x80)));
                if((v5 >>> 7 & 0xFFFFFF80) == 0) {
                    int v8 = this.g;
                    this.g = v8 + 1;
                    r2.i(this.d, ((long)v8), ((byte)(v5 >>> 7)));
                    return;
                }
                int v9 = this.g;
                this.g = v9 + 1;
                r2.i(this.d, ((long)v9), ((byte)(v5 >>> 7 | 0x80)));
                int v10 = this.g;
                this.g = v10 + 1;
                r2.i(this.d, ((long)v10), ((byte)(v5 >>> 7 >>> 7)));
                return;
            }
            try {
                while(true) {
                    if((v & 0xFFFFFF80) == 0) {
                        int v11 = this.g;
                        this.g = v11 + 1;
                        this.d[v11] = (byte)v;
                        return;
                    }
                    int v12 = this.g;
                    this.g = v12 + 1;
                    this.d[v12] = (byte)(v & 0x7F | 0x80);
                    v >>>= 7;
                }
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", this.g, this.f, 1), indexOutOfBoundsException0);
            }
        }
    }

    public static final class b extends IOException {
        b(String s, Throwable throwable0) {
            String s1 = String.valueOf(s);
            super((s1.length() == 0 ? new String("CodedOutputStream was writing to a flat byte array and ran out of space.: ") : "CodedOutputStream was writing to a flat byte array and ran out of space.: " + s1), throwable0);
        }

        b(Throwable throwable0) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", throwable0);
        }
    }

    y a;
    private static final Logger b;
    private static final boolean c;

    static {
        w.b = Logger.getLogger("com.google.android.gms.internal.drive.w");
        w.c = true;
    }

    private w() {
    }

    w(x x0) {
    }

    public static int A(int v, float f) {
        return w.o(v) + 4;
    }

    public final void A0(int v) {
        this.z0(v >> 0x1F ^ v << 1);
    }

    static int B(int v, i1 i10, u1 u10) {
        return w.o(v) + w.b(i10, u10);
    }

    public static int C(int v, String s) {
        return w.o(v) + w.p0(s);
    }

    public static int D(i i0) {
        int v = i0.size();
        return w.q(v) + v;
    }

    public static w E(byte[] arr_b) {
        return new a(arr_b, 0, arr_b.length);
    }

    public abstract void F(int arg1, int arg2);

    public final void G(int v, long v1) {
        this.g(v, v1 >> 0x3F ^ v1 << 1);
    }

    public abstract void H(int arg1, i arg2);

    public abstract void I(int arg1, boolean arg2);

    public abstract void J(i1 arg1);

    public static int K(int v, i i0) {
        int v1 = i0.size();
        return w.o(v) + (w.q(v1) + v1);
    }

    static int L(int v, i1 i10, u1 u10) {
        int v1 = w.o(v);
        int v2 = ((c)i10).h();
        if(v2 == -1) {
            v2 = u10.a(((c)i10));
            ((c)i10).i(v2);
        }
        return (v1 << 1) + v2;
    }

    public static int M(int v, boolean z) {
        return w.o(v) + 1;
    }

    public static int N(i1 i10) {
        int v = i10.a();
        return w.q(v) + v;
    }

    public static int O(byte[] arr_b) {
        return w.q(arr_b.length) + arr_b.length;
    }

    public abstract void P(byte arg1);

    public abstract void Q(int arg1, int arg2);

    public abstract void R(int arg1, long arg2);

    public final void S(boolean z) {
        this.P(((byte)z));
    }

    public abstract int T();

    public final void U() {
        if(this.T() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    static boolean V() [...] // 潜在的解密器

    public static int W(int v, long v1) {
        return w.o(v) + w.t0(v1);
    }

    // 去混淆评级： 低(20)
    public static int X(int v, i i0) {
        return w.h0(2, v) + 2 + w.K(3, i0);
    }

    public static int Y(i1 i10) {
        return i10.a();
    }

    public static int Z(boolean z) {
        return 1;
    }

    public abstract void a0(int arg1, int arg2);

    static int b(i1 i10, u1 u10) {
        int v = ((c)i10).h();
        if(v == -1) {
            v = u10.a(((c)i10));
            ((c)i10).i(v);
        }
        return w.q(v) + v;
    }

    public static int b0(int v, long v1) {
        return w.o(v) + w.t0(v1);
    }

    public final void c(double f) {
        this.r0(Double.doubleToRawLongBits(f));
    }

    public final void c0(int v, int v1) {
        this.a0(v, v1 >> 0x1F ^ v1 << 1);
    }

    public final void d(float f) {
        this.n(Float.floatToRawIntBits(f));
    }

    public static int d0(int v, long v1) {
        return w.o(v) + w.t0(v1 >> 0x3F ^ v1 << 1);
    }

    public final void e(int v, double f) {
        this.R(v, Double.doubleToRawLongBits(f));
    }

    public abstract void e0(int arg1, int arg2);

    public final void f(int v, float f) {
        this.e0(v, Float.floatToRawIntBits(f));
    }

    public static int f0(int v, int v1) {
        return w.o(v) + w.p(v1);
    }

    public abstract void g(int arg1, long arg2);

    public static int g0(int v, long v1) {
        return w.o(v) + 8;
    }

    public abstract void h(int arg1, i arg2);

    public static int h0(int v, int v1) {
        return w.o(v) + w.q(v1);
    }

    public abstract void i(int arg1, i1 arg2);

    public static int i0(int v, long v1) {
        return w.o(v) + 8;
    }

    abstract void j(int arg1, i1 arg2, u1 arg3);

    public static int j0(int v, int v1) {
        return w.o(v) + w.q(v1 >> 0x1F ^ v1 << 1);
    }

    public abstract void k(int arg1, String arg2);

    public static int k0(int v, int v1) {
        return w.o(v) + 4;
    }

    public abstract void l(i arg1);

    public static int l0(int v, int v1) {
        return w.o(v) + 4;
    }

    final void m(String s, w2 w20) {
        w.b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", w20);
        byte[] arr_b = s.getBytes(m0.a);
        try {
            this.z0(arr_b.length);
            this.a(arr_b, 0, arr_b.length);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new b(indexOutOfBoundsException0);
        }
    }

    public static int m0(int v, int v1) {
        return w.o(v) + w.p(v1);
    }

    public abstract void n(int arg1);

    public abstract void n0(long arg1);

    public static int o(int v) [...] // 潜在的解密器

    public abstract void o0(String arg1);

    public static int p(int v) {
        return v < 0 ? 10 : w.q(v);
    }

    public static int p0(String s) {
        int v;
        try {
            v = t2.a(s);
            return w.q(v) + v;
        }
        catch(w2 unused_ex) {
            v = s.getBytes(m0.a).length;
            return w.q(v) + v;
        }
    }

    public static int q(int v) {
        if((v & 0xFFFFFF80) == 0) {
            return 1;
        }
        if((v & 0xFFFFC000) == 0) {
            return 2;
        }
        if((0xFFE00000 & v) == 0) {
            return 3;
        }
        return (v & 0xF0000000) == 0 ? 4 : 5;
    }

    public final void q0(long v) {
        this.n0(v >> 0x3F ^ v << 1);
    }

    public static int r(int v) {
        return w.q(v >> 0x1F ^ v << 1);
    }

    public abstract void r0(long arg1);

    public static int s(int v) {
        return 4;
    }

    public static int s0(long v) {
        return w.t0(v);
    }

    public static int t(int v) {
        return 4;
    }

    public static int t0(long v) {
        int v1;
        if((0xFFFFFFFFFFFFFF80L & v) == 0L) {
            return 1;
        }
        if(v < 0L) {
            return 10;
        }
        if((0xFFFFFFF800000000L & v) == 0L) {
            v1 = 2;
        }
        else {
            v >>>= 28;
            v1 = 6;
        }
        if((0xFFFFFFFFFFE00000L & v) != 0L) {
            v1 += 2;
            v >>>= 14;
        }
        return (v & 0xFFFFFFFFFFFFC000L) == 0L ? v1 : v1 + 1;
    }

    public static int u(int v) {
        return w.p(v);
    }

    public static int u0(long v) {
        return w.t0(v >> 0x3F ^ v << 1);
    }

    private static int v(int v) [...] // Inlined contents

    public static int v0(long v) {
        return 8;
    }

    public static int w(int v) {
        return w.q(v);
    }

    public static int w0(long v) {
        return 8;
    }

    public static int x(double f) {
        return 8;
    }

    private static long x0(long v) [...] // Inlined contents

    public static int y(float f) {
        return 4;
    }

    public abstract void y0(int arg1);

    public static int z(int v, double f) {
        return w.o(v) + 8;
    }

    public abstract void z0(int arg1);
}

