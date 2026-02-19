package f2;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import g1.o0;
import h1.a;
import h1.c;

public final class l extends a {
    public static final Parcelable.Creator CREATOR;
    final int e;
    private final c1.a f;
    private final o0 g;

    static {
        l.CREATOR = new m();
    }

    l(int v, c1.a a0, o0 o00) {
        this.e = v;
        this.f = a0;
        this.g = o00;
    }

    public final c1.a j0() {
        return this.f;
    }

    public final o0 k0() {
        return this.g;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.i(parcel0, 1, this.e);
        c.m(parcel0, 2, this.f, v, false);
        c.m(parcel0, 3, this.g, v, false);
        c.b(parcel0, v1);
    }
}

