package d3;

import j3.p;
import k3.f;
import k3.g;

public interface e {
    public static abstract class a {
        public static e a(e e0, e e1) {
            static final class d3.e.a.a extends g implements p {
                public static final d3.e.a.a f;

                static {
                    d3.e.a.a.f = new d3.e.a.a();
                }

                d3.e.a.a() {
                    super(2);
                }

                @Override  // j3.p
                public Object b(Object object0, Object object1) {
                    return this.d(((e)object0), ((b)object1));
                }

                public final e d(e e0, b e$b0) {
                    f.e(e0, "acc");
                    f.e(e$b0, "element");
                    e e1 = e0.minusKey(e$b0.getKey());
                    d3.f f0 = d3.f.e;
                    if(e1 != f0) {
                        d3.d.b d$b0 = d.b;
                        d d0 = (d)e1.get(d$b0);
                        if(d0 == null) {
                            return new c(e1, e$b0);
                        }
                        e e2 = e1.minusKey(d$b0);
                        return e2 == f0 ? new c(e$b0, d0) : new c(new c(e2, e$b0), d0);
                    }
                    return e$b0;
                }
            }

            f.e(e1, "context");
            return e1 == d3.f.e ? e0 : ((e)e1.fold(e0, d3.e.a.a.f));
        }
    }

    public interface b extends e {
        public static abstract class d3.e.b.a {
            public static Object a(b e$b0, Object object0, p p0) {
                f.e(p0, "operation");
                return p0.b(object0, e$b0);
            }

            public static b b(b e$b0, d3.e.c e$c0) {
                f.e(e$c0, "key");
                if(f.a(e$b0.getKey(), e$c0)) {
                    f.c(e$b0, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                    return e$b0;
                }
                return null;
            }

            public static e c(b e$b0, d3.e.c e$c0) {
                f.e(e$c0, "key");
                return f.a(e$b0.getKey(), e$c0) ? d3.f.e : e$b0;
            }

            public static e d(b e$b0, e e0) {
                f.e(e0, "context");
                return a.a(e$b0, e0);
            }
        }

        @Override  // d3.e
        b get(d3.e.c arg1);

        d3.e.c getKey();
    }

    public interface d3.e.c {
    }

    Object fold(Object arg1, p arg2);

    b get(d3.e.c arg1);

    e minusKey(d3.e.c arg1);
}

