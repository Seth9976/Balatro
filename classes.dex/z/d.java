package z;

import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.savedstate.Recreator;
import k3.f;

public final class d {
    public static final class a {
        private a() {
        }

        public a(k3.d d0) {
        }

        public final d a(e e0) {
            f.e(e0, "owner");
            return new d(e0, null);
        }
    }

    private final e a;
    private final c b;
    private boolean c;
    public static final a d;

    static {
        d.d = new a(null);
    }

    private d(e e0) {
        this.a = e0;
        this.b = new c();
    }

    public d(e e0, k3.d d0) {
        this(e0);
    }

    public static final d a(e e0) {
        return d.d.a(e0);
    }

    public final c b() {
        return this.b;
    }

    public final void c() {
        h h0 = this.a.o();
        f.d(h0, "owner.lifecycle");
        if(h0.b() != androidx.lifecycle.h.c.f) {
            throw new IllegalStateException("Restarter must be created only during owner\'s initialization stage");
        }
        h0.a(new Recreator(this.a));
        this.b.e(h0);
        this.c = true;
    }

    public final void d(Bundle bundle0) {
        if(!this.c) {
            this.c();
        }
        h h0 = this.a.o();
        f.d(h0, "owner.lifecycle");
        if(!h0.b().c(androidx.lifecycle.h.c.h) == 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + h0.b()).toString());
        }
        this.b.f(bundle0);
    }

    public final void e(Bundle bundle0) {
        f.e(bundle0, "outBundle");
        this.b.g(bundle0);
    }
}

