package c1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import g1.o;
import h1.a;

public class c extends a {
    public static final Parcelable.Creator CREATOR;
    private final String e;
    private final int f;
    private final long g;

    static {
        c.CREATOR = new r();
    }

    public c(String s, int v, long v1) {
        this.e = s;
        this.f = v;
        this.g = v1;
    }

    public c(String s, long v) {
        this.e = s;
        this.g = v;
        this.f = -1;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof c && (this.j0() != null && this.j0().equals(((c)object0).j0()) || this.j0() == null && ((c)object0).j0() == null) && this.k0() == ((c)object0).k0();
    }

    @Override
    public final int hashCode() {
        return o.b(new Object[]{this.j0(), this.k0()});
    }

    public String j0() {
        return this.e;
    }

    public long k0() {
        return this.g == -1L ? ((long)this.f) : this.g;
    }

    @Override
    public final String toString() {
        g1.o.a o$a0 = o.c(this);
        o$a0.a("name", this.j0());
        o$a0.a("version", this.k0());
        return o$a0.toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = h1.c.a(parcel0);
        h1.c.n(parcel0, 1, this.j0(), false);
        h1.c.i(parcel0, 2, this.f);
        h1.c.k(parcel0, 3, this.k0());
        h1.c.b(parcel0, v1);
    }
}

