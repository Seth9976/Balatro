package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c1.c;
import e1.d;
import e1.i;
import g1.e;
import g1.h;
import p1.v;

final class q extends h {
    public q(Context context0, Looper looper0, e e0, d d0, i i0) {
        super(context0, looper0, 1, e0, d0, i0);
    }

    @Override  // g1.d
    protected final String D() {
        return "com.google.android.gms.games.internal.v2.appshortcuts.IAppShortcutsService";
    }

    @Override  // g1.d
    protected final String E() {
        return "com.google.android.gms.games.internal.appshortcuts.service.START";
    }

    @Override  // g1.d
    public final boolean Q() {
        return true;
    }

    @Override  // g1.d, d1.a$f
    public final boolean m() {
        return false;
    }

    @Override  // g1.d
    protected final IInterface r(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.games.internal.v2.appshortcuts.IAppShortcutsService");
        return iInterface0 instanceof r ? ((r)iInterface0) : new r(iBinder0);
    }

    @Override  // g1.d
    public final c[] u() {
        return new c[]{v.g};
    }
}

