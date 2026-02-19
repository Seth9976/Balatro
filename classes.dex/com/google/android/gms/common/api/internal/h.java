package com.google.android.gms.common.api.internal;

import android.app.Activity;
import c1.a;
import c1.i;
import e1.f;
import g1.q;
import k.b;

public final class h extends c0 {
    private final b f;
    private final c g;

    h(f f0, c c0, i i0) {
        super(f0, i0);
        this.f = new b();
        this.g = c0;
        this.a.b("ConnectionlessLifecycleHelper", this);
    }

    @Override  // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void h() {
        super.h();
        this.v();
    }

    @Override  // com.google.android.gms.common.api.internal.c0
    public final void j() {
        super.j();
        this.v();
    }

    @Override  // com.google.android.gms.common.api.internal.c0
    public final void k() {
        super.k();
        this.g.c(this);
    }

    @Override  // com.google.android.gms.common.api.internal.c0
    protected final void m(a a0, int v) {
        this.g.D(a0, v);
    }

    @Override  // com.google.android.gms.common.api.internal.c0
    protected final void n() {
        this.g.E();
    }

    final b t() {
        return this.f;
    }

    public static void u(Activity activity0, c c0, e1.b b0) {
        f f0 = LifecycleCallback.c(activity0);
        h h0 = (h)f0.e("ConnectionlessLifecycleHelper", h.class);
        if(h0 == null) {
            h0 = new h(f0, c0, i.l());
        }
        q.j(b0, "ApiKey cannot be null");
        h0.f.add(b0);
        c0.b(h0);
    }

    private final void v() {
        if(!this.f.isEmpty()) {
            this.g.b(this);
        }
    }
}

