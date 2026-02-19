package com.android.billingclient.api;

import android.content.Context;
import com.google.android.datatransport.cct.a;
import com.google.android.gms.internal.play_billing.a0;
import com.google.android.gms.internal.play_billing.r5;
import d0.p;
import h0.b;
import h0.c;
import h0.f;
import h0.g;
import j0.t;

final class u {
    private boolean a;
    private f b;

    u(Context context0) {
        try {
            t.f(context0);
            g g0 = t.c().g(a.g);
            b b0 = b.b("proto");
            p p0 = new p();
            this.b = g0.a("PLAY_BILLING_LIBRARY", r5.class, b0, p0);
        }
        catch(Throwable unused_ex) {
            this.a = true;
        }
    }

    public final void a(r5 r50) {
        String s;
        try {
            if(!this.a) {
                this.b.a(c.d(r50));
                return;
            }
            s = "Skipping logging since initialization failed.";
        }
        catch(Throwable unused_ex) {
            s = "logging failed.";
        }
        a0.i("BillingLogger", s);
    }
}

