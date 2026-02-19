package g0;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a implements IInterface {
    private final IBinder a;
    private final String b;

    protected a(IBinder iBinder0) {
        this.a = iBinder0;
        this.b = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";
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

    protected final Parcel d(Parcel parcel0) {
        Parcel parcel1 = Parcel.obtain();
        try {
            this.a.transact(1, parcel0, parcel1, 0);
            parcel1.readException();
            return parcel1;
        }
        catch(RuntimeException runtimeException0) {
            parcel1.recycle();
            throw runtimeException0;
        }
        finally {
            parcel0.recycle();
        }
    }
}

