package com.google.android.gms.internal.play_billing;

import java.util.List;

final class i extends j {
    final transient int h;
    final transient int i;
    final j j;

    i(j j0, int v, int v1) {
        this.j = j0;
        super();
        this.h = v;
        this.i = v1;
    }

    @Override
    public final Object get(int v) {
        b.a(v, this.i, "index");
        return this.j.get(v + this.h);
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    final int n() {
        return this.j.o() + this.h + this.i;
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    final int o() {
        return this.j.o() + this.h;
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    final boolean q() {
        return true;
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    final Object[] r() {
        return this.j.r();
    }

    @Override  // com.google.android.gms.internal.play_billing.j
    public final j s(int v, int v1) {
        b.d(v, v1, this.i);
        return this.j.s(v + this.h, v1 + this.h);
    }

    @Override
    public final int size() {
        return this.i;
    }

    @Override  // com.google.android.gms.internal.play_billing.j
    public final List subList(int v, int v1) {
        return this.s(v, v1);
    }
}

