package d0;

public final class e {
    public static class a {
        private String a;

        a(y y0) {
        }

        public e a() {
            if(this.a == null) {
                throw new IllegalArgumentException("Product type must be set");
            }
            return new e(this, null);
        }

        public a b(String s) {
            this.a = s;
            return this;
        }
    }

    private final String a;

    e(a e$a0, z z0) {
        this.a = e$a0.a;
    }

    public static a a() {
        return new a(null);
    }

    public final String b() {
        return this.a;
    }
}

