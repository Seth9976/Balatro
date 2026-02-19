package c2;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import g1.o;
import h1.a;
import h1.c;

public final class x2 extends a {
    public static final Parcelable.Creator CREATOR;
    private final Intent e;

    static {
        x2.CREATOR = new y2();
    }

    x2(Intent intent0) {
        this.e = intent0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof x2 ? o.a(this.e, ((x2)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        return this.e == null ? 0 : this.e.hashCode();
    }

    public static x2 j0(Intent intent0) {
        return new x2(intent0);
    }

    @Override
    public final String toString() {
        return o.c(this).a("resultData", this.e).toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.m(parcel0, 1, this.e, v, false);
        c.b(parcel0, v1);
    }
}

