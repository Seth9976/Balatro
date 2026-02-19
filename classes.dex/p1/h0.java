package p1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class h0 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        n n0 = null;
        n n1 = null;
        long v1 = 0L;
        long v2 = 0L;
        while(parcel0.dataPosition() < v) {
            int v3 = b.o(parcel0);
            switch(((char)v3)) {
                case 1: {
                    v1 = b.r(parcel0, v3);
                    break;
                }
                case 2: {
                    v2 = b.r(parcel0, v3);
                    break;
                }
                case 3: {
                    n0 = (n)b.d(parcel0, v3, n.CREATOR);
                    break;
                }
                case 4: {
                    n1 = (n)b.d(parcel0, v3, n.CREATOR);
                    break;
                }
                default: {
                    b.u(parcel0, v3);
                }
            }
        }
        b.j(parcel0, v);
        return new o(v1, v2, n0, n1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new o[v];
    }
}

