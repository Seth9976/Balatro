package a1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.c;

public class a extends h1.a {
    public static final Parcelable.Creator CREATOR;
    final int e;
    private int f;
    private Bundle g;

    static {
        a.CREATOR = new d();
    }

    a(int v, int v1, Bundle bundle0) {
        this.e = v;
        this.f = v1;
        this.g = bundle0;
    }

    public int j0() {
        return this.f;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.i(parcel0, 1, this.e);
        c.i(parcel0, 2, this.j0());
        c.f(parcel0, 3, this.g, false);
        c.b(parcel0, v1);
    }
}

