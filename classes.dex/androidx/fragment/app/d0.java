package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.v;
import androidx.lifecycle.h.c;

class d0 {
    static abstract class b {
        static final int[] a;

        static {
            int[] arr_v = new int[c.values().length];
            b.a = arr_v;
            try {
                arr_v[c.i.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[c.h.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[c.g.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[c.f.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

    private final r a;
    private final e0 b;
    private final Fragment c;
    private boolean d;
    private int e;

    d0(r r0, e0 e00, Fragment fragment0) {
        this.d = false;
        this.e = -1;
        this.a = r0;
        this.b = e00;
        this.c = fragment0;
    }

    d0(r r0, e0 e00, Fragment fragment0, c0 c00) {
        this.d = false;
        this.e = -1;
        this.a = r0;
        this.b = e00;
        this.c = fragment0;
        fragment0.c = null;
        fragment0.d = null;
        fragment0.s = 0;
        fragment0.p = false;
        fragment0.l = false;
        fragment0.i = fragment0.h == null ? null : fragment0.h.f;
        fragment0.h = null;
        fragment0.b = c00.q == null ? new Bundle() : c00.q;
    }

    d0(r r0, e0 e00, ClassLoader classLoader0, o o0, c0 c00) {
        this.d = false;
        this.e = -1;
        this.a = r0;
        this.b = e00;
        Fragment fragment0 = c00.o(o0, classLoader0);
        this.c = fragment0;
        if(x.G0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragment0);
        }
    }

    void a() {
        if(x.G0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.c);
        }
        this.c.N0(this.c.b);
        this.a.a(this.c, this.c.b, false);
    }

    void b() {
        int v = this.b.j(this.c);
        this.c.H.addView(this.c.I, v);
    }

    void c() {
        if(x.G0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.c);
        }
        Fragment fragment0 = this.c;
        Fragment fragment1 = fragment0.h;
        d0 d00 = null;
        if(fragment1 == null) {
            String s = fragment0.i;
            if(s != null) {
                d00 = this.b.n(s);
                if(d00 == null) {
                    throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.i + " that does not belong to this FragmentManager!");
                }
            }
        }
        else {
            d0 d01 = this.b.n(fragment1.f);
            if(d01 == null) {
                throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.h + " that does not belong to this FragmentManager!");
            }
            this.c.i = this.c.h.f;
            this.c.h = null;
            d00 = d01;
        }
        if(d00 != null) {
            d00.m();
        }
        this.c.u = this.c.t.t0();
        this.c.w = this.c.t.w0();
        this.a.g(this.c, false);
        this.c.O0();
        this.a.b(this.c, false);
    }

    int d() {
        Fragment fragment0 = this.c;
        if(fragment0.t == null) {
            return fragment0.a;
        }
        int v = this.e;
        switch(fragment0.S) {
            case 1: {
                break;
            }
            case 2: {
                v = Math.min(v, 5);
                break;
            }
            case 3: {
                v = Math.min(v, 1);
                break;
            }
            case 4: {
                v = Math.min(v, 0);
                break;
            }
            default: {
                v = Math.min(v, -1);
            }
        }
        Fragment fragment1 = this.c;
        if(fragment1.o) {
            if(fragment1.p) {
                v = Math.max(this.e, 2);
                View view0 = this.c.I;
                if(view0 != null && view0.getParent() == null) {
                    v = Math.min(v, 2);
                }
            }
            else {
                v = this.e >= 4 ? Math.min(v, 1) : Math.min(v, fragment1.a);
            }
        }
        if(!this.c.l) {
            v = Math.min(v, 1);
        }
        ViewGroup viewGroup0 = this.c.H;
        androidx.fragment.app.l0.e.b l0$e$b0 = viewGroup0 == null ? null : l0.n(viewGroup0, this.c.G()).l(this);
        if(l0$e$b0 == androidx.fragment.app.l0.e.b.f) {
            v = Math.min(v, 6);
        }
        else if(l0$e$b0 == androidx.fragment.app.l0.e.b.g) {
            v = Math.max(v, 3);
        }
        else {
            Fragment fragment2 = this.c;
            if(fragment2.m) {
                v = fragment2.a0() ? Math.min(v, 1) : Math.min(v, -1);
            }
        }
        if(this.c.J && this.c.a < 5) {
            v = Math.min(v, 4);
        }
        if(x.G0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + v + " for " + this.c);
        }
        return v;
    }

    void e() {
        if(x.G0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.c);
        }
        Fragment fragment0 = this.c;
        if(!fragment0.Q) {
            this.a.h(fragment0, fragment0.b, false);
            this.c.R0(this.c.b);
            this.a.c(this.c, this.c.b, false);
            return;
        }
        fragment0.p1(fragment0.b);
        this.c.a = 1;
    }

    void f() {
        class a implements View.OnAttachStateChangeListener {
            final View a;
            final d0 b;

            a(View view0) {
                this.a = view0;
                super();
            }

            @Override  // android.view.View$OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view0) {
                this.a.removeOnAttachStateChangeListener(this);
                v.E(this.a);
            }

            @Override  // android.view.View$OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view0) {
            }
        }

        String s;
        if(this.c.o) {
            return;
        }
        if(x.G0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
        }
        LayoutInflater layoutInflater0 = this.c.X0(this.c.b);
        Fragment fragment0 = this.c;
        ViewGroup viewGroup0 = fragment0.H;
        if(viewGroup0 == null) {
            switch(fragment0.y) {
                case -1: {
                    throw new IllegalArgumentException("Cannot create fragment " + this.c + " for a container view with no id");
                label_11:
                    viewGroup0 = (ViewGroup)fragment0.t.p0().i(this.c.y);
                    if(viewGroup0 == null) {
                        Fragment fragment1 = this.c;
                        if(!fragment1.q) {
                            try {
                                s = "unknown";
                                s = fragment1.M().getResourceName(this.c.y);
                            }
                            catch(Resources.NotFoundException unused_ex) {
                            }
                            throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.c.y) + " (" + s + ") for fragment " + this.c);
                        }
                    }
                    else if(!(viewGroup0 instanceof m)) {
                        v.c.i(this.c, viewGroup0);
                    }
                    break;
                }
                case 0: {
                    viewGroup0 = null;
                    break;
                }
                default: {
                    goto label_11;
                }
            }
        }
        this.c.H = viewGroup0;
        this.c.T0(layoutInflater0, viewGroup0, this.c.b);
        View view0 = this.c.I;
        if(view0 != null) {
            view0.setSaveFromParentEnabled(false);
            this.c.I.setTag(u.b.a, this.c);
            if(viewGroup0 != null) {
                this.b();
            }
            Fragment fragment2 = this.c;
            if(fragment2.A) {
                fragment2.I.setVisibility(8);
            }
            if(v.v(this.c.I)) {
                v.E(this.c.I);
            }
            else {
                View view1 = this.c.I;
                view1.addOnAttachStateChangeListener(new a(this, view1));
            }
            this.c.k1();
            this.a.m(this.c, this.c.I, this.c.b, false);
            int v = this.c.I.getVisibility();
            float f = this.c.I.getAlpha();
            this.c.x1(f);
            Fragment fragment3 = this.c;
            if(fragment3.H != null && v == 0) {
                View view2 = fragment3.I.findFocus();
                if(view2 != null) {
                    this.c.u1(view2);
                    if(x.G0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + view2 + " for Fragment " + this.c);
                    }
                }
                this.c.I.setAlpha(0.0f);
            }
        }
        this.c.a = 2;
    }

    void g() {
        if(x.G0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.c);
        }
        boolean z = true;
        boolean z1 = this.c.m && !this.c.a0();
        if(z1) {
            Fragment fragment0 = this.c;
            if(!fragment0.n) {
                this.b.B(fragment0.f, null);
            }
        }
        if(z1 || this.b.p().q(this.c)) {
            p p0 = this.c.u;
            if(p0 instanceof androidx.lifecycle.d0) {
                z = this.b.p().n();
            }
            else if(p0.u() instanceof Activity) {
                z = true ^ ((Activity)p0.u()).isChangingConfigurations();
            }
            if(z1 && !this.c.n || z) {
                this.b.p().f(this.c);
            }
            this.c.U0();
            this.a.d(this.c, false);
            for(Object object0: this.b.k()) {
                d0 d00 = (d0)object0;
                if(d00 != null) {
                    Fragment fragment1 = d00.k();
                    if(this.c.f.equals(fragment1.i)) {
                        fragment1.h = this.c;
                        fragment1.i = null;
                    }
                }
            }
            Fragment fragment2 = this.c;
            String s = fragment2.i;
            if(s != null) {
                fragment2.h = this.b.f(s);
            }
            this.b.s(this);
            return;
        }
        String s1 = this.c.i;
        if(s1 != null) {
            Fragment fragment3 = this.b.f(s1);
            if(fragment3 != null && fragment3.C) {
                this.c.h = fragment3;
            }
        }
        this.c.a = 0;
    }

    void h() {
        if(x.G0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.c);
        }
        Fragment fragment0 = this.c;
        ViewGroup viewGroup0 = fragment0.H;
        if(viewGroup0 != null) {
            View view0 = fragment0.I;
            if(view0 != null) {
                viewGroup0.removeView(view0);
            }
        }
        this.c.V0();
        this.a.n(this.c, false);
        this.c.H = null;
        this.c.I = null;
        this.c.U = null;
        this.c.V.n(null);
        this.c.p = false;
    }

    void i() {
        if(x.G0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.c);
        }
        this.c.W0();
        boolean z = false;
        this.a.e(this.c, false);
        this.c.a = -1;
        this.c.u = null;
        this.c.w = null;
        this.c.t = null;
        if(this.c.m && !this.c.a0()) {
            z = true;
        }
        if(z || this.b.p().q(this.c)) {
            if(x.G0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.c);
            }
            this.c.W();
        }
    }

    void j() {
        if(this.c.o && this.c.p && !this.c.r) {
            if(x.G0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
            }
            LayoutInflater layoutInflater0 = this.c.X0(this.c.b);
            this.c.T0(layoutInflater0, null, this.c.b);
            View view0 = this.c.I;
            if(view0 != null) {
                view0.setSaveFromParentEnabled(false);
                this.c.I.setTag(u.b.a, this.c);
                Fragment fragment0 = this.c;
                if(fragment0.A) {
                    fragment0.I.setVisibility(8);
                }
                this.c.k1();
                this.a.m(this.c, this.c.I, this.c.b, false);
                this.c.a = 2;
            }
        }
    }

    Fragment k() {
        return this.c;
    }

    private boolean l(View view0) {
        if(view0 == this.c.I) {
            return true;
        }
        for(ViewParent viewParent0 = view0.getParent(); viewParent0 != null; viewParent0 = viewParent0.getParent()) {
            if(viewParent0 == this.c.I) {
                return true;
            }
        }
        return false;
    }

    void m() {
        if(this.d) {
            if(x.G0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + this.k());
            }
            return;
        }
        try {
            this.d = true;
            boolean z;
            for(z = false; true; z = true) {
                int v1 = this.d();
                Fragment fragment0 = this.c;
                int v2 = fragment0.a;
                if(v1 == v2) {
                    break;
                }
                if(v1 > v2) {
                    switch(v2 + 1) {
                        case 0: {
                            this.c();
                            break;
                        }
                        case 1: {
                            this.e();
                            break;
                        }
                        case 2: {
                            this.j();
                            this.f();
                            break;
                        }
                        case 3: {
                            this.a();
                            break;
                        }
                        case 4: {
                            if(fragment0.I != null) {
                                ViewGroup viewGroup0 = fragment0.H;
                                if(viewGroup0 != null) {
                                    l0.n(viewGroup0, fragment0.G()).b(androidx.fragment.app.l0.e.c.j(this.c.I.getVisibility()), this);
                                }
                            }
                            this.c.a = 4;
                            break;
                        }
                        case 5: {
                            this.u();
                            break;
                        }
                        case 6: {
                            fragment0.a = 6;
                            break;
                        }
                        case 7: {
                            this.p();
                        }
                    }
                }
                else {
                    switch(v2 - 1) {
                        case -1: {
                            this.i();
                            break;
                        }
                        case 0: {
                            if(fragment0.n && this.b.q(fragment0.f) == null) {
                                this.r();
                            }
                            this.g();
                            break;
                        }
                        case 1: {
                            this.h();
                            this.c.a = 1;
                            break;
                        }
                        case 2: {
                            fragment0.p = false;
                            fragment0.a = 2;
                            break;
                        }
                        case 3: {
                            if(x.G0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.c);
                            }
                            Fragment fragment1 = this.c;
                            if(fragment1.n) {
                                this.r();
                            }
                            else if(fragment1.I != null && fragment1.c == null) {
                                this.s();
                            }
                            Fragment fragment2 = this.c;
                            if(fragment2.I != null) {
                                ViewGroup viewGroup1 = fragment2.H;
                                if(viewGroup1 != null) {
                                    l0.n(viewGroup1, fragment2.G()).d(this);
                                }
                            }
                            this.c.a = 3;
                            break;
                        }
                        case 4: {
                            this.v();
                            break;
                        }
                        case 5: {
                            fragment0.a = 5;
                            break;
                        }
                        case 6: {
                            this.n();
                        }
                    }
                }
            }
            if(!z && v2 == -1 && fragment0.m && !fragment0.a0() && !this.c.n) {
                if(x.G0(3)) {
                    Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.c);
                }
                this.b.p().f(this.c);
                this.b.s(this);
                if(x.G0(3)) {
                    Log.d("FragmentManager", "initState called for fragment: " + this.c);
                }
                this.c.W();
            }
            Fragment fragment3 = this.c;
            if(fragment3.O) {
                if(fragment3.I != null) {
                    ViewGroup viewGroup2 = fragment3.H;
                    if(viewGroup2 != null) {
                        l0 l00 = l0.n(viewGroup2, fragment3.G());
                        if(this.c.A) {
                            l00.c(this);
                        }
                        else {
                            l00.e(this);
                        }
                    }
                }
                Fragment fragment4 = this.c;
                x x0 = fragment4.t;
                if(x0 != null) {
                    x0.E0(fragment4);
                }
                this.c.O = false;
                this.c.v.I();
            }
        }
        finally {
            this.d = false;
        }
    }

    void n() {
        if(x.G0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.c);
        }
        this.c.c1();
        this.a.f(this.c, false);
    }

    void o(ClassLoader classLoader0) {
        Bundle bundle0 = this.c.b;
        if(bundle0 == null) {
            return;
        }
        bundle0.setClassLoader(classLoader0);
        this.c.c = this.c.b.getSparseParcelableArray("android:view_state");
        this.c.d = this.c.b.getBundle("android:view_registry_state");
        this.c.i = this.c.b.getString("android:target_state");
        Fragment fragment0 = this.c;
        if(fragment0.i != null) {
            fragment0.j = fragment0.b.getInt("android:target_req_state", 0);
        }
        Fragment fragment1 = this.c;
        Boolean boolean0 = fragment1.e;
        if(boolean0 == null) {
            fragment1.K = fragment1.b.getBoolean("android:user_visible_hint", true);
        }
        else {
            fragment1.K = boolean0.booleanValue();
            this.c.e = null;
        }
        Fragment fragment2 = this.c;
        if(!fragment2.K) {
            fragment2.J = true;
        }
    }

    void p() {
        if(x.G0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.c);
        }
        View view0 = this.c.A();
        if(view0 != null && this.l(view0)) {
            boolean z = view0.requestFocus();
            if(x.G0(2)) {
                Log.v("FragmentManager", "requestFocus: Restoring focused view " + view0 + " " + (z ? "succeeded" : "failed") + " on Fragment " + this.c + " resulting in focused view " + this.c.I.findFocus());
            }
        }
        this.c.u1(null);
        this.c.g1();
        this.a.i(this.c, false);
        this.c.b = null;
        this.c.c = null;
        this.c.d = null;
    }

    private Bundle q() {
        Bundle bundle0 = new Bundle();
        this.c.h1(bundle0);
        this.a.j(this.c, bundle0, false);
        if(bundle0.isEmpty()) {
            bundle0 = null;
        }
        if(this.c.I != null) {
            this.s();
        }
        if(this.c.c != null) {
            if(bundle0 == null) {
                bundle0 = new Bundle();
            }
            bundle0.putSparseParcelableArray("android:view_state", this.c.c);
        }
        if(this.c.d != null) {
            if(bundle0 == null) {
                bundle0 = new Bundle();
            }
            bundle0.putBundle("android:view_registry_state", this.c.d);
        }
        if(!this.c.K) {
            if(bundle0 == null) {
                bundle0 = new Bundle();
            }
            bundle0.putBoolean("android:user_visible_hint", this.c.K);
        }
        return bundle0;
    }

    void r() {
        c0 c00 = new c0(this.c);
        Fragment fragment0 = this.c;
        if(fragment0.a <= -1 || c00.q != null) {
            c00.q = fragment0.b;
        }
        else {
            Bundle bundle0 = this.q();
            c00.q = bundle0;
            if(this.c.i != null) {
                if(bundle0 == null) {
                    c00.q = new Bundle();
                }
                c00.q.putString("android:target_state", this.c.i);
                int v = this.c.j;
                if(v != 0) {
                    c00.q.putInt("android:target_req_state", v);
                }
            }
        }
        this.b.B(this.c.f, c00);
    }

    void s() {
        if(this.c.I == null) {
            return;
        }
        if(x.G0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.c + " with view " + this.c.I);
        }
        SparseArray sparseArray0 = new SparseArray();
        this.c.I.saveHierarchyState(sparseArray0);
        if(sparseArray0.size() > 0) {
            this.c.c = sparseArray0;
        }
        Bundle bundle0 = new Bundle();
        this.c.U.h(bundle0);
        if(!bundle0.isEmpty()) {
            this.c.d = bundle0;
        }
    }

    void t(int v) {
        this.e = v;
    }

    void u() {
        if(x.G0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.c);
        }
        this.c.i1();
        this.a.k(this.c, false);
    }

    void v() {
        if(x.G0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.c);
        }
        this.c.j1();
        this.a.l(this.c, false);
    }
}

