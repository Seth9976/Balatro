package f;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.c0;
import androidx.core.content.res.k;
import k.h;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a extends d {
    static abstract class f.a.a {
    }

    static class b extends g {
        private final Animatable a;

        b(Animatable animatable0) {
            super(null);
            this.a = animatable0;
        }

        @Override  // f.a$g
        public void c() {
            this.a.start();
        }

        @Override  // f.a$g
        public void d() {
            this.a.stop();
        }
    }

    static class c extends f.d.a {
        k.d K;
        h L;

        c(c a$c0, a a0, Resources resources0) {
            super(a$c0, a0, resources0);
            h h0;
            if(a$c0 == null) {
                this.K = new k.d();
                h0 = new h();
            }
            else {
                this.K = a$c0.K;
                h0 = a$c0.L;
            }
            this.L = h0;
        }

        int B(int[] arr_v, Drawable drawable0, int v) {
            int v1 = super.z(arr_v, drawable0);
            this.L.k(v1, v);
            return v1;
        }

        int C(int v, int v1, Drawable drawable0, boolean z) {
            int v2 = super.a(drawable0);
            this.K.a(((long)v1) | ((long)v) << 0x20, ((long)(((long)v2) | (z ? 0x200000000L : 0L))));
            if(z) {
                this.K.a(((long)v) | ((long)v1) << 0x20, ((long)(0x100000000L | ((long)v2) | 0x200000000L)));
            }
            return v2;
        }

        private static long D(int v, int v1) [...] // Inlined contents

        int E(int v) {
            return v < 0 ? 0 : ((int)(((Integer)this.L.i(v, 0))));
        }

        int F(int[] arr_v) {
            int v = super.A(arr_v);
            return v < 0 ? super.A(StateSet.WILD_CARD) : v;
        }

        int G(int v, int v1) {
            return (int)(((long)(((Long)this.K.g(((long)v1) | ((long)v) << 0x20, -1L)))));
        }

        boolean H(int v, int v1) {
            return (((long)(((Long)this.K.g(((long)v1) | ((long)v) << 0x20, -1L)))) & 0x100000000L) != 0L;
        }

        boolean I(int v, int v1) {
            return (((long)(((Long)this.K.g(((long)v1) | ((long)v) << 0x20, -1L)))) & 0x200000000L) != 0L;
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources0) {
            return new a(this, resources0);
        }

        @Override  // f.d$a
        void r() {
            this.K = this.K.c();
            this.L = this.L.d();
        }
    }

    static class f.a.d extends g {
        private final androidx.vectordrawable.graphics.drawable.b a;

        f.a.d(androidx.vectordrawable.graphics.drawable.b b0) {
            super(null);
            this.a = b0;
        }

        @Override  // f.a$g
        public void c() {
            this.a.start();
        }

        @Override  // f.a$g
        public void d() {
            this.a.stop();
        }
    }

    static class e extends g {
        private final ObjectAnimator a;
        private final boolean b;

        e(AnimationDrawable animationDrawable0, boolean z, boolean z1) {
            super(null);
            int v = animationDrawable0.getNumberOfFrames();
            f a$f0 = new f(animationDrawable0, z);
            ObjectAnimator objectAnimator0 = ObjectAnimator.ofInt(animationDrawable0, "currentIndex", new int[]{(z ? v - 1 : 0), (z ? 0 : v - 1)});
            g.b.a(objectAnimator0, true);
            objectAnimator0.setDuration(((long)a$f0.a()));
            objectAnimator0.setInterpolator(a$f0);
            this.b = z1;
            this.a = objectAnimator0;
        }

        @Override  // f.a$g
        public boolean a() {
            return this.b;
        }

        @Override  // f.a$g
        public void b() {
            this.a.reverse();
        }

        @Override  // f.a$g
        public void c() {
            this.a.start();
        }

        @Override  // f.a$g
        public void d() {
            this.a.cancel();
        }
    }

    static class f implements TimeInterpolator {
        private int[] a;
        private int b;
        private int c;

        f(AnimationDrawable animationDrawable0, boolean z) {
            this.b(animationDrawable0, z);
        }

        int a() {
            return this.c;
        }

        int b(AnimationDrawable animationDrawable0, boolean z) {
            int v = animationDrawable0.getNumberOfFrames();
            this.b = v;
            if(this.a == null || this.a.length < v) {
                this.a = new int[v];
            }
            int[] arr_v = this.a;
            int v2 = 0;
            for(int v1 = 0; v1 < v; ++v1) {
                int v3 = animationDrawable0.getDuration((z ? v - v1 - 1 : v1));
                arr_v[v1] = v3;
                v2 += v3;
            }
            this.c = v2;
            return v2;
        }

        @Override  // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int v = (int)(f * ((float)this.c) + 0.5f);
            int v1 = this.b;
            int[] arr_v = this.a;
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                int v3 = arr_v[v2];
                if(v < v3) {
                    break;
                }
                v -= v3;
            }
            return v2 >= v1 ? ((float)v2) / ((float)v1) + 0.0f : ((float)v2) / ((float)v1) + ((float)v) / ((float)this.c);
        }
    }

    static abstract class g {
        private g() {
        }

        g(f.a.a a$a0) {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    private c o;
    private g p;
    private int q;
    private int r;
    private boolean s;

    static {
    }

    public a() {
        this(null, null);
    }

    a(c a$c0, Resources resources0) {
        super(null);
        this.q = -1;
        this.r = -1;
        this.h(new c(a$c0, this, resources0));
        this.onStateChange(this.getState());
        this.jumpToCurrentState();
    }

    @Override  // f.b
    f.b.d b() {
        return this.k();
    }

    @Override  // f.d
    void h(f.b.d b$d0) {
        super.h(b$d0);
        if(b$d0 instanceof c) {
            this.o = (c)b$d0;
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override  // f.b
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g a$g0 = this.p;
        if(a$g0 != null) {
            a$g0.d();
            this.p = null;
            this.g(this.q);
            this.q = -1;
            this.r = -1;
        }
    }

    c k() {
        return new c(this.o, this, null);
    }

    public static a l(Context context0, Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
        String s = xmlPullParser0.getName();
        if(!s.equals("animated-selector")) {
            throw new XmlPullParserException(xmlPullParser0.getPositionDescription() + ": invalid animated-selector tag " + s);
        }
        a a0 = new a();
        a0.m(context0, resources0, xmlPullParser0, attributeSet0, resources$Theme0);
        return a0;
    }

    public void m(Context context0, Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
        TypedArray typedArray0 = k.k(resources0, resources$Theme0, attributeSet0, g.e.a);
        this.setVisible(typedArray0.getBoolean(g.e.c, true), true);
        this.s(typedArray0);
        this.i(resources0);
        typedArray0.recycle();
        this.n(context0, resources0, xmlPullParser0, attributeSet0, resources$Theme0);
        this.o();
    }

    @Override  // f.d
    public Drawable mutate() {
        if(!this.s && super.mutate() == this) {
            this.o.r();
            this.s = true;
        }
        return this;
    }

    private void n(Context context0, Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
        int v = xmlPullParser0.getDepth();
        int v1;
        while((v1 = xmlPullParser0.next()) != 1) {
            int v2 = xmlPullParser0.getDepth();
            if(v2 < v + 1 && v1 == 3) {
                break;
            }
            if(v1 != 2 || v2 > v + 1) {
            }
            else if(xmlPullParser0.getName().equals("item")) {
                this.p(context0, resources0, xmlPullParser0, attributeSet0, resources$Theme0);
            }
            else if(xmlPullParser0.getName().equals("transition")) {
                this.q(context0, resources0, xmlPullParser0, attributeSet0, resources$Theme0);
            }
        }
    }

    private void o() {
        this.onStateChange(this.getState());
    }

    @Override  // f.d
    protected boolean onStateChange(int[] arr_v) {
        int v = this.o.F(arr_v);
        boolean z = v != this.c() && (this.r(v) || this.g(v));
        Drawable drawable0 = this.getCurrent();
        return drawable0 != null ? z | drawable0.setState(arr_v) : z;
    }

    private int p(Context context0, Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
        TypedArray typedArray0 = k.k(resources0, resources$Theme0, attributeSet0, g.e.h);
        int v = typedArray0.getResourceId(g.e.i, 0);
        int v1 = typedArray0.getResourceId(g.e.j, -1);
        Drawable drawable0 = v1 <= 0 ? null : c0.h().j(context0, v1);
        typedArray0.recycle();
        int[] arr_v = this.j(attributeSet0);
        if(drawable0 == null) {
        alab1:
            while(true) {
                switch(xmlPullParser0.next()) {
                    case 2: {
                        if(xmlPullParser0.getName().equals("vector")) {
                            drawable0 = androidx.vectordrawable.graphics.drawable.g.c(resources0, xmlPullParser0, attributeSet0, resources$Theme0);
                            break alab1;
                        }
                        drawable0 = g.c.a(resources0, xmlPullParser0, attributeSet0, resources$Theme0);
                        break alab1;
                    }
                    case 4: {
                        break;
                    }
                    default: {
                        throw new XmlPullParserException(xmlPullParser0.getPositionDescription() + ": <item> tag requires a \'drawable\' attribute or child tag defining a drawable");
                    }
                }
            }
        }
        if(drawable0 == null) {
            throw new XmlPullParserException(xmlPullParser0.getPositionDescription() + ": <item> tag requires a \'drawable\' attribute or child tag defining a drawable");
        }
        return this.o.B(arr_v, drawable0, v);
    }

    private int q(Context context0, Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
        TypedArray typedArray0 = k.k(resources0, resources$Theme0, attributeSet0, g.e.k);
        int v = typedArray0.getResourceId(g.e.n, -1);
        int v1 = typedArray0.getResourceId(g.e.m, -1);
        int v2 = typedArray0.getResourceId(g.e.l, -1);
        Drawable drawable0 = v2 <= 0 ? null : c0.h().j(context0, v2);
        boolean z = typedArray0.getBoolean(g.e.o, false);
        typedArray0.recycle();
        if(drawable0 == null) {
        alab1:
            while(true) {
                switch(xmlPullParser0.next()) {
                    case 2: {
                        if(xmlPullParser0.getName().equals("animated-vector")) {
                            drawable0 = androidx.vectordrawable.graphics.drawable.b.a(context0, resources0, xmlPullParser0, attributeSet0, resources$Theme0);
                            break alab1;
                        }
                        drawable0 = g.c.a(resources0, xmlPullParser0, attributeSet0, resources$Theme0);
                        break alab1;
                    }
                    case 4: {
                        break;
                    }
                    default: {
                        throw new XmlPullParserException(xmlPullParser0.getPositionDescription() + ": <transition> tag requires a \'drawable\' attribute or child tag defining a drawable");
                    }
                }
            }
        }
        if(drawable0 == null) {
            throw new XmlPullParserException(xmlPullParser0.getPositionDescription() + ": <transition> tag requires a \'drawable\' attribute or child tag defining a drawable");
        }
        if(v == -1 || v1 == -1) {
            throw new XmlPullParserException(xmlPullParser0.getPositionDescription() + ": <transition> tag requires \'fromId\' & \'toId\' attributes");
        }
        return this.o.C(v, v1, drawable0, z);
    }

    private boolean r(int v) {
        e a$e0;
        int v1;
        g a$g0 = this.p;
        if(a$g0 == null) {
            v1 = this.c();
        }
        else {
            if(v == this.q) {
                return true;
            }
            if(v == this.r && a$g0.a()) {
                a$g0.b();
                this.q = this.r;
                this.r = v;
                return true;
            }
            v1 = this.q;
            a$g0.d();
        }
        this.p = null;
        this.r = -1;
        this.q = -1;
        c a$c0 = this.o;
        int v2 = a$c0.E(v1);
        int v3 = a$c0.E(v);
        if(v3 != 0 && v2 != 0) {
            int v4 = a$c0.G(v2, v3);
            if(v4 < 0) {
                return false;
            }
            boolean z = a$c0.I(v2, v3);
            this.g(v4);
            Drawable drawable0 = this.getCurrent();
            if(drawable0 instanceof AnimationDrawable) {
                a$e0 = new e(((AnimationDrawable)drawable0), a$c0.H(v2, v3), z);
                goto label_34;
            }
            boolean z1 = false;
            if(drawable0 instanceof androidx.vectordrawable.graphics.drawable.b) {
                z1 = true;
                a$e0 = new f.a.d(((androidx.vectordrawable.graphics.drawable.b)drawable0));
            }
            else if(drawable0 instanceof Animatable) {
                z1 = true;
                a$e0 = new b(((Animatable)drawable0));
            }
            if(z1) {
            label_34:
                a$e0.c();
                this.p = a$e0;
                this.r = v1;
                this.q = v;
                return true;
            }
        }
        return false;
    }

    private void s(TypedArray typedArray0) {
        c a$c0 = this.o;
        a$c0.d |= g.c.b(typedArray0);
        a$c0.x(typedArray0.getBoolean(g.e.d, a$c0.i));
        a$c0.t(typedArray0.getBoolean(g.e.e, a$c0.l));
        a$c0.u(typedArray0.getInt(g.e.f, a$c0.A));
        a$c0.v(typedArray0.getInt(g.e.g, a$c0.B));
        this.setDither(typedArray0.getBoolean(g.e.b, a$c0.x));
    }

    @Override  // f.b
    public boolean setVisible(boolean z, boolean z1) {
        boolean z2 = super.setVisible(z, z1);
        g a$g0 = this.p;
        if(a$g0 != null && (z2 || z1)) {
            if(z) {
                a$g0.c();
                return z2;
            }
            this.jumpToCurrentState();
        }
        return z2;
    }
}

