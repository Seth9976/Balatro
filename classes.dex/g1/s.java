package g1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.a;
import h1.c;

public class s extends a {
    public static final Parcelable.Creator CREATOR;
    private final int e;
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;

    static {
        s.CREATOR = new w0();
    }

    public s(int v, boolean z, boolean z1, int v1, int v2) {
        this.e = v;
        this.f = z;
        this.g = z1;
        this.h = v1;
        this.i = v2;
    }

    public int j0() {
        return this.h;
    }

    public int k0() {
        return this.i;
    }

    public boolean l0() {
        return this.f;
    }

    public boolean m0() {
        return this.g;
    }

    public int n0() {
        return this.e;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.i(parcel0, 1, this.n0());
        c.c(parcel0, 2, this.l0());
        c.c(parcel0, 3, this.m0());
        c.i(parcel0, 4, this.j0());
        c.i(parcel0, 5, this.k0());
        c.b(parcel0, v1);
    }
}

