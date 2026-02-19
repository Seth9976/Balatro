package g1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.a;
import h1.c;

public class f extends a {
    public static final Parcelable.Creator CREATOR;
    private final s e;
    private final boolean f;
    private final boolean g;
    private final int[] h;
    private final int i;
    private final int[] j;

    static {
        f.CREATOR = new g1();
    }

    public f(s s0, boolean z, boolean z1, int[] arr_v, int v, int[] arr_v1) {
        this.e = s0;
        this.f = z;
        this.g = z1;
        this.h = arr_v;
        this.i = v;
        this.j = arr_v1;
    }

    public int j0() {
        return this.i;
    }

    public int[] k0() {
        return this.h;
    }

    public int[] l0() {
        return this.j;
    }

    public boolean m0() {
        return this.f;
    }

    public boolean n0() {
        return this.g;
    }

    public final s o0() {
        return this.e;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.m(parcel0, 1, this.e, v, false);
        c.c(parcel0, 2, this.m0());
        c.c(parcel0, 3, this.n0());
        c.j(parcel0, 4, this.k0(), false);
        c.i(parcel0, 5, this.j0());
        c.j(parcel0, 6, this.l0(), false);
        c.b(parcel0, v1);
    }
}

