package com.android.billingclient.api;

import android.content.Context;
import com.google.android.gms.internal.play_billing.a0;
import com.google.android.gms.internal.play_billing.g5;
import com.google.android.gms.internal.play_billing.h5;
import com.google.android.gms.internal.play_billing.n4;
import com.google.android.gms.internal.play_billing.q5;
import com.google.android.gms.internal.play_billing.r4;
import com.google.android.gms.internal.play_billing.r5;
import com.google.android.gms.internal.play_billing.y5;

final class t implements r {
    private h5 b;
    private final u c;

    t(Context context0, h5 h50) {
        u u0 = new u(context0);
        super();
        this.c = u0;
        this.b = h50;
    }

    @Override  // com.android.billingclient.api.r
    public final void a(r4 r40, int v) {
        try {
            g5 g50 = (g5)this.b.j();
            g50.o(v);
            this.b = (h5)g50.j();
            this.d(r40);
        }
        catch(Throwable throwable0) {
            a0.j("BillingLogger", "Unable to log.", throwable0);
        }
    }

    @Override  // com.android.billingclient.api.r
    public final void b(n4 n40, int v) {
        try {
            g5 g50 = (g5)this.b.j();
            g50.o(v);
            this.b = (h5)g50.j();
            this.c(n40);
        }
        catch(Throwable throwable0) {
            a0.j("BillingLogger", "Unable to log.", throwable0);
        }
    }

    @Override  // com.android.billingclient.api.r
    public final void c(n4 n40) {
        if(n40 == null) {
            return;
        }
        try {
            q5 q50 = r5.F();
            q50.q(this.b);
            q50.o(n40);
            r5 r50 = (r5)q50.j();
            this.c.a(r50);
        }
        catch(Throwable throwable0) {
            a0.j("BillingLogger", "Unable to log.", throwable0);
        }
    }

    @Override  // com.android.billingclient.api.r
    public final void d(r4 r40) {
        if(r40 == null) {
            return;
        }
        try {
            q5 q50 = r5.F();
            q50.q(this.b);
            q50.p(r40);
            r5 r50 = (r5)q50.j();
            this.c.a(r50);
        }
        catch(Throwable throwable0) {
            a0.j("BillingLogger", "Unable to log.", throwable0);
        }
    }

    @Override  // com.android.billingclient.api.r
    public final void e(y5 y50) {
        if(y50 == null) {
            return;
        }
        try {
            q5 q50 = r5.F();
            q50.q(this.b);
            q50.r(y50);
            r5 r50 = (r5)q50.j();
            this.c.a(r50);
        }
        catch(Throwable throwable0) {
            a0.j("BillingLogger", "Unable to log.", throwable0);
        }
    }
}

