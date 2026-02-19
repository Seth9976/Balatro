package s1;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class t implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        String s = null;
        ComponentName componentName0 = null;
        String s1 = null;
        int v1 = 0;
        long v2 = 0L;
        while(parcel0.dataPosition() < v) {
            int v3 = b.o(parcel0);
            switch(((char)v3)) {
                case 1: {
                    v2 = b.r(parcel0, v3);
                    break;
                }
                case 2: {
                    s = b.e(parcel0, v3);
                    break;
                }
                case 3: {
                    v1 = b.q(parcel0, v3);
                    break;
                }
                case 4: {
                    componentName0 = (ComponentName)b.d(parcel0, v3, ComponentName.CREATOR);
                    break;
                }
                case 5: {
                    s1 = b.e(parcel0, v3);
                    break;
                }
                default: {
                    b.u(parcel0, v3);
                }
            }
        }
        b.j(parcel0, v);
        return new s(v2, s, v1, componentName0, s1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new s[v];
    }
}

