package i0;

final class e extends k {
    static abstract class a {
    }

    static final class b extends i0.k.a {
        private i0.k.b a;
        private i0.a b;

        @Override  // i0.k$a
        public k a() {
            return new e(this.a, this.b, null);
        }

        @Override  // i0.k$a
        public i0.k.a b(i0.a a0) {
            this.b = a0;
            return this;
        }

        @Override  // i0.k$a
        public i0.k.a c(i0.k.b k$b0) {
            this.a = k$b0;
            return this;
        }
    }

    private final i0.k.b a;
    private final i0.a b;

    private e(i0.k.b k$b0, i0.a a0) {
        this.a = k$b0;
        this.b = a0;
    }

    e(i0.k.b k$b0, i0.a a0, a e$a0) {
        this(k$b0, a0);
    }

    @Override  // i0.k
    public i0.a b() {
        return this.b;
    }

    @Override  // i0.k
    public i0.k.b c() {
        return this.a;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof k) {
            i0.k.b k$b0 = this.a;
            if(k$b0 != null) {
                if(k$b0.equals(((k)object0).c())) {
                label_8:
                    i0.a a0 = ((k)object0).b();
                    return this.b == null ? a0 == null : this.b.equals(a0);
                }
            }
            else if(((k)object0).c() == null) {
                goto label_8;
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        i0.a a0 = this.b;
        if(a0 != null) {
            v = a0.hashCode();
        }
        return (v1 ^ 1000003) * 1000003 ^ v;
    }

    @Override
    public String toString() {
        return "ClientInfo{clientType=" + this.a + ", androidClientInfo=" + this.b + "}";
    }
}

