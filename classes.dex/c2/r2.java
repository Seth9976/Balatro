package c2;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class r2 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        x2 x20 = null;
        int v1 = 0;
        while(parcel0.dataPosition() < v) {
            int v2 = b.o(parcel0);
            switch(((char)v2)) {
                case 1: {
                    v1 = b.q(parcel0, v2);
                    break;
                }
                case 2: {
                    x20 = (x2)b.d(parcel0, v2, x2.CREATOR);
                    break;
                }
                default: {
                    b.u(parcel0, v2);
                }
            }
        }
        b.j(parcel0, v);
        return new q2(v1, x20);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new q2[v];
    }
}

