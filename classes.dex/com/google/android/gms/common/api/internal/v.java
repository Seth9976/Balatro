package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import g1.q;

public final class v extends y {
    protected final b b;

    public v(int v, b b0) {
        super(v);
        this.b = (b)q.j(b0, "Null methods are not runnable.");
    }

    @Override  // com.google.android.gms.common.api.internal.y
    public final void a(Status status0) {
        try {
            this.b.b(status0);
        }
        catch(IllegalStateException illegalStateException0) {
            Log.w("ApiCallRunner", "Exception reporting failure", illegalStateException0);
        }
    }

    @Override  // com.google.android.gms.common.api.internal.y
    public final void b(Exception exception0) {
        Status status0 = new Status(10, exception0.getClass().getSimpleName() + ": " + exception0.getLocalizedMessage());
        try {
            this.b.b(status0);
        }
        catch(IllegalStateException illegalStateException0) {
            Log.w("ApiCallRunner", "Exception reporting failure", illegalStateException0);
        }
    }

    @Override  // com.google.android.gms.common.api.internal.y
    public final void c(n n0) {
        try {
            this.b.p(n0.v());
        }
        catch(RuntimeException runtimeException0) {
            this.b(runtimeException0);
        }
    }

    @Override  // com.google.android.gms.common.api.internal.y
    public final void d(g g0, boolean z) {
        g0.c(this.b, z);
    }
}

