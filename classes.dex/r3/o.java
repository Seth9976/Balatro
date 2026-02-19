package r3;

import d3.e;
import h.d;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import t3.f;

public abstract class o extends p implements j {
    private volatile Object _delayed;
    private volatile int _isCompleted;
    private volatile Object _queue;
    private static final AtomicReferenceFieldUpdater h;
    private static final AtomicReferenceFieldUpdater i;

    static {
        o.h = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_queue");
        o.i = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_delayed");
    }

    public o() {
        this._queue = null;
        this._delayed = null;
        this._isCompleted = 0;
    }

    @Override  // r3.c
    public final void a(e e0, Runnable runnable0) {
        this.m(runnable0);
    }

    @Override  // r3.m
    protected long e() {
        if(super.e() == 0L) {
            return 0L;
        }
        Object object0 = this._queue;
        if(object0 != null) {
            if(!(object0 instanceof f)) {
                return object0 == q.b ? 0x7FFFFFFFFFFFFFFFL : 0L;
            }
            else if(!((f)object0).g()) {
                return 0L;
            }
        }
        d.a(this._delayed);
        return 0x7FFFFFFFFFFFFFFFL;
    }

    private final Runnable l() {
        Object object0;
        while(true) {
            object0 = this._queue;
            if(object0 == null) {
                return null;
            }
            if(object0 instanceof f) {
                Object object1 = ((f)object0).j();
                if(object1 != f.h) {
                    return (Runnable)object1;
                }
                f f0 = ((f)object0).i();
                n.a(o.h, this, object0, f0);
            }
            else {
                if(object0 == q.b) {
                    return null;
                }
                if(n.a(o.h, this, object0, null)) {
                    break;
                }
            }
        }
        return (Runnable)object0;
    }

    public void m(Runnable runnable0) {
        if(this.n(runnable0)) {
            this.k();
            return;
        }
        h.j.m(runnable0);
    }

    private final boolean n(Runnable runnable0) {
        Object object0;
        while(true) {
        alab1:
            while(true) {
                while(true) {
                label_0:
                    object0 = this._queue;
                    if(this.p()) {
                        return false;
                    }
                    if(object0 != null) {
                        break;
                    }
                    if(n.a(o.h, this, null, runnable0)) {
                        return true;
                    }
                }
                if(!(object0 instanceof f)) {
                    goto label_17;
                }
                int v = ((f)object0).a(runnable0);
                switch(v) {
                    case 0: {
                        return true;
                    label_12:
                        if(v != 2) {
                            break;
                        }
                        break alab1;
                    }
                    case 1: {
                        goto label_14;
                    }
                    default: {
                        goto label_12;
                    }
                }
            }
            return false;
        label_14:
            f f0 = ((f)object0).i();
            n.a(o.h, this, object0, f0);
            goto label_0;
        label_17:
            if(object0 == q.b) {
                return false;
            }
            f f1 = new f(8, true);
            f1.a(((Runnable)object0));
            f1.a(runnable0);
            if(!n.a(o.h, this, object0, f1)) {
                goto label_0;
            }
            break;
        }
        return true;
    }

    private final boolean p() {
        return this._isCompleted;
    }

    protected boolean q() {
        d.a(this._delayed);
        Object object0 = this._queue;
        if(object0 == null) {
            return true;
        }
        return object0 instanceof f ? ((f)object0).g() : object0 == q.b;
    }

    public long r() {
        d.a(this._delayed);
        Runnable runnable0 = this.l();
        if(runnable0 != null) {
            runnable0.run();
            return 0L;
        }
        return this.e();
    }

    protected final void t() {
        this._queue = null;
        this._delayed = null;
    }
}

