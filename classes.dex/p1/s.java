package p1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import g1.o.a;
import g1.o;
import q1.r;

public final class s extends r implements c {
    public static final Parcelable.Creator CREATOR;
    private final int e;

    static {
        s.CREATOR = new t();
    }

    public s(int v) {
        this.e = v;
    }

    public s(c c0) {
        this.e = c0.V();
    }

    @Override  // f1.e
    public final Object D() {
        return this;
    }

    @Override  // p1.c
    public final int V() {
        return this.e;
    }

    @Override
    public final boolean equals(Object object0) {
        return s.l0(this, object0);
    }

    @Override
    public final int hashCode() {
        return s.j0(this);
    }

    static int j0(c c0) {
        return o.b(new Object[]{c0.V()});
    }

    static String k0(c c0) {
        a o$a0 = o.c(c0);
        o$a0.a("FriendsListVisibilityStatus", c0.V());
        return o$a0.toString();
    }

    static boolean l0(c c0, Object object0) {
        if(!(object0 instanceof c)) {
            return false;
        }
        return object0 == c0 ? true : ((c)object0).V() == c0.V();
    }

    @Override
    public final String toString() {
        return s.k0(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        t.a(this, parcel0, v);
    }
}

