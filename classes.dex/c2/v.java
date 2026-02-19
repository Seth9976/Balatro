package c2;

import g2.h;
import g2.i;

public final class v implements Runnable {
    public final g2 e;
    public final i f;

    public v(g2 g20, i i0) {
        this.e = g20;
        this.f = i0;
    }

    @Override
    public final void run() {
        ((h)this.e.a()).c(new t(this.f));
    }
}

