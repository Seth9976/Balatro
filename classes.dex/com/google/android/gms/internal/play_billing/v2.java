package com.google.android.gms.internal.play_billing;

import h.d;
import java.util.Iterator;
import java.util.Map.Entry;

final class v2 implements c3 {
    private final r2 a;
    private final s3 b;
    private final boolean c;
    private final d1 d;

    private v2(s3 s30, d1 d10, r2 r20) {
        this.b = s30;
        this.c = d10.f(r20);
        this.d = d10;
        this.a = r20;
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final boolean a(Object object0) {
        return this.d.b(object0).h();
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final void b(Object object0) {
        this.b.g(object0);
        this.d.d(object0);
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final void c(Object object0, byte[] arr_b, int v, int v1, d0 d00) {
        if(((n1)object0).zzc == t3.c()) {
            ((n1)object0).zzc = t3.f();
        }
        d.a(object0);
        throw null;
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final void d(Object object0, k4 k40) {
        Iterator iterator0 = this.d.b(object0).d();
        if(!iterator0.hasNext()) {
            Object object1 = this.b.d(object0);
            this.b.i(object1, k40);
            return;
        }
        Object object2 = iterator0.next();
        d.a(((Map.Entry)object2).getKey());
        throw null;
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final int e(Object object0) {
        Object object1 = this.b.d(object0);
        int v = this.b.b(object1);
        return this.c ? v + this.d.b(object0).c() : v;
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final Object f() {
        r2 r20 = this.a;
        return r20 instanceof n1 ? ((n1)r20).m() : r20.a().h();
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final void g(Object object0, Object object1) {
        e3.x(this.b, object0, object1);
        if(this.c) {
            e3.w(this.d, object0, object1);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final boolean h(Object object0, Object object1) {
        if(!this.b.d(object0).equals(this.b.d(object1))) {
            return false;
        }
        return this.c ? this.d.b(object0).equals(this.d.b(object1)) : true;
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final int i(Object object0) {
        int v = this.b.d(object0).hashCode();
        return this.c ? v * 53 + this.d.b(object0).a.hashCode() : v;
    }

    static v2 j(s3 s30, d1 d10, r2 r20) {
        return new v2(s30, d10, r20);
    }
}

