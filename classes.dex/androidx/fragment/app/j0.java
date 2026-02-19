package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.g;
import androidx.lifecycle.h.b;
import androidx.lifecycle.h;
import androidx.lifecycle.m;
import androidx.lifecycle.v;
import x.a;
import z.c;
import z.d;
import z.e;

class j0 implements d0, g, e {
    private final Fragment a;
    private final c0 b;
    private m c;
    private d d;

    j0(Fragment fragment0, c0 c00) {
        this.c = null;
        this.d = null;
        this.a = fragment0;
        this.b = c00;
    }

    @Override  // androidx.lifecycle.g
    public a a() {
        Application application0;
        for(Context context0 = this.a.n1().getApplicationContext(); true; context0 = ((ContextWrapper)context0).getBaseContext()) {
            application0 = null;
            if(!(context0 instanceof ContextWrapper)) {
                break;
            }
            if(context0 instanceof Application) {
                application0 = (Application)context0;
                break;
            }
        }
        a a0 = new x.d();
        if(application0 != null) {
            ((x.d)a0).b(androidx.lifecycle.z.a.d, application0);
        }
        ((x.d)a0).b(v.a, this.a);
        ((x.d)a0).b(v.b, this);
        if(this.a.r() != null) {
            ((x.d)a0).b(v.c, this.a.r());
        }
        return a0;
    }

    void b(b h$b0) {
        this.c.h(h$b0);
    }

    @Override  // z.e
    public c d() {
        this.e();
        return this.d.b();
    }

    void e() {
        if(this.c == null) {
            this.c = new m(this);
            d d0 = d.a(this);
            this.d = d0;
            d0.c();
        }
    }

    boolean f() {
        return this.c != null;
    }

    void g(Bundle bundle0) {
        this.d.d(bundle0);
    }

    void h(Bundle bundle0) {
        this.d.e(bundle0);
    }

    void i(androidx.lifecycle.h.c h$c0) {
        this.c.o(h$c0);
    }

    @Override  // androidx.lifecycle.d0
    public c0 l() {
        this.e();
        return this.b;
    }

    @Override  // androidx.lifecycle.l
    public h o() {
        this.e();
        return this.c;
    }
}

