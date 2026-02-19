package a1;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import d1.f;
import d1.g;
import d1.h;
import j1.a;

public abstract class o {
    private static final a a;

    static {
        o.a = new a("GoogleSignInCommon", new String[0]);
    }

    public static g a(f f0, Context context0, boolean z) {
        o.a.a("Revoking access", new Object[0]);
        String s = c.b(context0).e();
        o.c(context0);
        return z ? a1.f.a(s) : f0.a(new m(f0));
    }

    public static g b(f f0, Context context0, boolean z) {
        o.a.a("Signing out", new Object[0]);
        o.c(context0);
        return z ? h.b(Status.j, f0) : f0.a(new k(f0));
    }

    private static void c(Context context0) {
        p.b(context0).c();
        for(Object object0: f.b()) {
            ((f)object0).e();
        }
        com.google.android.gms.common.api.internal.c.a();
    }
}

