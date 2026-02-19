package q1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import c2.c;
import c2.f1;
import java.lang.ref.WeakReference;

public final class j implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, n {
    private final d a;
    private final c b;
    private WeakReference c;
    private boolean d;

    private j(d d0, int v) {
        this.d = false;
        this.a = d0;
        this.b = new c(v, null);
    }

    @Override  // q1.n
    public final void a(Activity activity0) {
        View view0 = null;
        try {
            view0 = activity0.findViewById(0x1020002);
        }
        catch(IllegalStateException unused_ex) {
        }
        if(view0 == null) {
            view0 = activity0.getWindow().getDecorView();
            if(view0 == null) {
                f1.g("PopupManager", "Failed to bind to: " + activity0);
                return;
            }
        }
        f1.f("PopupManager", "Binding to: " + activity0);
        this.f(view0);
    }

    public final Bundle b() {
        return this.b.a();
    }

    public final IBinder c() {
        return this.b.a;
    }

    public static j d(d d0, int v) {
        return new j(d0, v);
    }

    public final c e() {
        return this.b;
    }

    public final void f(View view0) {
        this.a.r0();
        WeakReference weakReference0 = this.c;
        if(weakReference0 != null) {
            View view1 = (View)weakReference0.get();
            Context context0 = this.a.x();
            if(view1 == null && context0 instanceof Activity) {
                view1 = ((Activity)context0).getWindow().getDecorView();
            }
            if(view1 != null) {
                view1.removeOnAttachStateChangeListener(this);
                view1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
        this.c = null;
        Context context1 = this.a.x();
        if(view0 == null && context1 instanceof Activity) {
            Activity activity0 = (Activity)context1;
            try {
                view0 = activity0.findViewById(0x1020002);
            }
            catch(IllegalStateException unused_ex) {
            }
            if(view0 == null) {
                view0 = activity0.getWindow().getDecorView();
            }
            f1.g("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
        }
        if(view0 != null) {
            this.h(view0);
            this.c = new WeakReference(view0);
            view0.addOnAttachStateChangeListener(this);
            view0.getViewTreeObserver().addOnGlobalLayoutListener(this);
            return;
        }
        f1.c("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client\'s calls. Use setViewForPopups() to set your content view.");
    }

    public final void g() {
        boolean z;
        c c0 = this.b;
        IBinder iBinder0 = c0.a;
        if(iBinder0 == null) {
            z = true;
        }
        else {
            Bundle bundle0 = c0.a();
            this.a.m0(iBinder0, bundle0);
            z = false;
        }
        this.d = z;
    }

    private final void h(View view0) {
        int v = -1;
        Display display0 = view0.getDisplay();
        if(display0 != null) {
            v = display0.getDisplayId();
        }
        IBinder iBinder0 = view0.getWindowToken();
        int[] arr_v = new int[2];
        view0.getLocationInWindow(arr_v);
        int v1 = view0.getWidth();
        int v2 = view0.getHeight();
        this.b.c = v;
        this.b.a = iBinder0;
        this.b.d = arr_v[0];
        this.b.e = arr_v[1];
        this.b.f = arr_v[0] + v1;
        this.b.g = arr_v[1] + v2;
        if(this.d) {
            this.g();
        }
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public final void onGlobalLayout() {
        WeakReference weakReference0 = this.c;
        if(weakReference0 != null) {
            View view0 = (View)weakReference0.get();
            if(view0 != null) {
                this.h(view0);
            }
        }
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view0) {
        this.h(view0);
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view0) {
        this.a.r0();
        view0.removeOnAttachStateChangeListener(this);
    }
}

