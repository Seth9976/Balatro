package i0;

final class h extends n {
    private final long a;

    h(long v) {
        this.a = v;
    }

    @Override  // i0.n
    public long c() {
        return this.a;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof n) {
            long v = ((n)object0).c();
            return this.a == v;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ((int)(this.a ^ this.a >>> 0x20)) ^ 1000003;
    }

    @Override
    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.a + "}";
    }
}

