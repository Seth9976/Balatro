package com.google.android.gms.common.api.internal;

import android.util.Log;
import c1.a;

final class p implements Runnable {
    final a e;
    final q f;

    p(q q0, a a0) {
        this.f = q0;
        this.e = a0;
        super();
    }

    @Override
    public final void run() {
        n n0 = (n)this.f.f.j.get(this.f.b);
        if(n0 == null) {
            return;
        }
        if(this.e.n0()) {
            q.g(this.f, true);
            if(this.f.a.k()) {
                this.f.i();
                return;
            }
            try {
                this.f.a.p(null, this.f.a.g());
            }
            catch(SecurityException securityException0) {
                Log.e("GoogleApiManager", "Failed to get service from broker. ", securityException0);
                this.f.a.j("Failed to get service from broker.");
                n0.H(new a(10), null);
            }
            return;
        }
        n0.H(this.e, null);
    }
}

