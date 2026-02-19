package l0;

public final class c implements b {
    private final Object a;
    private static final c b;

    static {
        c.b = new c(null);
    }

    private c(Object object0) {
        this.a = object0;
    }

    public static b a(Object object0) {
        return new c(d.c(object0, "instance cannot be null"));
    }

    @Override  // a3.a
    public Object get() {
        return this.a;
    }
}

