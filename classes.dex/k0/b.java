package k0;

final class b extends g {
    private final a a;
    private final long b;

    b(a g$a0, long v) {
        if(g$a0 == null) {
            throw new NullPointerException("Null status");
        }
        this.a = g$a0;
        this.b = v;
    }

    @Override  // k0.g
    public long b() {
        return this.b;
    }

    @Override  // k0.g
    public a c() {
        return this.a;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof g) {
            a g$a0 = ((g)object0).c();
            if(this.a.equals(g$a0)) {
                long v = ((g)object0).b();
                return this.b == v;
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.a.hashCode() ^ 1000003) * 1000003 ^ ((int)(this.b ^ this.b >>> 0x20));
    }

    @Override
    public String toString() {
        return "BackendResponse{status=" + this.a + ", nextRequestWaitMillis=" + this.b + "}";
    }
}

