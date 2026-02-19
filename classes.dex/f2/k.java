package f2;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import g1.m0;
import h1.b;

public final class k implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        m0 m00 = null;
        int v1 = 0;
        while(parcel0.dataPosition() < v) {
            int v2 = b.o(parcel0);
            switch(((char)v2)) {
                case 1: {
                    v1 = b.q(parcel0, v2);
                    break;
                }
                case 2: {
                    m00 = (m0)b.d(parcel0, v2, m0.CREATOR);
                    break;
                }
                default: {
                    b.u(parcel0, v2);
                }
            }
        }
        b.j(parcel0, v);
        return new j(v1, m00);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new j[v];
    }
}

