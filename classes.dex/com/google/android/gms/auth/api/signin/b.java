package com.google.android.gms.auth.api.signin;

import a1.o;
import android.content.Context;
import c1.i;
import com.google.android.gms.dynamite.DynamiteModule;
import d1.e.a;
import d1.e;
import g1.p;
import g2.h;

public class b extends e {
    private static final f k;
    static int l;

    static {
        b.k = new f(null);
        b.l = 1;
    }

    b(Context context0, GoogleSignInOptions googleSignInOptions0) {
        a e$a0 = new d1.e.a.a().b(new e1.a()).a();
        super(context0, x0.a.b, googleSignInOptions0, e$a0);
    }

    public h u() {
        d1.f f0 = this.d();
        Context context0 = this.m();
        return this.w() == 3 ? p.b(o.a(f0, context0, true)) : p.b(o.a(f0, context0, false));
    }

    public h v() {
        d1.f f0 = this.d();
        Context context0 = this.m();
        return this.w() == 3 ? p.b(o.b(f0, context0, true)) : p.b(o.b(f0, context0, false));
    }

    private final int w() {
        synchronized(this) {
            int v1 = b.l;
            if(v1 == 1) {
                Context context0 = this.m();
                i i0 = i.l();
                int v2 = i0.g(context0, 12451000);
                if(v2 == 0) {
                    v1 = 4;
                    b.l = 4;
                }
                else if(i0.a(context0, v2, null) != null || DynamiteModule.a(context0, "com.google.android.gms.auth.api.fallback") == 0) {
                    v1 = 2;
                    b.l = 2;
                }
                else {
                    v1 = 3;
                    b.l = 3;
                }
            }
            return v1;
        }
    }
}

