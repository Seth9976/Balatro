package q0;

import java.util.Set;

final class c extends b {
    static abstract class a {
    }

    static final class q0.c.b extends q0.f.b.a {
        private Long a;
        private Long b;
        private Set c;

        @Override  // q0.f$b$a
        public b a() {
            String s = this.a == null ? " delta" : "";
            if(this.b == null) {
                s = s + " maxAllowedDelay";
            }
            if(this.c == null) {
                s = s + " flags";
            }
            if(!s.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + s);
            }
            return new c(((long)this.a), ((long)this.b), this.c, null);
        }

        @Override  // q0.f$b$a
        public q0.f.b.a b(long v) {
            this.a = v;
            return this;
        }

        @Override  // q0.f$b$a
        public q0.f.b.a c(Set set0) {
            if(set0 == null) {
                throw new NullPointerException("Null flags");
            }
            this.c = set0;
            return this;
        }

        @Override  // q0.f$b$a
        public q0.f.b.a d(long v) {
            this.b = v;
            return this;
        }
    }

    private final long a;
    private final long b;
    private final Set c;

    private c(long v, long v1, Set set0) {
        this.a = v;
        this.b = v1;
        this.c = set0;
    }

    c(long v, long v1, Set set0, a c$a0) {
        this(v, v1, set0);
    }

    @Override  // q0.f$b
    long b() {
        return this.a;
    }

    @Override  // q0.f$b
    Set c() {
        return this.c;
    }

    @Override  // q0.f$b
    long d() {
        return this.b;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof b) {
            long v = ((b)object0).b();
            if(this.a == v) {
                long v1 = ((b)object0).d();
                if(this.b == v1) {
                    Set set0 = ((b)object0).c();
                    return this.c.equals(set0);
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ((((int)(this.a ^ this.a >>> 0x20)) ^ 1000003) * 1000003 ^ ((int)(this.b >>> 0x20 ^ this.b))) * 1000003 ^ this.c.hashCode();
    }

    @Override
    public String toString() {
        return "ConfigValue{delta=" + this.a + ", maxAllowedDelay=" + this.b + ", flags=" + this.c + "}";
    }
}

