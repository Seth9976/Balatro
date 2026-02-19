package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class g implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        String s = "";
        GoogleSignInAccount googleSignInAccount0 = null;
        String s1 = "";
        while(parcel0.dataPosition() < v) {
            int v1 = b.o(parcel0);
            switch(((char)v1)) {
                case 4: {
                    s = b.e(parcel0, v1);
                    break;
                }
                case 7: {
                    googleSignInAccount0 = (GoogleSignInAccount)b.d(parcel0, v1, GoogleSignInAccount.CREATOR);
                    break;
                }
                case 8: {
                    s1 = b.e(parcel0, v1);
                    break;
                }
                default: {
                    b.u(parcel0, v1);
                }
            }
        }
        b.j(parcel0, v);
        return new SignInAccount(s, googleSignInAccount0, s1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SignInAccount[v];
    }
}

