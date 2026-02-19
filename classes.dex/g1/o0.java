package g1;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.a;
import h1.c;

public final class o0 extends a {
    public static final Parcelable.Creator CREATOR;
    final int e;
    final IBinder f;
    private final c1.a g;
    private final boolean h;
    private final boolean i;

    static {
        o0.CREATOR = new p0();
    }

    o0(int v, IBinder iBinder0, c1.a a0, boolean z, boolean z1) {
        this.e = v;
        this.f = iBinder0;
        this.g = a0;
        this.h = z;
        this.i = z1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        if(this == object0) {
            return true;
        }
        return object0 instanceof o0 ? this.g.equals(((o0)object0).g) && o.a(this.k0(), ((o0)object0).k0()) : false;
    }

    public final c1.a j0() {
        return this.g;
    }

    public final k k0() {
        return this.f == null ? null : g1.k.a.d(this.f);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.i(parcel0, 1, this.e);
        c.h(parcel0, 2, this.f, false);
        c.m(parcel0, 3, this.g, v, false);
        c.c(parcel0, 4, this.h);
        c.c(parcel0, 5, this.i);
        c.b(parcel0, v1);
    }
}

