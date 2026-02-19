package f2;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import g1.m0;
import h1.a;
import h1.c;

public final class j extends a {
    public static final Parcelable.Creator CREATOR;
    final int e;
    final m0 f;

    static {
        j.CREATOR = new k();
    }

    j(int v, m0 m00) {
        this.e = v;
        this.f = m00;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.i(parcel0, 1, this.e);
        c.m(parcel0, 2, this.f, v, false);
        c.b(parcel0, v1);
    }
}

