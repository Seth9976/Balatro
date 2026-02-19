package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import k.h;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class c0 {
    static class a implements e {
        @Override  // androidx.appcompat.widget.c0$e
        public Drawable a(Context context0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
            try {
                return f.a.l(context0, context0.getResources(), xmlPullParser0, attributeSet0, resources$Theme0);
            }
            catch(Exception exception0) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", exception0);
                return null;
            }
        }
    }

    static class b implements e {
        @Override  // androidx.appcompat.widget.c0$e
        public Drawable a(Context context0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
            try {
                return androidx.vectordrawable.graphics.drawable.b.a(context0, context0.getResources(), xmlPullParser0, attributeSet0, resources$Theme0);
            }
            catch(Exception exception0) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", exception0);
                return null;
            }
        }
    }

    static class c extends k.e {
        public c(int v) {
            super(v);
        }

        private static int h(int v, PorterDuff.Mode porterDuff$Mode0) {
            return (v + 0x1F) * 0x1F + porterDuff$Mode0.hashCode();
        }

        PorterDuffColorFilter i(int v, PorterDuff.Mode porterDuff$Mode0) {
            return (PorterDuffColorFilter)this.c(c.h(v, porterDuff$Mode0));
        }

        PorterDuffColorFilter j(int v, PorterDuff.Mode porterDuff$Mode0, PorterDuffColorFilter porterDuffColorFilter0) {
            return (PorterDuffColorFilter)this.d(c.h(v, porterDuff$Mode0), porterDuffColorFilter0);
        }
    }

    static class d implements e {
        @Override  // androidx.appcompat.widget.c0$e
        public Drawable a(Context context0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
            String s = attributeSet0.getClassAttribute();
            if(s != null) {
                try {
                    Drawable drawable0 = (Drawable)d.class.getClassLoader().loadClass(s).asSubclass(Drawable.class).getDeclaredConstructor().newInstance();
                    g.c.c(drawable0, context0.getResources(), xmlPullParser0, attributeSet0, resources$Theme0);
                    return drawable0;
                }
                catch(Exception exception0) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", exception0);
                }
            }
            return null;
        }
    }

    interface e {
        Drawable a(Context arg1, XmlPullParser arg2, AttributeSet arg3, Resources.Theme arg4);
    }

    public interface f {
        Drawable a(c0 arg1, Context arg2, int arg3);

        boolean b(Context arg1, int arg2, Drawable arg3);

        ColorStateList c(Context arg1, int arg2);

        boolean d(Context arg1, int arg2, Drawable arg3);

        PorterDuff.Mode e(int arg1);
    }

    static class g implements e {
        @Override  // androidx.appcompat.widget.c0$e
        public Drawable a(Context context0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
            try {
                return androidx.vectordrawable.graphics.drawable.g.c(context0.getResources(), xmlPullParser0, attributeSet0, resources$Theme0);
            }
            catch(Exception exception0) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", exception0);
                return null;
            }
        }
    }

    private WeakHashMap a;
    private k.g b;
    private h c;
    private final WeakHashMap d;
    private TypedValue e;
    private boolean f;
    private f g;
    private static final PorterDuff.Mode h;
    private static c0 i;
    private static final c j;

    static {
        c0.h = PorterDuff.Mode.SRC_IN;
        c0.j = new c(6);
    }

    public c0() {
        this.d = new WeakHashMap(0);
    }

    private void a(String s, e c0$e0) {
        if(this.b == null) {
            this.b = new k.g();
        }
        this.b.put(s, c0$e0);
    }

    private boolean b(Context context0, long v, Drawable drawable0) {
        synchronized(this) {
            Drawable.ConstantState drawable$ConstantState0 = drawable0.getConstantState();
            if(drawable$ConstantState0 != null) {
                k.d d0 = (k.d)this.d.get(context0);
                if(d0 == null) {
                    d0 = new k.d();
                    this.d.put(context0, d0);
                }
                d0.j(v, new WeakReference(drawable$ConstantState0));
                return true;
            }
            return false;
        }
    }

    private void c(Context context0, int v, ColorStateList colorStateList0) {
        if(this.a == null) {
            this.a = new WeakHashMap();
        }
        h h0 = (h)this.a.get(context0);
        if(h0 == null) {
            h0 = new h();
            this.a.put(context0, h0);
        }
        h0.a(v, colorStateList0);
    }

    private void d(Context context0) {
        if(this.f) {
            return;
        }
        this.f = true;
        Drawable drawable0 = this.j(context0, g.d.a);
        if(drawable0 != null && c0.q(drawable0)) {
            return;
        }
        this.f = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    }

    private static long e(TypedValue typedValue0) {
        return ((long)typedValue0.assetCookie) << 0x20 | ((long)typedValue0.data);
    }

    private Drawable f(Context context0, int v) {
        if(this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue0 = this.e;
        context0.getResources().getValue(v, typedValue0, true);
        long v1 = c0.e(typedValue0);
        Drawable drawable0 = this.i(context0, v1);
        if(drawable0 != null) {
            return drawable0;
        }
        Drawable drawable1 = this.g == null ? null : this.g.a(this, context0, v);
        if(drawable1 != null) {
            drawable1.setChangingConfigurations(typedValue0.changingConfigurations);
            this.b(context0, v1, drawable1);
        }
        return drawable1;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList0, PorterDuff.Mode porterDuff$Mode0, int[] arr_v) {
        return colorStateList0 == null || porterDuff$Mode0 == null ? null : c0.l(colorStateList0.getColorForState(arr_v, 0), porterDuff$Mode0);
    }

    public static c0 h() {
        synchronized(c0.class) {
            if(c0.i == null) {
                c0 c00 = new c0();
                c0.i = c00;
                c0.p(c00);
            }
            return c0.i;
        }
    }

    private Drawable i(Context context0, long v) {
        synchronized(this) {
            k.d d0 = (k.d)this.d.get(context0);
            if(d0 == null) {
                return null;
            }
            WeakReference weakReference0 = (WeakReference)d0.f(v);
            if(weakReference0 != null) {
                Drawable.ConstantState drawable$ConstantState0 = (Drawable.ConstantState)weakReference0.get();
                if(drawable$ConstantState0 != null) {
                    return drawable$ConstantState0.newDrawable(context0.getResources());
                }
                d0.k(v);
            }
            return null;
        }
    }

    public Drawable j(Context context0, int v) {
        synchronized(this) {
            return this.k(context0, v, false);
        }
    }

    Drawable k(Context context0, int v, boolean z) {
        synchronized(this) {
            this.d(context0);
            Drawable drawable0 = this.r(context0, v);
            if(drawable0 == null) {
                drawable0 = this.f(context0, v);
            }
            if(drawable0 == null) {
                drawable0 = androidx.core.content.a.c(context0, v);
            }
            if(drawable0 != null) {
                drawable0 = this.u(context0, v, z, drawable0);
            }
            if(drawable0 != null) {
                u.b(drawable0);
            }
            return drawable0;
        }
    }

    public static PorterDuffColorFilter l(int v, PorterDuff.Mode porterDuff$Mode0) {
        synchronized(c0.class) {
            c c0$c0 = c0.j;
            PorterDuffColorFilter porterDuffColorFilter0 = c0$c0.i(v, porterDuff$Mode0);
            if(porterDuffColorFilter0 == null) {
                porterDuffColorFilter0 = new PorterDuffColorFilter(v, porterDuff$Mode0);
                c0$c0.j(v, porterDuff$Mode0, porterDuffColorFilter0);
            }
            return porterDuffColorFilter0;
        }
    }

    ColorStateList m(Context context0, int v) {
        synchronized(this) {
            ColorStateList colorStateList0 = this.n(context0, v);
            if(colorStateList0 == null) {
                colorStateList0 = this.g == null ? null : this.g.c(context0, v);
                if(colorStateList0 != null) {
                    this.c(context0, v, colorStateList0);
                }
            }
            return colorStateList0;
        }
    }

    private ColorStateList n(Context context0, int v) {
        WeakHashMap weakHashMap0 = this.a;
        if(weakHashMap0 != null) {
            h h0 = (h)weakHashMap0.get(context0);
            return h0 == null ? null : ((ColorStateList)h0.g(v));
        }
        return null;
    }

    PorterDuff.Mode o(int v) {
        return this.g == null ? null : this.g.e(v);
    }

    private static void p(c0 c00) {
        if(Build.VERSION.SDK_INT < 24) {
            c00.a("vector", new g());
            c00.a("animated-vector", new b());
            c00.a("animated-selector", new a());
            c00.a("drawable", new d());
        }
    }

    // 去混淆评级： 低(20)
    private static boolean q(Drawable drawable0) {
        return drawable0 instanceof androidx.vectordrawable.graphics.drawable.g || "android.graphics.drawable.VectorDrawable".equals(drawable0.getClass().getName());
    }

    private Drawable r(Context context0, int v) {
        if(this.b != null && !this.b.isEmpty()) {
            h h0 = this.c;
            if(h0 == null) {
                this.c = new h();
            }
            else {
                String s = (String)h0.g(v);
                if("appcompat_skip_skip".equals(s) || s != null && this.b.get(s) == null) {
                    return null;
                }
            }
            if(this.e == null) {
                this.e = new TypedValue();
            }
            TypedValue typedValue0 = this.e;
            Resources resources0 = context0.getResources();
            resources0.getValue(v, typedValue0, true);
            long v1 = c0.e(typedValue0);
            Drawable drawable0 = this.i(context0, v1);
            if(drawable0 != null) {
                return drawable0;
            }
            if(typedValue0.string != null && typedValue0.string.toString().endsWith(".xml")) {
                try {
                    XmlResourceParser xmlResourceParser0 = resources0.getXml(v);
                    AttributeSet attributeSet0 = Xml.asAttributeSet(xmlResourceParser0);
                    do {
                        int v2 = xmlResourceParser0.next();
                    }
                    while(v2 != 1 && v2 != 2);
                    if(v2 != 2) {
                        throw new XmlPullParserException("No start tag found");
                    }
                    String s1 = xmlResourceParser0.getName();
                    this.c.a(v, s1);
                    e c0$e0 = (e)this.b.get(s1);
                    if(c0$e0 != null) {
                        drawable0 = c0$e0.a(context0, xmlResourceParser0, attributeSet0, context0.getTheme());
                    }
                    if(drawable0 != null) {
                        drawable0.setChangingConfigurations(typedValue0.changingConfigurations);
                        this.b(context0, v1, drawable0);
                    }
                }
                catch(Exception exception0) {
                    Log.e("ResourceManagerInternal", "Exception while inflating drawable", exception0);
                }
            }
            if(drawable0 == null) {
                this.c.a(v, "appcompat_skip_skip");
            }
            return drawable0;
        }
        return null;
    }

    Drawable s(Context context0, u0 u00, int v) {
        synchronized(this) {
            Drawable drawable0 = this.r(context0, v);
            if(drawable0 == null) {
                drawable0 = u00.a(v);
            }
            return drawable0 != null ? this.u(context0, v, false, drawable0) : null;
        }
    }

    public void t(f c0$f0) {
        synchronized(this) {
            this.g = c0$f0;
        }
    }

    private Drawable u(Context context0, int v, boolean z, Drawable drawable0) {
        ColorStateList colorStateList0 = this.m(context0, v);
        if(colorStateList0 != null) {
            drawable0 = drawable0.mutate();
            androidx.core.graphics.drawable.a.n(drawable0, colorStateList0);
            PorterDuff.Mode porterDuff$Mode0 = this.o(v);
            if(porterDuff$Mode0 != null) {
                androidx.core.graphics.drawable.a.o(drawable0, porterDuff$Mode0);
                return drawable0;
            }
            return drawable0;
        }
        return this.g != null && this.g.d(context0, v, drawable0) || this.w(context0, v, drawable0) || !z ? drawable0 : null;
    }

    static void v(Drawable drawable0, j0 j00, int[] arr_v) {
        int[] arr_v1 = drawable0.getState();
        if(drawable0.mutate() != drawable0) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if(drawable0 instanceof LayerDrawable && drawable0.isStateful()) {
            drawable0.setState(new int[0]);
            drawable0.setState(arr_v1);
        }
        boolean z = j00.d;
        if(z || j00.c) {
            drawable0.setColorFilter(c0.g((z ? j00.a : null), (j00.c ? j00.b : c0.h), arr_v));
        }
        else {
            drawable0.clearColorFilter();
        }
        if(Build.VERSION.SDK_INT <= 23) {
            drawable0.invalidateSelf();
        }
    }

    boolean w(Context context0, int v, Drawable drawable0) {
        return this.g != null && this.g.b(context0, v, drawable0);
    }
}

