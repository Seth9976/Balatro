package com.google.android.gms.internal.play_billing;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Objects;

final class q extends j {
    final r h;

    q(r r0) {
        this.h = r0;
        super();
    }

    @Override
    public final Object get(int v) {
        b.a(v, this.h.i, "index");
        int v1 = v + v;
        Object object0 = this.h.h[v1];
        Objects.requireNonNull(object0);
        Object object1 = this.h.h[v1 + 1];
        Objects.requireNonNull(object1);
        return new AbstractMap.SimpleImmutableEntry(object0, object1);
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    public final boolean q() {
        return true;
    }

    @Override
    public final int size() {
        return this.h.i;
    }
}

