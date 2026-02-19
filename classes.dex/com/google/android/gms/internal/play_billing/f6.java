package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class f6 implements IInterface {
    private final IBinder a;
    private final String b;

    protected f6(IBinder iBinder0, String s) {
        this.a = iBinder0;
        this.b = "com.android.vending.billing.IInAppBillingService";
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

    protected final Parcel d(int v, Parcel parcel0) {
        Parcel parcel1 = Parcel.obtain();
        try {
            this.a.transact(v, parcel0, parcel1, 0);
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

