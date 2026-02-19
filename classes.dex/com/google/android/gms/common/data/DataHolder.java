package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import f1.f;
import g1.q;
import h1.a;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

public final class DataHolder extends a implements Closeable {
    public static abstract class com.google.android.gms.common.data.DataHolder.a {
        private final String[] a;
        private final ArrayList b;
        private final HashMap c;

        com.google.android.gms.common.data.DataHolder.a(String[] arr_s, String s, f f0) {
            this.a = (String[])q.i(arr_s);
            this.b = new ArrayList();
            this.c = new HashMap();
        }
    }

    public static final Parcelable.Creator CREATOR;
    final int e;
    private final String[] f;
    Bundle g;
    private final CursorWindow[] h;
    private final int i;
    private final Bundle j;
    int[] k;
    int l;
    boolean m;
    private boolean n;
    private static final com.google.android.gms.common.data.DataHolder.a o;

    static {
        DataHolder.CREATOR = new c();
        DataHolder.o = new b(new String[0], null);
    }

    DataHolder(int v, String[] arr_s, CursorWindow[] arr_cursorWindow, int v1, Bundle bundle0) {
        this.m = false;
        this.n = true;
        this.e = v;
        this.f = arr_s;
        this.h = arr_cursorWindow;
        this.i = v1;
        this.j = bundle0;
    }

    @Override
    public void close() {
        synchronized(this) {
            if(!this.m) {
                this.m = true;
                for(int v1 = 0; true; ++v1) {
                    CursorWindow[] arr_cursorWindow = this.h;
                    if(v1 >= arr_cursorWindow.length) {
                        break;
                    }
                    arr_cursorWindow[v1].close();
                }
            }
        }
    }

    @Override
    protected final void finalize() {
        try {
            if(this.n && this.h.length > 0 && !this.u()) {
                this.close();
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + this.toString() + ")");
            }
        }
        finally {
            super.finalize();
        }
    }

    public int getCount() {
        return this.l;
    }

    public boolean j0(String s, int v, int v1) {
        this.u0(s, v);
        return this.h[v1].getLong(v, this.g.getInt(s)) == 1L;
    }

    public int k0(String s, int v, int v1) {
        this.u0(s, v);
        return this.h[v1].getInt(v, this.g.getInt(s));
    }

    public long l0(String s, int v, int v1) {
        this.u0(s, v);
        return this.h[v1].getLong(v, this.g.getInt(s));
    }

    public Bundle m0() {
        return this.j;
    }

    public int n0() {
        return this.i;
    }

    public String o0(String s, int v, int v1) {
        this.u0(s, v);
        return this.h[v1].getString(v, this.g.getInt(s));
    }

    public int p0(int v) {
        int v2;
        int v1 = 0;
        q.k(v >= 0 && v < this.l);
        while(true) {
            int[] arr_v = this.k;
            v2 = arr_v.length;
            if(v1 >= v2) {
                break;
            }
            if(v < arr_v[v1]) {
                --v1;
                return v1 == v2 ? v1 - 1 : v1;
            }
            ++v1;
        }
        return v1 == v2 ? v1 - 1 : v1;
    }

    public boolean q0(String s) {
        return this.g.containsKey(s);
    }

    public boolean r0(String s, int v, int v1) {
        this.u0(s, v);
        return this.h[v1].isNull(v, this.g.getInt(s));
    }

    public final float s0(String s, int v, int v1) {
        this.u0(s, v);
        return this.h[v1].getFloat(v, this.g.getInt(s));
    }

    public final void t0() {
        this.g = new Bundle();
        for(int v1 = 0; true; ++v1) {
            String[] arr_s = this.f;
            if(v1 >= arr_s.length) {
                break;
            }
            this.g.putInt(arr_s[v1], v1);
        }
        this.k = new int[this.h.length];
        int v2 = 0;
        for(int v = 0; true; ++v) {
            CursorWindow[] arr_cursorWindow = this.h;
            if(v >= arr_cursorWindow.length) {
                break;
            }
            this.k[v] = v2;
            int v3 = arr_cursorWindow[v].getStartPosition();
            v2 += this.h[v].getNumRows() - (v2 - v3);
        }
        this.l = v2;
    }

    public boolean u() {
        synchronized(this) {
        }
        return this.m;
    }

    private final void u0(String s, int v) {
        if(this.g == null || !this.g.containsKey(s)) {
            throw new IllegalArgumentException("No such column: " + s);
        }
        if(this.u()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if(v < 0 || v >= this.l) {
            throw new CursorIndexOutOfBoundsException(v, this.l);
        }
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = h1.c.a(parcel0);
        h1.c.o(parcel0, 1, this.f, false);
        h1.c.q(parcel0, 2, this.h, v, false);
        h1.c.i(parcel0, 3, this.n0());
        h1.c.f(parcel0, 4, this.m0(), false);
        h1.c.i(parcel0, 1000, this.e);
        h1.c.b(parcel0, v1);
        if((v & 1) != 0) {
            this.close();
        }
    }
}

