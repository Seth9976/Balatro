package r0;

final class a extends e {
    static abstract class r0.a.a {
    }

    static final class b extends r0.e.a {
        private Long a;
        private Integer b;
        private Integer c;
        private Long d;
        private Integer e;

        @Override  // r0.e$a
        e a() {
            String s = this.a == null ? " maxStorageSizeInBytes" : "";
            if(this.b == null) {
                s = s + " loadBatchSize";
            }
            if(this.c == null) {
                s = s + " criticalSectionEnterTimeoutMs";
            }
            if(this.d == null) {
                s = s + " eventCleanUpAge";
            }
            if(this.e == null) {
                s = s + " maxBlobByteSizePerRow";
            }
            if(!s.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + s);
            }
            return new a(((long)this.a), ((int)this.b), ((int)this.c), ((long)this.d), ((int)this.e), null);
        }

        @Override  // r0.e$a
        r0.e.a b(int v) {
            this.c = v;
            return this;
        }

        @Override  // r0.e$a
        r0.e.a c(long v) {
            this.d = v;
            return this;
        }

        @Override  // r0.e$a
        r0.e.a d(int v) {
            this.b = v;
            return this;
        }

        @Override  // r0.e$a
        r0.e.a e(int v) {
            this.e = v;
            return this;
        }

        @Override  // r0.e$a
        r0.e.a f(long v) {
            this.a = v;
            return this;
        }
    }

    private final long b;
    private final int c;
    private final int d;
    private final long e;
    private final int f;

    private a(long v, int v1, int v2, long v3, int v4) {
        this.b = v;
        this.c = v1;
        this.d = v2;
        this.e = v3;
        this.f = v4;
    }

    a(long v, int v1, int v2, long v3, int v4, r0.a.a a$a0) {
        this(v, v1, v2, v3, v4);
    }

    @Override  // r0.e
    int b() {
        return this.d;
    }

    @Override  // r0.e
    long c() {
        return this.e;
    }

    @Override  // r0.e
    int d() {
        return this.c;
    }

    @Override  // r0.e
    int e() {
        return this.f;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof e) {
            long v = ((e)object0).f();
            if(this.b == v) {
                int v1 = ((e)object0).d();
                if(this.c == v1) {
                    int v2 = ((e)object0).b();
                    if(this.d == v2) {
                        long v3 = ((e)object0).c();
                        if(this.e == v3) {
                            int v4 = ((e)object0).e();
                            return this.f == v4;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override  // r0.e
    long f() {
        return this.b;
    }

    @Override
    public int hashCode() {
        return ((((((int)(this.b ^ this.b >>> 0x20)) ^ 1000003) * 1000003 ^ this.c) * 1000003 ^ this.d) * 1000003 ^ ((int)(this.e >>> 0x20 ^ this.e))) * 1000003 ^ this.f;
    }

    @Override
    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.b + ", loadBatchSize=" + this.c + ", criticalSectionEnterTimeoutMs=" + this.d + ", eventCleanUpAge=" + this.e + ", maxBlobByteSizePerRow=" + this.f + "}";
    }
}

