package v1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import g1.o;
import q1.r;

public final class d extends r implements a {
    public static final Parcelable.Creator CREATOR;
    private final i e;
    private final c f;

    static {
        d.CREATOR = new l();
    }

    public d(e e0, c c0) {
        this.e = new i(e0);
        this.f = c0;
    }

    @Override  // v1.a
    public b Z() {
        return this.f.u() ? null : this.f;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 instanceof a) {
            return this == object0 ? true : o.a(((a)object0).t(), this.t()) && o.a(((a)object0).Z(), this.Z());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return o.b(new Object[]{this.t(), this.Z()});
    }

    @Override  // v1.a
    public e t() {
        return this.e;
    }

    @Override
    public String toString() {
        g1.o.a o$a0 = o.c(this).a("Metadata", this.t());
        return this.Z() == null ? o$a0.a("HasContents", Boolean.FALSE).toString() : o$a0.a("HasContents", Boolean.TRUE).toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = h1.c.a(parcel0);
        h1.c.m(parcel0, 1, this.t(), v, false);
        h1.c.m(parcel0, 3, this.Z(), v, false);
        h1.c.b(parcel0, v1);
    }
}

