package f2;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import d1.k;
import h1.a;

public final class b extends a implements k {
    public static final Parcelable.Creator CREATOR;
    final int e;
    private int f;
    private Intent g;

    static {
        b.CREATOR = new c();
    }

    b(int v, int v1, Intent intent0) {
        this.e = v;
        this.f = v1;
        this.g = intent0;
    }

    @Override  // d1.k
    public final Status g0() {
        return this.f == 0 ? Status.j : Status.n;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = h1.c.a(parcel0);
        h1.c.i(parcel0, 1, this.e);
        h1.c.i(parcel0, 2, this.f);
        h1.c.m(parcel0, 3, this.g, v, false);
        h1.c.b(parcel0, v1);
    }
}

