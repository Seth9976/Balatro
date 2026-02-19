package v0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import g0.b;
import g0.c;

public interface a extends IInterface {
    public static abstract class v0.a.a extends b implements a {
        public static class v0.a.a.a extends g0.a implements a {
            v0.a.a.a(IBinder iBinder0) {
                super(iBinder0);
            }

            @Override  // v0.a
            public final Bundle o(Bundle bundle0) {
                Parcel parcel0 = this.a();
                c.b(parcel0, bundle0);
                Parcel parcel1 = this.d(parcel0);
                Bundle bundle1 = (Bundle)c.a(parcel1, Bundle.CREATOR);
                parcel1.recycle();
                return bundle1;
            }
        }

        public static a a(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            return iInterface0 instanceof a ? ((a)iInterface0) : new v0.a.a.a(iBinder0);
        }
    }

    Bundle o(Bundle arg1);
}

