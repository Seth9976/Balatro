package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;
import d0.d;
import d0.f;
import d0.m;
import d0.q;

final class g0 {
    private final Context a;
    private final d b;
    private final r c;
    private final f0 d;
    private final f0 e;
    private boolean f;

    g0(Context context0, d d0, q q0, m m0, f f0, r r0) {
        this.a = context0;
        this.b = d0;
        this.c = r0;
        this.d = new f0(this, true);
        this.e = new f0(this, false);
    }

    static m a(g0 g00) {
        g00.getClass();
        return null;
    }

    static d c(g0 g00) {
        return g00.b;
    }

    final d d() {
        return this.b;
    }

    static f e(g0 g00) {
        g00.getClass();
        return null;
    }

    final void f(boolean z) {
        IntentFilter intentFilter0 = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter1 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter1.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f = z;
        this.e.a(this.a, intentFilter1);
        if(this.f) {
            this.d.b(this.a, intentFilter0, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST");
            return;
        }
        this.d.a(this.a, intentFilter0);
    }
}

