package kotlinx.coroutines.scheduling;

public final class e extends g {
    public static final e a;

    static {
        e.a = new e();
    }

    @Override  // kotlinx.coroutines.scheduling.g
    public long a() {
        return System.nanoTime();
    }
}

