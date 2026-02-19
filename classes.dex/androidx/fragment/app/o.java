package androidx.fragment.app;

import k.g;

public abstract class o {
    private static final g a;

    static {
        o.a = new g();
    }

    public abstract Fragment a(ClassLoader arg1, String arg2);

    static boolean b(ClassLoader classLoader0, String s) {
        try {
            Class class0 = o.c(classLoader0, s);
            return Fragment.class.isAssignableFrom(class0);
        }
        catch(ClassNotFoundException unused_ex) {
            return false;
        }
    }

    private static Class c(ClassLoader classLoader0, String s) {
        g g0 = o.a;
        g g1 = (g)g0.get(classLoader0);
        if(g1 == null) {
            g1 = new g();
            g0.put(classLoader0, g1);
        }
        Class class0 = (Class)g1.get(s);
        if(class0 == null) {
            class0 = Class.forName(s, false, classLoader0);
            g1.put(s, class0);
        }
        return class0;
    }

    public static Class d(ClassLoader classLoader0, String s) {
        try {
            return o.c(classLoader0, s);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw new h("Unable to instantiate fragment " + s + ": make sure class name exists", classNotFoundException0);
        }
        catch(ClassCastException classCastException0) {
            throw new h("Unable to instantiate fragment " + s + ": make sure class is a valid subclass of Fragment", classCastException0);
        }
    }
}

