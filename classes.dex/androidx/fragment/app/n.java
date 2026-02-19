package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.core.util.c;

public class n {
    private final p a;

    private n(p p0) {
        this.a = p0;
    }

    public void a(Fragment fragment0) {
        this.a.e.m(this.a, this.a, fragment0);
    }

    public static n b(p p0) {
        return new n(((p)c.e(p0, "callbacks == null")));
    }

    public void c() {
        this.a.e.x();
    }

    public boolean d(MenuItem menuItem0) {
        return this.a.e.A(menuItem0);
    }

    public void e() {
        this.a.e.B();
    }

    public void f() {
        this.a.e.D();
    }

    public void g() {
        this.a.e.M();
    }

    public void h() {
        this.a.e.Q();
    }

    public void i() {
        this.a.e.R();
    }

    public void j() {
        this.a.e.T();
    }

    public boolean k() {
        return this.a.e.a0(true);
    }

    public x l() {
        return this.a.e;
    }

    public void m() {
        this.a.e.V0();
    }

    public View n(View view0, String s, Context context0, AttributeSet attributeSet0) {
        return this.a.e.u0().onCreateView(view0, s, context0, attributeSet0);
    }
}

