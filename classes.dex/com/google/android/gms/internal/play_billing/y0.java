package com.google.android.gms.internal.play_billing;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class y0 extends f0 {
    z0 a;
    private static final Logger b;
    private static final boolean c;

    static {
        y0.b = Logger.getLogger("com.google.android.gms.internal.play_billing.y0");
        y0.c = false;
    }

    y0(x0 x00) {
    }

    final void a(String s, g4 g40) {
        y0.b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", g40);
        byte[] arr_b = s.getBytes(v1.b);
        try {
            this.q(arr_b.length);
            this.m(arr_b, 0, arr_b.length);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new w0(indexOutOfBoundsException0);
        }
    }

    static boolean b() [...] // 潜在的解密器

    public abstract int c();

    public abstract void d(byte arg1);

    public abstract void e(int arg1, boolean arg2);

    public abstract void f(int arg1, q0 arg2);

    public abstract void g(int arg1, int arg2);

    public abstract void h(int arg1);

    public abstract void i(int arg1, long arg2);

    public abstract void j(long arg1);

    public abstract void k(int arg1, int arg2);

    public abstract void l(int arg1);

    public abstract void m(byte[] arg1, int arg2, int arg3);

    public abstract void n(int arg1, String arg2);

    public abstract void o(int arg1, int arg2);

    public abstract void p(int arg1, int arg2);

    public abstract void q(int arg1);

    public abstract void r(int arg1, long arg2);

    public abstract void s(long arg1);

    static int t(int v, r2 r20, c3 c30) {
        int v1 = y0.w(v << 3);
        return v1 + v1 + ((z)r20).b(c30);
    }

    static int u(r2 r20, c3 c30) {
        int v = ((z)r20).b(c30);
        return y0.w(v) + v;
    }

    public static int v(String s) {
        int v;
        try {
            v = h4.c(s);
            return y0.w(v) + v;
        }
        catch(g4 unused_ex) {
            v = s.getBytes(v1.b).length;
            return y0.w(v) + v;
        }
    }

    public static int w(int v) [...] // 潜在的解密器

    public static int x(long v) {
        return 640 - Long.numberOfLeadingZeros(v) * 9 >>> 6;
    }

    public static y0 y(byte[] arr_b, int v, int v1) {
        return new v0(arr_b, 0, v1);
    }

    public final void z() {
        if(this.c() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }
}

