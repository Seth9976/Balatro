package f2;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class c implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        Intent intent0 = null;
        int v1 = 0;
        int v2 = 0;
        while(parcel0.dataPosition() < v) {
            int v3 = b.o(parcel0);
            switch(((char)v3)) {
                case 1: {
                    v1 = b.q(parcel0, v3);
                    break;
                }
                case 2: {
                    v2 = b.q(parcel0, v3);
                    break;
                }
                case 3: {
                    intent0 = (Intent)b.d(parcel0, v3, Intent.CREATOR);
                    break;
                }
                default: {
                    b.u(parcel0, v3);
                }
            }
        }
        b.j(parcel0, v);
        return new f2.b(v1, v2, intent0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new f2.b[v];
    }
}

