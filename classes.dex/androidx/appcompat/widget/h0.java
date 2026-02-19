package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.a;
import c.i;

public abstract class h0 {
    private static final ThreadLocal a;
    static final int[] b;
    static final int[] c;
    static final int[] d;
    static final int[] e;
    static final int[] f;
    static final int[] g;
    static final int[] h;
    static final int[] i;
    private static final int[] j;

    static {
        h0.a = new ThreadLocal();
        h0.b = new int[]{0xFEFEFF62};
        h0.c = new int[]{0x101009C};
        h0.d = new int[]{0x10102FE};
        h0.e = new int[]{0x10100A7};
        h0.f = new int[]{0x10100A0};
        h0.g = new int[]{0x10100A1};
        h0.h = new int[]{0xFEFEFF59, 0xFEFEFF64};
        h0.i = new int[0];
        h0.j = new int[1];
    }

    public static void a(View view0, Context context0) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(i.k0);
        try {
            if(!typedArray0.hasValue(i.l0)) {
                Log.e("ThemeUtils", "View " + view0.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        }
        finally {
            typedArray0.recycle();
        }
    }

    public static int b(Context context0, int v) {
        ColorStateList colorStateList0 = h0.e(context0, v);
        if(colorStateList0 != null && colorStateList0.isStateful()) {
            int v1 = colorStateList0.getDefaultColor();
            return colorStateList0.getColorForState(h0.b, v1);
        }
        TypedValue typedValue0 = h0.f();
        context0.getTheme().resolveAttribute(0x1010033, typedValue0, true);
        return h0.d(context0, v, typedValue0.getFloat());
    }

    public static int c(Context context0, int v) {
        h0.j[0] = v;
        l0 l00 = l0.r(context0, null, h0.j);
        try {
            return l00.b(0, 0);
        }
        finally {
            l00.t();
        }
    }

    static int d(Context context0, int v, float f) {
        int v1 = h0.c(context0, v);
        return a.f(v1, Math.round(((float)Color.alpha(v1)) * f));
    }

    public static ColorStateList e(Context context0, int v) {
        h0.j[0] = v;
        l0 l00 = l0.r(context0, null, h0.j);
        try {
            return l00.c(0);
        }
        finally {
            l00.t();
        }
    }

    private static TypedValue f() {
        ThreadLocal threadLocal0 = h0.a;
        TypedValue typedValue0 = (TypedValue)threadLocal0.get();
        if(typedValue0 == null) {
            typedValue0 = new TypedValue();
            threadLocal0.set(typedValue0);
        }
        return typedValue0;
    }
}

