package c2;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import g1.o;
import h1.a;
import h1.c;

public final class s2 extends a {
    public static final Parcelable.Creator CREATOR;
    private final String e;

    static {
        s2.CREATOR = new t2();
    }

    s2(String s) {
        this.e = s;
    }

    public final String a() {
        return this.e;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof s2 ? o.a(this.e, ((s2)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        return o.b(new Object[]{this.e});
    }

    @Override
    public final String toString() {
        return o.c(this).a("gameRunToken", this.e).toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.n(parcel0, 1, this.e, false);
        c.b(parcel0, v1);
    }
}

