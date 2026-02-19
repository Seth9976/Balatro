package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AbsListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.k;
import java.lang.reflect.Method;

public abstract class z implements k {
    static abstract class c {
        static int a(PopupWindow popupWindow0, View view0, int v, boolean z) {
            return popupWindow0.getMaxAvailableHeight(view0, v, z);
        }
    }

    static abstract class d {
        static void a(PopupWindow popupWindow0, Rect rect0) {
            popupWindow0.setEpicenterBounds(rect0);
        }

        static void b(PopupWindow popupWindow0, boolean z) {
            popupWindow0.setIsClippedToScreen(z);
        }
    }

    class e implements Runnable {
        final z e;

        @Override
        public void run() {
            z.this.e();
        }
    }

    class f extends DataSetObserver {
        final z a;

        @Override  // android.database.DataSetObserver
        public void onChanged() {
            if(z.this.f()) {
                z.this.b();
            }
        }

        @Override  // android.database.DataSetObserver
        public void onInvalidated() {
            z.this.dismiss();
        }
    }

    class g implements AbsListView.OnScrollListener {
        final z a;

        @Override  // android.widget.AbsListView$OnScrollListener
        public void onScroll(AbsListView absListView0, int v, int v1, int v2) {
        }

        @Override  // android.widget.AbsListView$OnScrollListener
        public void onScrollStateChanged(AbsListView absListView0, int v) {
            if(v == 1 && !z.this.m() && z.this.F.getContentView() != null) {
                z.this.B.removeCallbacks(z.this.w);
                z.this.w.run();
            }
        }
    }

    class h implements View.OnTouchListener {
        final z a;

        @Override  // android.view.View$OnTouchListener
        public boolean onTouch(View view0, MotionEvent motionEvent0) {
            int v = motionEvent0.getAction();
            int v1 = (int)motionEvent0.getX();
            int v2 = (int)motionEvent0.getY();
            if(v == 0) {
                PopupWindow popupWindow0 = z.this.F;
                if(popupWindow0 != null && popupWindow0.isShowing() && v1 >= 0 && v1 < z.this.F.getWidth() && v2 >= 0 && v2 < z.this.F.getHeight()) {
                    z.this.B.postDelayed(z.this.w, 0xFAL);
                    return false;
                }
            }
            if(v == 1) {
                z.this.B.removeCallbacks(z.this.w);
            }
            return false;
        }
    }

    class i implements Runnable {
        final z e;

        @Override
        public void run() {
            v v0 = z.this.c;
            if(v0 != null && androidx.core.view.v.v(v0) && z.this.c.getCount() > z.this.c.getChildCount()) {
                int v1 = z.this.c.getChildCount();
                z z0 = z.this;
                if(v1 <= z0.o) {
                    z0.F.setInputMethodMode(2);
                    z.this.b();
                }
            }
        }
    }

    private Runnable A;
    final Handler B;
    private final Rect C;
    private Rect D;
    private boolean E;
    PopupWindow F;
    private static Method G;
    private static Method H;
    private static Method I;
    private Context a;
    private ListAdapter b;
    v c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private boolean m;
    private boolean n;
    int o;
    private View p;
    private int q;
    private DataSetObserver r;
    private View s;
    private Drawable t;
    private AdapterView.OnItemClickListener u;
    private AdapterView.OnItemSelectedListener v;
    final i w;
    private final h x;
    private final g y;
    private final e z;

    static {
        Class class0 = PopupWindow.class;
        if(Build.VERSION.SDK_INT <= 28) {
            try {
                z.G = class0.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            }
            catch(NoSuchMethodException unused_ex) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                z.I = class0.getDeclaredMethod("setEpicenterBounds", Rect.class);
            }
            catch(NoSuchMethodException unused_ex) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if(Build.VERSION.SDK_INT <= 23) {
            try {
                z.H = class0.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            }
            catch(NoSuchMethodException unused_ex) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public z(Context context0, AttributeSet attributeSet0, int v, int v1) {
        this.d = -2;
        this.e = -2;
        this.h = 1002;
        this.l = 0;
        this.m = false;
        this.n = false;
        this.o = 0x7FFFFFFF;
        this.q = 0;
        this.w = new i(this);
        this.x = new h(this);
        this.y = new g(this);
        this.z = () -> {
            v v0 = z.this.c;
            if(v0 != null) {
                v0.setListSelectionHidden(true);
                v0.requestLayout();
            }
        };
        this.C = new Rect();
        this.a = context0;
        this.B = new Handler(context0.getMainLooper());
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, c.i.C0, v, v1);
        this.f = typedArray0.getDimensionPixelOffset(c.i.D0, 0);
        int v2 = typedArray0.getDimensionPixelOffset(c.i.E0, 0);
        this.g = v2;
        if(v2 != 0) {
            this.i = true;
        }
        typedArray0.recycle();
        m m0 = new m(context0, attributeSet0, v, v1);
        this.F = m0;
        m0.setInputMethodMode(1);
    }

    public void A(boolean z) {
        this.k = true;
        this.j = z;
    }

    private void B(boolean z) {
        if(Build.VERSION.SDK_INT <= 28) {
            Method method0 = z.G;
            if(method0 != null) {
                try {
                    method0.invoke(this.F, Boolean.valueOf(z));
                }
                catch(Exception unused_ex) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        }
        else {
            d.b(this.F, z);
        }
    }

    public void C(int v) {
        this.g = v;
        this.i = true;
    }

    public void D(int v) {
        this.e = v;
    }

    @Override  // androidx.appcompat.view.menu.k
    public void b() {
        int v = this.d();
        boolean z = this.m();
        androidx.core.widget.f.b(this.F, this.h);
        boolean z1 = true;
        if(this.F.isShowing()) {
            if(!androidx.core.view.v.v(this.i())) {
                return;
            }
            int v1 = this.e;
            if(v1 == -1) {
                v1 = -1;
            }
            else if(v1 == -2) {
                v1 = this.i().getWidth();
            }
            int v2 = this.d;
            if(v2 == -1) {
                if(!z) {
                    v = -1;
                }
                if(z) {
                    this.F.setWidth((this.e == -1 ? -1 : 0));
                    this.F.setHeight(0);
                }
                else {
                    this.F.setWidth((this.e == -1 ? -1 : 0));
                    this.F.setHeight(-1);
                }
            }
            else if(v2 != -2) {
                v = v2;
            }
            PopupWindow popupWindow0 = this.F;
            if(this.n || this.m) {
                z1 = false;
            }
            popupWindow0.setOutsideTouchable(z1);
            this.F.update(this.i(), this.f, this.g, (v1 >= 0 ? v1 : -1), (v >= 0 ? v : -1));
            return;
        }
        int v3 = this.e;
        if(v3 == -1) {
            v3 = -1;
        }
        else if(v3 == -2) {
            v3 = this.i().getWidth();
        }
        int v4 = this.d;
        if(v4 == -1) {
            v = -1;
        }
        else if(v4 != -2) {
            v = v4;
        }
        this.F.setWidth(v3);
        this.F.setHeight(v);
        this.B(true);
        this.F.setOutsideTouchable(!this.n && !this.m);
        this.F.setTouchInterceptor(this.x);
        if(this.k) {
            androidx.core.widget.f.a(this.F, this.j);
        }
        if(Build.VERSION.SDK_INT <= 28) {
            Method method0 = z.I;
            if(method0 != null) {
                try {
                    method0.invoke(this.F, this.D);
                }
                catch(Exception exception0) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", exception0);
                }
            }
        }
        else {
            d.a(this.F, this.D);
        }
        androidx.core.widget.f.c(this.F, this.i(), this.f, this.g, this.l);
        this.c.setSelection(-1);
        if(!this.E || this.c.isInTouchMode()) {
            this.e();
        }
        if(!this.E) {
            this.B.post(this.z);
        }
    }

    private int d() {
        class a implements Runnable {
            final z e;

            @Override
            public void run() {
                View view0 = z.this.i();
                if(view0 != null && view0.getWindowToken() != null) {
                    z.this.b();
                }
            }
        }


        class b implements AdapterView.OnItemSelectedListener {
            final z a;

            @Override  // android.widget.AdapterView$OnItemSelectedListener
            public void onItemSelected(AdapterView adapterView0, View view0, int v, long v1) {
                if(v != -1) {
                    v v2 = z.this.c;
                    if(v2 != null) {
                        v2.setListSelectionHidden(false);
                    }
                }
            }

            @Override  // android.widget.AdapterView$OnItemSelectedListener
            public void onNothingSelected(AdapterView adapterView0) {
            }
        }

        int v9;
        int v6;
        int v4;
        int v3;
        boolean z = true;
        if(this.c == null) {
            Context context0 = this.a;
            this.A = new a(this);
            v v0 = this.h(context0, !this.E);
            this.c = v0;
            Drawable drawable0 = this.t;
            if(drawable0 != null) {
                v0.setSelector(drawable0);
            }
            this.c.setAdapter(this.b);
            this.c.setOnItemClickListener(this.u);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new b(this));
            this.c.setOnScrollListener(this.y);
            AdapterView.OnItemSelectedListener adapterView$OnItemSelectedListener0 = this.v;
            if(adapterView$OnItemSelectedListener0 != null) {
                this.c.setOnItemSelectedListener(adapterView$OnItemSelectedListener0);
            }
            v v1 = this.c;
            View view0 = this.p;
            if(view0 == null) {
                v4 = 0;
            }
            else {
                LinearLayout linearLayout0 = new LinearLayout(context0);
                linearLayout0.setOrientation(1);
                LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch(this.q) {
                    case 0: {
                        linearLayout0.addView(view0);
                        linearLayout0.addView(v1, linearLayout$LayoutParams0);
                        break;
                    }
                    case 1: {
                        linearLayout0.addView(v1, linearLayout$LayoutParams0);
                        linearLayout0.addView(view0);
                        break;
                    }
                    default: {
                        Log.e("ListPopupWindow", "Invalid hint position " + this.q);
                    }
                }
                int v2 = this.e;
                if(v2 >= 0) {
                    v3 = 0x80000000;
                }
                else {
                    v2 = 0;
                    v3 = 0;
                }
                view0.measure(View.MeasureSpec.makeMeasureSpec(v2, v3), 0);
                LinearLayout.LayoutParams linearLayout$LayoutParams1 = (LinearLayout.LayoutParams)view0.getLayoutParams();
                v4 = view0.getMeasuredHeight() + linearLayout$LayoutParams1.topMargin + linearLayout$LayoutParams1.bottomMargin;
                v1 = linearLayout0;
            }
            this.F.setContentView(v1);
        }
        else {
            ViewGroup viewGroup0 = (ViewGroup)this.F.getContentView();
            View view1 = this.p;
            if(view1 == null) {
                v4 = 0;
            }
            else {
                LinearLayout.LayoutParams linearLayout$LayoutParams2 = (LinearLayout.LayoutParams)view1.getLayoutParams();
                v4 = view1.getMeasuredHeight() + linearLayout$LayoutParams2.topMargin + linearLayout$LayoutParams2.bottomMargin;
            }
        }
        Drawable drawable1 = this.F.getBackground();
        if(drawable1 == null) {
            this.C.setEmpty();
            v6 = 0;
        }
        else {
            drawable1.getPadding(this.C);
            int v5 = this.C.top;
            v6 = this.C.bottom + v5;
            if(!this.i) {
                this.g = -v5;
            }
        }
        if(this.F.getInputMethodMode() != 2) {
            z = false;
        }
        int v7 = this.k(this.i(), this.g, z);
        if(!this.m && this.d != -1) {
            int v8 = this.e;
            switch(v8) {
                case -2: {
                    v9 = View.MeasureSpec.makeMeasureSpec(this.a.getResources().getDisplayMetrics().widthPixels - (this.C.left + this.C.right), 0x80000000);
                    break;
                }
                case -1: {
                    v9 = View.MeasureSpec.makeMeasureSpec(this.a.getResources().getDisplayMetrics().widthPixels - (this.C.left + this.C.right), 0x40000000);
                    break;
                }
                default: {
                    v9 = View.MeasureSpec.makeMeasureSpec(v8, 0x40000000);
                }
            }
            int v10 = this.c.d(v9, 0, -1, v7 - v4, -1);
            if(v10 > 0) {
                v4 += v6 + (this.c.getPaddingTop() + this.c.getPaddingBottom());
            }
            return v10 + v4;
        }
        return v7 + v6;
    }

    @Override  // androidx.appcompat.view.menu.k
    public void dismiss() {
        this.F.dismiss();
        this.o();
        this.F.setContentView(null);
        this.c = null;
        this.B.removeCallbacks(this.w);
    }

    // 检测为 Lambda 实现
    public void e() [...]

    @Override  // androidx.appcompat.view.menu.k
    public boolean f() {
        return this.F.isShowing();
    }

    @Override  // androidx.appcompat.view.menu.k
    public ListView g() {
        return this.c;
    }

    abstract v h(Context arg1, boolean arg2);

    public View i() {
        return this.s;
    }

    public int j() {
        return this.f;
    }

    private int k(View view0, int v, boolean z) {
        if(Build.VERSION.SDK_INT <= 23) {
            Method method0 = z.H;
            if(method0 != null) {
                try {
                    return (int)(((Integer)method0.invoke(this.F, view0, v, Boolean.valueOf(z))));
                }
                catch(Exception unused_ex) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            return this.F.getMaxAvailableHeight(view0, v);
        }
        return c.a(this.F, view0, v, z);
    }

    public int l() {
        return this.i ? this.g : 0;
    }

    public boolean m() {
        return this.F.getInputMethodMode() == 2;
    }

    public boolean n() {
        return this.E;
    }

    private void o() {
        View view0 = this.p;
        if(view0 != null) {
            ViewParent viewParent0 = view0.getParent();
            if(viewParent0 instanceof ViewGroup) {
                ((ViewGroup)viewParent0).removeView(this.p);
            }
        }
    }

    public void p(ListAdapter listAdapter0) {
        DataSetObserver dataSetObserver0 = this.r;
        if(dataSetObserver0 == null) {
            this.r = new f(this);
        }
        else {
            ListAdapter listAdapter1 = this.b;
            if(listAdapter1 != null) {
                listAdapter1.unregisterDataSetObserver(dataSetObserver0);
            }
        }
        this.b = listAdapter0;
        if(listAdapter0 != null) {
            listAdapter0.registerDataSetObserver(this.r);
        }
        v v0 = this.c;
        if(v0 != null) {
            v0.setAdapter(this.b);
        }
    }

    public void q(View view0) {
        this.s = view0;
    }

    public void r(int v) {
        this.F.setAnimationStyle(v);
    }

    public void s(int v) {
        Drawable drawable0 = this.F.getBackground();
        if(drawable0 != null) {
            drawable0.getPadding(this.C);
            this.e = this.C.left + this.C.right + v;
            return;
        }
        this.D(v);
    }

    public void t(int v) {
        this.l = v;
    }

    public void u(Rect rect0) {
        this.D = rect0 == null ? null : new Rect(rect0);
    }

    public void v(int v) {
        this.f = v;
    }

    public void w(int v) {
        this.F.setInputMethodMode(v);
    }

    public void x(boolean z) {
        this.E = z;
        this.F.setFocusable(z);
    }

    public void y(PopupWindow.OnDismissListener popupWindow$OnDismissListener0) {
        this.F.setOnDismissListener(popupWindow$OnDismissListener0);
    }

    public void z(AdapterView.OnItemClickListener adapterView$OnItemClickListener0) {
        this.u = adapterView$OnItemClickListener0;
    }
}

