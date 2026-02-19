package g1;

import android.os.IBinder;
import android.os.Parcel;

final class t0 implements m {
    private final IBinder a;

    t0(IBinder iBinder0) {
        this.a = iBinder0;
    }

    @Override  // g1.m
    public final void G(l l0, g g0) {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcel0.writeStrongBinder((l0 == null ? null : l0.asBinder()));
            if(g0 == null) {
                parcel0.writeInt(0);
            }
            else {
                parcel0.writeInt(1);
                h1.a(g0, parcel0, 0);
            }
            this.a.transact(46, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}

