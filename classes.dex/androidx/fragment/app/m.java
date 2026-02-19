package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.a0;
import androidx.core.view.v;
import java.util.ArrayList;
import java.util.List;
import k3.f;
import u.c;

public final class m extends FrameLayout {
    public static final class a {
        public static final a a;

        static {
            a.a = new a();
        }

        public final WindowInsets a(View.OnApplyWindowInsetsListener view$OnApplyWindowInsetsListener0, View view0, WindowInsets windowInsets0) {
            f.e(view$OnApplyWindowInsetsListener0, "onApplyWindowInsetsListener");
            f.e(view0, "v");
            f.e(windowInsets0, "insets");
            WindowInsets windowInsets1 = view$OnApplyWindowInsetsListener0.onApplyWindowInsets(view0, windowInsets0);
            f.d(windowInsets1, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return windowInsets1;
        }
    }

    private final List a;
    private final List b;
    private View.OnApplyWindowInsetsListener c;
    private boolean d;

    public m(Context context0, AttributeSet attributeSet0, x x0) {
        f.e(context0, "context");
        f.e(attributeSet0, "attrs");
        f.e(x0, "fm");
        super(context0, attributeSet0);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = true;
        String s = attributeSet0.getClassAttribute();
        int[] arr_v = c.e;
        f.d(arr_v, "FragmentContainerView");
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, arr_v, 0, 0);
        if(s == null) {
            s = typedArray0.getString(c.f);
        }
        String s1 = typedArray0.getString(c.g);
        typedArray0.recycle();
        int v = this.getId();
        if(s != null && x0.g0(v) == null) {
            if(v == -1) {
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + s + (s1 == null ? "" : " with tag " + s1));
            }
            Fragment fragment0 = x0.r0().a(context0.getClassLoader(), s);
            f.d(fragment0, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            fragment0.y0(context0, attributeSet0, null);
            x0.o().m(true).c(this, fragment0, s1).i();
        }
        x0.W0(this);
    }

    private final void a(View view0) {
        if(this.b.contains(view0)) {
            this.a.add(view0);
        }
    }

    @Override  // android.view.ViewGroup
    public void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        f.e(view0, "child");
        if(x.A0(view0) == null) {
            throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view0 + " is not associated with a Fragment.").toString());
        }
        super.addView(view0, v, viewGroup$LayoutParams0);
    }

    @Override  // android.view.ViewGroup
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets0) {
        a0 a01;
        f.e(windowInsets0, "insets");
        a0 a00 = a0.t(windowInsets0);
        f.d(a00, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener view$OnApplyWindowInsetsListener0 = this.c;
        if(view$OnApplyWindowInsetsListener0 == null) {
            a01 = v.z(this, a00);
        }
        else {
            f.b(view$OnApplyWindowInsetsListener0);
            a01 = a0.t(a.a.a(view$OnApplyWindowInsetsListener0, this, windowInsets0));
        }
        f.d(a01, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if(!a01.n()) {
            int v = this.getChildCount();
            for(int v1 = 0; v1 < v; ++v1) {
                v.c(this.getChildAt(v1), a01);
            }
        }
        return windowInsets0;
    }

    @Override  // android.view.ViewGroup
    protected void dispatchDraw(Canvas canvas0) {
        f.e(canvas0, "canvas");
        if(this.d) {
            for(Object object0: this.a) {
                super.drawChild(canvas0, ((View)object0), this.getDrawingTime());
            }
        }
        super.dispatchDraw(canvas0);
    }

    @Override  // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas0, View view0, long v) {
        f.e(canvas0, "canvas");
        f.e(view0, "child");
        return !this.d || !this.a.isEmpty() == 0 || !this.a.contains(view0) ? super.drawChild(canvas0, view0, v) : false;
    }

    @Override  // android.view.ViewGroup
    public void endViewTransition(View view0) {
        f.e(view0, "view");
        this.b.remove(view0);
        if(this.a.remove(view0)) {
            this.d = true;
        }
        super.endViewTransition(view0);
    }

    public final Fragment getFragment() {
        return x.j0(this).g0(this.getId());
    }

    @Override  // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets0) {
        f.e(windowInsets0, "insets");
        return windowInsets0;
    }

    @Override  // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for(int v = this.getChildCount() - 1; -1 < v; --v) {
            View view0 = this.getChildAt(v);
            f.d(view0, "view");
            this.a(view0);
        }
        super.removeAllViewsInLayout();
    }

    @Override  // android.view.ViewGroup
    public void removeView(View view0) {
        f.e(view0, "view");
        this.a(view0);
        super.removeView(view0);
    }

    @Override  // android.view.ViewGroup
    public void removeViewAt(int v) {
        View view0 = this.getChildAt(v);
        f.d(view0, "view");
        this.a(view0);
        super.removeViewAt(v);
    }

    @Override  // android.view.ViewGroup
    public void removeViewInLayout(View view0) {
        f.e(view0, "view");
        this.a(view0);
        super.removeViewInLayout(view0);
    }

    @Override  // android.view.ViewGroup
    public void removeViews(int v, int v1) {
        for(int v2 = v; v2 < v + v1; ++v2) {
            View view0 = this.getChildAt(v2);
            f.d(view0, "view");
            this.a(view0);
        }
        super.removeViews(v, v1);
    }

    @Override  // android.view.ViewGroup
    public void removeViewsInLayout(int v, int v1) {
        for(int v2 = v; v2 < v + v1; ++v2) {
            View view0 = this.getChildAt(v2);
            f.d(view0, "view");
            this.a(view0);
        }
        super.removeViewsInLayout(v, v1);
    }

    public final void setDrawDisappearingViewsLast(boolean z) {
        this.d = z;
    }

    @Override  // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition0) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override  // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener view$OnApplyWindowInsetsListener0) {
        f.e(view$OnApplyWindowInsetsListener0, "listener");
        this.c = view$OnApplyWindowInsetsListener0;
    }

    @Override  // android.view.ViewGroup
    public void startViewTransition(View view0) {
        f.e(view0, "view");
        if(view0.getParent() == this) {
            this.b.add(view0);
        }
        super.startViewTransition(view0);
    }
}

