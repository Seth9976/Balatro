package i0;

import java.util.List;

final class g extends m {
    static abstract class a {
    }

    static final class b extends i0.m.a {
        private Long a;
        private Long b;
        private k c;
        private Integer d;
        private String e;
        private List f;
        private p g;

        @Override  // i0.m$a
        public m a() {
            String s = this.a == null ? " requestTimeMs" : "";
            if(this.b == null) {
                s = s + " requestUptimeMs";
            }
            if(!s.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + s);
            }
            return new g(((long)this.a), ((long)this.b), this.c, this.d, this.e, this.f, this.g, null);
        }

        @Override  // i0.m$a
        public i0.m.a b(k k0) {
            this.c = k0;
            return this;
        }

        @Override  // i0.m$a
        public i0.m.a c(List list0) {
            this.f = list0;
            return this;
        }

        @Override  // i0.m$a
        i0.m.a d(Integer integer0) {
            this.d = integer0;
            return this;
        }

        @Override  // i0.m$a
        i0.m.a e(String s) {
            this.e = s;
            return this;
        }

        @Override  // i0.m$a
        public i0.m.a f(p p0) {
            this.g = p0;
            return this;
        }

        @Override  // i0.m$a
        public i0.m.a g(long v) {
            this.a = v;
            return this;
        }

        @Override  // i0.m$a
        public i0.m.a h(long v) {
            this.b = v;
            return this;
        }
    }

    private final long a;
    private final long b;
    private final k c;
    private final Integer d;
    private final String e;
    private final List f;
    private final p g;

    private g(long v, long v1, k k0, Integer integer0, String s, List list0, p p0) {
        this.a = v;
        this.b = v1;
        this.c = k0;
        this.d = integer0;
        this.e = s;
        this.f = list0;
        this.g = p0;
    }

    g(long v, long v1, k k0, Integer integer0, String s, List list0, p p0, a g$a0) {
        this(v, v1, k0, integer0, s, list0, p0);
    }

    @Override  // i0.m
    public k b() {
        return this.c;
    }

    @Override  // i0.m
    public List c() {
        return this.f;
    }

    @Override  // i0.m
    public Integer d() {
        return this.d;
    }

    @Override  // i0.m
    public String e() {
        return this.e;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof m) {
            long v = ((m)object0).g();
            if(this.a == v) {
                long v1 = ((m)object0).h();
                if(this.b == v1) {
                    k k0 = this.c;
                    if(k0 != null) {
                        if(k0.equals(((m)object0).b())) {
                        label_12:
                            Integer integer0 = this.d;
                            if(integer0 != null) {
                                if(integer0.equals(((m)object0).d())) {
                                label_17:
                                    String s = this.e;
                                    if(s != null) {
                                        if(s.equals(((m)object0).e())) {
                                        label_22:
                                            List list0 = this.f;
                                            if(list0 != null) {
                                                if(list0.equals(((m)object0).c())) {
                                                label_27:
                                                    p p0 = ((m)object0).f();
                                                    return this.g == null ? p0 == null : this.g.equals(p0);
                                                }
                                            }
                                            else if(((m)object0).c() == null) {
                                                goto label_27;
                                            }
                                        }
                                    }
                                    else if(((m)object0).e() == null) {
                                        goto label_22;
                                    }
                                }
                            }
                            else if(((m)object0).d() == null) {
                                goto label_17;
                            }
                        }
                    }
                    else if(((m)object0).b() == null) {
                        goto label_12;
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override  // i0.m
    public p f() {
        return this.g;
    }

    @Override  // i0.m
    public long g() {
        return this.a;
    }

    @Override  // i0.m
    public long h() {
        return this.b;
    }

    @Override
    public int hashCode() {
        int v = ((((int)(this.a ^ this.a >>> 0x20)) ^ 1000003) * 1000003 ^ ((int)(this.b >>> 0x20 ^ this.b))) * 1000003;
        int v1 = 0;
        int v2 = this.c == null ? 0 : this.c.hashCode();
        int v3 = this.d == null ? 0 : this.d.hashCode();
        int v4 = this.e == null ? 0 : this.e.hashCode();
        int v5 = this.f == null ? 0 : this.f.hashCode();
        p p0 = this.g;
        if(p0 != null) {
            v1 = p0.hashCode();
        }
        return ((((v ^ v2) * 1000003 ^ v3) * 1000003 ^ v4) * 1000003 ^ v5) * 1000003 ^ v1;
    }

    @Override
    public String toString() {
        return "LogRequest{requestTimeMs=" + this.a + ", requestUptimeMs=" + this.b + ", clientInfo=" + this.c + ", logSource=" + this.d + ", logSourceName=" + this.e + ", logEvents=" + this.f + ", qosTier=" + this.g + "}";
    }
}

