package kotlinx.coroutines.scheduling;

public final class c extends f {
    public static final c l;

    static {
        c.l = new c();
    }

    private c() {
        super(l.b, l.c, l.d, "DefaultDispatcher");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override  // r3.c
    public String toString() {
        return "Dispatchers.Default";
    }
}

