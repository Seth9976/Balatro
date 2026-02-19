package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class o {
    private final AtomicReferenceArray a;
    private static final AtomicReferenceFieldUpdater b;
    private volatile int blockingTasksInBuffer;
    private static final AtomicIntegerFieldUpdater c;
    private volatile int consumerIndex;
    private static final AtomicIntegerFieldUpdater d;
    private static final AtomicIntegerFieldUpdater e;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    static {
        o.b = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "lastScheduledTask");
        o.c = AtomicIntegerFieldUpdater.newUpdater(o.class, "producerIndex");
        o.d = AtomicIntegerFieldUpdater.newUpdater(o.class, "consumerIndex");
        o.e = AtomicIntegerFieldUpdater.newUpdater(o.class, "blockingTasksInBuffer");
    }

    public o() {
        this.a = new AtomicReferenceArray(0x80);
        this.lastScheduledTask = null;
        this.producerIndex = 0;
        this.consumerIndex = 0;
        this.blockingTasksInBuffer = 0;
    }

    public final h a(h h0, boolean z) {
        if(z) {
            return this.c(h0);
        }
        h h1 = (h)o.b.getAndSet(this, h0);
        return h1 == null ? null : this.c(h1);
    }

    public static h b(o o0, h h0, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        return o0.a(h0, z);
    }

    private final h c(h h0) {
        if(h0.f.a() == 1) {
            o.e.incrementAndGet(this);
        }
        if(this.e() == 0x7F) {
            return h0;
        }
        int v = this.producerIndex & 0x7F;
        while(this.a.get(v) != null) {
            Thread.yield();
        }
        this.a.lazySet(v, h0);
        o.c.incrementAndGet(this);
        return null;
    }

    private final void d(h h0) {
        if(h0 != null && h0.f.a() == 1) {
            o.e.decrementAndGet(this);
        }
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask == null ? this.e() : this.e() + 1;
    }

    public final void g(d d0) {
        h h0 = (h)o.b.getAndSet(this, null);
        if(h0 != null) {
            d0.a(h0);
        }
        while(this.j(d0)) {
        }
    }

    public final h h() {
        h h0 = (h)o.b.getAndSet(this, null);
        return h0 == null ? this.i() : h0;
    }

    private final h i() {
        h h0;
        int v;
        do {
            do {
                v = this.consumerIndex;
                if(v - this.producerIndex == 0) {
                    return null;
                }
            }
            while(!o.d.compareAndSet(this, v, v + 1));
            h0 = (h)this.a.getAndSet(v & 0x7F, null);
        }
        while(h0 == null);
        this.d(h0);
        return h0;
    }

    private final boolean j(d d0) {
        h h0 = this.i();
        if(h0 == null) {
            return false;
        }
        d0.a(h0);
        return true;
    }

    public final long k(o o0) {
        int v = o0.consumerIndex;
        int v1 = o0.producerIndex;
        AtomicReferenceArray atomicReferenceArray0 = o0.a;
        while(v != v1 && o0.blockingTasksInBuffer != 0) {
            h h0 = (h)atomicReferenceArray0.get(v & 0x7F);
            if(h0 != null && h0.f.a() == 1 && n.a(atomicReferenceArray0, v & 0x7F, h0, null)) {
                o.e.decrementAndGet(o0);
                o.b(this, h0, false, 2, null);
                return -1L;
            }
            ++v;
        }
        return this.m(o0, true);
    }

    public final long l(o o0) {
        h h0 = o0.i();
        if(h0 != null) {
            o.b(this, h0, false, 2, null);
            return -1L;
        }
        return this.m(o0, false);
    }

    private final long m(o o0, boolean z) {
        h h0;
        do {
            h0 = (h)o0.lastScheduledTask;
            if(h0 == null) {
                return -2L;
            }
            if(z && h0.f.a() != 1) {
                return -2L;
            }
            long v = l.e.a() - h0.e;
            long v1 = l.a;
            if(v < v1) {
                return v1 - v;
            }
        }
        while(!r3.n.a(o.b, o0, h0, null));
        o.b(this, h0, false, 2, null);
        return -1L;
    }
}

