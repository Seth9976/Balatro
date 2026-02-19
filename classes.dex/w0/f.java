package w0;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.a;
import h1.c;

public final class f extends a {
    public static final Parcelable.Creator CREATOR;
    private final String e;
    private final int f;

    static {
        f.CREATOR = new g();
    }

    public f(String s, int v) {
        this.e = s;
        this.f = v;
    }

    public final int a() {
        return this.f;
    }

    public final String b() {
        return this.e;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.n(parcel0, 1, this.e, false);
        c.i(parcel0, 2, this.f);
        c.b(parcel0, v1);
    }
}

