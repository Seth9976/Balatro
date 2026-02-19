package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.v;
import c.e;
import c.f;
import c.i;

public class ActionBarContextView extends a {
    private CharSequence h;
    private CharSequence i;
    private View j;
    private View k;
    private LinearLayout l;
    private TextView m;
    private TextView n;
    private int o;
    private int p;
    private boolean q;
    private int r;

    public ActionBarContextView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, c.a.d);
    }

    public ActionBarContextView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        l0 l00 = l0.s(context0, attributeSet0, i.w, v, 0);
        v.J(this, l00.f(i.x));
        this.o = l00.l(i.B, 0);
        this.p = l00.l(i.A, 0);
        this.e = l00.k(i.z, 0);
        this.r = l00.l(i.y, f.d);
        l00.t();
    }

    private void d() {
        if(this.l == null) {
            LayoutInflater.from(this.getContext()).inflate(f.a, this);
            LinearLayout linearLayout0 = (LinearLayout)this.getChildAt(this.getChildCount() - 1);
            this.l = linearLayout0;
            this.m = (TextView)linearLayout0.findViewById(e.e);
            this.n = (TextView)this.l.findViewById(e.d);
            if(this.o != 0) {
                this.m.setTextAppearance(this.getContext(), this.o);
            }
            if(this.p != 0) {
                this.n.setTextAppearance(this.getContext(), this.p);
            }
        }
        this.m.setText(this.h);
        this.n.setText(this.i);
        boolean z = TextUtils.isEmpty(this.h);
        boolean z1 = TextUtils.isEmpty(this.i);
        int v = 0;
        this.n.setVisibility((!z1 == 0 ? 8 : 0));
        LinearLayout linearLayout1 = this.l;
        if(!z == 0 && !z1 == 0) {
            v = 8;
        }
        linearLayout1.setVisibility(v);
        if(this.l.getParent() == null) {
            this.addView(this.l);
        }
    }

    @Override  // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new ViewGroup.MarginLayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // androidx.appcompat.widget.a
    public int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override  // androidx.appcompat.widget.a
    public int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.i;
    }

    public CharSequence getTitle() {
        return this.h;
    }

    @Override  // android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c c0 = this.d;
        if(c0 != null) {
            c0.z();
            this.d.A();
        }
    }

    @Override  // androidx.appcompat.widget.a
    public boolean onHoverEvent(MotionEvent motionEvent0) {
        return super.onHoverEvent(motionEvent0);
    }

    @Override  // android.view.ViewGroup
    protected void onLayout(boolean z, int v, int v1, int v2, int v3) {
        boolean z1 = v0.a(this);
        int v4 = z1 ? v2 - v - this.getPaddingRight() : this.getPaddingLeft();
        int v5 = this.getPaddingTop();
        int v6 = v3 - v1 - this.getPaddingTop() - this.getPaddingBottom();
        if(this.j != null && this.j.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)this.j.getLayoutParams();
            int v7 = z1 ? viewGroup$MarginLayoutParams0.leftMargin : viewGroup$MarginLayoutParams0.rightMargin;
            int v8 = a.b(v4, (z1 ? viewGroup$MarginLayoutParams0.rightMargin : viewGroup$MarginLayoutParams0.leftMargin), z1);
            v4 = a.b(v8 + this.c(this.j, v8, v5, v6, z1), v7, z1);
        }
        int v9 = this.l == null || this.k != null || this.l.getVisibility() == 8 ? v4 : v4 + this.c(this.l, v4, v5, v6, z1);
        View view0 = this.k;
        if(view0 != null) {
            this.c(view0, v9, v5, v6, z1);
        }
        int v10 = z1 ? this.getPaddingLeft() : v2 - v - this.getPaddingRight();
        ActionMenuView actionMenuView0 = this.c;
        if(actionMenuView0 != null) {
            this.c(actionMenuView0, v10, v5, v6, !z1);
        }
    }

    @Override  // android.view.View
    protected void onMeasure(int v, int v1) {
        int v2 = 0x40000000;
        if(View.MeasureSpec.getMode(v) != 0x40000000) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if(View.MeasureSpec.getMode(v1) == 0) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int v3 = View.MeasureSpec.getSize(v);
        int v4 = this.e > 0 ? this.e : View.MeasureSpec.getSize(v1);
        int v5 = this.getPaddingTop() + this.getPaddingBottom();
        int v6 = v3 - this.getPaddingLeft() - this.getPaddingRight();
        int v7 = v4 - v5;
        int v8 = View.MeasureSpec.makeMeasureSpec(v7, 0x80000000);
        View view0 = this.j;
        if(view0 != null) {
            int v10 = this.a(view0, v6, v8, 0);
            ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)this.j.getLayoutParams();
            v6 = v10 - (viewGroup$MarginLayoutParams0.leftMargin + viewGroup$MarginLayoutParams0.rightMargin);
        }
        if(this.c != null && this.c.getParent() == this) {
            v6 = this.a(this.c, v6, v8, 0);
        }
        LinearLayout linearLayout0 = this.l;
        if(linearLayout0 != null && this.k == null) {
            if(this.q) {
                this.l.measure(0, v8);
                int v11 = this.l.getMeasuredWidth();
                boolean z = v11 <= v6;
                if(z) {
                    v6 -= v11;
                }
                this.l.setVisibility((z ? 0 : 8));
            }
            else {
                v6 = this.a(linearLayout0, v6, v8, 0);
            }
        }
        View view1 = this.k;
        if(view1 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view1.getLayoutParams();
            int v12 = viewGroup$LayoutParams0.width;
            if(v12 >= 0) {
                v6 = Math.min(v12, v6);
            }
            int v13 = viewGroup$LayoutParams0.height;
            if(v13 == -2) {
                v2 = 0x80000000;
            }
            if(v13 >= 0) {
                v7 = Math.min(v13, v7);
            }
            this.k.measure(View.MeasureSpec.makeMeasureSpec(v6, (v12 == -2 ? 0x80000000 : 0x40000000)), View.MeasureSpec.makeMeasureSpec(v7, v2));
        }
        if(this.e <= 0) {
            int v14 = this.getChildCount();
            int v15 = 0;
            for(int v9 = 0; v9 < v14; ++v9) {
                int v16 = this.getChildAt(v9).getMeasuredHeight() + v5;
                if(v16 > v15) {
                    v15 = v16;
                }
            }
            this.setMeasuredDimension(v3, v15);
            return;
        }
        this.setMeasuredDimension(v3, v4);
    }

    @Override  // androidx.appcompat.widget.a
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        return super.onTouchEvent(motionEvent0);
    }

    @Override  // androidx.appcompat.widget.a
    public void setContentHeight(int v) {
        this.e = v;
    }

    public void setCustomView(View view0) {
        View view1 = this.k;
        if(view1 != null) {
            this.removeView(view1);
        }
        this.k = view0;
        if(view0 != null) {
            LinearLayout linearLayout0 = this.l;
            if(linearLayout0 != null) {
                this.removeView(linearLayout0);
                this.l = null;
            }
        }
        if(view0 != null) {
            this.addView(view0);
        }
        this.requestLayout();
    }

    public void setSubtitle(CharSequence charSequence0) {
        this.i = charSequence0;
        this.d();
    }

    public void setTitle(CharSequence charSequence0) {
        this.h = charSequence0;
        this.d();
        v.I(this, charSequence0);
    }

    public void setTitleOptional(boolean z) {
        if(z != this.q) {
            this.requestLayout();
        }
        this.q = z;
    }

    @Override  // androidx.appcompat.widget.a
    public void setVisibility(int v) {
        super.setVisibility(v);
    }

    @Override  // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

