package g1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import c1.c;
import h1.a;

public final class e1 extends a {
    public static final Parcelable.Creator CREATOR;
    Bundle e;
    c[] f;
    int g;
    f h;

    static {
        e1.CREATOR = new f1();
    }

    e1(Bundle bundle0, c[] arr_c, int v, f f0) {
        this.e = bundle0;
        this.f = arr_c;
        this.g = v;
        this.h = f0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = h1.c.a(parcel0);
        h1.c.f(parcel0, 1, this.e, false);
        h1.c.q(parcel0, 2, this.f, v, false);
        h1.c.i(parcel0, 3, this.g);
        h1.c.m(parcel0, 4, this.h, v, false);
        h1.c.b(parcel0, v1);
    }
}

