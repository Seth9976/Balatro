package m0;

public final class f {
    public static final class a {
        private long a;
        private long b;

        a() {
            this.a = 0L;
            this.b = 0L;
        }

        public f a() {
            return new f(this.a, this.b);
        }

        public a b(long v) {
            this.b = v;
            return this;
        }

        public a c(long v) {
            this.a = v;
            return this;
        }
    }

    private final long a;
    private final long b;
    private static final f c;

    static {
        f.c = new a().a();
    }

    f(long v, long v1) {
        this.a = v;
        this.b = v1;
    }

    public long a() {
        return this.b;
    }

    public long b() {
        return this.a;
    }

    public static a c() {
        return new a();
    }
}

