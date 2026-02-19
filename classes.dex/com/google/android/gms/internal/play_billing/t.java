package com.google.android.gms.internal.play_billing;

import java.util.Objects;

final class t extends j {
    private final transient Object[] h;
    private final transient int i;
    private final transient int j;

    t(Object[] arr_object, int v, int v1) {
        this.h = arr_object;
        this.i = v;
        this.j = v1;
    }

    @Override
    public final Object get(int v) {
        b.a(v, this.j, "index");
        Object object0 = this.h[v + v + this.i];
        Objects.requireNonNull(object0);
        return object0;
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    final boolean q() {
        return true;
    }

    @Override
    public final int size() {
        return this.j;
    }
}

