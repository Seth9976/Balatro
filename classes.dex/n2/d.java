package n2;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import p2.g;
import q2.e;
import q2.h;
import q2.i;
import q2.j;
import q2.k;
import q2.m;
import v2.a;
import v2.c;

public final class d {
    static class f extends k {
        private r a;

        f() {
            this.a = null;
        }

        @Override  // n2.r
        public Object b(a a0) {
            return this.f().b(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f().d(c0, object0);
        }

        @Override  // q2.k
        public r e() {
            return this.f();
        }

        private r f() {
            r r0 = this.a;
            if(r0 == null) {
                throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
            }
            return r0;
        }

        public void g(r r0) {
            if(this.a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.a = r0;
        }
    }

    static final n2.c A;
    static final q B;
    static final q C;
    private final ThreadLocal a;
    private final ConcurrentMap b;
    private final p2.c c;
    private final e d;
    final List e;
    final p2.d f;
    final n2.c g;
    final Map h;
    final boolean i;
    final boolean j;
    final boolean k;
    final boolean l;
    final boolean m;
    final boolean n;
    final boolean o;
    final boolean p;
    final String q;
    final int r;
    final int s;
    final n t;
    final List u;
    final List v;
    final q w;
    final q x;
    final List y;
    static final String z;

    static {
        d.A = b.e;
        d.B = p.e;
        d.C = p.f;
    }

    public d() {
        Map map0 = Collections.emptyMap();
        List list0 = Collections.emptyList();
        List list1 = Collections.emptyList();
        List list2 = Collections.emptyList();
        List list3 = Collections.emptyList();
        this(p2.d.k, d.A, map0, false, false, false, true, false, false, false, true, n.e, d.z, 2, 2, list0, list1, list2, d.B, d.C, list3);
    }

    d(p2.d d0, n2.c c0, Map map0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, n n0, String s, int v, int v1, List list0, List list1, List list2, q q0, q q1, List list3) {
        this.a = new ThreadLocal();
        this.b = new ConcurrentHashMap();
        this.f = d0;
        this.g = c0;
        this.h = map0;
        p2.c c1 = new p2.c(map0, z7, list3);
        this.c = c1;
        this.i = z;
        this.j = z1;
        this.k = z2;
        this.l = z3;
        this.m = z4;
        this.n = z5;
        this.o = z6;
        this.p = z7;
        this.t = n0;
        this.q = s;
        this.r = v;
        this.s = v1;
        this.u = list0;
        this.v = list1;
        this.w = q0;
        this.x = q1;
        this.y = list3;
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(m.W);
        arrayList0.add(i.e(q0));
        arrayList0.add(d0);
        arrayList0.addAll(list2);
        arrayList0.add(m.C);
        arrayList0.add(m.m);
        arrayList0.add(m.g);
        arrayList0.add(m.i);
        arrayList0.add(m.k);
        r r0 = d.n(n0);
        arrayList0.add(m.a(Long.TYPE, Long.class, r0));
        Class class0 = Double.TYPE;
        r r1 = this.e(z6);
        arrayList0.add(m.a(class0, Double.class, r1));
        Class class1 = Float.TYPE;
        r r2 = this.f(z6);
        arrayList0.add(m.a(class1, Float.class, r2));
        arrayList0.add(h.e(q1));
        arrayList0.add(m.o);
        arrayList0.add(m.q);
        r r3 = d.b(r0);
        arrayList0.add(m.b(AtomicLong.class, r3));
        r r4 = d.c(r0);
        arrayList0.add(m.b(AtomicLongArray.class, r4));
        arrayList0.add(m.s);
        arrayList0.add(m.x);
        arrayList0.add(m.E);
        arrayList0.add(m.G);
        arrayList0.add(m.b(BigDecimal.class, m.z));
        arrayList0.add(m.b(BigInteger.class, m.A));
        arrayList0.add(m.b(g.class, m.B));
        arrayList0.add(m.I);
        arrayList0.add(m.K);
        arrayList0.add(m.O);
        arrayList0.add(m.Q);
        arrayList0.add(m.U);
        arrayList0.add(m.M);
        arrayList0.add(m.d);
        arrayList0.add(q2.c.b);
        arrayList0.add(m.S);
        if(t2.d.a) {
            arrayList0.add(t2.d.e);
            arrayList0.add(t2.d.d);
            arrayList0.add(t2.d.f);
        }
        arrayList0.add(q2.a.c);
        arrayList0.add(m.b);
        arrayList0.add(new q2.b(c1));
        arrayList0.add(new q2.g(c1, z1));
        e e0 = new e(c1);
        this.d = e0;
        arrayList0.add(e0);
        arrayList0.add(m.X);
        arrayList0.add(new j(c1, c0, d0, e0, list3));
        this.e = Collections.unmodifiableList(arrayList0);
    }

    private static void a(Object object0, a a0) {
        if(object0 == null) {
            return;
        }
        else {
            try {
                if(a0.E() != v2.b.n) {
                    throw new n2.m("JSON document was not fully consumed.");
                }
                return;
            }
            catch(v2.d d0) {
            }
            catch(IOException iOException0) {
                throw new n2.h(iOException0);
            }
        }
        throw new n2.m(d0);
    }

    private static r b(r r0) {
        class n2.d.d extends r {
            final r a;

            n2.d.d(r r0) {
            }

            @Override  // n2.r
            public Object b(a a0) {
                return this.e(a0);
            }

            @Override  // n2.r
            public void d(c c0, Object object0) {
                this.f(c0, ((AtomicLong)object0));
            }

            public AtomicLong e(a a0) {
                return new AtomicLong(((Number)this.a.b(a0)).longValue());
            }

            public void f(c c0, AtomicLong atomicLong0) {
                Long long0 = atomicLong0.get();
                this.a.d(c0, long0);
            }
        }

        return new n2.d.d(r0).a();
    }

    private static r c(r r0) {
        class n2.d.e extends r {
            final r a;

            n2.d.e(r r0) {
            }

            @Override  // n2.r
            public Object b(a a0) {
                return this.e(a0);
            }

            @Override  // n2.r
            public void d(c c0, Object object0) {
                this.f(c0, ((AtomicLongArray)object0));
            }

            public AtomicLongArray e(a a0) {
                ArrayList arrayList0 = new ArrayList();
                a0.a();
                while(a0.l()) {
                    arrayList0.add(((Number)this.a.b(a0)).longValue());
                }
                a0.f();
                int v = arrayList0.size();
                AtomicLongArray atomicLongArray0 = new AtomicLongArray(v);
                for(int v1 = 0; v1 < v; ++v1) {
                    atomicLongArray0.set(v1, ((long)(((Long)arrayList0.get(v1)))));
                }
                return atomicLongArray0;
            }

            public void f(c c0, AtomicLongArray atomicLongArray0) {
                c0.c();
                int v = atomicLongArray0.length();
                for(int v1 = 0; v1 < v; ++v1) {
                    Long long0 = atomicLongArray0.get(v1);
                    this.a.d(c0, long0);
                }
                c0.f();
            }
        }

        return new n2.d.e(r0).a();
    }

    static void d(double f) {
        if(Double.isNaN(f) || Double.isInfinite(f)) {
            throw new IllegalArgumentException(f + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private r e(boolean z) {
        class n2.d.a extends r {
            final d a;

            @Override  // n2.r
            public Object b(a a0) {
                return this.e(a0);
            }

            @Override  // n2.r
            public void d(c c0, Object object0) {
                this.f(c0, ((Number)object0));
            }

            public Double e(a a0) {
                if(a0.E() == v2.b.m) {
                    a0.y();
                    return null;
                }
                return a0.r();
            }

            public void f(c c0, Number number0) {
                if(number0 == null) {
                    c0.n();
                    return;
                }
                double f = number0.doubleValue();
                d.d(f);
                c0.B(f);
            }
        }

        return z ? m.v : new n2.d.a(this);
    }

    private r f(boolean z) {
        class n2.d.b extends r {
            final d a;

            @Override  // n2.r
            public Object b(a a0) {
                return this.e(a0);
            }

            @Override  // n2.r
            public void d(c c0, Object object0) {
                this.f(c0, ((Number)object0));
            }

            public Float e(a a0) {
                if(a0.E() == v2.b.m) {
                    a0.y();
                    return null;
                }
                return (float)a0.r();
            }

            public void f(c c0, Number number0) {
                if(number0 == null) {
                    c0.n();
                    return;
                }
                float f = number0.floatValue();
                d.d(f);
                if(!(number0 instanceof Float)) {
                    number0 = f;
                }
                c0.F(number0);
            }
        }

        return z ? m.u : new n2.d.b(this);
    }

    public Object g(Reader reader0, u2.a a0) {
        a a1 = this.o(reader0);
        Object object0 = this.j(a1, a0);
        d.a(object0, a1);
        return object0;
    }

    public Object h(String s, Class class0) {
        return p2.k.b(class0).cast(this.i(s, u2.a.a(class0)));
    }

    public Object i(String s, u2.a a0) {
        return s == null ? null : this.g(new StringReader(s), a0);
    }

    public Object j(a a0, u2.a a1) {
        boolean z = a0.m();
        boolean z1 = true;
        a0.L(true);
        try {
            a0.E();
            z1 = false;
            return this.l(a1).b(a0);
        }
        catch(EOFException eOFException0) {
            if(!z1) {
                throw new n2.m(eOFException0);
            }
            return null;
        }
        catch(IllegalStateException illegalStateException0) {
            throw new n2.m(illegalStateException0);
        }
        catch(IOException iOException0) {
            throw new n2.m(iOException0);
        }
        catch(AssertionError assertionError0) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + assertionError0.getMessage(), assertionError0);
        }
        finally {
            a0.L(z);
        }
    }

    public r k(Class class0) {
        return this.l(u2.a.a(class0));
    }

    public r l(u2.a a0) {
        r r2;
        boolean z;
        Objects.requireNonNull(a0, "type must not be null");
        r r0 = (r)this.b.get(a0);
        if(r0 != null) {
            return r0;
        }
        Map map0 = (Map)this.a.get();
        if(map0 == null) {
            map0 = new HashMap();
            this.a.set(map0);
            z = true;
        }
        else {
            r r1 = (r)map0.get(a0);
            if(r1 != null) {
                return r1;
            }
            z = false;
        }
        try {
            f d$f0 = new f();
            map0.put(a0, d$f0);
            r2 = null;
            for(Object object0: this.e) {
                r2 = ((s)object0).a(this, a0);
                if(r2 != null) {
                    d$f0.g(r2);
                    map0.put(a0, r2);
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        finally {
            if(z) {
                this.a.remove();
            }
        }
        if(r2 == null) {
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + a0);
        }
        if(z) {
            this.b.putAll(map0);
        }
        return r2;
    }

    public r m(s s0, u2.a a0) {
        if(!this.e.contains(s0)) {
            s0 = this.d;
        }
        boolean z = false;
        for(Object object0: this.e) {
            s s1 = (s)object0;
            if(z) {
                r r0 = s1.a(this, a0);
                if(r0 != null) {
                    return r0;
                }
                if(false) {
                    break;
                }
            }
            else {
                if(s1 != s0) {
                    continue;
                }
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + a0);
    }

    private static r n(n n0) {
        class n2.d.c extends r {
            n2.d.c() {
                super();
            }

            @Override  // n2.r
            public Object b(a a0) {
                return this.e(a0);
            }

            @Override  // n2.r
            public void d(c c0, Object object0) {
                this.f(c0, ((Number)object0));
            }

            public Number e(a a0) {
                if(a0.E() == v2.b.m) {
                    a0.y();
                    return null;
                }
                return a0.u();
            }

            public void f(c c0, Number number0) {
                if(number0 == null) {
                    c0.n();
                    return;
                }
                c0.G(number0.toString());
            }
        }

        return n0 == n.e ? m.t : new n2.d.c();
    }

    public a o(Reader reader0) {
        a a0 = new a(reader0);
        a0.L(this.n);
        return a0;
    }

    public c p(Writer writer0) {
        if(this.k) {
            writer0.write(")]}\'\n");
        }
        c c0 = new c(writer0);
        if(this.m) {
            c0.v("  ");
        }
        c0.u(this.l);
        c0.w(this.n);
        c0.y(this.i);
        return c0;
    }

    // 去混淆评级： 低(30)
    public String q(Object object0) {
        return object0 == null ? "null" : this.r(object0, object0.getClass());
    }

    public String r(Object object0, Type type0) {
        StringWriter stringWriter0 = new StringWriter();
        this.t(object0, type0, stringWriter0);
        return stringWriter0.toString();
    }

    public String s(n2.g g0) [...] // 潜在的解密器

    public void t(Object object0, Type type0, Appendable appendable0) {
        try {
            this.u(object0, type0, this.p(p2.m.b(appendable0)));
        }
        catch(IOException iOException0) {
            throw new n2.h(iOException0);
        }
    }

    @Override
    public String toString() {
        return "{serializeNulls:" + this.i + ",factories:" + this.e + ",instanceCreators:" + this.c + "}";
    }

    public void u(Object object0, Type type0, c c0) {
        r r0 = this.l(u2.a.b(type0));
        boolean z = c0.j();
        c0.w(true);
        boolean z1 = c0.i();
        c0.u(this.l);
        boolean z2 = c0.h();
        c0.y(this.i);
        try {
            r0.d(c0, object0);
        }
        catch(IOException iOException0) {
            throw new n2.h(iOException0);
        }
        catch(AssertionError assertionError0) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + assertionError0.getMessage(), assertionError0);
        }
        finally {
            c0.w(z);
            c0.u(z1);
            c0.y(z2);
        }
    }

    public void v(n2.g g0, Appendable appendable0) {
        try {
            this.w(g0, this.p(p2.m.b(appendable0)));
        }
        catch(IOException iOException0) {
            throw new n2.h(iOException0);
        }
    }

    public void w(n2.g g0, c c0) {
        boolean z = c0.j();
        c0.w(true);
        boolean z1 = c0.i();
        c0.u(this.l);
        boolean z2 = c0.h();
        c0.y(this.i);
        try {
            p2.m.a(g0, c0);
        }
        catch(IOException iOException0) {
            throw new n2.h(iOException0);
        }
        catch(AssertionError assertionError0) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + assertionError0.getMessage(), assertionError0);
        }
        finally {
            c0.w(z);
            c0.u(z1);
            c0.y(z2);
        }
    }
}

