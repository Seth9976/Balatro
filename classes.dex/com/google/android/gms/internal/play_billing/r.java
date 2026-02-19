package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map.Entry;

final class r extends n {
    private final transient m g;
    private final transient Object[] h;
    private final transient int i;

    r(m m0, Object[] arr_object, int v, int v1) {
        this.g = m0;
        this.h = arr_object;
        this.i = v1;
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    public final boolean contains(Object object0) {
        if(object0 instanceof Map.Entry) {
            Object object1 = ((Map.Entry)object0).getKey();
            Object object2 = ((Map.Entry)object0).getValue();
            return object2 != null && object2.equals(this.g.get(object1));
        }
        return false;
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    final int e(Object[] arr_object, int v) {
        return this.p().e(arr_object, 0);
    }

    @Override
    public final Iterator iterator() {
        return this.p().w(0);
    }

    @Override  // com.google.android.gms.internal.play_billing.n
    final j s() {
        return new q(this);
    }

    @Override
    public final int size() {
        return this.i;
    }
}

