package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup;
import c.i;

abstract class a extends ViewGroup {
    public class androidx.appcompat.widget.a.a {
        private boolean a;
        final a b;

        protected androidx.appcompat.widget.a.a() {
            this.a = false;
        }
    }

    protected final androidx.appcompat.widget.a.a a;
    protected final Context b;
    protected ActionMenuView c;
    protected c d;
    protected int e;
    private boolean f;
    private boolean g;

    a(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = new androidx.appcompat.widget.a.a(this);
        TypedValue typedValue0 = new TypedValue();
        if(context0.getTheme().resolveAttribute(c.a.a, typedValue0, true) && typedValue0.resourceId != 0) {
            this.b = new ContextThemeWrapper(context0, typedValue0.resourceId);
            return;
        }
        this.b = context0;
    }

    protected int a(View view0, int v, int v1, int v2) {
        view0.measure(View.MeasureSpec.makeMeasureSpec(v, 0x80000000), v1);
        return Math.max(0, v - view0.getMeasuredWidth() - v2);
    }

    // 去混淆评级： 低(20)
    protected static int b(int v, int v1, boolean z) {
        return z ? v - v1 : v + v1;
    }

    protected int c(View view0, int v, int v1, int v2, boolean z) {
        int v3 = view0.getMeasuredWidth();
        int v4 = view0.getMeasuredHeight();
        int v5 = v1 + (v2 - v4) / 2;
        if(z) {
            view0.layout(v - v3, v5, v, v4 + v5);
            return -v3;
        }
        view0.layout(v, v5, v + v3, v4 + v5);
        return v3;
    }

    public int getAnimatedVisibility() {
        return this.getVisibility();
    }

    public int getContentHeight() {
        return this.e;
    }

    @Override  // android.view.View
    protected void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(null, i.a, c.a.c, 0);
        this.setContentHeight(typedArray0.getLayoutDimension(i.i, 0));
        typedArray0.recycle();
        c c0 = this.d;
        if(c0 != null) {
            c0.C(configuration0);
        }
    }

    @Override  // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionMasked();
        if(v == 9) {
            this.g = false;
        }
        if(!this.g && (v == 9 && !super.onHoverEvent(motionEvent0))) {
            this.g = true;
        }
        if(v == 3 || v == 10) {
            this.g = false;
        }
        return true;
    }

    @Override  // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionMasked();
        if(v == 0) {
            this.f = false;
        }
        if(!this.f && (v == 0 && !super.onTouchEvent(motionEvent0))) {
            this.f = true;
        }
        if(v == 1 || v == 3) {
            this.f = false;
        }
        return true;
    }

    public abstract void setContentHeight(int arg1);

    @Override  // android.view.View
    public void setVisibility(int v) {
        if(v != this.getVisibility()) {
            super.setVisibility(v);
        }
    }
}

