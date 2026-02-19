package q2;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import n2.d;
import n2.r;
import n2.s;
import p2.b;
import v2.c;

public final class a extends r {
    class q2.a.a implements s {
        q2.a.a() {
            super();
        }

        @Override  // n2.s
        public r a(d d0, u2.a a0) {
            Type type0 = a0.d();
            if(!(type0 instanceof GenericArrayType) && (!(type0 instanceof Class) || !((Class)type0).isArray())) {
                return null;
            }
            Type type1 = b.g(type0);
            return new a(d0, d0.l(u2.a.b(type1)), b.k(type1));
        }
    }

    private final Class a;
    private final r b;
    public static final s c;

    static {
        a.c = new q2.a.a();
    }

    public a(d d0, r r0, Class class0) {
        this.b = new l(d0, r0, class0);
        this.a = class0;
    }

    @Override  // n2.r
    public Object b(v2.a a0) {
        if(a0.E() == v2.b.m) {
            a0.y();
            return null;
        }
        ArrayList arrayList0 = new ArrayList();
        a0.a();
        while(a0.l()) {
            arrayList0.add(this.b.b(a0));
        }
        a0.f();
        int v = arrayList0.size();
        if(this.a.isPrimitive()) {
            Object object0 = Array.newInstance(this.a, v);
            for(int v1 = 0; v1 < v; ++v1) {
                Array.set(object0, v1, arrayList0.get(v1));
            }
            return object0;
        }
        return arrayList0.toArray(((Object[])Array.newInstance(this.a, v)));
    }

    @Override  // n2.r
    public void d(c c0, Object object0) {
        if(object0 == null) {
            c0.n();
            return;
        }
        c0.c();
        int v = Array.getLength(object0);
        for(int v1 = 0; v1 < v; ++v1) {
            Object object1 = Array.get(object0, v1);
            this.b.d(c0, object1);
        }
        c0.f();
    }
}

