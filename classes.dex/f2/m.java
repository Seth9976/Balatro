package f2;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import c1.a;
import g1.o0;
import h1.b;

public final class m implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        a a0 = null;
        int v1 = 0;
        o0 o00 = null;
        while(parcel0.dataPosition() < v) {
            int v2 = b.o(parcel0);
            switch(((char)v2)) {
                case 1: {
                    v1 = b.q(parcel0, v2);
                    break;
                }
                case 2: {
                    a0 = (a)b.d(parcel0, v2, a.CREATOR);
                    break;
                }
                case 3: {
                    o00 = (o0)b.d(parcel0, v2, o0.CREATOR);
                    break;
                }
                default: {
                    b.u(parcel0, v2);
                }
            }
        }
        b.j(parcel0, v);
        return new l(v1, a0, o00);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new l[v];
    }
}

