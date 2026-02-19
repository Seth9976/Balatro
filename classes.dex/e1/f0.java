package e1;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

final class f0 implements Runnable {
    final LifecycleCallback e;
    final String f;
    final g0 g;

    f0(g0 g00, LifecycleCallback lifecycleCallback0, String s) {
        this.g = g00;
        this.e = lifecycleCallback0;
        this.f = s;
        super();
    }

    @Override
    public final void run() {
        g0 g00 = this.g;
        if(g00.e0 > 0) {
            Bundle bundle0 = g00.f0 == null ? null : g00.f0.getBundle(this.f);
            this.e.f(bundle0);
        }
        if(this.g.e0 >= 2) {
            this.e.j();
        }
        if(this.g.e0 >= 3) {
            this.e.h();
        }
        if(this.g.e0 >= 4) {
            this.e.k();
        }
    }
}

