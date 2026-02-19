package com.google.android.gms.common.api.internal;

final class k implements Runnable {
    final int e;
    final n f;

    k(n n0, int v) {
        this.f = n0;
        this.e = v;
        super();
    }

    @Override
    public final void run() {
        this.f.l(this.e);
    }
}

