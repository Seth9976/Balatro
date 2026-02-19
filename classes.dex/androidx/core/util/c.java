package androidx.core.util;

public abstract class c {
    public static void a(boolean z, Object object0) {
        if(!z) {
            throw new IllegalArgumentException(String.valueOf(object0));
        }
    }

    public static int b(int v) {
        if(v < 0) {
            throw new IllegalArgumentException();
        }
        return v;
    }

    public static int c(int v, String s) {
        if(v < 0) {
            throw new IllegalArgumentException(s);
        }
        return v;
    }

    public static Object d(Object object0) {
        object0.getClass();
        return object0;
    }

    public static Object e(Object object0, Object object1) {
        if(object0 == null) {
            throw new NullPointerException(String.valueOf(object1));
        }
        return object0;
    }

    public static void f(boolean z, String s) {
        if(!z) {
            throw new IllegalStateException(s);
        }
    }
}

