package n1;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;

public final class b implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = h1.b.v(parcel0);
        ParcelFileDescriptor parcelFileDescriptor0 = null;
        DriveId driveId0 = null;
        String s = null;
        int v1 = 0;
        int v2 = 0;
        boolean z = false;
        while(parcel0.dataPosition() < v) {
            int v3 = h1.b.o(parcel0);
            switch(((char)v3)) {
                case 2: {
                    parcelFileDescriptor0 = (ParcelFileDescriptor)h1.b.d(parcel0, v3, ParcelFileDescriptor.CREATOR);
                    break;
                }
                case 3: {
                    v1 = h1.b.q(parcel0, v3);
                    break;
                }
                case 4: {
                    v2 = h1.b.q(parcel0, v3);
                    break;
                }
                case 5: {
                    driveId0 = (DriveId)h1.b.d(parcel0, v3, DriveId.CREATOR);
                    break;
                }
                case 7: {
                    z = h1.b.l(parcel0, v3);
                    break;
                }
                case 8: {
                    s = h1.b.e(parcel0, v3);
                    break;
                }
                default: {
                    h1.b.u(parcel0, v3);
                }
            }
        }
        h1.b.j(parcel0, v);
        return new a(parcelFileDescriptor0, v1, v2, driveId0, z, s);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new a[v];
    }
}

