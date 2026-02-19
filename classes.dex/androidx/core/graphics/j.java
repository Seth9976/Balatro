package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.res.e.c;
import androidx.core.content.res.e.d;
import androidx.core.provider.g.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import jeb.synthetic.TWR;

class j extends o {
    private static Class b;
    private static Constructor c;
    private static Method d;
    private static Method e;
    private static boolean f;

    static {
    }

    @Override  // androidx.core.graphics.o
    public Typeface a(Context context0, c e$c0, Resources resources0, int v) {
        Object object0 = j.l();
        d[] arr_e$d = e$c0.a();
        for(int v1 = 0; v1 < arr_e$d.length; ++v1) {
            d e$d0 = arr_e$d[v1];
            File file0 = p.e(context0);
            if(file0 == null) {
                return null;
            }
            try {
                if(!p.c(file0, resources0, e$d0.b())) {
                    return null;
                }
                boolean z = j.h(object0, file0.getPath(), e$d0.e(), e$d0.f());
            }
            catch(RuntimeException unused_ex) {
                return null;
            }
            finally {
                file0.delete();
            }
            if(!z) {
                return null;
            }
        }
        return j.i(object0);
    }

    @Override  // androidx.core.graphics.o
    public Typeface b(Context context0, CancellationSignal cancellationSignal0, b[] arr_g$b, int v) {
        if(arr_g$b.length < 1) {
            return null;
        }
        b g$b0 = this.g(arr_g$b, v);
        ContentResolver contentResolver0 = context0.getContentResolver();
        try(ParcelFileDescriptor parcelFileDescriptor0 = contentResolver0.openFileDescriptor(g$b0.d(), "r", cancellationSignal0)) {
            if(parcelFileDescriptor0 != null) {
                File file0 = this.j(parcelFileDescriptor0);
                if(file0 != null && file0.canRead()) {
                    return Typeface.createFromFile(file0);
                }
                FileInputStream fileInputStream0 = new FileInputStream(parcelFileDescriptor0.getFileDescriptor());
                TWR.declareResource(fileInputStream0);
                TWR.useResource$NT(fileInputStream0);
                return super.c(context0, fileInputStream0);
            }
        }
        catch(IOException unused_ex) {
        }
        return null;
    }

    private static boolean h(Object object0, String s, int v, boolean z) {
        j.k();
        try {
            return ((Boolean)j.d.invoke(object0, s, v, Boolean.valueOf(z))).booleanValue();
        }
        catch(IllegalAccessException | InvocationTargetException illegalAccessException0) {
            throw new RuntimeException(illegalAccessException0);
        }
    }

    private static Typeface i(Object object0) {
        j.k();
        try {
            Object object1 = Array.newInstance(j.b, 1);
            Array.set(object1, 0, object0);
            return (Typeface)j.e.invoke(null, object1);
        }
        catch(IllegalAccessException | InvocationTargetException illegalAccessException0) {
            throw new RuntimeException(illegalAccessException0);
        }
    }

    private File j(ParcelFileDescriptor parcelFileDescriptor0) {
        try {
            String s = Os.readlink(("/proc/self/fd/" + parcelFileDescriptor0.getFd()));
            return OsConstants.S_ISREG(Os.stat(s).st_mode) ? new File(s) : null;
        }
        catch(ErrnoException unused_ex) {
        }
        return null;
    }

    private static void k() {
        Method method1;
        Method method0;
        Constructor constructor0;
        Class class0;
        if(j.f) {
            return;
        }
        try {
            j.f = true;
            class0 = Class.forName("android.graphics.FontFamily");
            constructor0 = class0.getConstructor();
            method0 = class0.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            Class[] arr_class = {Array.newInstance(class0, 1).getClass()};
            method1 = Typeface.class.getMethod("createFromFamiliesWithDefault", arr_class);
        }
        catch(ClassNotFoundException | NoSuchMethodException classNotFoundException0) {
            Log.e("TypefaceCompatApi21Impl", classNotFoundException0.getClass().getName(), classNotFoundException0);
            class0 = null;
            method1 = null;
            constructor0 = null;
            method0 = null;
        }
        j.c = constructor0;
        j.b = class0;
        j.d = method0;
        j.e = method1;
    }

    private static Object l() {
        j.k();
        try {
            return j.c.newInstance();
        }
        catch(IllegalAccessException | InstantiationException | InvocationTargetException illegalAccessException0) {
            throw new RuntimeException(illegalAccessException0);
        }
    }
}

