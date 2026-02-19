package a1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import h1.b;

public final class w implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        String s = null;
        GoogleSignInOptions googleSignInOptions0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = b.o(parcel0);
            switch(((char)v1)) {
                case 2: {
                    s = b.e(parcel0, v1);
                    break;
                }
                case 5: {
                    googleSignInOptions0 = (GoogleSignInOptions)b.d(parcel0, v1, GoogleSignInOptions.CREATOR);
                    break;
                }
                default: {
                    b.u(parcel0, v1);
                }
            }
        }
        b.j(parcel0, v);
        return new SignInConfiguration(s, googleSignInOptions0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SignInConfiguration[v];
    }
}

