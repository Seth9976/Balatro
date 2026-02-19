package g2;

final class r implements Runnable {
    final h e;
    final s f;

    r(s s0, h h0) {
        this.f = s0;
        this.e = h0;
        super();
    }

    @Override
    public final void run() {
        synchronized(this.f.b) {
            s s0 = this.f;
            if(s0.c != null) {
                s0.c.a(this.e);
            }
        }
    }
}

