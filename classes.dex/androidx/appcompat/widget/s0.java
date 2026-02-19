package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.v;
import androidx.core.view.x;

class s0 implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private final View a;
    private final CharSequence b;
    private final int c;
    private final Runnable d;
    private final Runnable e;
    private int f;
    private int g;
    private t0 h;
    private boolean i;
    private boolean j;
    private static s0 k;
    private static s0 l;

    private s0(View view0, CharSequence charSequence0) {
        this.d = () -> this.i(false);
        this.e = () -> {
            if(s0.l == this) {
                s0.l = null;
                t0 t00 = this.h;
                if(t00 == null) {
                    Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
                }
                else {
                    t00.c();
                    this.h = null;
                    this.c();
                    this.a.removeOnAttachStateChangeListener(this);
                }
            }
            if(s0.k == this) {
                s0.g(null);
            }
            this.a.removeCallbacks(this.e);
        };
        this.a = view0;
        this.b = charSequence0;
        this.c = x.a(ViewConfiguration.get(view0.getContext()));
        this.c();
        view0.setOnLongClickListener(this);
        view0.setOnHoverListener(this);
    }

    private void b() {
        this.a.removeCallbacks(this.d);
    }

    private void c() {
        this.j = true;
    }

    // 检测为 Lambda 实现
    void d() [...]

    // 检测为 Lambda 实现
    private void e() [...]

    private void f() {
        long v = (long)ViewConfiguration.getLongPressTimeout();
        this.a.postDelayed(this.d, v);
    }

    private static void g(s0 s00) {
        s0 s01 = s0.k;
        if(s01 != null) {
            s01.b();
        }
        s0.k = s00;
        if(s00 != null) {
            s00.f();
        }
    }

    public static void h(View view0, CharSequence charSequence0) {
        if(s0.k != null && s0.k.a == view0) {
            s0.g(null);
        }
        if(TextUtils.isEmpty(charSequence0)) {
            s0 s00 = s0.l;
            if(s00 != null && s00.a == view0) {
                s00.d();
            }
            view0.setOnLongClickListener(null);
            view0.setLongClickable(false);
            view0.setOnHoverListener(null);
            return;
        }
        new s0(view0, charSequence0);
    }

    void i(boolean z) {
        long v2;
        long v1;
        long v;
        if(!v.v(this.a)) {
            return;
        }
        s0.g(null);
        s0 s00 = s0.l;
        if(s00 != null) {
            s00.d();
        }
        s0.l = this;
        this.i = z;
        t0 t00 = new t0(this.a.getContext());
        this.h = t00;
        t00.e(this.a, this.f, this.g, this.i, this.b);
        this.a.addOnAttachStateChangeListener(this);
        if(this.i) {
            v = 2500L;
        }
        else {
            if((v.t(this.a) & 1) == 1) {
                v1 = (long)ViewConfiguration.getLongPressTimeout();
                v2 = 3000L;
            }
            else {
                v1 = (long)ViewConfiguration.getLongPressTimeout();
                v2 = 15000L;
            }
            v = v2 - v1;
        }
        this.a.removeCallbacks(this.e);
        this.a.postDelayed(this.e, v);
    }

    private boolean j(MotionEvent motionEvent0) {
        int v = (int)motionEvent0.getX();
        int v1 = (int)motionEvent0.getY();
        if(!this.j && Math.abs(v - this.f) <= this.c && Math.abs(v1 - this.g) <= this.c) {
            return false;
        }
        this.f = v;
        this.g = v1;
        this.j = false;
        return true;
    }

    @Override  // android.view.View$OnHoverListener
    public boolean onHover(View view0, MotionEvent motionEvent0) {
        if(this.h != null && this.i) {
            return false;
        }
        AccessibilityManager accessibilityManager0 = (AccessibilityManager)this.a.getContext().getSystemService("accessibility");
        if(accessibilityManager0.isEnabled() && accessibilityManager0.isTouchExplorationEnabled()) {
            return false;
        }
        switch(motionEvent0.getAction()) {
            case 7: {
                if(this.a.isEnabled() && this.h == null && this.j(motionEvent0)) {
                    s0.g(this);
                }
                return false;
            }
            case 10: {
                this.c();
                this.d();
                return false;
            }
            default: {
                return false;
            }
        }
    }

    @Override  // android.view.View$OnLongClickListener
    public boolean onLongClick(View view0) {
        this.f = view0.getWidth() / 2;
        this.g = view0.getHeight() / 2;
        this.i(true);
        return true;
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view0) {
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view0) {
        this.d();
    }
}

