package androidx.core.view;

import android.view.ViewGroup.MarginLayoutParams;

public abstract class h {
    static abstract class a {
        static int a(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
            return viewGroup$MarginLayoutParams0.getLayoutDirection();
        }

        static int b(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
            return viewGroup$MarginLayoutParams0.getMarginEnd();
        }

        static int c(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
            return viewGroup$MarginLayoutParams0.getMarginStart();
        }

        static boolean d(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
            return viewGroup$MarginLayoutParams0.isMarginRelative();
        }

        static void e(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v) {
            viewGroup$MarginLayoutParams0.resolveLayoutDirection(v);
        }

        static void f(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v) {
            viewGroup$MarginLayoutParams0.setLayoutDirection(v);
        }

        static void g(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v) {
            viewGroup$MarginLayoutParams0.setMarginEnd(v);
        }

        static void h(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v) {
            viewGroup$MarginLayoutParams0.setMarginStart(v);
        }
    }

    public static int a(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
        return a.b(viewGroup$MarginLayoutParams0);
    }

    public static int b(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
        return a.c(viewGroup$MarginLayoutParams0);
    }
}

