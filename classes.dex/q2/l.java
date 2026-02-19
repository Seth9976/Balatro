package q2;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import n2.d;
import n2.r;
import v2.a;
import v2.c;

final class l extends r {
    private final d a;
    private final r b;
    private final Type c;

    l(d d0, r r0, Type type0) {
        this.a = d0;
        this.b = r0;
        this.c = type0;
    }

    @Override  // n2.r
    public Object b(a a0) {
        return this.b.b(a0);
    }

    @Override  // n2.r
    public void d(c c0, Object object0) {
        r r0 = this.b;
        Type type0 = l.e(this.c, object0);
        if(type0 != this.c) {
            u2.a a0 = u2.a.b(type0);
            r0 = this.a.l(a0);
            if(r0 instanceof b && !l.f(this.b)) {
                r0 = this.b;
            }
        }
        r0.d(c0, object0);
    }

    private static Type e(Type type0, Object object0) {
        return object0 != null && (type0 instanceof Class || type0 instanceof TypeVariable) ? object0.getClass() : type0;
    }

    private static boolean f(r r0) {
        while(r0 instanceof k) {
            r r1 = ((k)r0).e();
            if(r1 == r0) {
                break;
            }
            r0 = r1;
        }
        return r0 instanceof b;
    }
}

