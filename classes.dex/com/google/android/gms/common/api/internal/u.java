package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import d1.b;
import g2.i;

abstract class u extends e1.u {
    protected final i b;

    public u(int v, i i0) {
        super(v);
        this.b = i0;
    }

    @Override  // com.google.android.gms.common.api.internal.y
    public final void a(Status status0) {
        b b0 = new b(status0);
        this.b.d(b0);
    }

    @Override  // com.google.android.gms.common.api.internal.y
    public final void b(Exception exception0) {
        this.b.d(exception0);
    }

    @Override  // com.google.android.gms.common.api.internal.y
    public final void c(n n0) {
        try {
            this.h(n0);
        }
        catch(DeadObjectException deadObjectException0) {
            this.a(y.e(deadObjectException0));
            throw deadObjectException0;
        }
        catch(RemoteException remoteException0) {
            this.a(y.e(remoteException0));
        }
        catch(RuntimeException runtimeException0) {
            this.b.d(runtimeException0);
        }
    }

    protected abstract void h(n arg1);
}

