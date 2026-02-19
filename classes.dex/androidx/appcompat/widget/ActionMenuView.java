package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.e.b;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.j;

public class ActionMenuView extends y implements b, j {
    public interface a {
        boolean a();

        boolean b();
    }

    static class androidx.appcompat.widget.ActionMenuView.b implements androidx.appcompat.view.menu.i.a {
        @Override  // androidx.appcompat.view.menu.i$a
        public void a(e e0, boolean z) {
        }

        @Override  // androidx.appcompat.view.menu.i$a
        public boolean b(e e0) {
            return false;
        }
    }

    public static class c extends androidx.appcompat.widget.y.a {
        public boolean a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;
        boolean f;

        public c(int v, int v1) {
            super(v, v1);
            this.a = false;
        }

        public c(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
        }

        public c(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
            super(viewGroup$LayoutParams0);
        }

        public c(c actionMenuView$c0) {
            super(actionMenuView$c0);
            this.a = actionMenuView$c0.a;
        }
    }

    class d implements androidx.appcompat.view.menu.e.a {
        final ActionMenuView a;

        @Override  // androidx.appcompat.view.menu.e$a
        public boolean a(e e0, MenuItem menuItem0) {
            androidx.appcompat.widget.ActionMenuView.e actionMenuView$e0 = ActionMenuView.this.A;
            return actionMenuView$e0 != null && actionMenuView$e0.onMenuItemClick(menuItem0);
        }

        @Override  // androidx.appcompat.view.menu.e$a
        public void b(e e0) {
            androidx.appcompat.view.menu.e.a e$a0 = ActionMenuView.this.v;
            if(e$a0 != null) {
                e$a0.b(e0);
            }
        }
    }

    public interface androidx.appcompat.widget.ActionMenuView.e {
        boolean onMenuItemClick(MenuItem arg1);
    }

    androidx.appcompat.widget.ActionMenuView.e A;
    private e p;
    private Context q;
    private int r;
    private boolean s;
    private androidx.appcompat.widget.c t;
    private androidx.appcompat.view.menu.i.a u;
    androidx.appcompat.view.menu.e.a v;
    private boolean w;
    private int x;
    private int y;
    private int z;

    public ActionMenuView(Context context0) {
        this(context0, null);
    }

    public ActionMenuView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.setBaselineAligned(false);
        DisplayMetrics displayMetrics0 = context0.getResources().getDisplayMetrics();
        this.y = (int)(56.0f * displayMetrics0.density);
        this.z = (int)(displayMetrics0.density * 4.0f);
        this.q = context0;
        this.r = 0;
    }

    public c A(AttributeSet attributeSet0) {
        return new c(this.getContext(), attributeSet0);
    }

    protected c B(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(viewGroup$LayoutParams0 != null) {
            c actionMenuView$c0 = viewGroup$LayoutParams0 instanceof c ? new c(((c)viewGroup$LayoutParams0)) : new c(viewGroup$LayoutParams0);
            if(actionMenuView$c0.gravity <= 0) {
                actionMenuView$c0.gravity = 16;
            }
            return actionMenuView$c0;
        }
        return this.z();
    }

    public c C() {
        c actionMenuView$c0 = this.z();
        actionMenuView$c0.a = true;
        return actionMenuView$c0;
    }

    protected boolean D(int v) {
        boolean z = false;
        if(v == 0) {
            return false;
        }
        View view0 = this.getChildAt(v - 1);
        View view1 = this.getChildAt(v);
        if(v < this.getChildCount() && view0 instanceof a) {
            z = ((a)view0).a();
        }
        return v > 0 && view1 instanceof a ? z | ((a)view1).b() : z;
    }

    public void E(e e0) {
        this.p = e0;
    }

    public boolean F() {
        return this.t != null && this.t.B();
    }

    static int G(View view0, int v, int v1, int v2, int v3) {
        c actionMenuView$c0 = (c)view0.getLayoutParams();
        int v4 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(v2) - v3, View.MeasureSpec.getMode(v2));
        ActionMenuItemView actionMenuItemView0 = view0 instanceof ActionMenuItemView ? ((ActionMenuItemView)view0) : null;
        boolean z = true;
        boolean z1 = actionMenuItemView0 != null && actionMenuItemView0.r();
        int v5 = 2;
        if(v1 <= 0 || z1 && v1 < 2) {
            v5 = 0;
        }
        else {
            view0.measure(View.MeasureSpec.makeMeasureSpec(v1 * v, 0x80000000), v4);
            int v6 = view0.getMeasuredWidth();
            int v7 = v6 / v;
            if(v6 % v != 0) {
                ++v7;
            }
            if(!z1 || v7 >= 2) {
                v5 = v7;
            }
        }
        if(actionMenuView$c0.a || !z1) {
            z = false;
        }
        actionMenuView$c0.d = z;
        actionMenuView$c0.b = v5;
        view0.measure(View.MeasureSpec.makeMeasureSpec(v * v5, 0x40000000), v4);
        return v5;
    }

    private void H(int v, int v1) {
        int v36;
        int v33;
        int v30;
        int v29;
        int v20;
        int v2 = View.MeasureSpec.getMode(v1);
        int v3 = View.MeasureSpec.getSize(v);
        int v4 = View.MeasureSpec.getSize(v1);
        int v5 = this.getPaddingLeft();
        int v6 = this.getPaddingRight();
        int v7 = this.getPaddingTop() + this.getPaddingBottom();
        int v8 = ViewGroup.getChildMeasureSpec(v1, v7, -2);
        int v9 = v3 - (v5 + v6);
        int v10 = this.y;
        int v11 = v9 / v10;
        if(v11 == 0) {
            this.setMeasuredDimension(v9, 0);
            return;
        }
        int v12 = v10 + v9 % v10 / v11;
        int v13 = this.getChildCount();
        int v14 = 0;
        boolean z = false;
        int v16 = 0;
        int v17 = 0;
        int v18 = 0;
        long v19 = 0L;
        for(int v15 = 0; v15 < v13; ++v15) {
            View view0 = this.getChildAt(v15);
            if(view0.getVisibility() != 8) {
                if(view0 instanceof ActionMenuItemView) {
                    v20 = v16 + 1;
                    view0.setPadding(this.z, 0, this.z, 0);
                }
                else {
                    v20 = v16 + 1;
                }
                c actionMenuView$c0 = (c)view0.getLayoutParams();
                actionMenuView$c0.f = false;
                actionMenuView$c0.c = 0;
                actionMenuView$c0.b = 0;
                actionMenuView$c0.d = false;
                actionMenuView$c0.leftMargin = 0;
                actionMenuView$c0.rightMargin = 0;
                actionMenuView$c0.e = view0 instanceof ActionMenuItemView && ((ActionMenuItemView)view0).r();
                int v21 = ActionMenuView.G(view0, v12, (actionMenuView$c0.a ? 1 : v11), v8, v7);
                v17 = Math.max(v17, v21);
                if(actionMenuView$c0.d) {
                    ++v18;
                }
                if(actionMenuView$c0.a) {
                    z = true;
                }
                v11 -= v21;
                v14 = Math.max(v14, view0.getMeasuredHeight());
                if(v21 == 1) {
                    v19 |= (long)(1 << v15);
                }
                v16 = v20;
            }
        }
        int v22 = !z || v16 != 2 ? 0 : 1;
        int v23 = 0;
        while(true) {
            if(v18 <= 0 || v11 <= 0) {
                goto label_100;
            }
            int v24 = 0x7FFFFFFF;
            int v25 = 0;
            long v27 = 0L;
            for(int v26 = 0; v26 < v13; ++v26) {
                c actionMenuView$c1 = (c)this.getChildAt(v26).getLayoutParams();
                if(actionMenuView$c1.d) {
                    int v28 = actionMenuView$c1.b;
                    if(v28 < v24) {
                        v27 = 1L << v26;
                        v24 = v28;
                        v25 = 1;
                    }
                    else if(v28 == v24) {
                        ++v25;
                        v27 |= 1L << v26;
                    }
                }
            }
            v29 = v23;
            v30 = v14;
            v19 |= v27;
            if(v25 <= v11) {
                int v31 = v24 + 1;
                int v32 = 0;
                while(v32 < v13) {
                    View view1 = this.getChildAt(v32);
                    c actionMenuView$c2 = (c)view1.getLayoutParams();
                    if((v27 & ((long)(1 << v32))) == 0L) {
                        if(actionMenuView$c2.b == v31) {
                            v19 |= (long)(1 << v32);
                        }
                        v33 = v22;
                    }
                    else {
                        if(v22 == 0 || !actionMenuView$c2.e || v11 != 1) {
                            v33 = v22;
                        }
                        else {
                            v33 = v22;
                            view1.setPadding(this.z + v12, 0, this.z, 0);
                        }
                        ++actionMenuView$c2.b;
                        actionMenuView$c2.f = true;
                        --v11;
                    }
                    ++v32;
                    v22 = v33;
                }
                v14 = v30;
                v23 = 1;
                continue;
            label_100:
                v29 = v23;
                v30 = v14;
            }
            break;
        }
        boolean z1 = !z && v16 == 1;
        if(v11 <= 0 || v19 == 0L || v11 >= v16 - 1 && !z1 && v17 <= 1) {
            v36 = v29;
        }
        else {
            float f = (float)Long.bitCount(v19);
            if(!z1) {
                if(Long.compare(v19 & 1L, 0L) != 0 && !((c)this.getChildAt(0).getLayoutParams()).e) {
                    f -= 0.5f;
                }
                if((v19 & ((long)(1 << v13 - 1))) != 0L && !((c)this.getChildAt(v13 - 1).getLayoutParams()).e) {
                    f -= 0.5f;
                }
            }
            int v34 = f > 0.0f ? ((int)(((float)(v11 * v12)) / f)) : 0;
            v36 = v29;
            for(int v35 = 0; v35 < v13; ++v35) {
                if((v19 & ((long)(1 << v35))) != 0L) {
                    View view2 = this.getChildAt(v35);
                    c actionMenuView$c3 = (c)view2.getLayoutParams();
                    if(view2 instanceof ActionMenuItemView) {
                        actionMenuView$c3.c = v34;
                        actionMenuView$c3.f = true;
                        if(v35 == 0 && !actionMenuView$c3.e) {
                            actionMenuView$c3.leftMargin = -v34 / 2;
                        }
                        v36 = 1;
                    }
                    else if(actionMenuView$c3.a) {
                        actionMenuView$c3.c = v34;
                        actionMenuView$c3.f = true;
                        actionMenuView$c3.rightMargin = -v34 / 2;
                        v36 = 1;
                    }
                    else {
                        if(v35 != 0) {
                            actionMenuView$c3.leftMargin = v34 / 2;
                        }
                        if(v35 != v13 - 1) {
                            actionMenuView$c3.rightMargin = v34 / 2;
                        }
                    }
                }
            }
        }
        if(v36 != 0) {
            for(int v37 = 0; v37 < v13; ++v37) {
                View view3 = this.getChildAt(v37);
                c actionMenuView$c4 = (c)view3.getLayoutParams();
                if(actionMenuView$c4.f) {
                    view3.measure(View.MeasureSpec.makeMeasureSpec(actionMenuView$c4.b * v12 + actionMenuView$c4.c, 0x40000000), v8);
                }
            }
        }
        this.setMeasuredDimension(v9, (v2 == 0x40000000 ? v4 : v30));
    }

    public e I() {
        return this.p;
    }

    public void J(androidx.appcompat.view.menu.i.a i$a0, androidx.appcompat.view.menu.e.a e$a0) {
        this.u = i$a0;
        this.v = e$a0;
    }

    public boolean K() {
        return this.t != null && this.t.H();
    }

    @Override  // androidx.appcompat.view.menu.e$b
    public boolean a(f f0) {
        return this.p.H(f0, 0);
    }

    @Override  // androidx.appcompat.widget.y
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof c;
    }

    @Override  // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        return false;
    }

    @Override  // androidx.appcompat.widget.y
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.z();
    }

    @Override  // androidx.appcompat.widget.y
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return this.A(attributeSet0);
    }

    @Override  // androidx.appcompat.widget.y
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return this.B(viewGroup$LayoutParams0);
    }

    public Menu getMenu() {
        if(this.p == null) {
            Context context0 = this.getContext();
            e e0 = new e(context0);
            this.p = e0;
            e0.L(new d(this));
            androidx.appcompat.widget.c c0 = new androidx.appcompat.widget.c(context0);
            this.t = c0;
            c0.G(true);
            androidx.appcompat.widget.c c1 = this.t;
            androidx.appcompat.view.menu.i.a i$a0 = this.u;
            if(i$a0 == null) {
                i$a0 = new androidx.appcompat.widget.ActionMenuView.b();
            }
            c1.i(i$a0);
            this.p.b(this.t, this.q);
            this.t.E(this);
        }
        return this.p;
    }

    public Drawable getOverflowIcon() {
        this.getMenu();
        return this.t.y();
    }

    public int getPopupTheme() {
        return this.r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override  // androidx.appcompat.widget.y
    protected androidx.appcompat.widget.y.a j() {
        return this.z();
    }

    @Override  // androidx.appcompat.widget.y
    public androidx.appcompat.widget.y.a k(AttributeSet attributeSet0) {
        return this.A(attributeSet0);
    }

    @Override  // androidx.appcompat.widget.y
    protected androidx.appcompat.widget.y.a l(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return this.B(viewGroup$LayoutParams0);
    }

    @Override  // android.view.View
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        androidx.appcompat.widget.c c0 = this.t;
        if(c0 != null) {
            c0.k(false);
            if(this.t.B()) {
                this.t.z();
                this.t.H();
            }
        }
    }

    @Override  // android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.y();
    }

    @Override  // androidx.appcompat.widget.y
    protected void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v15;
        int v14;
        if(!this.w) {
            super.onLayout(z, v, v1, v2, v3);
            return;
        }
        int v4 = this.getChildCount();
        int v5 = (v3 - v1) / 2;
        int v6 = this.getDividerWidth();
        int v7 = v2 - v;
        int v8 = v7 - this.getPaddingRight() - this.getPaddingLeft();
        boolean z1 = v0.a(this);
        int v10 = 0;
        int v11 = 0;
        for(int v9 = 0; v9 < v4; ++v9) {
            View view0 = this.getChildAt(v9);
            if(view0.getVisibility() != 8) {
                c actionMenuView$c0 = (c)view0.getLayoutParams();
                if(actionMenuView$c0.a) {
                    int v12 = view0.getMeasuredWidth();
                    if(this.D(v9)) {
                        v12 += v6;
                    }
                    int v13 = view0.getMeasuredHeight();
                    if(z1) {
                        v14 = this.getPaddingLeft() + actionMenuView$c0.leftMargin;
                        v15 = v14 + v12;
                    }
                    else {
                        v15 = this.getWidth() - this.getPaddingRight() - actionMenuView$c0.rightMargin;
                        v14 = v15 - v12;
                    }
                    int v16 = v5 - v13 / 2;
                    view0.layout(v14, v16, v15, v13 + v16);
                    v8 -= v12;
                    v10 = 1;
                }
                else {
                    v8 -= view0.getMeasuredWidth() + actionMenuView$c0.leftMargin + actionMenuView$c0.rightMargin;
                    this.D(v9);
                    ++v11;
                }
            }
        }
        if(v4 == 1 && v10 == 0) {
            View view1 = this.getChildAt(0);
            int v17 = view1.getMeasuredWidth();
            int v18 = view1.getMeasuredHeight();
            int v19 = v7 / 2 - v17 / 2;
            int v20 = v5 - v18 / 2;
            view1.layout(v19, v20, v17 + v19, v18 + v20);
            return;
        }
        int v21 = v11 - (v10 ^ 1);
        int v22 = Math.max(0, (v21 <= 0 ? 0 : v8 / v21));
        if(z1) {
            int v23 = this.getWidth() - this.getPaddingRight();
            for(int v24 = 0; v24 < v4; ++v24) {
                View view2 = this.getChildAt(v24);
                c actionMenuView$c1 = (c)view2.getLayoutParams();
                if(view2.getVisibility() != 8 && !actionMenuView$c1.a) {
                    int v25 = v23 - actionMenuView$c1.rightMargin;
                    int v26 = view2.getMeasuredWidth();
                    int v27 = view2.getMeasuredHeight();
                    int v28 = v5 - v27 / 2;
                    view2.layout(v25 - v26, v28, v25, v27 + v28);
                    v23 = v25 - (v26 + actionMenuView$c1.leftMargin + v22);
                }
            }
            return;
        }
        int v29 = this.getPaddingLeft();
        for(int v30 = 0; v30 < v4; ++v30) {
            View view3 = this.getChildAt(v30);
            c actionMenuView$c2 = (c)view3.getLayoutParams();
            if(view3.getVisibility() != 8 && !actionMenuView$c2.a) {
                int v31 = v29 + actionMenuView$c2.leftMargin;
                int v32 = view3.getMeasuredWidth();
                int v33 = view3.getMeasuredHeight();
                int v34 = v5 - v33 / 2;
                view3.layout(v31, v34, v31 + v32, v33 + v34);
                v29 = v31 + (v32 + actionMenuView$c2.rightMargin + v22);
            }
        }
    }

    @Override  // androidx.appcompat.widget.y
    protected void onMeasure(int v, int v1) {
        boolean z = this.w;
        boolean z1 = View.MeasureSpec.getMode(v) == 0x40000000;
        this.w = z1;
        if(z != z1) {
            this.x = 0;
        }
        int v2 = View.MeasureSpec.getSize(v);
        if(this.w) {
            e e0 = this.p;
            if(e0 != null && v2 != this.x) {
                this.x = v2;
                e0.G(true);
            }
        }
        int v3 = this.getChildCount();
        if(this.w && v3 > 0) {
            this.H(v, v1);
            return;
        }
        for(int v4 = 0; v4 < v3; ++v4) {
            c actionMenuView$c0 = (c)this.getChildAt(v4).getLayoutParams();
            actionMenuView$c0.rightMargin = 0;
            actionMenuView$c0.leftMargin = 0;
        }
        super.onMeasure(v, v1);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.t.D(z);
    }

    public void setOnMenuItemClickListener(androidx.appcompat.widget.ActionMenuView.e actionMenuView$e0) {
        this.A = actionMenuView$e0;
    }

    public void setOverflowIcon(Drawable drawable0) {
        this.getMenu();
        this.t.F(drawable0);
    }

    public void setOverflowReserved(boolean z) {
        this.s = z;
    }

    public void setPopupTheme(int v) {
        if(this.r != v) {
            this.r = v;
            if(v == 0) {
                this.q = this.getContext();
                return;
            }
            this.q = new ContextThemeWrapper(this.getContext(), v);
        }
    }

    public void setPresenter(androidx.appcompat.widget.c c0) {
        this.t = c0;
        c0.E(this);
    }

    public void y() {
        androidx.appcompat.widget.c c0 = this.t;
        if(c0 != null) {
            c0.w();
        }
    }

    protected c z() {
        c actionMenuView$c0 = new c(-2, -2);
        actionMenuView$c0.gravity = 16;
        return actionMenuView$c0;
    }
}

