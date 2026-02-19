package com.google.android.gms.internal.drive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class s0 extends f implements t0, RandomAccess {
    private final List f;
    private static final s0 g;
    private static final t0 h;

    static {
        s0 s00 = new s0();
        s0.g = s00;
        s00.l();
        s0.h = s00;
    }

    public s0() {
        this(10);
    }

    public s0(int v) {
        this(new ArrayList(v));
    }

    private s0(ArrayList arrayList0) {
        this.f = arrayList0;
    }

    @Override  // com.google.android.gms.internal.drive.t0
    public final Object a(int v) {
        return this.f.get(v);
    }

    @Override
    public final void add(int v, Object object0) {
        this.e();
        this.f.add(v, ((String)object0));
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.drive.f
    public final boolean addAll(int v, Collection collection0) {
        this.e();
        if(collection0 instanceof t0) {
            collection0 = ((t0)collection0).k();
        }
        boolean z = this.f.addAll(v, collection0);
        ++this.modCount;
        return z;
    }

    @Override  // com.google.android.gms.internal.drive.f
    public final boolean addAll(Collection collection0) {
        return this.addAll(this.size(), collection0);
    }

    @Override
    public final void clear() {
        this.e();
        this.f.clear();
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.drive.f
    public final boolean equals(Object object0) {
        return super.equals(object0);
    }

    @Override
    public final Object get(int v) {
        Object object0 = this.f.get(v);
        if(object0 instanceof String) {
            return (String)object0;
        }
        if(object0 instanceof i) {
            String s = ((i)object0).t();
            if(((i)object0).u()) {
                this.f.set(v, s);
            }
            return s;
        }
        String s1 = m0.g(((byte[])object0));
        if(m0.e(((byte[])object0))) {
            this.f.set(v, s1);
        }
        return s1;
    }

    @Override  // com.google.android.gms.internal.drive.f
    public final boolean h() {
        return super.h();
    }

    @Override  // com.google.android.gms.internal.drive.f
    public final int hashCode() {
        return super.hashCode();
    }

    @Override  // com.google.android.gms.internal.drive.t0
    public final t0 i() {
        return this.h() ? new o2(this) : this;
    }

    @Override  // com.google.android.gms.internal.drive.n0
    public final n0 j(int v) {
        if(v < this.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList0 = new ArrayList(v);
        arrayList0.addAll(this.f);
        return new s0(arrayList0);
    }

    @Override  // com.google.android.gms.internal.drive.t0
    public final List k() {
        return Collections.unmodifiableList(this.f);
    }

    private static String n(Object object0) {
        if(object0 instanceof String) {
            return (String)object0;
        }
        return object0 instanceof i ? ((i)object0).t() : m0.g(((byte[])object0));
    }

    @Override
    public final Object remove(int v) {
        this.e();
        Object object0 = this.f.remove(v);
        ++this.modCount;
        return s0.n(object0);
    }

    @Override  // com.google.android.gms.internal.drive.f
    public final boolean remove(Object object0) {
        return super.remove(object0);
    }

    @Override  // com.google.android.gms.internal.drive.f
    public final boolean removeAll(Collection collection0) {
        return super.removeAll(collection0);
    }

    @Override  // com.google.android.gms.internal.drive.f
    public final boolean retainAll(Collection collection0) {
        return super.retainAll(collection0);
    }

    @Override
    public final Object set(int v, Object object0) {
        this.e();
        return s0.n(this.f.set(v, ((String)object0)));
    }

    @Override
    public final int size() {
        return this.f.size();
    }
}

