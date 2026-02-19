package g1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class h0 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        int v1 = -1;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        String s = null;
        String s1 = null;
        long v6 = 0L;
        long v7 = 0L;
        while(parcel0.dataPosition() < v) {
            int v8 = b.o(parcel0);
            switch(((char)v8)) {
                case 1: {
                    v2 = b.q(parcel0, v8);
                    break;
                }
                case 2: {
                    v3 = b.q(parcel0, v8);
                    break;
                }
                case 3: {
                    v4 = b.q(parcel0, v8);
                    break;
                }
                case 4: {
                    v6 = b.r(parcel0, v8);
                    break;
                }
                case 5: {
                    v7 = b.r(parcel0, v8);
                    break;
                }
                case 6: {
                    s = b.e(parcel0, v8);
                    break;
                }
                case 7: {
                    s1 = b.e(parcel0, v8);
                    break;
                }
                case 8: {
                    v5 = b.q(parcel0, v8);
                    break;
                }
                case 9: {
                    v1 = b.q(parcel0, v8);
                    break;
                }
                default: {
                    b.u(parcel0, v8);
                }
            }
        }
        b.j(parcel0, v);
        return new n(v2, v3, v4, v6, v7, s, s1, v5, v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new n[v];
    }
}

