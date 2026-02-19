package androidx.core.content.res;

final class l {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float[] g;
    private final float h;
    private final float i;
    private final float j;
    static final l k;

    static {
        l.k = l.k(b.c, 11.725677f, 50.0f, 2.0f, false);
    }

    private l(float f, float f1, float f2, float f3, float f4, float f5, float[] arr_f, float f6, float f7, float f8) {
        this.f = f;
        this.a = f1;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.g = arr_f;
        this.h = f6;
        this.i = f7;
        this.j = f8;
    }

    float a() {
        return this.a;
    }

    float b() {
        return this.d;
    }

    float c() {
        return this.h;
    }

    float d() {
        return this.i;
    }

    float e() {
        return this.f;
    }

    float f() {
        return this.b;
    }

    float g() {
        return this.e;
    }

    float h() {
        return this.c;
    }

    float[] i() {
        return this.g;
    }

    float j() {
        return this.j;
    }

    static l k(float[] arr_f, float f, float f1, float f2, boolean z) {
        float f3 = arr_f[0];
        float[] arr_f1 = b.a[0];
        float f4 = arr_f1[0] * f3;
        float f5 = arr_f[1];
        float f6 = f4 + arr_f1[1] * f5;
        float f7 = arr_f[2];
        float f8 = f6 + arr_f1[2] * f7;
        float[] arr_f2 = b.a[1];
        float f9 = arr_f2[0] * f3 + arr_f2[1] * f5 + arr_f2[2] * f7;
        float[] arr_f3 = b.a[2];
        float f10 = f3 * arr_f3[0] + f5 * arr_f3[1] + f7 * arr_f3[2];
        float f11 = f2 / 10.0f + 0.8f;
        float f12 = Double.compare(f11, 0.9) < 0 ? 0.525f + 0.065f * ((f11 - 0.8f) * 10.0f) : 0.59f + 0.1f * ((f11 - 0.9f) * 10.0f);
        float f13 = z ? 1.0f : (1.0f - ((float)Math.exp((-f - 42.0f) / 92.0f)) * 0.277778f) * f11;
        if(((double)f13) > 1.0) {
            f13 = 1.0f;
        }
        else if(((double)f13) < 0.0) {
            f13 = 0.0f;
        }
        float[] arr_f4 = {100.0f / f8 * f13 + 1.0f - f13, 100.0f / f9 * f13 + 1.0f - f13, 100.0f / f10 * f13 + 1.0f - f13};
        float f14 = 1.0f / (5.0f * f + 1.0f);
        float f15 = f14 * f14 * f14 * f14;
        float f16 = f15 * f + 0.1f * (1.0f - f15) * (1.0f - f15) * ((float)Math.cbrt(((double)f) * 5.0));
        float f17 = b.h(f1) / arr_f[1];
        float f18 = 0.725f / ((float)Math.pow(f17, 0.2));
        float f19 = (float)Math.pow(((double)(arr_f4[0] * f16 * f8)) / 100.0, 0.42);
        float f20 = (float)Math.pow(((double)(arr_f4[1] * f16 * f9)) / 100.0, 0.42);
        float f21 = (float)Math.pow(((double)(arr_f4[2] * f16 * f10)) / 100.0, 0.42);
        return new l(f17, (f19 * 400.0f / (f19 + 27.129999f) * 2.0f + f20 * 400.0f / (f20 + 27.129999f) + 400.0f * f21 / (f21 + 27.129999f) * 0.05f) * f18, f18, f18, f12, f11, arr_f4, f16, ((float)Math.pow(f16, 0.25)), ((float)Math.sqrt(f17)) + 1.48f);
    }
}

