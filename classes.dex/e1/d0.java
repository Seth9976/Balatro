package e1;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

final class d0 implements Runnable {
    final LifecycleCallback e;
    final String f;
    final e0 g;

    d0(e0 e00, LifecycleCallback lifecycleCallback0, String s) {
        this.g = e00;
        this.e = lifecycleCallback0;
        this.f = s;
        super();
    }

    @Override
    public final void run() {
        e0 e00 = this.g;
        if(e00.b > 0) {
            Bundle bundle0 = e00.c == null ? null : e00.c.getBundle(this.f);
            this.e.f(bundle0);
        }
        if(this.g.b >= 2) {
            this.e.j();
        }
        if(this.g.b >= 3) {
            this.e.h();
        }
        if(this.g.b >= 4) {
            this.e.k();
        }
    }
}

