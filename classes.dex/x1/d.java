package x1;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c1.c;
import e1.i;
import g1.e;
import g1.h;

public final class d extends h {
    protected d(Context context0, Looper looper0, e e0, e1.d d0, i i0) {
        super(context0, looper0, 300, e0, d0, i0);
    }

    @Override  // g1.d
    protected final String D() {
        return "com.google.android.gms.appset.internal.IAppSetService";
    }

    @Override  // g1.d
    protected final String E() {
        return "com.google.android.gms.appset.service.START";
    }

    @Override  // g1.d
    protected final boolean H() {
        return true;
    }

    @Override  // g1.d
    public final boolean Q() {
        return true;
    }

    @Override  // g1.d, d1.a$f
    public final int o() {
        return 212800000;
    }

    @Override  // g1.d
    protected final IInterface r(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.appset.internal.IAppSetService");
        return iInterface0 instanceof g ? ((g)iInterface0) : new g(iBinder0);
    }

    @Override  // g1.d
    public final c[] u() {
        return w0.h.b;
    }
}

