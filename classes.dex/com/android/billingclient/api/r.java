package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.b5;
import com.google.android.gms.internal.play_billing.m;
import com.google.android.gms.internal.play_billing.n4;
import com.google.android.gms.internal.play_billing.r4;
import com.google.android.gms.internal.play_billing.y5;

interface r {
    public static final m a;

    static {
        r.a = m.c("com.android.vending.billing.PURCHASES_UPDATED", b5.g, "com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED", b5.h, "com.android.vending.billing.ALTERNATIVE_BILLING", b5.i);
    }

    void a(r4 arg1, int arg2);

    void b(n4 arg1, int arg2);

    void c(n4 arg1);

    void d(r4 arg1);

    void e(y5 arg1);
}

