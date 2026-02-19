package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.j;
import d0.c;
import d0.t;
import java.util.concurrent.Callable;

final class m implements Callable {
    final String a;
    final c b;
    final b c;

    m(b b0, String s, c c0) {
        this.a = s;
        this.b = c0;
        this.c = b0;
        super();
    }

    @Override
    public final Object call() {
        t t0 = b.D(this.c, this.a, 9);
        if(t0.b() != null) {
            this.b.a(t0.a(), t0.b());
            return null;
        }
        this.b.a(t0.a(), j.v());
        return null;
    }
}

