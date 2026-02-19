package g2;

import java.util.concurrent.Executor;

final class w implements x {
    private final Executor a;
    private final Object b;
    private f c;

    public w(Executor executor0, f f0) {
        this.b = new Object();
        this.a = executor0;
        this.c = f0;
    }

    @Override  // g2.x
    public final void a(h h0) {
        if(h0.q()) {
            Object object0 = this.b;
            synchronized(object0) {
                if(this.c == null) {
                    return;
                }
            }
            v v0 = new v(this, h0);
            this.a.execute(v0);
        }
    }

    @Override  // g2.x
    public final void c() {
        synchronized(this.b) {
            this.c = null;
        }
    }
}

