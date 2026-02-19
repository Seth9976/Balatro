package i0;

final class c extends a {
    static abstract class i0.c.a {
    }

    static final class b extends i0.a.a {
        private Integer a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String k;
        private String l;

        @Override  // i0.a$a
        public a a() {
            return new c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, null);
        }

        @Override  // i0.a$a
        public i0.a.a b(String s) {
            this.l = s;
            return this;
        }

        @Override  // i0.a$a
        public i0.a.a c(String s) {
            this.j = s;
            return this;
        }

        @Override  // i0.a$a
        public i0.a.a d(String s) {
            this.d = s;
            return this;
        }

        @Override  // i0.a$a
        public i0.a.a e(String s) {
            this.h = s;
            return this;
        }

        @Override  // i0.a$a
        public i0.a.a f(String s) {
            this.c = s;
            return this;
        }

        @Override  // i0.a$a
        public i0.a.a g(String s) {
            this.i = s;
            return this;
        }

        @Override  // i0.a$a
        public i0.a.a h(String s) {
            this.g = s;
            return this;
        }

        @Override  // i0.a$a
        public i0.a.a i(String s) {
            this.k = s;
            return this;
        }

        @Override  // i0.a$a
        public i0.a.a j(String s) {
            this.b = s;
            return this;
        }

        @Override  // i0.a$a
        public i0.a.a k(String s) {
            this.f = s;
            return this;
        }

        @Override  // i0.a$a
        public i0.a.a l(String s) {
            this.e = s;
            return this;
        }

        @Override  // i0.a$a
        public i0.a.a m(Integer integer0) {
            this.a = integer0;
            return this;
        }
    }

    private final Integer a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;

    private c(Integer integer0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10) {
        this.a = integer0;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = s3;
        this.f = s4;
        this.g = s5;
        this.h = s6;
        this.i = s7;
        this.j = s8;
        this.k = s9;
        this.l = s10;
    }

    c(Integer integer0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, i0.c.a c$a0) {
        this(integer0, s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10);
    }

    @Override  // i0.a
    public String b() {
        return this.l;
    }

    @Override  // i0.a
    public String c() {
        return this.j;
    }

    @Override  // i0.a
    public String d() {
        return this.d;
    }

    @Override  // i0.a
    public String e() {
        return this.h;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof a) {
            a a0 = (a)object0;
            Integer integer0 = this.a;
            if(integer0 != null) {
                if(integer0.equals(a0.m())) {
                label_9:
                    String s = this.b;
                    if(s != null) {
                        if(s.equals(a0.j())) {
                        label_14:
                            String s1 = this.c;
                            if(s1 != null) {
                                if(s1.equals(a0.f())) {
                                label_19:
                                    String s2 = this.d;
                                    if(s2 != null) {
                                        if(s2.equals(a0.d())) {
                                        label_24:
                                            String s3 = this.e;
                                            if(s3 != null) {
                                                if(s3.equals(a0.l())) {
                                                label_29:
                                                    String s4 = this.f;
                                                    if(s4 != null) {
                                                        if(s4.equals(a0.k())) {
                                                        label_34:
                                                            String s5 = this.g;
                                                            if(s5 != null) {
                                                                if(s5.equals(a0.h())) {
                                                                label_39:
                                                                    String s6 = this.h;
                                                                    if(s6 != null) {
                                                                        if(s6.equals(a0.e())) {
                                                                        label_44:
                                                                            String s7 = this.i;
                                                                            if(s7 != null) {
                                                                                if(s7.equals(a0.g())) {
                                                                                label_49:
                                                                                    String s8 = this.j;
                                                                                    if(s8 != null) {
                                                                                        if(s8.equals(a0.c())) {
                                                                                        label_54:
                                                                                            String s9 = this.k;
                                                                                            if(s9 != null) {
                                                                                                if(s9.equals(a0.i())) {
                                                                                                label_59:
                                                                                                    String s10 = a0.b();
                                                                                                    return this.l == null ? s10 == null : this.l.equals(s10);
                                                                                                }
                                                                                            }
                                                                                            else if(a0.i() == null) {
                                                                                                goto label_59;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    else if(a0.c() == null) {
                                                                                        goto label_54;
                                                                                    }
                                                                                }
                                                                            }
                                                                            else if(a0.g() == null) {
                                                                                goto label_49;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if(a0.e() == null) {
                                                                        goto label_44;
                                                                    }
                                                                }
                                                            }
                                                            else if(a0.h() == null) {
                                                                goto label_39;
                                                            }
                                                        }
                                                    }
                                                    else if(a0.k() == null) {
                                                        goto label_34;
                                                    }
                                                }
                                            }
                                            else if(a0.l() == null) {
                                                goto label_29;
                                            }
                                        }
                                    }
                                    else if(a0.d() == null) {
                                        goto label_24;
                                    }
                                }
                            }
                            else if(a0.f() == null) {
                                goto label_19;
                            }
                        }
                    }
                    else if(a0.j() == null) {
                        goto label_14;
                    }
                }
            }
            else if(a0.m() == null) {
                goto label_9;
            }
            return false;
        }
        return false;
    }

    @Override  // i0.a
    public String f() {
        return this.c;
    }

    @Override  // i0.a
    public String g() {
        return this.i;
    }

    @Override  // i0.a
    public String h() {
        return this.g;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        int v5 = this.e == null ? 0 : this.e.hashCode();
        int v6 = this.f == null ? 0 : this.f.hashCode();
        int v7 = this.g == null ? 0 : this.g.hashCode();
        int v8 = this.h == null ? 0 : this.h.hashCode();
        int v9 = this.i == null ? 0 : this.i.hashCode();
        int v10 = this.j == null ? 0 : this.j.hashCode();
        int v11 = this.k == null ? 0 : this.k.hashCode();
        String s = this.l;
        if(s != null) {
            v = s.hashCode();
        }
        return (((((((((((v1 ^ 1000003) * 1000003 ^ v2) * 1000003 ^ v3) * 1000003 ^ v4) * 1000003 ^ v5) * 1000003 ^ v6) * 1000003 ^ v7) * 1000003 ^ v8) * 1000003 ^ v9) * 1000003 ^ v10) * 1000003 ^ v11) * 1000003 ^ v;
    }

    @Override  // i0.a
    public String i() {
        return this.k;
    }

    @Override  // i0.a
    public String j() {
        return this.b;
    }

    @Override  // i0.a
    public String k() {
        return this.f;
    }

    @Override  // i0.a
    public String l() {
        return this.e;
    }

    @Override  // i0.a
    public Integer m() {
        return this.a;
    }

    @Override
    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.a + ", model=" + this.b + ", hardware=" + this.c + ", device=" + this.d + ", product=" + this.e + ", osBuild=" + this.f + ", manufacturer=" + this.g + ", fingerprint=" + this.h + ", locale=" + this.i + ", country=" + this.j + ", mccMnc=" + this.k + ", applicationBuild=" + this.l + "}";
    }
}

