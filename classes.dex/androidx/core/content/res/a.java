package androidx.core.content.res;

class a {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;

    a(float f, float f1, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.a = f;
        this.b = f1;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = f5;
        this.g = f6;
        this.h = f7;
        this.i = f8;
    }

    float a(a a0) {
        float f = this.l();
        float f1 = a0.l();
        float f2 = this.g();
        float f3 = a0.g();
        float f4 = this.h();
        float f5 = a0.h();
        return (float)(Math.pow(Math.sqrt((f - f1) * (f - f1) + (f2 - f3) * (f2 - f3) + (f4 - f5) * (f4 - f5)), 0.63) * 1.41);
    }

    private static a b(float f, float f1, float f2) {
        float f3 = 100.0f;
        float f4 = 1000.0f;
        float f5 = 0.0f;
        a a0 = null;
        float f6 = 1000.0f;
        while(Math.abs(f5 - f3) > 0.01f) {
            float f7 = (f3 - f5) / 2.0f + f5;
            int v = a.e(f7, f1, f).p();
            float f8 = b.b(v);
            float f9 = Math.abs(f2 - f8);
            if(f9 < 0.2f) {
                a a1 = a.c(v);
                float f10 = a1.a(a.e(a1.k(), a1.i(), f));
                if(f10 <= 1.0f) {
                    a0 = a1;
                    f4 = f9;
                    f6 = f10;
                }
            }
            if(f4 == 0.0f && f6 == 0.0f) {
                break;
            }
            if(f8 < f2) {
                f5 = f7;
            }
            else {
                f3 = f7;
            }
        }
        return a0;
    }

    static a c(int v) {
        return a.d(v, l.k);
    }

    static a d(int v, l l0) {
        float[] arr_f = b.f(v);
        float f = arr_f[0];
        float[] arr_f1 = b.a[0];
        float f1 = arr_f1[0] * f;
        float f2 = arr_f[1];
        float f3 = f1 + arr_f1[1] * f2;
        float f4 = arr_f[2];
        float f5 = f3 + arr_f1[2] * f4;
        float[] arr_f2 = b.a[1];
        float f6 = arr_f2[0] * f + arr_f2[1] * f2 + arr_f2[2] * f4;
        float[] arr_f3 = b.a[2];
        float f7 = f * arr_f3[0] + f2 * arr_f3[1] + f4 * arr_f3[2];
        float f8 = l0.i()[0] * f5;
        float f9 = l0.i()[1] * f6;
        float f10 = l0.i()[2] * f7;
        float f11 = (float)Math.pow(((double)(l0.c() * Math.abs(f8))) / 100.0, 0.42);
        float f12 = (float)Math.pow(((double)(l0.c() * Math.abs(f9))) / 100.0, 0.42);
        float f13 = (float)Math.pow(((double)(l0.c() * Math.abs(f10))) / 100.0, 0.42);
        float f14 = Math.signum(f8) * 400.0f * f11 / (f11 + 27.129999f);
        float f15 = Math.signum(f9) * 400.0f * f12 / (f12 + 27.129999f);
        float f16 = Math.signum(f10) * 400.0f * f13 / (f13 + 27.129999f);
        float f17 = ((float)(((double)f14) * 11.0 + ((double)f15) * -12.0 + ((double)f16))) / 11.0f;
        float f18 = ((float)(((double)(f14 + f15)) - ((double)f16) * 2.0)) / 9.0f;
        float f19 = ((float)Math.atan2(f18, f17)) * 180.0f / 3.141593f;
        if(Float.compare(f19, 0.0f) < 0) {
            f19 += 360.0f;
        }
        else if(f19 >= 360.0f) {
            f19 -= 360.0f;
        }
        float f20 = ((float)Math.pow((f14 * 40.0f + f15 * 20.0f + f16) / 20.0f * l0.f() / l0.a(), l0.b() * l0.j())) * 100.0f;
        float f21 = ((float)Math.pow(1.64 - Math.pow(0.29, l0.e()), 0.73)) * ((float)Math.pow(((float)(Math.cos(((double)(((double)f19) < 20.14 ? f19 + 360.0f : f19)) * 3.141593 / 180.0 + 2.0) + 3.8)) * 961.538452f * l0.g() * l0.h() * ((float)Math.sqrt(f17 * f17 + f18 * f18)) / ((f14 * 20.0f + f15 * 20.0f + 21.0f * f16) / 20.0f + 0.305f), 0.9));
        float f22 = f21 * ((float)Math.sqrt(((double)f20) / 100.0));
        float f23 = f22 * l0.d();
        float f24 = ((float)Math.log(0.0228f * f23 + 1.0f)) * 43.85965f;
        double f25 = (double)(3.141593f * f19 / 180.0f);
        return new a(f19, f22, f20, l0.d() * (4.0f / l0.b() * ((float)Math.sqrt(f20 / 100.0f)) * (l0.a() + 4.0f)), f23, ((float)Math.sqrt(f21 * l0.b() / (l0.a() + 4.0f))) * 50.0f, 1.7f * f20 / (0.007f * f20 + 1.0f), f24 * ((float)Math.cos(f25)), f24 * ((float)Math.sin(f25)));
    }

    private static a e(float f, float f1, float f2) {
        return a.f(f, f1, f2, l.k);
    }

    private static a f(float f, float f1, float f2, l l0) {
        float f3 = f1 * l0.d();
        float f4 = ((float)Math.log(((double)f3) * 0.0228 + 1.0)) * 43.85965f;
        double f5 = (double)(3.141593f * f2 / 180.0f);
        return new a(f2, f1, f, 4.0f / l0.b() * ((float)Math.sqrt(((double)f) / 100.0)) * (l0.a() + 4.0f) * l0.d(), f3, ((float)Math.sqrt(f1 / ((float)Math.sqrt(((double)f) / 100.0)) * l0.b() / (l0.a() + 4.0f))) * 50.0f, 1.7f * f / (0.007f * f + 1.0f), f4 * ((float)Math.cos(f5)), f4 * ((float)Math.sin(f5)));
    }

    float g() {
        return this.h;
    }

    float h() {
        return this.i;
    }

    float i() {
        return this.b;
    }

    float j() {
        return this.a;
    }

    float k() {
        return this.c;
    }

    float l() {
        return this.g;
    }

    static int m(float f, float f1, float f2) {
        return a.n(f, f1, f2, l.k);
    }

    static int n(float f, float f1, float f2, l l0) {
        if(((double)f1) >= 1.0 && ((double)Math.round(f2)) > 0.0 && ((double)Math.round(f2)) < 100.0) {
            float f3 = f < 0.0f ? 0.0f : Math.min(360.0f, f);
            a a0 = null;
            boolean z = true;
            float f4 = 0.0f;
            float f5 = f1;
            while(Math.abs(f4 - f1) >= 0.4f) {
                a a1 = a.b(f3, f5, f2);
                if(z) {
                    if(a1 != null) {
                        return a1.o(l0);
                    }
                    f5 = (f1 - f4) / 2.0f + f4;
                    z = false;
                }
                else {
                    if(a1 == null) {
                        f1 = f5;
                    }
                    else {
                        f4 = f5;
                        a0 = a1;
                    }
                    f5 = (f1 - f4) / 2.0f + f4;
                }
            }
            return a0 == null ? b.a(f2) : a0.o(l0);
        }
        return b.a(f2);
    }

    int o(l l0) {
        float f = (float)Math.pow(((double)(Double.compare(this.i(), 0.0) == 0 || ((double)this.k()) == 0.0 ? 0.0f : this.i() / ((float)Math.sqrt(((double)this.k()) / 100.0)))) / Math.pow(1.64 - Math.pow(0.29, l0.e()), 0.73), 1.111111);
        double f1 = (double)(this.j() * 3.141593f / 180.0f);
        float f2 = l0.a() * ((float)Math.pow(((double)this.k()) / 100.0, 1.0 / ((double)l0.b()) / ((double)l0.j()))) / l0.f();
        float f3 = (float)Math.sin(f1);
        float f4 = (float)Math.cos(f1);
        float f5 = (f2 + 0.305f) * 23.0f * f / (((float)(Math.cos(f1 + 2.0) + 3.8)) * 961.538452f * l0.g() * l0.h() * 23.0f + 11.0f * f * f4 + f * 108.0f * f3);
        float f6 = f4 * f5;
        float f7 = f5 * f3;
        float f8 = (451.0f * f6 + f2 * 460.0f + 288.0f * f7) / 1403.0f;
        float f9 = (f2 * 460.0f - 891.0f * f6 - 261.0f * f7) / 1403.0f;
        float f10 = (f2 * 460.0f - f6 * 220.0f - f7 * 6300.0f) / 1403.0f;
        float f11 = Math.signum(f8) * (100.0f / l0.c()) * ((float)Math.pow(((float)Math.max(0.0, ((double)Math.abs(f8)) * 27.13 / (400.0 - ((double)Math.abs(f8))))), 2.380952)) / l0.i()[0];
        float f12 = Math.signum(f9) * (100.0f / l0.c()) * ((float)Math.pow(((float)Math.max(0.0, ((double)Math.abs(f9)) * 27.13 / (400.0 - ((double)Math.abs(f9))))), 2.380952)) / l0.i()[1];
        float f13 = Math.signum(f10) * (100.0f / l0.c()) * ((float)Math.pow(((float)Math.max(0.0, ((double)Math.abs(f10)) * 27.13 / (400.0 - ((double)Math.abs(f10))))), 2.380952)) / l0.i()[2];
        float[] arr_f = b.b[0];
        float f14 = arr_f[0] * f11 + arr_f[1] * f12 + arr_f[2] * f13;
        float[] arr_f1 = b.b[1];
        float f15 = arr_f1[0] * f11 + arr_f1[1] * f12 + arr_f1[2] * f13;
        float[] arr_f2 = b.b[2];
        return androidx.core.graphics.a.a(f14, f15, f11 * arr_f2[0] + f12 * arr_f2[1] + f13 * arr_f2[2]);
    }

    int p() {
        return this.o(l.k);
    }
}

