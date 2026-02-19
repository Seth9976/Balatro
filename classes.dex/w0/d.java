package w0;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.a;
import h1.c;

public final class d extends a {
    public static final Parcelable.Creator CREATOR;
    private final String e;
    private final String f;

    static {
        d.CREATOR = new e();
    }

    public d(String s, String s1) {
        this.e = s;
        this.f = s1;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.n(parcel0, 1, this.e, false);
        c.n(parcel0, 2, this.f, false);
        c.b(parcel0, v1);
    }
}

