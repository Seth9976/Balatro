package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils.TruncateAt;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.k;
import androidx.appcompat.view.menu.m;
import androidx.core.view.i;
import androidx.core.view.j;
import androidx.core.view.l;
import androidx.core.view.v;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Toolbar extends ViewGroup implements i {
    class a implements e {
        final Toolbar a;

        @Override  // androidx.appcompat.widget.ActionMenuView$e
        public boolean onMenuItemClick(MenuItem menuItem0) {
            if(Toolbar.this.G.d(menuItem0)) {
                return true;
            }
            Toolbar.this.getClass();
            return false;
        }
    }

    class b implements Runnable {
        final Toolbar e;

        @Override
        public void run() {
            Toolbar.this.M();
        }
    }

    static abstract class androidx.appcompat.widget.Toolbar.e {
        static OnBackInvokedDispatcher a(View view0) {
            return view0.findOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(Runnable runnable0) {
            Objects.requireNonNull(runnable0);
            return new k(runnable0);
        }

        static void c(Object object0, Object object1) {
            ((OnBackInvokedDispatcher)object0).registerOnBackInvokedCallback(1000000, ((OnBackInvokedCallback)object1));
        }

        static void d(Object object0, Object object1) {
            ((OnBackInvokedDispatcher)object0).unregisterOnBackInvokedCallback(((OnBackInvokedCallback)object1));
        }
    }

    class f implements androidx.appcompat.view.menu.i {
        androidx.appcompat.view.menu.e a;
        androidx.appcompat.view.menu.f b;
        final Toolbar c;

        @Override  // androidx.appcompat.view.menu.i
        public void a(androidx.appcompat.view.menu.e e0, boolean z) {
        }

        @Override  // androidx.appcompat.view.menu.i
        public boolean c() {
            return false;
        }

        @Override  // androidx.appcompat.view.menu.i
        public void d(Context context0, androidx.appcompat.view.menu.e e0) {
            androidx.appcompat.view.menu.e e1 = this.a;
            if(e1 != null) {
                androidx.appcompat.view.menu.f f0 = this.b;
                if(f0 != null) {
                    e1.e(f0);
                }
            }
            this.a = e0;
        }

        @Override  // androidx.appcompat.view.menu.i
        public boolean e(androidx.appcompat.view.menu.e e0, androidx.appcompat.view.menu.f f0) {
            View view0 = Toolbar.this.i;
            if(view0 instanceof h.b) {
                ((h.b)view0).c();
            }
            Toolbar.this.removeView(Toolbar.this.i);
            Toolbar.this.removeView(Toolbar.this.h);
            Toolbar.this.i = null;
            Toolbar.this.a();
            this.b = null;
            Toolbar.this.requestLayout();
            f0.q(false);
            Toolbar.this.N();
            return true;
        }

        @Override  // androidx.appcompat.view.menu.i
        public boolean h(androidx.appcompat.view.menu.e e0, androidx.appcompat.view.menu.f f0) {
            Toolbar.this.e();
            ViewParent viewParent0 = Toolbar.this.h.getParent();
            Toolbar toolbar0 = Toolbar.this;
            if(viewParent0 != toolbar0) {
                if(viewParent0 instanceof ViewGroup) {
                    ((ViewGroup)viewParent0).removeView(toolbar0.h);
                }
                Toolbar.this.addView(Toolbar.this.h);
            }
            Toolbar.this.i = f0.getActionView();
            this.b = f0;
            ViewParent viewParent1 = Toolbar.this.i.getParent();
            Toolbar toolbar1 = Toolbar.this;
            if(viewParent1 != toolbar1) {
                if(viewParent1 instanceof ViewGroup) {
                    ((ViewGroup)viewParent1).removeView(toolbar1.i);
                }
                g toolbar$g0 = Toolbar.this.m();
                toolbar$g0.a = Toolbar.this.n & 0x70 | 0x800003;
                toolbar$g0.b = 2;
                Toolbar.this.i.setLayoutParams(toolbar$g0);
                Toolbar.this.addView(Toolbar.this.i);
            }
            Toolbar.this.G();
            Toolbar.this.requestLayout();
            f0.q(true);
            View view0 = Toolbar.this.i;
            if(view0 instanceof h.b) {
                ((h.b)view0).b();
            }
            Toolbar.this.N();
            return true;
        }

        @Override  // androidx.appcompat.view.menu.i
        public boolean j(m m0) {
            return false;
        }

        @Override  // androidx.appcompat.view.menu.i
        public void k(boolean z) {
            if(this.b != null) {
                androidx.appcompat.view.menu.e e0 = this.a;
                boolean z1 = false;
                if(e0 != null) {
                    int v = e0.size();
                    for(int v1 = 0; v1 < v; ++v1) {
                        if(this.a.getItem(v1) == this.b) {
                            z1 = true;
                            break;
                        }
                    }
                }
                if(!z1) {
                    this.e(this.a, this.b);
                }
            }
        }
    }

    public static class g extends d.a {
        int b;

        public g(int v, int v1) {
            super(v, v1);
            this.b = 0;
            this.a = 0x800013;
        }

        public g(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            this.b = 0;
        }

        public g(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
            super(viewGroup$LayoutParams0);
            this.b = 0;
        }

        public g(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
            super(viewGroup$MarginLayoutParams0);
            this.b = 0;
            this.a(viewGroup$MarginLayoutParams0);
        }

        public g(g toolbar$g0) {
            super(toolbar$g0);
            this.b = toolbar$g0.b;
        }

        public g(d.a a0) {
            super(a0);
            this.b = 0;
        }

        void a(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
            this.leftMargin = viewGroup$MarginLayoutParams0.leftMargin;
            this.topMargin = viewGroup$MarginLayoutParams0.topMargin;
            this.rightMargin = viewGroup$MarginLayoutParams0.rightMargin;
            this.bottomMargin = viewGroup$MarginLayoutParams0.bottomMargin;
        }
    }

    public interface h {
    }

    public static class androidx.appcompat.widget.Toolbar.i extends r.a {
        class androidx.appcompat.widget.Toolbar.i.a implements Parcelable.ClassLoaderCreator {
            androidx.appcompat.widget.Toolbar.i.a() {
                super();
            }

            public androidx.appcompat.widget.Toolbar.i a(Parcel parcel0) {
                return new androidx.appcompat.widget.Toolbar.i(parcel0, null);
            }

            public androidx.appcompat.widget.Toolbar.i b(Parcel parcel0, ClassLoader classLoader0) {
                return new androidx.appcompat.widget.Toolbar.i(parcel0, classLoader0);
            }

            public androidx.appcompat.widget.Toolbar.i[] c(int v) {
                return new androidx.appcompat.widget.Toolbar.i[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.a(parcel0);
            }

            @Override  // android.os.Parcelable$ClassLoaderCreator
            public Object createFromParcel(Parcel parcel0, ClassLoader classLoader0) {
                return this.b(parcel0, classLoader0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.c(v);
            }
        }

        public static final Parcelable.Creator CREATOR;
        int g;
        boolean h;

        static {
            androidx.appcompat.widget.Toolbar.i.CREATOR = new androidx.appcompat.widget.Toolbar.i.a();
        }

        public androidx.appcompat.widget.Toolbar.i(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            this.g = parcel0.readInt();
            this.h = parcel0.readInt() != 0;
        }

        public androidx.appcompat.widget.Toolbar.i(Parcelable parcelable0) {
            super(parcelable0);
        }

        @Override  // r.a
        public void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(this.g);
            parcel0.writeInt(((int)this.h));
        }
    }

    private ColorStateList A;
    private boolean B;
    private boolean C;
    private final ArrayList D;
    private final ArrayList E;
    private final int[] F;
    final j G;
    private ArrayList H;
    private final e I;
    private o0 J;
    private c K;
    private f L;
    private androidx.appcompat.view.menu.i.a M;
    androidx.appcompat.view.menu.e.a N;
    private boolean O;
    private OnBackInvokedCallback P;
    private OnBackInvokedDispatcher Q;
    private boolean R;
    private final Runnable S;
    ActionMenuView a;
    private TextView b;
    private TextView c;
    private ImageButton d;
    private ImageView e;
    private Drawable f;
    private CharSequence g;
    ImageButton h;
    View i;
    private Context j;
    private int k;
    private int l;
    private int m;
    int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private e0 t;
    private int u;
    private int v;
    private int w;
    private CharSequence x;
    private CharSequence y;
    private ColorStateList z;

    public Toolbar(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, c.a.s);
    }

    public Toolbar(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.w = 0x800013;
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new int[2];
        this.G = new j(() -> {
            for(Object object0: this.H) {
                this.getMenu().removeItem(((MenuItem)object0).getItemId());
            }
            this.E();
        });
        this.H = new ArrayList();
        this.I = new a(this);
        this.S = () -> Toolbar.this.a != null && Toolbar.this.a.K();
        l0 l00 = l0.s(this.getContext(), attributeSet0, c.i.a2, v, 0);
        v.F(this, context0, c.i.a2, attributeSet0, l00.o(), v, 0);
        this.l = l00.l(c.i.C2, 0);
        this.m = l00.l(c.i.t2, 0);
        this.w = l00.j(c.i.b2, this.w);
        this.n = l00.j(c.i.c2, 0x30);
        int v1 = l00.d(c.i.w2, 0);
        if(l00.p(c.i.B2)) {
            v1 = l00.d(c.i.B2, v1);
        }
        this.s = v1;
        this.r = v1;
        this.q = v1;
        this.p = v1;
        int v2 = l00.d(c.i.z2, -1);
        if(v2 >= 0) {
            this.p = v2;
        }
        int v3 = l00.d(c.i.y2, -1);
        if(v3 >= 0) {
            this.q = v3;
        }
        int v4 = l00.d(c.i.A2, -1);
        if(v4 >= 0) {
            this.r = v4;
        }
        int v5 = l00.d(c.i.x2, -1);
        if(v5 >= 0) {
            this.s = v5;
        }
        this.o = l00.e(c.i.n2, -1);
        int v6 = l00.d(c.i.j2, 0x80000000);
        int v7 = l00.d(c.i.f2, 0x80000000);
        int v8 = l00.e(c.i.h2, 0);
        int v9 = l00.e(c.i.i2, 0);
        this.h();
        this.t.e(v8, v9);
        if(v6 != 0x80000000 || v7 != 0x80000000) {
            this.t.g(v6, v7);
        }
        this.u = l00.d(c.i.k2, 0x80000000);
        this.v = l00.d(c.i.g2, 0x80000000);
        this.f = l00.f(c.i.e2);
        this.g = l00.n(c.i.d2);
        CharSequence charSequence0 = l00.n(c.i.v2);
        if(!TextUtils.isEmpty(charSequence0)) {
            this.setTitle(charSequence0);
        }
        CharSequence charSequence1 = l00.n(c.i.s2);
        if(!TextUtils.isEmpty(charSequence1)) {
            this.setSubtitle(charSequence1);
        }
        this.j = this.getContext();
        this.setPopupTheme(l00.l(c.i.r2, 0));
        Drawable drawable0 = l00.f(c.i.q2);
        if(drawable0 != null) {
            this.setNavigationIcon(drawable0);
        }
        CharSequence charSequence2 = l00.n(c.i.p2);
        if(!TextUtils.isEmpty(charSequence2)) {
            this.setNavigationContentDescription(charSequence2);
        }
        Drawable drawable1 = l00.f(c.i.l2);
        if(drawable1 != null) {
            this.setLogo(drawable1);
        }
        CharSequence charSequence3 = l00.n(c.i.m2);
        if(!TextUtils.isEmpty(charSequence3)) {
            this.setLogoDescription(charSequence3);
        }
        if(l00.p(c.i.D2)) {
            this.setTitleTextColor(l00.c(c.i.D2));
        }
        if(l00.p(c.i.u2)) {
            this.setSubtitleTextColor(l00.c(c.i.u2));
        }
        if(l00.p(c.i.o2)) {
            this.w(l00.l(c.i.o2, 0));
        }
        l00.t();
    }

    private int A(View view0, int v, int[] arr_v, int v1) {
        g toolbar$g0 = (g)view0.getLayoutParams();
        int v2 = toolbar$g0.leftMargin - arr_v[0];
        int v3 = v + Math.max(0, v2);
        arr_v[0] = Math.max(0, -v2);
        int v4 = this.q(view0, v1);
        int v5 = view0.getMeasuredWidth();
        view0.layout(v3, v4, v3 + v5, view0.getMeasuredHeight() + v4);
        return v3 + (v5 + toolbar$g0.rightMargin);
    }

    private int B(View view0, int v, int[] arr_v, int v1) {
        g toolbar$g0 = (g)view0.getLayoutParams();
        int v2 = toolbar$g0.rightMargin - arr_v[1];
        int v3 = v - Math.max(0, v2);
        arr_v[1] = Math.max(0, -v2);
        int v4 = this.q(view0, v1);
        int v5 = view0.getMeasuredWidth();
        view0.layout(v3 - v5, v4, v3, view0.getMeasuredHeight() + v4);
        return v3 - (v5 + toolbar$g0.leftMargin);
    }

    private int C(View view0, int v, int v1, int v2, int v3, int[] arr_v) {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        int v4 = viewGroup$MarginLayoutParams0.leftMargin - arr_v[0];
        int v5 = viewGroup$MarginLayoutParams0.rightMargin - arr_v[1];
        int v6 = Math.max(0, v4) + Math.max(0, v5);
        arr_v[0] = Math.max(0, -v4);
        arr_v[1] = Math.max(0, -v5);
        view0.measure(ViewGroup.getChildMeasureSpec(v, this.getPaddingLeft() + this.getPaddingRight() + v6 + v1, viewGroup$MarginLayoutParams0.width), ViewGroup.getChildMeasureSpec(v2, this.getPaddingTop() + this.getPaddingBottom() + viewGroup$MarginLayoutParams0.topMargin + viewGroup$MarginLayoutParams0.bottomMargin + v3, viewGroup$MarginLayoutParams0.height));
        return view0.getMeasuredWidth() + v6;
    }

    private void D(View view0, int v, int v1, int v2, int v3, int v4) {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        int v5 = ViewGroup.getChildMeasureSpec(v, this.getPaddingLeft() + this.getPaddingRight() + viewGroup$MarginLayoutParams0.leftMargin + viewGroup$MarginLayoutParams0.rightMargin + v1, viewGroup$MarginLayoutParams0.width);
        int v6 = ViewGroup.getChildMeasureSpec(v2, this.getPaddingTop() + this.getPaddingBottom() + viewGroup$MarginLayoutParams0.topMargin + viewGroup$MarginLayoutParams0.bottomMargin + v3, viewGroup$MarginLayoutParams0.height);
        int v7 = View.MeasureSpec.getMode(v6);
        if(v7 != 0x40000000 && v4 >= 0) {
            if(v7 != 0) {
                v4 = Math.min(View.MeasureSpec.getSize(v6), v4);
            }
            v6 = View.MeasureSpec.makeMeasureSpec(v4, 0x40000000);
        }
        view0.measure(v5, v6);
    }

    private void E() {
        Menu menu0 = this.getMenu();
        ArrayList arrayList0 = this.getCurrentMenuItems();
        MenuInflater menuInflater0 = this.getMenuInflater();
        this.G.b(menu0, menuInflater0);
        ArrayList arrayList1 = this.getCurrentMenuItems();
        arrayList1.removeAll(arrayList0);
        this.H = arrayList1;
    }

    private void F() {
        this.removeCallbacks(this.S);
        this.post(this.S);
    }

    void G() {
        for(int v = this.getChildCount() - 1; v >= 0; --v) {
            View view0 = this.getChildAt(v);
            if(((g)view0.getLayoutParams()).b != 2 && view0 != this.a) {
                this.removeViewAt(v);
                this.E.add(view0);
            }
        }
    }

    public void H(int v, int v1) {
        this.h();
        this.t.g(v, v1);
    }

    public void I(Context context0, int v) {
        this.m = v;
        TextView textView0 = this.c;
        if(textView0 != null) {
            textView0.setTextAppearance(context0, v);
        }
    }

    public void J(Context context0, int v) {
        this.l = v;
        TextView textView0 = this.b;
        if(textView0 != null) {
            textView0.setTextAppearance(context0, v);
        }
    }

    private boolean K() {
        if(!this.O) {
            return false;
        }
        int v = this.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = this.getChildAt(v1);
            if(this.L(view0) && view0.getMeasuredWidth() > 0 && view0.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean L(View view0) {
        return view0 != null && view0.getParent() == this && view0.getVisibility() != 8;
    }

    // 检测为 Lambda 实现
    public boolean M() [...]

    void N() {
        if(Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher0 = androidx.appcompat.widget.Toolbar.e.a(this);
            boolean z = this.v() && onBackInvokedDispatcher0 != null && v.v(this) && this.R;
            if(z && this.Q == null) {
                if(this.P == null) {
                    this.P = androidx.appcompat.widget.Toolbar.e.b(() -> {
                        androidx.appcompat.view.menu.f f0 = this.L == null ? null : this.L.b;
                        if(f0 != null) {
                            f0.collapseActionView();
                        }
                    });
                }
                androidx.appcompat.widget.Toolbar.e.c(onBackInvokedDispatcher0, this.P);
                this.Q = onBackInvokedDispatcher0;
                return;
            }
            if(!z) {
                OnBackInvokedDispatcher onBackInvokedDispatcher1 = this.Q;
                if(onBackInvokedDispatcher1 != null) {
                    androidx.appcompat.widget.Toolbar.e.d(onBackInvokedDispatcher1, this.P);
                    this.Q = null;
                }
            }
        }
    }

    void a() {
        for(int v = this.E.size() - 1; v >= 0; --v) {
            this.addView(((View)this.E.get(v)));
        }
        this.E.clear();
    }

    private void b(List list0, int v) {
        boolean z = v.o(this) == 1;
        int v2 = this.getChildCount();
        int v3 = androidx.core.view.e.a(v, v.o(this));
        list0.clear();
        if(z) {
            for(int v4 = v2 - 1; v4 >= 0; --v4) {
                View view0 = this.getChildAt(v4);
                g toolbar$g0 = (g)view0.getLayoutParams();
                if(toolbar$g0.b == 0 && this.L(view0) && this.p(toolbar$g0.a) == v3) {
                    list0.add(view0);
                }
            }
            return;
        }
        for(int v1 = 0; v1 < v2; ++v1) {
            View view1 = this.getChildAt(v1);
            g toolbar$g1 = (g)view1.getLayoutParams();
            if(toolbar$g1.b == 0 && this.L(view1) && this.p(toolbar$g1.a) == v3) {
                list0.add(view1);
            }
        }
    }

    private void c(View view0, boolean z) {
        g toolbar$g0;
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(viewGroup$LayoutParams0 == null) {
            toolbar$g0 = this.m();
        }
        else {
            toolbar$g0 = this.checkLayoutParams(viewGroup$LayoutParams0) ? ((g)viewGroup$LayoutParams0) : this.o(viewGroup$LayoutParams0);
        }
        toolbar$g0.b = 1;
        if(z && this.i != null) {
            view0.setLayoutParams(toolbar$g0);
            this.E.add(view0);
            return;
        }
        this.addView(view0, toolbar$g0);
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return super.checkLayoutParams(viewGroup$LayoutParams0) && viewGroup$LayoutParams0 instanceof g;
    }

    // 检测为 Lambda 实现
    public void d() [...]

    void e() {
        class d implements View.OnClickListener {
            final Toolbar a;

            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                Toolbar.this.d();
            }
        }

        if(this.h == null) {
            androidx.appcompat.widget.j j0 = new androidx.appcompat.widget.j(this.getContext(), null, c.a.r);
            this.h = j0;
            j0.setImageDrawable(this.f);
            this.h.setContentDescription(this.g);
            g toolbar$g0 = this.m();
            toolbar$g0.a = this.n & 0x70 | 0x800003;
            toolbar$g0.b = 2;
            this.h.setLayoutParams(toolbar$g0);
            this.h.setOnClickListener((/* 缺少LAMBDA参数 */) -> {
                androidx.appcompat.view.menu.f f0 = Toolbar.this.L == null ? null : Toolbar.this.L.b;
                if(f0 != null) {
                    f0.collapseActionView();
                }
            });
        }
    }

    @Override  // androidx.core.view.i
    public void f(l l0) {
        this.G.f(l0);
    }

    @Override  // androidx.core.view.i
    public void g(l l0) {
        this.G.a(l0);
    }

    @Override  // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.m();
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return this.n(attributeSet0);
    }

    @Override  // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return this.o(viewGroup$LayoutParams0);
    }

    public CharSequence getCollapseContentDescription() {
        return this.h == null ? null : this.h.getContentDescription();
    }

    public Drawable getCollapseIcon() {
        return this.h == null ? null : this.h.getDrawable();
    }

    public int getContentInsetEnd() {
        return this.t == null ? 0 : this.t.a();
    }

    public int getContentInsetEndWithActions() {
        return this.v == 0x80000000 ? this.getContentInsetEnd() : this.v;
    }

    public int getContentInsetLeft() {
        return this.t == null ? 0 : this.t.b();
    }

    public int getContentInsetRight() {
        return this.t == null ? 0 : this.t.c();
    }

    public int getContentInsetStart() {
        return this.t == null ? 0 : this.t.d();
    }

    public int getContentInsetStartWithNavigation() {
        return this.u == 0x80000000 ? this.getContentInsetStart() : this.u;
    }

    public int getCurrentContentInsetEnd() {
        ActionMenuView actionMenuView0 = this.a;
        if(actionMenuView0 != null) {
            androidx.appcompat.view.menu.e e0 = actionMenuView0.I();
            return e0 == null || !e0.hasVisibleItems() ? this.getContentInsetEnd() : Math.max(this.getContentInsetEnd(), Math.max(this.v, 0));
        }
        return this.getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return v.o(this) == 1 ? this.getCurrentContentInsetEnd() : this.getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return v.o(this) == 1 ? this.getCurrentContentInsetStart() : this.getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return this.getNavigationIcon() == null ? this.getContentInsetStart() : Math.max(this.getContentInsetStart(), Math.max(this.u, 0));
    }

    private ArrayList getCurrentMenuItems() {
        ArrayList arrayList0 = new ArrayList();
        Menu menu0 = this.getMenu();
        for(int v = 0; v < menu0.size(); ++v) {
            arrayList0.add(menu0.getItem(v));
        }
        return arrayList0;
    }

    public Drawable getLogo() {
        return this.e == null ? null : this.e.getDrawable();
    }

    public CharSequence getLogoDescription() {
        return this.e == null ? null : this.e.getContentDescription();
    }

    public Menu getMenu() {
        this.j();
        return this.a.getMenu();
    }

    private MenuInflater getMenuInflater() {
        return new h.c(this.getContext());
    }

    View getNavButtonView() {
        return this.d;
    }

    public CharSequence getNavigationContentDescription() {
        return this.d == null ? null : this.d.getContentDescription();
    }

    public Drawable getNavigationIcon() {
        return this.d == null ? null : this.d.getDrawable();
    }

    c getOuterActionMenuPresenter() {
        return this.K;
    }

    public Drawable getOverflowIcon() {
        this.j();
        return this.a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.j;
    }

    public int getPopupTheme() {
        return this.k;
    }

    public CharSequence getSubtitle() {
        return this.y;
    }

    final TextView getSubtitleTextView() {
        return this.c;
    }

    public CharSequence getTitle() {
        return this.x;
    }

    public int getTitleMarginBottom() {
        return this.s;
    }

    public int getTitleMarginEnd() {
        return this.q;
    }

    public int getTitleMarginStart() {
        return this.p;
    }

    public int getTitleMarginTop() {
        return this.r;
    }

    final TextView getTitleTextView() {
        return this.b;
    }

    public t getWrapper() {
        if(this.J == null) {
            this.J = new o0(this, true);
        }
        return this.J;
    }

    private void h() {
        if(this.t == null) {
            this.t = new e0();
        }
    }

    private void i() {
        if(this.e == null) {
            this.e = new androidx.appcompat.widget.l(this.getContext());
        }
    }

    private void j() {
        this.k();
        if(this.a.I() == null) {
            androidx.appcompat.view.menu.e e0 = (androidx.appcompat.view.menu.e)this.a.getMenu();
            if(this.L == null) {
                this.L = new f(this);
            }
            this.a.setExpandedActionViewsExclusive(true);
            e0.b(this.L, this.j);
            this.N();
        }
    }

    private void k() {
        class androidx.appcompat.widget.Toolbar.c implements androidx.appcompat.view.menu.e.a {
            final Toolbar a;

            @Override  // androidx.appcompat.view.menu.e$a
            public boolean a(androidx.appcompat.view.menu.e e0, MenuItem menuItem0) {
                androidx.appcompat.view.menu.e.a e$a0 = Toolbar.this.N;
                return e$a0 != null && e$a0.a(e0, menuItem0);
            }

            @Override  // androidx.appcompat.view.menu.e$a
            public void b(androidx.appcompat.view.menu.e e0) {
                if(!Toolbar.this.a.F()) {
                    Toolbar.this.G.e(e0);
                }
                androidx.appcompat.view.menu.e.a e$a0 = Toolbar.this.N;
                if(e$a0 != null) {
                    e$a0.b(e0);
                }
            }
        }

        if(this.a == null) {
            ActionMenuView actionMenuView0 = new ActionMenuView(this.getContext());
            this.a = actionMenuView0;
            actionMenuView0.setPopupTheme(this.k);
            this.a.setOnMenuItemClickListener(this.I);
            this.a.J(this.M, new androidx.appcompat.widget.Toolbar.c(this));
            g toolbar$g0 = this.m();
            toolbar$g0.a = this.n & 0x70 | 0x800005;
            this.a.setLayoutParams(toolbar$g0);
            this.c(this.a, false);
        }
    }

    private void l() {
        if(this.d == null) {
            this.d = new androidx.appcompat.widget.j(this.getContext(), null, c.a.r);
            g toolbar$g0 = this.m();
            toolbar$g0.a = this.n & 0x70 | 0x800003;
            this.d.setLayoutParams(toolbar$g0);
        }
    }

    protected g m() {
        return new g(-2, -2);
    }

    public g n(AttributeSet attributeSet0) {
        return new g(this.getContext(), attributeSet0);
    }

    protected g o(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(viewGroup$LayoutParams0 instanceof g) {
            return new g(((g)viewGroup$LayoutParams0));
        }
        if(viewGroup$LayoutParams0 instanceof d.a) {
            return new g(((d.a)viewGroup$LayoutParams0));
        }
        return viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? new g(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0)) : new g(viewGroup$LayoutParams0);
    }

    @Override  // android.view.ViewGroup
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.N();
    }

    @Override  // android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks(this.S);
        this.N();
    }

    @Override  // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionMasked();
        if(v == 9) {
            this.C = false;
        }
        if(!this.C && (v == 9 && !super.onHoverEvent(motionEvent0))) {
            this.C = true;
        }
        if(v == 3 || v == 10) {
            this.C = false;
        }
        return true;
    }

    @Override  // android.view.ViewGroup
    protected void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v44;
        int v40;
        int v36;
        int v35;
        int v34;
        int v30;
        int v26;
        int v23;
        int v19;
        int v14;
        int v13;
        boolean z1 = v.o(this) == 1;
        int v4 = this.getWidth();
        int v5 = this.getHeight();
        int v6 = this.getPaddingLeft();
        int v7 = this.getPaddingRight();
        int v8 = this.getPaddingTop();
        int v9 = this.getPaddingBottom();
        int v10 = v4 - v7;
        int[] arr_v = this.F;
        arr_v[1] = 0;
        arr_v[0] = 0;
        int v11 = v.p(this);
        int v12 = v11 < 0 ? 0 : Math.min(v11, v3 - v1);
        if(this.L(this.d)) {
            ImageButton imageButton0 = this.d;
            if(z1) {
                v13 = this.B(imageButton0, v10, arr_v, v12);
                v14 = v6;
            }
            else {
                v14 = this.A(imageButton0, v6, arr_v, v12);
                v13 = v10;
            }
        }
        else {
            v14 = v6;
            v13 = v10;
        }
        if(this.L(this.h)) {
            ImageButton imageButton1 = this.h;
            if(z1) {
                v13 = this.B(imageButton1, v13, arr_v, v12);
            }
            else {
                v14 = this.A(imageButton1, v14, arr_v, v12);
            }
        }
        if(this.L(this.a)) {
            ActionMenuView actionMenuView0 = this.a;
            if(z1) {
                v14 = this.A(actionMenuView0, v14, arr_v, v12);
            }
            else {
                v13 = this.B(actionMenuView0, v13, arr_v, v12);
            }
        }
        int v15 = this.getCurrentContentInsetLeft();
        int v16 = this.getCurrentContentInsetRight();
        arr_v[0] = Math.max(0, v15 - v14);
        arr_v[1] = Math.max(0, v16 - (v10 - v13));
        int v17 = Math.max(v14, v15);
        int v18 = Math.min(v13, v10 - v16);
        if(this.L(this.i)) {
            View view0 = this.i;
            if(z1) {
                v18 = this.B(view0, v18, arr_v, v12);
            }
            else {
                v17 = this.A(view0, v17, arr_v, v12);
            }
        }
        if(this.L(this.e)) {
            ImageView imageView0 = this.e;
            if(z1) {
                v18 = this.B(imageView0, v18, arr_v, v12);
            }
            else {
                v17 = this.A(imageView0, v17, arr_v, v12);
            }
        }
        boolean z2 = this.L(this.b);
        boolean z3 = this.L(this.c);
        if(z2) {
            g toolbar$g0 = (g)this.b.getLayoutParams();
            v19 = toolbar$g0.topMargin + this.b.getMeasuredHeight() + toolbar$g0.bottomMargin;
        }
        else {
            v19 = 0;
        }
        if(z3) {
            g toolbar$g1 = (g)this.c.getLayoutParams();
            v19 += toolbar$g1.topMargin + this.c.getMeasuredHeight() + toolbar$g1.bottomMargin;
        }
        if(z2 || z3) {
            TextView textView0 = z3 ? this.c : this.b;
            g toolbar$g2 = (g)(z2 ? this.b : this.c).getLayoutParams();
            g toolbar$g3 = (g)textView0.getLayoutParams();
            boolean z4 = z2 && this.b.getMeasuredWidth() > 0 || z3 && this.c.getMeasuredWidth() > 0;
            switch(this.w & 0x70) {
                case 0x30: {
                    v23 = v17;
                    v26 = this.getPaddingTop() + toolbar$g2.topMargin + this.r;
                    break;
                }
                case 80: {
                    v23 = v17;
                    v26 = v5 - v9 - toolbar$g3.bottomMargin - this.s - v19;
                    break;
                }
                default: {
                    int v20 = (v5 - v8 - v9 - v19) / 2;
                    int v21 = toolbar$g2.topMargin;
                    int v22 = this.r;
                    v23 = v17;
                    if(v20 < v21 + v22) {
                        v20 = v21 + v22;
                    }
                    else {
                        int v24 = v5 - v9 - v19 - v20 - v8;
                        int v25 = this.s;
                        if(v24 < toolbar$g2.bottomMargin + v25) {
                            v20 = Math.max(0, v20 - (toolbar$g3.bottomMargin + v25 - v24));
                        }
                    }
                    v26 = v8 + v20;
                }
            }
            if(z1) {
                int v27 = (z4 ? this.p : 0) - arr_v[1];
                v18 -= Math.max(0, v27);
                arr_v[1] = Math.max(0, -v27);
                if(z2) {
                    g toolbar$g4 = (g)this.b.getLayoutParams();
                    int v28 = v18 - this.b.getMeasuredWidth();
                    int v29 = this.b.getMeasuredHeight() + v26;
                    this.b.layout(v28, v26, v18, v29);
                    v30 = v28 - this.q;
                    v26 = v29 + toolbar$g4.bottomMargin;
                }
                else {
                    v30 = v18;
                }
                if(z3) {
                    int v31 = v26 + ((g)this.c.getLayoutParams()).topMargin;
                    int v32 = this.c.getMeasuredWidth();
                    int v33 = this.c.getMeasuredHeight();
                    this.c.layout(v18 - v32, v31, v18, v33 + v31);
                    v34 = v18 - this.q;
                }
                else {
                    v34 = v18;
                }
                if(z4) {
                    v18 = Math.min(v30, v34);
                }
                v17 = v23;
                v35 = 0;
            }
            else {
                if(z4) {
                    v36 = this.p;
                    v35 = 0;
                }
                else {
                    v35 = 0;
                    v36 = 0;
                }
                int v37 = v36 - arr_v[0];
                v17 = v23 + Math.max(0, v37);
                arr_v[0] = Math.max(0, -v37);
                if(z2) {
                    g toolbar$g5 = (g)this.b.getLayoutParams();
                    int v38 = this.b.getMeasuredWidth() + v17;
                    int v39 = this.b.getMeasuredHeight() + v26;
                    this.b.layout(v17, v26, v38, v39);
                    v40 = v38 + this.q;
                    v26 = v39 + toolbar$g5.bottomMargin;
                }
                else {
                    v40 = v17;
                }
                if(z3) {
                    int v41 = v26 + ((g)this.c.getLayoutParams()).topMargin;
                    int v42 = this.c.getMeasuredWidth() + v17;
                    int v43 = this.c.getMeasuredHeight();
                    this.c.layout(v17, v41, v42, v43 + v41);
                    v44 = v42 + this.q;
                }
                else {
                    v44 = v17;
                }
                if(z4) {
                    v17 = Math.max(v40, v44);
                }
            }
        }
        else {
            v35 = 0;
        }
        this.b(this.D, 3);
        int v45 = this.D.size();
        for(int v46 = 0; v46 < v45; ++v46) {
            v17 = this.A(((View)this.D.get(v46)), v17, arr_v, v12);
        }
        this.b(this.D, 5);
        int v47 = this.D.size();
        for(int v48 = 0; v48 < v47; ++v48) {
            v18 = this.B(((View)this.D.get(v48)), v18, arr_v, v12);
        }
        this.b(this.D, 1);
        int v49 = this.u(this.D, arr_v);
        int v50 = v6 + (v4 - v6 - v7) / 2 - v49 / 2;
        int v51 = v49 + v50;
        if(v50 >= v17) {
            v17 = v51 <= v18 ? v50 : v50 - (v51 - v18);
        }
        int v52 = this.D.size();
        while(v35 < v52) {
            v17 = this.A(((View)this.D.get(v35)), v17, arr_v, v12);
            ++v35;
        }
        this.D.clear();
    }

    @Override  // android.view.View
    protected void onMeasure(int v, int v1) {
        int v19;
        int v18;
        int v17;
        int v8;
        int v5;
        int v4;
        int v3;
        int[] arr_v = this.F;
        boolean z = v0.a(this);
        int v2 = 0;
        if(this.L(this.d)) {
            this.D(this.d, v, 0, v1, 0, this.o);
            v3 = this.d.getMeasuredWidth() + this.s(this.d);
            v4 = Math.max(0, this.d.getMeasuredHeight() + this.t(this.d));
            v5 = View.combineMeasuredStates(0, this.d.getMeasuredState());
        }
        else {
            v3 = 0;
            v4 = 0;
            v5 = 0;
        }
        if(this.L(this.h)) {
            this.D(this.h, v, 0, v1, 0, this.o);
            v3 = this.h.getMeasuredWidth() + this.s(this.h);
            v4 = Math.max(v4, this.h.getMeasuredHeight() + this.t(this.h));
            v5 = View.combineMeasuredStates(v5, this.h.getMeasuredState());
        }
        int v6 = this.getCurrentContentInsetStart();
        int v7 = Math.max(v6, v3);
        arr_v[z] = Math.max(0, v6 - v3);
        if(this.L(this.a)) {
            this.D(this.a, v, v7, v1, 0, this.o);
            v8 = this.a.getMeasuredWidth() + this.s(this.a);
            v4 = Math.max(v4, this.a.getMeasuredHeight() + this.t(this.a));
            v5 = View.combineMeasuredStates(v5, this.a.getMeasuredState());
        }
        else {
            v8 = 0;
        }
        int v9 = this.getCurrentContentInsetEnd();
        int v10 = v7 + Math.max(v9, v8);
        arr_v[!z] = Math.max(0, v9 - v8);
        if(this.L(this.i)) {
            v10 += this.C(this.i, v, v10, v1, 0, arr_v);
            v4 = Math.max(v4, this.i.getMeasuredHeight() + this.t(this.i));
            v5 = View.combineMeasuredStates(v5, this.i.getMeasuredState());
        }
        if(this.L(this.e)) {
            v10 += this.C(this.e, v, v10, v1, 0, arr_v);
            v4 = Math.max(v4, this.e.getMeasuredHeight() + this.t(this.e));
            v5 = View.combineMeasuredStates(v5, this.e.getMeasuredState());
        }
        int v11 = this.getChildCount();
        for(int v12 = 0; v12 < v11; ++v12) {
            View view0 = this.getChildAt(v12);
            if(((g)view0.getLayoutParams()).b == 0 && this.L(view0)) {
                v10 += this.C(view0, v, v10, v1, 0, arr_v);
                v4 = Math.max(v4, view0.getMeasuredHeight() + this.t(view0));
                v5 = View.combineMeasuredStates(v5, view0.getMeasuredState());
            }
        }
        int v13 = this.r + this.s;
        int v14 = this.p + this.q;
        if(this.L(this.b)) {
            this.C(this.b, v, v10 + v14, v1, v13, arr_v);
            int v15 = this.b.getMeasuredWidth();
            int v16 = this.s(this.b);
            v17 = this.b.getMeasuredHeight() + this.t(this.b);
            v18 = View.combineMeasuredStates(v5, this.b.getMeasuredState());
            v19 = v15 + v16;
        }
        else {
            v17 = 0;
            v18 = v5;
            v19 = 0;
        }
        if(this.L(this.c)) {
            v19 = Math.max(v19, this.C(this.c, v, v10 + v14, v1, v17 + v13, arr_v));
            v17 += this.c.getMeasuredHeight() + this.t(this.c);
            v18 = View.combineMeasuredStates(v18, this.c.getMeasuredState());
        }
        int v20 = this.getPaddingLeft();
        int v21 = this.getPaddingRight();
        int v22 = this.getPaddingTop();
        int v23 = this.getPaddingBottom();
        int v24 = View.resolveSizeAndState(Math.max(v10 + v19 + (v20 + v21), this.getSuggestedMinimumWidth()), v, 0xFF000000 & v18);
        int v25 = View.resolveSizeAndState(Math.max(Math.max(v4, v17) + (v22 + v23), this.getSuggestedMinimumHeight()), v1, v18 << 16);
        if(!this.K()) {
            v2 = v25;
        }
        this.setMeasuredDimension(v24, v2);
    }

    @Override  // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof androidx.appcompat.widget.Toolbar.i)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((androidx.appcompat.widget.Toolbar.i)parcelable0).o());
        androidx.appcompat.view.menu.e e0 = this.a == null ? null : this.a.I();
        int v = ((androidx.appcompat.widget.Toolbar.i)parcelable0).g;
        if(v != 0 && this.L != null && e0 != null) {
            MenuItem menuItem0 = e0.findItem(v);
            if(menuItem0 != null) {
                menuItem0.expandActionView();
            }
        }
        if(((androidx.appcompat.widget.Toolbar.i)parcelable0).h) {
            this.F();
        }
    }

    @Override  // android.view.View
    public void onRtlPropertiesChanged(int v) {
        super.onRtlPropertiesChanged(v);
        this.h();
        this.t.f(v == 1);
    }

    @Override  // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new androidx.appcompat.widget.Toolbar.i(super.onSaveInstanceState());
        f toolbar$f0 = this.L;
        if(toolbar$f0 != null) {
            androidx.appcompat.view.menu.f f0 = toolbar$f0.b;
            if(f0 != null) {
                parcelable0.g = f0.getItemId();
            }
        }
        parcelable0.h = this.z();
        return parcelable0;
    }

    @Override  // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionMasked();
        if(v == 0) {
            this.B = false;
        }
        if(!this.B && (v == 0 && !super.onTouchEvent(motionEvent0))) {
            this.B = true;
        }
        if(v == 1 || v == 3) {
            this.B = false;
        }
        return true;
    }

    private int p(int v) {
        int v1 = v.o(this);
        int v2 = androidx.core.view.e.a(v, v1);
        if((v2 & 7) != 1 && (v2 & 7) != 3 && (v2 & 7) != 5) {
            return v1 == 1 ? 5 : 3;
        }
        return v2 & 7;
    }

    private int q(View view0, int v) {
        g toolbar$g0 = (g)view0.getLayoutParams();
        int v1 = view0.getMeasuredHeight();
        int v2 = v <= 0 ? 0 : (v1 - v) / 2;
        switch(this.r(toolbar$g0.a)) {
            case 0x30: {
                return this.getPaddingTop() - v2;
            }
            case 80: {
                return this.getHeight() - this.getPaddingBottom() - v1 - toolbar$g0.bottomMargin - v2;
            }
            default: {
                int v3 = this.getPaddingTop();
                int v4 = this.getPaddingBottom();
                int v5 = this.getHeight();
                int v6 = (v5 - v3 - v4 - v1) / 2;
                int v7 = toolbar$g0.topMargin;
                if(v6 < v7) {
                    return v3 + v7;
                }
                int v8 = v5 - v4 - v1 - v6 - v3;
                int v9 = toolbar$g0.bottomMargin;
                if(v8 < v9) {
                    v6 = Math.max(0, v6 - (v9 - v8));
                }
                return v3 + v6;
            }
        }
    }

    private int r(int v) {
        int v1 = v & 0x70;
        return v1 == 16 || v1 == 0x30 || v1 == 80 ? v1 : this.w & 0x70;
    }

    private int s(View view0) {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        return androidx.core.view.h.b(viewGroup$MarginLayoutParams0) + androidx.core.view.h.a(viewGroup$MarginLayoutParams0);
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if(this.R != z) {
            this.R = z;
            this.N();
        }
    }

    public void setCollapseContentDescription(int v) {
        this.setCollapseContentDescription((v == 0 ? null : this.getContext().getText(v)));
    }

    public void setCollapseContentDescription(CharSequence charSequence0) {
        if(!TextUtils.isEmpty(charSequence0)) {
            this.e();
        }
        ImageButton imageButton0 = this.h;
        if(imageButton0 != null) {
            imageButton0.setContentDescription(charSequence0);
        }
    }

    public void setCollapseIcon(int v) {
        this.setCollapseIcon(e.a.b(this.getContext(), v));
    }

    public void setCollapseIcon(Drawable drawable0) {
        if(drawable0 != null) {
            this.e();
            this.h.setImageDrawable(drawable0);
            return;
        }
        ImageButton imageButton0 = this.h;
        if(imageButton0 != null) {
            imageButton0.setImageDrawable(this.f);
        }
    }

    public void setCollapsible(boolean z) {
        this.O = z;
        this.requestLayout();
    }

    public void setContentInsetEndWithActions(int v) {
        if(v < 0) {
            v = 0x80000000;
        }
        if(v != this.v) {
            this.v = v;
            if(this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int v) {
        if(v < 0) {
            v = 0x80000000;
        }
        if(v != this.u) {
            this.u = v;
            if(this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }

    public void setLogo(int v) {
        this.setLogo(e.a.b(this.getContext(), v));
    }

    public void setLogo(Drawable drawable0) {
        if(drawable0 != null) {
            this.i();
            if(!this.y(this.e)) {
                this.c(this.e, true);
            }
        }
        else if(this.e != null && this.y(this.e)) {
            this.removeView(this.e);
            this.E.remove(this.e);
        }
        ImageView imageView0 = this.e;
        if(imageView0 != null) {
            imageView0.setImageDrawable(drawable0);
        }
    }

    public void setLogoDescription(int v) {
        this.setLogoDescription(this.getContext().getText(v));
    }

    public void setLogoDescription(CharSequence charSequence0) {
        if(!TextUtils.isEmpty(charSequence0)) {
            this.i();
        }
        ImageView imageView0 = this.e;
        if(imageView0 != null) {
            imageView0.setContentDescription(charSequence0);
        }
    }

    public void setNavigationContentDescription(int v) {
        this.setNavigationContentDescription((v == 0 ? null : this.getContext().getText(v)));
    }

    public void setNavigationContentDescription(CharSequence charSequence0) {
        if(!TextUtils.isEmpty(charSequence0)) {
            this.l();
        }
        ImageButton imageButton0 = this.d;
        if(imageButton0 != null) {
            imageButton0.setContentDescription(charSequence0);
            p0.a(this.d, charSequence0);
        }
    }

    public void setNavigationIcon(int v) {
        this.setNavigationIcon(e.a.b(this.getContext(), v));
    }

    public void setNavigationIcon(Drawable drawable0) {
        if(drawable0 != null) {
            this.l();
            if(!this.y(this.d)) {
                this.c(this.d, true);
            }
        }
        else if(this.d != null && this.y(this.d)) {
            this.removeView(this.d);
            this.E.remove(this.d);
        }
        ImageButton imageButton0 = this.d;
        if(imageButton0 != null) {
            imageButton0.setImageDrawable(drawable0);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener view$OnClickListener0) {
        this.l();
        this.d.setOnClickListener(view$OnClickListener0);
    }

    public void setOnMenuItemClickListener(h toolbar$h0) {
    }

    public void setOverflowIcon(Drawable drawable0) {
        this.j();
        this.a.setOverflowIcon(drawable0);
    }

    public void setPopupTheme(int v) {
        if(this.k != v) {
            this.k = v;
            if(v == 0) {
                this.j = this.getContext();
                return;
            }
            this.j = new ContextThemeWrapper(this.getContext(), v);
        }
    }

    public void setSubtitle(int v) {
        this.setSubtitle(this.getContext().getText(v));
    }

    public void setSubtitle(CharSequence charSequence0) {
        if(!TextUtils.isEmpty(charSequence0)) {
            if(this.c == null) {
                Context context0 = this.getContext();
                p p0 = new p(context0);
                this.c = p0;
                p0.setSingleLine();
                this.c.setEllipsize(TextUtils.TruncateAt.END);
                int v = this.m;
                if(v != 0) {
                    this.c.setTextAppearance(context0, v);
                }
                ColorStateList colorStateList0 = this.A;
                if(colorStateList0 != null) {
                    this.c.setTextColor(colorStateList0);
                }
            }
            if(!this.y(this.c)) {
                this.c(this.c, true);
            }
        }
        else if(this.c != null && this.y(this.c)) {
            this.removeView(this.c);
            this.E.remove(this.c);
        }
        TextView textView0 = this.c;
        if(textView0 != null) {
            textView0.setText(charSequence0);
        }
        this.y = charSequence0;
    }

    public void setSubtitleTextColor(int v) {
        this.setSubtitleTextColor(ColorStateList.valueOf(v));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList0) {
        this.A = colorStateList0;
        TextView textView0 = this.c;
        if(textView0 != null) {
            textView0.setTextColor(colorStateList0);
        }
    }

    public void setTitle(int v) {
        this.setTitle(this.getContext().getText(v));
    }

    public void setTitle(CharSequence charSequence0) {
        if(!TextUtils.isEmpty(charSequence0)) {
            if(this.b == null) {
                Context context0 = this.getContext();
                p p0 = new p(context0);
                this.b = p0;
                p0.setSingleLine();
                this.b.setEllipsize(TextUtils.TruncateAt.END);
                int v = this.l;
                if(v != 0) {
                    this.b.setTextAppearance(context0, v);
                }
                ColorStateList colorStateList0 = this.z;
                if(colorStateList0 != null) {
                    this.b.setTextColor(colorStateList0);
                }
            }
            if(!this.y(this.b)) {
                this.c(this.b, true);
            }
        }
        else if(this.b != null && this.y(this.b)) {
            this.removeView(this.b);
            this.E.remove(this.b);
        }
        TextView textView0 = this.b;
        if(textView0 != null) {
            textView0.setText(charSequence0);
        }
        this.x = charSequence0;
    }

    public void setTitleMarginBottom(int v) {
        this.s = v;
        this.requestLayout();
    }

    public void setTitleMarginEnd(int v) {
        this.q = v;
        this.requestLayout();
    }

    public void setTitleMarginStart(int v) {
        this.p = v;
        this.requestLayout();
    }

    public void setTitleMarginTop(int v) {
        this.r = v;
        this.requestLayout();
    }

    public void setTitleTextColor(int v) {
        this.setTitleTextColor(ColorStateList.valueOf(v));
    }

    public void setTitleTextColor(ColorStateList colorStateList0) {
        this.z = colorStateList0;
        TextView textView0 = this.b;
        if(textView0 != null) {
            textView0.setTextColor(colorStateList0);
        }
    }

    private int t(View view0) {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        return viewGroup$MarginLayoutParams0.topMargin + viewGroup$MarginLayoutParams0.bottomMargin;
    }

    private int u(List list0, int[] arr_v) {
        int v = arr_v[0];
        int v1 = arr_v[1];
        int v2 = list0.size();
        int v3 = 0;
        int v4 = 0;
        while(v3 < v2) {
            View view0 = (View)list0.get(v3);
            g toolbar$g0 = (g)view0.getLayoutParams();
            int v5 = toolbar$g0.leftMargin - v;
            int v6 = toolbar$g0.rightMargin - v1;
            v4 += Math.max(0, v5) + view0.getMeasuredWidth() + Math.max(0, v6);
            ++v3;
            v1 = Math.max(0, -v6);
            v = Math.max(0, -v5);
        }
        return v4;
    }

    public boolean v() {
        return this.L != null && this.L.b != null;
    }

    public void w(int v) {
        this.getMenuInflater().inflate(v, this.getMenu());
    }

    // 检测为 Lambda 实现
    public void x() [...]

    private boolean y(View view0) {
        return view0.getParent() == this || this.E.contains(view0);
    }

    public boolean z() {
        return this.a != null && this.a.F();
    }
}

