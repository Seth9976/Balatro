package g2;

import java.util.concurrent.Executor;

final class q implements x {
    private final Executor a;
    private final Object b;
    private c c;

    public q(Executor executor0, c c0) {
        this.b = new Object();
        this.a = executor0;
        this.c = c0;
    }

    @Override  // g2.x
    public final void a(h h0) {
        if(h0.o()) {
            Object object0 = this.b;
            synchronized(object0) {
                if(this.c == null) {
                    return;
                }
            }
            p p0 = new p(this);
            this.a.execute(p0);
        }
    }

    @Override  // g2.x
    public final void c() {
        synchronized(this.b) {
            this.c = null;
        }
    }
}

