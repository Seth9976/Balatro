package g1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import c1.c;
import h1.b;

public final class f1 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        Bundle bundle0 = null;
        f f0 = null;
        int v1 = 0;
        c[] arr_c = null;
        while(parcel0.dataPosition() < v) {
            int v2 = b.o(parcel0);
            switch(((char)v2)) {
                case 1: {
                    bundle0 = b.b(parcel0, v2);
                    break;
                }
                case 2: {
                    arr_c = (c[])b.h(parcel0, v2, c.CREATOR);
                    break;
                }
                case 3: {
                    v1 = b.q(parcel0, v2);
                    break;
                }
                case 4: {
                    f0 = (f)b.d(parcel0, v2, f.CREATOR);
                    break;
                }
                default: {
                    b.u(parcel0, v2);
                }
            }
        }
        b.j(parcel0, v);
        return new e1(bundle0, arr_c, v1, f0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new e1[v];
    }
}

