package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import h1.b;
import java.util.List;

public final class c implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        String s = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        Uri uri0 = null;
        String s4 = null;
        String s5 = null;
        List list0 = null;
        String s6 = null;
        String s7 = null;
        long v1 = 0L;
        int v2 = 0;
        while(parcel0.dataPosition() < v) {
            int v3 = b.o(parcel0);
            switch(((char)v3)) {
                case 1: {
                    v2 = b.q(parcel0, v3);
                    break;
                }
                case 2: {
                    s = b.e(parcel0, v3);
                    break;
                }
                case 3: {
                    s1 = b.e(parcel0, v3);
                    break;
                }
                case 4: {
                    s2 = b.e(parcel0, v3);
                    break;
                }
                case 5: {
                    s3 = b.e(parcel0, v3);
                    break;
                }
                case 6: {
                    uri0 = (Uri)b.d(parcel0, v3, Uri.CREATOR);
                    break;
                }
                case 7: {
                    s4 = b.e(parcel0, v3);
                    break;
                }
                case 8: {
                    v1 = b.r(parcel0, v3);
                    break;
                }
                case 9: {
                    s5 = b.e(parcel0, v3);
                    break;
                }
                case 10: {
                    list0 = b.i(parcel0, v3, Scope.CREATOR);
                    break;
                }
                case 11: {
                    s6 = b.e(parcel0, v3);
                    break;
                }
                case 12: {
                    s7 = b.e(parcel0, v3);
                    break;
                }
                default: {
                    b.u(parcel0, v3);
                }
            }
        }
        b.j(parcel0, v);
        return new GoogleSignInAccount(v2, s, s1, s2, s3, uri0, s4, v1, s5, list0, s6, s7);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new GoogleSignInAccount[v];
    }
}

