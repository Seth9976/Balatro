package q1;

public final class k {
    private volatile boolean a;
    private static final k b;

    static {
        k.b = new k();
    }

    k() {
        this.a = false;
    }

    public static k a() {
        return k.b;
    }

    public final void b() {
        this.a = true;
    }

    public final boolean c() {
        return this.a;
    }
}

