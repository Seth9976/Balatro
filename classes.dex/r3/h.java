package r3;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import n3.f;

public final class h extends o implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final h j;
    private static final long k;

    static {
        h h0 = new h();
        h.j = h0;
        m.g(h0, false, 1, null);
        h.k = TimeUnit.MILLISECONDS.toNanos(1000L);
    }

    private final boolean A() {
        synchronized(this) {
            h.debugStatus = 1;
            this.notifyAll();
            return true;
        }
    }

    private final void B() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override  // r3.p
    protected Thread j() {
        return h._thread == null ? this.v() : h._thread;
    }

    @Override  // r3.o
    public void m(Runnable runnable0) {
        if(this.w()) {
            this.B();
        }
        super.m(runnable0);
    }

    @Override
    public void run() {
        long v1;
        w.a.a(this);
        try {
            if(!this.A()) {
                goto label_2;
            }
            goto label_7;
        }
        catch(Throwable throwable0) {
            goto label_28;
        }
    label_2:
        h._thread = null;
        this.u();
        if(!this.q()) {
            this.j();
        }
        return;
    label_7:
        long v = 0x7FFFFFFFFFFFFFFFL;
        while(true) {
            try {
            label_8:
                Thread.interrupted();
                v1 = this.r();
                if(Long.compare(v1, 0x7FFFFFFFFFFFFFFFL) != 0) {
                    v = 0x7FFFFFFFFFFFFFFFL;
                    goto label_24;
                }
            }
            catch(Throwable throwable0) {
                break;
            }
            long v2 = System.nanoTime();
            if(v == 0x7FFFFFFFFFFFFFFFL) {
                v = h.k + v2;
            }
            long v3 = v - v2;
            if(v3 <= 0L) {
                h._thread = null;
                this.u();
                if(!this.q()) {
                    this.j();
                }
                return;
            }
            try {
                v1 = f.c(v1, v3);
            label_24:
                if(v1 <= 0L) {
                    goto label_8;
                }
                LockSupport.parkNanos(this, v1);
                goto label_8;
            }
            catch(Throwable throwable0) {
            }
            break;
        }
    label_28:
        h._thread = null;
        this.u();
        if(!this.q()) {
            this.j();
        }
        throw throwable0;
    }

    private final void u() {
        synchronized(this) {
        }
    }

    private final Thread v() {
        synchronized(this) {
            Thread thread0 = h._thread;
            if(thread0 == null) {
                thread0 = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                h._thread = thread0;
                thread0.setDaemon(true);
                thread0.start();
            }
            return thread0;
        }
    }

    private final boolean w() {
        return h.debugStatus == 4;
    }

    private final boolean y() [...] // 潜在的解密器
}

