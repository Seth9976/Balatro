package t3;

import r3.f;
import r3.i;
import r3.j;

public final class c extends r3.c implements Runnable, j {
    private final r3.c f;
    private final int g;
    private final j h;
    private final e i;
    private final Object j;
    private volatile int runningWorkers;

    public c(r3.c c0, int v) {
        this.f = c0;
        this.g = v;
        j j0 = c0 instanceof j ? ((j)c0) : null;
        if(j0 == null) {
            j0 = i.a();
        }
        this.h = j0;
        this.i = new e(false);
        this.j = new Object();
    }

    @Override  // r3.c
    public void a(d3.e e0, Runnable runnable0) {
        if(!this.d(runnable0) && this.e()) {
            this.f.a(this, this);
        }
    }

    private final boolean d(Runnable runnable0) {
        this.i.a(runnable0);
        return this.runningWorkers >= this.g;
    }

    private final boolean e() {
        synchronized(this.j) {
            if(this.runningWorkers >= this.g) {
                return false;
            }
            ++this.runningWorkers;
        }
        return true;
    }

    @Override
    public void run() {
        while(true) {
            int v = 0;
            Runnable runnable0;
            while((runnable0 = (Runnable)this.i.d()) != null) {
                try {
                    runnable0.run();
                }
                catch(Throwable throwable0) {
                    f.a(d3.f.e, throwable0);
                }
                ++v;
                if(v >= 16 && this.f.b(this)) {
                    this.f.a(this, this);
                    return;
                }
            }
            Object object0 = this.j;
            synchronized(object0) {
                --this.runningWorkers;
                if(this.i.c() == 0) {
                    return;
                }
                ++this.runningWorkers;
            }
        }
    }
}

