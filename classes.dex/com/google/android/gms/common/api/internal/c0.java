package com.google.android.gms.common.api.internal;

import a2.h;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import c1.a;
import c1.i;
import e1.b0;
import e1.f;
import java.util.concurrent.atomic.AtomicReference;

public abstract class c0 extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean b;
    protected final AtomicReference c;
    private final Handler d;
    protected final i e;

    c0(f f0, i i0) {
        super(f0);
        this.c = new AtomicReference(null);
        this.d = new h(Looper.getMainLooper());
        this.e = i0;
    }

    @Override  // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void e(int v, int v1, Intent intent0) {
        int v2 = 13;
        z z0 = (z)this.c.get();
    alab1:
        switch(v) {
            case 1: {
                switch(v1) {
                    case -1: {
                        this.o();
                        return;
                    }
                    case 0: {
                        if(z0 != null) {
                            if(intent0 != null) {
                                v2 = intent0.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                            }
                            this.l(new a(v2, null, z0.b().toString()), c0.p(z0));
                            return;
                        }
                        break alab1;
                    }
                    default: {
                        goto label_20;
                    }
                }
            }
            case 2: {
                Activity activity0 = this.b();
                int v3 = this.e.f(activity0);
                if(v3 == 0) {
                    this.o();
                    return;
                }
                if(z0 == null || z0.b().j0() == 18 && v3 == 18) {
                    return;
                }
            label_20:
                if(z0 != null) {
                    this.l(z0.b(), z0.a());
                }
                break;
            }
            default: {
                goto label_20;
            }
        }
    }

    @Override  // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void f(Bundle bundle0) {
        super.f(bundle0);
        if(bundle0 != null) {
            z z0 = bundle0.getBoolean("resolving_error", false) ? new z(new a(bundle0.getInt("failed_status"), ((PendingIntent)bundle0.getParcelable("failed_resolution"))), bundle0.getInt("failed_client_id", -1)) : null;
            this.c.set(z0);
        }
    }

    @Override  // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void i(Bundle bundle0) {
        super.i(bundle0);
        z z0 = (z)this.c.get();
        if(z0 == null) {
            return;
        }
        bundle0.putBoolean("resolving_error", true);
        bundle0.putInt("failed_client_id", z0.a());
        bundle0.putInt("failed_status", z0.b().j0());
        bundle0.putParcelable("failed_resolution", z0.b().l0());
    }

    @Override  // com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        this.b = true;
    }

    @Override  // com.google.android.gms.common.api.internal.LifecycleCallback
    public void k() {
        super.k();
        this.b = false;
    }

    private final void l(a a0, int v) {
        this.c.set(null);
        this.m(a0, v);
    }

    protected abstract void m(a arg1, int arg2);

    protected abstract void n();

    private final void o() {
        this.c.set(null);
        this.n();
    }

    @Override  // android.content.DialogInterface$OnCancelListener
    public final void onCancel(DialogInterface dialogInterface0) {
        this.l(new a(13, null), c0.p(((z)this.c.get())));
    }

    private static final int p(z z0) {
        return z0 == null ? -1 : z0.a();
    }

    public final void s(a a0, int v) {
        z z0 = new z(a0, v);
        do {
            AtomicReference atomicReference0 = this.c;
            if(b0.a(atomicReference0, null, z0)) {
                com.google.android.gms.common.api.internal.b0 b00 = new com.google.android.gms.common.api.internal.b0(this, z0);
                this.d.post(b00);
                return;
            }
        }
        while(atomicReference0.get() == null);
    }
}

