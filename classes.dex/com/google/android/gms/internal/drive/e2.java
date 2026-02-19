package com.google.android.gms.internal.drive;

import java.util.Map.Entry;

final class e2 implements Comparable, Map.Entry {
    private final Comparable e;
    private Object f;
    private final x1 g;

    e2(x1 x10, Comparable comparable0, Object object0) {
        this.g = x10;
        super();
        this.e = comparable0;
        this.f = object0;
    }

    e2(x1 x10, Map.Entry map$Entry0) {
        this(x10, ((Comparable)map$Entry0.getKey()), map$Entry0.getValue());
    }

    private static boolean c(Object object0, Object object1) {
        return object0 == null ? object1 == null : object0.equals(object1);
    }

    @Override
    public final int compareTo(Object object0) {
        return ((Comparable)this.getKey()).compareTo(((Comparable)((e2)object0).getKey()));
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof Map.Entry)) {
            return false;
        }
        Object object1 = ((Map.Entry)object0).getKey();
        return e2.c(this.e, object1) && e2.c(this.f, ((Map.Entry)object0).getValue());
    }

    @Override
    public final Object getKey() {
        return this.e;
    }

    @Override
    public final Object getValue() {
        return this.f;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.e == null ? 0 : this.e.hashCode();
        Object object0 = this.f;
        if(object0 != null) {
            v = object0.hashCode();
        }
        return v1 ^ v;
    }

    @Override
    public final Object setValue(Object object0) {
        this.g.p();
        Object object1 = this.f;
        this.f = object0;
        return object1;
    }

    @Override
    public final String toString() {
        return this.e + "=" + this.f;
    }
}

