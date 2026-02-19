package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import c1.a;
import c1.i;
import com.google.android.gms.common.api.Status;
import e1.l;
import e1.p;
import g1.g0;
import g1.n;
import g1.r;
import g1.t;
import g1.u;
import g1.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import k.b;
import l1.e;

public class c implements Handler.Callback {
    private long a;
    private boolean b;
    private t c;
    private v d;
    private final Context e;
    private final i f;
    private final g0 g;
    private final AtomicInteger h;
    private final AtomicInteger i;
    private final Map j;
    private h k;
    private final Set l;
    private final Set m;
    private final Handler n;
    private volatile boolean o;
    public static final Status p;
    private static final Status q;
    private static final Object r;
    private static c s;

    static {
        c.p = new Status(4, "Sign-out occurred while this API call was in progress.");
        c.q = new Status(4, "The user must be signed in to make this API call.");
        c.r = new Object();
    }

    private c(Context context0, Looper looper0, i i0) {
        this.a = 10000L;
        this.b = false;
        this.h = new AtomicInteger(1);
        this.i = new AtomicInteger(0);
        this.j = new ConcurrentHashMap(5, 0.75f, 1);
        this.k = null;
        this.l = new b();
        this.m = new b();
        this.o = true;
        this.e = context0;
        a2.h h0 = new a2.h(looper0, this);
        this.n = h0;
        this.f = i0;
        this.g = new g0(i0);
        if(e.a(context0)) {
            this.o = false;
        }
        h0.sendMessage(h0.obtainMessage(6));
    }

    public final void A(d1.e e0, int v, com.google.android.gms.common.api.internal.b b0) {
        e1.v v1 = new e1.v(new com.google.android.gms.common.api.internal.v(v, b0), this.i.get(), e0);
        Message message0 = this.n.obtainMessage(4, v1);
        this.n.sendMessage(message0);
    }

    public final void B(d1.e e0, int v, d d0, g2.i i0, l l0) {
        this.k(i0, d0.d(), e0);
        e1.v v1 = new e1.v(new w(v, d0, i0, l0), this.i.get(), e0);
        Message message0 = this.n.obtainMessage(4, v1);
        this.n.sendMessage(message0);
    }

    final void C(n n0, int v, long v1, int v2) {
        s s0 = new s(n0, v, v1, v2);
        Message message0 = this.n.obtainMessage(18, s0);
        this.n.sendMessage(message0);
    }

    public final void D(a a0, int v) {
        if(!this.f(a0, v)) {
            Message message0 = this.n.obtainMessage(5, v, 0, a0);
            this.n.sendMessage(message0);
        }
    }

    public final void E() {
        Message message0 = this.n.obtainMessage(3);
        this.n.sendMessage(message0);
    }

    public final void F(d1.e e0) {
        Message message0 = this.n.obtainMessage(7, e0);
        this.n.sendMessage(message0);
    }

    public static void a() {
        synchronized(c.r) {
            c c0 = c.s;
            if(c0 != null) {
                c0.i.incrementAndGet();
                Message message0 = c0.n.obtainMessage(10);
                c0.n.sendMessageAtFrontOfQueue(message0);
            }
        }
    }

    public final void b(h h0) {
        synchronized(c.r) {
            if(this.k != h0) {
                this.k = h0;
                this.l.clear();
            }
            this.l.addAll(h0.t());
        }
    }

    final void c(h h0) {
        synchronized(c.r) {
            if(this.k == h0) {
                this.k = null;
                this.l.clear();
            }
        }
    }

    final boolean e() {
        if(this.b) {
            return false;
        }
        g1.s s0 = r.b().a();
        if(s0 != null && !s0.l0()) {
            return false;
        }
        switch(this.g.a(this.e, 203400000)) {
            case -1: 
            case 0: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    final boolean f(a a0, int v) {
        return this.f.v(this.e, a0, v);
    }

    private static Status g(e1.b b0, a a0) {
        return new Status(a0, "API: " + b0.b() + " is not available on this device. Connection failed with: " + a0);
    }

    private final com.google.android.gms.common.api.internal.n h(d1.e e0) {
        e1.b b0 = e0.k();
        com.google.android.gms.common.api.internal.n n0 = (com.google.android.gms.common.api.internal.n)this.j.get(b0);
        if(n0 == null) {
            n0 = new com.google.android.gms.common.api.internal.n(this, e0);
            this.j.put(b0, n0);
        }
        if(n0.b()) {
            this.m.add(b0);
        }
        n0.E();
        return n0;
    }

    @Override  // android.os.Handler$Callback
    public final boolean handleMessage(Message message0) {
        int v = message0.what;
        long v1 = 300000L;
        com.google.android.gms.common.api.internal.n n0 = null;
        switch(v) {
            case 1: {
                if(((Boolean)message0.obj).booleanValue()) {
                    v1 = 10000L;
                }
                this.a = v1;
                this.n.removeMessages(12);
                for(Object object0: this.j.keySet()) {
                    Message message1 = this.n.obtainMessage(12, ((e1.b)object0));
                    this.n.sendMessageDelayed(message1, this.a);
                }
                return true;
            }
            case 2: {
                h.d.a(message0.obj);
                throw null;
            }
            case 3: {
                for(Object object1: this.j.values()) {
                    ((com.google.android.gms.common.api.internal.n)object1).D();
                    ((com.google.android.gms.common.api.internal.n)object1).E();
                }
                return true;
            }
            case 5: {
                int v3 = message0.arg1;
                a a0 = (a)message0.obj;
                for(Object object2: this.j.values()) {
                    com.google.android.gms.common.api.internal.n n2 = (com.google.android.gms.common.api.internal.n)object2;
                    if(n2.s() == v3) {
                        n0 = n2;
                        break;
                    }
                    if(false) {
                        break;
                    }
                }
                if(n0 != null) {
                    if(a0.j0() == 13) {
                        n0.h(new Status(17, "Error resolution was canceled by the user, original error message: " + this.f.d(a0.j0()) + ": " + a0.k0()));
                        return true;
                    }
                    n0.h(c.g(n0.c, a0));
                    return true;
                }
                Log.wtf("GoogleApiManager", "Could not find API instance " + v3 + " while trying to fail enqueued calls.", new Exception());
                return true;
            }
            case 6: {
                if(this.e.getApplicationContext() instanceof Application) {
                    com.google.android.gms.common.api.internal.a.c(((Application)this.e.getApplicationContext()));
                    com.google.android.gms.common.api.internal.a.b().a(new com.google.android.gms.common.api.internal.i(this));
                    if(!com.google.android.gms.common.api.internal.a.b().e(true)) {
                        this.a = 300000L;
                        return true;
                    }
                }
                break;
            }
            case 7: {
                this.h(((d1.e)message0.obj));
                return true;
            }
            case 9: {
                if(this.j.containsKey(message0.obj)) {
                    ((com.google.android.gms.common.api.internal.n)this.j.get(message0.obj)).J();
                    return true;
                }
                break;
            }
            case 10: {
                for(Object object3: this.m) {
                    com.google.android.gms.common.api.internal.n n3 = (com.google.android.gms.common.api.internal.n)this.j.remove(((e1.b)object3));
                    if(n3 != null) {
                        n3.K();
                    }
                }
                this.m.clear();
                return true;
            }
            case 11: {
                if(this.j.containsKey(message0.obj)) {
                    ((com.google.android.gms.common.api.internal.n)this.j.get(message0.obj)).L();
                    return true;
                }
                break;
            }
            case 12: {
                if(this.j.containsKey(message0.obj)) {
                    ((com.google.android.gms.common.api.internal.n)this.j.get(message0.obj)).c();
                    return true;
                }
                break;
            }
            case 4: 
            case 8: 
            case 13: {
                e1.v v2 = (e1.v)message0.obj;
                com.google.android.gms.common.api.internal.n n1 = (com.google.android.gms.common.api.internal.n)this.j.get(v2.c.k());
                if(n1 == null) {
                    n1 = this.h(v2.c);
                }
                if(n1.b() && this.i.get() != v2.b) {
                    v2.a.a(c.p);
                    n1.K();
                    return true;
                }
                n1.F(v2.a);
                return true;
            }
            case 14: {
                h.d.a(message0.obj);
                throw null;
            }
            case 15: {
                o o0 = (o)message0.obj;
                if(this.j.containsKey(o0.a)) {
                    com.google.android.gms.common.api.internal.n.B(((com.google.android.gms.common.api.internal.n)this.j.get(o0.a)), o0);
                    return true;
                }
                break;
            }
            case 16: {
                o o1 = (o)message0.obj;
                if(this.j.containsKey(o1.a)) {
                    com.google.android.gms.common.api.internal.n.C(((com.google.android.gms.common.api.internal.n)this.j.get(o1.a)), o1);
                    return true;
                }
                break;
            }
            case 17: {
                this.j();
                return true;
            }
            case 18: {
                s s0 = (s)message0.obj;
                if(s0.c == 0L) {
                    List list0 = Arrays.asList(new n[]{s0.a});
                    t t0 = new t(s0.b, list0);
                    this.i().a(t0);
                    return true;
                }
                t t1 = this.c;
                if(t1 != null) {
                    List list1 = t1.k0();
                    if(t1.j0() != s0.b || list1 != null && list1.size() >= s0.d) {
                        this.n.removeMessages(17);
                        this.j();
                    }
                    else {
                        this.c.l0(s0.a);
                    }
                }
                if(this.c == null) {
                    ArrayList arrayList0 = new ArrayList();
                    arrayList0.add(s0.a);
                    this.c = new t(s0.b, arrayList0);
                    Message message2 = this.n.obtainMessage(17);
                    this.n.sendMessageDelayed(message2, s0.c);
                    return true;
                }
                break;
            }
            case 19: {
                this.b = false;
                return true;
            }
            default: {
                Log.w("GoogleApiManager", "Unknown message id: " + v);
                return false;
            }
        }
        return true;
    }

    private final v i() {
        if(this.d == null) {
            this.d = u.a(this.e);
        }
        return this.d;
    }

    private final void j() {
        t t0 = this.c;
        if(t0 != null) {
            if(t0.j0() > 0 || this.e()) {
                this.i().a(t0);
            }
            this.c = null;
        }
    }

    private final void k(g2.i i0, int v, d1.e e0) {
        if(v != 0) {
            com.google.android.gms.common.api.internal.r r0 = com.google.android.gms.common.api.internal.r.b(this, v, e0.k());
            if(r0 != null) {
                this.n.getClass();
                i0.a().d(new p(this.n), r0);
            }
        }
    }

    public final int l() {
        return this.h.getAndIncrement();
    }

    final com.google.android.gms.common.api.internal.n t(e1.b b0) {
        return (com.google.android.gms.common.api.internal.n)this.j.get(b0);
    }

    public static c u(Context context0) {
        synchronized(c.r) {
            if(c.s == null) {
                Looper looper0 = g1.i.b().getLooper();
                c.s = new c(context0.getApplicationContext(), looper0, i.l());
            }
            return c.s;
        }
    }

    static void z(c c0, boolean z) {
        c0.b = true;
    }
}

