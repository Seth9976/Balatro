package g1;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import h1.a;
import h1.c;

public final class m0 extends a {
    public static final Parcelable.Creator CREATOR;
    final int e;
    private final Account f;
    private final int g;
    private final GoogleSignInAccount h;

    static {
        m0.CREATOR = new n0();
    }

    m0(int v, Account account0, int v1, GoogleSignInAccount googleSignInAccount0) {
        this.e = v;
        this.f = account0;
        this.g = v1;
        this.h = googleSignInAccount0;
    }

    public m0(Account account0, int v, GoogleSignInAccount googleSignInAccount0) {
        this(2, account0, v, googleSignInAccount0);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.i(parcel0, 1, this.e);
        c.m(parcel0, 2, this.f, v, false);
        c.i(parcel0, 3, this.g);
        c.m(parcel0, 4, this.h, v, false);
        c.b(parcel0, v1);
    }
}

