package g1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;
import java.util.List;

public final class x implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        List list0 = null;
        int v1 = 0;
        while(parcel0.dataPosition() < v) {
            int v2 = b.o(parcel0);
            switch(((char)v2)) {
                case 1: {
                    v1 = b.q(parcel0, v2);
                    break;
                }
                case 2: {
                    list0 = b.i(parcel0, v2, n.CREATOR);
                    break;
                }
                default: {
                    b.u(parcel0, v2);
                }
            }
        }
        b.j(parcel0, v);
        return new t(v1, list0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new t[v];
    }
}

