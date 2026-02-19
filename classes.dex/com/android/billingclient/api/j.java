package com.android.billingclient.api;

public final class j implements Runnable {
    public final b e;
    public final d0.b f;

    public j(b b0, d0.b b1) {
        this.e = b0;
        this.f = b1;
    }

    @Override
    public final void run() {
        this.e.z(this.f);
    }
}

