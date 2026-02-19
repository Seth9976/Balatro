package d3;

import k3.f;

public interface d extends b {
    public static abstract class a {
        public static b a(d d0, c e$c0) {
            f.e(e$c0, "key");
            if(e$c0 instanceof d3.b) {
                if(((d3.b)e$c0).a(d0.getKey())) {
                    b e$b0 = ((d3.b)e$c0).b(d0);
                    return e$b0 instanceof b ? e$b0 : null;
                }
                return null;
            }
            if(d.b == e$c0) {
                f.c(d0, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return d0;
            }
            return null;
        }

        public static e b(d d0, c e$c0) {
            f.e(e$c0, "key");
            if(e$c0 instanceof d3.b) {
                return ((d3.b)e$c0).a(d0.getKey()) && ((d3.b)e$c0).b(d0) != null ? d3.f.e : d0;
            }
            return d.b == e$c0 ? d3.f.e : d0;
        }
    }

    public static final class d3.d.b implements c {
        static final d3.d.b a;

        static {
            d3.d.b.a = new d3.d.b();
        }
    }

    public static final d3.d.b b;

    static {
        d.b = d3.d.b.a;
    }
}

