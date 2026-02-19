package w1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import g1.o;
import h1.c;
import q1.r;

public final class a extends r {
    public static final Parcelable.Creator CREATOR;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean[] h;
    private final boolean[] i;

    static {
        a.CREATOR = new b();
    }

    public a(boolean z, boolean z1, boolean z2, boolean[] arr_z, boolean[] arr_z1) {
        this.e = z;
        this.f = z1;
        this.g = z2;
        this.h = arr_z;
        this.i = arr_z1;
    }

    // 去混淆评级： 低(23)
    @Override
    public boolean equals(Object object0) {
        if(!(object0 instanceof a)) {
            return false;
        }
        return this == object0 ? true : o.a(((a)object0).j0(), this.j0()) && o.a(((a)object0).k0(), this.k0()) && o.a(Boolean.valueOf(((a)object0).l0()), Boolean.valueOf(this.l0())) && o.a(Boolean.valueOf(((a)object0).m0()), Boolean.valueOf(this.m0())) && o.a(Boolean.valueOf(((a)object0).n0()), Boolean.valueOf(this.n0()));
    }

    @Override
    public int hashCode() {
        return o.b(new Object[]{this.j0(), this.k0(), Boolean.valueOf(this.l0()), Boolean.valueOf(this.m0()), Boolean.valueOf(this.n0())});
    }

    public boolean[] j0() {
        return this.h;
    }

    public boolean[] k0() {
        return this.i;
    }

    public boolean l0() {
        return this.e;
    }

    public boolean m0() {
        return this.f;
    }

    public boolean n0() {
        return this.g;
    }

    @Override
    public String toString() {
        return o.c(this).a("SupportedCaptureModes", this.j0()).a("SupportedQualityLevels", this.k0()).a("CameraSupported", Boolean.valueOf(this.l0())).a("MicSupported", Boolean.valueOf(this.m0())).a("StorageWriteSupported", Boolean.valueOf(this.n0())).toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.c(parcel0, 1, this.l0());
        c.c(parcel0, 2, this.m0());
        c.c(parcel0, 3, this.n0());
        c.d(parcel0, 4, this.j0(), false);
        c.d(parcel0, 5, this.k0(), false);
        c.b(parcel0, v1);
    }
}

