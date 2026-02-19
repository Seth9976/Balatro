package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.a0;
import com.google.android.gms.internal.play_billing.c;
import com.google.android.gms.internal.play_billing.d6;
import com.google.android.gms.internal.play_billing.e6;
import com.google.android.gms.internal.play_billing.n4;
import com.google.android.gms.internal.play_billing.y5;
import d0.a;
import d0.g;

final class p implements ServiceConnection {
    private final Object a;
    private boolean b;
    private a c;
    final b d;

    p(b b0, a a0, g g0) {
        this.d = b0;
        super();
        this.a = new Object();
        this.b = false;
        this.c = a0;
    }

    final Object a() {
        String s;
        int v2;
        Bundle bundle0;
        synchronized(this.a) {
            if(this.b) {
                return null;
            }
        }
        if(TextUtils.isEmpty(null)) {
            bundle0 = null;
        }
        else {
            bundle0 = new Bundle();
            bundle0.putString("accountName", null);
        }
        int v = 3;
        int v1 = 22;
        try {
            while(v1 >= 3) {
                v = bundle0 == null ? this.d.g.E(v1, "com.playstack.balatro.android", "subs") : this.d.g.t(v1, "com.playstack.balatro.android", "subs", bundle0);
                if(v != 0) {
                    --v1;
                    continue;
                }
                a0.h("BillingClient", "highestLevelSupportedForSubs: " + v1);
                goto label_21;
            }
            v1 = 0;
        label_21:
            boolean z = true;
            this.d.j = v1 >= 5;
            this.d.i = v1 >= 3;
            if(v1 < 3) {
                a0.h("BillingClient", "In-app billing API does not support subscription on this device.");
                v2 = 9;
            }
            else {
                v2 = 1;
            }
            int v3 = 22;
            while(v3 >= 3) {
                v = bundle0 == null ? this.d.g.E(v3, "com.playstack.balatro.android", "inapp") : this.d.g.t(v3, "com.playstack.balatro.android", "inapp", bundle0);
                if(v == 0) {
                    this.d.k = v3;
                    a0.h("BillingClient", "mHighestLevelSupportedForInApp: " + this.d.k);
                    if(true) {
                        break;
                    }
                }
                else {
                    --v3;
                }
            }
            this.d.y = this.d.k >= 22;
            this.d.x = this.d.k >= 21;
            this.d.w = this.d.k >= 20;
            this.d.v = this.d.k >= 19;
            this.d.u = this.d.k >= 18;
            this.d.t = this.d.k >= 17;
            this.d.s = this.d.k >= 16;
            this.d.r = this.d.k >= 15;
            this.d.q = this.d.k >= 14;
            this.d.p = this.d.k >= 12;
            this.d.o = this.d.k >= 10;
            this.d.n = this.d.k >= 9;
            this.d.m = this.d.k >= 8;
            b b0 = this.d;
            if(b0.k < 6) {
                z = false;
            }
            b0.l = z;
            if(this.d.k < 3) {
                a0.i("BillingClient", "In-app billing API version 3 is not supported on this device.");
                v2 = 36;
            }
            if(v == 0) {
                this.d.a = 2;
                if(this.d.d != null) {
                    this.d.d.f(this.d.x);
                }
            }
            else {
                this.d.a = 0;
                this.d.g = null;
            }
            s = null;
        }
        catch(Exception exception0) {
            a0.j("BillingClient", "Exception while checking if billing is supported; try to reconnect", exception0);
            if(exception0 instanceof DeadObjectException) {
                v2 = 101;
            }
            else if(exception0 instanceof RemoteException) {
                v2 = 100;
            }
            else {
                v2 = exception0 instanceof SecurityException ? 102 : 42;
            }
            if(v2 == 42) {
                s = exception0.getClass().getSimpleName() + ": " + c.b(exception0.getMessage());
                if(s.length() > 70) {
                    s = s.substring(0, 70);
                }
            }
            else {
                s = null;
            }
            this.d.a = 0;
            this.d.g = null;
        }
        if(v == 0) {
            b.F(this.d, 6);
            this.c(s.l);
            return null;
        }
        n4 n40 = q.b(v2, 6, s.a, s);
        this.d.M(n40);
        this.c(s.a);
        return null;
    }

    // 检测为 Lambda 实现
    final void b() [...]

    private final void c(d d0) {
        synchronized(this.a) {
            a a0 = this.c;
            if(a0 != null) {
                a0.b(d0);
            }
        }
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        a0.h("BillingClient", "Billing service connected.");
        e6 e60 = d6.a(iBinder0);
        this.d.g = e60;
        n n0 = new n(this);
        o o0 = () -> {
            this.d.a = 0;
            this.d.g = null;
            b.E(this.d, 24, 6, s.n);
            this.c(s.n);
        };
        Handler handler0 = this.d.G();
        if(b.Z(this.d, n0, 30000L, o0, handler0) == null) {
            d d0 = this.d.I();
            b.E(this.d, 25, 6, d0);
            this.c(d0);
        }
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        a0.i("BillingClient", "Billing service disconnected.");
        this.d.f.e(y5.C());
        this.d.g = null;
        this.d.a = 0;
        synchronized(this.a) {
            a a0 = this.c;
            if(a0 != null) {
                a0.a();
            }
        }
    }
}

