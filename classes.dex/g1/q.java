package g1;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import l1.k;

public abstract class q {
    public static void a(boolean z) {
        if(!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z, Object object0) {
        if(!z) {
            throw new IllegalArgumentException(String.valueOf(object0));
        }
    }

    public static void c(boolean z, String s, Object[] arr_object) {
        if(!z) {
            throw new IllegalArgumentException(String.format(s, arr_object));
        }
    }

    public static void d(Handler handler0) {
        Looper looper0 = Looper.myLooper();
        if(looper0 != handler0.getLooper()) {
            String s = looper0 == null ? "null current looper" : looper0.getThread().getName();
            throw new IllegalStateException("Must be called on " + handler0.getLooper().getThread().getName() + " thread, but got " + s + ".");
        }
    }

    public static void e(String s) {
        if(!k.a()) {
            throw new IllegalStateException(s);
        }
    }

    public static String f(String s) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return s;
    }

    public static String g(String s, Object object0) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException(String.valueOf(object0));
        }
        return s;
    }

    public static void h(String s) {
        if(k.a()) {
            throw new IllegalStateException(s);
        }
    }

    public static Object i(Object object0) {
        if(object0 == null) {
            throw new NullPointerException("null reference");
        }
        return object0;
    }

    public static Object j(Object object0, Object object1) {
        if(object0 == null) {
            throw new NullPointerException(String.valueOf(object1));
        }
        return object0;
    }

    public static void k(boolean z) {
        if(!z) {
            throw new IllegalStateException();
        }
    }

    public static void l(boolean z, Object object0) {
        if(!z) {
            throw new IllegalStateException(String.valueOf(object0));
        }
    }
}

