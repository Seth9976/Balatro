package c1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class q implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        PendingIntent pendingIntent0 = null;
        int v1 = 0;
        int v2 = 0;
        String s = null;
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
                    pendingIntent0 = (PendingIntent)b.d(parcel0, v3, PendingIntent.CREATOR);
                    break;
                }
                case 4: {
                    s = b.e(parcel0, v3);
                    break;
                }
                default: {
                    b.u(parcel0, v3);
                }
            }
        }
        b.j(parcel0, v);
        return new a(v1, v2, pendingIntent0, s);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new a[v];
    }
}

