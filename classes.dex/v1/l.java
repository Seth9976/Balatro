package v1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class l implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        e e0 = null;
        c c0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = b.o(parcel0);
            switch(((char)v1)) {
                case 1: {
                    e0 = (i)b.d(parcel0, v1, i.CREATOR);
                    break;
                }
                case 3: {
                    c0 = (c)b.d(parcel0, v1, c.CREATOR);
                    break;
                }
                default: {
                    b.u(parcel0, v1);
                }
            }
        }
        b.j(parcel0, v);
        return new d(e0, c0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new d[v];
    }
}

