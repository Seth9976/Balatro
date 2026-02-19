package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public abstract class m implements Serializable, Map {
    private transient n e;
    private transient n f;
    private transient g g;

    abstract g a();

    public final g b() {
        g g0 = this.g;
        if(g0 == null) {
            g0 = this.a();
            this.g = g0;
        }
        return g0;
    }

    public static m c(Object object0, Object object1, Object object2, Object object3, Object object4, Object object5) {
        e.a("com.android.vending.billing.PURCHASES_UPDATED", object1);
        e.a("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED", object3);
        e.a("com.android.vending.billing.ALTERNATIVE_BILLING", object5);
        return u.g(3, new Object[]{"com.android.vending.billing.PURCHASES_UPDATED", object1, "com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED", object3, "com.android.vending.billing.ALTERNATIVE_BILLING", object5}, null);
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean containsKey(Object object0) {
        return this.get(object0) != null;
    }

    @Override
    public final boolean containsValue(Object object0) {
        return this.b().contains(object0);
    }

    abstract n d();

    abstract n e();

    @Override
    public final Set entrySet() {
        return this.f();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Map ? this.entrySet().equals(((Map)object0).entrySet()) : false;
    }

    public final n f() {
        n n0 = this.e;
        if(n0 == null) {
            n0 = this.d();
            this.e = n0;
        }
        return n0;
    }

    @Override
    public abstract Object get(Object arg1);

    @Override
    public final Object getOrDefault(Object object0, Object object1) {
        Object object2 = this.get(object0);
        return object2 == null ? object1 : object2;
    }

    @Override
    public final int hashCode() {
        return v.a(this.f());
    }

    @Override
    public final boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public final Set keySet() {
        n n0 = this.f;
        if(n0 == null) {
            n0 = this.e();
            this.f = n0;
        }
        return n0;
    }

    @Override
    public final Object put(Object object0, Object object1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void putAll(Map map0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Object remove(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final String toString() {
        int v = this.size();
        if(v < 0) {
            throw new IllegalArgumentException("size cannot be negative but was: " + v);
        }
        StringBuilder stringBuilder0 = new StringBuilder(((int)Math.min(((long)v) * 8L, 0x40000000L)));
        stringBuilder0.append('{');
        boolean z = true;
        for(Object object0: this.entrySet()) {
            if(!z) {
                stringBuilder0.append(", ");
            }
            stringBuilder0.append(((Map.Entry)object0).getKey());
            stringBuilder0.append('=');
            stringBuilder0.append(((Map.Entry)object0).getValue());
            z = false;
        }
        stringBuilder0.append('}');
        return stringBuilder0.toString();
    }

    @Override
    public final Collection values() {
        return this.b();
    }
}

