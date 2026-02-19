package g2;

import java.util.concurrent.Executor;

final class s implements x {
    private final Executor a;
    private final Object b;
    private d c;

    public s(Executor executor0, d d0) {
        this.b = new Object();
        this.a = executor0;
        this.c = d0;
    }

    @Override  // g2.x
    public final void a(h h0) {
        synchronized(this.b) {
            if(this.c == null) {
                return;
            }
        }
        r r0 = new r(this, h0);
        this.a.execute(r0);
    }

    @Override  // g2.x
    public final void c() {
        synchronized(this.b) {
            this.c = null;
        }
    }
}

