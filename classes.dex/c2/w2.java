package c2;

import android.os.IBinder;
import android.os.Parcel;

public final class w2 extends a {
    w2(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.games.internal.connect.IGamesConnectService");
    }

    public final void W(v2 v20, q2 q20) {
        Parcel parcel0 = this.a();
        m0.d(parcel0, v20);
        m0.c(parcel0, q20);
        this.f(2, parcel0);
    }
}

