package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.b0;
import androidx.core.view.v;
import c.f;
import java.util.ArrayList;
import java.util.List;

final class c extends g implements View.OnKeyListener, PopupWindow.OnDismissListener {
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        final c a;

        @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onGlobalLayout() {
            if(c.this.f() && c.this.i.size() > 0 && !((d)c.this.i.get(0)).a.n()) {
                View view0 = c.this.p;
                if(view0 != null && view0.isShown()) {
                    for(Object object0: c.this.i) {
                        ((d)object0).a.b();
                    }
                    return;
                }
                c.this.dismiss();
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        final c a;

        @Override  // android.view.View$OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view0) {
        }

        @Override  // android.view.View$OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view0) {
            ViewTreeObserver viewTreeObserver0 = c.this.y;
            if(viewTreeObserver0 != null) {
                if(!viewTreeObserver0.isAlive()) {
                    c.this.y = view0.getViewTreeObserver();
                }
                c.this.y.removeGlobalOnLayoutListener(c.this.j);
            }
            view0.removeOnAttachStateChangeListener(this);
        }
    }

    class androidx.appcompat.view.menu.c.c implements a0 {
        final c a;

        @Override  // androidx.appcompat.widget.a0
        public void a(e e0, MenuItem menuItem0) {
            class androidx.appcompat.view.menu.c.c.a implements Runnable {
                final d e;
                final MenuItem f;
                final e g;
                final androidx.appcompat.view.menu.c.c h;

                androidx.appcompat.view.menu.c.c.a(d c$d0, MenuItem menuItem0, e e0) {
                    this.e = c$d0;
                    this.f = menuItem0;
                    this.g = e0;
                    super();
                }

                @Override
                public void run() {
                    d c$d0 = this.e;
                    if(c$d0 != null) {
                        c.this.A = true;
                        c$d0.b.d(false);
                        c.this.A = false;
                    }
                    if(this.f.isEnabled() && this.f.hasSubMenu()) {
                        this.g.H(this.f, 4);
                    }
                }
            }

            d c$d0 = null;
            c.this.g.removeCallbacksAndMessages(null);
            int v = c.this.i.size();
            int v1;
            for(v1 = 0; true; ++v1) {
                if(v1 >= v) {
                    v1 = -1;
                    break;
                }
                if(e0 == ((d)c.this.i.get(v1)).b) {
                    break;
                }
            }
            if(v1 == -1) {
                return;
            }
            if(v1 + 1 < c.this.i.size()) {
                c$d0 = (d)c.this.i.get(v1 + 1);
            }
            androidx.appcompat.view.menu.c.c.a c$c$a0 = new androidx.appcompat.view.menu.c.c.a(this, c$d0, menuItem0, e0);
            long v2 = SystemClock.uptimeMillis();
            c.this.g.postAtTime(c$c$a0, e0, v2 + 200L);
        }

        @Override  // androidx.appcompat.widget.a0
        public void c(e e0, MenuItem menuItem0) {
            c.this.g.removeCallbacksAndMessages(e0);
        }
    }

    static class d {
        public final b0 a;
        public final e b;
        public final int c;

        public d(b0 b00, e e0, int v) {
            this.a = b00;
            this.b = e0;
            this.c = v;
        }

        public ListView a() {
            return this.a.g();
        }
    }

    boolean A;
    private static final int B;
    private final Context b;
    private final int c;
    private final int d;
    private final int e;
    private final boolean f;
    final Handler g;
    private final List h;
    final List i;
    final ViewTreeObserver.OnGlobalLayoutListener j;
    private final View.OnAttachStateChangeListener k;
    private final a0 l;
    private int m;
    private int n;
    private View o;
    View p;
    private int q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private androidx.appcompat.view.menu.i.a x;
    ViewTreeObserver y;
    private PopupWindow.OnDismissListener z;

    static {
        c.B = f.e;
    }

    public c(Context context0, View view0, int v, int v1, boolean z) {
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new a(this);
        this.k = new b(this);
        this.l = new androidx.appcompat.view.menu.c.c(this);
        this.m = 0;
        this.n = 0;
        this.b = context0;
        this.o = view0;
        this.d = v;
        this.e = v1;
        this.f = z;
        this.v = false;
        this.q = this.D();
        Resources resources0 = context0.getResources();
        this.c = Math.max(resources0.getDisplayMetrics().widthPixels / 2, resources0.getDimensionPixelSize(c.c.b));
        this.g = new Handler();
    }

    private int A(e e0) {
        int v = this.i.size();
        for(int v1 = 0; v1 < v; ++v1) {
            if(e0 == ((d)this.i.get(v1)).b) {
                return v1;
            }
        }
        return -1;
    }

    private MenuItem B(e e0, e e1) {
        int v = e0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            MenuItem menuItem0 = e0.getItem(v1);
            if(menuItem0.hasSubMenu() && e1 == menuItem0.getSubMenu()) {
                return menuItem0;
            }
        }
        return null;
    }

    private View C(d c$d0, e e0) {
        androidx.appcompat.view.menu.d d0;
        int v1;
        MenuItem menuItem0 = this.B(c$d0.b, e0);
        if(menuItem0 == null) {
            return null;
        }
        ListView listView0 = c$d0.a();
        ListAdapter listAdapter0 = listView0.getAdapter();
        int v = 0;
        if(listAdapter0 instanceof HeaderViewListAdapter) {
            v1 = ((HeaderViewListAdapter)listAdapter0).getHeadersCount();
            d0 = (androidx.appcompat.view.menu.d)((HeaderViewListAdapter)listAdapter0).getWrappedAdapter();
        }
        else {
            d0 = (androidx.appcompat.view.menu.d)listAdapter0;
            v1 = 0;
        }
        int v2 = d0.getCount();
        while(true) {
            if(v >= v2) {
                v = -1;
                break;
            }
            if(menuItem0 == d0.c(v)) {
                break;
            }
            ++v;
        }
        if(v == -1) {
            return null;
        }
        int v3 = v + v1 - listView0.getFirstVisiblePosition();
        return v3 < 0 || v3 >= listView0.getChildCount() ? null : listView0.getChildAt(v3);
    }

    private int D() {
        return v.o(this.o) == 1 ? 0 : 1;
    }

    private int E(int v) {
        ListView listView0 = ((d)this.i.get(this.i.size() - 1)).a();
        int[] arr_v = new int[2];
        listView0.getLocationOnScreen(arr_v);
        Rect rect0 = new Rect();
        this.p.getWindowVisibleDisplayFrame(rect0);
        if(this.q == 1) {
            return arr_v[0] + listView0.getWidth() + v <= rect0.right ? 1 : 0;
        }
        return arr_v[0] - v >= 0 ? 0 : 1;
    }

    private void F(e e0) {
        int v4;
        int v3;
        int v2;
        View view0;
        d c$d0;
        LayoutInflater layoutInflater0 = LayoutInflater.from(this.b);
        androidx.appcompat.view.menu.d d0 = new androidx.appcompat.view.menu.d(e0, layoutInflater0, this.f, c.B);
        if(!this.f() && this.v) {
            d0.d(true);
        }
        else if(this.f()) {
            d0.d(g.x(e0));
        }
        int v = g.o(d0, null, this.b, this.c);
        b0 b00 = this.z();
        b00.p(d0);
        b00.s(v);
        b00.t(this.n);
        if(this.i.size() > 0) {
            c$d0 = (d)this.i.get(this.i.size() - 1);
            view0 = this.C(c$d0, e0);
        }
        else {
            c$d0 = null;
            view0 = null;
        }
        if(view0 == null) {
            if(this.r) {
                b00.v(this.t);
            }
            if(this.s) {
                b00.C(this.u);
            }
            b00.u(this.n());
        }
        else {
            b00.H(false);
            b00.E(null);
            int v1 = this.E(v);
            this.q = v1;
            if(Build.VERSION.SDK_INT >= 26) {
                b00.q(view0);
                v2 = 0;
                v3 = 0;
            }
            else {
                int[] arr_v = new int[2];
                this.o.getLocationOnScreen(arr_v);
                int[] arr_v1 = new int[2];
                view0.getLocationOnScreen(arr_v1);
                if((this.n & 7) == 5) {
                    arr_v[0] += this.o.getWidth();
                    arr_v1[0] += view0.getWidth();
                }
                v3 = arr_v1[0] - arr_v[0];
                v2 = arr_v1[1] - arr_v[1];
            }
            if((this.n & 5) != 5) {
                v4 = v1 == 1 ? v3 + view0.getWidth() : v3 - v;
            }
            else if(v1 != 1) {
                v4 = v3 - view0.getWidth();
            }
            else {
                v4 = v3 + v;
            }
            b00.v(v4);
            b00.A(true);
            b00.C(v2);
        }
        d c$d1 = new d(b00, e0, this.q);
        this.i.add(c$d1);
        b00.b();
        ListView listView0 = b00.g();
        listView0.setOnKeyListener(this);
        if(c$d0 == null && this.w && e0.u() != null) {
            FrameLayout frameLayout0 = (FrameLayout)layoutInflater0.inflate(f.i, listView0, false);
            TextView textView0 = (TextView)frameLayout0.findViewById(0x1020016);
            frameLayout0.setEnabled(false);
            textView0.setText(e0.u());
            listView0.addHeaderView(frameLayout0, null, false);
            b00.b();
        }
    }

    @Override  // androidx.appcompat.view.menu.i
    public void a(e e0, boolean z) {
        int v = this.A(e0);
        if(v < 0) {
            return;
        }
        if(v + 1 < this.i.size()) {
            ((d)this.i.get(v + 1)).b.d(false);
        }
        d c$d0 = (d)this.i.remove(v);
        c$d0.b.K(this);
        if(this.A) {
            c$d0.a.F(null);
            c$d0.a.r(0);
        }
        c$d0.a.dismiss();
        int v1 = this.i.size();
        this.q = v1 <= 0 ? this.D() : ((d)this.i.get(v1 - 1)).c;
        if(v1 == 0) {
            this.dismiss();
            androidx.appcompat.view.menu.i.a i$a0 = this.x;
            if(i$a0 != null) {
                i$a0.a(e0, true);
            }
            ViewTreeObserver viewTreeObserver0 = this.y;
            if(viewTreeObserver0 != null) {
                if(viewTreeObserver0.isAlive()) {
                    this.y.removeGlobalOnLayoutListener(this.j);
                }
                this.y = null;
            }
            this.p.removeOnAttachStateChangeListener(this.k);
            this.z.onDismiss();
            return;
        }
        if(z) {
            ((d)this.i.get(0)).b.d(false);
        }
    }

    @Override  // androidx.appcompat.view.menu.k
    public void b() {
        if(this.f()) {
            return;
        }
        for(Object object0: this.h) {
            this.F(((e)object0));
        }
        this.h.clear();
        View view0 = this.o;
        this.p = view0;
        if(view0 != null) {
            boolean z = this.y == null;
            ViewTreeObserver viewTreeObserver0 = view0.getViewTreeObserver();
            this.y = viewTreeObserver0;
            if(z) {
                viewTreeObserver0.addOnGlobalLayoutListener(this.j);
            }
            this.p.addOnAttachStateChangeListener(this.k);
        }
    }

    @Override  // androidx.appcompat.view.menu.i
    public boolean c() {
        return false;
    }

    @Override  // androidx.appcompat.view.menu.k
    public void dismiss() {
        int v = this.i.size();
        if(v > 0) {
            d[] arr_c$d = (d[])this.i.toArray(new d[v]);
            for(int v1 = v - 1; v1 >= 0; --v1) {
                d c$d0 = arr_c$d[v1];
                if(c$d0.a.f()) {
                    c$d0.a.dismiss();
                }
            }
        }
    }

    @Override  // androidx.appcompat.view.menu.k
    public boolean f() {
        return this.i.size() > 0 && ((d)this.i.get(0)).a.f();
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.appcompat.view.menu.k
    public ListView g() {
        return this.i.isEmpty() ? null : ((d)this.i.get(this.i.size() - 1)).a();
    }

    @Override  // androidx.appcompat.view.menu.i
    public void i(androidx.appcompat.view.menu.i.a i$a0) {
        this.x = i$a0;
    }

    @Override  // androidx.appcompat.view.menu.i
    public boolean j(m m0) {
        for(Object object0: this.i) {
            d c$d0 = (d)object0;
            if(m0 == c$d0.b) {
                c$d0.a().requestFocus();
                return true;
            }
            if(false) {
                break;
            }
        }
        if(m0.hasVisibleItems()) {
            this.l(m0);
            androidx.appcompat.view.menu.i.a i$a0 = this.x;
            if(i$a0 != null) {
                i$a0.b(m0);
            }
            return true;
        }
        return false;
    }

    @Override  // androidx.appcompat.view.menu.i
    public void k(boolean z) {
        for(Object object0: this.i) {
            g.y(((d)object0).a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override  // androidx.appcompat.view.menu.g
    public void l(e e0) {
        e0.b(this, this.b);
        if(this.f()) {
            this.F(e0);
            return;
        }
        this.h.add(e0);
    }

    @Override  // androidx.appcompat.view.menu.g
    protected boolean m() {
        return false;
    }

    @Override  // android.widget.PopupWindow$OnDismissListener
    public void onDismiss() {
        d c$d0;
        int v = this.i.size();
        for(int v1 = 0; true; ++v1) {
            c$d0 = null;
            if(v1 >= v) {
                break;
            }
            d c$d1 = (d)this.i.get(v1);
            if(!c$d1.a.f()) {
                c$d0 = c$d1;
                break;
            }
        }
        if(c$d0 != null) {
            c$d0.b.d(false);
        }
    }

    @Override  // android.view.View$OnKeyListener
    public boolean onKey(View view0, int v, KeyEvent keyEvent0) {
        if(keyEvent0.getAction() == 1 && v == 82) {
            this.dismiss();
            return true;
        }
        return false;
    }

    @Override  // androidx.appcompat.view.menu.g
    public void p(View view0) {
        if(this.o != view0) {
            this.o = view0;
            this.n = androidx.core.view.e.a(this.m, v.o(view0));
        }
    }

    @Override  // androidx.appcompat.view.menu.g
    public void r(boolean z) {
        this.v = z;
    }

    @Override  // androidx.appcompat.view.menu.g
    public void s(int v) {
        if(this.m != v) {
            this.m = v;
            this.n = androidx.core.view.e.a(v, v.o(this.o));
        }
    }

    @Override  // androidx.appcompat.view.menu.g
    public void t(int v) {
        this.r = true;
        this.t = v;
    }

    @Override  // androidx.appcompat.view.menu.g
    public void u(PopupWindow.OnDismissListener popupWindow$OnDismissListener0) {
        this.z = popupWindow$OnDismissListener0;
    }

    @Override  // androidx.appcompat.view.menu.g
    public void v(boolean z) {
        this.w = z;
    }

    @Override  // androidx.appcompat.view.menu.g
    public void w(int v) {
        this.s = true;
        this.u = v;
    }

    private b0 z() {
        b0 b00 = new b0(this.b, null, this.d, this.e);
        b00.G(this.l);
        b00.z(this);
        b00.y(this);
        b00.q(this.o);
        b00.t(this.n);
        b00.x(true);
        b00.w(2);
        return b00;
    }
}

