package androidx.core.content.res;

public final class j implements Runnable {
    public final e e;
    public final int f;

    public j(e h$e0, int v) {
        this.e = h$e0;
        this.f = v;
    }

    @Override
    public final void run() {
        this.e.f(this.f);
    }
}

