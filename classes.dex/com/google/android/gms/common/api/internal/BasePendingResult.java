package com.google.android.gms.common.api.internal;

import a2.h;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import d1.f;
import d1.g;
import d1.i;
import d1.k;
import g1.q;
import h.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasePendingResult extends g {
    public static class a extends h {
        public a(Looper looper0) {
            super(looper0);
        }

        @Override  // android.os.Handler
        public final void handleMessage(Message message0) {
            int v = message0.what;
            switch(v) {
                case 1: {
                    Pair pair0 = (Pair)message0.obj;
                    d.a(pair0.first);
                    k k0 = (k)pair0.second;
                    try {
                        throw null;
                    }
                    catch(RuntimeException runtimeException0) {
                        BasePendingResult.m(k0);
                        throw runtimeException0;
                    }
                }
                case 2: {
                    ((BasePendingResult)message0.obj).f(Status.m);
                    return;
                }
                default: {
                    Log.wtf("BasePendingResult", "Don\'t know how to handle message: " + v, new Exception());
                }
            }
        }
    }

    private final Object a;
    protected final a b;
    protected final WeakReference c;
    private final CountDownLatch d;
    private final ArrayList e;
    private final AtomicReference f;
    private k g;
    private Status h;
    private volatile boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    static final ThreadLocal m;
    private e0 resultGuardian;

    static {
        BasePendingResult.m = new d0();
    }

    protected BasePendingResult(f f0) {
        this.a = new Object();
        this.d = new CountDownLatch(1);
        this.e = new ArrayList();
        this.f = new AtomicReference();
        this.l = false;
        this.b = new a((f0 == null ? Looper.getMainLooper() : f0.c()));
        this.c = new WeakReference(f0);
    }

    @Override  // d1.g
    public final void c(d1.g.a g$a0) {
        q.b(g$a0 != null, "Callback cannot be null.");
        synchronized(this.a) {
            if(this.g()) {
                g$a0.a(this.h);
            }
            else {
                this.e.add(g$a0);
            }
        }
    }

    @Override  // d1.g
    public final k d(long v, TimeUnit timeUnit0) {
        if(v > 0L) {
            q.h("await must not be called on the UI thread when time is greater than zero.");
        }
        q.l(!this.i, "Result has already been consumed.");
        q.l(true, "Cannot await if then() has been called.");
        try {
            if(!this.d.await(v, timeUnit0)) {
                this.f(Status.m);
            }
        }
        catch(InterruptedException unused_ex) {
            this.f(Status.k);
        }
        q.l(this.g(), "Result is not ready.");
        return this.i();
    }

    protected abstract k e(Status arg1);

    public final void f(Status status0) {
        synchronized(this.a) {
            if(!this.g()) {
                this.h(this.e(status0));
                this.k = true;
            }
        }
    }

    public final boolean g() {
        return this.d.getCount() == 0L;
    }

    public final void h(k k0) {
        synchronized(this.a) {
            if(!this.k && !this.j) {
                this.g();
                q.l(!this.g(), "Results have already been set");
                q.l(!this.i, "Result has already been consumed");
                this.j(k0);
                return;
            }
            BasePendingResult.m(k0);
        }
    }

    private final k i() {
        k k0;
        synchronized(this.a) {
            q.l(!this.i, "Result has already been consumed.");
            q.l(this.g(), "Result is not ready.");
            k0 = this.g;
            this.g = null;
            this.i = true;
        }
        d.a(this.f.getAndSet(null));
        return (k)q.i(k0);
    }

    private final void j(k k0) {
        this.g = k0;
        this.h = k0.g0();
        this.d.countDown();
        if(!this.j && this.g instanceof i) {
            this.resultGuardian = new e0(this, null);
        }
        ArrayList arrayList0 = this.e;
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((d1.g.a)arrayList0.get(v1)).a(this.h);
        }
        this.e.clear();
    }

    public final void l() {
        this.l = this.l || ((Boolean)BasePendingResult.m.get()).booleanValue();
    }

    public static void m(k k0) {
        if(k0 instanceof i) {
            try {
                ((i)k0).e();
            }
            catch(RuntimeException runtimeException0) {
                Log.w("BasePendingResult", "Unable to release " + k0, runtimeException0);
            }
        }
    }
}

