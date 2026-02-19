package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public abstract class q0 implements Serializable, Iterable {
    private int e;
    public static final q0 f;
    private static final Comparator g;
    private static final p0 h;

    static {
        q0.f = new n0(v1.d);
        q0.h = new p0(null);
        q0.g = new h0();
    }

    q0() {
        this.e = 0;
    }

    public abstract byte e(int arg1);

    @Override
    public abstract boolean equals(Object arg1);

    @Override
    public final int hashCode() {
        int v = this.e;
        if(v == 0) {
            int v1 = this.o();
            v = this.p(v1, 0, v1);
            if(v == 0) {
                v = 1;
            }
            this.e = v;
        }
        return v;
    }

    @Override
    public final Iterator iterator() {
        return new g0(this);
    }

    abstract byte n(int arg1);

    public abstract int o();

    protected abstract int p(int arg1, int arg2, int arg3);

    public abstract q0 q(int arg1, int arg2);

    protected abstract String r(Charset arg1);

    abstract void s(f0 arg1);

    public abstract boolean t();

    @Override
    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), this.o(), (this.o() > 50 ? q3.a(this.q(0, 0x2F)) + "..." : q3.a(this)));
    }

    static int u(int v, int v1, int v2) {
        int v3 = v1 - v;
        if((v | v1 | v3 | v2 - v1) < 0) {
            if(v < 0) {
                throw new IndexOutOfBoundsException("Beginning index: " + v + " < 0");
            }
            throw v1 >= v ? new IndexOutOfBoundsException("End index: " + v1 + " >= " + v2) : new IndexOutOfBoundsException("Beginning index larger than ending index: " + v + ", " + v1);
        }
        return v3;
    }

    protected final int v() {
        return this.e;
    }

    public static q0 w(byte[] arr_b, int v, int v1) {
        q0.u(v, v + v1, arr_b.length);
        byte[] arr_b1 = new byte[v1];
        System.arraycopy(arr_b, v, arr_b1, 0, v1);
        return new n0(arr_b1);
    }

    public final String x(Charset charset0) {
        return this.o() == 0 ? "" : this.r(charset0);
    }
}

