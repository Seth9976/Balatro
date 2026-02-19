package p1;

public final class b {
    private final boolean a;
    public static final b b;
    public static final b c;

    static {
        b.b = new b(true);
        b.c = new b(false);
    }

    private b(boolean z) {
        this.a = z;
    }

    public boolean a() {
        return this.a;
    }
}

