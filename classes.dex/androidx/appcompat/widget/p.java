package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.widget.g;
import androidx.core.widget.h;
import h.d;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import o.l;

public class p extends TextView implements h {
    interface a {
        void a(int[] arg1, int arg2);

        void b(TextClassifier arg1);

        int c();

        int[] d();

        void e(int arg1);

        void f(int arg1);

        TextClassifier g();

        int h();

        int i();

        void j(int arg1);

        void k(int arg1, int arg2, int arg3, int arg4);

        int l();
    }

    class b implements a {
        final p a;

        @Override  // androidx.appcompat.widget.p$a
        public void a(int[] arr_v, int v) {
            p.this.super.setAutoSizeTextTypeUniformWithPresetSizes(arr_v, v);
        }

        @Override  // androidx.appcompat.widget.p$a
        public void b(TextClassifier textClassifier0) {
            p.this.super.setTextClassifier(textClassifier0);
        }

        @Override  // androidx.appcompat.widget.p$a
        public int c() {
            return p.this.super.getAutoSizeMinTextSize();
        }

        @Override  // androidx.appcompat.widget.p$a
        public int[] d() {
            return p.this.super.getAutoSizeTextAvailableSizes();
        }

        @Override  // androidx.appcompat.widget.p$a
        public void e(int v) {
        }

        @Override  // androidx.appcompat.widget.p$a
        public void f(int v) {
        }

        @Override  // androidx.appcompat.widget.p$a
        public TextClassifier g() {
            return p.this.super.getTextClassifier();
        }

        @Override  // androidx.appcompat.widget.p$a
        public int h() {
            return p.this.super.getAutoSizeStepGranularity();
        }

        @Override  // androidx.appcompat.widget.p$a
        public int i() {
            return p.this.super.getAutoSizeMaxTextSize();
        }

        @Override  // androidx.appcompat.widget.p$a
        public void j(int v) {
            p.this.super.setAutoSizeTextTypeWithDefaults(v);
        }

        @Override  // androidx.appcompat.widget.p$a
        public void k(int v, int v1, int v2, int v3) {
            p.this.super.setAutoSizeTextTypeUniformWithConfiguration(v, v1, v2, v3);
        }

        @Override  // androidx.appcompat.widget.p$a
        public int l() {
            return p.this.super.getAutoSizeTextType();
        }
    }

    class c extends b {
        final p b;

        @Override  // androidx.appcompat.widget.p$b
        public void e(int v) {
            p.this.super.setLastBaselineToBottomHeight(v);
        }

        @Override  // androidx.appcompat.widget.p$b
        public void f(int v) {
            p.this.super.setFirstBaselineToTopHeight(v);
        }
    }

    private final e a;
    private final o b;
    private final n c;
    private androidx.appcompat.widget.h d;
    private boolean e;
    private a f;
    private Future g;

    public p(Context context0) {
        this(context0, null);
    }

    public p(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x1010084);
    }

    public p(Context context0, AttributeSet attributeSet0, int v) {
        super(i0.b(context0), attributeSet0, v);
        this.e = false;
        this.f = null;
        h0.a(this, this.getContext());
        e e0 = new e(this);
        this.a = e0;
        e0.e(attributeSet0, v);
        o o0 = new o(this);
        this.b = o0;
        o0.m(attributeSet0, v);
        o0.b();
        this.c = new n(this);
        this.getEmojiTextViewHelper().b(attributeSet0, v);
    }

    @Override  // android.widget.TextView
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e e0 = this.a;
        if(e0 != null) {
            e0.b();
        }
        o o0 = this.b;
        if(o0 != null) {
            o0.b();
        }
    }

    @Override  // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if(v0.b) {
            return this.getSuperCaller().i();
        }
        return this.b == null ? -1 : this.b.e();
    }

    @Override  // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if(v0.b) {
            return this.getSuperCaller().c();
        }
        return this.b == null ? -1 : this.b.f();
    }

    @Override  // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if(v0.b) {
            return this.getSuperCaller().h();
        }
        return this.b == null ? -1 : this.b.g();
    }

    @Override  // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if(v0.b) {
            return this.getSuperCaller().d();
        }
        return this.b == null ? new int[0] : this.b.h();
    }

    @Override  // android.widget.TextView
    public int getAutoSizeTextType() {
        if(v0.b) {
            return this.getSuperCaller().l() == 1 ? 1 : 0;
        }
        return this.b == null ? 0 : this.b.i();
    }

    @Override  // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return g.m(super.getCustomSelectionActionModeCallback());
    }

    private androidx.appcompat.widget.h getEmojiTextViewHelper() {
        if(this.d == null) {
            this.d = new androidx.appcompat.widget.h(this);
        }
        return this.d;
    }

    @Override  // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return g.a(this);
    }

    @Override  // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return g.b(this);
    }

    a getSuperCaller() {
        b p$b0;
        if(this.f == null) {
            int v = Build.VERSION.SDK_INT;
            boolean z = false;
            if(v >= 28) {
                z = true;
                p$b0 = new c(this);
            }
            else if(v >= 26) {
                z = true;
                p$b0 = new b(this);
            }
            if(z) {
                this.f = p$b0;
                return this.f;
            }
        }
        return this.f;
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.a == null ? null : this.a.c();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.a == null ? null : this.a.d();
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.b.k();
    }

    @Override  // android.widget.TextView
    public CharSequence getText() {
        this.q();
        return super.getText();
    }

    @Override  // android.widget.TextView
    public TextClassifier getTextClassifier() {
        if(Build.VERSION.SDK_INT < 28) {
            return this.c == null ? this.getSuperCaller().g() : this.c.a();
        }
        return this.getSuperCaller().g();
    }

    public o.l.a getTextMetricsParamsCompat() {
        return g.e(this);
    }

    @Override  // android.widget.TextView
    public InputConnection onCreateInputConnection(EditorInfo editorInfo0) {
        InputConnection inputConnection0 = super.onCreateInputConnection(editorInfo0);
        this.b.r(this, inputConnection0, editorInfo0);
        return i.a(inputConnection0, editorInfo0, this);
    }

    @Override  // android.widget.TextView
    protected void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        o o0 = this.b;
        if(o0 != null) {
            o0.o(z, v, v1, v2, v3);
        }
    }

    @Override  // android.widget.TextView
    protected void onMeasure(int v, int v1) {
        this.q();
        super.onMeasure(v, v1);
    }

    @Override  // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        super.onTextChanged(charSequence0, v, v1, v2);
        if(this.b != null && !v0.b && this.b.l()) {
            this.b.c();
        }
    }

    private void q() {
        Future future0 = this.g;
        if(future0 != null) {
            try {
                this.g = null;
                d.a(future0.get());
                g.k(this, null);
            }
            catch(InterruptedException | ExecutionException unused_ex) {
            }
        }
    }

    @Override  // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        this.getEmojiTextViewHelper().c(z);
    }

    @Override  // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int v, int v1, int v2, int v3) {
        if(v0.b) {
            this.getSuperCaller().k(v, v1, v2, v3);
            return;
        }
        o o0 = this.b;
        if(o0 != null) {
            o0.t(v, v1, v2, v3);
        }
    }

    @Override  // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] arr_v, int v) {
        if(v0.b) {
            this.getSuperCaller().a(arr_v, v);
            return;
        }
        o o0 = this.b;
        if(o0 != null) {
            o0.u(arr_v, v);
        }
    }

    @Override  // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int v) {
        if(v0.b) {
            this.getSuperCaller().j(v);
            return;
        }
        o o0 = this.b;
        if(o0 != null) {
            o0.v(v);
        }
    }

    @Override  // android.view.View
    public void setBackgroundDrawable(Drawable drawable0) {
        super.setBackgroundDrawable(drawable0);
        e e0 = this.a;
        if(e0 != null) {
            e0.f(drawable0);
        }
    }

    @Override  // android.view.View
    public void setBackgroundResource(int v) {
        super.setBackgroundResource(v);
        e e0 = this.a;
        if(e0 != null) {
            e0.g(v);
        }
    }

    @Override  // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawables(drawable0, drawable1, drawable2, drawable3);
        o o0 = this.b;
        if(o0 != null) {
            o0.p();
        }
    }

    @Override  // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawablesRelative(drawable0, drawable1, drawable2, drawable3);
        o o0 = this.b;
        if(o0 != null) {
            o0.p();
        }
    }

    @Override  // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int v, int v1, int v2, int v3) {
        Context context0 = this.getContext();
        Drawable drawable0 = null;
        Drawable drawable1 = v == 0 ? null : e.a.b(context0, v);
        Drawable drawable2 = v1 == 0 ? null : e.a.b(context0, v1);
        Drawable drawable3 = v2 == 0 ? null : e.a.b(context0, v2);
        if(v3 != 0) {
            drawable0 = e.a.b(context0, v3);
        }
        this.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable1, drawable2, drawable3, drawable0);
        o o0 = this.b;
        if(o0 != null) {
            o0.p();
        }
    }

    @Override  // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable0, drawable1, drawable2, drawable3);
        o o0 = this.b;
        if(o0 != null) {
            o0.p();
        }
    }

    @Override  // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int v, int v1, int v2, int v3) {
        Context context0 = this.getContext();
        Drawable drawable0 = null;
        Drawable drawable1 = v == 0 ? null : e.a.b(context0, v);
        Drawable drawable2 = v1 == 0 ? null : e.a.b(context0, v1);
        Drawable drawable3 = v2 == 0 ? null : e.a.b(context0, v2);
        if(v3 != 0) {
            drawable0 = e.a.b(context0, v3);
        }
        this.setCompoundDrawablesWithIntrinsicBounds(drawable1, drawable2, drawable3, drawable0);
        o o0 = this.b;
        if(o0 != null) {
            o0.p();
        }
    }

    @Override  // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable0, drawable1, drawable2, drawable3);
        o o0 = this.b;
        if(o0 != null) {
            o0.p();
        }
    }

    @Override  // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionMode$Callback0) {
        super.setCustomSelectionActionModeCallback(g.n(this, actionMode$Callback0));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.getEmojiTextViewHelper().d(z);
    }

    @Override  // android.widget.TextView
    public void setFilters(InputFilter[] arr_inputFilter) {
        super.setFilters(this.getEmojiTextViewHelper().a(arr_inputFilter));
    }

    @Override  // android.widget.TextView
    public void setFirstBaselineToTopHeight(int v) {
        if(Build.VERSION.SDK_INT >= 28) {
            this.getSuperCaller().f(v);
            return;
        }
        g.h(this, v);
    }

    @Override  // android.widget.TextView
    public void setLastBaselineToBottomHeight(int v) {
        if(Build.VERSION.SDK_INT >= 28) {
            this.getSuperCaller().e(v);
            return;
        }
        g.i(this, v);
    }

    @Override  // android.widget.TextView
    public void setLineHeight(int v) {
        g.j(this, v);
    }

    public void setPrecomputedText(l l0) {
        g.k(this, l0);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList0) {
        e e0 = this.a;
        if(e0 != null) {
            e0.i(colorStateList0);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode0) {
        e e0 = this.a;
        if(e0 != null) {
            e0.j(porterDuff$Mode0);
        }
    }

    @Override  // androidx.core.widget.h
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList0) {
        this.b.w(colorStateList0);
        this.b.b();
    }

    @Override  // androidx.core.widget.h
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.b.x(porterDuff$Mode0);
        this.b.b();
    }

    @Override  // android.widget.TextView
    public void setTextAppearance(Context context0, int v) {
        super.setTextAppearance(context0, v);
        o o0 = this.b;
        if(o0 != null) {
            o0.q(context0, v);
        }
    }

    @Override  // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier0) {
        if(Build.VERSION.SDK_INT < 28) {
            n n0 = this.c;
            if(n0 != null) {
                n0.b(textClassifier0);
                return;
            }
        }
        this.getSuperCaller().b(textClassifier0);
    }

    public void setTextFuture(Future future0) {
        this.g = future0;
        if(future0 != null) {
            this.requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(o.l.a l$a0) {
        g.l(this, l$a0);
    }

    @Override  // android.widget.TextView
    public void setTextSize(int v, float f) {
        if(v0.b) {
            super.setTextSize(v, f);
            return;
        }
        o o0 = this.b;
        if(o0 != null) {
            o0.A(v, f);
        }
    }

    @Override  // android.widget.TextView
    public void setTypeface(Typeface typeface0, int v) {
        if(this.e) {
            return;
        }
        Typeface typeface1 = typeface0 == null || v <= 0 ? null : androidx.core.graphics.i.a(this.getContext(), typeface0, v);
        this.e = true;
        if(typeface1 != null) {
            typeface0 = typeface1;
        }
        try {
            super.setTypeface(typeface0, v);
            this.e = false;
        }
        catch(Throwable throwable0) {
            this.e = false;
            throw throwable0;
        }
    }
}

