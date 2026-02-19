package com.google.android.gms.common.api.internal;

final class j implements Runnable {
    final n e;

    j(n n0) {
        this.e = n0;
        super();
    }

    @Override
    public final void run() {
        this.e.k();
    }
}

