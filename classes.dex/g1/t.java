package g1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.a;
import h1.c;
import java.util.ArrayList;
import java.util.List;

public class t extends a {
    public static final Parcelable.Creator CREATOR;
    private final int e;
    private List f;

    static {
        t.CREATOR = new x();
    }

    public t(int v, List list0) {
        this.e = v;
        this.f = list0;
    }

    public final int j0() {
        return this.e;
    }

    public final List k0() {
        return this.f;
    }

    public final void l0(n n0) {
        if(this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(n0);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.i(parcel0, 1, this.e);
        c.r(parcel0, 2, this.f, false);
        c.b(parcel0, v1);
    }
}

