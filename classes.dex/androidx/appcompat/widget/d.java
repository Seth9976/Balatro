package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.core.widget.h;
import e.a;

public abstract class d extends AutoCompleteTextView implements h {
    private final e a;
    private final o b;
    private final g c;
    private static final int[] d;

    static {
        d.d = new int[]{0x1010176};
    }

    public d(Context context0, AttributeSet attributeSet0, int v) {
        super(i0.b(context0), attributeSet0, v);
        h0.a(this, this.getContext());
        l0 l00 = l0.s(this.getContext(), attributeSet0, d.d, v, 0);
        if(l00.p(0)) {
            this.setDropDownBackgroundDrawable(l00.f(0));
        }
        l00.t();
        e e0 = new e(this);
        this.a = e0;
        e0.e(attributeSet0, v);
        o o0 = new o(this);
        this.b = o0;
        o0.m(attributeSet0, v);
        o0.b();
        g g0 = new g(this);
        this.c = g0;
        g0.c(attributeSet0, v);
        this.a(g0);
    }

    void a(g g0) {
        KeyListener keyListener0 = this.getKeyListener();
        if(g0.b(keyListener0)) {
            boolean z = super.isFocusable();
            boolean z1 = super.isClickable();
            boolean z2 = super.isLongClickable();
            int v = super.getInputType();
            KeyListener keyListener1 = g0.a(keyListener0);
            if(keyListener1 == keyListener0) {
                return;
            }
            super.setKeyListener(keyListener1);
            super.setRawInputType(v);
            super.setFocusable(z);
            super.setClickable(z1);
            super.setLongClickable(z2);
        }
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
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.g.m(super.getCustomSelectionActionModeCallback());
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
    public InputConnection onCreateInputConnection(EditorInfo editorInfo0) {
        InputConnection inputConnection0 = i.a(super.onCreateInputConnection(editorInfo0), editorInfo0, this);
        return this.c.d(inputConnection0, editorInfo0);
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
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionMode$Callback0) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.g.n(this, actionMode$Callback0));
    }

    @Override  // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int v) {
        this.setDropDownBackgroundDrawable(a.b(this.getContext(), v));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.c.e(z);
    }

    @Override  // android.widget.TextView
    public void setKeyListener(KeyListener keyListener0) {
        super.setKeyListener(this.c.a(keyListener0));
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
}

