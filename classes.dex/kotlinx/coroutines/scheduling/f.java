package kotlinx.coroutines.scheduling;

import d3.e;
import r3.r;

public abstract class f extends r {
    private final int g;
    private final int h;
    private final long i;
    private final String j;
    private a k;

    public f(int v, int v1, long v2, String s) {
        this.g = v;
        this.h = v1;
        this.i = v2;
        this.j = s;
        this.k = this.d();
    }

    @Override  // r3.c
    public void a(e e0, Runnable runnable0) {
        a.f(this.k, runnable0, null, false, 6, null);
    }

    private final a d() {
        return new a(this.g, this.h, this.i, this.j);
    }

    public final void e(Runnable runnable0, i i0, boolean z) {
        this.k.e(runnable0, i0, z);
    }
}

