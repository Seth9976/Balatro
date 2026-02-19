package j0;

import h0.e;

final class c extends n {
    static abstract class a {
    }

    static final class b extends j0.n.a {
        private o a;
        private String b;
        private h0.c c;
        private e d;
        private h0.b e;

        @Override  // j0.n$a
        public n a() {
            String s = this.a == null ? " transportContext" : "";
            if(this.b == null) {
                s = s + " transportName";
            }
            if(this.c == null) {
                s = s + " event";
            }
            if(this.d == null) {
                s = s + " transformer";
            }
            if(this.e == null) {
                s = s + " encoding";
            }
            if(!s.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + s);
            }
            return new c(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override  // j0.n$a
        j0.n.a b(h0.b b0) {
            if(b0 == null) {
                throw new NullPointerException("Null encoding");
            }
            this.e = b0;
            return this;
        }

        @Override  // j0.n$a
        j0.n.a c(h0.c c0) {
            if(c0 == null) {
                throw new NullPointerException("Null event");
            }
            this.c = c0;
            return this;
        }

        @Override  // j0.n$a
        j0.n.a d(e e0) {
            if(e0 == null) {
                throw new NullPointerException("Null transformer");
            }
            this.d = e0;
            return this;
        }

        @Override  // j0.n$a
        public j0.n.a e(o o0) {
            if(o0 == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.a = o0;
            return this;
        }

        @Override  // j0.n$a
        public j0.n.a f(String s) {
            if(s == null) {
                throw new NullPointerException("Null transportName");
            }
            this.b = s;
            return this;
        }
    }

    private final o a;
    private final String b;
    private final h0.c c;
    private final e d;
    private final h0.b e;

    private c(o o0, String s, h0.c c0, e e0, h0.b b0) {
        this.a = o0;
        this.b = s;
        this.c = c0;
        this.d = e0;
        this.e = b0;
    }

    c(o o0, String s, h0.c c0, e e0, h0.b b0, a c$a0) {
        this(o0, s, c0, e0, b0);
    }

    @Override  // j0.n
    public h0.b b() {
        return this.e;
    }

    @Override  // j0.n
    h0.c c() {
        return this.c;
    }

    @Override  // j0.n
    e e() {
        return this.d;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof n) {
            o o0 = ((n)object0).f();
            if(this.a.equals(o0)) {
                String s = ((n)object0).g();
                if(this.b.equals(s)) {
                    h0.c c0 = ((n)object0).c();
                    if(this.c.equals(c0)) {
                        e e0 = ((n)object0).e();
                        if(this.d.equals(e0)) {
                            h0.b b0 = ((n)object0).b();
                            return this.e.equals(b0);
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override  // j0.n
    public o f() {
        return this.a;
    }

    @Override  // j0.n
    public String g() {
        return this.b;
    }

    @Override
    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode()) * 1000003 ^ this.d.hashCode()) * 1000003 ^ this.e.hashCode();
    }

    @Override
    public String toString() {
        return "SendRequest{transportContext=" + this.a + ", transportName=" + this.b + ", event=" + this.c + ", transformer=" + this.d + ", encoding=" + this.e + "}";
    }
}

