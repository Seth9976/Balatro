package i0;

final class i extends o {
    static abstract class a {
    }

    static final class b extends i0.o.a {
        private c a;
        private i0.o.b b;

        @Override  // i0.o$a
        public o a() {
            return new i(this.a, this.b, null);
        }

        @Override  // i0.o$a
        public i0.o.a b(i0.o.b o$b0) {
            this.b = o$b0;
            return this;
        }

        @Override  // i0.o$a
        public i0.o.a c(c o$c0) {
            this.a = o$c0;
            return this;
        }
    }

    private final c a;
    private final i0.o.b b;

    private i(c o$c0, i0.o.b o$b0) {
        this.a = o$c0;
        this.b = o$b0;
    }

    i(c o$c0, i0.o.b o$b0, a i$a0) {
        this(o$c0, o$b0);
    }

    @Override  // i0.o
    public i0.o.b b() {
        return this.b;
    }

    @Override  // i0.o
    public c c() {
        return this.a;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof o) {
            c o$c0 = this.a;
            if(o$c0 != null) {
                if(o$c0.equals(((o)object0).c())) {
                label_8:
                    i0.o.b o$b0 = ((o)object0).b();
                    return this.b == null ? o$b0 == null : this.b.equals(o$b0);
                }
            }
            else if(((o)object0).c() == null) {
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
        i0.o.b o$b0 = this.b;
        if(o$b0 != null) {
            v = o$b0.hashCode();
        }
        return (v1 ^ 1000003) * 1000003 ^ v;
    }

    @Override
    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.a + ", mobileSubtype=" + this.b + "}";
    }
}

