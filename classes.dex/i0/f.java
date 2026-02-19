package i0;

import java.util.Arrays;

final class f extends l {
    static abstract class a {
    }

    static final class b extends i0.l.a {
        private Long a;
        private Integer b;
        private Long c;
        private byte[] d;
        private String e;
        private Long f;
        private o g;

        @Override  // i0.l$a
        public l a() {
            String s = this.a == null ? " eventTimeMs" : "";
            if(this.c == null) {
                s = s + " eventUptimeMs";
            }
            if(this.f == null) {
                s = s + " timezoneOffsetSeconds";
            }
            if(!s.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + s);
            }
            return new f(((long)this.a), this.b, ((long)this.c), this.d, this.e, ((long)this.f), this.g, null);
        }

        @Override  // i0.l$a
        public i0.l.a b(Integer integer0) {
            this.b = integer0;
            return this;
        }

        @Override  // i0.l$a
        public i0.l.a c(long v) {
            this.a = v;
            return this;
        }

        @Override  // i0.l$a
        public i0.l.a d(long v) {
            this.c = v;
            return this;
        }

        @Override  // i0.l$a
        public i0.l.a e(o o0) {
            this.g = o0;
            return this;
        }

        @Override  // i0.l$a
        i0.l.a f(byte[] arr_b) {
            this.d = arr_b;
            return this;
        }

        @Override  // i0.l$a
        i0.l.a g(String s) {
            this.e = s;
            return this;
        }

        @Override  // i0.l$a
        public i0.l.a h(long v) {
            this.f = v;
            return this;
        }
    }

    private final long a;
    private final Integer b;
    private final long c;
    private final byte[] d;
    private final String e;
    private final long f;
    private final o g;

    private f(long v, Integer integer0, long v1, byte[] arr_b, String s, long v2, o o0) {
        this.a = v;
        this.b = integer0;
        this.c = v1;
        this.d = arr_b;
        this.e = s;
        this.f = v2;
        this.g = o0;
    }

    f(long v, Integer integer0, long v1, byte[] arr_b, String s, long v2, o o0, a f$a0) {
        this(v, integer0, v1, arr_b, s, v2, o0);
    }

    @Override  // i0.l
    public Integer b() {
        return this.b;
    }

    @Override  // i0.l
    public long c() {
        return this.a;
    }

    @Override  // i0.l
    public long d() {
        return this.c;
    }

    @Override  // i0.l
    public o e() {
        return this.g;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof l) {
            long v = ((l)object0).c();
            if(this.a == v) {
                Integer integer0 = this.b;
                if(integer0 != null) {
                    if(integer0.equals(((l)object0).b())) {
                    label_10:
                        long v1 = ((l)object0).d();
                        if(this.c == v1) {
                            byte[] arr_b = ((l)object0) instanceof f ? ((f)(((l)object0))).d : ((l)object0).f();
                            if(Arrays.equals(this.d, arr_b)) {
                                String s = this.e;
                                if(s != null) {
                                    if(s.equals(((l)object0).g())) {
                                    label_19:
                                        long v2 = ((l)object0).h();
                                        if(this.f == v2) {
                                            o o0 = ((l)object0).e();
                                            return this.g == null ? o0 == null : this.g.equals(o0);
                                        }
                                    }
                                }
                                else if(((l)object0).g() == null) {
                                    goto label_19;
                                }
                            }
                        }
                    }
                }
                else if(((l)object0).b() == null) {
                    goto label_10;
                }
            }
            return false;
        }
        return false;
    }

    @Override  // i0.l
    public byte[] f() {
        return this.d;
    }

    @Override  // i0.l
    public String g() {
        return this.e;
    }

    @Override  // i0.l
    public long h() {
        return this.f;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = Arrays.hashCode(this.d);
        int v2 = ((((((((int)(this.a ^ this.a >>> 0x20)) ^ 1000003) * 1000003 ^ (this.b == null ? 0 : this.b.hashCode())) * 1000003 ^ ((int)(this.c ^ this.c >>> 0x20))) * 1000003 ^ v1) * 1000003 ^ (this.e == null ? 0 : this.e.hashCode())) * 1000003 ^ ((int)(this.f >>> 0x20 ^ this.f))) * 1000003;
        o o0 = this.g;
        if(o0 != null) {
            v = o0.hashCode();
        }
        return v2 ^ v;
    }

    @Override
    public String toString() {
        return "LogEvent{eventTimeMs=" + this.a + ", eventCode=" + this.b + ", eventUptimeMs=" + this.c + ", sourceExtension=" + Arrays.toString(this.d) + ", sourceExtensionJsonProto3=" + this.e + ", timezoneOffsetSeconds=" + this.f + ", networkConnectionInfo=" + this.g + "}";
    }
}

