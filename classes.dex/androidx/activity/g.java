package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.e0;
import androidx.lifecycle.h.b;
import androidx.lifecycle.h;
import androidx.lifecycle.m;
import k3.f;

public class g extends Dialog implements l, androidx.lifecycle.l {
    private m a;
    private final OnBackPressedDispatcher b;

    public g(Context context0, int v) {
        f.e(context0, "context");
        super(context0, v);
        this.b = new OnBackPressedDispatcher(() -> {
            f.e(this, "this$0");
            this.super.onBackPressed();
        });
    }

    @Override  // android.app.Dialog
    public void addContentView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        f.e(view0, "view");
        this.e();
        super.addContentView(view0, viewGroup$LayoutParams0);
    }

    private final m b() {
        m m0 = this.a;
        if(m0 == null) {
            m0 = new m(this);
            this.a = m0;
        }
        return m0;
    }

    @Override  // androidx.activity.l
    public final OnBackPressedDispatcher c() {
        return this.b;
    }

    private final void e() {
        Window window0 = this.getWindow();
        f.b(window0);
        e0.a(window0.getDecorView(), this);
        Window window1 = this.getWindow();
        f.b(window1);
        View view0 = window1.getDecorView();
        f.d(view0, "window!!.decorView");
        n.a(view0, this);
    }

    // 检测为 Lambda 实现
    private static final void f(g g0) [...]

    @Override  // androidx.lifecycle.l
    public final h o() {
        return this.b();
    }

    @Override  // android.app.Dialog
    public void onBackPressed() {
        this.b.f();
    }

    @Override  // android.app.Dialog
    protected void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher0 = this.getOnBackInvokedDispatcher();
            this.b.g(onBackInvokedDispatcher0);
        }
        this.b().h(b.ON_CREATE);
    }

    @Override  // android.app.Dialog
    protected void onStart() {
        super.onStart();
        this.b().h(b.ON_RESUME);
    }

    @Override  // android.app.Dialog
    protected void onStop() {
        this.b().h(b.ON_DESTROY);
        this.a = null;
        super.onStop();
    }

    @Override  // android.app.Dialog
    public void setContentView(int v) {
        this.e();
        super.setContentView(v);
    }

    @Override  // android.app.Dialog
    public void setContentView(View view0) {
        f.e(view0, "view");
        this.e();
        super.setContentView(view0);
    }

    @Override  // android.app.Dialog
    public void setContentView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        f.e(view0, "view");
        this.e();
        super.setContentView(view0, viewGroup$LayoutParams0);
    }
}

