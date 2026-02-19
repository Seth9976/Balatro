package com.google.android.gms.internal.drive;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

public abstract class i implements Serializable, Iterable {
    private int e;
    public static final i f;
    private static final o g;
    private static final Comparator h;

    static {
        i.f = new r(m0.c);
        i.g = new m(null);
        i.h = new k();
    }

    i() {
        this.e = 0;
    }

    private static int e(byte b) [...] // Inlined contents

    @Override
    public abstract boolean equals(Object arg1);

    @Override
    public final int hashCode() {
        int v = this.e;
        if(v == 0) {
            int v1 = this.size();
            v = this.n(v1, 0, v1);
            if(v == 0) {
                v = 1;
            }
            this.e = v;
        }
        return v;
    }

    @Override
    public Iterator iterator() {
        return new j(this);
    }

    protected abstract int n(int arg1, int arg2, int arg3);

    public abstract i o(int arg1, int arg2);

    protected abstract String p(Charset arg1);

    abstract void q(h arg1);

    static int r(byte b) {
        return b & 0xFF;
    }

    static int s(int v, int v1, int v2) {
        int v3 = v1 - v;
        if((v | v1 | v3 | v2 - v1) < 0) {
            if(v < 0) {
                throw new IndexOutOfBoundsException("Beginning index: " + v + " < 0");
            }
            throw v1 >= v ? new IndexOutOfBoundsException("End index: " + v1 + " >= " + v2) : new IndexOutOfBoundsException("Beginning index larger than ending index: " + v + ", " + v1);
        }
        return v3;
    }

    public abstract int size();

    public final String t() {
        return this.size() == 0 ? "" : this.p(m0.a);
    }

    @Override
    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), this.size());
    }

    public abstract boolean u();

    protected final int v() {
        return this.e;
    }

    public static i w(String s) {
        return new r(s.getBytes(m0.a));
    }

    public abstract byte x(int arg1);

    abstract byte y(int arg1);
}

