package i1;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c1.c;
import e1.d;
import e1.i;
import g1.h;
import g1.w;

public final class e extends h {
    private final w I;

    public e(Context context0, Looper looper0, g1.e e0, w w0, d d0, i i0) {
        super(context0, looper0, 270, e0, d0, i0);
        this.I = w0;
    }

    @Override  // g1.d
    protected final String D() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override  // g1.d
    protected final String E() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override  // g1.d
    protected final boolean H() {
        return true;
    }

    @Override  // g1.d, d1.a$f
    public final int o() {
        return 203400000;
    }

    @Override  // g1.d
    protected final IInterface r(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterface0 instanceof a ? ((a)iInterface0) : new a(iBinder0);
    }

    @Override  // g1.d
    public final c[] u() {
        return a2.d.b;
    }

    @Override  // g1.d
    protected final Bundle z() {
        return this.I.b();
    }
}

