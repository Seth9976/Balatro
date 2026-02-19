package m0;

public final class b {
    public static final class a {
        private e a;

        a() {
            this.a = null;
        }

        public b a() {
            return new b(this.a);
        }

        public a b(e e0) {
            this.a = e0;
            return this;
        }
    }

    private final e a;
    private static final b b;

    static {
        b.b = new a().a();
    }

    b(e e0) {
        this.a = e0;
    }

    public e a() {
        return this.a;
    }

    public static a b() {
        return new a();
    }
}

