package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.accessibility.u;
import androidx.core.view.accessibility.w;
import androidx.core.view.m;
import androidx.core.view.n;
import androidx.core.view.p;
import androidx.core.view.q;
import androidx.core.view.v;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements p {
    static class a extends androidx.core.view.a {
        @Override  // androidx.core.view.a
        public void f(View view0, AccessibilityEvent accessibilityEvent0) {
            super.f(view0, accessibilityEvent0);
            accessibilityEvent0.setClassName("android.widget.ScrollView");
            accessibilityEvent0.setScrollable(((NestedScrollView)view0).getScrollRange() > 0);
            accessibilityEvent0.setScrollX(((NestedScrollView)view0).getScrollX());
            accessibilityEvent0.setScrollY(((NestedScrollView)view0).getScrollY());
            w.a(accessibilityEvent0, ((NestedScrollView)view0).getScrollX());
            w.b(accessibilityEvent0, ((NestedScrollView)view0).getScrollRange());
        }

        @Override  // androidx.core.view.a
        public void g(View view0, u u0) {
            super.g(view0, u0);
            u0.I("android.widget.ScrollView");
            if(((NestedScrollView)view0).isEnabled()) {
                int v = ((NestedScrollView)view0).getScrollRange();
                if(v > 0) {
                    u0.M(true);
                    if(((NestedScrollView)view0).getScrollY() > 0) {
                        u0.a(androidx.core.view.accessibility.u.a.q);
                        u0.a(androidx.core.view.accessibility.u.a.B);
                    }
                    if(((NestedScrollView)view0).getScrollY() < v) {
                        u0.a(androidx.core.view.accessibility.u.a.p);
                        u0.a(androidx.core.view.accessibility.u.a.D);
                    }
                }
            }
        }

        @Override  // androidx.core.view.a
        public boolean j(View view0, int v, Bundle bundle0) {
            if(super.j(view0, v, bundle0)) {
                return true;
            }
            if(!((NestedScrollView)view0).isEnabled()) {
                return false;
            }
            int v1 = ((NestedScrollView)view0).getHeight();
            Rect rect0 = new Rect();
            if(((NestedScrollView)view0).getMatrix().isIdentity() && ((NestedScrollView)view0).getGlobalVisibleRect(rect0)) {
                v1 = rect0.height();
            }
            switch(v) {
                case 0x2000: 
                case 0x1020038: {
                    int v5 = ((NestedScrollView)view0).getPaddingBottom();
                    int v6 = ((NestedScrollView)view0).getPaddingTop();
                    int v7 = Math.max(((NestedScrollView)view0).getScrollY() - (v1 - v5 - v6), 0);
                    if(v7 != ((NestedScrollView)view0).getScrollY()) {
                        ((NestedScrollView)view0).T(0, v7, true);
                        return true;
                    }
                    return false;
                }
                case 0x1000: 
                case 0x102003A: {
                    int v2 = ((NestedScrollView)view0).getPaddingBottom();
                    int v3 = ((NestedScrollView)view0).getPaddingTop();
                    int v4 = Math.min(((NestedScrollView)view0).getScrollY() + (v1 - v2 - v3), ((NestedScrollView)view0).getScrollRange());
                    if(v4 != ((NestedScrollView)view0).getScrollY()) {
                        ((NestedScrollView)view0).T(0, v4, true);
                        return true;
                    }
                    return false;
                }
                default: {
                    return false;
                }
            }
        }
    }

    static abstract class b {
        static boolean a(ViewGroup viewGroup0) {
            return viewGroup0.getClipToPadding();
        }
    }

    public interface c {
    }

    static class d extends View.BaseSavedState {
        class androidx.core.widget.NestedScrollView.d.a implements Parcelable.Creator {
            androidx.core.widget.NestedScrollView.d.a() {
                super();
            }

            public d a(Parcel parcel0) {
                return new d(parcel0);
            }

            public d[] b(int v) {
                return new d[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.a(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.b(v);
            }
        }

        public static final Parcelable.Creator CREATOR;
        public int e;

        static {
            d.CREATOR = new androidx.core.widget.NestedScrollView.d.a();
        }

        d(Parcel parcel0) {
            super(parcel0);
            this.e = parcel0.readInt();
        }

        d(Parcelable parcelable0) {
            super(parcelable0);
        }

        @Override
        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.e + "}";
        }

        @Override  // android.view.View$BaseSavedState
        public void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(this.e);
        }
    }

    private static final float A;
    private static final a B;
    private static final int[] C;
    private final float a;
    private long b;
    private final Rect c;
    private OverScroller d;
    public EdgeEffect e;
    public EdgeEffect f;
    private int g;
    private boolean h;
    private boolean i;
    private View j;
    private boolean k;
    private VelocityTracker l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    private final int[] s;
    private final int[] t;
    private int u;
    private int v;
    private d w;
    private final q x;
    private final n y;
    private float z;

    static {
        NestedScrollView.A = 2.358202f;
        NestedScrollView.B = new a();
        NestedScrollView.C = new int[]{0x101017A};
    }

    public NestedScrollView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, l.a.c);
    }

    public NestedScrollView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.c = new Rect();
        this.h = true;
        this.i = false;
        this.j = null;
        this.k = false;
        this.n = true;
        this.r = -1;
        this.s = new int[2];
        this.t = new int[2];
        this.e = androidx.core.widget.b.a(context0, attributeSet0);
        this.f = androidx.core.widget.b.a(context0, attributeSet0);
        this.a = context0.getResources().getDisplayMetrics().density * 51890.199219f;
        this.A();
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, NestedScrollView.C, v, 0);
        this.setFillViewport(typedArray0.getBoolean(0, false));
        typedArray0.recycle();
        this.x = new q(this);
        this.y = new n(this);
        this.setNestedScrollingEnabled(true);
        v.H(this, NestedScrollView.B);
    }

    private void A() {
        this.d = new OverScroller(this.getContext());
        this.setFocusable(true);
        this.setDescendantFocusability(0x40000);
        this.setWillNotDraw(false);
        ViewConfiguration viewConfiguration0 = ViewConfiguration.get(this.getContext());
        this.o = viewConfiguration0.getScaledTouchSlop();
        this.p = viewConfiguration0.getScaledMinimumFlingVelocity();
        this.q = viewConfiguration0.getScaledMaximumFlingVelocity();
    }

    private void B() {
        if(this.l == null) {
            this.l = VelocityTracker.obtain();
        }
    }

    private boolean C(View view0) {
        return !this.E(view0, 0, this.getHeight());
    }

    private static boolean D(View view0, View view1) {
        if(view0 == view1) {
            return true;
        }
        ViewParent viewParent0 = view0.getParent();
        return viewParent0 instanceof ViewGroup && NestedScrollView.D(((View)viewParent0), view1);
    }

    private boolean E(View view0, int v, int v1) {
        view0.getDrawingRect(this.c);
        this.offsetDescendantRectToMyCoords(view0, this.c);
        return this.c.bottom + v >= this.getScrollY() && this.c.top - v <= this.getScrollY() + v1;
    }

    private void F(int v, int v1, int[] arr_v) {
        int v2 = this.getScrollY();
        this.scrollBy(0, v);
        int v3 = this.getScrollY() - v2;
        if(arr_v != null) {
            arr_v[1] += v3;
        }
        this.y.d(0, v3, 0, v - v3, null, v1, arr_v);
    }

    private void G(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionIndex();
        if(motionEvent0.getPointerId(v) == this.r) {
            int v1 = v == 0 ? 1 : 0;
            this.g = (int)motionEvent0.getY(v1);
            this.r = motionEvent0.getPointerId(v1);
            VelocityTracker velocityTracker0 = this.l;
            if(velocityTracker0 != null) {
                velocityTracker0.clear();
            }
        }
    }

    boolean H(int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7, boolean z) {
        boolean z2;
        boolean z1;
        int v8 = this.getOverScrollMode();
        int v9 = v2 + v;
        int v10 = v8 == 0 || v8 == 1 && this.computeHorizontalScrollRange() > this.computeHorizontalScrollExtent() ? v6 : 0;
        int v11 = v3 + v1;
        int v12 = v8 == 0 || v8 == 1 && this.computeVerticalScrollRange() > this.computeVerticalScrollExtent() ? v7 : 0;
        int v13 = v10 + v4;
        int v14 = v12 + v5;
        if(v9 > v13) {
            v9 = v13;
            z1 = true;
        }
        else if(v9 < -v10) {
            z1 = true;
            v9 = -v10;
        }
        else {
            z1 = false;
        }
        if(v11 > v14) {
            v11 = v14;
            z2 = true;
        }
        else if(v11 < -v12) {
            z2 = true;
            v11 = -v12;
        }
        else {
            z2 = false;
        }
        if(z2 && !this.x(1)) {
            this.d.springBack(v9, v11, 0, 0, 0, this.getScrollRange());
        }
        this.onOverScrolled(v9, v11, z1, z2);
        return z1 || z2;
    }

    public boolean I(int v) {
        int v1 = this.getHeight();
        if(v == 130) {
            this.c.top = this.getScrollY() + v1;
            int v2 = this.getChildCount();
            if(v2 > 0) {
                View view0 = this.getChildAt(v2 - 1);
                FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
                int v3 = view0.getBottom() + frameLayout$LayoutParams0.bottomMargin + this.getPaddingBottom();
                Rect rect0 = this.c;
                if(rect0.top + v1 > v3) {
                    rect0.top = v3 - v1;
                }
            }
        }
        else {
            this.c.top = this.getScrollY() - v1;
            Rect rect1 = this.c;
            if(rect1.top < 0) {
                rect1.top = 0;
            }
        }
        int v4 = v1 + this.c.top;
        this.c.bottom = v4;
        return this.M(v, this.c.top, v4);
    }

    private void J() {
        VelocityTracker velocityTracker0 = this.l;
        if(velocityTracker0 != null) {
            velocityTracker0.recycle();
            this.l = null;
        }
    }

    private int K(int v, float f) {
        float f4;
        float f1 = f / ((float)this.getWidth());
        float f2 = ((float)v) / ((float)this.getHeight());
        float f3 = 0.0f;
        if(androidx.core.widget.b.b(this.e) != 0.0f) {
            f4 = -androidx.core.widget.b.d(this.e, -f2, f1);
            if(androidx.core.widget.b.b(this.e) == 0.0f) {
                this.e.onRelease();
            }
            f3 = f4;
        }
        else if(androidx.core.widget.b.b(this.f) != 0.0f) {
            f4 = androidx.core.widget.b.d(this.f, f2, 1.0f - f1);
            if(androidx.core.widget.b.b(this.f) == 0.0f) {
                this.f.onRelease();
            }
            f3 = f4;
        }
        int v1 = Math.round(f3 * ((float)this.getHeight()));
        if(v1 != 0) {
            this.invalidate();
        }
        return v1;
    }

    private void L(boolean z) {
        if(z) {
            this.U(2, 1);
        }
        else {
            this.W(1);
        }
        this.v = this.getScrollY();
        v.B(this);
    }

    private boolean M(int v, int v1, int v2) {
        int v3 = this.getHeight();
        int v4 = this.getScrollY();
        int v5 = v3 + v4;
        boolean z = false;
        View view0 = this.t(v == 33, v1, v2);
        if(view0 == null) {
            view0 = this;
        }
        if(v1 < v4 || v2 > v5) {
            this.p((v == 33 ? v2 - v5 : v1 - v4));
            z = true;
        }
        if(view0 != this.findFocus()) {
            view0.requestFocus(v);
        }
        return z;
    }

    private void N(View view0) {
        view0.getDrawingRect(this.c);
        this.offsetDescendantRectToMyCoords(view0, this.c);
        int v = this.l(this.c);
        if(v != 0) {
            this.scrollBy(0, v);
        }
    }

    private boolean O(Rect rect0, boolean z) {
        int v = this.l(rect0);
        if(v != 0) {
            if(z) {
                this.scrollBy(0, v);
                return true;
            }
            this.Q(0, v);
        }
        return v != 0;
    }

    private boolean P(EdgeEffect edgeEffect0, int v) {
        return v <= 0 ? this.w(-v) < androidx.core.widget.b.b(edgeEffect0) * ((float)this.getHeight()) : true;
    }

    public final void Q(int v, int v1) {
        this.R(v, v1, 0xFA, false);
    }

    private void R(int v, int v1, int v2, boolean z) {
        if(this.getChildCount() == 0) {
            return;
        }
        if(AnimationUtils.currentAnimationTimeMillis() - this.b > 0xFAL) {
            View view0 = this.getChildAt(0);
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
            int v3 = view0.getHeight() + frameLayout$LayoutParams0.topMargin + frameLayout$LayoutParams0.bottomMargin;
            int v4 = this.getHeight();
            int v5 = this.getPaddingTop();
            int v6 = this.getPaddingBottom();
            int v7 = this.getScrollY();
            this.d.startScroll(this.getScrollX(), v7, 0, Math.max(0, Math.min(v1 + v7, Math.max(0, v3 - (v4 - v5 - v6)))) - v7, v2);
            this.L(z);
        }
        else {
            if(!this.d.isFinished()) {
                this.g();
            }
            this.scrollBy(v, v1);
        }
        this.b = AnimationUtils.currentAnimationTimeMillis();
    }

    void S(int v, int v1, int v2, boolean z) {
        this.R(v - this.getScrollX(), v1 - this.getScrollY(), v2, z);
    }

    void T(int v, int v1, boolean z) {
        this.S(v, v1, 0xFA, z);
    }

    public boolean U(int v, int v1) {
        return this.y.m(v, v1);
    }

    private boolean V(MotionEvent motionEvent0) {
        boolean z;
        if(Float.compare(androidx.core.widget.b.b(this.e), 0.0f) == 0) {
            z = false;
        }
        else {
            androidx.core.widget.b.d(this.e, 0.0f, motionEvent0.getX() / ((float)this.getWidth()));
            z = true;
        }
        if(androidx.core.widget.b.b(this.f) != 0.0f) {
            androidx.core.widget.b.d(this.f, 0.0f, 1.0f - motionEvent0.getX() / ((float)this.getWidth()));
            return true;
        }
        return z;
    }

    public void W(int v) {
        this.y.n(v);
    }

    @Override  // androidx.core.view.o
    public void a(View view0, View view1, int v, int v1) {
        this.x.c(view0, view1, v, v1);
        this.U(2, v1);
    }

    @Override  // android.view.ViewGroup
    public void addView(View view0) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view0);
    }

    @Override  // android.view.ViewGroup
    public void addView(View view0, int v) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view0, v);
    }

    @Override  // android.view.ViewGroup
    public void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view0, v, viewGroup$LayoutParams0);
    }

    @Override  // android.view.ViewGroup
    public void addView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view0, viewGroup$LayoutParams0);
    }

    @Override  // androidx.core.view.o
    public void b(View view0, int v) {
        this.x.d(view0, v);
        this.W(v);
    }

    @Override  // androidx.core.view.o
    public void c(View view0, int v, int v1, int[] arr_v, int v2) {
        this.n(v, v1, arr_v, null, v2);
    }

    @Override  // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override  // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override  // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override  // android.view.View
    public void computeScroll() {
        if(this.d.isFinished()) {
            return;
        }
        this.d.computeScrollOffset();
        int v = this.d.getCurrY();
        int v1 = this.m(v - this.v);
        this.v = v;
        this.t[1] = 0;
        this.n(0, v1, this.t, null, 1);
        int v2 = v1 - this.t[1];
        int v3 = this.getScrollRange();
        if(v2 != 0) {
            int v4 = this.getScrollY();
            this.H(0, v2, this.getScrollX(), v4, 0, v3, 0, 0, false);
            int v5 = this.getScrollY() - v4;
            int v6 = v2 - v5;
            this.t[1] = 0;
            this.o(0, v5, 0, v6, this.s, 1, this.t);
            v2 = v6 - this.t[1];
        }
        if(v2 != 0) {
            int v7 = this.getOverScrollMode();
            if(v7 == 0 || v7 == 1 && v3 > 0) {
                if(v2 >= 0) {
                    if(this.f.isFinished()) {
                        this.f.onAbsorb(((int)this.d.getCurrVelocity()));
                    }
                }
                else if(this.e.isFinished()) {
                    this.e.onAbsorb(((int)this.d.getCurrVelocity()));
                }
            }
            this.g();
        }
        if(!this.d.isFinished()) {
            v.B(this);
            return;
        }
        this.W(1);
    }

    @Override  // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override  // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override  // android.view.View
    public int computeVerticalScrollRange() {
        int v = this.getChildCount();
        int v1 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
        if(v == 0) {
            return v1;
        }
        View view0 = this.getChildAt(0);
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
        int v2 = view0.getBottom() + frameLayout$LayoutParams0.bottomMargin;
        int v3 = this.getScrollY();
        int v4 = Math.max(0, v2 - v1);
        if(v3 < 0) {
            return v2 - v3;
        }
        return v3 <= v4 ? v2 : v2 + (v3 - v4);
    }

    @Override  // androidx.core.view.p
    public void d(View view0, int v, int v1, int v2, int v3, int v4, int[] arr_v) {
        this.F(v3, v4, arr_v);
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        return super.dispatchKeyEvent(keyEvent0) || this.s(keyEvent0);
    }

    @Override  // android.view.View
    public boolean dispatchNestedFling(float f, float f1, boolean z) {
        return this.y.a(f, f1, z);
    }

    @Override  // android.view.View
    public boolean dispatchNestedPreFling(float f, float f1) {
        return this.y.b(f, f1);
    }

    @Override  // android.view.View
    public boolean dispatchNestedPreScroll(int v, int v1, int[] arr_v, int[] arr_v1) {
        return this.n(v, v1, arr_v, arr_v1, 0);
    }

    @Override  // android.view.View
    public boolean dispatchNestedScroll(int v, int v1, int v2, int v3, int[] arr_v) {
        return this.y.e(v, v1, v2, v3, arr_v);
    }

    @Override  // android.view.View
    public void draw(Canvas canvas0) {
        int v6;
        super.draw(canvas0);
        int v = this.getScrollY();
        int v1 = 0;
        if(!this.e.isFinished()) {
            int v2 = canvas0.save();
            int v3 = this.getWidth();
            int v4 = this.getHeight();
            int v5 = Math.min(0, v);
            if(b.a(this)) {
                v3 -= this.getPaddingLeft() + this.getPaddingRight();
                v6 = this.getPaddingLeft();
            }
            else {
                v6 = 0;
            }
            if(b.a(this)) {
                v4 -= this.getPaddingTop() + this.getPaddingBottom();
                v5 += this.getPaddingTop();
            }
            canvas0.translate(((float)v6), ((float)v5));
            this.e.setSize(v3, v4);
            if(this.e.draw(canvas0)) {
                v.B(this);
            }
            canvas0.restoreToCount(v2);
        }
        if(!this.f.isFinished()) {
            int v7 = canvas0.save();
            int v8 = this.getWidth();
            int v9 = this.getHeight();
            int v10 = Math.max(this.getScrollRange(), v) + v9;
            if(b.a(this)) {
                v8 -= this.getPaddingLeft() + this.getPaddingRight();
                v1 = this.getPaddingLeft();
            }
            if(b.a(this)) {
                v9 -= this.getPaddingTop() + this.getPaddingBottom();
                v10 -= this.getPaddingBottom();
            }
            canvas0.translate(((float)(v1 - v8)), ((float)v10));
            canvas0.rotate(180.0f, ((float)v8), 0.0f);
            this.f.setSize(v8, v9);
            if(this.f.draw(canvas0)) {
                v.B(this);
            }
            canvas0.restoreToCount(v7);
        }
    }

    @Override  // androidx.core.view.o
    public void e(View view0, int v, int v1, int v2, int v3, int v4) {
        this.F(v3, v4, null);
    }

    @Override  // androidx.core.view.o
    public boolean f(View view0, View view1, int v, int v1) {
        return (v & 2) != 0;
    }

    private void g() {
        this.d.abortAnimation();
        this.W(1);
    }

    @Override  // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if(this.getChildCount() == 0) {
            return 0.0f;
        }
        View view0 = this.getChildAt(0);
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
        int v = this.getVerticalFadingEdgeLength();
        int v1 = this.getHeight();
        int v2 = this.getPaddingBottom();
        int v3 = view0.getBottom() + frameLayout$LayoutParams0.bottomMargin - this.getScrollY() - (v1 - v2);
        return v3 >= v ? 1.0f : ((float)v3) / ((float)v);
    }

    public int getMaxScrollAmount() {
        return (int)(((float)this.getHeight()) * 0.5f);
    }

    @Override  // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.x.a();
    }

    int getScrollRange() {
        if(this.getChildCount() > 0) {
            View view0 = this.getChildAt(0);
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
            return Math.max(0, view0.getHeight() + frameLayout$LayoutParams0.topMargin + frameLayout$LayoutParams0.bottomMargin - (this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()));
        }
        return 0;
    }

    @Override  // android.view.View
    protected float getTopFadingEdgeStrength() {
        if(this.getChildCount() == 0) {
            return 0.0f;
        }
        int v = this.getVerticalFadingEdgeLength();
        int v1 = this.getScrollY();
        return v1 >= v ? 1.0f : ((float)v1) / ((float)v);
    }

    private float getVerticalScrollFactorCompat() {
        if(this.z == 0.0f) {
            TypedValue typedValue0 = new TypedValue();
            Context context0 = this.getContext();
            if(!context0.getTheme().resolveAttribute(0x101004D, typedValue0, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.z = typedValue0.getDimension(context0.getResources().getDisplayMetrics());
            return this.z;
        }
        return this.z;
    }

    public boolean h(int v) {
        View view0 = this.findFocus();
        if(view0 == this) {
            view0 = null;
        }
        View view1 = FocusFinder.getInstance().findNextFocus(this, view0, v);
        int v1 = this.getMaxScrollAmount();
        if(view1 == null || !this.E(view1, v1, this.getHeight())) {
            if(v == 33 && this.getScrollY() < v1) {
                v1 = this.getScrollY();
            }
            else if(v == 130 && this.getChildCount() > 0) {
                View view2 = this.getChildAt(0);
                FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view2.getLayoutParams();
                v1 = Math.min(view2.getBottom() + frameLayout$LayoutParams0.bottomMargin - (this.getScrollY() + this.getHeight() - this.getPaddingBottom()), v1);
            }
            if(v1 == 0) {
                return false;
            }
            if(v != 130) {
                v1 = -v1;
            }
            this.p(v1);
        }
        else {
            view1.getDrawingRect(this.c);
            this.offsetDescendantRectToMyCoords(view1, this.c);
            this.p(this.l(this.c));
            view1.requestFocus(v);
        }
        if(view0 != null && view0.isFocused() && this.C(view0)) {
            int v2 = this.getDescendantFocusability();
            this.setDescendantFocusability(0x20000);
            this.requestFocus();
            this.setDescendantFocusability(v2);
        }
        return true;
    }

    @Override  // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.x(0);
    }

    private boolean i() {
        int v = this.getOverScrollMode();
        return v == 0 || v == 1 && this.getScrollRange() > 0;
    }

    @Override  // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.y.j();
    }

    private boolean j() {
        if(this.getChildCount() > 0) {
            View view0 = this.getChildAt(0);
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
            return view0.getHeight() + frameLayout$LayoutParams0.topMargin + frameLayout$LayoutParams0.bottomMargin > this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
        }
        return false;
    }

    private static int k(int v, int v1, int v2) {
        if(v1 < v2 && v >= 0) {
            return v1 + v <= v2 ? v : v2 - v1;
        }
        return 0;
    }

    protected int l(Rect rect0) {
        if(this.getChildCount() == 0) {
            return 0;
        }
        int v = this.getHeight();
        int v1 = this.getScrollY();
        int v2 = v1 + v;
        int v3 = this.getVerticalFadingEdgeLength();
        if(rect0.top > 0) {
            v1 += v3;
        }
        View view0 = this.getChildAt(0);
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
        int v4 = rect0.bottom >= view0.getHeight() + frameLayout$LayoutParams0.topMargin + frameLayout$LayoutParams0.bottomMargin ? v2 : v2 - v3;
        int v5 = rect0.bottom;
        if(v5 > v4 && rect0.top > v1) {
            return rect0.height() <= v ? Math.min(rect0.bottom - v4, view0.getBottom() + frameLayout$LayoutParams0.bottomMargin - v2) : Math.min(rect0.top - v1, view0.getBottom() + frameLayout$LayoutParams0.bottomMargin - v2);
        }
        if(rect0.top < v1 && v5 < v4) {
            return rect0.height() <= v ? Math.max(-(v1 - rect0.top), -this.getScrollY()) : Math.max(-(v4 - rect0.bottom), -this.getScrollY());
        }
        return 0;
    }

    int m(int v) {
        int v1 = this.getHeight();
        if(v > 0 && androidx.core.widget.b.b(this.e) != 0.0f) {
            int v2 = Math.round(((float)(-v1)) / 4.0f * androidx.core.widget.b.d(this.e, ((float)(-v)) * 4.0f / ((float)v1), 0.5f));
            if(v2 != v) {
                this.e.finish();
            }
            return v - v2;
        }
        if(v < 0 && androidx.core.widget.b.b(this.f) != 0.0f) {
            int v3 = Math.round(((float)v1) / 4.0f * androidx.core.widget.b.d(this.f, ((float)v) * 4.0f / ((float)v1), 0.5f));
            if(v3 != v) {
                this.f.finish();
            }
            return v - v3;
        }
        return v;
    }

    @Override  // android.view.ViewGroup
    protected void measureChild(View view0, int v, int v1) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        view0.measure(ViewGroup.getChildMeasureSpec(v, this.getPaddingLeft() + this.getPaddingRight(), viewGroup$LayoutParams0.width), 0);
    }

    @Override  // android.view.ViewGroup
    protected void measureChildWithMargins(View view0, int v, int v1, int v2, int v3) {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        view0.measure(ViewGroup.getChildMeasureSpec(v, this.getPaddingLeft() + this.getPaddingRight() + viewGroup$MarginLayoutParams0.leftMargin + viewGroup$MarginLayoutParams0.rightMargin + v1, viewGroup$MarginLayoutParams0.width), View.MeasureSpec.makeMeasureSpec(viewGroup$MarginLayoutParams0.topMargin + viewGroup$MarginLayoutParams0.bottomMargin, 0));
    }

    public boolean n(int v, int v1, int[] arr_v, int[] arr_v1, int v2) {
        return this.y.c(v, v1, arr_v, arr_v1, v2);
    }

    public void o(int v, int v1, int v2, int v3, int[] arr_v, int v4, int[] arr_v1) {
        this.y.d(v, v1, v2, v3, arr_v, v4, arr_v1);
    }

    @Override  // android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.i = false;
    }

    @Override  // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent0) {
        boolean z;
        float f;
        int v = 0;
        if(motionEvent0.getAction() == 8 && !this.k) {
            if(m.a(motionEvent0, 2)) {
                f = motionEvent0.getAxisValue(9);
            }
            else {
                f = m.a(motionEvent0, 0x400000) ? motionEvent0.getAxisValue(26) : 0.0f;
            }
            if(f != 0.0f) {
                float f1 = this.getVerticalScrollFactorCompat();
                int v1 = this.getScrollRange();
                int v2 = this.getScrollY();
                int v3 = v2 - ((int)(f * f1));
                if(v3 >= 0) {
                    if(v3 > v1) {
                        if(this.i() && !m.a(motionEvent0, 0x2002)) {
                            androidx.core.widget.b.d(this.f, ((float)(v3 - v1)) / ((float)this.getHeight()), 0.5f);
                            this.f.onRelease();
                            this.invalidate();
                            v = 1;
                        }
                        z = v;
                        v = v1;
                    }
                    else {
                        z = false;
                        v = v3;
                    }
                }
                else if(this.i() && !m.a(motionEvent0, 0x2002)) {
                    androidx.core.widget.b.d(this.e, -((float)v3) / ((float)this.getHeight()), 0.5f);
                    this.e.onRelease();
                    this.invalidate();
                    z = true;
                }
                else {
                    z = false;
                }
                if(v != v2) {
                    super.scrollTo(this.getScrollX(), v);
                    return true;
                }
                return z;
            }
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getAction();
        boolean z = true;
        if(v == 2 && this.k) {
            return true;
        }
        if((v & 0xFF) == 0) {
            int v4 = (int)motionEvent0.getY();
            if(!this.y(((int)motionEvent0.getX()), v4)) {
                if(!this.V(motionEvent0) && this.d.isFinished()) {
                    z = false;
                }
                this.k = z;
                this.J();
                return this.k;
            }
            this.g = v4;
            this.r = motionEvent0.getPointerId(0);
            this.z();
            this.l.addMovement(motionEvent0);
            this.d.computeScrollOffset();
            if(!this.V(motionEvent0) && this.d.isFinished()) {
                z = false;
            }
            this.k = z;
            this.U(2, 0);
        }
        else {
            switch(v & 0xFF) {
                case 1: {
                    goto label_8;
                }
                case 2: {
                    goto label_17;
                }
            }
            switch(v & 0xFF) {
                case 3: {
                label_8:
                    this.k = false;
                    this.r = -1;
                    this.J();
                    if(this.d.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                        v.B(this);
                    }
                    this.W(0);
                    return this.k;
                }
                case 6: {
                    this.G(motionEvent0);
                    return this.k;
                }
                default: {
                    return this.k;
                }
            }
        label_17:
            int v1 = this.r;
            if(v1 != -1) {
                int v2 = motionEvent0.findPointerIndex(v1);
                if(v2 == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + v1 + " in onInterceptTouchEvent");
                    return this.k;
                }
                int v3 = (int)motionEvent0.getY(v2);
                if(Math.abs(v3 - this.g) > this.o && (2 & this.getNestedScrollAxes()) == 0) {
                    this.k = true;
                    this.g = v3;
                    this.B();
                    this.l.addMovement(motionEvent0);
                    this.u = 0;
                    ViewParent viewParent0 = this.getParent();
                    if(viewParent0 != null) {
                        viewParent0.requestDisallowInterceptTouchEvent(true);
                        return this.k;
                    }
                }
            }
        }
        return this.k;
    }

    @Override  // android.widget.FrameLayout
    protected void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        int v4 = 0;
        this.h = false;
        if(this.j != null && NestedScrollView.D(this.j, this)) {
            this.N(this.j);
        }
        this.j = null;
        if(!this.i) {
            if(this.w != null) {
                this.scrollTo(this.getScrollX(), this.w.e);
                this.w = null;
            }
            if(this.getChildCount() > 0) {
                View view0 = this.getChildAt(0);
                FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
                v4 = view0.getMeasuredHeight() + frameLayout$LayoutParams0.topMargin + frameLayout$LayoutParams0.bottomMargin;
            }
            int v5 = this.getPaddingTop();
            int v6 = this.getPaddingBottom();
            int v7 = this.getScrollY();
            int v8 = NestedScrollView.k(v7, v3 - v1 - v5 - v6, v4);
            if(v8 != v7) {
                this.scrollTo(this.getScrollX(), v8);
            }
        }
        this.scrollTo(this.getScrollX(), this.getScrollY());
        this.i = true;
    }

    @Override  // android.widget.FrameLayout
    protected void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        if(!this.m) {
            return;
        }
        if(View.MeasureSpec.getMode(v1) == 0) {
            return;
        }
        if(this.getChildCount() > 0) {
            View view0 = this.getChildAt(0);
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
            int v2 = view0.getMeasuredHeight();
            int v3 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom() - frameLayout$LayoutParams0.topMargin - frameLayout$LayoutParams0.bottomMargin;
            if(v2 < v3) {
                view0.measure(ViewGroup.getChildMeasureSpec(v, this.getPaddingLeft() + this.getPaddingRight() + frameLayout$LayoutParams0.leftMargin + frameLayout$LayoutParams0.rightMargin, frameLayout$LayoutParams0.width), View.MeasureSpec.makeMeasureSpec(v3, 0x40000000));
            }
        }
    }

    @Override  // android.view.ViewGroup
    public boolean onNestedFling(View view0, float f, float f1, boolean z) {
        if(!z) {
            this.dispatchNestedFling(0.0f, f1, true);
            this.u(((int)f1));
            return true;
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public boolean onNestedPreFling(View view0, float f, float f1) {
        return this.dispatchNestedPreFling(f, f1);
    }

    @Override  // android.view.ViewGroup
    public void onNestedPreScroll(View view0, int v, int v1, int[] arr_v) {
        this.c(view0, v, v1, arr_v, 0);
    }

    @Override  // android.view.ViewGroup
    public void onNestedScroll(View view0, int v, int v1, int v2, int v3) {
        this.F(v3, 0, null);
    }

    @Override  // android.view.ViewGroup
    public void onNestedScrollAccepted(View view0, View view1, int v) {
        this.a(view0, view1, v, 0);
    }

    @Override  // android.view.View
    protected void onOverScrolled(int v, int v1, boolean z, boolean z1) {
        super.scrollTo(v, v1);
    }

    @Override  // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int v, Rect rect0) {
        switch(v) {
            case 1: {
                v = 33;
                break;
            }
            case 2: {
                v = 130;
            }
        }
        FocusFinder focusFinder0 = FocusFinder.getInstance();
        View view0 = rect0 == null ? focusFinder0.findNextFocus(this, null, v) : focusFinder0.findNextFocusFromRect(this, rect0, v);
        if(view0 == null) {
            return false;
        }
        return this.C(view0) ? false : view0.requestFocus(v, rect0);
    }

    @Override  // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof d)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((d)parcelable0).getSuperState());
        this.w = (d)parcelable0;
        this.requestLayout();
    }

    @Override  // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new d(super.onSaveInstanceState());
        parcelable0.e = this.getScrollY();
        return parcelable0;
    }

    @Override  // android.view.View
    protected void onScrollChanged(int v, int v1, int v2, int v3) {
        super.onScrollChanged(v, v1, v2, v3);
    }

    @Override  // android.view.View
    protected void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        View view0 = this.findFocus();
        if(view0 != null && this != view0 && this.E(view0, 0, v3)) {
            view0.getDrawingRect(this.c);
            this.offsetDescendantRectToMyCoords(view0, this.c);
            this.p(this.l(this.c));
        }
    }

    @Override  // android.view.ViewGroup
    public boolean onStartNestedScroll(View view0, View view1, int v) {
        return this.f(view0, view1, v, 0);
    }

    @Override  // android.view.ViewGroup
    public void onStopNestedScroll(View view0) {
        this.b(view0, 0);
    }

    @Override  // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        this.B();
        int v = motionEvent0.getActionMasked();
        int v1 = 0;
        if(v == 0) {
            this.u = 0;
        }
        MotionEvent motionEvent1 = MotionEvent.obtain(motionEvent0);
        motionEvent1.offsetLocation(0.0f, ((float)this.u));
        if(v == 0) {
            if(this.getChildCount() == 0) {
                return false;
            }
            if(this.k) {
                ViewParent viewParent1 = this.getParent();
                if(viewParent1 != null) {
                    viewParent1.requestDisallowInterceptTouchEvent(true);
                }
            }
            if(!this.d.isFinished()) {
                this.g();
            }
            this.g = (int)motionEvent0.getY();
            this.r = motionEvent0.getPointerId(0);
            this.U(2, 0);
        }
        else {
            switch(v) {
                case 1: {
                    VelocityTracker velocityTracker0 = this.l;
                    velocityTracker0.computeCurrentVelocity(1000, ((float)this.q));
                    int v2 = (int)velocityTracker0.getYVelocity(this.r);
                    if(Math.abs(v2) < this.p) {
                        if(this.d.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                            v.B(this);
                        }
                    }
                    else if(!this.q(v2) && !this.dispatchNestedPreFling(0.0f, ((float)(-v2)))) {
                        this.dispatchNestedFling(0.0f, ((float)(-v2)), true);
                        this.u(-v2);
                    }
                    this.r = -1;
                    this.r();
                    break;
                }
                case 2: {
                    int v3 = motionEvent0.findPointerIndex(this.r);
                    if(v3 == -1) {
                        Log.e("NestedScrollView", "Invalid pointerId=" + this.r + " in onTouchEvent");
                    }
                    else {
                        int v4 = (int)motionEvent0.getY(v3);
                        int v5 = this.g - v4;
                        int v6 = v5 - this.K(v5, motionEvent0.getX(v3));
                        if(!this.k && Math.abs(v6) > this.o) {
                            ViewParent viewParent0 = this.getParent();
                            if(viewParent0 != null) {
                                viewParent0.requestDisallowInterceptTouchEvent(true);
                            }
                            this.k = true;
                            v6 = v6 <= 0 ? v6 + this.o : v6 - this.o;
                        }
                        int v7 = v6;
                        if(this.k) {
                            if(this.n(0, v7, this.t, this.s, 0)) {
                                v7 -= this.t[1];
                                this.u += this.s[1];
                            }
                            this.g = v4 - this.s[1];
                            int v8 = this.getScrollY();
                            int v9 = this.getScrollRange();
                            int v10 = this.getOverScrollMode();
                            int v11 = !this.H(0, v7, 0, this.getScrollY(), 0, v9, 0, 0, true) || this.x(0) ? 0 : 1;
                            int v12 = this.getScrollY();
                            this.t[1] = 0;
                            this.o(0, v12 - v8, 0, v7 - (v12 - v8), this.s, 0, this.t);
                            this.g -= this.s[1];
                            this.u += this.s[1];
                            if(v10 != 0 && (v10 != 1 || v9 <= 0)) {
                                v1 = v11;
                            }
                            else {
                                int v13 = v7 - this.t[1];
                                int v14 = v8 + v13;
                                if(v14 < 0) {
                                    androidx.core.widget.b.d(this.e, ((float)(-v13)) / ((float)this.getHeight()), motionEvent0.getX(v3) / ((float)this.getWidth()));
                                    if(!this.f.isFinished()) {
                                        this.f.onRelease();
                                    }
                                }
                                else if(v14 > v9) {
                                    androidx.core.widget.b.d(this.f, ((float)v13) / ((float)this.getHeight()), 1.0f - motionEvent0.getX(v3) / ((float)this.getWidth()));
                                    if(!this.e.isFinished()) {
                                        this.e.onRelease();
                                    }
                                }
                                if(this.e.isFinished() && this.f.isFinished()) {
                                    v1 = v11;
                                }
                                else {
                                    v.B(this);
                                }
                            }
                            if(v1 != 0) {
                                this.l.clear();
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    if(this.k && this.getChildCount() > 0 && this.d.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                        v.B(this);
                    }
                    this.r = -1;
                    this.r();
                    break;
                }
                case 5: {
                    int v15 = motionEvent0.getActionIndex();
                    this.g = (int)motionEvent0.getY(v15);
                    this.r = motionEvent0.getPointerId(v15);
                    break;
                }
                case 6: {
                    this.G(motionEvent0);
                    this.g = (int)motionEvent0.getY(motionEvent0.findPointerIndex(this.r));
                }
            }
        }
        VelocityTracker velocityTracker1 = this.l;
        if(velocityTracker1 != null) {
            velocityTracker1.addMovement(motionEvent1);
        }
        motionEvent1.recycle();
        return true;
    }

    private void p(int v) {
        if(v != 0) {
            if(this.n) {
                this.Q(0, v);
                return;
            }
            this.scrollBy(0, v);
        }
    }

    private boolean q(int v) {
        EdgeEffect edgeEffect0;
        if(androidx.core.widget.b.b(this.e) != 0.0f) {
            if(this.P(this.e, v)) {
                edgeEffect0 = this.e;
                edgeEffect0.onAbsorb(v);
                return true;
            }
            v = -v;
        }
        else if(androidx.core.widget.b.b(this.f) != 0.0f) {
            v = -v;
            if(this.P(this.f, v)) {
                edgeEffect0 = this.f;
                edgeEffect0.onAbsorb(v);
                return true;
            }
        }
        else {
            return false;
        }
        this.u(v);
        return true;
    }

    private void r() {
        this.k = false;
        this.J();
        this.W(0);
        this.e.onRelease();
        this.f.onRelease();
    }

    @Override  // android.view.ViewGroup
    public void requestChildFocus(View view0, View view1) {
        if(this.h) {
            this.j = view1;
        }
        else {
            this.N(view1);
        }
        super.requestChildFocus(view0, view1);
    }

    @Override  // android.view.ViewGroup
    public boolean requestChildRectangleOnScreen(View view0, Rect rect0, boolean z) {
        rect0.offset(view0.getLeft() - view0.getScrollX(), view0.getTop() - view0.getScrollY());
        return this.O(rect0, z);
    }

    @Override  // android.view.ViewGroup
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if(z) {
            this.J();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override  // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.h = true;
        super.requestLayout();
    }

    public boolean s(KeyEvent keyEvent0) {
        this.c.setEmpty();
        int v = 130;
        if(!this.j()) {
            if(this.isFocused() && keyEvent0.getKeyCode() != 4) {
                View view0 = this.findFocus();
                if(view0 == this) {
                    view0 = null;
                }
                View view1 = FocusFinder.getInstance().findNextFocus(this, view0, 130);
                return view1 != null && view1 != this && view1.requestFocus(130);
            }
            return false;
        }
        if(keyEvent0.getAction() == 0) {
            switch(keyEvent0.getKeyCode()) {
                case 19: {
                    return keyEvent0.isAltPressed() ? this.v(33) : this.h(33);
                }
                case 20: {
                    return keyEvent0.isAltPressed() ? this.v(130) : this.h(130);
                }
                case 62: {
                    if(keyEvent0.isShiftPressed()) {
                        v = 33;
                    }
                    this.I(v);
                    return false;
                }
                default: {
                    return false;
                }
            }
        }
        return false;
    }

    @Override  // android.view.View
    public void scrollTo(int v, int v1) {
        if(this.getChildCount() > 0) {
            View view0 = this.getChildAt(0);
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
            int v2 = NestedScrollView.k(v, this.getWidth() - this.getPaddingLeft() - this.getPaddingRight(), view0.getWidth() + frameLayout$LayoutParams0.leftMargin + frameLayout$LayoutParams0.rightMargin);
            int v3 = NestedScrollView.k(v1, this.getHeight() - this.getPaddingTop() - this.getPaddingBottom(), view0.getHeight() + frameLayout$LayoutParams0.topMargin + frameLayout$LayoutParams0.bottomMargin);
            if(v2 != this.getScrollX() || v3 != this.getScrollY()) {
                super.scrollTo(v2, v3);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if(z != this.m) {
            this.m = z;
            this.requestLayout();
        }
    }

    @Override  // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.y.k(z);
    }

    public void setOnScrollChangeListener(c nestedScrollView$c0) {
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.n = z;
    }

    @Override  // android.widget.FrameLayout
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override  // android.view.View
    public boolean startNestedScroll(int v) {
        return this.U(v, 0);
    }

    @Override  // android.view.View
    public void stopNestedScroll() {
        this.W(0);
    }

    private View t(boolean z, int v, int v1) {
        ArrayList arrayList0 = this.getFocusables(2);
        int v2 = arrayList0.size();
        View view0 = null;
        int v4 = 0;
        for(int v3 = 0; v3 < v2; ++v3) {
            View view1 = (View)arrayList0.get(v3);
            int v5 = view1.getTop();
            int v6 = view1.getBottom();
            if(v < v6 && v5 < v1) {
                int v7 = v >= v5 || v6 >= v1 ? 0 : 1;
                if(view0 == null) {
                    view0 = view1;
                    v4 = v7;
                }
                else {
                    boolean z1 = z && v5 < view0.getTop() || !z && v6 > view0.getBottom();
                    if(v4 == 0) {
                        if(v7 != 0) {
                            view0 = view1;
                            v4 = 1;
                        }
                        else if(z1) {
                            view0 = view1;
                        }
                    }
                    else if(v7 != 0 && z1) {
                        view0 = view1;
                    }
                }
            }
        }
        return view0;
    }

    public void u(int v) {
        if(this.getChildCount() > 0) {
            this.d.fling(this.getScrollX(), this.getScrollY(), 0, v, 0, 0, 0x80000000, 0x7FFFFFFF, 0, 0);
            this.L(true);
        }
    }

    public boolean v(int v) {
        int v1 = this.getHeight();
        this.c.top = 0;
        this.c.bottom = v1;
        if(v == 130) {
            int v2 = this.getChildCount();
            if(v2 > 0) {
                View view0 = this.getChildAt(v2 - 1);
                FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
                this.c.bottom = view0.getBottom() + frameLayout$LayoutParams0.bottomMargin + this.getPaddingBottom();
                this.c.top = this.c.bottom - v1;
            }
        }
        return this.M(v, this.c.top, this.c.bottom);
    }

    private float w(int v) {
        return (float)(((double)(this.a * 0.015f)) * Math.exp(((double)NestedScrollView.A) / (((double)NestedScrollView.A) - 1.0) * Math.log(((float)Math.abs(v)) * 0.35f / (this.a * 0.015f))));
    }

    public boolean x(int v) {
        return this.y.i(v);
    }

    private boolean y(int v, int v1) {
        if(this.getChildCount() > 0) {
            int v2 = this.getScrollY();
            View view0 = this.getChildAt(0);
            return v1 >= view0.getTop() - v2 && v1 < view0.getBottom() - v2 && v >= view0.getLeft() && v < view0.getRight();
        }
        return false;
    }

    private void z() {
        VelocityTracker velocityTracker0 = this.l;
        if(velocityTracker0 == null) {
            this.l = VelocityTracker.obtain();
            return;
        }
        velocityTracker0.clear();
    }
}

