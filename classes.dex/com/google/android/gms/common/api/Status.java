package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import d1.c;
import d1.k;
import g1.o;
import h1.a;

public final class Status extends a implements ReflectedParcelable, k {
    public static final Parcelable.Creator CREATOR;
    private final int e;
    private final String f;
    private final PendingIntent g;
    private final c1.a h;
    public static final Status i;
    public static final Status j;
    public static final Status k;
    public static final Status l;
    public static final Status m;
    public static final Status n;
    public static final Status o;
    public static final Status p;

    static {
        Status.i = new Status(-1);
        Status.j = new Status(0);
        Status.k = new Status(14);
        Status.l = new Status(8);
        Status.m = new Status(15);
        Status.n = new Status(16);
        Status.p = new Status(17);
        Status.o = new Status(18);
        Status.CREATOR = new b();
    }

    public Status(int v) {
        this(v, null);
    }

    public Status(int v, String s) {
        this(v, s, null);
    }

    public Status(int v, String s, PendingIntent pendingIntent0) {
        this(v, s, pendingIntent0, null);
    }

    Status(int v, String s, PendingIntent pendingIntent0, c1.a a0) {
        this.e = v;
        this.f = s;
        this.g = pendingIntent0;
        this.h = a0;
    }

    public Status(c1.a a0, String s) {
        this(a0, s, 17);
    }

    public Status(c1.a a0, String s, int v) {
        this(v, s, a0.l0(), a0);
    }

    public final String a() {
        return this.f == null ? c.a(this.e) : this.f;
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof Status ? this.e == ((Status)object0).e && o.a(this.f, ((Status)object0).f) && o.a(this.g, ((Status)object0).g) && o.a(this.h, ((Status)object0).h) : false;
    }

    @Override  // d1.k
    public Status g0() {
        return this;
    }

    @Override
    public int hashCode() {
        return o.b(new Object[]{this.e, this.f, this.g, this.h});
    }

    public c1.a j0() {
        return this.h;
    }

    public PendingIntent k0() {
        return this.g;
    }

    public int l0() {
        return this.e;
    }

    public String m0() {
        return this.f;
    }

    public boolean n0() {
        return this.g != null;
    }

    public boolean o0() {
        return this.e <= 0;
    }

    @Override
    public String toString() {
        g1.o.a o$a0 = o.c(this);
        o$a0.a("statusCode", this.a());
        o$a0.a("resolution", this.g);
        return o$a0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = h1.c.a(parcel0);
        h1.c.i(parcel0, 1, this.l0());
        h1.c.n(parcel0, 2, this.m0(), false);
        h1.c.m(parcel0, 3, this.g, v, false);
        h1.c.m(parcel0, 4, this.j0(), v, false);
        h1.c.b(parcel0, v1);
    }
}

