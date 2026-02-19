package g1;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import b2.b;

public interface k extends IInterface {
    public static abstract class a extends b implements k {
        public static k d(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return iInterface0 instanceof k ? ((k)iInterface0) : new q1(iBinder0);
        }
    }

    Account b();
}

