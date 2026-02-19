package r0;

import j0.i;
import j0.o;

final class b extends k {
    private final long a;
    private final o b;
    private final i c;

    b(long v, o o0, i i0) {
        this.a = v;
        if(o0 == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.b = o0;
        if(i0 == null) {
            throw new NullPointerException("Null event");
        }
        this.c = i0;
    }

    @Override  // r0.k
    public i b() {
        return this.c;
    }

    @Override  // r0.k
    public long c() {
        return this.a;
    }

    @Override  // r0.k
    public o d() {
        return this.b;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof k) {
            long v = ((k)object0).c();
            if(this.a == v) {
                o o0 = ((k)object0).d();
                if(this.b.equals(o0)) {
                    i i0 = ((k)object0).b();
                    return this.c.equals(i0);
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ((((int)(this.a ^ this.a >>> 0x20)) ^ 1000003) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode();
    }

    @Override
    public String toString() {
        return "PersistedEvent{id=" + this.a + ", transportContext=" + this.b + ", event=" + this.c + "}";
    }
}

