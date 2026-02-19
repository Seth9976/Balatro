package f2;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import d1.k;
import h1.a;
import h1.c;
import java.util.List;

public final class h extends a implements k {
    public static final Parcelable.Creator CREATOR;
    private final List e;
    private final String f;

    static {
        h.CREATOR = new i();
    }

    public h(List list0, String s) {
        this.e = list0;
        this.f = s;
    }

    @Override  // d1.k
    public final Status g0() {
        return this.f == null ? Status.n : Status.j;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.p(parcel0, 1, this.e, false);
        c.n(parcel0, 2, this.f, false);
        c.b(parcel0, v1);
    }
}

