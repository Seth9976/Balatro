package k3;

import o3.a;

public abstract class h {
    private static final i a;
    private static final a[] b;

    static {
        i i0 = null;
        try {
            i0 = (i)Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        }
        catch(ClassCastException | ClassNotFoundException | InstantiationException | IllegalAccessException unused_ex) {
        }
        if(i0 == null) {
            i0 = new i();
        }
        h.a = i0;
        h.b = new a[0];
    }

    public static a a(Class class0) {
        return h.a.a(class0);
    }

    public static String b(g g0) {
        return h.a.c(g0);
    }
}

