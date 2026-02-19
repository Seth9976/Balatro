package r1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class g implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while(parcel0.dataPosition() < v) {
            int v1 = b.o(parcel0);
            switch(((char)v1)) {
                case 1: {
                    z = b.l(parcel0, v1);
                    break;
                }
                case 2: {
                    z1 = b.l(parcel0, v1);
                    break;
                }
                case 3: {
                    z2 = b.l(parcel0, v1);
                    break;
                }
                case 4: {
                    z3 = b.l(parcel0, v1);
                    break;
                }
                case 5: {
                    z4 = b.l(parcel0, v1);
                    break;
                }
                case 6: {
                    z5 = b.l(parcel0, v1);
                    break;
                }
                case 7: {
                    z6 = b.l(parcel0, v1);
                    break;
                }
                case 8: {
                    z7 = b.l(parcel0, v1);
                    break;
                }
                case 9: {
                    z8 = b.l(parcel0, v1);
                    break;
                }
                case 10: {
                    z9 = b.l(parcel0, v1);
                    break;
                }
                default: {
                    b.u(parcel0, v1);
                }
            }
        }
        b.j(parcel0, v);
        return new f(z, z1, z2, z3, z4, z5, z6, z7, z8, z9);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new f[v];
    }
}

