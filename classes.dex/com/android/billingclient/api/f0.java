package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.a0;
import com.google.android.gms.internal.play_billing.c1;
import com.google.android.gms.internal.play_billing.n4;
import com.google.android.gms.internal.play_billing.r4;
import d0.d;
import java.util.List;

final class f0 extends BroadcastReceiver {
    private boolean a;
    private final boolean b;
    final g0 c;

    f0(g0 g00, boolean z) {
        this.c = g00;
        super();
        this.b = z;
    }

    public final void a(Context context0, IntentFilter intentFilter0) {
        synchronized(this) {
            if(this.a) {
                return;
            }
            if(Build.VERSION.SDK_INT >= 33) {
                context0.registerReceiver(this, intentFilter0, (this.b ? 2 : 4));
            }
            else {
                context0.registerReceiver(this, intentFilter0);
            }
            this.a = true;
        }
    }

    public static void a$003(d d0, com.android.billingclient.api.d d1, List list0) {
        d0.a(d1, list0);
    }

    public static void a$011(d d0, com.android.billingclient.api.d d1, List list0) {
        d0.a(d1, list0);
    }

    public static void a$013(d d0, com.android.billingclient.api.d d1, List list0) {
        d0.a(d1, list0);
    }

    public static void a$017(d d0, com.android.billingclient.api.d d1, List list0) {
        d0.a(d1, list0);
    }

    public final void b(Context context0, IntentFilter intentFilter0, String s) {
        synchronized(this) {
            if(this.a) {
                return;
            }
            if(Build.VERSION.SDK_INT >= 33) {
                context0.registerReceiver(this, intentFilter0, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, (this.b ? 2 : 4));
            }
            else {
                context0.registerReceiver(this, intentFilter0, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
            }
            this.a = true;
        }
    }

    public static int b$009(com.android.billingclient.api.d d0) {
        return d0.b();
    }

    public static int b$014(com.android.billingclient.api.d d0) {
        return d0.b();
    }

    private final void c(Bundle bundle0, com.android.billingclient.api.d d0, int v) {
        if(bundle0.getByteArray("FAILURE_LOGGING_PAYLOAD") != null) {
            try {
                this.c.c.c(n4.B(bundle0.getByteArray("FAILURE_LOGGING_PAYLOAD"), c1.a()));
            }
            catch(Throwable unused_ex) {
                a0.i("BillingBroadcastManager", "Failed parsing Api failure.");
            }
            return;
        }
        this.c.c.c(q.a(23, v, d0));
    }

    public static void c$002(r r0, n4 n40) {
        r0.c(n40);
    }

    public static void c$010(f0 f00, Bundle bundle0, com.android.billingclient.api.d d0, int v) {
        f00.c(bundle0, d0, v);
    }

    public static void c$012(r r0, n4 n40) {
        r0.c(n40);
    }

    public static void c$016(f0 f00, Bundle bundle0, com.android.billingclient.api.d d0, int v) {
        f00.c(bundle0, d0, v);
    }

    public static void d$015(r r0, r4 r40) {
        r0.d(r40);
    }

    public static boolean equals$006(String s, Object object0) {
        return s.equals(object0);
    }

    public static boolean equals$007(String s, Object object0) {
        return s.equals(object0);
    }

    public static boolean equals$008(String s, Object object0) {
        return s.equals(object0);
    }

    public static String getAction$004(Intent intent0) {
        return intent0.getAction();
    }

    public static Bundle getExtras$001(Intent intent0) {
        return intent0.getExtras();
    }

    public static String getString$005(BaseBundle baseBundle0, String s) {
        return baseBundle0.getString(s);
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
    }
}

