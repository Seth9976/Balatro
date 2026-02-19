package a1;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import z1.c;
import z1.d;

public abstract class s extends c implements t {
    public s() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override  // z1.c
    protected final boolean a(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 101: {
                GoogleSignInAccount googleSignInAccount0 = (GoogleSignInAccount)d.a(parcel0, GoogleSignInAccount.CREATOR);
                Status status0 = (Status)d.a(parcel0, Status.CREATOR);
                d.b(parcel0);
                this.S(googleSignInAccount0, status0);
                break;
            }
            case 102: {
                Status status1 = (Status)d.a(parcel0, Status.CREATOR);
                d.b(parcel0);
                this.p(status1);
                break;
            }
            case 103: {
                Status status2 = (Status)d.a(parcel0, Status.CREATOR);
                d.b(parcel0);
                this.P(status2);
                break;
            }
            default: {
                return false;
            }
        }
        parcel1.writeNoException();
        return true;
    }
}

