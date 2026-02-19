package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;
import androidx.core.view.v;
import c.c;

public class h {
    class a implements PopupWindow.OnDismissListener {
        final h a;

        @Override  // android.widget.PopupWindow$OnDismissListener
        public void onDismiss() {
            h.this.e();
        }
    }

    static abstract class b {
        static void a(Display display0, Point point0) {
            display0.getRealSize(point0);
        }
    }

    private final Context a;
    private final e b;
    private final boolean c;
    private final int d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private androidx.appcompat.view.menu.i.a i;
    private g j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l;

    public h(Context context0, e e0, View view0, boolean z, int v) {
        this(context0, e0, view0, z, v, 0);
    }

    public h(Context context0, e e0, View view0, boolean z, int v, int v1) {
        this.g = 0x800003;
        this.l = () -> {
            h.this.j = null;
            PopupWindow.OnDismissListener popupWindow$OnDismissListener0 = h.this.k;
            if(popupWindow$OnDismissListener0 != null) {
                popupWindow$OnDismissListener0.onDismiss();
            }
        };
        this.a = context0;
        this.b = e0;
        this.f = view0;
        this.c = z;
        this.d = v;
        this.e = v1;
    }

    private g a() {
        Display display0 = ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay();
        Point point0 = new Point();
        b.a(display0, point0);
        g g0 = Math.min(point0.x, point0.y) >= this.a.getResources().getDimensionPixelSize(c.a) ? new androidx.appcompat.view.menu.c(this.a, this.f, this.d, this.e, this.c) : new l(this.a, this.b, this.f, this.d, this.e, this.c);
        g0.l(this.b);
        g0.u(this.l);
        g0.p(this.f);
        g0.i(this.i);
        g0.r(this.h);
        g0.s(this.g);
        return g0;
    }

    public void b() {
        if(this.d()) {
            this.j.dismiss();
        }
    }

    public g c() {
        if(this.j == null) {
            this.j = this.a();
        }
        return this.j;
    }

    public boolean d() {
        return this.j != null && this.j.f();
    }

    // 检测为 Lambda 实现
    protected void e() [...]

    public void f(View view0) {
        this.f = view0;
    }

    public void g(boolean z) {
        this.h = z;
        g g0 = this.j;
        if(g0 != null) {
            g0.r(z);
        }
    }

    public void h(int v) {
        this.g = v;
    }

    public void i(PopupWindow.OnDismissListener popupWindow$OnDismissListener0) {
        this.k = popupWindow$OnDismissListener0;
    }

    public void j(androidx.appcompat.view.menu.i.a i$a0) {
        this.i = i$a0;
        g g0 = this.j;
        if(g0 != null) {
            g0.i(i$a0);
        }
    }

    public void k() {
        if(!this.m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    private void l(int v, int v1, boolean z, boolean z1) {
        g g0 = this.c();
        g0.v(z1);
        if(z) {
            if((androidx.core.view.e.a(this.g, v.o(this.f)) & 7) == 5) {
                v -= this.f.getWidth();
            }
            g0.t(v);
            g0.w(v1);
            int v2 = (int)(this.a.getResources().getDisplayMetrics().density * 48.0f / 2.0f);
            g0.q(new Rect(v - v2, v1 - v2, v + v2, v1 + v2));
        }
        g0.b();
    }

    public boolean m() {
        if(this.d()) {
            return true;
        }
        if(this.f == null) {
            return false;
        }
        this.l(0, 0, false, false);
        return true;
    }

    public boolean n(int v, int v1) {
        if(this.d()) {
            return true;
        }
        if(this.f == null) {
            return false;
        }
        this.l(v, v1, true, true);
        return true;
    }
}

