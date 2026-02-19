package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets.Builder;
import android.view.WindowInsets;
import androidx.core.graphics.f;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class a0 {
    static abstract class a {
        private static Field a;
        private static Field b;
        private static Field c;
        private static boolean d;

        static {
            try {
                Field field0 = View.class.getDeclaredField("mAttachInfo");
                a.a = field0;
                field0.setAccessible(true);
                Class class0 = Class.forName("android.view.View$AttachInfo");
                Field field1 = class0.getDeclaredField("mStableInsets");
                a.b = field1;
                field1.setAccessible(true);
                Field field2 = class0.getDeclaredField("mContentInsets");
                a.c = field2;
                field2.setAccessible(true);
                a.d = true;
            }
            catch(ReflectiveOperationException reflectiveOperationException0) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + reflectiveOperationException0.getMessage(), reflectiveOperationException0);
            }
        }

        public static a0 a(View view0) {
            if(a.d && view0.isAttachedToWindow()) {
                View view1 = view0.getRootView();
                try {
                    Object object0 = a.a.get(view1);
                    if(object0 != null) {
                        Rect rect0 = (Rect)a.b.get(object0);
                        Rect rect1 = (Rect)a.c.get(object0);
                        if(rect0 != null && rect1 != null) {
                            a0 a00 = new b().b(f.c(rect0)).c(f.c(rect1)).a();
                            a00.q(a00);
                            a00.d(view0.getRootView());
                            return a00;
                        }
                    }
                }
                catch(IllegalAccessException illegalAccessException0) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + illegalAccessException0.getMessage(), illegalAccessException0);
                }
            }
            return null;
        }
    }

    public static final class b {
        private final androidx.core.view.a0.f a;

        public b() {
            d a0$d0;
            int v = Build.VERSION.SDK_INT;
            if(v >= 30) {
                a0$d0 = new e();
            }
            else if(v >= 29) {
                a0$d0 = new d();
            }
            else {
                a0$d0 = new c();
            }
            this.a = a0$d0;
        }

        public b(a0 a00) {
            d a0$d0;
            int v = Build.VERSION.SDK_INT;
            if(v >= 30) {
                a0$d0 = new e(a00);
            }
            else if(v >= 29) {
                a0$d0 = new d(a00);
            }
            else {
                a0$d0 = new c(a00);
            }
            this.a = a0$d0;
        }

        public a0 a() {
            return this.a.b();
        }

        public b b(f f0) {
            this.a.d(f0);
            return this;
        }

        public b c(f f0) {
            this.a.f(f0);
            return this;
        }
    }

    static class c extends androidx.core.view.a0.f {
        private WindowInsets c;
        private f d;
        private static Field e;
        private static boolean f;
        private static Constructor g;
        private static boolean h;

        static {
        }

        c() {
            this.c = c.h();
        }

        c(a0 a00) {
            super(a00);
            this.c = a00.s();
        }

        @Override  // androidx.core.view.a0$f
        a0 b() {
            this.a();
            a0 a00 = a0.t(this.c);
            a00.o(this.b);
            a00.r(this.d);
            return a00;
        }

        @Override  // androidx.core.view.a0$f
        void d(f f0) {
            this.d = f0;
        }

        @Override  // androidx.core.view.a0$f
        void f(f f0) {
            WindowInsets windowInsets0 = this.c;
            if(windowInsets0 != null) {
                this.c = windowInsets0.replaceSystemWindowInsets(f0.a, f0.b, f0.c, f0.d);
            }
        }

        private static WindowInsets h() {
            Class class0 = WindowInsets.class;
            if(!c.f) {
                try {
                    c.e = class0.getDeclaredField("CONSUMED");
                }
                catch(ReflectiveOperationException reflectiveOperationException0) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", reflectiveOperationException0);
                }
                c.f = true;
            }
            Field field0 = c.e;
            if(field0 != null) {
                try {
                    WindowInsets windowInsets0 = (WindowInsets)field0.get(null);
                    if(windowInsets0 != null) {
                        return new WindowInsets(windowInsets0);
                    }
                }
                catch(ReflectiveOperationException reflectiveOperationException1) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", reflectiveOperationException1);
                }
            }
            if(!c.h) {
                try {
                    c.g = class0.getConstructor(Rect.class);
                }
                catch(ReflectiveOperationException reflectiveOperationException2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", reflectiveOperationException2);
                }
                c.h = true;
            }
            Constructor constructor0 = c.g;
            if(constructor0 != null) {
                try {
                    return (WindowInsets)constructor0.newInstance(new Rect());
                }
                catch(ReflectiveOperationException reflectiveOperationException3) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", reflectiveOperationException3);
                }
            }
            return null;
        }
    }

    static class d extends androidx.core.view.a0.f {
        final WindowInsets.Builder c;

        d() {
            this.c = h0.a();
        }

        d(a0 a00) {
            super(a00);
            WindowInsets windowInsets0 = a00.s();
            this.c = windowInsets0 == null ? h0.a() : i0.a(windowInsets0);
        }

        @Override  // androidx.core.view.a0$f
        a0 b() {
            this.a();
            a0 a00 = a0.t(this.c.build());
            a00.o(this.b);
            return a00;
        }

        @Override  // androidx.core.view.a0$f
        void c(f f0) {
            Insets insets0 = f0.e();
            this.c.setMandatorySystemGestureInsets(insets0);
        }

        @Override  // androidx.core.view.a0$f
        void d(f f0) {
            Insets insets0 = f0.e();
            this.c.setStableInsets(insets0);
        }

        @Override  // androidx.core.view.a0$f
        void e(f f0) {
            Insets insets0 = f0.e();
            this.c.setSystemGestureInsets(insets0);
        }

        @Override  // androidx.core.view.a0$f
        void f(f f0) {
            Insets insets0 = f0.e();
            this.c.setSystemWindowInsets(insets0);
        }

        @Override  // androidx.core.view.a0$f
        void g(f f0) {
            Insets insets0 = f0.e();
            this.c.setTappableElementInsets(insets0);
        }
    }

    static class e extends d {
        e() {
        }

        e(a0 a00) {
            super(a00);
        }
    }

    static abstract class androidx.core.view.a0.f {
        private final a0 a;
        f[] b;

        androidx.core.view.a0.f() {
            this(new a0(null));
        }

        androidx.core.view.a0.f(a0 a00) {
            this.a = a00;
        }

        protected final void a() {
            f[] arr_f = this.b;
            if(arr_f != null) {
                f f0 = arr_f[m.a(1)];
                f[] arr_f1 = this.b;
                f f1 = arr_f1[m.a(2)];
                if(f1 == null) {
                    f1 = this.a.f(2);
                }
                if(f0 == null) {
                    f0 = this.a.f(1);
                }
                this.f(f.a(f0, f1));
                f[] arr_f2 = this.b;
                f f2 = arr_f2[m.a(16)];
                if(f2 != null) {
                    this.e(f2);
                }
                f[] arr_f3 = this.b;
                f f3 = arr_f3[m.a(0x20)];
                if(f3 != null) {
                    this.c(f3);
                }
                f[] arr_f4 = this.b;
                f f4 = arr_f4[m.a(0x40)];
                if(f4 != null) {
                    this.g(f4);
                }
            }
        }

        abstract a0 b();

        void c(f f0) {
        }

        abstract void d(f arg1);

        void e(f f0) {
        }

        abstract void f(f arg1);

        void g(f f0) {
        }
    }

    static class g extends l {
        final WindowInsets c;
        private f[] d;
        private f e;
        private a0 f;
        f g;
        private static boolean h;
        private static Method i;
        private static Class j;
        private static Field k;
        private static Field l;

        static {
        }

        g(a0 a00, WindowInsets windowInsets0) {
            super(a00);
            this.e = null;
            this.c = windowInsets0;
        }

        g(a0 a00, g a0$g0) {
            this(a00, new WindowInsets(a0$g0.c));
        }

        @Override  // androidx.core.view.a0$l
        void d(View view0) {
            f f0 = this.w(view0);
            if(f0 == null) {
                f0 = f.e;
            }
            this.q(f0);
        }

        @Override  // androidx.core.view.a0$l
        void e(a0 a00) {
            a00.q(this.f);
            a00.p(this.g);
        }

        @Override  // androidx.core.view.a0$l
        public boolean equals(Object object0) {
            return super.equals(object0) ? Objects.equals(this.g, ((g)object0).g) : false;
        }

        @Override  // androidx.core.view.a0$l
        public f g(int v) {
            return this.t(v, false);
        }

        @Override  // androidx.core.view.a0$l
        final f k() {
            if(this.e == null) {
                this.e = f.b(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.e;
        }

        @Override  // androidx.core.view.a0$l
        a0 m(int v, int v1, int v2, int v3) {
            b a0$b0 = new b(a0.t(this.c));
            a0$b0.c(a0.m(this.k(), v, v1, v2, v3));
            a0$b0.b(a0.m(this.i(), v, v1, v2, v3));
            return a0$b0.a();
        }

        @Override  // androidx.core.view.a0$l
        boolean o() {
            return this.c.isRound();
        }

        @Override  // androidx.core.view.a0$l
        public void p(f[] arr_f) {
            this.d = arr_f;
        }

        @Override  // androidx.core.view.a0$l
        void q(f f0) {
            this.g = f0;
        }

        @Override  // androidx.core.view.a0$l
        void r(a0 a00) {
            this.f = a00;
        }

        private f t(int v, boolean z) {
            f f0 = f.e;
            for(int v1 = 1; v1 <= 0x100; v1 <<= 1) {
                if((v & v1) != 0) {
                    f0 = f.a(f0, this.u(v1, z));
                }
            }
            return f0;
        }

        protected f u(int v, boolean z) {
            f f0 = null;
            switch(v) {
                case 1: {
                    if(z) {
                        f f1 = this.v();
                        f f2 = this.k();
                        return f.b(0, Math.max(f1.b, f2.b), 0, 0);
                    }
                    return f.b(0, this.k().b, 0, 0);
                }
                case 2: {
                    if(z) {
                        f f3 = this.v();
                        f f4 = this.i();
                        return f.b(Math.max(f3.a, f4.a), 0, Math.max(f3.c, f4.c), Math.max(f3.d, f4.d));
                    }
                    f f5 = this.k();
                    a0 a00 = this.f;
                    if(a00 != null) {
                        f0 = a00.g();
                    }
                    return f.b(f5.a, 0, f5.c, (f0 == null ? f5.d : Math.min(f5.d, f0.d)));
                }
                case 8: {
                    f[] arr_f = this.d;
                    if(arr_f != null) {
                        f0 = arr_f[m.a(8)];
                    }
                    if(f0 != null) {
                        return f0;
                    }
                    f f6 = this.k();
                    f f7 = this.v();
                    int v1 = f6.d;
                    if(v1 > f7.d) {
                        return f.b(0, 0, 0, v1);
                    }
                    if(this.g != null && !this.g.equals(f.e)) {
                        int v2 = this.g.d;
                        return v2 <= f7.d ? f.e : f.b(0, 0, 0, v2);
                    }
                    return f.e;
                }
                case 16: {
                    return this.j();
                }
                case 0x20: {
                    return this.h();
                }
                case 0x40: {
                    return this.l();
                }
                case 0x80: {
                    a0 a01 = this.f;
                    androidx.core.view.d d0 = a01 == null ? this.f() : a01.e();
                    return d0 == null ? f.e : f.b(d0.b(), d0.d(), d0.c(), d0.a());
                }
                default: {
                    return f.e;
                }
            }
        }

        private f v() {
            return this.f == null ? f.e : this.f.g();
        }

        private f w(View view0) {
            if(Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if(!g.h) {
                g.x();
            }
            Method method0 = g.i;
            if(method0 != null && g.j != null && g.k != null) {
                try {
                    Object object0 = method0.invoke(view0);
                    if(object0 == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Object object1 = g.l.get(object0);
                    Rect rect0 = (Rect)g.k.get(object1);
                    return rect0 == null ? null : f.c(rect0);
                }
                catch(ReflectiveOperationException reflectiveOperationException0) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + reflectiveOperationException0.getMessage(), reflectiveOperationException0);
                }
            }
            return null;
        }

        private static void x() {
            try {
                g.i = View.class.getDeclaredMethod("getViewRootImpl");
                Class class0 = Class.forName("android.view.View$AttachInfo");
                g.j = class0;
                g.k = class0.getDeclaredField("mVisibleInsets");
                g.l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                g.k.setAccessible(true);
                g.l.setAccessible(true);
            }
            catch(ReflectiveOperationException reflectiveOperationException0) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + reflectiveOperationException0.getMessage(), reflectiveOperationException0);
            }
            g.h = true;
        }
    }

    static class h extends g {
        private f m;

        h(a0 a00, WindowInsets windowInsets0) {
            super(a00, windowInsets0);
            this.m = null;
        }

        h(a0 a00, h a0$h0) {
            super(a00, a0$h0);
            this.m = a0$h0.m;
        }

        @Override  // androidx.core.view.a0$l
        a0 b() {
            return a0.t(this.c.consumeStableInsets());
        }

        @Override  // androidx.core.view.a0$l
        a0 c() {
            return a0.t(this.c.consumeSystemWindowInsets());
        }

        @Override  // androidx.core.view.a0$l
        final f i() {
            if(this.m == null) {
                this.m = f.b(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
            }
            return this.m;
        }

        @Override  // androidx.core.view.a0$l
        boolean n() {
            return this.c.isConsumed();
        }

        @Override  // androidx.core.view.a0$l
        public void s(f f0) {
            this.m = f0;
        }
    }

    static class i extends h {
        i(a0 a00, WindowInsets windowInsets0) {
            super(a00, windowInsets0);
        }

        i(a0 a00, i a0$i0) {
            super(a00, a0$i0);
        }

        @Override  // androidx.core.view.a0$l
        a0 a() {
            return a0.t(this.c.consumeDisplayCutout());
        }

        @Override  // androidx.core.view.a0$g
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof i ? Objects.equals(this.c, ((i)object0).c) && Objects.equals(this.g, ((i)object0).g) : false;
        }

        @Override  // androidx.core.view.a0$l
        androidx.core.view.d f() {
            return androidx.core.view.d.e(this.c.getDisplayCutout());
        }

        @Override  // androidx.core.view.a0$l
        public int hashCode() {
            return this.c.hashCode();
        }
    }

    static class j extends i {
        private f n;
        private f o;
        private f p;

        j(a0 a00, WindowInsets windowInsets0) {
            super(a00, windowInsets0);
            this.n = null;
            this.o = null;
            this.p = null;
        }

        j(a0 a00, j a0$j0) {
            super(a00, a0$j0);
            this.n = null;
            this.o = null;
            this.p = null;
        }

        @Override  // androidx.core.view.a0$l
        f h() {
            if(this.o == null) {
                this.o = f.d(this.c.getMandatorySystemGestureInsets());
            }
            return this.o;
        }

        @Override  // androidx.core.view.a0$l
        f j() {
            if(this.n == null) {
                this.n = f.d(this.c.getSystemGestureInsets());
            }
            return this.n;
        }

        @Override  // androidx.core.view.a0$l
        f l() {
            if(this.p == null) {
                this.p = f.d(this.c.getTappableElementInsets());
            }
            return this.p;
        }

        @Override  // androidx.core.view.a0$g
        a0 m(int v, int v1, int v2, int v3) {
            return a0.t(this.c.inset(v, v1, v2, v3));
        }

        @Override  // androidx.core.view.a0$h
        public void s(f f0) {
        }
    }

    static class k extends j {
        static final a0 q;

        static {
            k.q = a0.t(WindowInsets.CONSUMED);
        }

        k(a0 a00, WindowInsets windowInsets0) {
            super(a00, windowInsets0);
        }

        k(a0 a00, k a0$k0) {
            super(a00, a0$k0);
        }

        @Override  // androidx.core.view.a0$g
        final void d(View view0) {
        }

        @Override  // androidx.core.view.a0$g
        public f g(int v) {
            int v1 = n.a(v);
            return f.d(this.c.getInsets(v1));
        }
    }

    static class l {
        final a0 a;
        static final a0 b;

        static {
            l.b = new b().a().a().b().c();
        }

        l(a0 a00) {
            this.a = a00;
        }

        a0 a() {
            return this.a;
        }

        a0 b() {
            return this.a;
        }

        a0 c() {
            return this.a;
        }

        void d(View view0) {
        }

        void e(a0 a00) {
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof l ? this.o() == ((l)object0).o() && this.n() == ((l)object0).n() && androidx.core.util.b.a(this.k(), ((l)object0).k()) && androidx.core.util.b.a(this.i(), ((l)object0).i()) && androidx.core.util.b.a(this.f(), ((l)object0).f()) : false;
        }

        androidx.core.view.d f() {
            return null;
        }

        f g(int v) {
            return f.e;
        }

        f h() {
            return this.k();
        }

        @Override
        public int hashCode() {
            return androidx.core.util.b.b(new Object[]{Boolean.valueOf(this.o()), Boolean.valueOf(this.n()), this.k(), this.i(), this.f()});
        }

        f i() {
            return f.e;
        }

        f j() {
            return this.k();
        }

        f k() {
            return f.e;
        }

        f l() {
            return this.k();
        }

        a0 m(int v, int v1, int v2, int v3) {
            return l.b;
        }

        boolean n() {
            return false;
        }

        boolean o() {
            return false;
        }

        public void p(f[] arr_f) {
        }

        void q(f f0) {
        }

        void r(a0 a00) {
        }

        public void s(f f0) {
        }
    }

    public static abstract class m {
        static int a(int v) {
            switch(v) {
                case 1: {
                    return 0;
                }
                case 2: {
                    return 1;
                }
                case 4: {
                    return 2;
                }
                case 8: {
                    return 3;
                }
                case 16: {
                    return 4;
                }
                case 0x20: {
                    return 5;
                }
                case 0x40: {
                    return 6;
                }
                case 0x80: {
                    return 7;
                }
                case 0x100: {
                    return 8;
                }
                default: {
                    throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + v);
                }
            }
        }
    }

    static abstract class n {
        static int a(int v) {
            int v1 = 0;
            for(int v2 = 1; v2 <= 0x100; v2 <<= 1) {
                if((v & v2) != 0) {
                    switch(v2) {
                        case 1: {
                            v1 |= r0.a();
                            break;
                        }
                        case 2: {
                            v1 |= s0.a();
                            break;
                        }
                        case 4: {
                            v1 |= t0.a();
                            break;
                        }
                        case 8: {
                            v1 |= u0.a();
                            break;
                        }
                        case 16: {
                            v1 |= v0.a();
                            break;
                        }
                        case 0x20: {
                            v1 |= w0.a();
                            break;
                        }
                        case 0x40: {
                            v1 |= x0.a();
                            break;
                        }
                        case 0x80: {
                            v1 |= y0.a();
                        }
                    }
                }
            }
            return v1;
        }
    }

    private final l a;
    public static final a0 b;

    static {
        a0.b = Build.VERSION.SDK_INT < 30 ? l.b : k.q;
    }

    private a0(WindowInsets windowInsets0) {
        h a0$h0;
        int v = Build.VERSION.SDK_INT;
        if(v >= 30) {
            a0$h0 = new k(this, windowInsets0);
        }
        else if(v >= 29) {
            a0$h0 = new j(this, windowInsets0);
        }
        else if(v >= 28) {
            a0$h0 = new i(this, windowInsets0);
        }
        else {
            a0$h0 = new h(this, windowInsets0);
        }
        this.a = a0$h0;
    }

    public a0(a0 a00) {
        l a0$l1;
        if(a00 != null) {
            l a0$l0 = a00.a;
            int v = Build.VERSION.SDK_INT;
            if(v >= 30 && a0$l0 instanceof k) {
                a0$l1 = new k(this, ((k)a0$l0));
            }
            else if(v >= 29 && a0$l0 instanceof j) {
                a0$l1 = new j(this, ((j)a0$l0));
            }
            else if(v >= 28 && a0$l0 instanceof i) {
                a0$l1 = new i(this, ((i)a0$l0));
            }
            else if(a0$l0 instanceof h) {
                a0$l1 = new h(this, ((h)a0$l0));
            }
            else if(a0$l0 instanceof g) {
                a0$l1 = new g(this, ((g)a0$l0));
            }
            else {
                a0$l1 = new l(this);
            }
            this.a = a0$l1;
            a0$l0.e(this);
            return;
        }
        this.a = new l(this);
    }

    public a0 a() {
        return this.a.a();
    }

    public a0 b() {
        return this.a.b();
    }

    public a0 c() {
        return this.a.c();
    }

    void d(View view0) {
        this.a.d(view0);
    }

    public androidx.core.view.d e() {
        return this.a.f();
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof a0 ? androidx.core.util.b.a(this.a, ((a0)object0).a) : false;
    }

    public f f(int v) {
        return this.a.g(v);
    }

    public f g() {
        return this.a.i();
    }

    public int h() {
        return this.a.k().d;
    }

    @Override
    public int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    public int i() {
        return this.a.k().a;
    }

    public int j() {
        return this.a.k().c;
    }

    public int k() {
        return this.a.k().b;
    }

    public a0 l(int v, int v1, int v2, int v3) {
        return this.a.m(v, v1, v2, v3);
    }

    static f m(f f0, int v, int v1, int v2, int v3) {
        int v4 = Math.max(0, f0.a - v);
        int v5 = Math.max(0, f0.b - v1);
        int v6 = Math.max(0, f0.c - v2);
        int v7 = Math.max(0, f0.d - v3);
        return v4 != v || v5 != v1 || v6 != v2 || v7 != v3 ? f.b(v4, v5, v6, v7) : f0;
    }

    public boolean n() {
        return this.a.n();
    }

    void o(f[] arr_f) {
        this.a.p(arr_f);
    }

    void p(f f0) {
        this.a.q(f0);
    }

    void q(a0 a00) {
        this.a.r(a00);
    }

    void r(f f0) {
        this.a.s(f0);
    }

    // 去混淆评级： 低(20)
    public WindowInsets s() {
        return this.a instanceof g ? ((g)this.a).c : null;
    }

    public static a0 t(WindowInsets windowInsets0) {
        return a0.u(windowInsets0, null);
    }

    public static a0 u(WindowInsets windowInsets0, View view0) {
        a0 a00 = new a0(((WindowInsets)androidx.core.util.c.d(windowInsets0)));
        if(view0 != null && v.v(view0)) {
            a00.q(v.q(view0));
            a00.d(view0.getRootView());
        }
        return a00;
    }
}

