package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import c1.c;
import com.google.android.gms.common.api.Status;
import e1.l;
import e1.u;
import g2.i;

public final class w extends u {
    private final d b;
    private final i c;
    private final l d;

    public w(int v, d d0, i i0, l l0) {
        super(v);
        this.c = i0;
        this.b = d0;
        this.d = l0;
        if(v == 2 && d0.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override  // com.google.android.gms.common.api.internal.y
    public final void a(Status status0) {
        Exception exception0 = this.d.a(status0);
        this.c.d(exception0);
    }

    @Override  // com.google.android.gms.common.api.internal.y
    public final void b(Exception exception0) {
        this.c.d(exception0);
    }

    @Override  // com.google.android.gms.common.api.internal.y
    public final void c(n n0) {
        try {
            this.b.b(n0.v(), this.c);
        }
        catch(DeadObjectException deadObjectException0) {
            throw deadObjectException0;
        }
        catch(RemoteException remoteException0) {
            this.a(y.e(remoteException0));
        }
        catch(RuntimeException runtimeException0) {
            this.c.d(runtimeException0);
        }
    }

    @Override  // com.google.android.gms.common.api.internal.y
    public final void d(g g0, boolean z) {
        g0.d(this.c, z);
    }

    @Override  // e1.u
    public final boolean f(n n0) {
        return this.b.c();
    }

    @Override  // e1.u
    public final c[] g(n n0) {
        return this.b.e();
    }
}

