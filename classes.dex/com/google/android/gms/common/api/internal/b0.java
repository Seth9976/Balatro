package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import c1.a;
import com.google.android.gms.common.api.GoogleApiActivity;
import g1.q;

final class b0 implements Runnable {
    private final z e;
    final c0 f;

    b0(c0 c00, z z0) {
        this.f = c00;
        super();
        this.e = z0;
    }

    @Override
    public final void run() {
        if(!this.f.b) {
            return;
        }
        a a0 = this.e.b();
        if(a0.m0()) {
            Intent intent0 = GoogleApiActivity.a(this.f.b(), ((PendingIntent)q.i(a0.l0())), this.e.a(), false);
            this.f.a.startActivityForResult(intent0, 1);
            return;
        }
        Activity activity0 = this.f.b();
        if(this.f.e.a(activity0, a0.j0(), null) != null) {
            Activity activity1 = this.f.b();
            this.f.e.u(activity1, this.f.a, a0.j0(), 2, this.f);
            return;
        }
        if(a0.j0() == 18) {
            Activity activity2 = this.f.b();
            Dialog dialog0 = this.f.e.p(activity2, this.f);
            Context context0 = this.f.b().getApplicationContext();
            a0 a00 = new a0(this, dialog0);
            this.f.e.q(context0, a00);
            return;
        }
        this.f.l(a0, this.e.a());
    }
}

