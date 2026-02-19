package p0;

import h0.h;
import j0.i;
import j0.o;

public final class a implements Runnable {
    public final c e;
    public final o f;
    public final h g;
    public final i h;

    public a(c c0, o o0, h h0, i i0) {
        this.e = c0;
        this.f = o0;
        this.g = h0;
        this.h = i0;
    }

    @Override
    public final void run() {
        this.e.e(this.f, this.g, this.h);
    }
}

