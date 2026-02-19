package com.google.android.gms.internal.play_billing;

import java.util.Objects;

final class p extends j {
    final transient Object[] h;
    private final transient int i;
    static final j j;

    static {
        p.j = new p(new Object[0], 0);
    }

    p(Object[] arr_object, int v) {
        this.h = arr_object;
        this.i = v;
    }

    @Override  // com.google.android.gms.internal.play_billing.j
    final int e(Object[] arr_object, int v) {
        System.arraycopy(this.h, 0, arr_object, 0, this.i);
        return this.i;
    }

    @Override
    public final Object get(int v) {
        b.a(v, this.i, "index");
        Object object0 = this.h[v];
        Objects.requireNonNull(object0);
        return object0;
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    final int n() {
        return this.i;
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    final int o() {
        return 0;
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    final boolean q() {
        return false;
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    final Object[] r() {
        return this.h;
    }

    @Override
    public final int size() {
        return this.i;
    }
}

