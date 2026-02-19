package g1;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import c1.a;
import h1.b;

public final class p0 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        int v1 = 0;
        boolean z = false;
        boolean z1 = false;
        IBinder iBinder0 = null;
        a a0 = null;
        while(parcel0.dataPosition() < v) {
            int v2 = b.o(parcel0);
            switch(((char)v2)) {
                case 1: {
                    v1 = b.q(parcel0, v2);
                    break;
                }
                case 2: {
                    iBinder0 = b.p(parcel0, v2);
                    break;
                }
                case 3: {
                    a0 = (a)b.d(parcel0, v2, a.CREATOR);
                    break;
                }
                case 4: {
                    z = b.l(parcel0, v2);
                    break;
                }
                case 5: {
                    z1 = b.l(parcel0, v2);
                    break;
                }
                default: {
                    b.u(parcel0, v2);
                }
            }
        }
        b.j(parcel0, v);
        return new o0(v1, iBinder0, a0, z, z1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new o0[v];
    }
}

