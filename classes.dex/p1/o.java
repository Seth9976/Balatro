package p1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import g1.q;
import h1.c;
import q1.r;

public final class o extends r {
    public static final Parcelable.Creator CREATOR;
    private final long e;
    private final long f;
    private final n g;
    private final n h;

    static {
        o.CREATOR = new h0();
    }

    public o(long v, long v1, n n0, n n1) {
        q.k(v != -1L);
        q.i(n0);
        q.i(n1);
        this.e = v;
        this.f = v1;
        this.g = n0;
        this.h = n1;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        if(!(object0 instanceof o)) {
            return false;
        }
        return object0 == this ? true : g1.o.a(this.e, ((o)object0).e) && g1.o.a(this.f, ((o)object0).f) && g1.o.a(this.g, ((o)object0).g) && g1.o.a(this.h, ((o)object0).h);
    }

    @Override
    public int hashCode() {
        return g1.o.b(new Object[]{this.e, this.f, this.g, this.h});
    }

    public n j0() {
        return this.g;
    }

    public long k0() {
        return this.e;
    }

    public long l0() {
        return this.f;
    }

    public n m0() {
        return this.h;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.k(parcel0, 1, this.k0());
        c.k(parcel0, 2, this.l0());
        c.m(parcel0, 3, this.j0(), v, false);
        c.m(parcel0, 4, this.m0(), v, false);
        c.b(parcel0, v1);
    }
}

