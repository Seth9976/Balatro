package v1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;
import n1.a;

public final class k implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        a a0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = b.o(parcel0);
            if(((char)v1) == 1) {
                a0 = (a)b.d(parcel0, v1, a.CREATOR);
            }
            else {
                b.u(parcel0, v1);
            }
        }
        b.j(parcel0, v);
        return new c(a0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new c[v];
    }
}

