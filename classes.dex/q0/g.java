package q0;

import j0.o;

public final class g implements Runnable {
    public final r e;
    public final o f;
    public final int g;
    public final Runnable h;

    public g(r r0, o o0, int v, Runnable runnable0) {
        this.e = r0;
        this.f = o0;
        this.g = v;
        this.h = runnable0;
    }

    @Override
    public final void run() {
        this.e.t(this.f, this.g, this.h);
    }
}

