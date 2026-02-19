package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final class i implements Callable {
    public final b a;
    public final g b;
    public final d0.b c;

    public i(b b0, g g0, d0.b b1) {
        this.a = b0;
        this.b = g0;
        this.c = b1;
    }

    @Override
    public final Object call() {
        this.a.Y(this.b, this.c);
        return null;
    }
}

