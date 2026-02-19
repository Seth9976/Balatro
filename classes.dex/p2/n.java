package p2;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class n {
    public static final n a;

    static {
        n.a = n.c();
    }

    private static void b(Class class0) {
        String s = c.a(class0);
        if(s != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + s);
        }
    }

    private static n c() {
        class a extends n {
            final Method b;
            final Object c;

            a(Method method0, Object object0) {
                this.c = object0;
                super();
            }

            @Override  // p2.n
            public Object d(Class class0) {
                n.b(class0);
                return this.b.invoke(this.c, class0);
            }
        }


        class b extends n {
            final Method b;
            final int c;

            b(Method method0, int v) {
                this.c = v;
                super();
            }

            @Override  // p2.n
            public Object d(Class class0) {
                n.b(class0);
                return this.b.invoke(null, class0, this.c);
            }
        }


        class p2.n.c extends n {
            final Method b;

            p2.n.c(Method method0) {
            }

            @Override  // p2.n
            public Object d(Class class0) {
                n.b(class0);
                return this.b.invoke(null, class0, Object.class);
            }
        }


        class d extends n {
            d() {
                super();
            }

            @Override  // p2.n
            public Object d(Class class0) {
                throw new UnsupportedOperationException("Cannot allocate " + class0 + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
            }
        }

        Class class1;
        Class class0;
        try {
            class0 = ObjectStreamClass.class;
            class1 = Class.class;
            Class class2 = Class.forName("sun.misc.Unsafe");
            Field field0 = class2.getDeclaredField("theUnsafe");
            field0.setAccessible(true);
            Object object0 = field0.get(null);
            return new a(class2.getMethod("allocateInstance", class1), object0);
        }
        catch(Exception unused_ex) {
            try {
                Method method0 = class0.getDeclaredMethod("getConstructorId", class1);
                method0.setAccessible(true);
                int v = (int)(((Integer)method0.invoke(null, Object.class)));
                Method method1 = class0.getDeclaredMethod("newInstance", class1, Integer.TYPE);
                method1.setAccessible(true);
                return new b(method1, v);
            }
            catch(Exception unused_ex) {
                try {
                    Method method2 = ObjectInputStream.class.getDeclaredMethod("newInstance", class1, class1);
                    method2.setAccessible(true);
                    return new p2.n.c(method2);
                }
                catch(Exception unused_ex) {
                    return new d();
                }
            }
        }
    }

    public abstract Object d(Class arg1);
}

