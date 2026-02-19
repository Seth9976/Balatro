package q2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import n2.d;
import n2.p;
import n2.q;
import n2.r;
import n2.s;
import p2.h;
import v2.c;

public final class i extends r {
    static abstract class b {
        static final int[] a;

        static {
            int[] arr_v = new int[v2.b.values().length];
            b.a = arr_v;
            try {
                arr_v[v2.b.e.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[v2.b.g.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[v2.b.j.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[v2.b.k.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[v2.b.l.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[v2.b.m.ordinal()] = 6;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

    private final d a;
    private final q b;
    private static final s c;

    static {
        i.c = i.f(p.e);
    }

    private i(d d0, q q0) {
        this.a = d0;
        this.b = q0;
    }

    i(d d0, q q0, a i$a0) {
        this(d0, q0);
    }

    @Override  // n2.r
    public Object b(v2.a a0) {
        v2.b b0 = a0.E();
        Object object0 = this.h(a0, b0);
        if(object0 == null) {
            return this.g(a0, b0);
        }
        ArrayDeque arrayDeque0 = new ArrayDeque();
        while(true) {
            if(a0.l()) {
                String s = object0 instanceof Map ? a0.v() : null;
                v2.b b1 = a0.E();
                Object object1 = this.h(a0, b1);
                boolean z = object1 != null;
                if(object1 == null) {
                    object1 = this.g(a0, b1);
                }
                if(object0 instanceof List) {
                    ((List)object0).add(object1);
                }
                else {
                    ((Map)object0).put(s, object1);
                }
                if(!z) {
                    continue;
                }
                arrayDeque0.addLast(object0);
                object0 = object1;
            }
            else {
                if(object0 instanceof List) {
                    a0.f();
                }
                else {
                    a0.g();
                }
                if(arrayDeque0.isEmpty()) {
                    break;
                }
                object0 = arrayDeque0.removeLast();
            }
        }
        return object0;
    }

    @Override  // n2.r
    public void d(c c0, Object object0) {
        if(object0 == null) {
            c0.n();
            return;
        }
        Class class0 = object0.getClass();
        r r0 = this.a.k(class0);
        if(r0 instanceof i) {
            c0.d();
            c0.g();
            return;
        }
        r0.d(c0, object0);
    }

    public static s e(q q0) {
        return q0 == p.e ? i.c : i.f(q0);
    }

    private static s f(q q0) {
        class a implements s {
            final q e;

            a(q q0) {
            }

            @Override  // n2.s
            public r a(d d0, u2.a a0) {
                return a0.c() == Object.class ? new i(d0, this.e, null) : null;
            }
        }

        return new a(q0);
    }

    private Object g(v2.a a0, v2.b b0) {
        switch(b0) {
            case 3: {
                return a0.B();
            }
            case 4: {
                return this.b.c(a0);
            }
            case 5: {
                return Boolean.valueOf(a0.q());
            }
            case 6: {
                a0.y();
                return null;
            }
            default: {
                throw new IllegalStateException("Unexpected token: " + b0);
            }
        }
    }

    private Object h(v2.a a0, v2.b b0) {
        switch(b0) {
            case 1: {
                a0.a();
                return new ArrayList();
            }
            case 2: {
                a0.b();
                return new h();
            }
            default: {
                return null;
            }
        }
    }
}

