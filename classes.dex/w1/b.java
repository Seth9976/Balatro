package w1;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class b implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = h1.b.v(parcel0);
        boolean[] arr_z = null;
        boolean[] arr_z1 = null;
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        while(parcel0.dataPosition() < v) {
            int v1 = h1.b.o(parcel0);
            switch(((char)v1)) {
                case 1: {
                    z = h1.b.l(parcel0, v1);
                    break;
                }
                case 2: {
                    z1 = h1.b.l(parcel0, v1);
                    break;
                }
                case 3: {
                    z2 = h1.b.l(parcel0, v1);
                    break;
                }
                case 4: {
                    arr_z = h1.b.a(parcel0, v1);
                    break;
                }
                case 5: {
                    arr_z1 = h1.b.a(parcel0, v1);
                    break;
                }
                default: {
                    h1.b.u(parcel0, v1);
                }
            }
        }
        h1.b.j(parcel0, v);
        return new a(z, z1, z2, arr_z, arr_z1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new a[v];
    }
}

