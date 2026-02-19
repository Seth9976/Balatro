package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class y {
    public final int a;

    public y(int v) {
        this.a = v;
    }

    public abstract void a(Status arg1);

    public abstract void b(Exception arg1);

    public abstract void c(n arg1);

    public abstract void d(g arg1, boolean arg2);

    static Status e(RemoteException remoteException0) {
        return new Status(19, remoteException0.getClass().getSimpleName() + ": " + remoteException0.getLocalizedMessage());
    }
}

