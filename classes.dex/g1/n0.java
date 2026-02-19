package g1;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import h1.b;

public final class n0 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        Account account0 = null;
        int v1 = 0;
        int v2 = 0;
        GoogleSignInAccount googleSignInAccount0 = null;
        while(parcel0.dataPosition() < v) {
            int v3 = b.o(parcel0);
            switch(((char)v3)) {
                case 1: {
                    v1 = b.q(parcel0, v3);
                    break;
                }
                case 2: {
                    account0 = (Account)b.d(parcel0, v3, Account.CREATOR);
                    break;
                }
                case 3: {
                    v2 = b.q(parcel0, v3);
                    break;
                }
                case 4: {
                    googleSignInAccount0 = (GoogleSignInAccount)b.d(parcel0, v3, GoogleSignInAccount.CREATOR);
                    break;
                }
                default: {
                    b.u(parcel0, v3);
                }
            }
        }
        b.j(parcel0, v);
        return new m0(v1, account0, v2, googleSignInAccount0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new m0[v];
    }
}

