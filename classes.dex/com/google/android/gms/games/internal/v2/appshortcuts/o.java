package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import d1.b;
import g2.i;
import s1.v;

abstract class o extends v {
    protected final i a;

    o(i i0) {
        this.a = i0;
    }

    @Override  // s1.w
    public void M(f f0) {
        this.k(new Status(10));
    }

    @Override  // s1.w
    public final void k(Status status0) {
        b b0 = g1.b.a(status0);
        this.a.d(b0);
    }

    @Override  // s1.w
    public void l(Intent intent0) {
        this.k(new Status(10));
    }
}

