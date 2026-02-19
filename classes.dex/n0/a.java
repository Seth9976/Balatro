package n0;

import android.os.Build.VERSION;
import android.util.Log;

public abstract class a {
    private static String a(String s, String s1) {
        String s2 = s + s1;
        return s2.length() <= 23 ? s2 : s2.substring(0, 23);
    }

    public static void b(String s, String s1, Object object0) {
        String s2 = a.e(s);
        if(Log.isLoggable(s2, 3)) {
            Log.d(s2, String.format(s1, object0));
        }
    }

    public static void c(String s, String s1, Object[] arr_object) {
        String s2 = a.e(s);
        if(Log.isLoggable(s2, 3)) {
            Log.d(s2, String.format(s1, arr_object));
        }
    }

    public static void d(String s, String s1, Throwable throwable0) {
        String s2 = a.e(s);
        if(Log.isLoggable(s2, 6)) {
            Log.e(s2, s1, throwable0);
        }
    }

    private static String e(String s) {
        return Build.VERSION.SDK_INT >= 26 ? "TRuntime." + s : a.a("TRuntime.", s);
    }

    public static void f(String s, String s1, Object object0) {
        String s2 = a.e(s);
        if(Log.isLoggable(s2, 4)) {
            Log.i(s2, String.format(s1, object0));
        }
    }

    public static void g(String s, String s1, Object object0) {
        String s2 = a.e(s);
        if(Log.isLoggable(s2, 5)) {
            Log.w(s2, String.format(s1, object0));
        }
    }
}

