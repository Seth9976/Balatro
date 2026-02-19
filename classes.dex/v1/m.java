package v1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import h1.b;

public final class m implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        String s = null;
        Long long0 = null;
        BitmapTeleporter bitmapTeleporter0 = null;
        Uri uri0 = null;
        Long long1 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = b.o(parcel0);
            switch(((char)v1)) {
                case 1: {
                    s = b.e(parcel0, v1);
                    break;
                }
                case 2: {
                    long0 = b.s(parcel0, v1);
                    break;
                }
                case 4: {
                    uri0 = (Uri)b.d(parcel0, v1, Uri.CREATOR);
                    break;
                }
                case 5: {
                    bitmapTeleporter0 = (BitmapTeleporter)b.d(parcel0, v1, BitmapTeleporter.CREATOR);
                    break;
                }
                case 6: {
                    long1 = b.s(parcel0, v1);
                    break;
                }
                default: {
                    b.u(parcel0, v1);
                }
            }
        }
        b.j(parcel0, v);
        return new h(s, long0, bitmapTeleporter0, uri0, long1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new h[v];
    }
}

