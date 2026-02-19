package m0;

public final class c {
    public static final class a {
        private long a;
        private b b;

        a() {
            this.a = 0L;
            this.b = b.f;
        }

        public c a() {
            return new c(this.a, this.b);
        }

        public a b(long v) {
            this.a = v;
            return this;
        }

        public a c(b c$b0) {
            this.b = c$b0;
            return this;
        }
    }

    public static enum b implements m2.c {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);

        private final int e;

        private b(int v1) {
            this.e = v1;
        }

        @Override  // m2.c
        public int c() {
            return this.e;
        }
    }

    private final long a;
    private final b b;
    private static final c c;

    static {
        c.c = new a().a();
    }

    c(long v, b c$b0) {
        this.a = v;
        this.b = c$b0;
    }

    public long a() {
        return this.a;
    }

    public b b() {
        return this.b;
    }

    public static a c() {
        return new a();
    }
}

