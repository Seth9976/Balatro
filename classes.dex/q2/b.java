package q2;

import java.lang.reflect.Type;
import java.util.Collection;
import n2.d;
import n2.r;
import n2.s;
import p2.i;
import v2.c;

public final class b implements s {
    static final class a extends r {
        private final r a;
        private final i b;

        public a(d d0, Type type0, r r0, i i0) {
            this.a = new l(d0, r0, type0);
            this.b = i0;
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((Collection)object0));
        }

        public Collection e(v2.a a0) {
            if(a0.E() == v2.b.m) {
                a0.y();
                return null;
            }
            Collection collection0 = (Collection)this.b.a();
            a0.a();
            while(a0.l()) {
                collection0.add(this.a.b(a0));
            }
            a0.f();
            return collection0;
        }

        public void f(c c0, Collection collection0) {
            if(collection0 == null) {
                c0.n();
                return;
            }
            c0.c();
            for(Object object0: collection0) {
                this.a.d(c0, object0);
            }
            c0.f();
        }
    }

    private final p2.c e;

    public b(p2.c c0) {
        this.e = c0;
    }

    @Override  // n2.s
    public r a(d d0, u2.a a0) {
        Type type0 = a0.d();
        Class class0 = a0.c();
        if(!Collection.class.isAssignableFrom(class0)) {
            return null;
        }
        Type type1 = p2.b.h(type0, class0);
        return new a(d0, type1, d0.l(u2.a.b(type1)), this.e.b(a0));
    }
}

