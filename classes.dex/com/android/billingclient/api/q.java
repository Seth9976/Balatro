package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.a0;
import com.google.android.gms.internal.play_billing.m4;
import com.google.android.gms.internal.play_billing.n4;
import com.google.android.gms.internal.play_billing.q4;
import com.google.android.gms.internal.play_billing.r4;
import com.google.android.gms.internal.play_billing.t4;
import com.google.android.gms.internal.play_billing.x4;

public abstract class q {
    static {
    }

    public static n4 a(int v, int v1, d d0) {
        try {
            m4 m40 = n4.E();
            t4 t40 = x4.F();
            t40.q(d0.b());
            t40.p(d0.a());
            t40.r(v);
            m40.o(t40);
            m40.p(v1);
            return (n4)m40.j();
        }
        catch(Exception exception0) {
            a0.j("BillingLogger", "Unable to create logging payload", exception0);
            return null;
        }
    }

    public static n4 b(int v, int v1, d d0, String s) {
        try {
            t4 t40 = x4.F();
            t40.q(d0.b());
            t40.p(d0.a());
            t40.r(v);
            if(s != null) {
                t40.o(s);
            }
            m4 m40 = n4.E();
            m40.o(t40);
            m40.p(v1);
            return (n4)m40.j();
        }
        catch(Exception exception0) {
            a0.j("BillingLogger", "Unable to create logging payload", exception0);
            return null;
        }
    }

    public static r4 c(int v) {
        try {
            q4 q40 = r4.C();
            q40.o(v);
            return (r4)q40.j();
        }
        catch(Exception exception0) {
            a0.j("BillingLogger", "Unable to create logging payload", exception0);
            return null;
        }
    }
}

