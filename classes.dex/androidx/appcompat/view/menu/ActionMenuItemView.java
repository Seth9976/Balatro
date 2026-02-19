package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View;
import androidx.appcompat.widget.p0;
import androidx.appcompat.widget.p;
import androidx.appcompat.widget.x;
import c.i;

public class ActionMenuItemView extends p implements View.OnClickListener, a, androidx.appcompat.widget.ActionMenuView.a {
    class androidx.appcompat.view.menu.ActionMenuItemView.a extends x {
        final ActionMenuItemView j;

        @Override  // androidx.appcompat.widget.x
        public k b() {
            b actionMenuItemView$b0 = ActionMenuItemView.this.m;
            return actionMenuItemView$b0 == null ? null : actionMenuItemView$b0.a();
        }

        @Override  // androidx.appcompat.widget.x
        protected boolean c() {
            androidx.appcompat.view.menu.e.b e$b0 = ActionMenuItemView.this.k;
            if(e$b0 != null && e$b0.a(ActionMenuItemView.this.h)) {
                k k0 = this.b();
                return k0 != null && k0.f();
            }
            return false;
        }
    }

    public static abstract class b {
        public abstract k a();
    }

    f h;
    private CharSequence i;
    private Drawable j;
    androidx.appcompat.view.menu.e.b k;
    private x l;
    b m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;

    public ActionMenuItemView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public ActionMenuItemView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        Resources resources0 = context0.getResources();
        this.n = this.s();
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, i.t, v, 0);
        this.p = typedArray0.getDimensionPixelSize(i.u, 0);
        typedArray0.recycle();
        this.r = (int)(resources0.getDisplayMetrics().density * 32.0f + 0.5f);
        this.setOnClickListener(this);
        this.q = -1;
        this.setSaveEnabled(false);
    }

    @Override  // androidx.appcompat.widget.ActionMenuView$a
    public boolean a() {
        return this.r();
    }

    @Override  // androidx.appcompat.widget.ActionMenuView$a
    public boolean b() {
        return this.r() && this.h.getIcon() == null;
    }

    @Override  // androidx.appcompat.view.menu.j$a
    public boolean c() {
        return true;
    }

    @Override  // androidx.appcompat.view.menu.j$a
    public void d(f f0, int v) {
        this.h = f0;
        this.setIcon(f0.getIcon());
        this.setTitle(f0.h(this));
        this.setId(f0.getItemId());
        this.setVisibility((f0.isVisible() ? 0 : 8));
        this.setEnabled(f0.isEnabled());
        if(f0.hasSubMenu() && this.l == null) {
            this.l = new androidx.appcompat.view.menu.ActionMenuItemView.a(this);
        }
    }

    // 去混淆评级： 低(20)
    @Override  // android.widget.TextView
    public CharSequence getAccessibilityClassName() {
        return "android.widget.Button";
    }

    @Override  // androidx.appcompat.view.menu.j$a
    public f getItemData() {
        return this.h;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        androidx.appcompat.view.menu.e.b e$b0 = this.k;
        if(e$b0 != null) {
            e$b0.a(this.h);
        }
    }

    @Override  // android.widget.TextView
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        this.n = this.s();
        this.t();
    }

    @Override  // androidx.appcompat.widget.p
    protected void onMeasure(int v, int v1) {
        boolean z = this.r();
        if(z) {
            int v2 = this.q;
            if(v2 >= 0) {
                super.setPadding(v2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
            }
        }
        super.onMeasure(v, v1);
        int v3 = View.MeasureSpec.getMode(v);
        int v4 = View.MeasureSpec.getSize(v);
        int v5 = this.getMeasuredWidth();
        int v6 = v3 == 0x80000000 ? Math.min(v4, this.p) : this.p;
        if(v3 != 0x40000000 && this.p > 0 && v5 < v6) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(v6, 0x40000000), v1);
        }
        if(!z && this.j != null) {
            super.setPadding((this.getMeasuredWidth() - this.j.getBounds().width()) / 2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }
    }

    @Override  // android.widget.TextView
    public void onRestoreInstanceState(Parcelable parcelable0) {
        super.onRestoreInstanceState(null);
    }

    // 去混淆评级： 低(20)
    @Override  // android.widget.TextView
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        return !this.h.hasSubMenu() || (this.l == null || !this.l.onTouch(this, motionEvent0)) ? super.onTouchEvent(motionEvent0) : true;
    }

    public boolean r() {
        return !TextUtils.isEmpty(this.getText());
    }

    private boolean s() {
        Configuration configuration0 = this.getContext().getResources().getConfiguration();
        return configuration0.screenWidthDp >= 480 || configuration0.screenWidthDp >= 640 && configuration0.screenHeightDp >= 480 || configuration0.orientation == 2;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if(this.o != z) {
            this.o = z;
            f f0 = this.h;
            if(f0 != null) {
                f0.a();
            }
        }
    }

    public void setIcon(Drawable drawable0) {
        this.j = drawable0;
        if(drawable0 != null) {
            int v = drawable0.getIntrinsicWidth();
            int v1 = drawable0.getIntrinsicHeight();
            int v2 = this.r;
            if(v > v2) {
                v1 = (int)(((float)v1) * (((float)v2) / ((float)v)));
                v = v2;
            }
            if(v1 > v2) {
                v = (int)(((float)v) * (((float)v2) / ((float)v1)));
            }
            else {
                v2 = v1;
            }
            drawable0.setBounds(0, 0, v, v2);
        }
        this.setCompoundDrawables(drawable0, null, null, null);
        this.t();
    }

    public void setItemInvoker(androidx.appcompat.view.menu.e.b e$b0) {
        this.k = e$b0;
    }

    @Override  // android.widget.TextView
    public void setPadding(int v, int v1, int v2, int v3) {
        this.q = v;
        super.setPadding(v, v1, v2, v3);
    }

    public void setPopupCallback(b actionMenuItemView$b0) {
        this.m = actionMenuItemView$b0;
    }

    public void setTitle(CharSequence charSequence0) {
        this.i = charSequence0;
        this.t();
    }

    private void t() {
        int v = !TextUtils.isEmpty(this.i) & (this.j == null || this.h.A() && (this.n || this.o) ? 1 : 0);
        CharSequence charSequence0 = null;
        this.setText((v == 0 ? null : this.i));
        CharSequence charSequence1 = this.h.getContentDescription();
        if(TextUtils.isEmpty(charSequence1)) {
            charSequence1 = v == 0 ? this.h.getTitle() : null;
        }
        this.setContentDescription(charSequence1);
        CharSequence charSequence2 = this.h.getTooltipText();
        if(TextUtils.isEmpty(charSequence2)) {
            if(v == 0) {
                charSequence0 = this.h.getTitle();
            }
            p0.a(this, charSequence0);
            return;
        }
        p0.a(this, charSequence2);
    }
}

