package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface ILicensingService extends IInterface {
    public static abstract class a extends Binder implements ILicensingService {
        static class com.android.vending.licensing.ILicensingService.a.a implements ILicensingService {
            private IBinder a;

            com.android.vending.licensing.ILicensingService.a.a(IBinder iBinder0) {
                this.a = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override  // com.android.vending.licensing.ILicensingService
            public void h(long v, String s, com.android.vending.licensing.a a0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.android.vending.licensing.ILicensingService");
                    parcel0.writeLong(v);
                    parcel0.writeString(s);
                    parcel0.writeStrongBinder((a0 == null ? null : a0.asBinder()));
                    this.a.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        public static ILicensingService a(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.android.vending.licensing.ILicensingService");
            return iInterface0 != null && iInterface0 instanceof ILicensingService ? ((ILicensingService)iInterface0) : new com.android.vending.licensing.ILicensingService.a.a(iBinder0);
        }
    }

    void h(long arg1, String arg2, com.android.vending.licensing.a arg3);
}

