package p1;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import r1.e;

public final class k0 extends e0 implements p {
    private final e h;

    public k0(DataHolder dataHolder0, int v, e e0) {
        super(dataHolder0, v);
        this.h = e0;
    }

    @Override  // f1.e
    public final Object D() {
        return new i0(this);
    }

    @Override  // p1.p
    public final int J() {
        return this.h0(this.h.H, -1);
    }

    @Override  // p1.p
    public final String a() {
        return this.g0(this.h.J, null);
    }

    @Override  // p1.p
    public final String b() {
        return this.g0(this.h.I, null);
    }

    @Override  // p1.p
    public final String c() {
        return this.g0(this.h.K, null);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object0) {
        return i0.l0(this, object0);
    }

    @Override
    public final int hashCode() {
        return i0.j0(this);
    }

    @Override
    public final String toString() {
        return i0.k0(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        j0.a(new i0(this), parcel0, v);
    }
}

