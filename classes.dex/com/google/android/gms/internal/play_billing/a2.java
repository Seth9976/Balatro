package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class a2 extends b0 implements b2, RandomAccess {
    private final List f;
    private static final a2 g;
    public static final b2 h;

    static {
        a2 a20 = new a2(false);
        a2.g = a20;
        a2.h = a20;
    }

    public a2(int v) {
        ArrayList arrayList0 = new ArrayList(v);
        super(true);
        this.f = arrayList0;
    }

    private a2(ArrayList arrayList0) {
        super(true);
        this.f = arrayList0;
    }

    private a2(boolean z) {
        super(false);
        this.f = Collections.emptyList();
    }

    @Override
    public final void add(int v, Object object0) {
        this.e();
        this.f.add(v, ((String)object0));
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.play_billing.b0
    public final boolean addAll(int v, Collection collection0) {
        this.e();
        if(collection0 instanceof b2) {
            collection0 = ((b2)collection0).g();
        }
        boolean z = this.f.addAll(v, collection0);
        ++this.modCount;
        return z;
    }

    @Override  // com.google.android.gms.internal.play_billing.b0
    public final boolean addAll(Collection collection0) {
        return this.addAll(this.size(), collection0);
    }

    @Override  // com.google.android.gms.internal.play_billing.b0
    public final void clear() {
        this.e();
        this.f.clear();
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.play_billing.u1
    public final u1 d(int v) {
        if(v < this.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList0 = new ArrayList(v);
        arrayList0.addAll(this.f);
        return new a2(arrayList0);
    }

    @Override  // com.google.android.gms.internal.play_billing.b2
    public final b2 f() {
        return this.c() ? new x3(this) : this;
    }

    @Override  // com.google.android.gms.internal.play_billing.b2
    public final List g() {
        return Collections.unmodifiableList(this.f);
    }

    @Override
    public final Object get(int v) {
        return this.n(v);
    }

    @Override  // com.google.android.gms.internal.play_billing.b2
    public final Object m(int v) {
        return this.f.get(v);
    }

    public final String n(int v) {
        Object object0 = this.f.get(v);
        if(object0 instanceof String) {
            return (String)object0;
        }
        if(object0 instanceof q0) {
            String s = ((q0)object0).x(v1.b);
            if(((q0)object0).t()) {
                this.f.set(v, s);
            }
            return s;
        }
        String s1 = v1.d(((byte[])object0));
        if(h4.d(((byte[])object0))) {
            this.f.set(v, s1);
        }
        return s1;
    }

    private static String o(Object object0) {
        if(object0 instanceof String) {
            return (String)object0;
        }
        return object0 instanceof q0 ? ((q0)object0).x(v1.b) : v1.d(((byte[])object0));
    }

    @Override  // com.google.android.gms.internal.play_billing.b0
    public final Object remove(int v) {
        this.e();
        Object object0 = this.f.remove(v);
        ++this.modCount;
        return a2.o(object0);
    }

    @Override
    public final Object set(int v, Object object0) {
        this.e();
        return a2.o(this.f.set(v, ((String)object0)));
    }

    @Override
    public final int size() {
        return this.f.size();
    }
}

