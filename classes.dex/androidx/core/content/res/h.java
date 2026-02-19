package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.graphics.i;
import java.io.IOException;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

public abstract class h {
    static abstract class a {
        static Drawable a(Resources resources0, int v, Resources.Theme resources$Theme0) {
            return resources0.getDrawable(v, resources$Theme0);
        }

        static Drawable b(Resources resources0, int v, int v1, Resources.Theme resources$Theme0) {
            return resources0.getDrawableForDensity(v, v1, resources$Theme0);
        }
    }

    static abstract class b {
        static int a(Resources resources0, int v, Resources.Theme resources$Theme0) {
            return resources0.getColor(v, resources$Theme0);
        }

        static ColorStateList b(Resources resources0, int v, Resources.Theme resources$Theme0) {
            return resources0.getColorStateList(v, resources$Theme0);
        }
    }

    static class c {
        final ColorStateList a;
        final Configuration b;
        final int c;

        c(ColorStateList colorStateList0, Configuration configuration0, Resources.Theme resources$Theme0) {
            this.a = colorStateList0;
            this.b = configuration0;
            this.c = resources$Theme0 == null ? 0 : resources$Theme0.hashCode();
        }
    }

    static final class d {
        final Resources a;
        final Resources.Theme b;

        d(Resources resources0, Resources.Theme resources$Theme0) {
            this.a = resources0;
            this.b = resources$Theme0;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 != null) {
                Class class0 = object0.getClass();
                return d.class == class0 && (this.a.equals(((d)object0).a) && androidx.core.util.b.a(this.b, ((d)object0).b));
            }
            return false;
        }

        @Override
        public int hashCode() {
            return androidx.core.util.b.b(new Object[]{this.a, this.b});
        }
    }

    public static abstract class e {
        public final void c(int v, Handler handler0) {
            e.e(handler0).post(() -> this.h(v));
        }

        public final void d(Typeface typeface0, Handler handler0) {
            e.e(handler0).post(() -> this.i(typeface0));
        }

        public static Handler e(Handler handler0) {
            return handler0 == null ? new Handler(Looper.getMainLooper()) : handler0;
        }

        // 检测为 Lambda 实现
        private void f(int v) [...]

        // 检测为 Lambda 实现
        private void g(Typeface typeface0) [...]

        public abstract void h(int arg1);

        public abstract void i(Typeface arg1);
    }

    private static final ThreadLocal a;
    private static final WeakHashMap b;
    private static final Object c;

    static {
        h.a = new ThreadLocal();
        h.b = new WeakHashMap(0);
        h.c = new Object();
    }

    private static void a(d h$d0, int v, ColorStateList colorStateList0, Resources.Theme resources$Theme0) {
        synchronized(h.c) {
            WeakHashMap weakHashMap0 = h.b;
            SparseArray sparseArray0 = (SparseArray)weakHashMap0.get(h$d0);
            if(sparseArray0 == null) {
                sparseArray0 = new SparseArray();
                weakHashMap0.put(h$d0, sparseArray0);
            }
            sparseArray0.append(v, new c(colorStateList0, h$d0.a.getConfiguration(), resources$Theme0));
        }
    }

    private static ColorStateList b(d h$d0, int v) {
        synchronized(h.c) {
            SparseArray sparseArray0 = (SparseArray)h.b.get(h$d0);
            if(sparseArray0 != null && sparseArray0.size() > 0) {
                c h$c0 = (c)sparseArray0.get(v);
                if(h$c0 != null) {
                    Configuration configuration0 = h$d0.a.getConfiguration();
                    if(h$c0.b.equals(configuration0) && (h$d0.b == null && h$c0.c == 0 || h$d0.b != null && h$c0.c == h$d0.b.hashCode())) {
                        return h$c0.a;
                    }
                    sparseArray0.remove(v);
                }
            }
            return null;
        }
    }

    public static ColorStateList c(Resources resources0, int v, Resources.Theme resources$Theme0) {
        d h$d0 = new d(resources0, resources$Theme0);
        ColorStateList colorStateList0 = h.b(h$d0, v);
        if(colorStateList0 != null) {
            return colorStateList0;
        }
        ColorStateList colorStateList1 = h.h(resources0, v, resources$Theme0);
        if(colorStateList1 != null) {
            h.a(h$d0, v, colorStateList1, resources$Theme0);
            return colorStateList1;
        }
        return b.b(resources0, v, resources$Theme0);
    }

    public static Drawable d(Resources resources0, int v, Resources.Theme resources$Theme0) {
        return a.a(resources0, v, resources$Theme0);
    }

    public static Drawable e(Resources resources0, int v, int v1, Resources.Theme resources$Theme0) {
        return a.b(resources0, v, v1, resources$Theme0);
    }

    // 去混淆评级： 低(20)
    public static Typeface f(Context context0, int v, TypedValue typedValue0, int v1, e h$e0) {
        return context0.isRestricted() ? null : h.j(context0, v, typedValue0, v1, h$e0, null, true, false);
    }

    private static TypedValue g() {
        ThreadLocal threadLocal0 = h.a;
        TypedValue typedValue0 = (TypedValue)threadLocal0.get();
        if(typedValue0 == null) {
            typedValue0 = new TypedValue();
            threadLocal0.set(typedValue0);
        }
        return typedValue0;
    }

    private static ColorStateList h(Resources resources0, int v, Resources.Theme resources$Theme0) {
        if(h.i(resources0, v)) {
            return null;
        }
        XmlResourceParser xmlResourceParser0 = resources0.getXml(v);
        try {
            return androidx.core.content.res.c.a(resources0, xmlResourceParser0, resources$Theme0);
        }
        catch(Exception exception0) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", exception0);
            return null;
        }
    }

    private static boolean i(Resources resources0, int v) {
        TypedValue typedValue0 = h.g();
        resources0.getValue(v, typedValue0, true);
        return typedValue0.type >= 28 && typedValue0.type <= 0x1F;
    }

    private static Typeface j(Context context0, int v, TypedValue typedValue0, int v1, e h$e0, Handler handler0, boolean z, boolean z1) {
        Resources resources0 = context0.getResources();
        resources0.getValue(v, typedValue0, true);
        Typeface typeface0 = h.k(context0, resources0, typedValue0, v, v1, h$e0, handler0, z, z1);
        if(typeface0 == null && h$e0 == null && !z1) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(v) + " could not be retrieved.");
        }
        return typeface0;
    }

    private static Typeface k(Context context0, Resources resources0, TypedValue typedValue0, int v, int v1, e h$e0, Handler handler0, boolean z, boolean z1) {
        String s1;
        StringBuilder stringBuilder0;
        CharSequence charSequence0 = typedValue0.string;
        if(charSequence0 == null) {
            throw new Resources.NotFoundException("Resource \"" + resources0.getResourceName(v) + "\" (" + Integer.toHexString(v) + ") is not a Font: " + typedValue0);
        }
        String s = charSequence0.toString();
        if(!s.startsWith("res/")) {
            if(h$e0 != null) {
                h$e0.c(-3, handler0);
            }
            return null;
        }
        Typeface typeface0 = i.f(resources0, v, s, typedValue0.assetCookie, v1);
        if(typeface0 != null) {
            if(h$e0 != null) {
                h$e0.d(typeface0, handler0);
            }
            return typeface0;
        }
        if(z1) {
            return null;
        }
        try {
            if(s.toLowerCase().endsWith(".xml")) {
                androidx.core.content.res.e.b e$b0 = androidx.core.content.res.e.b(resources0.getXml(v), resources0);
                if(e$b0 == null) {
                    Log.e("ResourcesCompat", "Failed to find font-family tag");
                    if(h$e0 != null) {
                        h$e0.c(-3, handler0);
                    }
                    return null;
                }
                return i.c(context0, e$b0, resources0, v, s, typedValue0.assetCookie, v1, h$e0, handler0, z);
            }
            Typeface typeface1 = i.d(context0, resources0, v, s, typedValue0.assetCookie, v1);
            if(h$e0 != null) {
                if(typeface1 != null) {
                    h$e0.d(typeface1, handler0);
                    return typeface1;
                }
                h$e0.c(-3, handler0);
            }
            return typeface1;
        }
        catch(XmlPullParserException xmlPullParserException0) {
            stringBuilder0 = new StringBuilder();
            s1 = "Failed to parse xml resource ";
        }
        catch(IOException xmlPullParserException0) {
            stringBuilder0 = new StringBuilder();
            s1 = "Failed to read xml resource ";
        }
        stringBuilder0.append(s1);
        stringBuilder0.append(s);
        Log.e("ResourcesCompat", stringBuilder0.toString(), xmlPullParserException0);
        if(h$e0 != null) {
            h$e0.c(-3, handler0);
        }
        return null;
    }
}

