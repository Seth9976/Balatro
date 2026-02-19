package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;

public abstract class d6 extends g6 implements e6 {
    public static e6 a(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
        return iInterface0 instanceof e6 ? ((e6)iInterface0) : new c6(iBinder0);
    }
}

