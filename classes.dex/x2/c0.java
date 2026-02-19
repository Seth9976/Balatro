package x2;

import android.content.res.Configuration;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

public abstract class c0 {
    static Class a(String s) {
        try {
            return Class.forName(s);
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    // 去混淆评级： 低(20)
    static String b() [...] // 潜在的解密器

    static Locale c(Configuration configuration0) {
        try {
            return (Locale)c0.j("android.content.res.Configuration", "locale", configuration0);
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    static Locale d(Configuration configuration0) {
        try {
            Object object0 = c0.f(configuration0, "getLocales", null, new Object[0]);
            return object0 == null ? null : ((Locale)c0.f(object0, "get", new Class[]{Integer.TYPE}, new Object[]{0}));
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    static String[] e() {
        try {
            return (String[])c0.i("android.os.Build", "SUPPORTED_ABIS");
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    public static Object f(Object object0, String s, Class[] arr_class, Object[] arr_object) {
        return c0.g(object0.getClass(), s, object0, arr_class, arr_object);
    }

    static Object g(Class class0, String s, Object object0, Class[] arr_class, Object[] arr_object) {
        Method method0 = class0.getMethod(s, arr_class);
        return method0 == null ? null : method0.invoke(object0, arr_object);
    }

    public static Object h(String s, String s1, Class[] arr_class, Object[] arr_object) {
        return c0.g(Class.forName(s), s1, null, arr_class, arr_object);
    }

    static Object i(String s, String s1) {
        return c0.j(s, s1, null);
    }

    static Object j(String s, String s1, Object object0) {
        Class class0 = c0.a(s);
        if(class0 == null) {
            return null;
        }
        Field field0 = class0.getField(s1);
        return field0 == null ? null : field0.get(object0);
    }
}

