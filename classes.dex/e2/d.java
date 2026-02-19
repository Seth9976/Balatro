package e2;

import com.google.android.gms.common.api.Scope;
import d1.a.a;
import d1.a.g;

public abstract class d {
    public static final g a;
    public static final g b;
    public static final a c;
    static final a d;
    public static final Scope e;
    public static final Scope f;
    public static final d1.a g;
    public static final d1.a h;

    static {
        g a$g0 = new g();
        d.a = a$g0;
        g a$g1 = new g();
        d.b = a$g1;
        b b0 = new b();
        d.c = b0;
        c c0 = new c();
        d.d = c0;
        d.e = new Scope("profile");
        d.f = new Scope("email");
        d.g = new d1.a("SignIn.API", b0, a$g0);
        d.h = new d1.a("SignIn.INTERNAL_API", c0, a$g1);
    }
}

