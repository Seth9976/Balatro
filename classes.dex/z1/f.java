package z1;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import d1.f.a;
import d1.f.b;
import g1.e;
import g1.h;
import x0.g;

public final class f extends h {
    private final g I;

    public f(Context context0, Looper looper0, e e0, g g0, a f$a0, b f$b0) {
        super(context0, looper0, 68, e0, f$a0, f$b0);
        if(g0 == null) {
            g0 = g.h;
        }
        x0.f f0 = new x0.f(g0);
        f0.a("VEH8ZdoezzIFEPu-4pd_kg");
        this.I = new g(f0);
    }

    @Override  // g1.d
    protected final String D() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override  // g1.d
    protected final String E() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    @Override  // g1.d, d1.a$f
    public final int o() {
        return 12800000;
    }

    @Override  // g1.d
    protected final IInterface r(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return iInterface0 instanceof z1.g ? ((z1.g)iInterface0) : new z1.g(iBinder0);
    }

    @Override  // g1.d
    protected final Bundle z() {
        return this.I.a();
    }
}

