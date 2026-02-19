package q2;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Map;
import n2.d;
import n2.m;
import n2.r;
import n2.s;
import p2.f;
import p2.i;
import v2.b;
import v2.c;

public final class g implements s {
    final class a extends r {
        private final r a;
        private final r b;
        private final i c;
        final g d;

        public a(d d0, Type type0, r r0, Type type1, r r1, i i0) {
            this.a = new l(d0, r0, type0);
            this.b = new l(d0, r1, type1);
            this.c = i0;
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.f(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.g(c0, ((Map)object0));
        }

        // 去混淆评级： 中等(90)
        private String e(n2.g g0) {
            throw new AssertionError();
        }

        public Map f(v2.a a0) {
            b b0 = a0.E();
            if(b0 == b.m) {
                a0.y();
                return null;
            }
            Map map0 = (Map)this.c.a();
            if(b0 == b.e) {
                a0.a();
                while(a0.l()) {
                    a0.a();
                    Object object0 = this.a.b(a0);
                    if(map0.put(object0, this.b.b(a0)) != null) {
                        throw new m("duplicate key: " + object0);
                    }
                    a0.f();
                }
                a0.f();
                return map0;
            }
            a0.b();
            while(a0.l()) {
                f.a.a(a0);
                Object object1 = this.a.b(a0);
                if(map0.put(object1, this.b.b(a0)) != null) {
                    throw new m("duplicate key: " + object1);
                }
                if(false) {
                    break;
                }
            }
            a0.g();
            return map0;
        }

        public void g(c c0, Map map0) {
            if(map0 == null) {
                c0.n();
                return;
            }
            if(!g.this.f) {
                c0.d();
                for(Object object0: map0.entrySet()) {
                    c0.l(String.valueOf(((Map.Entry)object0).getKey()));
                    Object object1 = ((Map.Entry)object0).getValue();
                    this.b.d(c0, object1);
                }
                c0.g();
                return;
            }
            ArrayList arrayList0 = new ArrayList(map0.size());
            ArrayList arrayList1 = new ArrayList(map0.size());
            for(Object object2: map0.entrySet()) {
                Object object3 = ((Map.Entry)object2).getKey();
                arrayList0.add(this.a.c(object3));
                arrayList1.add(((Map.Entry)object2).getValue());
            }
            c0.d();
            int v1 = arrayList0.size();
            for(int v = 0; v < v1; ++v) {
                c0.l(this.e(((n2.g)arrayList0.get(v))));
                Object object4 = arrayList1.get(v);
                this.b.d(c0, object4);
            }
            c0.g();
        }
    }

    private final p2.c e;
    final boolean f;

    public g(p2.c c0, boolean z) {
        this.e = c0;
        this.f = z;
    }

    @Override  // n2.s
    public r a(d d0, u2.a a0) {
        Type type0 = a0.d();
        Class class0 = a0.c();
        if(!Map.class.isAssignableFrom(class0)) {
            return null;
        }
        Type[] arr_type = p2.b.j(type0, class0);
        r r0 = this.b(d0, arr_type[0]);
        r r1 = d0.l(u2.a.b(arr_type[1]));
        i i0 = this.e.b(a0);
        return new a(this, d0, arr_type[0], r0, arr_type[1], r1, i0);
    }

    private r b(d d0, Type type0) {
        return type0 == Boolean.TYPE || type0 == Boolean.class ? q2.m.f : d0.l(u2.a.b(type0));
    }
}

