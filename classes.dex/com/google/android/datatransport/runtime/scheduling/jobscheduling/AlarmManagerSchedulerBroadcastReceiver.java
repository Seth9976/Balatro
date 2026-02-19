package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import j0.o.a;
import j0.o;
import j0.t;

public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static void a() {
    }

    private static void b() {
    }

    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context0, Intent intent0) {
        String s = intent0.getData().getQueryParameter("backendName");
        String s1 = intent0.getData().getQueryParameter("extras");
        int v = (int)Integer.valueOf(intent0.getData().getQueryParameter("priority"));
        int v1 = intent0.getExtras().getInt("attemptNumber");
        t.f(context0);
        a o$a0 = o.a().b(s).d(u0.a.b(v));
        if(s1 != null) {
            o$a0.c(Base64.decode(s1, 0));
        }
        t.c().e().v(o$a0.a(), v1, new q0.a());
    }
}

