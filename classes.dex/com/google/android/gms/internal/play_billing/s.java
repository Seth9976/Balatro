package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

final class s extends n {
    private final transient m g;
    private final transient j h;

    s(m m0, j j0) {
        this.g = m0;
        this.h = j0;
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    public final boolean contains(Object object0) {
        return this.g.get(object0) != null;
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    final int e(Object[] arr_object, int v) {
        return this.h.e(arr_object, 0);
    }

    @Override
    public final Iterator iterator() {
        return this.h.w(0);
    }

    @Override  // com.google.android.gms.internal.play_billing.n
    public final j p() {
        return this.h;
    }

    @Override
    public final int size() {
        return this.g.size();
    }
}

