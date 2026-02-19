package g2;

import android.app.Activity;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class c0 extends h {
    private final Object a;
    private final y b;
    private boolean c;
    private volatile boolean d;
    private Object e;
    private Exception f;

    c0() {
        this.a = new Object();
        this.b = new y();
    }

    @Override  // g2.h
    public final h a(Executor executor0, c c0) {
        q q0 = new q(executor0, c0);
        this.b.a(q0);
        this.z();
        return this;
    }

    @Override  // g2.h
    public final h b(Activity activity0, d d0) {
        s s0 = new s(j.a, d0);
        this.b.a(s0);
        b0.l(activity0).m(s0);
        this.z();
        return this;
    }

    @Override  // g2.h
    public final h c(d d0) {
        s s0 = new s(j.a, d0);
        this.b.a(s0);
        this.z();
        return this;
    }

    @Override  // g2.h
    public final h d(Executor executor0, d d0) {
        s s0 = new s(executor0, d0);
        this.b.a(s0);
        this.z();
        return this;
    }

    @Override  // g2.h
    public final h e(e e0) {
        this.f(j.a, e0);
        return this;
    }

    @Override  // g2.h
    public final h f(Executor executor0, e e0) {
        u u0 = new u(executor0, e0);
        this.b.a(u0);
        this.z();
        return this;
    }

    @Override  // g2.h
    public final h g(f f0) {
        this.h(j.a, f0);
        return this;
    }

    @Override  // g2.h
    public final h h(Executor executor0, f f0) {
        w w0 = new w(executor0, f0);
        this.b.a(w0);
        this.z();
        return this;
    }

    @Override  // g2.h
    public final h i(a a0) {
        return this.j(j.a, a0);
    }

    @Override  // g2.h
    public final h j(Executor executor0, a a0) {
        h h0 = new c0();
        m m0 = new m(executor0, a0, ((c0)h0));
        this.b.a(m0);
        this.z();
        return h0;
    }

    @Override  // g2.h
    public final h k(a a0) {
        return this.l(j.a, a0);
    }

    @Override  // g2.h
    public final h l(Executor executor0, a a0) {
        h h0 = new c0();
        o o0 = new o(executor0, a0, ((c0)h0));
        this.b.a(o0);
        this.z();
        return h0;
    }

    @Override  // g2.h
    public final Exception m() {
        synchronized(this.a) {
        }
        return this.f;
    }

    @Override  // g2.h
    public final Object n() {
        Exception exception0;
        synchronized(this.a) {
            this.w();
            this.x();
            exception0 = this.f;
            if(exception0 == null) {
                return this.e;
            }
        }
        throw new g(exception0);
    }

    @Override  // g2.h
    public final boolean o() {
        return this.d;
    }

    @Override  // g2.h
    public final boolean p() {
        synchronized(this.a) {
        }
        return this.c;
    }

    @Override  // g2.h
    public final boolean q() {
        boolean z = false;
        synchronized(this.a) {
            if(this.c && !this.d && this.f == null) {
                z = true;
            }
        }
        return z;
    }

    public final void r(Exception exception0) {
        g1.q.j(exception0, "Exception must not be null");
        synchronized(this.a) {
            this.y();
            this.c = true;
            this.f = exception0;
        }
        this.b.b(this);
    }

    public final void s(Object object0) {
        synchronized(this.a) {
            this.y();
            this.c = true;
            this.e = object0;
        }
        this.b.b(this);
    }

    public final boolean t() {
        synchronized(this.a) {
            if(this.c) {
                return false;
            }
            this.c = true;
            this.d = true;
        }
        this.b.b(this);
        return true;
    }

    public final boolean u(Exception exception0) {
        g1.q.j(exception0, "Exception must not be null");
        synchronized(this.a) {
            if(this.c) {
                return false;
            }
            this.c = true;
            this.f = exception0;
        }
        this.b.b(this);
        return true;
    }

    public final boolean v(Object object0) {
        synchronized(this.a) {
            if(this.c) {
                return false;
            }
            this.c = true;
            this.e = object0;
        }
        this.b.b(this);
        return true;
    }

    private final void w() {
        g1.q.l(this.c, "Task is not yet complete");
    }

    private final void x() {
        if(this.d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void y() {
        if(this.c) {
            throw b.a(this);
        }
    }

    private final void z() {
        synchronized(this.a) {
            if(!this.c) {
                return;
            }
        }
        this.b.b(this);
    }
}

