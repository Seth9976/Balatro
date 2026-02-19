package i1;

import a2.c;
import android.os.IBinder;
import android.os.Parcel;
import g1.t;

public final class a extends a2.a {
    a(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void W(t t0) {
        Parcel parcel0 = this.a();
        c.c(parcel0, t0);
        this.f(1, parcel0);
    }
}

