package g1;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

public abstract class a extends g1.k.a {
    public static Account f(k k0) {
        Account account0 = null;
        if(k0 != null) {
            long v = Binder.clearCallingIdentity();
            try {
                account0 = k0.b();
            }
            catch(RemoteException unused_ex) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            }
            finally {
                Binder.restoreCallingIdentity(v);
            }
            return account0;
        }
        return null;
    }
}

