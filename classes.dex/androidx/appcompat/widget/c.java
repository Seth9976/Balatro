package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.b;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.m;
import java.util.ArrayList;

class c extends b {
    class a extends h {
        final c m;

        public a(Context context0, m m0, View view0) {
            super(context0, m0, view0, false, c.a.f);
            if(!((f)m0.getItem()).k()) {
                View view1 = c0.j;
                if(view1 == null) {
                    view1 = (View)c0.i;
                }
                this.f(view1);
            }
            this.j(c0.B);
        }

        @Override  // androidx.appcompat.view.menu.h
        protected void e() {
            c.this.y = null;
            c.this.C = 0;
            super.e();
        }
    }

    class androidx.appcompat.widget.c.b extends androidx.appcompat.view.menu.ActionMenuItemView.b {
        final c a;

        @Override  // androidx.appcompat.view.menu.ActionMenuItemView$b
        public k a() {
            a c$a0 = c.this.y;
            return c$a0 != null ? c$a0.c() : null;
        }
    }

    class androidx.appcompat.widget.c.c implements Runnable {
        private e e;
        final c f;

        public androidx.appcompat.widget.c.c(e c$e0) {
            this.e = c$e0;
        }

        @Override
        public void run() {
            if(c.this.c != null) {
                c.this.c.c();
            }
            View view0 = (View)c.this.i;
            if(view0 != null && view0.getWindowToken() != null && this.e.m()) {
                c.this.x = this.e;
            }
            c.this.z = null;
        }
    }

    class d extends l implements androidx.appcompat.widget.ActionMenuView.a {
        final c d;

        public d(Context context0) {
            class androidx.appcompat.widget.c.d.a extends x {
                final c j;
                final d k;

                androidx.appcompat.widget.c.d.a(View view0, c c0) {
                    this.j = c0;
                    super(view0);
                }

                @Override  // androidx.appcompat.widget.x
                public k b() {
                    e c$e0 = c.this.x;
                    return c$e0 == null ? null : c$e0.c();
                }

                @Override  // androidx.appcompat.widget.x
                public boolean c() {
                    c.this.H();
                    return true;
                }

                @Override  // androidx.appcompat.widget.x
                public boolean d() {
                    c c0 = c.this;
                    if(c0.z != null) {
                        return false;
                    }
                    c0.z();
                    return true;
                }
            }

            super(context0, null, c.a.e);
            this.setClickable(true);
            this.setFocusable(true);
            this.setVisibility(0);
            this.setEnabled(true);
            p0.a(this, this.getContentDescription());
            this.setOnTouchListener(new androidx.appcompat.widget.c.d.a(this, this, c0));
        }

        @Override  // androidx.appcompat.widget.ActionMenuView$a
        public boolean a() {
            return false;
        }

        @Override  // androidx.appcompat.widget.ActionMenuView$a
        public boolean b() {
            return false;
        }

        @Override  // android.view.View
        public boolean performClick() {
            if(super.performClick()) {
                return true;
            }
            this.playSoundEffect(0);
            c.this.H();
            return true;
        }

        @Override  // android.widget.ImageView
        protected boolean setFrame(int v, int v1, int v2, int v3) {
            boolean z = super.setFrame(v, v1, v2, v3);
            Drawable drawable0 = this.getDrawable();
            Drawable drawable1 = this.getBackground();
            if(drawable0 != null && drawable1 != null) {
                int v4 = this.getWidth();
                int v5 = this.getHeight();
                int v6 = Math.max(v4, v5);
                int v7 = (v4 + (this.getPaddingLeft() - this.getPaddingRight())) / 2;
                int v8 = (v5 + (this.getPaddingTop() - this.getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.k(drawable1, v7 - v6 / 2, v8 - v6 / 2, v7 + v6 / 2, v8 + v6 / 2);
            }
            return z;
        }
    }

    class e extends h {
        final c m;

        public e(Context context0, androidx.appcompat.view.menu.e e0, View view0, boolean z) {
            super(context0, e0, view0, z, c.a.f);
            this.h(0x800005);
            this.j(c0.B);
        }

        @Override  // androidx.appcompat.view.menu.h
        protected void e() {
            if(c.this.c != null) {
                c.this.c.close();
            }
            c.this.x = null;
            super.e();
        }
    }

    class androidx.appcompat.widget.c.f implements androidx.appcompat.view.menu.i.a {
        final c a;

        @Override  // androidx.appcompat.view.menu.i$a
        public void a(androidx.appcompat.view.menu.e e0, boolean z) {
            if(e0 instanceof m) {
                e0.z().d(false);
            }
            androidx.appcompat.view.menu.i.a i$a0 = c.this.m();
            if(i$a0 != null) {
                i$a0.a(e0, z);
            }
        }

        @Override  // androidx.appcompat.view.menu.i$a
        public boolean b(androidx.appcompat.view.menu.e e0) {
            if(e0 == c.this.c) {
                return false;
            }
            c.this.C = ((m)e0).getItem().getItemId();
            androidx.appcompat.view.menu.i.a i$a0 = c.this.m();
            return i$a0 == null ? false : i$a0.b(e0);
        }
    }

    private androidx.appcompat.widget.c.b A;
    final androidx.appcompat.widget.c.f B;
    int C;
    d j;
    private Drawable k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private final SparseBooleanArray w;
    e x;
    a y;
    androidx.appcompat.widget.c.c z;

    public c(Context context0) {
        super(context0, c.f.c, c.f.b);
        this.w = new SparseBooleanArray();
        this.B = new androidx.appcompat.widget.c.f(this);
    }

    public boolean A() {
        a c$a0 = this.y;
        if(c$a0 != null) {
            c$a0.b();
            return true;
        }
        return false;
    }

    public boolean B() {
        return this.x != null && this.x.d();
    }

    public void C(Configuration configuration0) {
        if(!this.r) {
            this.q = h.a.a(this.b).c();
        }
        androidx.appcompat.view.menu.e e0 = this.c;
        if(e0 != null) {
            e0.G(true);
        }
    }

    public void D(boolean z) {
        this.u = z;
    }

    public void E(ActionMenuView actionMenuView0) {
        this.i = actionMenuView0;
        actionMenuView0.E(this.c);
    }

    public void F(Drawable drawable0) {
        d c$d0 = this.j;
        if(c$d0 != null) {
            c$d0.setImageDrawable(drawable0);
            return;
        }
        this.l = true;
        this.k = drawable0;
    }

    public void G(boolean z) {
        this.m = z;
        this.n = true;
    }

    public boolean H() {
        if(this.m && !this.B() && (this.c != null && this.i != null && this.z == null && !this.c.v().isEmpty())) {
            androidx.appcompat.widget.c.c c$c0 = new androidx.appcompat.widget.c.c(this, new e(this, this.b, this.c, this.j, true));
            this.z = c$c0;
            ((View)this.i).post(c$c0);
            return true;
        }
        return false;
    }

    @Override  // androidx.appcompat.view.menu.b
    public void a(androidx.appcompat.view.menu.e e0, boolean z) {
        this.w();
        super.a(e0, z);
    }

    @Override  // androidx.appcompat.view.menu.i
    public boolean c() {
        boolean z4;
        int v14;
        int v9;
        int v8;
        int v;
        ArrayList arrayList0;
        androidx.appcompat.view.menu.e e0 = this.c;
        if(e0 == null) {
            arrayList0 = null;
            v = 0;
        }
        else {
            arrayList0 = e0.A();
            v = arrayList0.size();
        }
        int v1 = this.q;
        int v2 = this.p;
        ViewGroup viewGroup0 = (ViewGroup)this.i;
        boolean z = false;
        int v4 = 0;
        int v5 = 0;
        for(int v3 = 0; v3 < v; ++v3) {
            f f0 = (f)arrayList0.get(v3);
            if(f0.n()) {
                ++v4;
            }
            else if(f0.m()) {
                ++v5;
            }
            else {
                z = true;
            }
            if(this.u && f0.isActionViewExpanded()) {
                v1 = 0;
            }
        }
        if(this.m && (z || v5 + v4 > v1)) {
            --v1;
        }
        int v6 = v1 - v4;
        SparseBooleanArray sparseBooleanArray0 = this.w;
        sparseBooleanArray0.clear();
        if(this.s) {
            int v7 = this.v;
            v8 = v2 / v7;
            v9 = v7 + v2 % v7 / v8;
        }
        else {
            v9 = 0;
            v8 = 0;
        }
        int v10 = 0;
        int v11 = 0;
        while(v10 < v) {
            f f1 = (f)arrayList0.get(v10);
            if(f1.n()) {
                View view0 = this.n(f1, null, viewGroup0);
                if(this.s) {
                    v8 -= ActionMenuView.G(view0, v9, v8, 0, 0);
                }
                else {
                    view0.measure(0, 0);
                }
                int v12 = view0.getMeasuredWidth();
                v2 -= v12;
                if(v11 == 0) {
                    v11 = v12;
                }
                int v13 = f1.getGroupId();
                if(v13 != 0) {
                    sparseBooleanArray0.put(v13, true);
                }
                f1.t(true);
                v14 = v;
            }
            else if(f1.m()) {
                int v15 = f1.getGroupId();
                boolean z1 = sparseBooleanArray0.get(v15);
                boolean z2 = (v6 > 0 || z1) && v2 > 0 && (!this.s || v8 > 0);
                boolean z3 = z2;
                v14 = v;
                if(z2) {
                    View view1 = this.n(f1, null, viewGroup0);
                    if(this.s) {
                        int v16 = ActionMenuView.G(view1, v9, v8, 0, 0);
                        v8 -= v16;
                        if(v16 == 0) {
                            z3 = false;
                        }
                    }
                    else {
                        view1.measure(0, 0);
                    }
                    int v17 = view1.getMeasuredWidth();
                    v2 -= v17;
                    if(v11 == 0) {
                        v11 = v17;
                    }
                    if(!this.s) {
                        if(v2 + v11 > 0) {
                            z4 = true;
                        }
                    }
                    else if(v2 >= 0) {
                        z4 = true;
                    }
                    else {
                        z4 = false;
                    }
                    z2 = z3 & z4;
                }
                if(z2 && v15 != 0) {
                    sparseBooleanArray0.put(v15, true);
                }
                else if(z1) {
                    sparseBooleanArray0.put(v15, false);
                    for(int v18 = 0; v18 < v10; ++v18) {
                        f f2 = (f)arrayList0.get(v18);
                        if(f2.getGroupId() == v15) {
                            if(f2.k()) {
                                ++v6;
                            }
                            f2.t(false);
                        }
                    }
                }
                if(z2) {
                    --v6;
                }
                f1.t(z2);
            }
            else {
                v14 = v;
                f1.t(((boolean)0));
            }
            ++v10;
            v = v14;
        }
        return true;
    }

    @Override  // androidx.appcompat.view.menu.b
    public void d(Context context0, androidx.appcompat.view.menu.e e0) {
        super.d(context0, e0);
        Resources resources0 = context0.getResources();
        h.a a0 = h.a.a(context0);
        if(!this.n) {
            this.m = true;
        }
        if(!this.t) {
            this.o = a0.b();
        }
        if(!this.r) {
            this.q = a0.c();
        }
        int v = this.o;
        if(this.m) {
            if(this.j == null) {
                d c$d0 = new d(this, this.a);
                this.j = c$d0;
                if(this.l) {
                    c$d0.setImageDrawable(this.k);
                    this.k = null;
                    this.l = false;
                }
                this.j.measure(0, 0);
            }
            v -= this.j.getMeasuredWidth();
        }
        else {
            this.j = null;
        }
        this.p = v;
        this.v = (int)(resources0.getDisplayMetrics().density * 56.0f);
    }

    @Override  // androidx.appcompat.view.menu.b
    public void f(f f0, androidx.appcompat.view.menu.j.a j$a0) {
        j$a0.d(f0, 0);
        ((ActionMenuItemView)j$a0).setItemInvoker(((ActionMenuView)this.i));
        if(this.A == null) {
            this.A = new androidx.appcompat.widget.c.b(this);
        }
        ((ActionMenuItemView)j$a0).setPopupCallback(this.A);
    }

    @Override  // androidx.appcompat.view.menu.b
    public boolean j(m m0) {
        boolean z = false;
        if(!m0.hasVisibleItems()) {
            return false;
        }
        m m1;
        for(m1 = m0; m1.W() != this.c; m1 = (m)m1.W()) {
        }
        View view0 = this.x(m1.getItem());
        if(view0 == null) {
            return false;
        }
        this.C = m0.getItem().getItemId();
        int v = m0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            MenuItem menuItem0 = m0.getItem(v1);
            if(menuItem0.isVisible() && menuItem0.getIcon() != null) {
                z = true;
                break;
            }
        }
        a c$a0 = new a(this, this.b, m0, view0);
        this.y = c$a0;
        c$a0.g(z);
        this.y.k();
        super.j(m0);
        return true;
    }

    @Override  // androidx.appcompat.view.menu.b
    public void k(boolean z) {
        super.k(z);
        ((View)this.i).requestLayout();
        androidx.appcompat.view.menu.e e0 = this.c;
        int v = 0;
        if(e0 != null) {
            ArrayList arrayList0 = e0.r();
            int v1 = arrayList0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                ((f)arrayList0.get(v2)).g();
            }
        }
        ArrayList arrayList1 = this.c == null ? null : this.c.v();
        if(this.m && arrayList1 != null) {
            int v3 = arrayList1.size();
            if(v3 == 1) {
                v = !((f)arrayList1.get(0)).isActionViewExpanded();
            }
            else if(v3 > 0) {
                v = 1;
            }
        }
        d c$d0 = this.j;
        if(v != 0) {
            if(c$d0 == null) {
                this.j = new d(this, this.a);
            }
            ViewGroup viewGroup0 = (ViewGroup)this.j.getParent();
            if(viewGroup0 != this.i) {
                if(viewGroup0 != null) {
                    viewGroup0.removeView(this.j);
                }
                ActionMenuView actionMenuView0 = (ActionMenuView)this.i;
                actionMenuView0.addView(this.j, actionMenuView0.C());
            }
        }
        else if(c$d0 != null) {
            ViewParent viewParent0 = c$d0.getParent();
            j j0 = this.i;
            if(viewParent0 == j0) {
                ((ViewGroup)j0).removeView(this.j);
            }
        }
        ((ActionMenuView)this.i).setOverflowReserved(this.m);
    }

    @Override  // androidx.appcompat.view.menu.b
    public boolean l(ViewGroup viewGroup0, int v) {
        return viewGroup0.getChildAt(v) == this.j ? false : super.l(viewGroup0, v);
    }

    @Override  // androidx.appcompat.view.menu.b
    public View n(f f0, View view0, ViewGroup viewGroup0) {
        View view1 = f0.getActionView();
        if(view1 == null || f0.i()) {
            view1 = super.n(f0, view0, viewGroup0);
        }
        view1.setVisibility((f0.isActionViewExpanded() ? 8 : 0));
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view1.getLayoutParams();
        if(!((ActionMenuView)viewGroup0).checkLayoutParams(viewGroup$LayoutParams0)) {
            view1.setLayoutParams(((ActionMenuView)viewGroup0).B(viewGroup$LayoutParams0));
        }
        return view1;
    }

    @Override  // androidx.appcompat.view.menu.b
    public boolean o(int v, f f0) {
        return f0.k();
    }

    public boolean w() {
        return this.z() | this.A();
    }

    private View x(MenuItem menuItem0) {
        ViewGroup viewGroup0 = (ViewGroup)this.i;
        if(viewGroup0 == null) {
            return null;
        }
        int v = viewGroup0.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = viewGroup0.getChildAt(v1);
            if(view0 instanceof androidx.appcompat.view.menu.j.a && ((androidx.appcompat.view.menu.j.a)view0).getItemData() == menuItem0) {
                return view0;
            }
        }
        return null;
    }

    public Drawable y() {
        d c$d0 = this.j;
        if(c$d0 != null) {
            return c$d0.getDrawable();
        }
        return this.l ? this.k : null;
    }

    public boolean z() {
        androidx.appcompat.widget.c.c c$c0 = this.z;
        if(c$c0 != null) {
            j j0 = this.i;
            if(j0 != null) {
                ((View)j0).removeCallbacks(c$c0);
                this.z = null;
                return true;
            }
        }
        e c$e0 = this.x;
        if(c$e0 != null) {
            c$e0.b();
            return true;
        }
        return false;
    }
}

