package g1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class g1 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        s s0 = null;
        int[] arr_v = null;
        int[] arr_v1 = null;
        boolean z = false;
        boolean z1 = false;
        int v1 = 0;
        while(parcel0.dataPosition() < v) {
            int v2 = b.o(parcel0);
            switch(((char)v2)) {
                case 1: {
                    s0 = (s)b.d(parcel0, v2, s.CREATOR);
                    break;
                }
                case 2: {
                    z = b.l(parcel0, v2);
                    break;
                }
                case 3: {
                    z1 = b.l(parcel0, v2);
                    break;
                }
                case 4: {
                    arr_v = b.c(parcel0, v2);
                    break;
                }
                case 5: {
                    v1 = b.q(parcel0, v2);
                    break;
                }
                case 6: {
                    arr_v1 = b.c(parcel0, v2);
                    break;
                }
                default: {
                    b.u(parcel0, v2);
                }
            }
        }
        b.j(parcel0, v);
        return new f(s0, z, z1, arr_v, v1, arr_v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new f[v];
    }
}

