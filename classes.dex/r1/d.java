package r1;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;

public final class d extends f1.d implements b {
    private final e h;

    public d(DataHolder dataHolder0, int v, e e0) {
        super(dataHolder0, v);
        this.h = e0;
    }

    @Override  // r1.b
    public final long a() {
        return this.z(this.h.v);
    }

    @Override  // r1.b
    public final Uri b() {
        return this.U(this.h.y);
    }

    @Override  // r1.b
    public final Uri c() {
        return this.U(this.h.x);
    }

    @Override  // r1.b
    public final String d() {
        return this.C(this.h.u);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // r1.b
    public final Uri e() {
        return this.U(this.h.w);
    }

    @Override
    public final boolean equals(Object object0) {
        return a.l0(this, object0);
    }

    @Override  // r1.b
    public final String f() {
        return this.C(this.h.t);
    }

    @Override
    public final int hashCode() {
        return a.j0(this);
    }

    @Override
    public final String toString() {
        return a.k0(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        c.a(new a(this), parcel0, v);
    }
}

