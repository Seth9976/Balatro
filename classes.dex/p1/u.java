package p1;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import r1.e;

public final class u extends e0 implements c {
    private final e h;

    public u(DataHolder dataHolder0, int v, e e0) {
        super(dataHolder0, v);
        this.h = e0;
    }

    @Override  // f1.e
    public final Object D() {
        return new s(this);
    }

    @Override  // p1.c
    public final int V() {
        return this.h0(this.h.L, 0);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object0) {
        return s.l0(this, object0);
    }

    @Override
    public final int hashCode() {
        return s.j0(this);
    }

    // 去混淆评级： 低(20)
    public final boolean j0() {
        return this.H(this.h.L) && !this.K(this.h.L);
    }

    @Override
    public final String toString() {
        return s.k0(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        t.a(new s(this), parcel0, v);
    }
}

