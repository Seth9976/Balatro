package c2;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import e1.d;
import e1.i;
import g1.e;
import g1.h;

public final class p2 extends h {
    private final i2 I;

    public p2(Context context0, Looper looper0, e e0, i2 i20, d d0, i i0) {
        super(context0, looper0, 1, e0, d0, i0);
        this.I = i20;
    }

    @Override  // g1.d
    protected final String D() {
        return "com.google.android.gms.games.internal.connect.IGamesConnectService";
    }

    @Override  // g1.d
    protected final String E() {
        return "com.google.android.gms.games.internal.connect.service.START";
    }

    @Override  // g1.d
    public final boolean Q() {
        return true;
    }

    @Override  // g1.d, d1.a$f
    public final int o() {
        return 213000000;
    }

    @Override  // g1.d
    protected final IInterface r(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.games.internal.connect.IGamesConnectService");
        return iInterface0 instanceof w2 ? ((w2)iInterface0) : new w2(iBinder0);
    }

    @Override  // g1.d
    protected final Bundle z() {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("com.google.android.gms.games.key.API_VERSION", this.I.e);
        bundle0.putString("com.google.android.gms.games.key.gamePackageName", this.I.f);
        return bundle0;
    }
}

