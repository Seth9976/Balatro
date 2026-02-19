package com.android.billingclient.api;

public final class h0 implements Runnable {
    public final b e;
    public final d f;

    public h0(b b0, d d0) {
        this.e = b0;
        this.f = d0;
    }

    @Override
    public final void run() {
        this.e.y(this.f);
    }
}

