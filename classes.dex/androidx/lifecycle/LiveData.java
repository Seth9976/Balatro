package androidx.lifecycle;

import j.b.d;
import java.util.Map.Entry;

public abstract class LiveData {
    class LifecycleBoundObserver extends c implements j {
        final l e;
        final LiveData f;

        LifecycleBoundObserver(l l0, q q0) {
            super(q0);
            this.e = l0;
        }

        @Override  // androidx.lifecycle.j
        public void d(l l0, b h$b0) {
            androidx.lifecycle.h.c h$c0 = this.e.o().b();
            if(h$c0 == androidx.lifecycle.h.c.e) {
                LiveData.this.m(this.a);
                return;
            }
            androidx.lifecycle.h.c h$c1 = null;
            while(h$c1 != h$c0) {
                this.h(this.k());
                h$c1 = h$c0;
                h$c0 = this.e.o().b();
            }
        }

        @Override  // androidx.lifecycle.LiveData$c
        void i() {
            this.e.o().c(this);
        }

        @Override  // androidx.lifecycle.LiveData$c
        boolean j(l l0) {
            return this.e == l0;
        }

        @Override  // androidx.lifecycle.LiveData$c
        boolean k() {
            return this.e.o().b().c(androidx.lifecycle.h.c.h);
        }
    }

    class a implements Runnable {
        final LiveData e;

        @Override
        public void run() {
            Object object0;
            synchronized(LiveData.this.a) {
                object0 = LiveData.this.f;
                LiveData.this.f = LiveData.k;
            }
            LiveData.this.n(object0);
        }
    }

    class androidx.lifecycle.LiveData.b extends c {
        final LiveData e;

        androidx.lifecycle.LiveData.b(q q0) {
            super(q0);
        }

        @Override  // androidx.lifecycle.LiveData$c
        boolean k() {
            return true;
        }
    }

    abstract class c {
        final q a;
        boolean b;
        int c;
        final LiveData d;

        c(q q0) {
            this.c = -1;
            this.a = q0;
        }

        void h(boolean z) {
            if(z == this.b) {
                return;
            }
            this.b = z;
            LiveData.this.c((z ? 1 : -1));
            if(this.b) {
                LiveData.this.e(this);
            }
        }

        void i() {
        }

        boolean j(l l0) {
            return false;
        }

        abstract boolean k();
    }

    final Object a;
    private j.b b;
    int c;
    private boolean d;
    private volatile Object e;
    volatile Object f;
    private int g;
    private boolean h;
    private boolean i;
    private final Runnable j;
    static final Object k;

    static {
        LiveData.k = new Object();
    }

    public LiveData() {
        this.a = new Object();
        this.b = new j.b();
        this.c = 0;
        this.f = LiveData.k;
        this.j = new a(this);
        this.e = LiveData.k;
        this.g = -1;
    }

    static void b(String s) {
        if(!i.a.d().b()) {
            throw new IllegalStateException("Cannot invoke " + s + " on a background thread");
        }
    }

    void c(int v) {
        int v1 = this.c;
        this.c = v + v1;
        if(this.d) {
            return;
        }
        this.d = true;
        try {
            while(true) {
                int v3 = this.c;
                if(v1 == v3) {
                    break;
                }
                if(v1 == 0 && v3 > 0) {
                    this.j();
                }
                else if(v1 > 0 && v3 == 0) {
                    this.k();
                }
                v1 = v3;
            }
        }
        finally {
            this.d = false;
        }
    }

    private void d(c liveData$c0) {
        if(!liveData$c0.b) {
            return;
        }
        if(!liveData$c0.k()) {
            liveData$c0.h(false);
            return;
        }
        int v = this.g;
        if(liveData$c0.c >= v) {
            return;
        }
        liveData$c0.c = v;
        liveData$c0.a.a(this.e);
    }

    void e(c liveData$c0) {
        if(this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if(liveData$c0 == null) {
                d b$d0 = this.b.p();
                while(b$d0.hasNext()) {
                    Object object0 = b$d0.next();
                    this.d(((c)((Map.Entry)object0).getValue()));
                    if(this.i) {
                        break;
                    }
                }
            }
            else {
                this.d(liveData$c0);
                liveData$c0 = null;
            }
        }
        while(this.i);
        this.h = false;
    }

    public Object f() {
        return this.e == LiveData.k ? null : this.e;
    }

    public boolean g() {
        return this.c > 0;
    }

    public void h(l l0, q q0) {
        LiveData.b("observe");
        if(l0.o().b() == androidx.lifecycle.h.c.e) {
            return;
        }
        LifecycleBoundObserver liveData$LifecycleBoundObserver0 = new LifecycleBoundObserver(this, l0, q0);
        c liveData$c0 = (c)this.b.s(q0, liveData$LifecycleBoundObserver0);
        if(liveData$c0 != null && !liveData$c0.j(l0)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if(liveData$c0 != null) {
            return;
        }
        l0.o().a(liveData$LifecycleBoundObserver0);
    }

    public void i(q q0) {
        LiveData.b("observeForever");
        androidx.lifecycle.LiveData.b liveData$b0 = new androidx.lifecycle.LiveData.b(this, q0);
        c liveData$c0 = (c)this.b.s(q0, liveData$b0);
        if(liveData$c0 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if(liveData$c0 != null) {
            return;
        }
        liveData$b0.h(true);
    }

    protected void j() {
    }

    protected void k() {
    }

    protected void l(Object object0) {
        synchronized(this.a) {
            boolean z = this.f == LiveData.k;
            this.f = object0;
        }
        if(!z) {
            return;
        }
        i.a.d().c(this.j);
    }

    public void m(q q0) {
        LiveData.b("removeObserver");
        c liveData$c0 = (c)this.b.t(q0);
        if(liveData$c0 == null) {
            return;
        }
        liveData$c0.i();
        liveData$c0.h(false);
    }

    protected void n(Object object0) {
        LiveData.b("setValue");
        ++this.g;
        this.e = object0;
        this.e(null);
    }
}

