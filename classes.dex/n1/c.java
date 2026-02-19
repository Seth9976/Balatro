package n1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import h1.b;

public final class c implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        String s = null;
        long v1 = 0L;
        long v2 = 0L;
        int v3 = -1;
        while(parcel0.dataPosition() < v) {
            int v4 = b.o(parcel0);
            switch(((char)v4)) {
                case 2: {
                    s = b.e(parcel0, v4);
                    break;
                }
                case 3: {
                    v1 = b.r(parcel0, v4);
                    break;
                }
                case 4: {
                    v2 = b.r(parcel0, v4);
                    break;
                }
                case 5: {
                    v3 = b.q(parcel0, v4);
                    break;
                }
                default: {
                    b.u(parcel0, v4);
                }
            }
        }
        b.j(parcel0, v);
        return new DriveId(s, v1, v2, v3);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new DriveId[v];
    }
}

