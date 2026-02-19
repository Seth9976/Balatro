package g1;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import b2.a;
import b2.c;

public final class q1 extends a implements k {
    q1(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override  // g1.k
    public final Account b() {
        Parcel parcel0 = this.a(2, this.d());
        Account account0 = (Account)c.a(parcel0, Account.CREATOR);
        parcel0.recycle();
        return account0;
    }
}

