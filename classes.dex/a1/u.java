package a1;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import z1.a;
import z1.d;

public final class u extends a {
    u(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void W(t t0, GoogleSignInOptions googleSignInOptions0) {
        Parcel parcel0 = this.a();
        d.d(parcel0, t0);
        d.c(parcel0, googleSignInOptions0);
        this.d(102, parcel0);
    }

    public final void f(t t0, GoogleSignInOptions googleSignInOptions0) {
        Parcel parcel0 = this.a();
        d.d(parcel0, t0);
        d.c(parcel0, googleSignInOptions0);
        this.d(103, parcel0);
    }
}

