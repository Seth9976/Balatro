package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.view.v;
import c.i;
import java.lang.ref.WeakReference;
import java.util.Locale;

class o {
    static abstract class c {
        static Drawable[] a(TextView textView0) {
            return textView0.getCompoundDrawablesRelative();
        }

        static void b(TextView textView0, Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
            textView0.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable0, drawable1, drawable2, drawable3);
        }

        static void c(TextView textView0, Locale locale0) {
            textView0.setTextLocale(locale0);
        }
    }

    static abstract class d {
        static Locale a(String s) {
            return Locale.forLanguageTag(s);
        }
    }

    static abstract class e {
        static LocaleList a(String s) {
            return LocaleList.forLanguageTags(s);
        }

        static void b(TextView textView0, LocaleList localeList0) {
            textView0.setTextLocales(localeList0);
        }
    }

    static abstract class f {
        static int a(TextView textView0) {
            return textView0.getAutoSizeStepGranularity();
        }

        static void b(TextView textView0, int v, int v1, int v2, int v3) {
            textView0.setAutoSizeTextTypeUniformWithConfiguration(v, v1, v2, v3);
        }

        static void c(TextView textView0, int[] arr_v, int v) {
            textView0.setAutoSizeTextTypeUniformWithPresetSizes(arr_v, v);
        }

        static boolean d(TextView textView0, String s) {
            return textView0.setFontVariationSettings(s);
        }
    }

    static abstract class g {
        static Typeface a(Typeface typeface0, int v, boolean z) {
            return Typeface.create(typeface0, v, z);
        }
    }

    private final TextView a;
    private j0 b;
    private j0 c;
    private j0 d;
    private j0 e;
    private j0 f;
    private j0 g;
    private j0 h;
    private final q i;
    private int j;
    private int k;
    private Typeface l;
    private boolean m;

    o(TextView textView0) {
        this.j = 0;
        this.k = -1;
        this.a = textView0;
        this.i = new q(textView0);
    }

    void A(int v, float f) {
        if(!v0.b && !this.l()) {
            this.B(v, f);
        }
    }

    private void B(int v, float f) {
        this.i.t(v, f);
    }

    private void C(Context context0, l0 l00) {
        class a extends androidx.core.content.res.h.e {
            final int a;
            final int b;
            final WeakReference c;
            final o d;

            a(int v, int v1, WeakReference weakReference0) {
                this.a = v;
                this.b = v1;
                this.c = weakReference0;
                super();
            }

            @Override  // androidx.core.content.res.h$e
            public void h(int v) {
            }

            @Override  // androidx.core.content.res.h$e
            public void i(Typeface typeface0) {
                if(Build.VERSION.SDK_INT >= 28) {
                    int v = this.a;
                    if(v != -1) {
                        typeface0 = g.a(typeface0, v, (this.b & 2) != 0);
                    }
                }
                o.this.n(this.c, typeface0);
            }
        }

        Typeface typeface2;
        this.j = l00.i(i.T1, this.j);
        int v = Build.VERSION.SDK_INT;
        boolean z = false;
        if(v >= 28) {
            int v1 = l00.i(i.V1, -1);
            this.k = v1;
            if(v1 != -1) {
                this.j &= 2;
            }
        }
        if(!l00.p(i.U1) && !l00.p(i.W1)) {
            if(l00.p(i.S1)) {
                this.m = false;
                int v2 = l00.i(i.S1, 1);
                switch(v2) {
                    case 1: {
                        this.l = Typeface.SANS_SERIF;
                        return;
                    label_16:
                        if(v2 == 3) {
                            this.l = Typeface.MONOSPACE;
                            return;
                        }
                        break;
                    }
                    case 2: {
                        this.l = Typeface.SERIF;
                        break;
                    }
                    default: {
                        goto label_16;
                    }
                }
            }
            return;
        }
        this.l = null;
        int v3 = l00.p(i.W1) ? i.W1 : i.U1;
        int v4 = this.k;
        int v5 = this.j;
        if(!context0.isRestricted()) {
            a o$a0 = new a(this, v4, v5, new WeakReference(this.a));
            try {
                Typeface typeface0 = l00.h(v3, this.j, o$a0);
                if(typeface0 != null) {
                    if(v >= 28 && this.k != -1) {
                        typeface0 = g.a(Typeface.create(typeface0, 0), this.k, (this.j & 2) != 0);
                    }
                    this.l = typeface0;
                }
                this.m = this.l == null;
            }
            catch(UnsupportedOperationException | Resources.NotFoundException unused_ex) {
            }
        }
        if(this.l == null) {
            String s = l00.m(v3);
            if(s != null) {
                if(Build.VERSION.SDK_INT < 28 || this.k == -1) {
                    typeface2 = Typeface.create(s, this.j);
                }
                else {
                    Typeface typeface1 = Typeface.create(s, 0);
                    int v6 = this.k;
                    if((this.j & 2) != 0) {
                        z = true;
                    }
                    typeface2 = g.a(typeface1, v6, z);
                }
                this.l = typeface2;
            }
        }
    }

    private void a(Drawable drawable0, j0 j00) {
        if(drawable0 != null && j00 != null) {
            androidx.appcompat.widget.f.g(drawable0, j00, this.a.getDrawableState());
        }
    }

    void b() {
        if(this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] arr_drawable = this.a.getCompoundDrawables();
            this.a(arr_drawable[0], this.b);
            this.a(arr_drawable[1], this.c);
            this.a(arr_drawable[2], this.d);
            this.a(arr_drawable[3], this.e);
        }
        if(this.f != null || this.g != null) {
            Drawable[] arr_drawable1 = c.a(this.a);
            this.a(arr_drawable1[0], this.f);
            this.a(arr_drawable1[2], this.g);
        }
    }

    void c() {
        this.i.a();
    }

    private static j0 d(Context context0, androidx.appcompat.widget.f f0, int v) {
        ColorStateList colorStateList0 = f0.e(context0, v);
        if(colorStateList0 != null) {
            j0 j00 = new j0();
            j00.d = true;
            j00.a = colorStateList0;
            return j00;
        }
        return null;
    }

    int e() {
        return this.i.f();
    }

    int f() {
        return this.i.g();
    }

    int g() {
        return this.i.h();
    }

    int[] h() {
        return this.i.i();
    }

    int i() {
        return this.i.j();
    }

    ColorStateList j() {
        return this.h == null ? null : this.h.a;
    }

    PorterDuff.Mode k() {
        return this.h == null ? null : this.h.b;
    }

    boolean l() {
        return this.i.n();
    }

    void m(AttributeSet attributeSet0, int v) {
        int v4;
        String s1;
        String s;
        int v3;
        boolean z;
        Context context0 = this.a.getContext();
        androidx.appcompat.widget.f f0 = androidx.appcompat.widget.f.b();
        l0 l00 = l0.s(context0, attributeSet0, i.K, v, 0);
        Context context1 = this.a.getContext();
        v.F(this.a, context1, i.K, attributeSet0, l00.o(), v, 0);
        int v1 = l00.l(i.L, -1);
        if(l00.p(i.O)) {
            this.b = o.d(context0, f0, l00.l(i.O, 0));
        }
        if(l00.p(i.M)) {
            this.c = o.d(context0, f0, l00.l(i.M, 0));
        }
        if(l00.p(i.P)) {
            this.d = o.d(context0, f0, l00.l(i.P, 0));
        }
        if(l00.p(i.N)) {
            this.e = o.d(context0, f0, l00.l(i.N, 0));
        }
        int v2 = Build.VERSION.SDK_INT;
        if(l00.p(i.Q)) {
            this.f = o.d(context0, f0, l00.l(i.Q, 0));
        }
        if(l00.p(i.R)) {
            this.g = o.d(context0, f0, l00.l(i.R, 0));
        }
        l00.t();
        TransformationMethod transformationMethod0 = this.a.getTransformationMethod();
        if(v1 == -1) {
            z = false;
            v3 = 0;
            s1 = null;
            s = null;
        }
        else {
            l0 l01 = l0.q(context0, v1, i.Q1);
            if(transformationMethod0 instanceof PasswordTransformationMethod || !l01.p(i.Y1)) {
                z = false;
                v3 = 0;
            }
            else {
                z = l01.a(i.Y1, false);
                v3 = 1;
            }
            this.C(context0, l01);
            s = l01.p(i.Z1) ? l01.m(i.Z1) : null;
            s1 = v2 < 26 || !l01.p(i.X1) ? null : l01.m(i.X1);
            l01.t();
        }
        l0 l02 = l0.s(context0, attributeSet0, i.Q1, v, 0);
        if(transformationMethod0 instanceof PasswordTransformationMethod || !l02.p(i.Y1)) {
            v4 = v3;
        }
        else {
            z = l02.a(i.Y1, false);
            v4 = 1;
        }
        if(l02.p(i.Z1)) {
            s = l02.m(i.Z1);
        }
        if(v2 >= 26 && l02.p(i.X1)) {
            s1 = l02.m(i.X1);
        }
        if(v2 >= 28 && l02.p(i.R1) && l02.e(i.R1, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        this.C(context0, l02);
        l02.t();
        if(!(transformationMethod0 instanceof PasswordTransformationMethod) && v4 != 0) {
            this.s(z);
        }
        Typeface typeface0 = this.l;
        if(typeface0 != null) {
            if(this.k == -1) {
                this.a.setTypeface(typeface0, this.j);
            }
            else {
                this.a.setTypeface(typeface0);
            }
        }
        if(s1 != null) {
            f.d(this.a, s1);
        }
        if(s != null) {
            if(v2 >= 24) {
                LocaleList localeList0 = e.a(s);
                e.b(this.a, localeList0);
            }
            else {
                Locale locale0 = d.a(s.split(",")[0]);
                c.c(this.a, locale0);
            }
        }
        this.i.o(attributeSet0, v);
        if(v0.b && this.i.j() != 0) {
            int[] arr_v = this.i.i();
            if(arr_v.length > 0) {
                if(((float)f.a(this.a)) == -1.0f) {
                    f.c(this.a, arr_v, 0);
                }
                else {
                    f.b(this.a, this.i.g(), this.i.f(), this.i.h(), 0);
                }
            }
        }
        l0 l03 = l0.r(context0, attributeSet0, i.S);
        int v5 = l03.l(i.a0, -1);
        Drawable drawable0 = v5 == -1 ? null : f0.c(context0, v5);
        int v6 = l03.l(i.f0, -1);
        Drawable drawable1 = v6 == -1 ? null : f0.c(context0, v6);
        int v7 = l03.l(i.b0, -1);
        Drawable drawable2 = v7 == -1 ? null : f0.c(context0, v7);
        int v8 = l03.l(i.Y, -1);
        Drawable drawable3 = v8 == -1 ? null : f0.c(context0, v8);
        int v9 = l03.l(i.c0, -1);
        Drawable drawable4 = v9 == -1 ? null : f0.c(context0, v9);
        int v10 = l03.l(i.Z, -1);
        this.y(drawable0, drawable1, drawable2, drawable3, drawable4, (v10 == -1 ? null : f0.c(context0, v10)));
        if(l03.p(i.d0)) {
            ColorStateList colorStateList0 = l03.c(i.d0);
            androidx.core.widget.g.f(this.a, colorStateList0);
        }
        if(l03.p(i.e0)) {
            PorterDuff.Mode porterDuff$Mode0 = u.d(l03.i(i.e0, -1), null);
            androidx.core.widget.g.g(this.a, porterDuff$Mode0);
        }
        int v11 = l03.e(i.h0, -1);
        int v12 = l03.e(i.i0, -1);
        int v13 = l03.e(i.j0, -1);
        l03.t();
        if(v11 != -1) {
            androidx.core.widget.g.h(this.a, v11);
        }
        if(v12 != -1) {
            androidx.core.widget.g.i(this.a, v12);
        }
        if(v13 != -1) {
            androidx.core.widget.g.j(this.a, v13);
        }
    }

    void n(WeakReference weakReference0, Typeface typeface0) {
        class b implements Runnable {
            final TextView e;
            final Typeface f;
            final int g;
            final o h;

            b(TextView textView0, Typeface typeface0, int v) {
                this.e = textView0;
                this.f = typeface0;
                this.g = v;
                super();
            }

            @Override
            public void run() {
                this.e.setTypeface(this.f, this.g);
            }
        }

        if(this.m) {
            this.l = typeface0;
            TextView textView0 = (TextView)weakReference0.get();
            if(textView0 != null) {
                if(v.v(textView0)) {
                    textView0.post(new b(this, textView0, typeface0, this.j));
                    return;
                }
                textView0.setTypeface(typeface0, this.j);
            }
        }
    }

    void o(boolean z, int v, int v1, int v2, int v3) {
        if(!v0.b) {
            this.c();
        }
    }

    void p() {
        this.b();
    }

    void q(Context context0, int v) {
        l0 l00 = l0.q(context0, v, i.Q1);
        if(l00.p(i.Y1)) {
            this.s(l00.a(i.Y1, false));
        }
        int v1 = Build.VERSION.SDK_INT;
        if(l00.p(i.R1) && l00.e(i.R1, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        this.C(context0, l00);
        if(v1 >= 26 && l00.p(i.X1)) {
            String s = l00.m(i.X1);
            if(s != null) {
                f.d(this.a, s);
            }
        }
        l00.t();
        Typeface typeface0 = this.l;
        if(typeface0 != null) {
            this.a.setTypeface(typeface0, this.j);
        }
    }

    void r(TextView textView0, InputConnection inputConnection0, EditorInfo editorInfo0) {
        if(Build.VERSION.SDK_INT < 30 && inputConnection0 != null) {
            p.a.d(editorInfo0, textView0.getText());
        }
    }

    void s(boolean z) {
        this.a.setAllCaps(z);
    }

    void t(int v, int v1, int v2, int v3) {
        this.i.p(v, v1, v2, v3);
    }

    void u(int[] arr_v, int v) {
        this.i.q(arr_v, v);
    }

    void v(int v) {
        this.i.r(v);
    }

    void w(ColorStateList colorStateList0) {
        if(this.h == null) {
            this.h = new j0();
        }
        this.h.a = colorStateList0;
        this.h.d = colorStateList0 != null;
        this.z();
    }

    void x(PorterDuff.Mode porterDuff$Mode0) {
        if(this.h == null) {
            this.h = new j0();
        }
        this.h.b = porterDuff$Mode0;
        this.h.c = porterDuff$Mode0 != null;
        this.z();
    }

    private void y(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5) {
        if(drawable4 != null || drawable5 != null) {
            Drawable[] arr_drawable2 = c.a(this.a);
            TextView textView2 = this.a;
            if(drawable4 == null) {
                drawable4 = arr_drawable2[0];
            }
            if(drawable1 == null) {
                drawable1 = arr_drawable2[1];
            }
            if(drawable5 == null) {
                drawable5 = arr_drawable2[2];
            }
            if(drawable3 == null) {
                drawable3 = arr_drawable2[3];
            }
            c.b(textView2, drawable4, drawable1, drawable5, drawable3);
        }
        else if(drawable0 != null || drawable1 != null || drawable2 != null || drawable3 != null) {
            Drawable[] arr_drawable = c.a(this.a);
            Drawable drawable6 = arr_drawable[0];
            if(drawable6 == null && arr_drawable[2] == null) {
                Drawable[] arr_drawable1 = this.a.getCompoundDrawables();
                TextView textView0 = this.a;
                if(drawable0 == null) {
                    drawable0 = arr_drawable1[0];
                }
                if(drawable1 == null) {
                    drawable1 = arr_drawable1[1];
                }
                if(drawable2 == null) {
                    drawable2 = arr_drawable1[2];
                }
                if(drawable3 == null) {
                    drawable3 = arr_drawable1[3];
                }
                textView0.setCompoundDrawablesWithIntrinsicBounds(drawable0, drawable1, drawable2, drawable3);
                return;
            }
            TextView textView1 = this.a;
            if(drawable1 == null) {
                drawable1 = arr_drawable[1];
            }
            Drawable drawable7 = arr_drawable[2];
            if(drawable3 == null) {
                drawable3 = arr_drawable[3];
            }
            c.b(textView1, drawable6, drawable1, drawable7, drawable3);
        }
    }

    private void z() {
        this.b = this.h;
        this.c = this.h;
        this.d = this.h;
        this.e = this.h;
        this.f = this.h;
        this.g = this.h;
    }
}

