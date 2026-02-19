package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.v;
import androidx.core.widget.c;
import c.i;
import e.a;

public class k {
    private final ImageView a;
    private j0 b;
    private j0 c;
    private j0 d;
    private int e;

    public k(ImageView imageView0) {
        this.e = 0;
        this.a = imageView0;
    }

    private boolean a(Drawable drawable0) {
        if(this.d == null) {
            this.d = new j0();
        }
        j0 j00 = this.d;
        j00.a();
        ColorStateList colorStateList0 = c.a(this.a);
        if(colorStateList0 != null) {
            j00.d = true;
            j00.a = colorStateList0;
        }
        PorterDuff.Mode porterDuff$Mode0 = c.b(this.a);
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
        if(this.a.getDrawable() != null) {
            this.a.getDrawable().setLevel(this.e);
        }
    }

    void c() {
        Drawable drawable0 = this.a.getDrawable();
        if(drawable0 != null) {
            u.b(drawable0);
        }
        if(drawable0 == null || this.l() && this.a(drawable0)) {
            return;
        }
        j0 j00 = this.c;
        if(j00 != null) {
            f.g(drawable0, j00, this.a.getDrawableState());
            return;
        }
        j0 j01 = this.b;
        if(j01 != null) {
            f.g(drawable0, j01, this.a.getDrawableState());
        }
    }

    ColorStateList d() {
        return this.c == null ? null : this.c.a;
    }

    PorterDuff.Mode e() {
        return this.c == null ? null : this.c.b;
    }

    boolean f() {
        return !(this.a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet0, int v) {
        l0 l00 = l0.s(this.a.getContext(), attributeSet0, i.F, v, 0);
        Context context0 = this.a.getContext();
        v.F(this.a, context0, i.F, attributeSet0, l00.o(), v, 0);
        try {
            Drawable drawable0 = this.a.getDrawable();
            if(drawable0 == null) {
                int v2 = l00.l(i.G, -1);
                if(v2 != -1) {
                    drawable0 = a.b(this.a.getContext(), v2);
                    if(drawable0 != null) {
                        this.a.setImageDrawable(drawable0);
                    }
                }
            }
            if(drawable0 != null) {
                u.b(drawable0);
            }
            if(l00.p(i.H)) {
                ColorStateList colorStateList0 = l00.c(i.H);
                c.c(this.a, colorStateList0);
            }
            if(l00.p(i.I)) {
                PorterDuff.Mode porterDuff$Mode0 = u.d(l00.i(i.I, -1), null);
                c.d(this.a, porterDuff$Mode0);
            }
        }
        finally {
            l00.t();
        }
    }

    void h(Drawable drawable0) {
        this.e = drawable0.getLevel();
    }

    public void i(int v) {
        if(v == 0) {
            this.a.setImageDrawable(null);
        }
        else {
            Drawable drawable0 = a.b(this.a.getContext(), v);
            if(drawable0 != null) {
                u.b(drawable0);
            }
            this.a.setImageDrawable(drawable0);
        }
        this.c();
    }

    void j(ColorStateList colorStateList0) {
        if(this.c == null) {
            this.c = new j0();
        }
        this.c.a = colorStateList0;
        this.c.d = true;
        this.c();
    }

    void k(PorterDuff.Mode porterDuff$Mode0) {
        if(this.c == null) {
            this.c = new j0();
        }
        this.c.b = porterDuff$Mode0;
        this.c.c = true;
        this.c();
    }

    private boolean l() {
        return this.b != null;
    }
}

