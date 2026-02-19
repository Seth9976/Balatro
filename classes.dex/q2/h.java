package q2;

import n2.d;
import n2.m;
import n2.p;
import n2.q;
import n2.r;
import n2.s;
import v2.a;
import v2.c;

public final class h extends r {
    static abstract class b {
        static final int[] a;

        static {
            int[] arr_v = new int[v2.b.values().length];
            b.a = arr_v;
            try {
                arr_v[v2.b.m.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[v2.b.k.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[v2.b.j.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

    private final q a;
    private static final s b;

    static {
        h.b = h.f(p.f);
    }

    private h(q q0) {
        this.a = q0;
    }

    @Override  // n2.r
    public Object b(a a0) {
        return this.g(a0);
    }

    @Override  // n2.r
    public void d(c c0, Object object0) {
        this.h(c0, ((Number)object0));
    }

    public static s e(q q0) {
        return q0 == p.f ? h.b : h.f(q0);
    }

    private static s f(q q0) {
        class q2.h.a implements s {
            final h e;

            @Override  // n2.s
            public r a(d d0, u2.a a0) {
                return a0.c() == Number.class ? h.this : null;
            }
        }

        return new q2.h.a(new h(q0));
    }

    public Number g(a a0) {
        v2.b b0 = a0.E();
        switch(b0) {
            case 1: {
                a0.y();
                return null;
            }
            case 2: 
            case 3: {
                return this.a.c(a0);
            }
            default: {
                throw new m("Expecting number, got: " + b0 + "; at path " + a0.i());
            }
        }
    }

    public void h(c c0, Number number0) {
        c0.F(number0);
    }
}

