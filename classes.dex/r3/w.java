package r3;

public final class w {
    public static final w a;
    private static final ThreadLocal b;

    static {
        w.a = new w();
        w.b = new ThreadLocal();
    }

    public final void a(m m0) {
        w.b.set(m0);
    }
}

