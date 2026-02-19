package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import androidx.core.view.v;
import c.d;
import c.g;
import c.i;

public class o0 implements t {
    Toolbar a;
    private int b;
    private View c;
    private Drawable d;
    private Drawable e;
    private Drawable f;
    private boolean g;
    CharSequence h;
    private CharSequence i;
    private CharSequence j;
    Window.Callback k;
    boolean l;
    private int m;
    private int n;
    private Drawable o;

    public o0(Toolbar toolbar0, boolean z) {
        this(toolbar0, z, g.a, d.n);
    }

    public o0(Toolbar toolbar0, boolean z, int v, int v1) {
        class a implements View.OnClickListener {
            final androidx.appcompat.view.menu.a a;
            final o0 b;

            a() {
                this.a = new androidx.appcompat.view.menu.a(o00.a.getContext(), 0, 0x102002C, 0, 0, o00.h);
            }

            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                Window.Callback window$Callback0 = o0.this.k;
                if(window$Callback0 != null && o0.this.l) {
                    window$Callback0.onMenuItemSelected(0, this.a);
                }
            }
        }

        this.m = 0;
        this.n = 0;
        this.a = toolbar0;
        this.h = toolbar0.getTitle();
        this.i = toolbar0.getSubtitle();
        this.g = this.h != null;
        this.f = toolbar0.getNavigationIcon();
        l0 l00 = l0.s(toolbar0.getContext(), null, i.a, c.a.c, 0);
        this.o = l00.f(i.j);
        if(z) {
            CharSequence charSequence0 = l00.n(i.p);
            if(!TextUtils.isEmpty(charSequence0)) {
                this.n(charSequence0);
            }
            CharSequence charSequence1 = l00.n(i.n);
            if(!TextUtils.isEmpty(charSequence1)) {
                this.m(charSequence1);
            }
            Drawable drawable0 = l00.f(i.l);
            if(drawable0 != null) {
                this.i(drawable0);
            }
            Drawable drawable1 = l00.f(i.k);
            if(drawable1 != null) {
                this.setIcon(drawable1);
            }
            if(this.f == null) {
                Drawable drawable2 = this.o;
                if(drawable2 != null) {
                    this.l(drawable2);
                }
            }
            this.h(l00.i(i.h, 0));
            int v2 = l00.l(i.g, 0);
            if(v2 != 0) {
                this.f(LayoutInflater.from(this.a.getContext()).inflate(v2, this.a, false));
                this.h(this.b | 16);
            }
            int v3 = l00.k(i.i, 0);
            if(v3 > 0) {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.a.getLayoutParams();
                viewGroup$LayoutParams0.height = v3;
                this.a.setLayoutParams(viewGroup$LayoutParams0);
            }
            int v4 = l00.d(i.f, -1);
            int v5 = l00.d(i.e, -1);
            if(v4 >= 0 || v5 >= 0) {
                this.a.H(Math.max(v4, 0), Math.max(v5, 0));
            }
            int v6 = l00.l(i.q, 0);
            if(v6 != 0) {
                this.a.J(this.a.getContext(), v6);
            }
            int v7 = l00.l(i.o, 0);
            if(v7 != 0) {
                this.a.I(this.a.getContext(), v7);
            }
            int v8 = l00.l(i.m, 0);
            if(v8 != 0) {
                this.a.setPopupTheme(v8);
            }
        }
        else {
            this.b = this.d();
        }
        l00.t();
        this.g(v);
        this.j = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new a(this));
    }

    @Override  // androidx.appcompat.widget.t
    public void a(int v) {
        this.i((v == 0 ? null : e.a.b(this.e(), v)));
    }

    @Override  // androidx.appcompat.widget.t
    public void b(CharSequence charSequence0) {
        if(!this.g) {
            this.o(charSequence0);
        }
    }

    @Override  // androidx.appcompat.widget.t
    public void c(Window.Callback window$Callback0) {
        this.k = window$Callback0;
    }

    private int d() {
        if(this.a.getNavigationIcon() != null) {
            this.o = this.a.getNavigationIcon();
            return 15;
        }
        return 11;
    }

    public Context e() {
        return this.a.getContext();
    }

    public void f(View view0) {
        View view1 = this.c;
        if(view1 != null && (this.b & 16) != 0) {
            this.a.removeView(view1);
        }
        this.c = view0;
        if(view0 != null && (this.b & 16) != 0) {
            this.a.addView(view0);
        }
    }

    public void g(int v) {
        if(v == this.n) {
            return;
        }
        this.n = v;
        if(TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            this.j(this.n);
        }
    }

    @Override  // androidx.appcompat.widget.t
    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    public void h(int v) {
        CharSequence charSequence0;
        Toolbar toolbar0;
        int v1 = this.b ^ v;
        this.b = v;
        if(v1 != 0) {
            if((v1 & 4) != 0) {
                if((v & 4) != 0) {
                    this.p();
                }
                this.q();
            }
            if((v1 & 3) != 0) {
                this.r();
            }
            if((v1 & 8) != 0) {
                if((v & 8) == 0) {
                    charSequence0 = null;
                    this.a.setTitle(null);
                    toolbar0 = this.a;
                }
                else {
                    this.a.setTitle(this.h);
                    toolbar0 = this.a;
                    charSequence0 = this.i;
                }
                toolbar0.setSubtitle(charSequence0);
            }
            if((v1 & 16) != 0) {
                View view0 = this.c;
                if(view0 != null) {
                    if((v & 16) != 0) {
                        this.a.addView(view0);
                        return;
                    }
                    this.a.removeView(view0);
                }
            }
        }
    }

    public void i(Drawable drawable0) {
        this.e = drawable0;
        this.r();
    }

    public void j(int v) {
        this.k((v == 0 ? null : this.e().getString(v)));
    }

    public void k(CharSequence charSequence0) {
        this.j = charSequence0;
        this.p();
    }

    public void l(Drawable drawable0) {
        this.f = drawable0;
        this.q();
    }

    public void m(CharSequence charSequence0) {
        this.i = charSequence0;
        if((this.b & 8) != 0) {
            this.a.setSubtitle(charSequence0);
        }
    }

    public void n(CharSequence charSequence0) {
        this.g = true;
        this.o(charSequence0);
    }

    private void o(CharSequence charSequence0) {
        this.h = charSequence0;
        if((this.b & 8) != 0) {
            this.a.setTitle(charSequence0);
            if(this.g) {
                v.I(this.a.getRootView(), charSequence0);
            }
        }
    }

    private void p() {
        if((this.b & 4) != 0) {
            if(TextUtils.isEmpty(this.j)) {
                this.a.setNavigationContentDescription(this.n);
                return;
            }
            this.a.setNavigationContentDescription(this.j);
        }
    }

    private void q() {
        Drawable drawable0;
        Toolbar toolbar0;
        if((this.b & 4) == 0) {
            toolbar0 = this.a;
            drawable0 = null;
        }
        else {
            toolbar0 = this.a;
            drawable0 = this.f;
            if(drawable0 == null) {
                drawable0 = this.o;
            }
        }
        toolbar0.setNavigationIcon(drawable0);
    }

    private void r() {
        Drawable drawable0;
        int v = this.b;
        if((v & 2) == 0) {
            drawable0 = null;
        }
        else if((v & 1) != 0) {
            drawable0 = this.e;
            if(drawable0 == null) {
                drawable0 = this.d;
            }
        }
        else {
            drawable0 = this.d;
        }
        this.a.setLogo(drawable0);
    }

    @Override  // androidx.appcompat.widget.t
    public void setIcon(int v) {
        this.setIcon((v == 0 ? null : e.a.b(this.e(), v)));
    }

    @Override  // androidx.appcompat.widget.t
    public void setIcon(Drawable drawable0) {
        this.d = drawable0;
        this.r();
    }
}

