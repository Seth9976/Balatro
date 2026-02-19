package x1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a implements IInterface {
    private final IBinder a;
    private final String b;

    protected a(IBinder iBinder0, String s) {
        this.a = iBinder0;
        this.b = "com.google.android.gms.appset.internal.IAppSetService";
    }

    protected final Parcel a() {
        Parcel parcel0 = Parcel.obtain();
        parcel0.writeInterfaceToken(this.b);
        return parcel0;
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    protected final void d(int v, Parcel parcel0) {
        Parcel parcel1 = Parcel.obtain();
        try {
            this.a.transact(1, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel0.recycle();
            parcel1.recycle();
        }
    }
}

