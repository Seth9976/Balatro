package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import d1.a;
import d1.f;
import d1.k;
import e1.c;
import g1.q;

public abstract class b extends BasePendingResult implements c {
    private final d1.a.c n;
    private final a o;

    protected b(a a0, f f0) {
        super(((f)q.j(f0, "GoogleApiClient must not be null")));
        q.j(a0, "Api must not be null");
        this.n = a0.b();
        this.o = a0;
    }

    @Override  // e1.c
    public final void b(Status status0) {
        q.b(!status0.o0(), "Failed result must not be success");
        this.h(this.e(status0));
    }

    protected abstract void n(d1.a.b arg1);

    protected void o(k k0) {
    }

    public final void p(d1.a.b a$b0) {
        try {
            this.n(a$b0);
        }
        catch(DeadObjectException deadObjectException0) {
            this.q(deadObjectException0);
            throw deadObjectException0;
        }
        catch(RemoteException remoteException0) {
            this.q(remoteException0);
        }
    }

    private void q(RemoteException remoteException0) {
        this.b(new Status(8, remoteException0.getLocalizedMessage(), null));
    }
}

