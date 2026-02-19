package f2;

import a2.a;
import a2.c;
import android.os.IBinder;
import android.os.Parcel;

public final class g extends a {
    g(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void W(j j0, f f0) {
        Parcel parcel0 = this.a();
        c.c(parcel0, j0);
        c.d(parcel0, f0);
        this.d(12, parcel0);
    }
}

