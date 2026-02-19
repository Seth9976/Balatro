package j0;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class i {
    public static abstract class a {
        public final a a(String s, int v) {
            this.e().put(s, String.valueOf(v));
            return this;
        }

        public final a b(String s, long v) {
            this.e().put(s, String.valueOf(v));
            return this;
        }

        public final a c(String s, String s1) {
            this.e().put(s, s1);
            return this;
        }

        public abstract i d();

        protected abstract Map e();

        protected abstract a f(Map arg1);

        public abstract a g(Integer arg1);

        public abstract a h(h arg1);

        public abstract a i(long arg1);

        public abstract a j(String arg1);

        public abstract a k(long arg1);
    }

    public static a a() {
        return new b().f(new HashMap());
    }

    public final String b(String s) {
        String s1 = (String)this.c().get(s);
        return s1 == null ? "" : s1;
    }

    protected abstract Map c();

    public abstract Integer d();

    public abstract h e();

    public abstract long f();

    public final int g(String s) {
        String s1 = (String)this.c().get(s);
        return s1 == null ? 0 : ((int)Integer.valueOf(s1));
    }

    public final long h(String s) {
        String s1 = (String)this.c().get(s);
        return s1 == null ? 0L : ((long)Long.valueOf(s1));
    }

    public final Map i() {
        return Collections.unmodifiableMap(this.c());
    }

    public abstract String j();

    public abstract long k();

    public a l() {
        return new b().j(this.j()).g(this.d()).h(this.e()).i(this.f()).k(this.k()).f(new HashMap(this.c()));
    }
}

