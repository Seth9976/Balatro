package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import d1.a.f;
import d1.e;
import d1.f.a;
import d1.f.b;
import d1.l;
import e1.u;
import e1.z;
import g1.q;
import g2.i;
import h.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class n implements a, b {
    private final Queue a;
    private final f b;
    private final e1.b c;
    private final g d;
    private final Set e;
    private final Map f;
    private final int g;
    private final z h;
    private boolean i;
    private final List j;
    private c1.a k;
    private int l;
    final c m;

    public n(c c0, e e0) {
        this.m = c0;
        super();
        this.a = new LinkedList();
        this.e = new HashSet();
        this.f = new HashMap();
        this.j = new ArrayList();
        this.k = null;
        this.l = 0;
        f a$f0 = e0.q(c0.n.getLooper(), this);
        this.b = a$f0;
        this.c = e0.k();
        this.d = new g();
        this.g = e0.p();
        if(a$f0.k()) {
            this.h = e0.r(c0.e, c0.n);
            return;
        }
        this.h = null;
    }

    static void B(n n0, o o0) {
        if(n0.j.contains(o0) && !n0.i) {
            if(!n0.b.c()) {
                n0.E();
                return;
            }
            n0.j();
        }
    }

    static void C(n n0, o o0) {
        if(n0.j.remove(o0)) {
            n0.m.n.removeMessages(15, o0);
            n0.m.n.removeMessages(16, o0);
            c1.c c0 = o0.b;
            ArrayList arrayList0 = new ArrayList(n0.a.size());
            for(Object object0: n0.a) {
                y y0 = (y)object0;
                if(y0 instanceof u) {
                    c1.c[] arr_c = ((u)y0).g(n0);
                    if(arr_c != null && l1.a.b(arr_c, c0)) {
                        arrayList0.add(y0);
                    }
                }
            }
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                y y1 = (y)arrayList0.get(v1);
                n0.a.remove(y1);
                y1.b(new l(c0));
            }
        }
    }

    public final void D() {
        q.d(this.m.n);
        this.k = null;
    }

    public final void E() {
        c1.a a1;
        q.d(this.m.n);
        if(!this.b.c() && !this.b.a()) {
            try {
                int v = this.m.g.b(this.m.e, this.b);
                if(v != 0) {
                    c1.a a0 = new c1.a(v, null);
                    Log.w("GoogleApiManager", "The service for " + this.b.getClass().getName() + " is not available: " + a0.toString());
                    this.H(a0, null);
                    return;
                }
            }
            catch(IllegalStateException illegalStateException0) {
                a1 = new c1.a(10);
                this.H(a1, illegalStateException0);
                return;
            }
            com.google.android.gms.common.api.internal.q q0 = new com.google.android.gms.common.api.internal.q(this.m, this.b, this.c);
            if(this.b.k()) {
                ((z)q.i(this.h)).Z(q0);
            }
            try {
                this.b.n(q0);
                return;
            }
            catch(SecurityException illegalStateException0) {
                a1 = new c1.a(10);
            }
            this.H(a1, illegalStateException0);
        }
    }

    public final void F(y y0) {
        q.d(this.m.n);
        if(this.b.c()) {
            if(this.p(y0)) {
                this.m();
                return;
            }
            this.a.add(y0);
            return;
        }
        this.a.add(y0);
        if(this.k != null && this.k.m0()) {
            this.H(this.k, null);
            return;
        }
        this.E();
    }

    final void G() {
        ++this.l;
    }

    public final void H(c1.a a0, Exception exception0) {
        q.d(this.m.n);
        z z0 = this.h;
        if(z0 != null) {
            z0.a0();
        }
        this.D();
        this.m.g.c();
        this.g(a0);
        if(this.b instanceof i1.e && a0.j0() != 24) {
            c.z(this.m, true);
            Message message0 = this.m.n.obtainMessage(19);
            this.m.n.sendMessageDelayed(message0, 300000L);
        }
        if(a0.j0() == 4) {
            this.h(c.q);
            return;
        }
        if(this.a.isEmpty()) {
            this.k = a0;
            return;
        }
        if(exception0 != null) {
            q.d(this.m.n);
            this.i(null, exception0, false);
            return;
        }
        if(this.m.o) {
            this.i(c.g(this.c, a0), null, true);
            if(!this.a.isEmpty() && !this.q(a0) && !this.m.f(a0, this.g)) {
                if(a0.j0() == 18) {
                    this.i = true;
                }
                if(this.i) {
                    Message message1 = Message.obtain(this.m.n, 9, this.c);
                    this.m.n.sendMessageDelayed(message1, 5000L);
                    return;
                }
                this.h(c.g(this.c, a0));
            }
            return;
        }
        this.h(c.g(this.c, a0));
    }

    public final void I(c1.a a0) {
        q.d(this.m.n);
        String s = this.b.getClass().getName();
        this.b.j("onSignInFailed for " + s + " with " + a0);
        this.H(a0, null);
    }

    public final void J() {
        q.d(this.m.n);
        if(this.i) {
            this.E();
        }
    }

    public final void K() {
        q.d(this.m.n);
        this.h(c.p);
        this.d.f();
        e1.g[] arr_g = (e1.g[])this.f.keySet().toArray(new e1.g[0]);
        for(int v = 0; v < arr_g.length; ++v) {
            e1.g g0 = arr_g[v];
            this.F(new x(null, new i()));
        }
        this.g(new c1.a(4));
        if(this.b.c()) {
            m m0 = new m(this);
            this.b.h(m0);
        }
    }

    public final void L() {
        q.d(this.m.n);
        if(this.i) {
            this.o();
            this.h((this.m.f.f(this.m.e) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error.")));
            this.b.j("Timing out connection while resuming.");
        }
    }

    @Override  // e1.d
    public final void a(int v) {
        if(Looper.myLooper() == this.m.n.getLooper()) {
            this.l(v);
            return;
        }
        k k0 = new k(this, v);
        this.m.n.post(k0);
    }

    public final boolean b() {
        return this.b.k();
    }

    public final boolean c() {
        return this.r(true);
    }

    @Override  // e1.i
    public final void d(c1.a a0) {
        this.H(a0, null);
    }

    private final c1.c e(c1.c[] arr_c) {
        if(arr_c != null && arr_c.length != 0) {
            c1.c[] arr_c1 = this.b.b();
            int v = 0;
            if(arr_c1 == null) {
                arr_c1 = new c1.c[0];
            }
            k.a a0 = new k.a(arr_c1.length);
            for(int v1 = 0; v1 < arr_c1.length; ++v1) {
                c1.c c0 = arr_c1[v1];
                a0.put(c0.j0(), c0.k0());
            }
            while(v < arr_c.length) {
                c1.c c1 = arr_c[v];
                Long long0 = (Long)a0.get(c1.j0());
                if(long0 != null && ((long)long0) >= c1.k0()) {
                    ++v;
                    continue;
                }
                return c1;
            }
        }
        return null;
    }

    @Override  // e1.d
    public final void f(Bundle bundle0) {
        if(Looper.myLooper() == this.m.n.getLooper()) {
            this.k();
            return;
        }
        j j0 = new j(this);
        this.m.n.post(j0);
    }

    private final void g(c1.a a0) {
        Iterator iterator0 = this.e.iterator();
        if(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            d.a(object0);
            if(g1.o.a(a0, c1.a.i)) {
                this.b.d();
            }
            throw null;
        }
        this.e.clear();
    }

    private final void h(Status status0) {
        q.d(this.m.n);
        this.i(status0, null, false);
    }

    private final void i(Status status0, Exception exception0, boolean z) {
        q.d(this.m.n);
        if((status0 == null ? 1 : 0) == (exception0 == null ? 1 : 0)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator iterator0 = this.a.iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            y y0 = (y)object0;
            if(!z || y0.a == 2) {
                if(status0 == null) {
                    y0.b(exception0);
                }
                else {
                    y0.a(status0);
                }
                iterator0.remove();
            }
        }
    }

    private final void j() {
        ArrayList arrayList0 = new ArrayList(this.a);
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            y y0 = (y)arrayList0.get(v1);
            if(!this.b.c()) {
                break;
            }
            if(this.p(y0)) {
                this.a.remove(y0);
            }
        }
    }

    private final void k() {
        this.D();
        this.g(c1.a.i);
        this.o();
        Iterator iterator0 = this.f.values().iterator();
        if(!iterator0.hasNext()) {
            this.j();
            this.m();
            return;
        }
        Object object0 = iterator0.next();
        d.a(object0);
        throw null;
    }

    private final void l(int v) {
        this.D();
        this.i = true;
        String s = this.b.e();
        this.d.e(v, s);
        Message message0 = Message.obtain(this.m.n, 9, this.c);
        this.m.n.sendMessageDelayed(message0, 5000L);
        Message message1 = Message.obtain(this.m.n, 11, this.c);
        this.m.n.sendMessageDelayed(message1, 120000L);
        this.m.g.c();
        Iterator iterator0 = this.f.values().iterator();
        if(!iterator0.hasNext()) {
            return;
        }
        Object object0 = iterator0.next();
        d.a(object0);
        throw null;
    }

    private final void m() {
        this.m.n.removeMessages(12, this.c);
        Message message0 = this.m.n.obtainMessage(12, this.c);
        long v = this.m.a;
        this.m.n.sendMessageDelayed(message0, v);
    }

    private final void n(y y0) {
        boolean z = this.b();
        y0.d(this.d, z);
        try {
            y0.c(this);
        }
        catch(DeadObjectException unused_ex) {
            this.a(1);
            this.b.j("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void o() {
        if(this.i) {
            this.m.n.removeMessages(11, this.c);
            this.m.n.removeMessages(9, this.c);
            this.i = false;
        }
    }

    private final boolean p(y y0) {
        if(!(y0 instanceof u)) {
            this.n(y0);
            return true;
        }
        c1.c c0 = this.e(((u)y0).g(this));
        if(c0 == null) {
            this.n(y0);
            return true;
        }
        Log.w("GoogleApiManager", this.b.getClass().getName() + " could not execute call because it requires feature (" + c0.j0() + ", " + c0.k0() + ").");
        if(this.m.o && ((u)y0).f(this)) {
            o o0 = new o(this.c, c0, null);
            int v = this.j.indexOf(o0);
            if(v >= 0) {
                o o1 = (o)this.j.get(v);
                this.m.n.removeMessages(15, o1);
                Message message0 = Message.obtain(this.m.n, 15, o1);
                this.m.n.sendMessageDelayed(message0, 5000L);
                return false;
            }
            this.j.add(o0);
            Message message1 = Message.obtain(this.m.n, 15, o0);
            this.m.n.sendMessageDelayed(message1, 5000L);
            Message message2 = Message.obtain(this.m.n, 16, o0);
            this.m.n.sendMessageDelayed(message2, 120000L);
            c1.a a0 = new c1.a(2, null);
            if(!this.q(a0)) {
                this.m.f(a0, this.g);
            }
            return false;
        }
        ((u)y0).b(new l(c0));
        return true;
    }

    private final boolean q(c1.a a0) {
        synchronized(c.r) {
            if(this.m.k != null && this.m.l.contains(this.c)) {
                this.m.k.s(a0, this.g);
                return true;
            }
            return false;
        }
    }

    private final boolean r(boolean z) {
        q.d(this.m.n);
        if(this.b.c() && this.f.isEmpty()) {
            if(!this.d.g()) {
                this.b.j("Timing out service connection.");
                return true;
            }
            else if(z) {
                this.m();
                return false;
            }
        }
        return false;
    }

    public final int s() {
        return this.g;
    }

    final int t() {
        return this.l;
    }

    public final f v() {
        return this.b;
    }

    public final Map x() {
        return this.f;
    }
}

