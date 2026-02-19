package l1;

public class d implements c {
    private static final d a;

    static {
        d.a = new d();
    }

    @Override  // l1.c
    public final long a() {
        return System.currentTimeMillis();
    }

    public static c b() {
        return d.a;
    }
}

