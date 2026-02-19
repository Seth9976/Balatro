package y1;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import e1.d;
import e1.i;
import g1.e;
import g1.h;
import x0.c;

public final class b extends h {
    private final Bundle I;

    public b(Context context0, Looper looper0, e e0, c c0, d d0, i i0) {
        super(context0, looper0, 16, e0, d0, i0);
        this.I = new Bundle();
    }

    @Override  // g1.d
    protected final String D() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override  // g1.d
    protected final String E() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override  // g1.d
    public final boolean Q() {
        return true;
    }

    @Override  // g1.d, d1.a$f
    public final boolean k() {
        e e0 = this.h0();
        return !TextUtils.isEmpty(e0.b()) && !e0.e(x0.b.a).isEmpty();
    }

    @Override  // g1.d, d1.a$f
    public final int o() {
        return 12451000;
    }

    @Override  // g1.d
    protected final IInterface r(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return iInterface0 instanceof y1.c ? ((y1.c)iInterface0) : new y1.c(iBinder0);
    }

    @Override  // g1.d
    protected final Bundle z() {
        return this.I;
    }
}

