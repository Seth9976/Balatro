package f2;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;
import java.util.List;

public final class i implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        List list0 = null;
        String s = null;
        while(parcel0.dataPosition() < v) {
            int v1 = b.o(parcel0);
            switch(((char)v1)) {
                case 1: {
                    list0 = b.g(parcel0, v1);
                    break;
                }
                case 2: {
                    s = b.e(parcel0, v1);
                    break;
                }
                default: {
                    b.u(parcel0, v1);
                }
            }
        }
        b.j(parcel0, v);
        return new h(list0, s);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new h[v];
    }
}

