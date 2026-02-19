package g1;

import android.app.PendingIntent;
import android.os.Bundle;
import c1.a;

abstract class q0 extends y0 {
    public final int d;
    public final Bundle e;
    final d f;

    protected q0(d d0, int v, Bundle bundle0) {
        this.f = d0;
        super(d0, Boolean.TRUE);
        this.d = v;
        this.e = bundle0;
    }

    @Override  // g1.y0
    protected final void a(Object object0) {
        PendingIntent pendingIntent0 = null;
        if(this.d == 0) {
            if(!this.g()) {
                d.Z(this.f, 1, null);
                this.f(new a(8, null));
            }
            return;
        }
        d.Z(this.f, 1, null);
        Bundle bundle0 = this.e;
        if(bundle0 != null) {
            pendingIntent0 = (PendingIntent)bundle0.getParcelable("pendingIntent");
        }
        this.f(new a(this.d, pendingIntent0));
    }

    @Override  // g1.y0
    protected final void b() {
    }

    protected abstract void f(a arg1);

    protected abstract boolean g();
}

