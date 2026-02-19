package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.v;

public abstract class a implements View.OnTouchListener {
    static class androidx.core.widget.a.a {
        private int a;
        private int b;
        private float c;
        private float d;
        private long e;
        private long f;
        private int g;
        private int h;
        private long i;
        private float j;
        private int k;

        androidx.core.widget.a.a() {
            this.e = 0x8000000000000000L;
            this.i = -1L;
            this.f = 0L;
            this.g = 0;
            this.h = 0;
        }

        public void a() {
            if(this.f == 0L) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long v = AnimationUtils.currentAnimationTimeMillis();
            float f = this.g(this.e(v));
            long v1 = v - this.f;
            this.f = v;
            float f1 = ((float)v1) * f;
            this.g = (int)(this.c * f1);
            this.h = (int)(f1 * this.d);
        }

        public int b() {
            return this.g;
        }

        public int c() {
            return this.h;
        }

        public int d() {
            return (int)(this.c / Math.abs(this.c));
        }

        private float e(long v) {
            long v1 = this.e;
            if(Long.compare(v, v1) < 0) {
                return 0.0f;
            }
            return Long.compare(this.i, 0L) < 0 || v < this.i ? a.e(((float)(v - v1)) / ((float)this.a), 0.0f, 1.0f) * 0.5f : 1.0f - this.j + this.j * a.e(((float)(v - this.i)) / ((float)this.k), 0.0f, 1.0f);
        }

        public int f() {
            return (int)(this.d / Math.abs(this.d));
        }

        private float g(float f) {
            return -4.0f * f * f + f * 4.0f;
        }

        public boolean h() {
            return this.i > 0L && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long)this.k);
        }

        public void i() {
            long v = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.f(((int)(v - this.e)), 0, this.b);
            this.j = this.e(v);
            this.i = v;
        }

        public void j(int v) {
            this.b = v;
        }

        public void k(int v) {
            this.a = v;
        }

        public void l(float f, float f1) {
            this.c = f;
            this.d = f1;
        }

        public void m() {
            long v = AnimationUtils.currentAnimationTimeMillis();
            this.e = v;
            this.i = -1L;
            this.f = v;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }
    }

    class b implements Runnable {
        final a e;

        @Override
        public void run() {
            a a0 = a.this;
            if(!a0.o) {
                return;
            }
            if(a0.m) {
                a0.m = false;
                a0.a.m();
            }
            androidx.core.widget.a.a a$a0 = a.this.a;
            if(!a$a0.h() && a.this.u()) {
                a a1 = a.this;
                if(a1.n) {
                    a1.n = false;
                    a1.c();
                }
                a$a0.a();
                a.this.j(a$a0.b(), a$a0.c());
                v.C(a.this.c, this);
                return;
            }
            a.this.o = false;
        }
    }

    final androidx.core.widget.a.a a;
    private final Interpolator b;
    final View c;
    private Runnable d;
    private float[] e;
    private float[] f;
    private int g;
    private int h;
    private float[] i;
    private float[] j;
    private float[] k;
    private boolean l;
    boolean m;
    boolean n;
    boolean o;
    private boolean p;
    private boolean q;
    private static final int r;

    static {
        a.r = ViewConfiguration.getTapTimeout();
    }

    public a(View view0) {
        this.a = new androidx.core.widget.a.a();
        this.b = new AccelerateInterpolator();
        this.e = new float[]{0.0f, 0.0f};
        this.f = new float[]{3.402823E+38f, 3.402823E+38f};
        this.i = new float[]{0.0f, 0.0f};
        this.j = new float[]{0.0f, 0.0f};
        this.k = new float[]{3.402823E+38f, 3.402823E+38f};
        this.c = view0;
        DisplayMetrics displayMetrics0 = Resources.getSystem().getDisplayMetrics();
        int v = (int)(displayMetrics0.density * 315.0f + 0.5f);
        float f = (float)(((int)(1575.0f * displayMetrics0.density + 0.5f)));
        this.o(f, f);
        this.p(((float)v), ((float)v));
        this.l(1);
        this.n(3.402823E+38f, 3.402823E+38f);
        this.s(0.2f, 0.2f);
        this.t(1.0f, 1.0f);
        this.k(a.r);
        this.r(500);
        this.q(500);
    }

    public abstract boolean a(int arg1);

    public abstract boolean b(int arg1);

    void c() {
        long v = SystemClock.uptimeMillis();
        MotionEvent motionEvent0 = MotionEvent.obtain(v, v, 3, 0.0f, 0.0f, 0);
        this.c.onTouchEvent(motionEvent0);
        motionEvent0.recycle();
    }

    private float d(int v, float f, float f1, float f2) {
        float f3 = this.h(this.e[v], f1, this.f[v], f);
        int v1 = Float.compare(f3, 0.0f);
        if(v1 == 0) {
            return 0.0f;
        }
        float f4 = this.i[v];
        float f5 = this.j[v];
        float f6 = this.k[v];
        float f7 = f4 * f2;
        return v1 <= 0 ? -a.e(-f3 * f7, f5, f6) : a.e(f3 * f7, f5, f6);
    }

    static float e(float f, float f1, float f2) {
        if(f > f2) {
            return f2;
        }
        return f < f1 ? f1 : f;
    }

    static int f(int v, int v1, int v2) {
        if(v > v2) {
            return v2;
        }
        return v >= v1 ? v : v1;
    }

    private float g(float f, float f1) {
        if(f1 == 0.0f) {
            return 0.0f;
        }
        int v = this.g;
        if(v != 0 && v != 1) {
            return v != 2 || f >= 0.0f ? 0.0f : f / -f1;
        }
        if(f < f1) {
            if(Float.compare(f, 0.0f) >= 0) {
                return 1.0f - f / f1;
            }
            return !this.o || v != 1 ? 0.0f : 1.0f;
        }
        return 0.0f;
    }

    private float h(float f, float f1, float f2, float f3) {
        float f4 = a.e(f * f1, 0.0f, f2);
        float f5 = this.g(f1 - f3, f4) - this.g(f3, f4);
        if(f5 < 0.0f) {
            return a.e(-this.b.getInterpolation(-f5), -1.0f, 1.0f);
        }
        return f5 > 0.0f ? a.e(this.b.getInterpolation(f5), -1.0f, 1.0f) : 0.0f;
    }

    private void i() {
        if(this.m) {
            this.o = false;
            return;
        }
        this.a.i();
    }

    public abstract void j(int arg1, int arg2);

    public a k(int v) {
        this.h = v;
        return this;
    }

    public a l(int v) {
        this.g = v;
        return this;
    }

    public a m(boolean z) {
        if(this.p && !z) {
            this.i();
        }
        this.p = z;
        return this;
    }

    public a n(float f, float f1) {
        float[] arr_f = this.f;
        arr_f[0] = f;
        arr_f[1] = f1;
        return this;
    }

    public a o(float f, float f1) {
        float[] arr_f = this.k;
        arr_f[0] = f / 1000.0f;
        arr_f[1] = f1 / 1000.0f;
        return this;
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View view0, MotionEvent motionEvent0) {
        if(!this.p) {
            return false;
        }
        switch(motionEvent0.getActionMasked()) {
            case 0: {
                this.n = true;
                this.l = false;
                break;
            }
            case 2: {
                break;
            }
            case 1: 
            case 3: {
                this.i();
                return this.q && this.o;
            }
            default: {
                return this.q && this.o;
            }
        }
        float f = this.d(0, motionEvent0.getX(), ((float)view0.getWidth()), ((float)this.c.getWidth()));
        float f1 = this.d(1, motionEvent0.getY(), ((float)view0.getHeight()), ((float)this.c.getHeight()));
        this.a.l(f, f1);
        if(!this.o && this.u()) {
            this.v();
        }
        return this.q && this.o;
    }

    public a p(float f, float f1) {
        float[] arr_f = this.j;
        arr_f[0] = f / 1000.0f;
        arr_f[1] = f1 / 1000.0f;
        return this;
    }

    public a q(int v) {
        this.a.j(v);
        return this;
    }

    public a r(int v) {
        this.a.k(v);
        return this;
    }

    public a s(float f, float f1) {
        float[] arr_f = this.e;
        arr_f[0] = f;
        arr_f[1] = f1;
        return this;
    }

    public a t(float f, float f1) {
        float[] arr_f = this.i;
        arr_f[0] = f / 1000.0f;
        arr_f[1] = f1 / 1000.0f;
        return this;
    }

    boolean u() {
        int v = this.a.f();
        int v1 = this.a.d();
        return v != 0 && this.b(v) || v1 != 0 && this.a(v1);
    }

    private void v() {
        if(this.d == null) {
            this.d = new b(this);
        }
        this.o = true;
        this.m = true;
        if(this.l) {
            this.d.run();
        }
        else {
            int v = this.h;
            if(v > 0) {
                v.D(this.c, this.d, ((long)v));
            }
            else {
                this.d.run();
            }
        }
        this.l = true;
    }
}

