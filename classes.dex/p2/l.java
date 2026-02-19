package p2;

import h.d;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import n2.o;

public abstract class l {
    static abstract class a {
    }

    static abstract class b {
        class p2.l.b.a extends b {
            final Method b;

            p2.l.b.a(Method method0) {
                super(null);
            }

            @Override  // p2.l$b
            public boolean a(AccessibleObject accessibleObject0, Object object0) {
                try {
                    return ((Boolean)this.b.invoke(accessibleObject0, object0)).booleanValue();
                }
                catch(Exception exception0) {
                    throw new RuntimeException("Failed invoking canAccess", exception0);
                }
            }
        }

        class p2.l.b.b extends b {
            p2.l.b.b() {
                super(null);
            }

            @Override  // p2.l$b
            public boolean a(AccessibleObject accessibleObject0, Object object0) {
                return true;
            }
        }

        public static final b a;

        static {
            b.a = new p2.l.b.b();
        }

        private b() {
        }

        b(a l$a0) {
        }

        public abstract boolean a(AccessibleObject arg1, Object arg2);
    }

    public static boolean a(AccessibleObject accessibleObject0, Object object0) {
        return b.a.a(accessibleObject0, object0);
    }

    public static o b(List list0, Class class0) {
        Iterator iterator0 = list0.iterator();
        if(!iterator0.hasNext()) {
            return o.e;
        }
        Object object0 = iterator0.next();
        d.a(object0);
        throw null;
    }
}

