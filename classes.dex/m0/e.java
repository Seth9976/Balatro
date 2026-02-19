package m0;

public final class e {
    public static final class a {
        private long a;
        private long b;

        a() {
            this.a = 0L;
            this.b = 0L;
        }

        public e a() {
            return new e(this.a, this.b);
        }

        public a b(long v) {
            this.a = v;
            return this;
        }

        public a c(long v) {
            this.b = v;
            return this;
        }
    }

    private final long a;
    private final long b;
    private static final e c;

    static {
        e.c = new a().a();
    }

    e(long v, long v1) {
        this.a = v;
        this.b = v1;
    }

    public long a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public static a c() {
        return new a();
    }
}

