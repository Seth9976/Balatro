package androidx.appcompat.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public abstract class u {
    private static final int[] a;
    private static final int[] b;
    public static final Rect c;

    static {
        u.a = new int[]{0x10100A0};
        u.b = new int[0];
        u.c = new Rect();
    }

    public static boolean a(Drawable drawable0) [...] // Inlined contents

    static void b(Drawable drawable0) {
        String s = drawable0.getClass().getName();
        if(Build.VERSION.SDK_INT >= 29 && Build.VERSION.SDK_INT < 0x1F && "android.graphics.drawable.ColorStateListDrawable".equals(s)) {
            u.c(drawable0);
        }
    }

    private static void c(Drawable drawable0) {
        int[] arr_v = drawable0.getState();
        if(arr_v == null || arr_v.length == 0) {
            drawable0.setState(u.a);
        }
        else {
            drawable0.setState(u.b);
        }
        drawable0.setState(arr_v);
    }

    public static PorterDuff.Mode d(int v, PorterDuff.Mode porterDuff$Mode0) {
        switch(v) {
            case 3: {
                return PorterDuff.Mode.SRC_OVER;
            }
            case 5: {
                return PorterDuff.Mode.SRC_IN;
            }
            case 9: {
                return PorterDuff.Mode.SRC_ATOP;
            }
            case 14: {
                return PorterDuff.Mode.MULTIPLY;
            }
            case 15: {
                return PorterDuff.Mode.SCREEN;
            }
            case 16: {
                return PorterDuff.Mode.ADD;
            }
            default: {
                return porterDuff$Mode0;
            }
        }
    }
}

