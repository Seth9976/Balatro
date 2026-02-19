package com.android.billingclient.api;

import d0.c;

public final class h implements Runnable {
    public final b e;
    public final c f;

    public h(b b0, c c0) {
        this.e = b0;
        this.f = c0;
    }

    @Override
    public final void run() {
        this.e.B(this.f);
    }
}

