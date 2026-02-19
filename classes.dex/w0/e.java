package w0;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class e implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        String s = null;
        String s1 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = b.o(parcel0);
            switch(((char)v1)) {
                case 1: {
                    s = b.e(parcel0, v1);
                    break;
                }
                case 2: {
                    s1 = b.e(parcel0, v1);
                    break;
                }
                default: {
                    b.u(parcel0, v1);
                }
            }
        }
        b.j(parcel0, v);
        return new d(s, s1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new d[v];
    }
}

