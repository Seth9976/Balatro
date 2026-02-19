package com.google.android.gms.internal.drive;

import h.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class e0 {
    final x1 a;
    private boolean b;
    private boolean c;
    private static final e0 d;

    static {
        e0.d = new e0(true);
    }

    private e0() {
        this.c = false;
        this.a = x1.f(16);
    }

    private e0(boolean z) {
        this.c = false;
        this.a = x1.f(0);
        this.k();
    }

    final Iterator a() {
        return this.c ? new r0(this.a.o().iterator()) : this.a.o().iterator();
    }

    public final boolean b() {
        for(int v = 0; v < this.a.m(); ++v) {
            if(!e0.j(this.a.g(v))) {
                return false;
            }
        }
        for(Object object0: this.a.n()) {
            if(!e0.j(((Map.Entry)object0))) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    public final Iterator c() {
        return this.c ? new r0(this.a.entrySet().iterator()) : this.a.entrySet().iterator();
    }

    @Override
    public final Object clone() {
        e0 e00 = new e0();
        for(int v = 0; v < this.a.m(); ++v) {
            Map.Entry map$Entry0 = this.a.g(v);
            d.a(map$Entry0.getKey());
            e00.f(null, map$Entry0.getValue());
        }
        for(Object object0: this.a.n()) {
            d.a(((Map.Entry)object0).getKey());
            e00.f(null, ((Map.Entry)object0).getValue());
        }
        e00.c = this.c;
        return e00;
    }

    static int d(z2 z20, int v, Object object0) {
        int v1 = w.o(v);
        if(z20 == z2.p) {
            i1 i10 = (i1)object0;
            v1 <<= 1;
        }
        return v1 + e0.i(z20, object0);
    }

    public final void e(e0 e00) {
        for(int v = 0; v < e00.a.m(); ++v) {
            this.l(e00.a.g(v));
        }
        for(Object object0: e00.a.n()) {
            this.l(((Map.Entry)object0));
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof e0 ? this.a.equals(((e0)object0).a) : false;
    }

    private final void f(g0 g00, Object object0) {
        if(g00.i()) {
            if(!(object0 instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList0 = new ArrayList();
            arrayList0.addAll(((List)object0));
            int v = arrayList0.size();
            int v1 = 0;
            while(v1 < v) {
                Object object1 = arrayList0.get(v1);
                ++v1;
                e0.g(g00.g(), object1);
            }
            object0 = arrayList0;
        }
        else {
            e0.g(g00.g(), object0);
        }
        this.a.d(g00, object0);
    }

    private static void g(z2 z20, Object object0) {
        m0.a(object0);
        boolean z = true;
        boolean z1 = false;
        switch(z20.c()) {
            case 1: {
                z1 = object0 instanceof Integer;
                break;
            }
            case 2: {
                z1 = object0 instanceof Long;
                break;
            }
            case 3: {
                z1 = object0 instanceof Float;
                break;
            }
            case 4: {
                z1 = object0 instanceof Double;
                break;
            }
            case 5: {
                z1 = object0 instanceof Boolean;
                break;
            }
            case 6: {
                z1 = object0 instanceof String;
                break;
            }
            case 7: {
                if(!(object0 instanceof i) && !(object0 instanceof byte[])) {
                    z = false;
                }
                z1 = z;
                break;
            }
            case 8: {
                if(!(object0 instanceof Integer)) {
                    z = false;
                }
                z1 = z;
                break;
            }
            case 9: {
                if(!(object0 instanceof i1)) {
                    z = false;
                }
                z1 = z;
            }
        }
        if(!z1) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public static int h(g0 g00, Object object0) {
        int v = 0;
        z2 z20 = g00.g();
        int v1 = g00.b();
        if(g00.i()) {
            if(g00.f()) {
                for(Object object1: ((List)object0)) {
                    v += e0.i(z20, object1);
                }
                return w.o(v1) + v + w.w(v);
            }
            for(Object object2: ((List)object0)) {
                v += e0.d(z20, v1, object2);
            }
            return v;
        }
        return e0.d(z20, v1, object0);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    private static int i(z2 z20, Object object0) {
        switch(z20) {
            case 1: {
                return w.x(((double)(((Double)object0))));
            }
            case 2: {
                return w.y(((float)(((Float)object0))));
            }
            case 3: {
                return w.s0(((long)(((Long)object0))));
            }
            case 4: {
                return w.t0(((long)(((Long)object0))));
            }
            case 5: {
                return w.p(((int)(((Integer)object0))));
            }
            case 6: {
                return w.v0(((long)(((Long)object0))));
            }
            case 7: {
                return w.s(((int)(((Integer)object0))));
            }
            case 8: {
                return w.Z(((Boolean)object0).booleanValue());
            }
            case 9: {
                return w.Y(((i1)object0));
            }
            case 10: {
                return w.N(((i1)object0));
            }
            case 11: {
                return object0 instanceof i ? w.D(((i)object0)) : w.p0(((String)object0));
            }
            case 12: {
                return object0 instanceof i ? w.D(((i)object0)) : w.O(((byte[])object0));
            }
            case 13: {
                return w.q(((int)(((Integer)object0))));
            }
            case 14: {
                return w.t(((int)(((Integer)object0))));
            }
            case 15: {
                return w.w0(((long)(((Long)object0))));
            }
            case 16: {
                return w.r(((int)(((Integer)object0))));
            }
            case 17: {
                return w.u0(((long)(((Long)object0))));
            }
            case 18: {
                return w.u(((int)(((Integer)object0))));
            }
            default: {
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
        }
    }

    private static boolean j(Map.Entry map$Entry0) {
        d.a(map$Entry0.getKey());
        throw null;
    }

    public final void k() {
        if(this.b) {
            return;
        }
        this.a.j();
        this.b = true;
    }

    private final void l(Map.Entry map$Entry0) {
        d.a(map$Entry0.getKey());
        map$Entry0.getValue();
        throw null;
    }

    public final int m() {
        int v1 = 0;
        for(int v = 0; v < this.a.m(); ++v) {
            v1 += e0.n(this.a.g(v));
        }
        for(Object object0: this.a.n()) {
            v1 += e0.n(((Map.Entry)object0));
        }
        return v1;
    }

    private static int n(Map.Entry map$Entry0) {
        d.a(map$Entry0.getKey());
        map$Entry0.getValue();
        throw null;
    }
}

