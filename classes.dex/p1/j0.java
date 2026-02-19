package p1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;
import h1.c;

public final class j0 implements Parcelable.Creator {
    static void a(i0 i00, Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.i(parcel0, 1, i00.J());
        c.n(parcel0, 2, i00.b(), false);
        c.n(parcel0, 3, i00.a(), false);
        c.n(parcel0, 4, i00.c(), false);
        c.b(parcel0, v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        String s = null;
        String s1 = null;
        int v1 = 0;
        String s2 = null;
        while(parcel0.dataPosition() < v) {
            int v2 = b.o(parcel0);
            switch(((char)v2)) {
                case 1: {
                    v1 = b.q(parcel0, v2);
                    break;
                }
                case 2: {
                    s = b.e(parcel0, v2);
                    break;
                }
                case 3: {
                    s2 = b.e(parcel0, v2);
                    break;
                }
                case 4: {
                    s1 = b.e(parcel0, v2);
                    break;
                }
                default: {
                    b.u(parcel0, v2);
                }
            }
        }
        b.j(parcel0, v);
        return new i0(v1, s, s2, s1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new i0[v];
    }
}

