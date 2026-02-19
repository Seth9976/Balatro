package r1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class c implements Parcelable.Creator {
    static void a(a a0, Parcel parcel0, int v) {
        int v1 = h1.c.a(parcel0);
        h1.c.n(parcel0, 1, a0.f(), false);
        h1.c.n(parcel0, 2, a0.d(), false);
        h1.c.k(parcel0, 3, a0.a());
        h1.c.m(parcel0, 4, a0.e(), v, false);
        h1.c.m(parcel0, 5, a0.c(), v, false);
        h1.c.m(parcel0, 6, a0.b(), v, false);
        h1.c.b(parcel0, v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        String s = null;
        String s1 = null;
        Uri uri0 = null;
        Uri uri1 = null;
        Uri uri2 = null;
        long v1 = 0L;
        while(parcel0.dataPosition() < v) {
            int v2 = b.o(parcel0);
            switch(((char)v2)) {
                case 1: {
                    s = b.e(parcel0, v2);
                    break;
                }
                case 2: {
                    s1 = b.e(parcel0, v2);
                    break;
                }
                case 3: {
                    v1 = b.r(parcel0, v2);
                    break;
                }
                case 4: {
                    uri0 = (Uri)b.d(parcel0, v2, Uri.CREATOR);
                    break;
                }
                case 5: {
                    uri1 = (Uri)b.d(parcel0, v2, Uri.CREATOR);
                    break;
                }
                case 6: {
                    uri2 = (Uri)b.d(parcel0, v2, Uri.CREATOR);
                    break;
                }
                default: {
                    b.u(parcel0, v2);
                }
            }
        }
        b.j(parcel0, v);
        return new a(s, s1, v1, uri0, uri1, uri2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new a[v];
    }
}

