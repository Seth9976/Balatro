package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.widget.b0;
import androidx.core.view.v;
import c.c;
import c.f;

final class l extends g implements View.OnKeyListener, PopupWindow.OnDismissListener {
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        final l a;

        @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onGlobalLayout() {
            if(l.this.f() && !l.this.i.n()) {
                View view0 = l.this.n;
                if(view0 != null && view0.isShown()) {
                    l.this.i.b();
                    return;
                }
                l.this.dismiss();
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        final l a;

        @Override  // android.view.View$OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view0) {
        }

        @Override  // android.view.View$OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view0) {
            ViewTreeObserver viewTreeObserver0 = l.this.p;
            if(viewTreeObserver0 != null) {
                if(!viewTreeObserver0.isAlive()) {
                    l.this.p = view0.getViewTreeObserver();
                }
                l.this.p.removeGlobalOnLayoutListener(l.this.j);
            }
            view0.removeOnAttachStateChangeListener(this);
        }
    }

    private final Context b;
    private final e c;
    private final d d;
    private final boolean e;
    private final int f;
    private final int g;
    private final int h;
    final b0 i;
    final ViewTreeObserver.OnGlobalLayoutListener j;
    private final View.OnAttachStateChangeListener k;
    private PopupWindow.OnDismissListener l;
    private View m;
    View n;
    private androidx.appcompat.view.menu.i.a o;
    ViewTreeObserver p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private boolean u;
    private static final int v;

    static {
        l.v = f.j;
    }

    public l(Context context0, e e0, View view0, int v, int v1, boolean z) {
        this.j = new a(this);
        this.k = new b(this);
        this.t = 0;
        this.b = context0;
        this.c = e0;
        this.e = z;
        this.d = new d(e0, LayoutInflater.from(context0), z, l.v);
        this.g = v;
        this.h = v1;
        Resources resources0 = context0.getResources();
        this.f = Math.max(resources0.getDisplayMetrics().widthPixels / 2, resources0.getDimensionPixelSize(c.b));
        this.m = view0;
        this.i = new b0(context0, null, v, v1);
        e0.b(this, context0);
    }

    @Override  // androidx.appcompat.view.menu.i
    public void a(e e0, boolean z) {
        if(e0 != this.c) {
            return;
        }
        this.dismiss();
        androidx.appcompat.view.menu.i.a i$a0 = this.o;
        if(i$a0 != null) {
            i$a0.a(e0, z);
        }
    }

    @Override  // androidx.appcompat.view.menu.k
    public void b() {
        if(!this.z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override  // androidx.appcompat.view.menu.i
    public boolean c() {
        return false;
    }

    @Override  // androidx.appcompat.view.menu.k
    public void dismiss() {
        if(this.f()) {
            this.i.dismiss();
        }
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.appcompat.view.menu.k
    public boolean f() {
        return !this.q && this.i.f();
    }

    @Override  // androidx.appcompat.view.menu.k
    public ListView g() {
        return this.i.g();
    }

    @Override  // androidx.appcompat.view.menu.i
    public void i(androidx.appcompat.view.menu.i.a i$a0) {
        this.o = i$a0;
    }

    @Override  // androidx.appcompat.view.menu.i
    public boolean j(m m0) {
        if(m0.hasVisibleItems()) {
            h h0 = new h(this.b, m0, this.n, this.e, this.g, this.h);
            h0.j(this.o);
            h0.g(g.x(m0));
            h0.i(this.l);
            this.l = null;
            this.c.d(false);
            int v = this.i.j();
            int v1 = this.i.l();
            if((Gravity.getAbsoluteGravity(this.t, v.o(this.m)) & 7) == 5) {
                v += this.m.getWidth();
            }
            if(h0.n(v, v1)) {
                androidx.appcompat.view.menu.i.a i$a0 = this.o;
                if(i$a0 != null) {
                    i$a0.b(m0);
                }
                return true;
            }
        }
        return false;
    }

    @Override  // androidx.appcompat.view.menu.i
    public void k(boolean z) {
        this.r = false;
        d d0 = this.d;
        if(d0 != null) {
            d0.notifyDataSetChanged();
        }
    }

    @Override  // androidx.appcompat.view.menu.g
    public void l(e e0) {
    }

    @Override  // android.widget.PopupWindow$OnDismissListener
    public void onDismiss() {
        this.q = true;
        this.c.close();
        ViewTreeObserver viewTreeObserver0 = this.p;
        if(viewTreeObserver0 != null) {
            if(!viewTreeObserver0.isAlive()) {
                this.p = this.n.getViewTreeObserver();
            }
            this.p.removeGlobalOnLayoutListener(this.j);
            this.p = null;
        }
        this.n.removeOnAttachStateChangeListener(this.k);
        PopupWindow.OnDismissListener popupWindow$OnDismissListener0 = this.l;
        if(popupWindow$OnDismissListener0 != null) {
            popupWindow$OnDismissListener0.onDismiss();
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
        this.m = view0;
    }

    @Override  // androidx.appcompat.view.menu.g
    public void r(boolean z) {
        this.d.d(z);
    }

    @Override  // androidx.appcompat.view.menu.g
    public void s(int v) {
        this.t = v;
    }

    @Override  // androidx.appcompat.view.menu.g
    public void t(int v) {
        this.i.v(v);
    }

    @Override  // androidx.appcompat.view.menu.g
    public void u(PopupWindow.OnDismissListener popupWindow$OnDismissListener0) {
        this.l = popupWindow$OnDismissListener0;
    }

    @Override  // androidx.appcompat.view.menu.g
    public void v(boolean z) {
        this.u = z;
    }

    @Override  // androidx.appcompat.view.menu.g
    public void w(int v) {
        this.i.C(v);
    }

    private boolean z() {
        if(this.f()) {
            return true;
        }
        if(!this.q) {
            View view0 = this.m;
            if(view0 != null) {
                this.n = view0;
                this.i.y(this);
                this.i.z(this);
                this.i.x(true);
                View view1 = this.n;
                boolean z = this.p == null;
                ViewTreeObserver viewTreeObserver0 = view1.getViewTreeObserver();
                this.p = viewTreeObserver0;
                if(z) {
                    viewTreeObserver0.addOnGlobalLayoutListener(this.j);
                }
                view1.addOnAttachStateChangeListener(this.k);
                this.i.q(view1);
                this.i.t(this.t);
                if(!this.r) {
                    this.s = g.o(this.d, null, this.b, this.f);
                    this.r = true;
                }
                this.i.s(this.s);
                this.i.w(2);
                this.i.u(this.n());
                this.i.b();
                ListView listView0 = this.i.g();
                listView0.setOnKeyListener(this);
                if(this.u && this.c.u() != null) {
                    FrameLayout frameLayout0 = (FrameLayout)LayoutInflater.from(this.b).inflate(f.i, listView0, false);
                    TextView textView0 = (TextView)frameLayout0.findViewById(0x1020016);
                    if(textView0 != null) {
                        textView0.setText(this.c.u());
                    }
                    frameLayout0.setEnabled(false);
                    listView0.addHeaderView(frameLayout0, null, false);
                }
                this.i.p(this.d);
                this.i.b();
                return true;
            }
        }
        return false;
    }
}

