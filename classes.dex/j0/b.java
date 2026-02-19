package j0;

import java.util.Map;

final class b extends i {
    static abstract class a {
    }

    static final class j0.b.b extends j0.i.a {
        private String a;
        private Integer b;
        private h c;
        private Long d;
        private Long e;
        private Map f;

        @Override  // j0.i$a
        public i d() {
            String s = this.a == null ? " transportName" : "";
            if(this.c == null) {
                s = s + " encodedPayload";
            }
            if(this.d == null) {
                s = s + " eventMillis";
            }
            if(this.e == null) {
                s = s + " uptimeMillis";
            }
            if(this.f == null) {
                s = s + " autoMetadata";
            }
            if(!s.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + s);
            }
            return new b(this.a, this.b, this.c, ((long)this.d), ((long)this.e), this.f, null);
        }

        @Override  // j0.i$a
        protected Map e() {
            Map map0 = this.f;
            if(map0 == null) {
                throw new IllegalStateException("Property \"autoMetadata\" has not been set");
            }
            return map0;
        }

        @Override  // j0.i$a
        protected j0.i.a f(Map map0) {
            if(map0 == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f = map0;
            return this;
        }

        @Override  // j0.i$a
        public j0.i.a g(Integer integer0) {
            this.b = integer0;
            return this;
        }

        @Override  // j0.i$a
        public j0.i.a h(h h0) {
            if(h0 == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.c = h0;
            return this;
        }

        @Override  // j0.i$a
        public j0.i.a i(long v) {
            this.d = v;
            return this;
        }

        @Override  // j0.i$a
        public j0.i.a j(String s) {
            if(s == null) {
                throw new NullPointerException("Null transportName");
            }
            this.a = s;
            return this;
        }

        @Override  // j0.i$a
        public j0.i.a k(long v) {
            this.e = v;
            return this;
        }
    }

    private final String a;
    private final Integer b;
    private final h c;
    private final long d;
    private final long e;
    private final Map f;

    private b(String s, Integer integer0, h h0, long v, long v1, Map map0) {
        this.a = s;
        this.b = integer0;
        this.c = h0;
        this.d = v;
        this.e = v1;
        this.f = map0;
    }

    b(String s, Integer integer0, h h0, long v, long v1, Map map0, a b$a0) {
        this(s, integer0, h0, v, v1, map0);
    }

    @Override  // j0.i
    protected Map c() {
        return this.f;
    }

    @Override  // j0.i
    public Integer d() {
        return this.b;
    }

    @Override  // j0.i
    public h e() {
        return this.c;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof i) {
            String s = ((i)object0).j();
            if(this.a.equals(s)) {
                Integer integer0 = this.b;
                if(integer0 != null) {
                    if(integer0.equals(((i)object0).d())) {
                    label_10:
                        h h0 = ((i)object0).e();
                        if(this.c.equals(h0)) {
                            long v = ((i)object0).f();
                            if(this.d == v) {
                                long v1 = ((i)object0).k();
                                if(this.e == v1) {
                                    Map map0 = ((i)object0).c();
                                    return this.f.equals(map0);
                                }
                            }
                        }
                    }
                }
                else if(((i)object0).d() == null) {
                    goto label_10;
                }
            }
            return false;
        }
        return false;
    }

    @Override  // j0.i
    public long f() {
        return this.d;
    }

    @Override
    public int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? ((((v ^ 1000003) * 0xD5009D89 ^ this.c.hashCode()) * 1000003 ^ ((int)(this.d ^ this.d >>> 0x20))) * 1000003 ^ ((int)(this.e ^ this.e >>> 0x20))) * 1000003 ^ this.f.hashCode() : (((((v ^ 1000003) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode()) * 1000003 ^ ((int)(this.d ^ this.d >>> 0x20))) * 1000003 ^ ((int)(this.e ^ this.e >>> 0x20))) * 1000003 ^ this.f.hashCode();
    }

    @Override  // j0.i
    public String j() {
        return this.a;
    }

    @Override  // j0.i
    public long k() {
        return this.e;
    }

    @Override
    public String toString() {
        return "EventInternal{transportName=" + this.a + ", code=" + this.b + ", encodedPayload=" + this.c + ", eventMillis=" + this.d + ", uptimeMillis=" + this.e + ", autoMetadata=" + this.f + "}";
    }
}

