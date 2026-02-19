package e1;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import d1.f.a;
import d1.f.b;
import f2.d;
import f2.l;
import g1.e;
import g1.o0;
import g1.q;
import java.util.Set;

public final class z extends d implements a, b {
    private final Context a;
    private final Handler b;
    private final d1.a.a c;
    private final Set d;
    private final e e;
    private e2.e f;
    private y g;
    private static final d1.a.a h;

    static {
        z.h = e2.d.c;
    }

    public z(Context context0, Handler handler0, e e0) {
        this.a = context0;
        this.b = handler0;
        this.e = (e)q.j(e0, "ClientSettings must not be null");
        this.d = e0.h();
        this.c = z.h;
    }

    static void Y(z z0, l l0) {
        c1.a a0 = l0.j0();
        if(a0.n0()) {
            o0 o00 = (o0)q.i(l0.k0());
            a0 = o00.j0();
            if(a0.n0()) {
                z0.g.a(o00.k0(), z0.d);
            }
            else {
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: " + a0, new Exception());
                z0.g.c(a0);
            }
        }
        else {
            z0.g.c(a0);
        }
        z0.f.i();
    }

    public final void Z(y y0) {
        e2.e e0 = this.f;
        if(e0 != null) {
            e0.i();
        }
        this.e.m(System.identityHashCode(this));
        Looper looper0 = this.b.getLooper();
        this.f = this.c.a(this.a, looper0, this.e, this.e.j(), this, this);
        this.g = y0;
        if(this.d != null && !this.d.isEmpty()) {
            this.f.l();
            return;
        }
        w w0 = new w(this);
        this.b.post(w0);
    }

    @Override  // e1.d
    public final void a(int v) {
        this.g.d(v);
    }

    public final void a0() {
        e2.e e0 = this.f;
        if(e0 != null) {
            e0.i();
        }
    }

    @Override  // e1.i
    public final void d(c1.a a0) {
        this.g.c(a0);
    }

    @Override  // e1.d
    public final void f(Bundle bundle0) {
        this.f.f(this);
    }

    @Override  // f2.f
    public final void m(l l0) {
        x x0 = new x(this, l0);
        this.b.post(x0);
    }
}

