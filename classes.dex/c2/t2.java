package c2;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class t2 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        String s = null;
        while(parcel0.dataPosition() < v) {
            int v1 = b.o(parcel0);
            if(((char)v1) == 1) {
                s = b.e(parcel0, v1);
            }
            else {
                b.u(parcel0, v1);
            }
        }
        b.j(parcel0, v);
        return new s2(s);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new s2[v];
    }
}

