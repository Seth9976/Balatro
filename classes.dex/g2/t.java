package g2;

import g1.q;

final class t implements Runnable {
    final h e;
    final u f;

    t(u u0, h h0) {
        this.f = u0;
        this.e = h0;
        super();
    }

    @Override
    public final void run() {
        synchronized(this.f.b) {
            u u0 = this.f;
            if(u0.c != null) {
                u0.c.d(((Exception)q.i(this.e.m())));
            }
        }
    }
}

