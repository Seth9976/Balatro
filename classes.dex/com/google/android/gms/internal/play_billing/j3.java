package com.google.android.gms.internal.play_billing;

import java.util.Map.Entry;

final class j3 implements Comparable, Map.Entry {
    private final Comparable e;
    private Object f;
    final p3 g;

    j3(p3 p30, Comparable comparable0, Object object0) {
        this.g = p30;
        super();
        this.e = comparable0;
        this.f = object0;
    }

    public final Comparable c() {
        return this.e;
    }

    @Override
    public final int compareTo(Object object0) {
        return this.e.compareTo(((j3)object0).e);
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
        return j3.j(this.e, object1) && j3.j(this.f, ((Map.Entry)object0).getValue());
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

    private static final boolean j(Object object0, Object object1) {
        return object0 == null ? object1 == null : object0.equals(object1);
    }

    @Override
    public final Object setValue(Object object0) {
        this.g.n();
        Object object1 = this.f;
        this.f = object0;
        return object1;
    }

    @Override
    public final String toString() {
        return this.e + "=" + this.f;
    }
}

