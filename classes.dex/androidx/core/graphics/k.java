package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.res.e.c;
import androidx.core.content.res.e.d;
import androidx.core.provider.g.b;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import k.g;

class k extends o {
    private static final Class b;
    private static final Constructor c;
    private static final Method d;
    private static final Method e;

    static {
        Method method1;
        Method method0;
        Constructor constructor0;
        Class class0;
        try {
            class0 = Class.forName("android.graphics.FontFamily");
            constructor0 = class0.getConstructor();
            method0 = class0.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            Class[] arr_class = {Array.newInstance(class0, 1).getClass()};
            method1 = Typeface.class.getMethod("createFromFamiliesWithDefault", arr_class);
        }
        catch(ClassNotFoundException | NoSuchMethodException classNotFoundException0) {
            Log.e("TypefaceCompatApi24Impl", classNotFoundException0.getClass().getName(), classNotFoundException0);
            class0 = null;
            method1 = null;
            constructor0 = null;
            method0 = null;
        }
        k.c = constructor0;
        k.b = class0;
        k.d = method0;
        k.e = method1;
    }

    @Override  // androidx.core.graphics.o
    public Typeface a(Context context0, c e$c0, Resources resources0, int v) {
        Object object0 = k.k();
        if(object0 == null) {
            return null;
        }
        d[] arr_e$d = e$c0.a();
        for(int v1 = 0; v1 < arr_e$d.length; ++v1) {
            d e$d0 = arr_e$d[v1];
            ByteBuffer byteBuffer0 = p.b(context0, resources0, e$d0.b());
            if(byteBuffer0 == null) {
                return null;
            }
            if(!k.h(object0, byteBuffer0, e$d0.c(), e$d0.e(), e$d0.f())) {
                return null;
            }
        }
        return k.i(object0);
    }

    @Override  // androidx.core.graphics.o
    public Typeface b(Context context0, CancellationSignal cancellationSignal0, b[] arr_g$b, int v) {
        Object object0 = k.k();
        if(object0 == null) {
            return null;
        }
        g g0 = new g();
        for(int v1 = 0; v1 < arr_g$b.length; ++v1) {
            b g$b0 = arr_g$b[v1];
            Uri uri0 = g$b0.d();
            ByteBuffer byteBuffer0 = (ByteBuffer)g0.get(uri0);
            if(byteBuffer0 == null) {
                byteBuffer0 = p.f(context0, cancellationSignal0, uri0);
                g0.put(uri0, byteBuffer0);
            }
            if(byteBuffer0 == null) {
                return null;
            }
            if(!k.h(object0, byteBuffer0, g$b0.c(), g$b0.e(), g$b0.f())) {
                return null;
            }
        }
        Typeface typeface0 = k.i(object0);
        return typeface0 == null ? null : Typeface.create(typeface0, v);
    }

    private static boolean h(Object object0, ByteBuffer byteBuffer0, int v, int v1, boolean z) {
        try {
            return ((Boolean)k.d.invoke(object0, byteBuffer0, v, null, v1, Boolean.valueOf(z))).booleanValue();
        }
        catch(IllegalAccessException | InvocationTargetException unused_ex) {
            return false;
        }
    }

    private static Typeface i(Object object0) {
        try {
            Object object1 = Array.newInstance(k.b, 1);
            Array.set(object1, 0, object0);
            return (Typeface)k.e.invoke(null, object1);
        }
        catch(IllegalAccessException | InvocationTargetException unused_ex) {
            return null;
        }
    }

    public static boolean j() {
        Method method0 = k.d;
        if(method0 == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method0 != null;
    }

    private static Object k() {
        try {
            return k.c.newInstance();
        }
        catch(IllegalAccessException | InstantiationException | InvocationTargetException unused_ex) {
            return null;
        }
    }
}

