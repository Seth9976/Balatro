package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface.Builder;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.res.e.c;
import androidx.core.content.res.e.d;
import androidx.core.provider.g.b;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

public class l extends j {
    protected final Class g;
    protected final Constructor h;
    protected final Method i;
    protected final Method j;
    protected final Method k;
    protected final Method l;
    protected final Method m;

    public l() {
        Method method4;
        Method method3;
        Method method2;
        Method method1;
        Method method0;
        Constructor constructor0;
        Class class0;
        try {
            class0 = this.v();
            constructor0 = this.w(class0);
            method0 = this.s(class0);
            method1 = this.t(class0);
            method2 = this.x(class0);
            method3 = this.r(class0);
            method4 = this.u(class0);
        }
        catch(ClassNotFoundException | NoSuchMethodException classNotFoundException0) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + classNotFoundException0.getClass().getName(), classNotFoundException0);
            class0 = null;
            constructor0 = null;
            method0 = null;
            method1 = null;
            method2 = null;
            method3 = null;
            method4 = null;
        }
        this.g = class0;
        this.h = constructor0;
        this.i = method0;
        this.j = method1;
        this.k = method2;
        this.l = method3;
        this.m = method4;
    }

    @Override  // androidx.core.graphics.j
    public Typeface a(Context context0, c e$c0, Resources resources0, int v) {
        if(!this.q()) {
            return super.a(context0, e$c0, resources0, v);
        }
        Object object0 = this.l();
        if(object0 == null) {
            return null;
        }
        d[] arr_e$d = e$c0.a();
        for(int v1 = 0; v1 < arr_e$d.length; ++v1) {
            d e$d0 = arr_e$d[v1];
            if(!this.n(context0, object0, e$d0.a(), e$d0.c(), e$d0.e(), ((int)e$d0.f()), FontVariationAxis.fromFontVariationSettings(e$d0.d()))) {
                this.m(object0);
                return null;
            }
        }
        return this.p(object0) ? this.i(object0) : null;
    }

    @Override  // androidx.core.graphics.j
    public Typeface b(Context context0, CancellationSignal cancellationSignal0, b[] arr_g$b, int v) {
        if(arr_g$b.length < 1) {
            return null;
        }
        if(!this.q()) {
            b g$b0 = this.g(arr_g$b, v);
            ContentResolver contentResolver0 = context0.getContentResolver();
            try(ParcelFileDescriptor parcelFileDescriptor0 = contentResolver0.openFileDescriptor(g$b0.d(), "r", cancellationSignal0)) {
                if(parcelFileDescriptor0 != null) {
                    return new Typeface.Builder(parcelFileDescriptor0.getFileDescriptor()).setWeight(g$b0.e()).setItalic(g$b0.f()).build();
                }
            }
            catch(IOException unused_ex) {
            }
            return null;
        }
        Map map0 = p.h(context0, arr_g$b, cancellationSignal0);
        Object object0 = this.l();
        if(object0 == null) {
            return null;
        }
        boolean z = false;
        for(int v1 = 0; v1 < arr_g$b.length; ++v1) {
            b g$b1 = arr_g$b[v1];
            ByteBuffer byteBuffer0 = (ByteBuffer)map0.get(g$b1.d());
            if(byteBuffer0 != null) {
                if(!this.o(object0, byteBuffer0, g$b1.c(), g$b1.e(), ((int)g$b1.f()))) {
                    this.m(object0);
                    return null;
                }
                z = true;
            }
        }
        if(!z) {
            this.m(object0);
            return null;
        }
        if(!this.p(object0)) {
            return null;
        }
        Typeface typeface0 = this.i(object0);
        return typeface0 == null ? null : Typeface.create(typeface0, v);
    }

    @Override  // androidx.core.graphics.o
    public Typeface d(Context context0, Resources resources0, int v, String s, int v1) {
        if(!this.q()) {
            return super.d(context0, resources0, v, s, v1);
        }
        Object object0 = this.l();
        if(object0 == null) {
            return null;
        }
        if(!this.n(context0, object0, s, 0, -1, -1, null)) {
            this.m(object0);
            return null;
        }
        return this.p(object0) ? this.i(object0) : null;
    }

    protected Typeface i(Object object0) {
        try {
            Object object1 = Array.newInstance(this.g, 1);
            Array.set(object1, 0, object0);
            return (Typeface)this.m.invoke(null, object1, -1, -1);
        }
        catch(IllegalAccessException | InvocationTargetException unused_ex) {
            return null;
        }
    }

    private Object l() {
        try {
            return this.h.newInstance();
        }
        catch(IllegalAccessException | InstantiationException | InvocationTargetException unused_ex) {
            return null;
        }
    }

    private void m(Object object0) {
        try {
            this.l.invoke(object0);
        }
        catch(IllegalAccessException | InvocationTargetException unused_ex) {
        }
    }

    private boolean n(Context context0, Object object0, String s, int v, int v1, int v2, FontVariationAxis[] arr_fontVariationAxis) {
        try {
            Object[] arr_object = {context0.getAssets(), s, 0, Boolean.FALSE, v, v1, v2, arr_fontVariationAxis};
            return ((Boolean)this.i.invoke(object0, arr_object)).booleanValue();
        }
        catch(IllegalAccessException | InvocationTargetException unused_ex) {
            return false;
        }
    }

    private boolean o(Object object0, ByteBuffer byteBuffer0, int v, int v1, int v2) {
        try {
            return ((Boolean)this.j.invoke(object0, byteBuffer0, v, null, v1, v2)).booleanValue();
        }
        catch(IllegalAccessException | InvocationTargetException unused_ex) {
            return false;
        }
    }

    private boolean p(Object object0) {
        try {
            return ((Boolean)this.k.invoke(object0)).booleanValue();
        }
        catch(IllegalAccessException | InvocationTargetException unused_ex) {
            return false;
        }
    }

    private boolean q() {
        if(this.i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.i != null;
    }

    protected Method r(Class class0) {
        return class0.getMethod("abortCreation");
    }

    protected Method s(Class class0) {
        return class0.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    protected Method t(Class class0) {
        return class0.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    protected Method u(Class class0) {
        Class[] arr_class = {Array.newInstance(class0, 1).getClass(), Integer.TYPE, Integer.TYPE};
        Method method0 = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", arr_class);
        method0.setAccessible(true);
        return method0;
    }

    protected Class v() {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor w(Class class0) {
        return class0.getConstructor();
    }

    protected Method x(Class class0) {
        return class0.getMethod("freeze");
    }
}

