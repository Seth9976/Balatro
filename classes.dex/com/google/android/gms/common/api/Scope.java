package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import g1.q;
import h1.a;
import h1.c;

public final class Scope extends a implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    final int e;
    private final String f;

    static {
        Scope.CREATOR = new com.google.android.gms.common.api.a();
    }

    Scope(int v, String s) {
        q.g(s, "scopeUri must not be null or empty");
        this.e = v;
        this.f = s;
    }

    public Scope(String s) {
        this(1, s);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Scope ? this.f.equals(((Scope)object0).f) : false;
    }

    @Override
    public int hashCode() {
        return this.f.hashCode();
    }

    public String j0() {
        return this.f;
    }

    @Override
    public String toString() {
        return this.f;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.i(parcel0, 1, this.e);
        c.n(parcel0, 2, this.j0(), false);
        c.b(parcel0, v1);
    }
}

