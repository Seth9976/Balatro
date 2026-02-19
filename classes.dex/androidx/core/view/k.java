package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.MenuItem;
import m.b;

public abstract class k {
    static abstract class a {
        static int a(MenuItem menuItem0) {
            return menuItem0.getAlphabeticModifiers();
        }

        static CharSequence b(MenuItem menuItem0) {
            return menuItem0.getContentDescription();
        }

        static ColorStateList c(MenuItem menuItem0) {
            return menuItem0.getIconTintList();
        }

        static PorterDuff.Mode d(MenuItem menuItem0) {
            return menuItem0.getIconTintMode();
        }

        static int e(MenuItem menuItem0) {
            return menuItem0.getNumericModifiers();
        }

        static CharSequence f(MenuItem menuItem0) {
            return menuItem0.getTooltipText();
        }

        static MenuItem g(MenuItem menuItem0, char c, int v) {
            return menuItem0.setAlphabeticShortcut(c, v);
        }

        static MenuItem h(MenuItem menuItem0, CharSequence charSequence0) {
            return menuItem0.setContentDescription(charSequence0);
        }

        static MenuItem i(MenuItem menuItem0, ColorStateList colorStateList0) {
            return menuItem0.setIconTintList(colorStateList0);
        }

        static MenuItem j(MenuItem menuItem0, PorterDuff.Mode porterDuff$Mode0) {
            return menuItem0.setIconTintMode(porterDuff$Mode0);
        }

        static MenuItem k(MenuItem menuItem0, char c, int v) {
            return menuItem0.setNumericShortcut(c, v);
        }

        static MenuItem l(MenuItem menuItem0, char c, char c1, int v, int v1) {
            return menuItem0.setShortcut(c, c1, v, v1);
        }

        static MenuItem m(MenuItem menuItem0, CharSequence charSequence0) {
            return menuItem0.setTooltipText(charSequence0);
        }
    }

    public static void a(MenuItem menuItem0, char c, int v) {
        if(menuItem0 instanceof b) {
            ((b)menuItem0).setAlphabeticShortcut(c, v);
            return;
        }
        if(Build.VERSION.SDK_INT >= 26) {
            a.g(menuItem0, c, v);
        }
    }

    public static void b(MenuItem menuItem0, CharSequence charSequence0) {
        if(menuItem0 instanceof b) {
            ((b)menuItem0).setContentDescription(charSequence0);
            return;
        }
        if(Build.VERSION.SDK_INT >= 26) {
            a.h(menuItem0, charSequence0);
        }
    }

    public static void c(MenuItem menuItem0, ColorStateList colorStateList0) {
        if(menuItem0 instanceof b) {
            ((b)menuItem0).setIconTintList(colorStateList0);
            return;
        }
        if(Build.VERSION.SDK_INT >= 26) {
            a.i(menuItem0, colorStateList0);
        }
    }

    public static void d(MenuItem menuItem0, PorterDuff.Mode porterDuff$Mode0) {
        if(menuItem0 instanceof b) {
            ((b)menuItem0).setIconTintMode(porterDuff$Mode0);
            return;
        }
        if(Build.VERSION.SDK_INT >= 26) {
            a.j(menuItem0, porterDuff$Mode0);
        }
    }

    public static void e(MenuItem menuItem0, char c, int v) {
        if(menuItem0 instanceof b) {
            ((b)menuItem0).setNumericShortcut(c, v);
            return;
        }
        if(Build.VERSION.SDK_INT >= 26) {
            a.k(menuItem0, c, v);
        }
    }

    public static void f(MenuItem menuItem0, CharSequence charSequence0) {
        if(menuItem0 instanceof b) {
            ((b)menuItem0).setTooltipText(charSequence0);
            return;
        }
        if(Build.VERSION.SDK_INT >= 26) {
            a.m(menuItem0, charSequence0);
        }
    }
}

