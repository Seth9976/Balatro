package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.core.graphics.f;
import androidx.core.view.a0;
import androidx.core.view.o;
import androidx.core.view.p;
import androidx.core.view.q;
import androidx.core.view.v;

public class ActionBarOverlayLayout extends ViewGroup implements o, p {
    class a extends AnimatorListenerAdapter {
        final ActionBarOverlayLayout a;

        @Override  // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator0) {
            ActionBarOverlayLayout.this.z = null;
            ActionBarOverlayLayout.this.k = false;
        }

        @Override  // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator0) {
            ActionBarOverlayLayout.this.z = null;
            ActionBarOverlayLayout.this.k = false;
        }
    }

    class b implements Runnable {
        final ActionBarOverlayLayout e;

        @Override
        public void run() {
            ActionBarOverlayLayout.this.l();
            ActionBarOverlayLayout.this.z = ActionBarOverlayLayout.this.d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.A);
        }
    }

    class c implements Runnable {
        final ActionBarOverlayLayout e;

        @Override
        public void run() {
            ActionBarOverlayLayout.this.l();
            ActionBarOverlayLayout.this.z = ActionBarOverlayLayout.this.d.animate().translationY(((float)(-ActionBarOverlayLayout.this.d.getHeight()))).setListener(ActionBarOverlayLayout.this.A);
        }
    }

    public interface d {
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(int v, int v1) {
            super(v, v1);
        }

        public e(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
        }

        public e(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
            super(viewGroup$LayoutParams0);
        }
    }

    final AnimatorListenerAdapter A;
    private final Runnable B;
    private final Runnable C;
    private final q D;
    static final int[] E;
    private int a;
    private int b;
    private ContentFrameLayout c;
    ActionBarContainer d;
    private t e;
    private Drawable f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    boolean k;
    private int l;
    private int m;
    private final Rect n;
    private final Rect o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private a0 u;
    private a0 v;
    private a0 w;
    private a0 x;
    private OverScroller y;
    ViewPropertyAnimator z;

    static {
        ActionBarOverlayLayout.E = new int[]{c.a.b, 0x1010059};
    }

    public ActionBarOverlayLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.b = 0;
        this.n = new Rect();
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = a0.b;
        this.v = a0.b;
        this.w = a0.b;
        this.x = a0.b;
        this.A = new a(this);
        this.B = new b(this);
        this.C = new c(this);
        this.m(context0);
        this.D = new q(this);
    }

    @Override  // androidx.core.view.o
    public void a(View view0, View view1, int v, int v1) {
        if(v1 == 0) {
            this.onNestedScrollAccepted(view0, view1, v);
        }
    }

    @Override  // androidx.core.view.o
    public void b(View view0, int v) {
        if(v == 0) {
            this.onStopNestedScroll(view0);
        }
    }

    @Override  // androidx.core.view.o
    public void c(View view0, int v, int v1, int[] arr_v, int v2) {
    }

    @Override  // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof e;
    }

    @Override  // androidx.core.view.p
    public void d(View view0, int v, int v1, int v2, int v3, int v4, int[] arr_v) {
        this.e(view0, v, v1, v2, v3, v4);
    }

    @Override  // android.view.View
    public void draw(Canvas canvas0) {
        super.draw(canvas0);
        if(this.f != null && !this.g) {
            int v = this.d.getVisibility() == 0 ? ((int)(((float)this.d.getBottom()) + this.d.getTranslationY() + 0.5f)) : 0;
            this.f.setBounds(0, v, this.getWidth(), this.f.getIntrinsicHeight() + v);
            this.f.draw(canvas0);
        }
    }

    @Override  // androidx.core.view.o
    public void e(View view0, int v, int v1, int v2, int v3, int v4) {
        if(v4 == 0) {
            this.onNestedScroll(view0, v, v1, v2, v3);
        }
    }

    @Override  // androidx.core.view.o
    public boolean f(View view0, View view1, int v, int v1) {
        return v1 == 0 && this.onStartNestedScroll(view0, view1, v);
    }

    @Override  // android.view.View
    protected boolean fitSystemWindows(Rect rect0) {
        return super.fitSystemWindows(rect0);
    }

    private void g() {
        this.l();
        this.C.run();
    }

    @Override  // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.i();
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return this.j(attributeSet0);
    }

    @Override  // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return new e(viewGroup$LayoutParams0);
    }

    public int getActionBarHideOffset() {
        return this.d == null ? 0 : -((int)this.d.getTranslationY());
    }

    @Override  // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.D.a();
    }

    public CharSequence getTitle() {
        this.p();
        return this.e.getTitle();
    }

    private boolean h(View view0, Rect rect0, boolean z, boolean z1, boolean z2, boolean z3) {
        boolean z4;
        e actionBarOverlayLayout$e0 = (e)view0.getLayoutParams();
        if(z) {
            int v = rect0.left;
            if(actionBarOverlayLayout$e0.leftMargin == v) {
                z4 = false;
            }
            else {
                actionBarOverlayLayout$e0.leftMargin = v;
                z4 = true;
            }
        }
        else {
            z4 = false;
        }
        if(z1) {
            int v1 = rect0.top;
            if(actionBarOverlayLayout$e0.topMargin != v1) {
                actionBarOverlayLayout$e0.topMargin = v1;
                z4 = true;
            }
        }
        if(z3) {
            int v2 = rect0.right;
            if(actionBarOverlayLayout$e0.rightMargin != v2) {
                actionBarOverlayLayout$e0.rightMargin = v2;
                z4 = true;
            }
        }
        if(z2) {
            int v3 = rect0.bottom;
            if(actionBarOverlayLayout$e0.bottomMargin != v3) {
                actionBarOverlayLayout$e0.bottomMargin = v3;
                return true;
            }
        }
        return z4;
    }

    protected e i() {
        return new e(-1, -1);
    }

    public e j(AttributeSet attributeSet0) {
        return new e(this.getContext(), attributeSet0);
    }

    private t k(View view0) {
        if(view0 instanceof t) {
            return (t)view0;
        }
        if(!(view0 instanceof Toolbar)) {
            throw new IllegalStateException("Can\'t make a decor toolbar out of " + view0.getClass().getSimpleName());
        }
        return ((Toolbar)view0).getWrapper();
    }

    void l() {
        this.removeCallbacks(this.B);
        this.removeCallbacks(this.C);
        ViewPropertyAnimator viewPropertyAnimator0 = this.z;
        if(viewPropertyAnimator0 != null) {
            viewPropertyAnimator0.cancel();
        }
    }

    private void m(Context context0) {
        TypedArray typedArray0 = this.getContext().getTheme().obtainStyledAttributes(ActionBarOverlayLayout.E);
        this.a = typedArray0.getDimensionPixelSize(0, 0);
        Drawable drawable0 = typedArray0.getDrawable(1);
        this.f = drawable0;
        this.setWillNotDraw(drawable0 == null);
        typedArray0.recycle();
        this.g = false;
        this.y = new OverScroller(context0);
    }

    private void n() {
        this.l();
        this.postDelayed(this.C, 600L);
    }

    private void o() {
        this.l();
        this.postDelayed(this.B, 600L);
    }

    @Override  // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets0) {
        this.p();
        a0 a00 = a0.u(windowInsets0, this);
        Rect rect0 = new Rect(a00.i(), a00.k(), a00.j(), a00.h());
        boolean z = this.h(this.d, rect0, true, true, false, true);
        v.b(this, a00, this.n);
        a0 a01 = a00.l(this.n.left, this.n.top, this.n.right, this.n.bottom);
        this.u = a01;
        boolean z1 = true;
        if(!this.v.equals(a01)) {
            this.v = this.u;
            z = true;
        }
        if(this.o.equals(this.n)) {
            z1 = z;
        }
        else {
            this.o.set(this.n);
        }
        if(z1) {
            this.requestLayout();
        }
        return a00.a().c().b().s();
    }

    @Override  // android.view.View
    protected void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        this.m(this.getContext());
        v.E(this);
    }

    @Override  // android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l();
    }

    @Override  // android.view.ViewGroup
    protected void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v4 = this.getChildCount();
        int v5 = this.getPaddingLeft();
        int v6 = this.getPaddingTop();
        for(int v7 = 0; v7 < v4; ++v7) {
            View view0 = this.getChildAt(v7);
            if(view0.getVisibility() != 8) {
                e actionBarOverlayLayout$e0 = (e)view0.getLayoutParams();
                int v8 = view0.getMeasuredWidth();
                int v9 = view0.getMeasuredHeight();
                int v10 = actionBarOverlayLayout$e0.leftMargin + v5;
                int v11 = actionBarOverlayLayout$e0.topMargin + v6;
                view0.layout(v10, v11, v8 + v10, v9 + v11);
            }
        }
    }

    @Override  // android.view.View
    protected void onMeasure(int v, int v1) {
        a0 a01;
        int v5;
        this.p();
        this.measureChildWithMargins(this.d, v, 0, v1, 0);
        e actionBarOverlayLayout$e0 = (e)this.d.getLayoutParams();
        int v2 = Math.max(0, this.d.getMeasuredWidth() + actionBarOverlayLayout$e0.leftMargin + actionBarOverlayLayout$e0.rightMargin);
        int v3 = Math.max(0, this.d.getMeasuredHeight() + actionBarOverlayLayout$e0.topMargin + actionBarOverlayLayout$e0.bottomMargin);
        int v4 = View.combineMeasuredStates(0, this.d.getMeasuredState());
        boolean z = (v.t(this) & 0x100) != 0;
        if(z) {
            v5 = this.a;
            if(this.i && this.d.getTabContainer() != null) {
                v5 += this.a;
            }
        }
        else {
            v5 = this.d.getVisibility() == 8 ? 0 : this.d.getMeasuredHeight();
        }
        this.p.set(this.n);
        a0 a00 = this.u;
        this.w = a00;
        if(this.h || z) {
            f f0 = f.b(a00.i(), this.w.k() + v5, this.w.j(), this.w.h());
            a01 = new androidx.core.view.a0.b(this.w).c(f0).a();
        }
        else {
            this.p.top += v5;
            this.p.bottom = this.p.bottom;
            a01 = a00.l(0, v5, 0, 0);
        }
        this.w = a01;
        this.h(this.c, this.p, true, true, true, true);
        if(!this.x.equals(this.w)) {
            this.x = this.w;
            v.c(this.c, this.w);
        }
        this.measureChildWithMargins(this.c, v, 0, v1, 0);
        e actionBarOverlayLayout$e1 = (e)this.c.getLayoutParams();
        int v6 = Math.max(v2, this.c.getMeasuredWidth() + actionBarOverlayLayout$e1.leftMargin + actionBarOverlayLayout$e1.rightMargin);
        int v7 = Math.max(v3, this.c.getMeasuredHeight() + actionBarOverlayLayout$e1.topMargin + actionBarOverlayLayout$e1.bottomMargin);
        int v8 = View.combineMeasuredStates(v4, this.c.getMeasuredState());
        int v9 = this.getPaddingLeft();
        int v10 = this.getPaddingRight();
        int v11 = Math.max(v7 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight());
        this.setMeasuredDimension(View.resolveSizeAndState(Math.max(v6 + (v9 + v10), this.getSuggestedMinimumWidth()), v, v8), View.resolveSizeAndState(v11, v1, v8 << 16));
    }

    @Override  // android.view.ViewGroup
    public boolean onNestedFling(View view0, float f, float f1, boolean z) {
        if(this.j && z) {
            if(this.r(f1)) {
                this.g();
            }
            else {
                this.q();
            }
            this.k = true;
            return true;
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public boolean onNestedPreFling(View view0, float f, float f1) {
        return false;
    }

    @Override  // android.view.ViewGroup
    public void onNestedPreScroll(View view0, int v, int v1, int[] arr_v) {
    }

    @Override  // android.view.ViewGroup
    public void onNestedScroll(View view0, int v, int v1, int v2, int v3) {
        int v4 = this.l + v1;
        this.l = v4;
        this.setActionBarHideOffset(v4);
    }

    @Override  // android.view.ViewGroup
    public void onNestedScrollAccepted(View view0, View view1, int v) {
        this.D.b(view0, view1, v);
        this.l = this.getActionBarHideOffset();
        this.l();
    }

    @Override  // android.view.ViewGroup
    public boolean onStartNestedScroll(View view0, View view1, int v) {
        return (v & 2) == 0 || this.d.getVisibility() != 0 ? false : this.j;
    }

    @Override  // android.view.ViewGroup
    public void onStopNestedScroll(View view0) {
        if(this.j && !this.k) {
            if(this.l <= this.d.getHeight()) {
                this.o();
                return;
            }
            this.n();
        }
    }

    @Override  // android.view.View
    public void onWindowSystemUiVisibilityChanged(int v) {
        super.onWindowSystemUiVisibilityChanged(v);
        this.p();
        this.m = v;
    }

    @Override  // android.view.View
    protected void onWindowVisibilityChanged(int v) {
        super.onWindowVisibilityChanged(v);
        this.b = v;
    }

    void p() {
        if(this.c == null) {
            this.c = (ContentFrameLayout)this.findViewById(c.e.b);
            this.d = (ActionBarContainer)this.findViewById(c.e.c);
            this.e = this.k(this.findViewById(c.e.a));
        }
    }

    private void q() {
        this.l();
        this.B.run();
    }

    private boolean r(float f) {
        this.y.fling(0, 0, 0, ((int)f), 0, 0, 0x80000000, 0x7FFFFFFF);
        return this.y.getFinalY() > this.d.getHeight();
    }

    public void setActionBarHideOffset(int v) {
        this.l();
        int v1 = Math.max(0, Math.min(v, this.d.getHeight()));
        this.d.setTranslationY(((float)(-v1)));
    }

    public void setActionBarVisibilityCallback(d actionBarOverlayLayout$d0) {
        if(this.getWindowToken() != null) {
            throw null;
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.i = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if(z != this.j) {
            this.j = z;
            if(!z) {
                this.l();
                this.setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int v) {
        this.p();
        this.e.setIcon(v);
    }

    public void setIcon(Drawable drawable0) {
        this.p();
        this.e.setIcon(drawable0);
    }

    public void setLogo(int v) {
        this.p();
        this.e.a(v);
    }

    public void setOverlayMode(boolean z) {
        this.h = z;
        this.g = false;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int v) {
    }

    public void setWindowCallback(Window.Callback window$Callback0) {
        this.p();
        this.e.c(window$Callback0);
    }

    public void setWindowTitle(CharSequence charSequence0) {
        this.p();
        this.e.b(charSequence0);
    }

    @Override  // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

