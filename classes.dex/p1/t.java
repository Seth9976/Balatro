package p1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;
import h1.c;

public final class t implements Parcelable.Creator {
    static void a(s s0, Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.i(parcel0, 1, s0.V());
        c.b(parcel0, v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        int v1 = 0;
        while(parcel0.dataPosition() < v) {
            int v2 = b.o(parcel0);
            if(((char)v2) == 1) {
                v1 = b.q(parcel0, v2);
            }
            else {
                b.u(parcel0, v2);
            }
        }
        b.j(parcel0, v);
        return new s(v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new s[v];
    }
}

