package m0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a {
    public static final class m0.a.a {
        private f a;
        private List b;
        private b c;
        private String d;

        m0.a.a() {
            this.a = null;
            this.b = new ArrayList();
            this.c = null;
            this.d = "";
        }

        public m0.a.a a(d d0) {
            this.b.add(d0);
            return this;
        }

        public a b() {
            return new a(this.a, Collections.unmodifiableList(this.b), this.c, this.d);
        }

        public m0.a.a c(String s) {
            this.d = s;
            return this;
        }

        public m0.a.a d(b b0) {
            this.c = b0;
            return this;
        }

        public m0.a.a e(f f0) {
            this.a = f0;
            return this;
        }
    }

    private final f a;
    private final List b;
    private final b c;
    private final String d;
    private static final a e;

    static {
        a.e = new m0.a.a().b();
    }

    a(f f0, List list0, b b0, String s) {
        this.a = f0;
        this.b = list0;
        this.c = b0;
        this.d = s;
    }

    public String a() {
        return this.d;
    }

    public b b() {
        return this.c;
    }

    public List c() {
        return this.b;
    }

    public f d() {
        return this.a;
    }

    public static m0.a.a e() {
        return new m0.a.a();
    }

    public byte[] f() [...] // 潜在的解密器
}

