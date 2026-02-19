package g1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.a;
import h1.c;

public class n extends a {
    public static final Parcelable.Creator CREATOR;
    private final int e;
    private final int f;
    private final int g;
    private final long h;
    private final long i;
    private final String j;
    private final String k;
    private final int l;
    private final int m;

    static {
        n.CREATOR = new h0();
    }

    public n(int v, int v1, int v2, long v3, long v4, String s, String s1, int v5, int v6) {
        this.e = v;
        this.f = v1;
        this.g = v2;
        this.h = v3;
        this.i = v4;
        this.j = s;
        this.k = s1;
        this.l = v5;
        this.m = v6;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.i(parcel0, 1, this.e);
        c.i(parcel0, 2, this.f);
        c.i(parcel0, 3, this.g);
        c.k(parcel0, 4, this.h);
        c.k(parcel0, 5, this.i);
        c.n(parcel0, 6, this.j, false);
        c.n(parcel0, 7, this.k, false);
        c.i(parcel0, 8, this.l);
        c.i(parcel0, 9, this.m);
        c.b(parcel0, v1);
    }
}

