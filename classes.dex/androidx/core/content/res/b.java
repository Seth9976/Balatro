package androidx.core.content.res;

import android.graphics.Color;
import androidx.core.graphics.a;

abstract class b {
    static final float[][] a;
    static final float[][] b;
    static final float[] c;
    static final float[][] d;

    static {
        b.a = new float[][]{new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
        b.b = new float[][]{new float[]{1.862068f, -1.011255f, 0.149187f}, new float[]{0.387527f, 0.621447f, -0.008974f}, new float[]{-0.015842f, -0.034123f, 1.049964f}};
        b.c = new float[]{95.046997f, 100.0f, 108.883003f};
        b.d = new float[][]{new float[]{0.412339f, 0.357621f, 0.18051f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.019321f, 0.119164f, 0.950345f}};
    }

    static int a(float f) {
        if(f < 1.0f) {
            return 0xFF000000;
        }
        if(f > 99.0f) {
            return -1;
        }
        float f1 = (f + 16.0f) / 116.0f;
        float f2 = Float.compare(f, 8.0f) <= 0 ? f1 * f1 * f1 : f / 903.296326f;
        float f3 = f1 * f1 * f1;
        float f4 = f3 > 0.008856f ? f3 : (f1 * 116.0f - 16.0f) / 903.296326f;
        if(f3 <= 0.008856f) {
            f3 = (f1 * 116.0f - 16.0f) / 903.296326f;
        }
        return a.a(f4 * b.c[0], f2 * b.c[1], f3 * b.c[2]);
    }

    static float b(int v) {
        return b.c(b.g(v));
    }

    static float c(float f) {
        return f / 100.0f <= 0.008856f ? f / 100.0f * 903.296326f : ((float)Math.cbrt(f / 100.0f)) * 116.0f - 16.0f;
    }

    static float d(float f, float f1, float f2) [...] // Inlined contents

    static float e(int v) {
        return Float.compare(((float)v) / 255.0f, 0.04045f) > 0 ? ((float)Math.pow((((float)v) / 255.0f + 0.055f) / 1.055f, 2.4)) * 100.0f : ((float)v) / 255.0f / 12.92f * 100.0f;
    }

    static float[] f(int v) {
        float f = b.e(Color.red(v));
        float f1 = b.e(Color.green(v));
        float f2 = b.e(Color.blue(v));
        float[] arr_f = b.d[0];
        float f3 = arr_f[0] * f + arr_f[1] * f1 + arr_f[2] * f2;
        float[] arr_f1 = b.d[1];
        float f4 = arr_f1[0] * f + arr_f1[1] * f1 + arr_f1[2] * f2;
        float[] arr_f2 = b.d[2];
        return new float[]{f3, f4, f * arr_f2[0] + f1 * arr_f2[1] + f2 * arr_f2[2]};
    }

    static float g(int v) {
        float f = b.e(Color.red(v));
        float f1 = b.e(Color.green(v));
        float f2 = b.e(Color.blue(v));
        float[] arr_f = b.d[1];
        return f * arr_f[0] + f1 * arr_f[1] + f2 * arr_f[2];
    }

    static float h(float f) [...] // Inlined contents
}

