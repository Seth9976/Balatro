package c2;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class y2 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        Intent intent0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = b.o(parcel0);
            if(((char)v1) == 1) {
                intent0 = (Intent)b.d(parcel0, v1, Intent.CREATOR);
            }
            else {
                b.u(parcel0, v1);
            }
        }
        b.j(parcel0, v);
        return new x2(intent0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new x2[v];
    }
}

