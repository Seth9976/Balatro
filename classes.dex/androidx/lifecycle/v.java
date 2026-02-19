package androidx.lifecycle;

import j3.l;
import k3.f;
import k3.g;
import k3.h;
import x.a.b;
import z.e;

public abstract class v {
    public static final class a implements b {
    }

    public static final class androidx.lifecycle.v.b implements b {
    }

    public static final class c implements b {
    }

    public static final b a;
    public static final b b;
    public static final b c;

    static {
        v.a = new androidx.lifecycle.v.b();
        v.b = new c();
        v.c = new a();
    }

    public static final void a(e e0) {
        f.e(e0, "<this>");
        androidx.lifecycle.h.c h$c0 = e0.o().b();
        f.d(h$c0, "lifecycle.currentState");
        if(h$c0 != androidx.lifecycle.h.c.f && h$c0 != androidx.lifecycle.h.c.g) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if(e0.d().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            w w0 = new w(e0.d(), ((d0)e0));
            e0.d().h("androidx.lifecycle.internal.SavedStateHandlesProvider", w0);
            e0.o().a(new SavedStateHandleAttacher(w0));
        }
    }

    public static final x b(d0 d00) {
        static final class d extends g implements l {
            public static final d f;

            static {
                d.f = new d();
            }

            d() {
                super(1);
            }

            @Override  // j3.l
            public Object c(Object object0) {
                return this.d(((x.a)object0));
            }

            public final x d(x.a a0) {
                f.e(a0, "$this$initializer");
                return new x();
            }
        }

        f.e(d00, "<this>");
        x.c c0 = new x.c();
        c0.a(h.a(x.class), d.f);
        return (x)new z(d00, c0.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", x.class);
    }
}

