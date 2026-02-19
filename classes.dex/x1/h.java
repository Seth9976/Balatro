package x1;

import g2.i;

public final class h implements Runnable {
    public final l e;
    public final i f;

    public h(l l0, i i0) {
        this.e = l0;
        this.f = i0;
    }

    @Override
    public final void run() {
        this.e.e(this.f);
    }
}

