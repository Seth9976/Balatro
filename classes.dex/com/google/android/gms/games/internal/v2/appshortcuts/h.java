package com.google.android.gms.games.internal.v2.appshortcuts;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.PersistableBundle;
import h1.a;
import h1.c;

public final class h extends a {
    public static final Parcelable.Creator CREATOR;
    private final String e;
    private final PersistableBundle f;
    private final Boolean g;
    private final Boolean h;

    static {
        h.CREATOR = new i();
    }

    h(String s, PersistableBundle persistableBundle0, Boolean boolean0, Boolean boolean1) {
        this.e = s;
        this.f = persistableBundle0;
        this.g = boolean0;
        this.h = boolean1;
    }

    public final String a() {
        return this.e;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.n(parcel0, 1, this.e, false);
        c.m(parcel0, 2, this.f, v, false);
        c.e(parcel0, 3, this.g, false);
        c.e(parcel0, 4, this.h, false);
        c.b(parcel0, v1);
    }
}

