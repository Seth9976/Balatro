package androidx.core.view;

import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver;

public final class t implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
    private final View a;
    private ViewTreeObserver b;
    private final Runnable c;

    private t(View view0, Runnable runnable0) {
        this.a = view0;
        this.b = view0.getViewTreeObserver();
        this.c = runnable0;
    }

    public static t a(View view0, Runnable runnable0) {
        if(view0 == null) {
            throw new NullPointerException("view == null");
        }
        if(runnable0 == null) {
            throw new NullPointerException("runnable == null");
        }
        t t0 = new t(view0, runnable0);
        view0.getViewTreeObserver().addOnPreDrawListener(t0);
        view0.addOnAttachStateChangeListener(t0);
        return t0;
    }

    public void b() {
        (this.b.isAlive() ? this.b : this.a.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.a.removeOnAttachStateChangeListener(this);
    }

    @Override  // android.view.ViewTreeObserver$OnPreDrawListener
    public boolean onPreDraw() {
        this.b();
        this.c.run();
        return true;
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view0) {
        this.b = view0.getViewTreeObserver();
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view0) {
        this.b();
    }
}

