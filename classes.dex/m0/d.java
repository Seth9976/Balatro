package m0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d {
    public static final class a {
        private String a;
        private List b;

        a() {
            this.a = "";
            this.b = new ArrayList();
        }

        public d a() {
            return new d(this.a, Collections.unmodifiableList(this.b));
        }

        public a b(List list0) {
            this.b = list0;
            return this;
        }

        public a c(String s) {
            this.a = s;
            return this;
        }
    }

    private final String a;
    private final List b;
    private static final d c;

    static {
        d.c = new a().a();
    }

    d(String s, List list0) {
        this.a = s;
        this.b = list0;
    }

    public List a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public static a c() {
        return new a();
    }
}

