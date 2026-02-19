package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;

final class g0 extends i0 {
    private int e;
    private final int f;
    final q0 g;

    g0(q0 q00) {
        this.g = q00;
        super();
        this.e = 0;
        this.f = q00.o();
    }

    @Override  // com.google.android.gms.internal.play_billing.k0
    public final byte a() {
        int v = this.e;
        if(v >= this.f) {
            throw new NoSuchElementException();
        }
        this.e = v + 1;
        return this.g.n(v);
    }

    @Override
    public final boolean hasNext() {
        return this.e < this.f;
    }
}

