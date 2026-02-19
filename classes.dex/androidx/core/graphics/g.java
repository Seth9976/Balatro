package androidx.core.graphics;

import android.graphics.Paint;

public abstract class g {
    static abstract class a {
        static boolean a(Paint paint0, String s) {
            return paint0.hasGlyph(s);
        }
    }

    private static final ThreadLocal a;

    static {
        g.a = new ThreadLocal();
    }

    public static boolean a(Paint paint0, String s) {
        return a.a(paint0, s);
    }
}

