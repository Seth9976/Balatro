package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public abstract class a {
    static abstract class androidx.core.graphics.drawable.a.a {
        static int a(Drawable drawable0) {
            return drawable0.getAlpha();
        }

        static Drawable b(DrawableContainer.DrawableContainerState drawableContainer$DrawableContainerState0, int v) {
            return drawableContainer$DrawableContainerState0.getChild(v);
        }

        static Drawable c(InsetDrawable insetDrawable0) {
            return insetDrawable0.getDrawable();
        }

        static boolean d(Drawable drawable0) {
            return drawable0.isAutoMirrored();
        }

        static void e(Drawable drawable0, boolean z) {
            drawable0.setAutoMirrored(z);
        }
    }

    static abstract class b {
        static void a(Drawable drawable0, Resources.Theme resources$Theme0) {
            drawable0.applyTheme(resources$Theme0);
        }

        static boolean b(Drawable drawable0) {
            return drawable0.canApplyTheme();
        }

        static ColorFilter c(Drawable drawable0) {
            return drawable0.getColorFilter();
        }

        static void d(Drawable drawable0, Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
            drawable0.inflate(resources0, xmlPullParser0, attributeSet0, resources$Theme0);
        }

        static void e(Drawable drawable0, float f, float f1) {
            drawable0.setHotspot(f, f1);
        }

        static void f(Drawable drawable0, int v, int v1, int v2, int v3) {
            drawable0.setHotspotBounds(v, v1, v2, v3);
        }

        static void g(Drawable drawable0, int v) {
            drawable0.setTint(v);
        }

        static void h(Drawable drawable0, ColorStateList colorStateList0) {
            drawable0.setTintList(colorStateList0);
        }

        static void i(Drawable drawable0, PorterDuff.Mode porterDuff$Mode0) {
            drawable0.setTintMode(porterDuff$Mode0);
        }
    }

    static abstract class c {
        static int a(Drawable drawable0) {
            return drawable0.getLayoutDirection();
        }

        static boolean b(Drawable drawable0, int v) {
            return drawable0.setLayoutDirection(v);
        }
    }

    public static void a(Drawable drawable0, Resources.Theme resources$Theme0) {
        b.a(drawable0, resources$Theme0);
    }

    public static boolean b(Drawable drawable0) {
        return b.b(drawable0);
    }

    public static int c(Drawable drawable0) {
        return androidx.core.graphics.drawable.a.a.a(drawable0);
    }

    public static ColorFilter d(Drawable drawable0) {
        return b.c(drawable0);
    }

    public static int e(Drawable drawable0) {
        return c.a(drawable0);
    }

    public static void f(Drawable drawable0, Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
        b.d(drawable0, resources0, xmlPullParser0, attributeSet0, resources$Theme0);
    }

    public static boolean g(Drawable drawable0) {
        return androidx.core.graphics.drawable.a.a.d(drawable0);
    }

    public static void h(Drawable drawable0) {
        drawable0.jumpToCurrentState();
    }

    public static void i(Drawable drawable0, boolean z) {
        androidx.core.graphics.drawable.a.a.e(drawable0, z);
    }

    public static void j(Drawable drawable0, float f, float f1) {
        b.e(drawable0, f, f1);
    }

    public static void k(Drawable drawable0, int v, int v1, int v2, int v3) {
        b.f(drawable0, v, v1, v2, v3);
    }

    public static boolean l(Drawable drawable0, int v) {
        return c.b(drawable0, v);
    }

    public static void m(Drawable drawable0, int v) {
        b.g(drawable0, v);
    }

    public static void n(Drawable drawable0, ColorStateList colorStateList0) {
        b.h(drawable0, colorStateList0);
    }

    public static void o(Drawable drawable0, PorterDuff.Mode porterDuff$Mode0) {
        b.i(drawable0, porterDuff$Mode0);
    }

    public static Drawable p(Drawable drawable0) [...] // Inlined contents
}

