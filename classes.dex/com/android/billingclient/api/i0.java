package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final class i0 implements Callable {
    public final b a;
    public final String b;
    public final String c;

    public i0(b b0, String s, String s1) {
        this.a = b0;
        this.b = s;
        this.c = s1;
    }

    @Override
    public final Object call() {
        return this.a.S(this.b, this.c);
    }
}

