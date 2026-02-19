package x1;

import l1.d;

final class j implements Runnable {
    final l e;

    j(l l0, i i0) {
        this.e = l0;
        super();
    }

    @Override
    public final void run() {
        long v = this.e.a();
        if(v != -1L && d.b().a() > v) {
            l.f(this.e.a);
        }
    }
}

