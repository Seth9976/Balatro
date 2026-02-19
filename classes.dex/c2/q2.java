package c2;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import g1.o;
import h1.a;
import h1.c;

public final class q2 extends a {
    public static final Parcelable.Creator CREATOR;
    private final int e;
    private final x2 f;

    static {
        q2.CREATOR = new r2();
    }

    q2(int v, x2 x20) {
        this.e = v;
        this.f = x20;
    }

    public final int a() {
        return this.e;
    }

    public final boolean e() {
        return this.f == null;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof q2 ? this.e == ((q2)object0).e && o.a(this.f, ((q2)object0).f) : false;
    }

    @Override
    public final int hashCode() {
        return o.b(new Object[]{this.e, this.f});
    }

    public static q2 j0(int v) {
        return new q2(v, null);
    }

    public static q2 k0(int v, x2 x20) {
        return new q2(v, x20);
    }

    @Override
    public final String toString() {
        return o.c(this).a("signInType", this.e).a("previousStepResolutionResult", this.f).toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.i(parcel0, 1, this.e);
        c.m(parcel0, 2, this.f, v, false);
        c.b(parcel0, v1);
    }
}

