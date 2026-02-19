package com.google.android.gms.games.internal.v2.appshortcuts;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.a;
import h1.c;
import java.util.List;

public final class f extends a {
    public static final Parcelable.Creator CREATOR;
    private final List e;
    private final List f;
    private final List g;
    private final List h;

    static {
        f.CREATOR = new g();
    }

    f(List list0, List list1, List list2, List list3) {
        this.e = list0;
        this.f = list1;
        this.g = list2;
        this.h = list3;
    }

    public final List j0() {
        return this.f;
    }

    public final List k0() {
        return this.g;
    }

    public final List l0() {
        return this.h;
    }

    public final List m0() {
        return this.e;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.p(parcel0, 1, this.e, false);
        c.r(parcel0, 2, this.f, false);
        c.p(parcel0, 3, this.g, false);
        c.p(parcel0, 4, this.h, false);
        c.b(parcel0, v1);
    }
}

