package com.android.billingclient.api;

import android.os.Bundle;
import java.util.concurrent.Callable;

public final class k implements Callable {
    public final b a;
    public final int b;
    public final String c;
    public final String d;
    public final c e;
    public final Bundle f;

    public k(b b0, int v, String s, String s1, c c0, Bundle bundle0) {
        this.a = b0;
        this.b = v;
        this.c = s;
        this.d = s1;
        this.e = c0;
        this.f = bundle0;
    }

    @Override
    public final Object call() {
        return this.a.R(this.b, this.c, this.d, this.e, this.f);
    }
}

