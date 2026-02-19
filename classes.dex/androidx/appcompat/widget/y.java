package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout.LayoutParams;
import androidx.core.view.e;
import androidx.core.view.v;
import c.i;

public abstract class y extends ViewGroup {
    public static class a extends LinearLayout.LayoutParams {
        public a(int v, int v1) {
            super(v, v1);
        }

        public a(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
        }

        public a(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
            super(viewGroup$LayoutParams0);
        }
    }

    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    public y(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public y(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = true;
        this.b = -1;
        this.c = 0;
        this.e = 0x800033;
        l0 l00 = l0.s(context0, attributeSet0, i.r0, v, 0);
        v.F(this, context0, i.r0, attributeSet0, l00.o(), v, 0);
        int v1 = l00.i(i.t0, -1);
        if(v1 >= 0) {
            this.setOrientation(v1);
        }
        int v2 = l00.i(i.s0, -1);
        if(v2 >= 0) {
            this.setGravity(v2);
        }
        if(!l00.a(i.u0, true)) {
            this.setBaselineAligned(false);
        }
        this.g = l00.g(i.w0, -1.0f);
        this.b = l00.i(i.v0, -1);
        this.h = l00.a(i.z0, false);
        this.setDividerDrawable(l00.f(i.x0));
        this.n = l00.i(i.A0, 0);
        this.o = l00.e(i.y0, 0);
        l00.t();
    }

    @Override  // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof a;
    }

    void d(Canvas canvas0) {
        int v2;
        int v = this.getVirtualChildCount();
        boolean z = v0.a(this);
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = this.p(v1);
            if(view0 != null && view0.getVisibility() != 8 && this.q(v1)) {
                a y$a0 = (a)view0.getLayoutParams();
                this.g(canvas0, (z ? view0.getRight() + y$a0.rightMargin : view0.getLeft() - y$a0.leftMargin - this.l));
            }
        }
        if(this.q(v)) {
            View view1 = this.p(v - 1);
            if(view1 != null) {
                a y$a1 = (a)view1.getLayoutParams();
                v2 = z ? view1.getLeft() - y$a1.leftMargin - this.l : view1.getRight() + y$a1.rightMargin;
            }
            else if(z) {
                v2 = this.getPaddingLeft();
            }
            else {
                v2 = this.getWidth() - this.getPaddingRight() - this.l;
            }
            this.g(canvas0, v2);
        }
    }

    void e(Canvas canvas0) {
        int v2;
        int v = this.getVirtualChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = this.p(v1);
            if(view0 != null && view0.getVisibility() != 8 && this.q(v1)) {
                a y$a0 = (a)view0.getLayoutParams();
                this.f(canvas0, view0.getTop() - y$a0.topMargin - this.m);
            }
        }
        if(this.q(v)) {
            View view1 = this.p(v - 1);
            if(view1 == null) {
                v2 = this.getHeight() - this.getPaddingBottom() - this.m;
            }
            else {
                a y$a1 = (a)view1.getLayoutParams();
                v2 = view1.getBottom() + y$a1.bottomMargin;
            }
            this.f(canvas0, v2);
        }
    }

    void f(Canvas canvas0, int v) {
        this.k.setBounds(this.getPaddingLeft() + this.o, v, this.getWidth() - this.getPaddingRight() - this.o, this.m + v);
        this.k.draw(canvas0);
    }

    void g(Canvas canvas0, int v) {
        this.k.setBounds(v, this.getPaddingTop() + this.o, this.l + v, this.getHeight() - this.getPaddingBottom() - this.o);
        this.k.draw(canvas0);
    }

    @Override  // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.j();
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return this.k(attributeSet0);
    }

    @Override  // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return this.l(viewGroup$LayoutParams0);
    }

    @Override  // android.view.View
    public int getBaseline() {
        if(this.b < 0) {
            return super.getBaseline();
        }
        int v = this.getChildCount();
        int v1 = this.b;
        if(v <= v1) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View view0 = this.getChildAt(v1);
        int v2 = view0.getBaseline();
        if(v2 == -1) {
            if(this.b != 0) {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn\'t know how to get its baseline.");
            }
            return -1;
        }
        int v3 = this.c;
        if(this.d == 1) {
            switch(this.e & 0x70) {
                case 16: {
                    v3 += (this.getBottom() - this.getTop() - this.getPaddingTop() - this.getPaddingBottom() - this.f) / 2;
                    break;
                }
                case 80: {
                    return this.getBottom() - this.getTop() - this.getPaddingBottom() - this.f + ((a)view0.getLayoutParams()).topMargin + v2;
                }
                default: {
                    return v3 + ((a)view0.getLayoutParams()).topMargin + v2;
                }
            }
        }
        return v3 + ((a)view0.getLayoutParams()).topMargin + v2;
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    public int getGravity() {
        return this.e;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.n;
    }

    int getVirtualChildCount() {
        return this.getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    private void h(int v, int v1) {
        int v2 = View.MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0x40000000);
        for(int v3 = 0; v3 < v; ++v3) {
            View view0 = this.p(v3);
            if(view0.getVisibility() != 8) {
                a y$a0 = (a)view0.getLayoutParams();
                if(y$a0.height == -1) {
                    int v4 = y$a0.width;
                    y$a0.width = view0.getMeasuredWidth();
                    this.measureChildWithMargins(view0, v1, 0, v2, 0);
                    y$a0.width = v4;
                }
            }
        }
    }

    private void i(int v, int v1) {
        int v2 = View.MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0x40000000);
        for(int v3 = 0; v3 < v; ++v3) {
            View view0 = this.p(v3);
            if(view0.getVisibility() != 8) {
                a y$a0 = (a)view0.getLayoutParams();
                if(y$a0.width == -1) {
                    int v4 = y$a0.height;
                    y$a0.height = view0.getMeasuredHeight();
                    this.measureChildWithMargins(view0, v2, 0, v1, 0);
                    y$a0.height = v4;
                }
            }
        }
    }

    protected a j() {
        int v = this.d;
        if(v == 0) {
            return new a(-2, -2);
        }
        return v == 1 ? new a(-1, -2) : null;
    }

    public a k(AttributeSet attributeSet0) {
        return new a(this.getContext(), attributeSet0);
    }

    protected a l(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return new a(viewGroup$LayoutParams0);
    }

    int m(View view0, int v) [...] // Inlined contents

    int n(View view0) [...] // Inlined contents

    int o(View view0) [...] // Inlined contents

    @Override  // android.view.View
    protected void onDraw(Canvas canvas0) {
        if(this.k == null) {
            return;
        }
        if(this.d == 1) {
            this.e(canvas0);
            return;
        }
        this.d(canvas0);
    }

    @Override  // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(accessibilityEvent0);
        accessibilityEvent0.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override  // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override  // android.view.ViewGroup
    protected void onLayout(boolean z, int v, int v1, int v2, int v3) {
        if(this.d == 1) {
            this.s(v, v1, v2, v3);
            return;
        }
        this.r(v, v1, v2, v3);
    }

    @Override  // android.view.View
    protected void onMeasure(int v, int v1) {
        if(this.d == 1) {
            this.w(v, v1);
            return;
        }
        this.u(v, v1);
    }

    View p(int v) {
        return this.getChildAt(v);
    }

    protected boolean q(int v) {
        if(v == 0) {
            return (this.n & 1) != 0;
        }
        if(v == this.getChildCount()) {
            return (this.n & 4) != 0;
        }
        if((this.n & 2) != 0) {
            for(int v1 = v - 1; v1 >= 0; --v1) {
                if(this.getChildAt(v1).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    void r(int v, int v1, int v2, int v3) {
        int v18;
        int v12;
        int v11;
        int v10;
        boolean z = v0.a(this);
        int v4 = this.getPaddingTop();
        int v5 = v3 - v1;
        int v6 = this.getPaddingBottom();
        int v7 = this.getPaddingBottom();
        int v8 = this.getVirtualChildCount();
        int v9 = this.e & 0x70;
        boolean z1 = this.a;
        int[] arr_v = this.i;
        int[] arr_v1 = this.j;
        switch(e.a(0x800007 & this.e, v.o(this))) {
            case 1: {
                v10 = this.getPaddingLeft() + (v2 - v - this.f) / 2;
                break;
            }
            case 5: {
                v10 = this.getPaddingLeft() + v2 - v - this.f;
                break;
            }
            default: {
                v10 = this.getPaddingLeft();
            }
        }
        if(z) {
            v11 = v8 - 1;
            v12 = -1;
        }
        else {
            v11 = 0;
            v12 = 1;
        }
        for(int v13 = 0; v13 < v8; ++v13) {
            int v14 = v11 + v12 * v13;
            View view0 = this.p(v14);
            if(view0 != null && view0.getVisibility() != 8) {
                int v15 = view0.getMeasuredWidth();
                int v16 = view0.getMeasuredHeight();
                a y$a0 = (a)view0.getLayoutParams();
                int v17 = !z1 || y$a0.height == -1 ? -1 : view0.getBaseline();
                switch((y$a0.gravity >= 0 ? y$a0.gravity : v9) & 0x70) {
                    case 16: {
                        v18 = (v5 - v4 - v7 - v16) / 2 + v4 + y$a0.topMargin - y$a0.bottomMargin;
                        break;
                    }
                    case 0x30: {
                        v18 = y$a0.topMargin + v4;
                        if(v17 != -1) {
                            v18 += arr_v[1] - v17;
                        }
                        break;
                    }
                    case 80: {
                        v18 = v5 - v6 - v16 - y$a0.bottomMargin;
                        if(v17 != -1) {
                            int v19 = view0.getMeasuredHeight();
                            v18 -= arr_v1[2] - (v19 - v17);
                        }
                        break;
                    }
                    default: {
                        v18 = v4;
                    }
                }
                if(this.q(v14)) {
                    v10 += this.l;
                }
                int v20 = y$a0.leftMargin + v10;
                this.x(view0, v20, v18, v15, v16);
                v10 = v20 + (v15 + y$a0.rightMargin);
            }
        }
    }

    void s(int v, int v1, int v2, int v3) {
        int v14;
        int v10;
        int v4 = this.getPaddingLeft();
        int v5 = v2 - v;
        int v6 = this.getPaddingRight();
        int v7 = this.getPaddingRight();
        int v8 = this.getVirtualChildCount();
        int v9 = this.e & 0x800007;
        switch(this.e & 0x70) {
            case 16: {
                v10 = this.getPaddingTop() + (v3 - v1 - this.f) / 2;
                break;
            }
            case 80: {
                v10 = this.getPaddingTop() + v3 - v1 - this.f;
                break;
            }
            default: {
                v10 = this.getPaddingTop();
            }
        }
        for(int v11 = 0; v11 < v8; ++v11) {
            View view0 = this.p(v11);
            if(view0 != null && view0.getVisibility() != 8) {
                int v12 = view0.getMeasuredWidth();
                int v13 = view0.getMeasuredHeight();
                a y$a0 = (a)view0.getLayoutParams();
                switch(e.a((y$a0.gravity >= 0 ? y$a0.gravity : v9), v.o(this)) & 7) {
                    case 1: {
                        v14 = (v5 - v4 - v7 - v12) / 2 + v4 + y$a0.leftMargin - y$a0.rightMargin;
                        break;
                    }
                    case 5: {
                        v14 = v5 - v6 - v12 - y$a0.rightMargin;
                        break;
                    }
                    default: {
                        v14 = y$a0.leftMargin + v4;
                    }
                }
                if(this.q(v11)) {
                    v10 += this.m;
                }
                int v15 = v10 + y$a0.topMargin;
                this.x(view0, v14, v15, v12, v13);
                v10 = v15 + (v13 + y$a0.bottomMargin);
            }
        }
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setBaselineAlignedChildIndex(int v) {
        if(v < 0 || v >= this.getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + this.getChildCount() + ")");
        }
        this.b = v;
    }

    public void setDividerDrawable(Drawable drawable0) {
        if(drawable0 == this.k) {
            return;
        }
        this.k = drawable0;
        boolean z = false;
        if(drawable0 == null) {
            this.l = 0;
            this.m = 0;
        }
        else {
            this.l = drawable0.getIntrinsicWidth();
            this.m = drawable0.getIntrinsicHeight();
        }
        if(drawable0 == null) {
            z = true;
        }
        this.setWillNotDraw(z);
        this.requestLayout();
    }

    public void setDividerPadding(int v) {
        this.o = v;
    }

    public void setGravity(int v) {
        if(this.e != v) {
            if((0x800007 & v) == 0) {
                v |= 0x800003;
            }
            if((v & 0x70) == 0) {
                v |= 0x30;
            }
            this.e = v;
            this.requestLayout();
        }
    }

    public void setHorizontalGravity(int v) {
        int v1 = this.e;
        if((0x800007 & v1) != (v & 0x800007)) {
            this.e = v & 0x800007 | 0xFF7FFFF8 & v1;
            this.requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    public void setOrientation(int v) {
        if(this.d != v) {
            this.d = v;
            this.requestLayout();
        }
    }

    public void setShowDividers(int v) {
        if(v != this.n) {
            this.requestLayout();
        }
        this.n = v;
    }

    public void setVerticalGravity(int v) {
        int v1 = this.e;
        if((v1 & 0x70) != (v & 0x70)) {
            this.e = v & 0x70 | v1 & 0xFFFFFF8F;
            this.requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.g = Math.max(0.0f, f);
    }

    @Override  // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    void t(View view0, int v, int v1, int v2, int v3, int v4) {
        this.measureChildWithMargins(view0, v1, v2, v3, v4);
    }

    void u(int v, int v1) {
        int v33;
        int v32;
        int v30;
        float f5;
        int v43;
        int v40;
        int v26;
        int v23;
        int v22;
        int v20;
        boolean z6;
        View view1;
        boolean z5;
        boolean z4;
        int v12;
        int v15;
        int v13;
        this.f = 0;
        int v2 = this.getVirtualChildCount();
        int v3 = View.MeasureSpec.getMode(v);
        int v4 = View.MeasureSpec.getMode(v1);
        if(this.i == null || this.j == null) {
            this.i = new int[4];
            this.j = new int[4];
        }
        int[] arr_v = this.i;
        int[] arr_v1 = this.j;
        arr_v[3] = -1;
        arr_v[2] = -1;
        arr_v[1] = -1;
        arr_v[0] = -1;
        arr_v1[3] = -1;
        arr_v1[2] = -1;
        arr_v1[1] = -1;
        arr_v1[0] = -1;
        boolean z = this.a;
        boolean z1 = this.h;
        int v5 = 0;
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        int v9 = 0;
        boolean z2 = false;
        int v10 = 0;
        boolean z3 = false;
        int v11 = 1;
        float f = 0.0f;
        while(v5 < v2) {
            View view0 = this.p(v5);
            if(view0 == null) {
                this.f = this.f;
            }
            else if(view0.getVisibility() != 8) {
                if(this.q(v5)) {
                    this.f += this.l;
                }
                a y$a0 = (a)view0.getLayoutParams();
                float f1 = y$a0.weight;
                float f2 = f + f1;
                if(v3 != 0x40000000 || y$a0.width != 0 || f1 <= 0.0f) {
                    if(y$a0.width != 0 || f1 <= 0.0f) {
                        v13 = 0x80000000;
                    }
                    else {
                        y$a0.width = -2;
                        v13 = 0;
                    }
                    v12 = v5;
                    z4 = z1;
                    z5 = z;
                    this.t(view0, v12, v, (f2 == 0.0f ? this.f : 0), v1, 0);
                    if(v13 != 0x80000000) {
                        y$a0.width = v13;
                    }
                    int v14 = view0.getMeasuredWidth();
                    if(v3 == 0x40000000) {
                        view1 = view0;
                        v15 = this.f + (y$a0.leftMargin + v14 + y$a0.rightMargin);
                    }
                    else {
                        view1 = view0;
                        v15 = Math.max(this.f, this.f + v14 + y$a0.leftMargin + y$a0.rightMargin);
                    }
                    this.f = v15;
                    if(z4) {
                        v6 = Math.max(v14, v6);
                    }
                }
                else {
                    this.f = v3 == 0x40000000 ? Math.max(this.f, y$a0.leftMargin + this.f + y$a0.rightMargin) : this.f + (y$a0.leftMargin + y$a0.rightMargin);
                    if(z) {
                        view0.measure(0, 0);
                        v12 = v5;
                        z4 = z1;
                        z5 = true;
                        view1 = view0;
                    }
                    else {
                        v12 = v5;
                        z4 = z1;
                        z5 = false;
                        view1 = view0;
                        z2 = true;
                    }
                }
                if(v4 == 0x40000000 || y$a0.height != -1) {
                    z6 = false;
                }
                else {
                    z6 = true;
                    z3 = true;
                }
                int v16 = y$a0.topMargin + y$a0.bottomMargin;
                int v17 = view1.getMeasuredHeight() + v16;
                v10 = View.combineMeasuredStates(v10, view1.getMeasuredState());
                if(z5) {
                    int v18 = view1.getBaseline();
                    if(v18 != -1) {
                        int v19 = (((y$a0.gravity >= 0 ? y$a0.gravity : this.e) & 0x70) >> 4 & -2) >> 1;
                        arr_v[v19] = Math.max(arr_v[v19], v18);
                        arr_v1[v19] = Math.max(arr_v1[v19], v17 - v18);
                    }
                }
                v7 = Math.max(v7, v17);
                v11 = v11 == 0 || y$a0.height != -1 ? 0 : 1;
                if(y$a0.weight > 0.0f) {
                    if(!z6) {
                        v16 = v17;
                    }
                    v9 = Math.max(v9, v16);
                }
                else {
                    if(!z6) {
                        v16 = v17;
                    }
                    v8 = Math.max(v8, v16);
                }
                v20 = v12;
                f = f2;
                goto label_106;
            }
            z4 = z1;
            z5 = z;
            v20 = v5;
        label_106:
            z1 = z4;
            z = z5;
            v5 = v20 + 1;
        }
        if(this.f > 0 && this.q(v2)) {
            this.f += this.l;
        }
        int v21 = arr_v[1];
        if(v21 != -1 || arr_v[0] != -1 || arr_v[2] != -1 || arr_v[3] != -1) {
            v23 = v10;
            v22 = Math.max(v7, Math.max(arr_v[3], Math.max(arr_v[0], Math.max(v21, arr_v[2]))) + Math.max(arr_v1[3], Math.max(arr_v1[0], Math.max(arr_v1[1], arr_v1[2]))));
        }
        else {
            v22 = v7;
            v23 = v10;
        }
        if(z1 && (v3 == 0x80000000 || v3 == 0)) {
            this.f = 0;
            int v24 = 0;
            while(v24 < v2) {
                View view2 = this.p(v24);
                if(view2 == null) {
                    this.f = this.f;
                }
                else if(view2.getVisibility() != 8) {
                    a y$a1 = (a)view2.getLayoutParams();
                    int v25 = this.f;
                    if(v3 == 0x40000000) {
                        this.f = v25 + (y$a1.leftMargin + v6 + y$a1.rightMargin);
                        v26 = v22;
                    }
                    else {
                        v26 = v22;
                        this.f = Math.max(v25, v25 + v6 + y$a1.leftMargin + y$a1.rightMargin);
                    }
                    goto label_138;
                }
                v26 = v22;
            label_138:
                ++v24;
                v22 = v26;
            }
        }
        int v27 = this.f + (this.getPaddingLeft() + this.getPaddingRight());
        this.f = v27;
        int v28 = View.resolveSizeAndState(Math.max(v27, this.getSuggestedMinimumWidth()), v, 0);
        int v29 = (0xFFFFFF & v28) - this.f;
        if(z2 || v29 != 0 && f > 0.0f) {
            float f3 = this.g;
            if(f3 > 0.0f) {
                f = f3;
            }
            arr_v[3] = -1;
            arr_v[2] = -1;
            arr_v[1] = -1;
            arr_v[0] = -1;
            arr_v1[3] = -1;
            arr_v1[2] = -1;
            arr_v1[1] = -1;
            arr_v1[0] = -1;
            this.f = 0;
            int v34 = v8;
            int v35 = -1;
            int v36 = v23;
            int v37 = 0;
            while(v37 < v2) {
                View view4 = this.p(v37);
                if(view4 == null || view4.getVisibility() == 8) {
                    v43 = v29;
                    v40 = v2;
                }
                else {
                    a y$a2 = (a)view4.getLayoutParams();
                    float f4 = y$a2.weight;
                    if(f4 > 0.0f) {
                        int v38 = (int)(((float)v29) * f4 / f);
                        int v39 = v29 - v38;
                        v40 = v2;
                        int v41 = ViewGroup.getChildMeasureSpec(v1, this.getPaddingTop() + this.getPaddingBottom() + y$a2.topMargin + y$a2.bottomMargin, y$a2.height);
                        if(y$a2.width != 0 || v3 != 0x40000000) {
                            int v42 = view4.getMeasuredWidth() + v38;
                            if(v42 >= 0) {
                                v38 = v42;
                            }
                        }
                        else if(v38 > 0) {
                        }
                        else {
                            v38 = 0;
                        }
                        view4.measure(View.MeasureSpec.makeMeasureSpec(v38, 0x40000000), v41);
                        v36 = View.combineMeasuredStates(v36, view4.getMeasuredState() & 0xFF000000);
                        f -= f4;
                        v43 = v39;
                    }
                    else {
                        v43 = v29;
                        v40 = v2;
                    }
                    int v44 = this.f;
                    if(v3 == 0x40000000) {
                        this.f = v44 + (view4.getMeasuredWidth() + y$a2.leftMargin + y$a2.rightMargin);
                        f5 = f;
                    }
                    else {
                        f5 = f;
                        this.f = Math.max(v44, view4.getMeasuredWidth() + v44 + y$a2.leftMargin + y$a2.rightMargin);
                    }
                    boolean z7 = v4 != 0x40000000 && y$a2.height == -1;
                    int v45 = y$a2.topMargin + y$a2.bottomMargin;
                    int v46 = view4.getMeasuredHeight() + v45;
                    v35 = Math.max(v35, v46);
                    if(!z7) {
                        v45 = v46;
                    }
                    int v47 = Math.max(v34, v45);
                    int v48 = v11 == 0 || y$a2.height != -1 ? 0 : 1;
                    if(z) {
                        int v49 = view4.getBaseline();
                        if(v49 != -1) {
                            int v50 = (((y$a2.gravity >= 0 ? y$a2.gravity : this.e) & 0x70) >> 4 & -2) >> 1;
                            arr_v[v50] = Math.max(arr_v[v50], v49);
                            arr_v1[v50] = Math.max(arr_v1[v50], v46 - v49);
                        }
                    }
                    v11 = v48;
                    v34 = v47;
                    f = f5;
                }
                ++v37;
                v29 = v43;
                v2 = v40;
            }
            v32 = v2;
            this.f += this.getPaddingLeft() + this.getPaddingRight();
            int v51 = arr_v[1];
            v33 = v51 != -1 || arr_v[0] != -1 || arr_v[2] != -1 || arr_v[3] != -1 ? Math.max(v35, Math.max(arr_v[3], Math.max(arr_v[0], Math.max(v51, arr_v[2]))) + Math.max(arr_v1[3], Math.max(arr_v1[0], Math.max(arr_v1[1], arr_v1[2])))) : v35;
            v30 = v34;
            v23 = v36;
        }
        else {
            v30 = Math.max(v8, v9);
            if(z1 && v3 != 0x40000000) {
                for(int v31 = 0; v31 < v2; ++v31) {
                    View view3 = this.p(v31);
                    if(view3 != null && view3.getVisibility() != 8 && ((a)view3.getLayoutParams()).weight > 0.0f) {
                        view3.measure(View.MeasureSpec.makeMeasureSpec(v6, 0x40000000), View.MeasureSpec.makeMeasureSpec(view3.getMeasuredHeight(), 0x40000000));
                    }
                }
            }
            v32 = v2;
            v33 = v22;
        }
        if(v11 != 0 || v4 == 0x40000000) {
            v30 = v33;
        }
        this.setMeasuredDimension(v28 | v23 & 0xFF000000, View.resolveSizeAndState(Math.max(v30 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight()), v1, v23 << 16));
        if(z3) {
            this.h(v32, v);
        }
    }

    int v(int v) [...] // Inlined contents

    void w(int v, int v1) {
        int v35;
        int v33;
        boolean z4;
        int v45;
        int v39;
        int v28;
        int v26;
        boolean z3;
        int v19;
        int v18;
        int v17;
        int v16;
        int v15;
        View view1;
        int v14;
        int v20;
        int v13;
        this.f = 0;
        int v2 = this.getVirtualChildCount();
        int v3 = View.MeasureSpec.getMode(v);
        int v4 = View.MeasureSpec.getMode(v1);
        int v5 = this.b;
        boolean z = this.h;
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        int v9 = 0;
        int v10 = 0;
        int v11 = 0;
        boolean z1 = false;
        boolean z2 = false;
        int v12 = 1;
        float f = 0.0f;
        while(v11 < v2) {
            View view0 = this.p(v11);
            if(view0 == null) {
                this.f = this.f;
                v13 = v2;
            }
            else if(view0.getVisibility() == 8) {
                v13 = v2;
            }
            else {
                if(this.q(v11)) {
                    this.f += this.m;
                }
                a y$a0 = (a)view0.getLayoutParams();
                float f1 = y$a0.weight;
                float f2 = f + f1;
                if(v4 != 0x40000000 || y$a0.height != 0 || f1 <= 0.0f) {
                    if(y$a0.height != 0 || f1 <= 0.0f) {
                        v20 = 0x80000000;
                    }
                    else {
                        y$a0.height = -2;
                        v20 = 0;
                    }
                    v16 = v6;
                    v17 = v7;
                    v13 = v2;
                    v18 = v9;
                    v15 = v10;
                    v19 = v11;
                    this.t(view0, v11, v, 0, v1, (f2 == 0.0f ? this.f : 0));
                    if(v20 != 0x80000000) {
                        y$a0.height = v20;
                    }
                    int v21 = view0.getMeasuredHeight();
                    view1 = view0;
                    this.f = Math.max(this.f, this.f + v21 + y$a0.topMargin + y$a0.bottomMargin);
                    v14 = z ? Math.max(v21, v8) : v8;
                }
                else {
                    this.f = Math.max(this.f, y$a0.topMargin + this.f + y$a0.bottomMargin);
                    v14 = v8;
                    view1 = view0;
                    v15 = v10;
                    z1 = true;
                    v16 = v6;
                    v17 = v7;
                    v13 = v2;
                    v18 = v9;
                    v19 = v11;
                }
                if(v5 >= 0 && v5 == v19 + 1) {
                    this.c = this.f;
                }
                if(v19 < v5 && y$a0.weight > 0.0f) {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won\'t work.  Either remove the weight, or don\'t set mBaselineAlignedChildIndex.");
                }
                if(v3 == 0x40000000 || y$a0.width != -1) {
                    z3 = false;
                }
                else {
                    z3 = true;
                    z2 = true;
                }
                int v22 = y$a0.leftMargin + y$a0.rightMargin;
                int v23 = view1.getMeasuredWidth() + v22;
                int v24 = Math.max(v17, v23);
                int v25 = View.combineMeasuredStates(v16, view1.getMeasuredState());
                v12 = v12 == 0 || y$a0.width != -1 ? 0 : 1;
                if(y$a0.weight > 0.0f) {
                    if(!z3) {
                        v22 = v23;
                    }
                    v9 = Math.max(v18, v22);
                    v26 = v15;
                }
                else {
                    if(!z3) {
                        v22 = v23;
                    }
                    v26 = Math.max(v15, v22);
                    v9 = v18;
                }
                v8 = v14;
                f = f2;
                v10 = v26;
                v6 = v25;
                v11 = v19;
                v7 = v24;
            }
            ++v11;
            v2 = v13;
        }
        int v27 = v7;
        if(this.f > 0) {
            v28 = v2;
            if(this.q(v28)) {
                this.f += this.m;
            }
        }
        else {
            v28 = v2;
        }
        if(z && (v4 == 0x80000000 || v4 == 0)) {
            this.f = 0;
            for(int v29 = 0; v29 < v28; ++v29) {
                View view2 = this.p(v29);
                if(view2 == null) {
                    this.f = this.f;
                }
                else if(view2.getVisibility() != 8) {
                    a y$a1 = (a)view2.getLayoutParams();
                    this.f = Math.max(this.f, this.f + v8 + y$a1.topMargin + y$a1.bottomMargin);
                }
            }
        }
        int v30 = this.f + (this.getPaddingTop() + this.getPaddingBottom());
        this.f = v30;
        int v31 = View.resolveSizeAndState(Math.max(v30, this.getSuggestedMinimumHeight()), v1, 0);
        int v32 = (0xFFFFFF & v31) - this.f;
        if(z1 || v32 != 0 && f > 0.0f) {
            float f3 = this.g;
            if(f3 > 0.0f) {
                f = f3;
            }
            this.f = 0;
            int v36 = v32;
            int v37 = v10;
            v35 = v6;
            int v38 = 0;
            while(v38 < v28) {
                View view4 = this.p(v38);
                if(view4.getVisibility() == 8) {
                    v39 = v36;
                }
                else {
                    a y$a2 = (a)view4.getLayoutParams();
                    float f4 = y$a2.weight;
                    if(f4 > 0.0f) {
                        int v40 = (int)(((float)v36) * f4 / f);
                        v39 = v36 - v40;
                        int v41 = ViewGroup.getChildMeasureSpec(v, this.getPaddingLeft() + this.getPaddingRight() + y$a2.leftMargin + y$a2.rightMargin, y$a2.width);
                        if(y$a2.height != 0 || v4 != 0x40000000) {
                            int v42 = view4.getMeasuredHeight() + v40;
                            if(v42 >= 0) {
                                v40 = v42;
                            }
                        }
                        else if(v40 > 0) {
                        }
                        else {
                            v40 = 0;
                        }
                        view4.measure(v41, View.MeasureSpec.makeMeasureSpec(v40, 0x40000000));
                        v35 = View.combineMeasuredStates(v35, view4.getMeasuredState() & 0xFFFFFF00);
                        f -= f4;
                    }
                    else {
                        v39 = v36;
                    }
                    int v43 = y$a2.leftMargin + y$a2.rightMargin;
                    int v44 = view4.getMeasuredWidth() + v43;
                    v27 = Math.max(v27, v44);
                    if(v3 == 0x40000000) {
                        v45 = v35;
                    }
                    else {
                        v45 = v35;
                        if(y$a2.width == -1) {
                            z4 = true;
                            goto label_171;
                        }
                    }
                    z4 = false;
                label_171:
                    if(!z4) {
                        v43 = v44;
                    }
                    int v46 = v12 == 0 || y$a2.width != -1 ? 0 : 1;
                    int v47 = this.f;
                    this.f = Math.max(v47, view4.getMeasuredHeight() + v47 + y$a2.topMargin + y$a2.bottomMargin);
                    v12 = v46;
                    v35 = v45;
                    v37 = Math.max(v37, v43);
                }
                ++v38;
                v36 = v39;
            }
            this.f += this.getPaddingTop() + this.getPaddingBottom();
            v33 = v37;
        }
        else {
            v33 = Math.max(v10, v9);
            if(z && v4 != 0x40000000) {
                for(int v34 = 0; v34 < v28; ++v34) {
                    View view3 = this.p(v34);
                    if(view3 != null && view3.getVisibility() != 8 && ((a)view3.getLayoutParams()).weight > 0.0f) {
                        view3.measure(View.MeasureSpec.makeMeasureSpec(view3.getMeasuredWidth(), 0x40000000), View.MeasureSpec.makeMeasureSpec(v8, 0x40000000));
                    }
                }
            }
            v35 = v6;
        }
        if(v12 != 0 || v3 == 0x40000000) {
            v33 = v27;
        }
        this.setMeasuredDimension(View.resolveSizeAndState(Math.max(v33 + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), v, v35), v31);
        if(z2) {
            this.i(v28, v1);
        }
    }

    private void x(View view0, int v, int v1, int v2, int v3) {
        view0.layout(v, v1, v2 + v, v3 + v1);
    }
}

