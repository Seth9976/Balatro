package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import k3.d;
import k3.f;
import r3.g;
import t3.k;
import t3.l;

public final class a implements Closeable, Executor {
    public static final class kotlinx.coroutines.scheduling.a.a {
        private kotlinx.coroutines.scheduling.a.a() {
        }

        public kotlinx.coroutines.scheduling.a.a(d d0) {
        }
    }

    public abstract class b {
        public static final int[] a;

        static {
            int[] arr_v = new int[kotlinx.coroutines.scheduling.a.d.values().length];
            arr_v[kotlinx.coroutines.scheduling.a.d.g.ordinal()] = 1;
            arr_v[kotlinx.coroutines.scheduling.a.d.f.ordinal()] = 2;
            arr_v[kotlinx.coroutines.scheduling.a.d.e.ordinal()] = 3;
            arr_v[kotlinx.coroutines.scheduling.a.d.h.ordinal()] = 4;
            arr_v[kotlinx.coroutines.scheduling.a.d.i.ordinal()] = 5;
            b.a = arr_v;
        }
    }

    public final class c extends Thread {
        public final o e;
        public kotlinx.coroutines.scheduling.a.d f;
        private long g;
        private long h;
        private int i;
        private volatile int indexInArray;
        public boolean j;
        final a k;
        static final AtomicIntegerFieldUpdater l;
        private volatile Object nextParkedWorker;
        volatile int workerCtl;

        static {
            c.l = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");
        }

        private c() {
            this.setDaemon(true);
            this.e = new o();
            this.f = kotlinx.coroutines.scheduling.a.d.h;
            this.workerCtl = 0;
            this.nextParkedWorker = a.p;
            this.i = l3.c.e.b();
        }

        public c(int v) {
            this.o(v);
        }

        private final void b(int v) {
            if(v == 0) {
                return;
            }
            a.n.addAndGet(a.this, 0xFFFFFFFFFFE00000L);
            if(this.f != kotlinx.coroutines.scheduling.a.d.i) {
                this.f = kotlinx.coroutines.scheduling.a.d.h;
            }
        }

        private final void c(int v) {
            if(v == 0) {
                return;
            }
            if(this.s(kotlinx.coroutines.scheduling.a.d.f)) {
                a.this.p();
            }
        }

        private final void d(h h0) {
            int v = h0.f.a();
            this.i(v);
            this.c(v);
            a.this.l(h0);
            this.b(v);
        }

        private final h e(boolean z) {
            if(z) {
                boolean z1 = this.k(a.this.e * 2) == 0;
                if(z1) {
                    h h0 = this.m();
                    if(h0 != null) {
                        return h0;
                    }
                }
                h h1 = this.e.h();
                if(h1 == null) {
                    if(!z1) {
                        h h2 = this.m();
                        return h2 == null ? this.t(false) : h2;
                    }
                    return this.t(false);
                }
                return h1;
            }
            h h3 = this.m();
            return h3 == null ? this.t(false) : h3;
        }

        public final h f(boolean z) {
            h h0;
            if(this.q()) {
                return this.e(z);
            }
            if(z) {
                h0 = this.e.h();
                if(h0 == null) {
                    h0 = (h)a.this.j.d();
                    return h0 == null ? this.t(true) : h0;
                }
            }
            else {
                h0 = (h)a.this.j.d();
            }
            return h0 == null ? this.t(true) : h0;
        }

        public final int g() {
            return this.indexInArray;
        }

        public final Object h() {
            return this.nextParkedWorker;
        }

        private final void i(int v) {
            this.g = 0L;
            if(this.f == kotlinx.coroutines.scheduling.a.d.g) {
                this.f = kotlinx.coroutines.scheduling.a.d.f;
            }
        }

        private final boolean j() {
            return this.nextParkedWorker != a.p;
        }

        public final int k(int v) {
            int v1 = this.i ^ this.i << 13;
            int v2 = v1 ^ v1 >> 17;
            int v3 = v2 ^ v2 << 5;
            this.i = v3;
            return (v - 1 & v) == 0 ? v3 & v - 1 : (v3 & 0x7FFFFFFF) % v;
        }

        private final void l() {
            if(this.g == 0L) {
                this.g = System.nanoTime() + a.this.g;
            }
            LockSupport.parkNanos(a.this.g);
            if(System.nanoTime() - this.g >= 0L) {
                this.g = 0L;
                this.u();
            }
        }

        private final h m() {
            if(this.k(2) == 0) {
                h h0 = (h)a.this.i.d();
                return h0 == null ? ((h)a.this.j.d()) : h0;
            }
            h h1 = (h)a.this.j.d();
            return h1 == null ? ((h)a.this.i.d()) : h1;
        }

        private final void n() {
        alab1:
            while(true) {
                boolean z = false;
                while(true) {
                    if(a.this.g() || this.f == kotlinx.coroutines.scheduling.a.d.i) {
                        break alab1;
                    }
                    h h0 = this.f(this.j);
                    if(h0 != null) {
                        this.h = 0L;
                        this.d(h0);
                        break;
                    }
                    this.j = false;
                    if(this.h == 0L) {
                        this.r();
                    }
                    else {
                        if(z) {
                            this.s(kotlinx.coroutines.scheduling.a.d.g);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.h);
                            this.h = 0L;
                            break;
                        }
                        z = true;
                    }
                }
            }
            this.s(kotlinx.coroutines.scheduling.a.d.i);
        }

        public final void o(int v) {
            this.setName(a.this.h + "-worker-" + (v == 0 ? "TERMINATED" : String.valueOf(v)));
            this.indexInArray = v;
        }

        public final void p(Object object0) {
            this.nextParkedWorker = object0;
        }

        private final boolean q() {
            boolean z;
            if(this.f != kotlinx.coroutines.scheduling.a.d.e) {
                a a0 = a.this;
                while(true) {
                    long v = a0.controlState;
                    if(((int)((0x7FFFFC0000000000L & v) >> 42)) == 0) {
                        z = false;
                        break;
                    }
                    if(a.n.compareAndSet(a0, v, v - 0x40000000000L)) {
                        z = true;
                        break;
                    }
                }
                if(z) {
                    this.f = kotlinx.coroutines.scheduling.a.d.e;
                    return true;
                }
                return false;
            }
            return true;
        }

        private final void r() {
            if(!this.j()) {
                a.this.j(this);
                return;
            }
            this.workerCtl = -1;
            while(this.j() && this.workerCtl == -1 && !a.this.g() && this.f != kotlinx.coroutines.scheduling.a.d.i) {
                this.s(kotlinx.coroutines.scheduling.a.d.g);
                Thread.interrupted();
                this.l();
            }
        }

        @Override
        public void run() {
            this.n();
        }

        public final boolean s(kotlinx.coroutines.scheduling.a.d a$d0) {
            kotlinx.coroutines.scheduling.a.d a$d1 = this.f;
            boolean z = a$d1 == kotlinx.coroutines.scheduling.a.d.e;
            if(z) {
                a.n.addAndGet(a.this, 0x40000000000L);
            }
            if(a$d1 != a$d0) {
                this.f = a$d0;
            }
            return z;
        }

        private final h t(boolean z) {
            int v = (int)(a.this.controlState & 0x1FFFFFL);
            if(v < 2) {
                return null;
            }
            int v1 = this.k(v);
            a a0 = a.this;
            int v2 = 0;
            long v3 = 0x7FFFFFFFFFFFFFFFL;
            while(v2 < v) {
                ++v2;
                ++v1;
                v1 = v1 <= v ? v1 + 1 : 1;
                c a$c0 = (c)a0.k.b(v1);
                if(a$c0 != null && a$c0 != this) {
                    long v4 = z ? this.e.k(a$c0.e) : this.e.l(a$c0.e);
                    if(v4 == -1L) {
                        return this.e.h();
                    }
                    if(v4 > 0L) {
                        v3 = Math.min(v3, v4);
                    }
                }
            }
            if(v3 == 0x7FFFFFFFFFFFFFFFL) {
                v3 = 0L;
            }
            this.h = v3;
            return null;
        }

        private final void u() {
            a a0 = a.this;
            synchronized(a0.k) {
                if(a0.g()) {
                    return;
                }
                if(((int)(a0.controlState & 0x1FFFFFL)) <= a0.e) {
                    return;
                }
                if(!c.l.compareAndSet(this, -1, 1)) {
                    return;
                }
                int v1 = this.g();
                this.o(0);
                a0.k(this, v1, 0);
                long v2 = a.n.getAndDecrement(a0);
                if(((int)(v2 & 0x1FFFFFL)) != v1) {
                    Object object0 = a0.k.b(((int)(v2 & 0x1FFFFFL)));
                    f.b(object0);
                    a0.k.c(v1, ((c)object0));
                    ((c)object0).o(v1);
                    a0.k(((c)object0), ((int)(v2 & 0x1FFFFFL)), v1);
                }
                a0.k.c(((int)(v2 & 0x1FFFFFL)), null);
            }
            this.f = kotlinx.coroutines.scheduling.a.d.i;
        }
    }

    public static enum kotlinx.coroutines.scheduling.a.d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED;

        private static final kotlinx.coroutines.scheduling.a.d[] c() [...] // Inlined contents
    }

    private volatile int _isTerminated;
    volatile long controlState;
    public final int e;
    public final int f;
    public final long g;
    public final String h;
    public final kotlinx.coroutines.scheduling.d i;
    public final kotlinx.coroutines.scheduling.d j;
    public final k k;
    public static final kotlinx.coroutines.scheduling.a.a l;
    private static final AtomicLongFieldUpdater m;
    static final AtomicLongFieldUpdater n;
    private static final AtomicIntegerFieldUpdater o;
    public static final l p;
    private volatile long parkedWorkersStack;

    static {
        a.l = new kotlinx.coroutines.scheduling.a.a(null);
        a.p = new l("NOT_IN_STACK");
        a.m = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
        a.n = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
        a.o = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");
    }

    public a(int v, int v1, long v2, String s) {
        this.e = v;
        this.f = v1;
        this.g = v2;
        this.h = s;
        if(v < 1) {
            throw new IllegalArgumentException(("Core pool size " + v + " should be at least 1").toString());
        }
        if(v1 < v) {
            throw new IllegalArgumentException(("Max pool size " + v1 + " should be greater than or equals to core pool size " + v).toString());
        }
        if(v1 > 0x1FFFFE) {
            throw new IllegalArgumentException(("Max pool size " + v1 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if(v2 <= 0L) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + v2 + " must be positive").toString());
        }
        this.i = new kotlinx.coroutines.scheduling.d();
        this.j = new kotlinx.coroutines.scheduling.d();
        this.parkedWorkersStack = 0L;
        this.k = new k(v + 1);
        this.controlState = ((long)v) << 42;
        this._isTerminated = 0;
    }

    private final boolean a(h h0) {
        return h0.f.a() == 1 ? this.j.a(h0) : this.i.a(h0);
    }

    private final int b() {
        synchronized(this.k) {
            if(this.g()) {
                return -1;
            }
            int v1 = (int)(this.controlState & 0x1FFFFFL);
            int v2 = n3.f.a(v1 - ((int)((this.controlState & 0x3FFFFE00000L) >> 21)), 0);
            if(v2 >= this.e) {
                return 0;
            }
            if(v1 >= this.f) {
                return 0;
            }
            int v3 = ((int)(this.controlState & 0x1FFFFFL)) + 1;
            if(v3 > 0 && this.k.b(v3) == null) {
                c a$c0 = new c(this, v3);
                this.k.c(v3, a$c0);
                if(v3 != ((int)(0x1FFFFFL & a.n.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                a$c0.start();
                return v2 + 1;
            }
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public final h c(Runnable runnable0, i i0) {
        long v = kotlinx.coroutines.scheduling.l.e.a();
        if(runnable0 instanceof h) {
            ((h)runnable0).e = v;
            ((h)runnable0).f = i0;
            return (h)runnable0;
        }
        return new kotlinx.coroutines.scheduling.k(runnable0, v, i0);
    }

    @Override
    public void close() {
        this.m(10000L);
    }

    private final c d() {
        Thread thread0 = Thread.currentThread();
        c a$c0 = thread0 instanceof c ? ((c)thread0) : null;
        return a$c0 == null || !f.a(a.this, this) ? null : a$c0;
    }

    public final void e(Runnable runnable0, i i0, boolean z) {
        h h0 = this.c(runnable0, i0);
        c a$c0 = this.d();
        h h1 = this.q(a$c0, h0, z);
        if(h1 != null && !this.a(h1)) {
            throw new RejectedExecutionException(this.h + " was terminated");
        }
        boolean z1 = z && a$c0 != null;
        if(h0.f.a() == 0) {
            if(z1) {
                return;
            }
            this.p();
            return;
        }
        this.n(z1);
    }

    @Override
    public void execute(Runnable runnable0) {
        a.f(this, runnable0, null, false, 6, null);
    }

    public static void f(a a0, Runnable runnable0, i i0, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            i0 = kotlinx.coroutines.scheduling.l.f;
        }
        if((v & 4) != 0) {
            z = false;
        }
        a0.e(runnable0, i0, z);
    }

    public final boolean g() {
        return this._isTerminated;
    }

    private final int h(c a$c0) {
        int v;
        do {
            Object object0 = a$c0.h();
            if(object0 == a.p) {
                return -1;
            }
            if(object0 == null) {
                return 0;
            }
            a$c0 = (c)object0;
            v = a$c0.g();
        }
        while(v == 0);
        return v;
    }

    private final c i() {
        c a$c0;
        do {
            long v = this.parkedWorkersStack;
            a$c0 = (c)this.k.b(((int)(0x1FFFFFL & v)));
            if(a$c0 == null) {
                return null;
            }
            int v1 = this.h(a$c0);
        }
        while(v1 < 0 || !a.m.compareAndSet(this, v, ((long)v1) | v + 0x200000L & 0xFFFFFFFFFFE00000L));
        a$c0.p(a.p);
        return a$c0;
    }

    public final boolean j(c a$c0) {
        if(a$c0.h() != a.p) {
            return false;
        }
        do {
            long v = this.parkedWorkersStack;
            a$c0.p(this.k.b(((int)(0x1FFFFFL & v))));
        }
        while(!a.m.compareAndSet(this, v, v + 0x200000L & 0xFFFFFFFFFFE00000L | ((long)a$c0.g())));
        return true;
    }

    public final void k(c a$c0, int v, int v1) {
        do {
            long v2 = this.parkedWorkersStack;
            int v3 = (int)(0x1FFFFFL & v2);
            if(v3 == v) {
                v3 = v1 == 0 ? this.h(a$c0) : v1;
            }
        }
        while(v3 < 0 || !a.m.compareAndSet(this, v2, v2 + 0x200000L & 0xFFFFFFFFFFE00000L | ((long)v3)));
    }

    public final void l(h h0) {
        try {
            h0.run();
        }
        catch(Throwable throwable0) {
            Thread thread0 = Thread.currentThread();
            thread0.getUncaughtExceptionHandler().uncaughtException(thread0, throwable0);
        }
    }

    public final void m(long v) {
        if(!a.o.compareAndSet(this, 0, 1)) {
            return;
        }
        c a$c0 = this.d();
        synchronized(this.k) {
            int v1 = (int)(this.controlState & 0x1FFFFFL);
        }
        if(1 <= v1) {
            for(int v2 = 1; true; ++v2) {
                Object object0 = this.k.b(v2);
                f.b(object0);
                c a$c1 = (c)object0;
                if(a$c1 != a$c0) {
                    while(a$c1.isAlive()) {
                        LockSupport.unpark(a$c1);
                        a$c1.join(v);
                    }
                    a$c1.e.g(this.j);
                }
                if(v2 == v1) {
                    break;
                }
            }
        }
        this.j.b();
        this.i.b();
        while(true) {
            h h0 = a$c0 == null ? null : a$c0.f(true);
            if(h0 == null) {
                h h1 = (h)this.i.d();
                if(h1 == null) {
                    h0 = (h)this.j.d();
                    if(h0 != null) {
                        goto label_30;
                    }
                    break;
                }
                else {
                    h0 = h1;
                }
            }
        label_30:
            this.l(h0);
        }
        if(a$c0 != null) {
            a$c0.s(kotlinx.coroutines.scheduling.a.d.i);
        }
        this.parkedWorkersStack = 0L;
        this.controlState = 0L;
    }

    private final void n(boolean z) {
        long v = a.n.addAndGet(this, 0x200000L);
        if(z) {
            return;
        }
        if(this.u()) {
            return;
        }
        if(this.r(v)) {
            return;
        }
        this.u();
    }

    public final void p() {
        if(this.u()) {
            return;
        }
        if(a.t(this, 0L, 1, null)) {
            return;
        }
        this.u();
    }

    private final h q(c a$c0, h h0, boolean z) {
        if(a$c0 == null) {
            return h0;
        }
        if(a$c0.f == kotlinx.coroutines.scheduling.a.d.i) {
            return h0;
        }
        if(h0.f.a() == 0 && a$c0.f == kotlinx.coroutines.scheduling.a.d.f) {
            return h0;
        }
        a$c0.j = true;
        return a$c0.e.a(h0, z);
    }

    private final boolean r(long v) {
        if(n3.f.a(((int)(0x1FFFFFL & v)) - ((int)((v & 0x3FFFFE00000L) >> 21)), 0) < this.e) {
            int v1 = this.b();
            if(v1 == 1 && this.e > 1) {
                this.b();
            }
            return v1 > 0;
        }
        return false;
    }

    static boolean t(a a0, long v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = a0.controlState;
        }
        return a0.r(v);
    }

    @Override
    public String toString() {
        ArrayList arrayList0 = new ArrayList();
        int v = this.k.a();
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        for(int v6 = 1; v6 < v; ++v6) {
            c a$c0 = (c)this.k.b(v6);
            if(a$c0 != null) {
                int v7 = a$c0.e.f();
                switch(a$c0.f) {
                    case 1: {
                        ++v3;
                        break;
                    }
                    case 2: {
                        ++v2;
                        arrayList0.add(v7 + 'b');
                        break;
                    }
                    case 3: {
                        ++v1;
                        arrayList0.add(v7 + 'c');
                        break;
                    }
                    case 4: {
                        ++v4;
                        if(v7 > 0) {
                            arrayList0.add(v7 + 'd');
                        }
                        break;
                    }
                    case 5: {
                        ++v5;
                    }
                }
            }
        }
        return this.h + '@' + g.b(this) + "[Pool Size {core = " + this.e + ", max = " + this.f + "}, Worker States {CPU = " + v1 + ", blocking = " + v2 + ", parked = " + v3 + ", dormant = " + v4 + ", terminated = " + v5 + "}, running workers queues = " + arrayList0 + ", global CPU queue size = " + this.i.c() + ", global blocking queue size = " + this.j.c() + ", Control State {created workers= " + ((int)(0x1FFFFFL & this.controlState)) + ", blocking tasks = " + ((int)((0x3FFFFE00000L & this.controlState) >> 21)) + ", CPUs acquired = " + (this.e - ((int)((0x7FFFFC0000000000L & this.controlState) >> 42))) + "}]";
    }

    private final boolean u() {
        c a$c0;
        do {
            a$c0 = this.i();
            if(a$c0 == null) {
                return false;
            }
        }
        while(!c.l.compareAndSet(a$c0, -1, 0));
        LockSupport.unpark(a$c0);
        return true;
    }
}

