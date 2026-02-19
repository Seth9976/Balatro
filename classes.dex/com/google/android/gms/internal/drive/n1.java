package com.google.android.gms.internal.drive;

import h.d;
import java.util.Iterator;
import java.util.Map.Entry;

final class n1 implements u1 {
    private final i1 a;
    private final l2 b;
    private final boolean c;
    private final b0 d;

    private n1(l2 l20, b0 b00, i1 i10) {
        this.b = l20;
        this.c = b00.f(i10);
        this.d = b00;
        this.a = i10;
    }

    @Override  // com.google.android.gms.internal.drive.u1
    public final int a(Object object0) {
        Object object1 = this.b.g(object0);
        int v = this.b.h(object1);
        return this.c ? v + this.d.c(object0).m() : v;
    }

    @Override  // com.google.android.gms.internal.drive.u1
    public final void b(Object object0, f3 f30) {
        Iterator iterator0 = this.d.c(object0).c();
        if(!iterator0.hasNext()) {
            Object object1 = this.b.g(object0);
            this.b.b(object1, f30);
            return;
        }
        Object object2 = iterator0.next();
        d.a(((Map.Entry)object2).getKey());
        throw null;
    }

    @Override  // com.google.android.gms.internal.drive.u1
    public final void c(Object object0, Object object1) {
        w1.g(this.b, object0, object1);
        if(this.c) {
            w1.e(this.d, object0, object1);
        }
    }

    @Override  // com.google.android.gms.internal.drive.u1
    public final boolean d(Object object0) {
        return this.d.c(object0).b();
    }

    @Override  // com.google.android.gms.internal.drive.u1
    public final boolean e(Object object0, Object object1) {
        if(!this.b.g(object0).equals(this.b.g(object1))) {
            return false;
        }
        return this.c ? this.d.c(object0).equals(this.d.c(object1)) : true;
    }

    @Override  // com.google.android.gms.internal.drive.u1
    public final int f(Object object0) {
        int v = this.b.g(object0).hashCode();
        return this.c ? v * 53 + this.d.c(object0).hashCode() : v;
    }

    @Override  // com.google.android.gms.internal.drive.u1
    public final void g(Object object0) {
        this.b.c(object0);
        this.d.e(object0);
    }

    static n1 h(l2 l20, b0 b00, i1 i10) {
        return new n1(l20, b00, i10);
    }
}

