package k3;

import java.util.Arrays;

public abstract class f {
    public static boolean a(Object object0, Object object1) {
        return object0 == null ? object1 == null : object0.equals(object1);
    }

    public static void b(Object object0) {
        if(object0 == null) {
            f.k();
        }
    }

    public static void c(Object object0, String s) {
        if(object0 == null) {
            f.l(s);
        }
    }

    public static void d(Object object0, String s) [...] // 潜在的解密器

    public static void e(Object object0, String s) {
        if(object0 == null) {
            f.m(s);
        }
    }

    public static int f(int v, int v1) {
        if(v < v1) {
            return -1;
        }
        return v == v1 ? 0 : 1;
    }

    private static String g(String s) {
        StackTraceElement stackTraceElement0 = Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + stackTraceElement0.getClassName() + "." + stackTraceElement0.getMethodName() + ", parameter " + s;
    }

    // 去混淆评级： 低(20)
    private static Throwable h(Throwable throwable0) {
        return f.i(throwable0, "k3.f");
    }

    static Throwable i(Throwable throwable0, String s) {
        StackTraceElement[] arr_stackTraceElement = throwable0.getStackTrace();
        int v = -1;
        for(int v1 = 0; v1 < arr_stackTraceElement.length; ++v1) {
            if(s.equals(arr_stackTraceElement[v1].getClassName())) {
                v = v1;
            }
        }
        throwable0.setStackTrace(((StackTraceElement[])Arrays.copyOfRange(arr_stackTraceElement, v + 1, arr_stackTraceElement.length)));
        return throwable0;
    }

    public static String j(String s, Object object0) [...] // Inlined contents

    public static void k() {
        throw (NullPointerException)f.h(new NullPointerException());
    }

    public static void l(String s) {
        throw (NullPointerException)f.h(new NullPointerException(s));
    }

    private static void m(String s) {
        throw (NullPointerException)f.h(new NullPointerException(f.g(s)));
    }
}

