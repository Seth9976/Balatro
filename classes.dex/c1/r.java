package c1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class r implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        long v1 = -1L;
        int v2 = 0;
        String s = null;
        while(parcel0.dataPosition() < v) {
            int v3 = b.o(parcel0);
            switch(((char)v3)) {
                case 1: {
                    s = b.e(parcel0, v3);
                    break;
                }
                case 2: {
                    v2 = b.q(parcel0, v3);
                    break;
                }
                case 3: {
                    v1 = b.r(parcel0, v3);
                    break;
                }
                default: {
                    b.u(parcel0, v3);
                }
            }
        }
        b.j(parcel0, v);
        return new c(s, v2, v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new c[v];
    }
}

