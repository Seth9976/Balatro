package f2;

import a2.b;
import a2.c;
import android.os.Parcel;
import c1.a;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract class e extends b implements f {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override  // a2.b
    protected final boolean W(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 3: {
                a a0 = (a)c.a(parcel0, a.CREATOR);
                f2.b b0 = (f2.b)c.a(parcel0, f2.b.CREATOR);
                c.b(parcel0);
                break;
            }
            case 4: 
            case 6: {
                Status status0 = (Status)c.a(parcel0, Status.CREATOR);
                c.b(parcel0);
                break;
            }
            case 7: {
                Status status1 = (Status)c.a(parcel0, Status.CREATOR);
                GoogleSignInAccount googleSignInAccount0 = (GoogleSignInAccount)c.a(parcel0, GoogleSignInAccount.CREATOR);
                c.b(parcel0);
                break;
            }
            case 8: {
                l l0 = (l)c.a(parcel0, l.CREATOR);
                c.b(parcel0);
                this.m(l0);
                break;
            }
            case 9: {
                h h0 = (h)c.a(parcel0, h.CREATOR);
                c.b(parcel0);
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

