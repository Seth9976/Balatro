package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.l;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.d;
import androidx.core.app.a.c;
import androidx.core.app.d0;
import androidx.core.app.e0;
import androidx.core.content.b;
import androidx.core.view.i;
import androidx.lifecycle.c0;
import androidx.lifecycle.h;
import androidx.lifecycle.m;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import z.e;

public abstract class j extends ComponentActivity implements c {
    class a extends p implements l, d, d0, e0, b, androidx.core.content.c, i, b0, androidx.lifecycle.d0, e {
        final j f;

        @Override  // androidx.fragment.app.p
        public void A() {
            this.B();
        }

        public void B() {
            j.this.B();
        }

        public j C() {
            return j.this;
        }

        @Override  // androidx.fragment.app.b0
        public void a(x x0, Fragment fragment0) {
        }

        @Override  // androidx.activity.l
        public OnBackPressedDispatcher c() {
            return j.this.c();
        }

        @Override  // z.e
        public z.c d() {
            return j.this.d();
        }

        @Override  // androidx.core.app.e0
        public void e(androidx.core.util.a a0) {
            j.this.e(a0);
        }

        @Override  // androidx.core.view.i
        public void f(androidx.core.view.l l0) {
            j.this.f(l0);
        }

        @Override  // androidx.core.view.i
        public void g(androidx.core.view.l l0) {
            j.this.g(l0);
        }

        @Override  // androidx.activity.result.d
        public ActivityResultRegistry h() {
            return j.this.h();
        }

        @Override  // androidx.fragment.app.l
        public View i(int v) {
            return j.this.findViewById(v);
        }

        @Override  // androidx.core.app.d0
        public void j(androidx.core.util.a a0) {
            j.this.j(a0);
        }

        @Override  // androidx.core.content.b
        public void k(androidx.core.util.a a0) {
            j.this.k(a0);
        }

        @Override  // androidx.lifecycle.d0
        public c0 l() {
            return j.this.l();
        }

        @Override  // androidx.core.app.d0
        public void m(androidx.core.util.a a0) {
            j.this.m(a0);
        }

        @Override  // androidx.core.app.e0
        public void n(androidx.core.util.a a0) {
            j.this.n(a0);
        }

        @Override  // androidx.lifecycle.l
        public h o() {
            return j.this.t;
        }

        @Override  // androidx.core.content.c
        public void p(androidx.core.util.a a0) {
            j.this.p(a0);
        }

        @Override  // androidx.core.content.c
        public void q(androidx.core.util.a a0) {
            j.this.q(a0);
        }

        @Override  // androidx.core.content.b
        public void r(androidx.core.util.a a0) {
            j.this.r(a0);
        }

        @Override  // androidx.fragment.app.l
        public boolean s() {
            Window window0 = j.this.getWindow();
            return window0 != null && window0.peekDecorView() != null;
        }

        @Override  // androidx.fragment.app.p
        public void w(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
            j.this.dump(s, fileDescriptor0, printWriter0, arr_s);
        }

        @Override  // androidx.fragment.app.p
        public Object x() {
            return this.C();
        }

        @Override  // androidx.fragment.app.p
        public LayoutInflater y() {
            return j.this.getLayoutInflater().cloneInContext(j.this);
        }
    }

    final n s;
    final m t;
    boolean u;
    boolean v;
    boolean w;

    public j() {
        this.s = n.b(new a(this));
        this.t = new m(this);
        this.w = true;
        this.O();
    }

    final View L(View view0, String s, Context context0, AttributeSet attributeSet0) {
        return this.s.n(view0, s, context0, attributeSet0);
    }

    public x M() {
        return this.s.l();
    }

    public androidx.loader.app.a N() {
        return androidx.loader.app.a.b(this);
    }

    private void O() {
        this.d().h("android:support:lifecycle", () -> {
            this.T();
            this.t.h(androidx.lifecycle.h.b.ON_STOP);
            return new Bundle();
        });
        this.k((Configuration configuration0) -> this.s.m());
        this.y((Intent intent0) -> this.s.m());
        this.x((Context context0) -> this.s.a(null));
    }

    // 检测为 Lambda 实现
    private Bundle P() [...]

    // 检测为 Lambda 实现
    private void Q(Configuration configuration0) [...]

    // 检测为 Lambda 实现
    private void R(Intent intent0) [...]

    // 检测为 Lambda 实现
    private void S(Context context0) [...]

    void T() {
        while(j.U(this.M(), androidx.lifecycle.h.c.g)) {
        }
    }

    private static boolean U(x x0, androidx.lifecycle.h.c h$c0) {
        boolean z = false;
        for(Object object0: x0.s0()) {
            Fragment fragment0 = (Fragment)object0;
            if(fragment0 != null) {
                if(fragment0.B() != null) {
                    z |= j.U(fragment0.s(), h$c0);
                }
                if(fragment0.U != null && fragment0.U.o().b().c(androidx.lifecycle.h.c.h)) {
                    fragment0.U.i(h$c0);
                    z = true;
                }
                if(fragment0.T.b().c(androidx.lifecycle.h.c.h)) {
                    fragment0.T.o(h$c0);
                    z = true;
                }
            }
        }
        return z;
    }

    public void V(Fragment fragment0) {
    }

    protected void W() {
        this.t.h(androidx.lifecycle.h.b.ON_RESUME);
        this.s.h();
    }

    @Override  // androidx.core.app.a$c
    public final void b(int v) {
    }

    @Override  // android.app.Activity
    public void dump(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        super.dump(s, fileDescriptor0, printWriter0, arr_s);
        if(!this.s(arr_s)) {
            return;
        }
        printWriter0.print(s);
        printWriter0.print("Local FragmentActivity ");
        printWriter0.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter0.println(" State:");
        printWriter0.print(s + "  ");
        printWriter0.print("mCreated=");
        printWriter0.print(this.u);
        printWriter0.print(" mResumed=");
        printWriter0.print(this.v);
        printWriter0.print(" mStopped=");
        printWriter0.print(this.w);
        if(this.getApplication() != null) {
            androidx.loader.app.a.b(this).a(s + "  ", fileDescriptor0, printWriter0, arr_s);
        }
        this.s.l().W(s, fileDescriptor0, printWriter0, arr_s);
    }

    @Override  // androidx.activity.ComponentActivity
    protected void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.t.h(androidx.lifecycle.h.b.ON_CREATE);
        this.s.e();
    }

    @Override  // android.app.Activity
    public View onCreateView(View view0, String s, Context context0, AttributeSet attributeSet0) {
        View view1 = this.L(view0, s, context0, attributeSet0);
        return view1 == null ? super.onCreateView(view0, s, context0, attributeSet0) : view1;
    }

    @Override  // android.app.Activity
    public View onCreateView(String s, Context context0, AttributeSet attributeSet0) {
        View view0 = this.L(null, s, context0, attributeSet0);
        return view0 == null ? super.onCreateView(s, context0, attributeSet0) : view0;
    }

    @Override  // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.s.f();
        this.t.h(androidx.lifecycle.h.b.ON_DESTROY);
    }

    @Override  // androidx.activity.ComponentActivity
    public boolean onMenuItemSelected(int v, MenuItem menuItem0) {
        if(super.onMenuItemSelected(v, menuItem0)) {
            return true;
        }
        return v == 6 ? this.s.d(menuItem0) : false;
    }

    @Override  // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.v = false;
        this.s.g();
        this.t.h(androidx.lifecycle.h.b.ON_PAUSE);
    }

    @Override  // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.W();
    }

    @Override  // androidx.activity.ComponentActivity
    public void onRequestPermissionsResult(int v, String[] arr_s, int[] arr_v) {
        this.s.m();
        super.onRequestPermissionsResult(v, arr_s, arr_v);
    }

    @Override  // android.app.Activity
    protected void onResume() {
        this.s.m();
        super.onResume();
        this.v = true;
        this.s.k();
    }

    @Override  // android.app.Activity
    protected void onStart() {
        this.s.m();
        super.onStart();
        this.w = false;
        if(!this.u) {
            this.u = true;
            this.s.c();
        }
        this.s.k();
        this.t.h(androidx.lifecycle.h.b.ON_START);
        this.s.i();
    }

    @Override  // android.app.Activity
    public void onStateNotSaved() {
        this.s.m();
    }

    @Override  // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.w = true;
        this.T();
        this.s.j();
        this.t.h(androidx.lifecycle.h.b.ON_STOP);
    }
}

