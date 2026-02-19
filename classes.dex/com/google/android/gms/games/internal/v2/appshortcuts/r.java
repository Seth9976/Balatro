package com.google.android.gms.games.internal.v2.appshortcuts;

import android.os.IBinder;
import android.os.Parcel;
import c2.a;
import c2.m0;
import java.util.List;
import s1.s;
import s1.w;

public final class r extends a {
    r(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.games.internal.v2.appshortcuts.IAppShortcutsService");
    }

    public final void W(w w0, s s0, List list0, List list1) {
        Parcel parcel0 = this.a();
        m0.d(parcel0, w0);
        m0.c(parcel0, s0);
        parcel0.writeTypedList(list0);
        parcel0.writeTypedList(list1);
        this.f(3, parcel0);
    }

    public final void X(w w0, s s0, h h0) {
        Parcel parcel0 = this.a();
        m0.d(parcel0, w0);
        m0.c(parcel0, s0);
        m0.c(parcel0, h0);
        this.f(4, parcel0);
    }
}

