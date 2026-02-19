package x1;

import android.os.IBinder;
import android.os.Parcel;
import w0.d;

public final class g extends a {
    g(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.appset.internal.IAppSetService");
    }

    public final void f(d d0, f f0) {
        Parcel parcel0 = this.a();
        c.b(parcel0, d0);
        c.c(parcel0, f0);
        this.d(1, parcel0);
    }
}

