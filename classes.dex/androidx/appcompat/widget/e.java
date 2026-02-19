package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.v;
import c.i;

class e {
    private final View a;
    private final f b;
    private int c;
    private j0 d;
    private j0 e;
    private j0 f;

    e(View view0) {
        this.c = -1;
        this.a = view0;
        this.b = f.b();
    }

    private boolean a(Drawable drawable0) {
        if(this.f == null) {
            this.f = new j0();
        }
        j0 j00 = this.f;
        j00.a();
        ColorStateList colorStateList0 = v.l(this.a);
        if(colorStateList0 != null) {
            j00.d = true;
            j00.a = colorStateList0;
        }
        PorterDuff.Mode porterDuff$Mode0 = v.m(this.a);
        if(porterDuff$Mode0 != null) {
            j00.c = true;
            j00.b = porterDuff$Mode0;
        }
        if(!j00.d && !j00.c) {
            return false;
        }
        f.g(drawable0, j00, this.a.getDrawableState());
        return true;
    }

    void b() {
        Drawable drawable0 = this.a.getBackground();
        if(drawable0 == null || this.k() && this.a(drawable0)) {
            return;
        }
        j0 j00 = this.e;
        if(j00 != null) {
            f.g(drawable0, j00, this.a.getDrawableState());
            return;
        }
        j0 j01 = this.d;
        if(j01 != null) {
            f.g(drawable0, j01, this.a.getDrawableState());
        }
    }

    ColorStateList c() {
        return this.e == null ? null : this.e.a;
    }

    PorterDuff.Mode d() {
        return this.e == null ? null : this.e.b;
    }

    void e(AttributeSet attributeSet0, int v) {
        l0 l00 = l0.s(this.a.getContext(), attributeSet0, i.F2, v, 0);
        Context context0 = this.a.getContext();
        v.F(this.a, context0, i.F2, attributeSet0, l00.o(), v, 0);
        try {
            if(l00.p(i.G2)) {
                this.c = l00.l(i.G2, -1);
                Context context1 = this.a.getContext();
                ColorStateList colorStateList0 = this.b.e(context1, this.c);
                if(colorStateList0 != null) {
                    this.h(colorStateList0);
                }
            }
            if(l00.p(i.H2)) {
                ColorStateList colorStateList1 = l00.c(i.H2);
                v.K(this.a, colorStateList1);
            }
            if(l00.p(i.I2)) {
                PorterDuff.Mode porterDuff$Mode0 = u.d(l00.i(i.I2, -1), null);
                v.L(this.a, porterDuff$Mode0);
            }
        }
        finally {
            l00.t();
        }
    }

    void f(Drawable drawable0) {
        this.c = -1;
        this.h(null);
        this.b();
    }

    void g(int v) {
        this.c = v;
        this.h((this.b == null ? null : this.b.e(this.a.getContext(), v)));
        this.b();
    }

    void h(ColorStateList colorStateList0) {
        if(colorStateList0 == null) {
            this.d = null;
        }
        else {
            if(this.d == null) {
                this.d = new j0();
            }
            this.d.a = colorStateList0;
            this.d.d = true;
        }
        this.b();
    }

    void i(ColorStateList colorStateList0) {
        if(this.e == null) {
            this.e = new j0();
        }
        this.e.a = colorStateList0;
        this.e.d = true;
        this.b();
    }

    void j(PorterDuff.Mode porterDuff$Mode0) {
        if(this.e == null) {
            this.e = new j0();
        }
        this.e.b = porterDuff$Mode0;
        this.e.c = true;
        this.b();
    }

    private boolean k() {
        return this.d != null;
    }
}

