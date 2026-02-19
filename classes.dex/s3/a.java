package s3;

import android.os.Handler;
import android.os.Looper;
import d3.e;
import java.util.concurrent.CancellationException;
import k3.d;
import k3.f;
import r3.l;
import r3.t;
import r3.v;

public final class a extends b {
    private volatile a _immediate;
    private final Handler f;
    private final String g;
    private final boolean h;
    private final a i;

    public a(Handler handler0, String s) {
        this(handler0, s, false);
    }

    public a(Handler handler0, String s, int v, d d0) {
        if((v & 2) != 0) {
            s = null;
        }
        this(handler0, s);
    }

    private a(Handler handler0, String s, boolean z) {
        a a0 = null;
        super(null);
        this.f = handler0;
        this.g = s;
        this.h = z;
        if(z) {
            a0 = this;
        }
        this._immediate = a0;
        a a1 = this._immediate;
        if(a1 == null) {
            a1 = new a(handler0, s, true);
            this._immediate = a1;
        }
        this.i = a1;
    }

    @Override  // r3.c
    public void a(e e0, Runnable runnable0) {
        if(!this.f.post(runnable0)) {
            this.f(e0, runnable0);
        }
    }

    // 去混淆评级： 低(20)
    @Override  // r3.c
    public boolean b(e e0) {
        return !this.h || !f.a(Looper.myLooper(), this.f.getLooper());
    }

    @Override  // r3.v
    public v d() {
        return this.g();
    }

    @Override
    public boolean equals(Object object0) {
        return object0 instanceof a && ((a)object0).f == this.f;
    }

    private final void f(e e0, Runnable runnable0) {
        t.a(e0, new CancellationException("The task was rejected, the handler underlying the dispatcher \'" + this + "\' was closed"));
        l.a().a(e0, runnable0);
    }

    public a g() {
        return this.i;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this.f);
    }

    @Override  // r3.c
    public String toString() {
        String s = this.e();
        if(s == null) {
            s = this.g == null ? this.f.toString() : this.g;
            return this.h ? s + ".immediate" : s;
        }
        return s;
    }
}

