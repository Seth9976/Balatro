package v;

public final class b implements Runnable {
    public final String e;
    public final g f;

    public b(String s, g g0) {
        this.e = s;
        this.f = g0;
    }

    @Override
    public final void run() {
        c.d(this.e, this.f);
    }
}

