package g2;

final class p implements Runnable {
    final q e;

    p(q q0) {
        this.e = q0;
        super();
    }

    @Override
    public final void run() {
        synchronized(this.e.b) {
            q q0 = this.e;
            if(q0.c != null) {
                q0.c.b();
            }
        }
    }
}

