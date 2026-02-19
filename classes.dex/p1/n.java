package p1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import g1.o;
import g1.q;
import h1.c;
import q1.r;

public final class n extends r {
    public static final Parcelable.Creator CREATOR;
    private final int e;
    private final long f;
    private final long g;

    static {
        n.CREATOR = new g0();
    }

    public n(int v, long v1, long v2) {
        boolean z = true;
        q.l(Long.compare(v1, 0L) >= 0, "Min XP must be positive!");
        if(v2 <= v1) {
            z = false;
        }
        q.l(z, "Max XP must be more than min XP!");
        this.e = v;
        this.f = v1;
        this.g = v2;
    }

    @Override
    public boolean equals(Object object0) {
        if(!(object0 instanceof n)) {
            return false;
        }
        return this == object0 ? true : o.a(((n)object0).j0(), this.j0()) && o.a(((n)object0).l0(), this.l0()) && o.a(((n)object0).k0(), this.k0());
    }

    @Override
    public int hashCode() {
        return o.b(new Object[]{this.e, this.f, this.g});
    }

    public int j0() {
        return this.e;
    }

    public long k0() {
        return this.g;
    }

    public long l0() {
        return this.f;
    }

    @Override
    public String toString() {
        return o.c(this).a("LevelNumber", this.j0()).a("MinXp", this.l0()).a("MaxXp", this.k0()).toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.i(parcel0, 1, this.j0());
        c.k(parcel0, 2, this.l0());
        c.k(parcel0, 3, this.k0());
        c.b(parcel0, v1);
    }
}

