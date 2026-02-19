package com.google.android.gms.internal.play_billing;

import h.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class h1 {
    final p3 a;
    private boolean b;
    private boolean c;
    private static final h1 d;

    static {
        h1.d = new h1(true);
    }

    private h1() {
        this.a = new f3(16);
    }

    private h1(boolean z) {
        f3 f30 = new f3(0);
        super();
        this.a = f30;
        this.e();
        this.e();
    }

    static int a(i4 i40, int v, Object object0) {
        if(i4.o == null) {
            r2 r20 = (r2)object0;
        }
        throw null;
    }

    public static int b(g1 g10, Object object0) {
        int v = 0;
        i4 i40 = g10.e();
        int v1 = g10.a();
        if(g10.h()) {
            if(g10.d()) {
                if(((List)object0).isEmpty()) {
                    return 0;
                }
                Iterator iterator0 = ((List)object0).iterator();
                if(!iterator0.hasNext()) {
                    return y0.w(v1 << 3) + 1;
                }
                iterator0.next();
                throw null;
            }
            for(Object object1: ((List)object0)) {
                v += h1.a(i40, v1, object1);
            }
            return v;
        }
        return h1.a(i40, v1, object0);
    }

    public final int c() {
        int v1 = 0;
        for(int v = 0; v < this.a.b(); ++v) {
            v1 += h1.k(this.a.g(v));
        }
        for(Object object0: this.a.c()) {
            v1 += h1.k(((Map.Entry)object0));
        }
        return v1;
    }

    @Override
    public final Object clone() {
        h1 h10 = new h1();
        for(int v = 0; v < this.a.b(); ++v) {
            Map.Entry map$Entry0 = this.a.g(v);
            d.a(map$Entry0.getKey());
            h10.g(null, map$Entry0.getValue());
        }
        for(Object object0: this.a.c()) {
            d.a(((Map.Entry)object0).getKey());
            h10.g(null, ((Map.Entry)object0).getValue());
        }
        h10.c = this.c;
        return h10;
    }

    public final Iterator d() {
        return this.c ? new z1(this.a.entrySet().iterator()) : this.a.entrySet().iterator();
    }

    public final void e() {
        if(!this.b) {
            for(int v = 0; v < this.a.b(); ++v) {
                Map.Entry map$Entry0 = this.a.g(v);
                if(map$Entry0.getValue() instanceof n1) {
                    ((n1)map$Entry0.getValue()).s();
                }
            }
            this.a.a();
            this.b = true;
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof h1 ? this.a.equals(((h1)object0).a) : false;
    }

    public final void f(h1 h10) {
        for(int v = 0; v < h10.a.b(); ++v) {
            this.i(h10.a.g(v));
        }
        for(Object object0: h10.a.c()) {
            this.i(((Map.Entry)object0));
        }
    }

    public final void g(g1 g10, Object object0) {
        if(g10.h()) {
            if(!(object0 instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList0 = new ArrayList();
            arrayList0.addAll(((List)object0));
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                h1.l(g10, arrayList0.get(v1));
            }
            object0 = arrayList0;
        }
        else {
            h1.l(g10, object0);
        }
        this.a.e(g10, object0);
    }

    public final boolean h() {
        for(int v = 0; v < this.a.b(); ++v) {
            if(!h1.j(this.a.g(v))) {
                return false;
            }
        }
        for(Object object0: this.a.c()) {
            if(!h1.j(((Map.Entry)object0))) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    private final void i(Map.Entry map$Entry0) {
        d.a(map$Entry0.getKey());
        map$Entry0.getValue();
        throw null;
    }

    private static boolean j(Map.Entry map$Entry0) {
        d.a(map$Entry0.getKey());
        throw null;
    }

    private static final int k(Map.Entry map$Entry0) {
        d.a(map$Entry0.getKey());
        map$Entry0.getValue();
        throw null;
    }

    private static final void l(g1 g10, Object object0) {
        boolean z;
        i4 i40 = g10.e();
        object0.getClass();
        switch(i40.c().ordinal()) {
            case 0: {
                z = object0 instanceof Integer;
                goto label_15;
            }
            case 1: {
                z = object0 instanceof Long;
                goto label_15;
            }
            case 2: {
                z = object0 instanceof Float;
                goto label_15;
            }
            case 3: {
                z = object0 instanceof Double;
                goto label_15;
            }
            case 4: {
                z = object0 instanceof Boolean;
                goto label_15;
            }
            case 5: {
                z = object0 instanceof String;
            label_15:
                if(z) {
                    return;
                }
                break;
            }
            case 6: {
                if(object0 instanceof q0 || object0 instanceof byte[]) {
                    return;
                }
                break;
            }
            case 7: {
                if(object0 instanceof Integer || object0 instanceof p1) {
                    return;
                }
                break;
            }
            case 8: {
                if(object0 instanceof r2) {
                    return;
                }
            }
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", g10.a(), g10.e().c(), object0.getClass().getName()));
    }
}

