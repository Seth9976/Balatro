package p1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class g0 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        long v1 = 0L;
        long v2 = 0L;
        int v3 = 0;
        while(parcel0.dataPosition() < v) {
            int v4 = b.o(parcel0);
            switch(((char)v4)) {
                case 1: {
                    v3 = b.q(parcel0, v4);
                    break;
                }
                case 2: {
                    v1 = b.r(parcel0, v4);
                    break;
                }
                case 3: {
                    v2 = b.r(parcel0, v4);
                    break;
                }
                default: {
                    b.u(parcel0, v4);
                }
            }
        }
        b.j(parcel0, v);
        return new n(v3, v1, v2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new n[v];
    }
}

