package g2;

import java.util.concurrent.Executor;

final class u implements x {
    private final Executor a;
    private final Object b;
    private e c;

    public u(Executor executor0, e e0) {
        this.b = new Object();
        this.a = executor0;
        this.c = e0;
    }

    @Override  // g2.x
    public final void a(h h0) {
        if(!h0.q() && !h0.o()) {
            Object object0 = this.b;
            synchronized(object0) {
                if(this.c == null) {
                    return;
                }
            }
            t t0 = new t(this, h0);
            this.a.execute(t0);
        }
    }

    @Override  // g2.x
    public final void c() {
        synchronized(this.b) {
            this.c = null;
        }
    }
}

