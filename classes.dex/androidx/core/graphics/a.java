package androidx.core.graphics;

import android.graphics.Color;

public abstract class a {
    private static final ThreadLocal a;

    static {
        a.a = new ThreadLocal();
    }

    public static int a(double f, double f1, double f2) {
        double f3 = (3.2406 * f + -1.5372 * f1 + -0.4986 * f2) / 100.0;
        double f4 = (-0.9689 * f + 1.8758 * f1 + 0.0415 * f2) / 100.0;
        double f5 = (0.0557 * f + -0.204 * f1 + 1.057 * f2) / 100.0;
        double f6 = Double.compare(f3, 0.003131) <= 0 ? f3 * 12.92 : Math.pow(f3, 0.416667) * 1.055 - 0.055;
        double f7 = f4 > 0.003131 ? Math.pow(f4, 0.416667) * 1.055 - 0.055 : f4 * 12.92;
        return f5 > 0.003131 ? Color.rgb(a.e(((int)Math.round(f6 * 255.0)), 0, 0xFF), a.e(((int)Math.round(f7 * 255.0)), 0, 0xFF), a.e(((int)Math.round((Math.pow(f5, 0.416667) * 1.055 - 0.055) * 255.0)), 0, 0xFF)) : Color.rgb(a.e(((int)Math.round(f6 * 255.0)), 0, 0xFF), a.e(((int)Math.round(f7 * 255.0)), 0, 0xFF), a.e(((int)Math.round(f5 * 3294.6)), 0, 0xFF));
    }

    private static int b(int v, int v1) [...] // Inlined contents

    public static int c(int v, int v1) {
        int v2 = Color.alpha(v1);
        int v3 = Color.alpha(v);
        int v4 = 0xFF - (0xFF - v2) * (0xFF - v3) / 0xFF;
        return Color.argb(v4, a.d(Color.red(v), v3, Color.red(v1), v2, v4), a.d(Color.green(v), v3, Color.green(v1), v2, v4), a.d(Color.blue(v), v3, Color.blue(v1), v2, v4));
    }

    private static int d(int v, int v1, int v2, int v3, int v4) {
        return v4 == 0 ? 0 : (v * 0xFF * v1 + v2 * v3 * (0xFF - v1)) / (v4 * 0xFF);
    }

    private static int e(int v, int v1, int v2) {
        return v < v1 ? v1 : Math.min(v, v2);
    }

    public static int f(int v, int v1) {
        if(v1 < 0 || v1 > 0xFF) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return v & 0xFFFFFF | v1 << 24;
    }
}

