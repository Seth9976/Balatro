package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import c.b;
import c.c;
import c.d;

public final class f {
    private c0 a;
    private static final PorterDuff.Mode b;
    private static f c;

    static {
        f.b = PorterDuff.Mode.SRC_IN;
    }

    public static f b() {
        synchronized(f.class) {
            if(f.c == null) {
                f.f();
            }
            return f.c;
        }
    }

    public Drawable c(Context context0, int v) {
        synchronized(this) {
            return this.a.j(context0, v);
        }
    }

    public static PorterDuffColorFilter d(int v, PorterDuff.Mode porterDuff$Mode0) {
        synchronized(f.class) {
            return c0.l(v, porterDuff$Mode0);
        }
    }

    ColorStateList e(Context context0, int v) {
        synchronized(this) {
            return this.a.m(context0, v);
        }
    }

    public static void f() {
        class a implements androidx.appcompat.widget.c0.f {
            private final int[] a;
            private final int[] b;
            private final int[] c;
            private final int[] d;
            private final int[] e;
            private final int[] f;

            a() {
                super();
                this.a = new int[]{d.R, d.P, d.a};
                this.b = new int[]{d.o, d.B, d.t, d.p, d.q, d.s, d.r};
                this.c = new int[]{d.O, d.Q, d.k, d.K, d.L, d.M, d.N};
                this.d = new int[]{d.w, d.i, d.v};
                this.e = new int[]{d.J, d.S};
                this.f = new int[]{d.c, d.g, d.d, d.h};
            }

            @Override  // androidx.appcompat.widget.c0$f
            public Drawable a(c0 c00, Context context0, int v) {
                if(v == d.j) {
                    return new LayerDrawable(new Drawable[]{c00.j(context0, d.i), c00.j(context0, d.k)});
                }
                if(v == d.y) {
                    return this.l(c00, context0, c.g);
                }
                if(v == d.x) {
                    return this.l(c00, context0, c.h);
                }
                return v == d.z ? this.l(c00, context0, c.i) : null;
            }

            @Override  // androidx.appcompat.widget.c0$f
            public boolean b(Context context0, int v, Drawable drawable0) {
                int v2;
                boolean z;
                PorterDuff.Mode porterDuff$Mode1;
                int v1;
                PorterDuff.Mode porterDuff$Mode0 = f.b;
                if(this.f(this.a, v)) {
                    v1 = c.a.l;
                    porterDuff$Mode1 = porterDuff$Mode0;
                    z = true;
                    v2 = -1;
                }
                else if(this.f(this.c, v)) {
                    v1 = c.a.j;
                    porterDuff$Mode1 = porterDuff$Mode0;
                    z = true;
                    v2 = -1;
                }
                else if(this.f(this.d, v)) {
                    porterDuff$Mode0 = PorterDuff.Mode.MULTIPLY;
                    porterDuff$Mode1 = porterDuff$Mode0;
                    v2 = -1;
                    v1 = 0x1010031;
                    z = true;
                }
                else if(v == d.u) {
                    z = true;
                    v2 = 41;
                    v1 = 0x1010030;
                    porterDuff$Mode1 = porterDuff$Mode0;
                }
                else if(v == d.l) {
                    porterDuff$Mode1 = porterDuff$Mode0;
                    v2 = -1;
                    v1 = 0x1010031;
                    z = true;
                }
                else {
                    porterDuff$Mode1 = porterDuff$Mode0;
                    v1 = 0;
                    z = false;
                    v2 = -1;
                }
                if(z) {
                    drawable0 = drawable0.mutate();
                    drawable0.setColorFilter(f.d(h0.c(context0, v1), porterDuff$Mode1));
                    if(v2 != -1) {
                        drawable0.setAlpha(v2);
                    }
                    return true;
                }
                return false;
            }

            @Override  // androidx.appcompat.widget.c0$f
            public ColorStateList c(Context context0, int v) {
                if(v == d.m) {
                    return e.a.a(context0, b.c);
                }
                if(v == d.I) {
                    return e.a.a(context0, b.f);
                }
                if(v == d.H) {
                    return this.k(context0);
                }
                if(v == d.f) {
                    return this.j(context0);
                }
                if(v == d.b) {
                    return this.g(context0);
                }
                if(v == d.e) {
                    return this.i(context0);
                }
                if(v != d.D && v != d.E) {
                    if(this.f(this.b, v)) {
                        return h0.e(context0, c.a.l);
                    }
                    if(this.f(this.e, v)) {
                        return e.a.a(context0, b.b);
                    }
                    if(this.f(this.f, v)) {
                        return e.a.a(context0, b.a);
                    }
                    return v == d.A ? e.a.a(context0, b.d) : null;
                }
                return e.a.a(context0, b.e);
            }

            @Override  // androidx.appcompat.widget.c0$f
            public boolean d(Context context0, int v, Drawable drawable0) {
                int v1;
                Drawable drawable1;
                LayerDrawable layerDrawable0;
                if(v == d.C) {
                    layerDrawable0 = (LayerDrawable)drawable0;
                    this.m(layerDrawable0.findDrawableByLayerId(0x1020000), h0.c(context0, c.a.l), f.b);
                    drawable1 = layerDrawable0.findDrawableByLayerId(0x102000F);
                    v1 = c.a.l;
                }
                else {
                    if(v != d.y && v != d.x && v != d.z) {
                        return false;
                    }
                    layerDrawable0 = (LayerDrawable)drawable0;
                    this.m(layerDrawable0.findDrawableByLayerId(0x1020000), h0.b(context0, c.a.l), f.b);
                    drawable1 = layerDrawable0.findDrawableByLayerId(0x102000F);
                    v1 = c.a.j;
                }
                this.m(drawable1, h0.c(context0, v1), f.b);
                this.m(layerDrawable0.findDrawableByLayerId(0x102000D), h0.c(context0, c.a.j), f.b);
                return true;
            }

            @Override  // androidx.appcompat.widget.c0$f
            public PorterDuff.Mode e(int v) {
                return v == d.H ? PorterDuff.Mode.MULTIPLY : null;
            }

            private boolean f(int[] arr_v, int v) {
                for(int v1 = 0; v1 < arr_v.length; ++v1) {
                    if(arr_v[v1] == v) {
                        return true;
                    }
                }
                return false;
            }

            private ColorStateList g(Context context0) {
                return this.h(context0, 0);
            }

            private ColorStateList h(Context context0, int v) {
                int[][] arr2_v = new int[4][];
                int[] arr_v = new int[4];
                int v1 = h0.c(context0, c.a.k);
                int v2 = h0.b(context0, c.a.i);
                arr2_v[0] = h0.b;
                arr_v[0] = v2;
                arr2_v[1] = h0.e;
                arr_v[1] = androidx.core.graphics.a.c(v1, v);
                arr2_v[2] = h0.c;
                arr_v[2] = androidx.core.graphics.a.c(v1, v);
                arr2_v[3] = h0.i;
                arr_v[3] = v;
                return new ColorStateList(arr2_v, arr_v);
            }

            private ColorStateList i(Context context0) {
                return this.h(context0, h0.c(context0, c.a.h));
            }

            private ColorStateList j(Context context0) {
                return this.h(context0, h0.c(context0, c.a.i));
            }

            private ColorStateList k(Context context0) {
                int[][] arr2_v = new int[3][];
                int[] arr_v = new int[3];
                ColorStateList colorStateList0 = h0.e(context0, c.a.m);
                if(colorStateList0 != null && colorStateList0.isStateful()) {
                    arr2_v[0] = h0.b;
                    arr_v[0] = colorStateList0.getColorForState(h0.b, 0);
                    arr2_v[1] = h0.f;
                    arr_v[1] = h0.c(context0, c.a.j);
                    arr2_v[2] = h0.i;
                    arr_v[2] = colorStateList0.getDefaultColor();
                    return new ColorStateList(arr2_v, arr_v);
                }
                arr2_v[0] = h0.b;
                arr_v[0] = h0.b(context0, c.a.m);
                arr2_v[1] = h0.f;
                arr_v[1] = h0.c(context0, c.a.j);
                arr2_v[2] = h0.i;
                arr_v[2] = h0.c(context0, c.a.m);
                return new ColorStateList(arr2_v, arr_v);
            }

            private LayerDrawable l(c0 c00, Context context0, int v) {
                BitmapDrawable bitmapDrawable2;
                BitmapDrawable bitmapDrawable1;
                BitmapDrawable bitmapDrawable0;
                int v1 = context0.getResources().getDimensionPixelSize(v);
                Drawable drawable0 = c00.j(context0, d.F);
                Drawable drawable1 = c00.j(context0, d.G);
                if(!(drawable0 instanceof BitmapDrawable) || drawable0.getIntrinsicWidth() != v1 || drawable0.getIntrinsicHeight() != v1) {
                    Bitmap bitmap0 = Bitmap.createBitmap(v1, v1, Bitmap.Config.ARGB_8888);
                    Canvas canvas0 = new Canvas(bitmap0);
                    drawable0.setBounds(0, 0, v1, v1);
                    drawable0.draw(canvas0);
                    bitmapDrawable0 = new BitmapDrawable(bitmap0);
                    bitmapDrawable1 = new BitmapDrawable(bitmap0);
                }
                else {
                    bitmapDrawable0 = (BitmapDrawable)drawable0;
                    bitmapDrawable1 = new BitmapDrawable(bitmapDrawable0.getBitmap());
                }
                bitmapDrawable1.setTileModeX(Shader.TileMode.REPEAT);
                if(!(drawable1 instanceof BitmapDrawable) || drawable1.getIntrinsicWidth() != v1 || drawable1.getIntrinsicHeight() != v1) {
                    Bitmap bitmap1 = Bitmap.createBitmap(v1, v1, Bitmap.Config.ARGB_8888);
                    Canvas canvas1 = new Canvas(bitmap1);
                    drawable1.setBounds(0, 0, v1, v1);
                    drawable1.draw(canvas1);
                    bitmapDrawable2 = new BitmapDrawable(bitmap1);
                }
                else {
                    bitmapDrawable2 = (BitmapDrawable)drawable1;
                }
                LayerDrawable layerDrawable0 = new LayerDrawable(new Drawable[]{bitmapDrawable0, bitmapDrawable2, bitmapDrawable1});
                layerDrawable0.setId(0, 0x1020000);
                layerDrawable0.setId(1, 0x102000F);
                layerDrawable0.setId(2, 0x102000D);
                return layerDrawable0;
            }

            private void m(Drawable drawable0, int v, PorterDuff.Mode porterDuff$Mode0) {
                drawable0 = drawable0.mutate();
                if(porterDuff$Mode0 == null) {
                    porterDuff$Mode0 = f.b;
                }
                drawable0.setColorFilter(f.d(v, porterDuff$Mode0));
            }
        }

        synchronized(f.class) {
            if(f.c == null) {
                f f0 = new f();
                f.c = f0;
                f0.a = c0.h();
                f.c.a.t(new a());
            }
        }
    }

    static void g(Drawable drawable0, j0 j00, int[] arr_v) {
        c0.v(drawable0, j00, arr_v);
    }
}

