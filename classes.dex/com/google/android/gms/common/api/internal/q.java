package com.google.android.gms.common.api.internal;

import android.util.Log;
import c1.a;
import d1.a.f;
import e1.b;
import e1.y;
import g1.d.c;
import g1.k;
import java.util.Set;

final class q implements y, c {
    private final f a;
    private final b b;
    private k c;
    private Set d;
    private boolean e;
    final com.google.android.gms.common.api.internal.c f;

    public q(com.google.android.gms.common.api.internal.c c0, f a$f0, b b0) {
        this.f = c0;
        super();
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = a$f0;
        this.b = b0;
    }

    @Override  // e1.y
    public final void a(k k0, Set set0) {
        if(k0 != null && set0 != null) {
            this.c = k0;
            this.d = set0;
            this.i();
            return;
        }
        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
        this.c(new a(4));
    }

    @Override  // g1.d$c
    public final void b(a a0) {
        p p0 = new p(this, a0);
        this.f.n.post(p0);
    }

    @Override  // e1.y
    public final void c(a a0) {
        n n0 = (n)this.f.j.get(this.b);
        if(n0 != null) {
            n0.I(a0);
        }
    }

    @Override  // e1.y
    public final void d(int v) {
        n n0 = (n)this.f.j.get(this.b);
        if(n0 != null) {
            if(n0.i) {
                n0.I(new a(17));
                return;
            }
            n0.a(v);
        }
    }

    static void g(q q0, boolean z) {
        q0.e = true;
    }

    private final void i() {
        if(this.e) {
            k k0 = this.c;
            if(k0 != null) {
                this.a.p(k0, this.d);
            }
        }
    }
}

