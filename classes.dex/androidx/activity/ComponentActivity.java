package androidx.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.d;
import androidx.core.app.c;
import androidx.core.app.d0;
import androidx.core.app.e0;
import androidx.core.content.b;
import androidx.core.view.i;
import androidx.core.view.j;
import androidx.lifecycle.c0;
import androidx.lifecycle.f0;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.m;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import z.e;
import z.f;

public abstract class ComponentActivity extends c implements l, d, d0, e0, b, androidx.core.content.c, i, androidx.lifecycle.d0, g, e {
    class a implements Runnable {
        final ComponentActivity e;

        @Override
        public void run() {
            try {
                ComponentActivity.this.super.onBackPressed();
            }
            catch(IllegalStateException illegalStateException0) {
                if(!TextUtils.equals(illegalStateException0.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw illegalStateException0;
                }
            }
        }
    }

    class androidx.activity.ComponentActivity.b extends ActivityResultRegistry {
        final ComponentActivity i;

        @Override  // androidx.activity.result.ActivityResultRegistry
        public void f(int v, b.a a0, Object object0, androidx.core.app.b b0) {
            class androidx.activity.ComponentActivity.b.a implements Runnable {
                final int e;
                final b.a.a f;
                final androidx.activity.ComponentActivity.b g;

                androidx.activity.ComponentActivity.b.a(int v, b.a.a a$a0) {
                    this.e = v;
                    this.f = a$a0;
                    super();
                }

                @Override
                public void run() {
                    Object object0 = this.f.a();
                    androidx.activity.ComponentActivity.b.this.c(this.e, object0);
                }
            }


            class androidx.activity.ComponentActivity.b.b implements Runnable {
                final int e;
                final IntentSender.SendIntentException f;
                final androidx.activity.ComponentActivity.b g;

                androidx.activity.ComponentActivity.b.b(int v, IntentSender.SendIntentException intentSender$SendIntentException0) {
                    this.e = v;
                    this.f = intentSender$SendIntentException0;
                    super();
                }

                @Override
                public void run() {
                    Intent intent0 = new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f);
                    androidx.activity.ComponentActivity.b.this.b(this.e, 0, intent0);
                }
            }

            Bundle bundle1;
            ComponentActivity componentActivity0 = ComponentActivity.this;
            b.a.a a$a0 = a0.b(componentActivity0, object0);
            if(a$a0 != null) {
                new Handler(Looper.getMainLooper()).post(new androidx.activity.ComponentActivity.b.a(this, v, a$a0));
                return;
            }
            Intent intent0 = a0.a(componentActivity0, object0);
            if(intent0.getExtras() != null && intent0.getExtras().getClassLoader() == null) {
                intent0.setExtrasClassLoader(componentActivity0.getClassLoader());
            }
            if(intent0.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundle0 = intent0.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intent0.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle1 = bundle0;
            }
            else {
                bundle1 = null;
            }
            if("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intent0.getAction())) {
                String[] arr_s = intent0.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if(arr_s == null) {
                    arr_s = new String[0];
                }
                androidx.core.app.a.e(componentActivity0, arr_s, v);
                return;
            }
            if("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intent0.getAction())) {
                androidx.activity.result.e e0 = (androidx.activity.result.e)intent0.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    androidx.core.app.a.h(componentActivity0, e0.z(), v, e0.o(), e0.s(), e0.x(), 0, bundle1);
                }
                catch(IntentSender.SendIntentException intentSender$SendIntentException0) {
                    new Handler(Looper.getMainLooper()).post(new androidx.activity.ComponentActivity.b.b(this, v, intentSender$SendIntentException0));
                }
                return;
            }
            androidx.core.app.a.g(componentActivity0, intent0, v, bundle1);
        }
    }

    static abstract class androidx.activity.ComponentActivity.c {
        static void a(View view0) {
            view0.cancelPendingInputEvents();
        }
    }

    static abstract class androidx.activity.ComponentActivity.d {
        static OnBackInvokedDispatcher a(Activity activity0) {
            return activity0.getOnBackInvokedDispatcher();
        }
    }

    static final class androidx.activity.ComponentActivity.e {
        Object a;
        c0 b;

    }

    final a.a c;
    private final j d;
    private final m e;
    final z.d f;
    private c0 g;
    private final OnBackPressedDispatcher h;
    private int i;
    private final AtomicInteger j;
    private final ActivityResultRegistry k;
    private final CopyOnWriteArrayList l;
    private final CopyOnWriteArrayList m;
    private final CopyOnWriteArrayList n;
    private final CopyOnWriteArrayList o;
    private final CopyOnWriteArrayList p;
    private boolean q;
    private boolean r;

    public ComponentActivity() {
        this.c = new a.a();
        this.d = new j(() -> this.invalidateOptionsMenu());
        this.e = new m(this);
        z.d d0 = z.d.a(this);
        this.f = d0;
        this.h = new OnBackPressedDispatcher(new a(this));
        this.j = new AtomicInteger();
        this.k = new androidx.activity.ComponentActivity.b(this);
        this.l = new CopyOnWriteArrayList();
        this.m = new CopyOnWriteArrayList();
        this.n = new CopyOnWriteArrayList();
        this.o = new CopyOnWriteArrayList();
        this.p = new CopyOnWriteArrayList();
        this.q = false;
        this.r = false;
        if(this.o() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity\'s constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int v = Build.VERSION.SDK_INT;
        this.o().a(new androidx.lifecycle.j() {
            final ComponentActivity a;

            @Override  // androidx.lifecycle.j
            public void d(androidx.lifecycle.l l0, androidx.lifecycle.h.b h$b0) {
                if(h$b0 == androidx.lifecycle.h.b.ON_STOP) {
                    Window window0 = ComponentActivity.this.getWindow();
                    View view0 = window0 == null ? null : window0.peekDecorView();
                    if(view0 != null) {
                        androidx.activity.ComponentActivity.c.a(view0);
                    }
                }
            }
        });
        this.o().a(new androidx.lifecycle.j() {
            final ComponentActivity a;

            @Override  // androidx.lifecycle.j
            public void d(androidx.lifecycle.l l0, androidx.lifecycle.h.b h$b0) {
                if(h$b0 == androidx.lifecycle.h.b.ON_DESTROY) {
                    ComponentActivity.this.c.b();
                    if(!ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.l().a();
                    }
                }
            }
        });
        this.o().a(new androidx.lifecycle.j() {
            final ComponentActivity a;

            @Override  // androidx.lifecycle.j
            public void d(androidx.lifecycle.l l0, androidx.lifecycle.h.b h$b0) {
                ComponentActivity.this.z();
                ComponentActivity.this.o().c(this);
            }
        });
        d0.c();
        v.a(this);
        if(v <= 23) {
            this.o().a(new ImmLeaksCleaner(this));
        }
        this.d().h("android:support:activity-result", () -> {
            Bundle bundle0 = new Bundle();
            this.k.h(bundle0);
            return bundle0;
        });
        this.x((Context context0) -> {
            Bundle bundle0 = this.d().b("android:support:activity-result");
            if(bundle0 != null) {
                this.k.g(bundle0);
            }
        });
    }

    private void A() {
        androidx.lifecycle.e0.a(this.getWindow().getDecorView(), this);
        f0.a(this.getWindow().getDecorView(), this);
        f.a(this.getWindow().getDecorView(), this);
        n.a(this.getWindow().getDecorView(), this);
    }

    // 检测为 Lambda 实现
    public void B() [...]

    // 检测为 Lambda 实现
    private Bundle C() [...]

    // 检测为 Lambda 实现
    private void D(Context context0) [...]

    public Object E() [...] // Inlined contents

    public final androidx.activity.result.c F(b.a a0, androidx.activity.result.b b0) {
        return this.G(a0, this.k, b0);
    }

    public final androidx.activity.result.c G(b.a a0, ActivityResultRegistry activityResultRegistry0, androidx.activity.result.b b0) {
        return activityResultRegistry0.i("activity_rq#" + this.j.getAndIncrement(), this, a0, b0);
    }

    @Override  // androidx.lifecycle.g
    public x.a a() {
        x.a a0 = new x.d();
        if(this.getApplication() != null) {
            Application application0 = this.getApplication();
            ((x.d)a0).b(androidx.lifecycle.z.a.d, application0);
        }
        ((x.d)a0).b(v.a, this);
        ((x.d)a0).b(v.b, this);
        if(this.getIntent() != null && this.getIntent().getExtras() != null) {
            Bundle bundle0 = this.getIntent().getExtras();
            ((x.d)a0).b(v.c, bundle0);
        }
        return a0;
    }

    @Override  // android.app.Activity
    public void addContentView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.A();
        super.addContentView(view0, viewGroup$LayoutParams0);
    }

    @Override  // androidx.activity.l
    public final OnBackPressedDispatcher c() {
        return this.h;
    }

    @Override  // z.e
    public final z.c d() {
        return this.f.b();
    }

    @Override  // androidx.core.app.e0
    public final void e(androidx.core.util.a a0) {
        this.p.add(a0);
    }

    @Override  // androidx.core.view.i
    public void f(androidx.core.view.l l0) {
        this.d.f(l0);
    }

    @Override  // androidx.core.view.i
    public void g(androidx.core.view.l l0) {
        this.d.a(l0);
    }

    @Override  // androidx.activity.result.d
    public final ActivityResultRegistry h() {
        return this.k;
    }

    @Override  // androidx.core.app.d0
    public final void j(androidx.core.util.a a0) {
        this.o.add(a0);
    }

    @Override  // androidx.core.content.b
    public final void k(androidx.core.util.a a0) {
        this.l.add(a0);
    }

    @Override  // androidx.lifecycle.d0
    public c0 l() {
        if(this.getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can\'t request ViewModel before onCreate call.");
        }
        this.z();
        return this.g;
    }

    @Override  // androidx.core.app.d0
    public final void m(androidx.core.util.a a0) {
        this.o.remove(a0);
    }

    @Override  // androidx.core.app.e0
    public final void n(androidx.core.util.a a0) {
        this.p.remove(a0);
    }

    @Override  // androidx.lifecycle.l
    public h o() {
        return this.e;
    }

    @Override  // android.app.Activity
    protected void onActivityResult(int v, int v1, Intent intent0) {
        if(!this.k.b(v, v1, intent0)) {
            super.onActivityResult(v, v1, intent0);
        }
    }

    @Override  // android.app.Activity
    public void onBackPressed() {
        this.h.f();
    }

    @Override  // android.app.Activity
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        for(Object object0: this.l) {
            ((androidx.core.util.a)object0).accept(configuration0);
        }
    }

    @Override  // androidx.core.app.c
    protected void onCreate(Bundle bundle0) {
        this.f.d(bundle0);
        this.c.c(this);
        super.onCreate(bundle0);
        u.g(this);
        OnBackInvokedDispatcher onBackInvokedDispatcher0 = androidx.activity.ComponentActivity.d.a(this);
        this.h.g(onBackInvokedDispatcher0);
        int v = this.i;
        if(v != 0) {
            this.setContentView(v);
        }
    }

    @Override  // android.app.Activity
    public boolean onCreatePanelMenu(int v, Menu menu0) {
        if(v == 0) {
            super.onCreatePanelMenu(0, menu0);
            MenuInflater menuInflater0 = this.getMenuInflater();
            this.d.b(menu0, menuInflater0);
        }
        return true;
    }

    @Override  // android.app.Activity
    public boolean onMenuItemSelected(int v, MenuItem menuItem0) {
        if(super.onMenuItemSelected(v, menuItem0)) {
            return true;
        }
        return v == 0 ? this.d.d(menuItem0) : false;
    }

    @Override  // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        if(this.q) {
            return;
        }
        for(Object object0: this.o) {
            ((androidx.core.util.a)object0).accept(new androidx.core.app.d(z));
        }
    }

    @Override  // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration0) {
        try {
            this.q = true;
            super.onMultiWindowModeChanged(z, configuration0);
        }
        finally {
            this.q = false;
        }
        for(Object object0: this.o) {
            ((androidx.core.util.a)object0).accept(new androidx.core.app.d(z, configuration0));
        }
    }

    @Override  // android.app.Activity
    protected void onNewIntent(Intent intent0) {
        super.onNewIntent(intent0);
        for(Object object0: this.n) {
            ((androidx.core.util.a)object0).accept(intent0);
        }
    }

    @Override  // android.app.Activity
    public void onPanelClosed(int v, Menu menu0) {
        this.d.c(menu0);
        super.onPanelClosed(v, menu0);
    }

    @Override  // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        if(this.r) {
            return;
        }
        for(Object object0: this.p) {
            ((androidx.core.util.a)object0).accept(new androidx.core.app.f0(z));
        }
    }

    @Override  // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration0) {
        try {
            this.r = true;
            super.onPictureInPictureModeChanged(z, configuration0);
        }
        finally {
            this.r = false;
        }
        for(Object object0: this.p) {
            ((androidx.core.util.a)object0).accept(new androidx.core.app.f0(z, configuration0));
        }
    }

    @Override  // android.app.Activity
    public boolean onPreparePanel(int v, View view0, Menu menu0) {
        if(v == 0) {
            super.onPreparePanel(0, view0, menu0);
            this.d.e(menu0);
        }
        return true;
    }

    @Override  // android.app.Activity
    public void onRequestPermissionsResult(int v, String[] arr_s, int[] arr_v) {
        Intent intent0 = new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", arr_s).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", arr_v);
        if(!this.k.b(v, -1, intent0)) {
            super.onRequestPermissionsResult(v, arr_s, arr_v);
        }
    }

    @Override  // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        c0 c00 = this.g;
        if(c00 == null) {
            androidx.activity.ComponentActivity.e componentActivity$e0 = (androidx.activity.ComponentActivity.e)this.getLastNonConfigurationInstance();
            if(componentActivity$e0 != null) {
                c00 = componentActivity$e0.b;
            }
        }
        if(c00 == null) {
            return null;
        }
        androidx.activity.ComponentActivity.e componentActivity$e1 = new androidx.activity.ComponentActivity.e();
        componentActivity$e1.a = null;
        componentActivity$e1.b = c00;
        return componentActivity$e1;
    }

    @Override  // androidx.core.app.c
    protected void onSaveInstanceState(Bundle bundle0) {
        h h0 = this.o();
        if(h0 instanceof m) {
            ((m)h0).o(androidx.lifecycle.h.c.g);
        }
        super.onSaveInstanceState(bundle0);
        this.f.e(bundle0);
    }

    @Override  // android.app.Activity
    public void onTrimMemory(int v) {
        super.onTrimMemory(v);
        for(Object object0: this.m) {
            ((androidx.core.util.a)object0).accept(v);
        }
    }

    @Override  // androidx.core.content.c
    public final void p(androidx.core.util.a a0) {
        this.m.remove(a0);
    }

    @Override  // androidx.core.content.c
    public final void q(androidx.core.util.a a0) {
        this.m.add(a0);
    }

    @Override  // androidx.core.content.b
    public final void r(androidx.core.util.a a0) {
        this.l.remove(a0);
    }

    @Override  // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if(b0.b.d()) {
                b0.b.a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
        }
        finally {
            b0.b.b();
        }
    }

    @Override  // android.app.Activity
    public void setContentView(int v) {
        this.A();
        super.setContentView(v);
    }

    @Override  // android.app.Activity
    public void setContentView(View view0) {
        this.A();
        super.setContentView(view0);
    }

    @Override  // android.app.Activity
    public void setContentView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.A();
        super.setContentView(view0, viewGroup$LayoutParams0);
    }

    @Override  // android.app.Activity
    public void startActivityForResult(Intent intent0, int v) {
        super.startActivityForResult(intent0, v);
    }

    @Override  // android.app.Activity
    public void startActivityForResult(Intent intent0, int v, Bundle bundle0) {
        super.startActivityForResult(intent0, v, bundle0);
    }

    @Override  // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender0, int v, Intent intent0, int v1, int v2, int v3) {
        super.startIntentSenderForResult(intentSender0, v, intent0, v1, v2, v3);
    }

    @Override  // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender0, int v, Intent intent0, int v1, int v2, int v3, Bundle bundle0) {
        super.startIntentSenderForResult(intentSender0, v, intent0, v1, v2, v3, bundle0);
    }

    public final void x(a.b b0) {
        this.c.a(b0);
    }

    public final void y(androidx.core.util.a a0) {
        this.n.add(a0);
    }

    void z() {
        if(this.g == null) {
            androidx.activity.ComponentActivity.e componentActivity$e0 = (androidx.activity.ComponentActivity.e)this.getLastNonConfigurationInstance();
            if(componentActivity$e0 != null) {
                this.g = componentActivity$e0.b;
            }
            if(this.g == null) {
                this.g = new c0();
            }
        }
    }
}

