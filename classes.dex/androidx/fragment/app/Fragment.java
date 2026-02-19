package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.OnCreateContextMenuListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.h0;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;
import androidx.lifecycle.g;
import androidx.lifecycle.h.c;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.p;
import androidx.lifecycle.v;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import z.d;
import z.e;

public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, d0, g, l, e {
    class a implements Runnable {
        final Fragment e;

        @Override
        public void run() {
            Fragment.this.A1();
        }
    }

    class b extends i {
        final Fragment a;

        b() {
            super(null);
        }

        @Override  // androidx.fragment.app.Fragment$i
        void a() {
            Fragment.this.X.c();
            v.a(Fragment.this);
        }
    }

    static class f {
        View a;
        boolean b;
        int c;
        int d;
        int e;
        int f;
        int g;
        ArrayList h;
        ArrayList i;
        Object j;
        Object k;
        Object l;
        Object m;
        Object n;
        Object o;
        Boolean p;
        Boolean q;
        float r;
        View s;
        boolean t;

        f() {
            this.j = null;
            this.k = Fragment.c0;
            this.l = null;
            this.m = Fragment.c0;
            this.n = null;
            this.o = Fragment.c0;
            this.r = 1.0f;
            this.s = null;
        }
    }

    static abstract class androidx.fragment.app.Fragment.g {
        static void a(View view0) {
            view0.cancelPendingInputEvents();
        }
    }

    public static class h extends RuntimeException {
        public h(String s, Exception exception0) {
            super(s, exception0);
        }
    }

    static abstract class i {
        private i() {
        }

        i(a fragment$a0) {
        }

        abstract void a();
    }

    boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    private boolean G;
    ViewGroup H;
    View I;
    boolean J;
    boolean K;
    f L;
    Handler M;
    Runnable N;
    boolean O;
    LayoutInflater P;
    boolean Q;
    public String R;
    c S;
    m T;
    j0 U;
    p V;
    androidx.lifecycle.z.b W;
    d X;
    private int Y;
    private final AtomicInteger Z;
    int a;
    private final ArrayList a0;
    Bundle b;
    private final i b0;
    SparseArray c;
    static final Object c0;
    Bundle d;
    Boolean e;
    String f;
    Bundle g;
    Fragment h;
    String i;
    int j;
    private Boolean k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    int s;
    x t;
    androidx.fragment.app.p u;
    x v;
    Fragment w;
    int x;
    int y;
    String z;

    static {
        Fragment.c0 = new Object();
    }

    public Fragment() {
        this.a = -1;
        this.f = "b1bddedb-3cf9-4827-89fb-4094feb1790a";
        this.i = null;
        this.k = null;
        this.v = new y();
        this.F = true;
        this.K = true;
        this.N = () -> {
            class androidx.fragment.app.Fragment.c implements Runnable {
                final Fragment e;

                @Override
                public void run() {
                    Fragment.this.g(false);
                }
            }

            if(Fragment.this.L != null && Fragment.this.j().t) {
                if(Fragment.this.u == null) {
                    Fragment.this.j().t = false;
                    return;
                }
                if(Looper.myLooper() != Fragment.this.u.v().getLooper()) {
                    Fragment.this.u.v().postAtFrontOfQueue(() -> {
                        class androidx.fragment.app.Fragment.d implements Runnable {
                            final l0 e;
                            final Fragment f;

                            androidx.fragment.app.Fragment.d(l0 l00) {
                                this.e = l00;
                                super();
                            }

                            @Override
                            public void run() {
                                this.e.g();
                            }
                        }

                        f fragment$f0 = Fragment.this.L;
                        if(fragment$f0 != null) {
                            fragment$f0.t = false;
                        }
                        if(Fragment.this.I != null) {
                            ViewGroup viewGroup0 = Fragment.this.H;
                            if(viewGroup0 != null) {
                                x x0 = Fragment.this.t;
                                if(x0 != null) {
                                    l0 l00 = l0.n(viewGroup0, x0);
                                    l00.p();
                                    if(false) {
                                        Fragment.this.u.v().post(new androidx.fragment.app.Fragment.d(Fragment.this, l00));
                                    }
                                    else {
                                        l00.g();
                                    }
                                    Handler handler0 = Fragment.this.M;
                                    if(handler0 != null) {
                                        handler0.removeCallbacks(Fragment.this.N);
                                        Fragment.this.M = null;
                                    }
                                }
                            }
                        }
                    });
                    return;
                }
                Fragment.this.g(true);
            }
        };
        this.S = c.i;
        this.V = new p();
        this.Z = new AtomicInteger();
        this.a0 = new ArrayList();
        this.b0 = new b(this);
        this.V();
    }

    View A() {
        return this.L == null ? null : this.L.s;
    }

    public boolean A0(MenuItem menuItem0) [...] // Inlined contents

    // 检测为 Lambda 实现
    public void A1() [...]

    public final Object B() {
        return this.u == null ? null : this.u.x();
    }

    public void B0(Menu menu0) {
    }

    public LayoutInflater C(Bundle bundle0) {
        androidx.fragment.app.p p0 = this.u;
        if(p0 == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflater0 = p0.y();
        androidx.core.view.g.a(layoutInflater0, this.v.u0());
        return layoutInflater0;
    }

    public void C0() {
        this.G = true;
    }

    private int D() {
        return this.S == c.f || this.w == null ? this.S.ordinal() : Math.min(this.S.ordinal(), this.w.D());
    }

    public void D0(boolean z) {
    }

    int E() {
        return this.L == null ? 0 : this.L.g;
    }

    public void E0(Menu menu0) {
    }

    public final Fragment F() {
        return this.w;
    }

    public void F0(boolean z) {
    }

    public final x G() {
        x x0 = this.t;
        if(x0 == null) {
            throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
        }
        return x0;
    }

    public void G0(int v, String[] arr_s, int[] arr_v) {
    }

    boolean H() {
        return this.L == null ? false : this.L.b;
    }

    public void H0() {
        this.G = true;
    }

    int I() {
        return this.L == null ? 0 : this.L.e;
    }

    public void I0(Bundle bundle0) {
    }

    int J() {
        return this.L == null ? 0 : this.L.f;
    }

    public void J0() {
        this.G = true;
    }

    float K() {
        return this.L == null ? 1.0f : this.L.r;
    }

    public void K0() {
        this.G = true;
    }

    public Object L() {
        f fragment$f0 = this.L;
        if(fragment$f0 == null) {
            return null;
        }
        return fragment$f0.m == Fragment.c0 ? this.y() : fragment$f0.m;
    }

    public void L0(View view0, Bundle bundle0) {
    }

    public final Resources M() {
        return this.n1().getResources();
    }

    public void M0(Bundle bundle0) {
        this.G = true;
    }

    public Object N() {
        f fragment$f0 = this.L;
        if(fragment$f0 == null) {
            return null;
        }
        return fragment$f0.k == Fragment.c0 ? this.v() : fragment$f0.k;
    }

    void N0(Bundle bundle0) {
        this.v.V0();
        this.a = 3;
        this.G = false;
        this.g0(bundle0);
        throw new n0("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public Object O() {
        return this.L == null ? null : this.L.n;
    }

    void O0() {
        for(Object object0: this.a0) {
            ((i)object0).a();
        }
        this.a0.clear();
        this.v.m(this.u, this.h(), this);
        this.a = 0;
        this.G = false;
        this.j0(this.u.u());
        if(!this.G) {
            throw new n0("Fragment " + this + " did not call through to super.onAttach()");
        }
        this.t.H(this);
        this.v.y();
    }

    public Object P() {
        f fragment$f0 = this.L;
        if(fragment$f0 == null) {
            return null;
        }
        return fragment$f0.o == Fragment.c0 ? this.O() : fragment$f0.o;
    }

    void P0(Configuration configuration0) {
        this.onConfigurationChanged(configuration0);
    }

    ArrayList Q() {
        f fragment$f0 = this.L;
        if(fragment$f0 != null) {
            ArrayList arrayList0 = fragment$f0.h;
            return arrayList0 == null ? new ArrayList() : arrayList0;
        }
        return new ArrayList();
    }

    boolean Q0(MenuItem menuItem0) {
        return this.A ? false : this.v.A(menuItem0);
    }

    ArrayList R() {
        f fragment$f0 = this.L;
        if(fragment$f0 != null) {
            ArrayList arrayList0 = fragment$f0.i;
            return arrayList0 == null ? new ArrayList() : arrayList0;
        }
        return new ArrayList();
    }

    void R0(Bundle bundle0) {
        this.v.V0();
        this.a = 1;
        this.G = false;
        this.T.a(new j() {
            final Fragment a;

            @Override  // androidx.lifecycle.j
            public void d(l l0, androidx.lifecycle.h.b h$b0) {
                if(h$b0 == androidx.lifecycle.h.b.ON_STOP) {
                    View view0 = Fragment.this.I;
                    if(view0 != null) {
                        androidx.fragment.app.Fragment.g.a(view0);
                    }
                }
            }
        });
        this.X.d(bundle0);
        this.m0(bundle0);
        this.Q = true;
        throw new n0("Fragment " + this + " did not call through to super.onCreate()");
    }

    private Fragment S(boolean z) {
        if(z) {
            v.c.h(this);
        }
        Fragment fragment0 = this.h;
        if(fragment0 != null) {
            return fragment0;
        }
        x x0 = this.t;
        if(x0 != null) {
            return this.i == null ? null : x0.e0(this.i);
        }
        return null;
    }

    boolean S0(Menu menu0, MenuInflater menuInflater0) {
        boolean z = false;
        if(!this.A) {
            if(this.E && this.F) {
                z = true;
            }
            return z | this.v.C(menu0, menuInflater0);
        }
        return false;
    }

    public View T() {
        return this.I;
    }

    void T0(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        this.v.V0();
        this.r = true;
        this.U = new j0(this, this.l());
        View view0 = this.q0(layoutInflater0, viewGroup0, bundle0);
        this.I = view0;
        if(view0 != null) {
            this.U.e();
            e0.a(this.I, this.U);
            f0.a(this.I, this.U);
            z.f.a(this.I, this.U);
            this.V.n(this.U);
            return;
        }
        if(this.U.f()) {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
        this.U = null;
    }

    public LiveData U() {
        return this.V;
    }

    void U0() {
        this.v.D();
        this.T.h(androidx.lifecycle.h.b.ON_DESTROY);
        this.a = 0;
        this.G = false;
        this.Q = false;
        this.r0();
        throw new n0("Fragment " + this + " did not call through to super.onDestroy()");
    }

    private void V() {
        this.T = new m(this);
        this.X = d.a(this);
        this.W = null;
        if(!this.a0.contains(this.b0)) {
            this.l1(this.b0);
        }
    }

    void V0() {
        this.v.E();
        if(this.I != null && this.U.o().b().c(c.g)) {
            this.U.b(androidx.lifecycle.h.b.ON_DESTROY);
        }
        this.a = 1;
        this.G = false;
        this.t0();
        if(!this.G) {
            throw new n0("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        androidx.loader.app.a.b(this).d();
        this.r = false;
    }

    void W() {
        this.V();
        this.R = this.f;
        this.f = "d76e7e9b-92d5-4f9d-9293-aa4348cb685e";
        this.l = false;
        this.m = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.s = 0;
        this.t = null;
        this.v = new y();
        this.u = null;
        this.x = 0;
        this.y = 0;
        this.z = null;
        this.A = false;
        this.B = false;
    }

    void W0() {
        this.a = -1;
        this.G = false;
        this.u0();
        this.P = null;
        throw new n0("Fragment " + this + " did not call through to super.onDetach()");
    }

    public static Fragment X(Context context0, String s, Bundle bundle0) {
        try {
            Fragment fragment0 = (Fragment)o.d(context0.getClassLoader(), s).getConstructor().newInstance();
            if(bundle0 != null) {
                bundle0.setClassLoader(fragment0.getClass().getClassLoader());
                fragment0.t1(bundle0);
            }
            return fragment0;
        }
        catch(InstantiationException instantiationException0) {
            throw new h("Unable to instantiate fragment " + s + ": make sure class name exists, is public, and has an empty constructor that is public", instantiationException0);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new h("Unable to instantiate fragment " + s + ": make sure class name exists, is public, and has an empty constructor that is public", illegalAccessException0);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new h("Unable to instantiate fragment " + s + ": could not find Fragment constructor", noSuchMethodException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw new h("Unable to instantiate fragment " + s + ": calling Fragment constructor caused an exception", invocationTargetException0);
        }
    }

    LayoutInflater X0(Bundle bundle0) {
        LayoutInflater layoutInflater0 = this.v0(bundle0);
        this.P = layoutInflater0;
        return layoutInflater0;
    }

    public final boolean Y() {
        return this.u != null && this.l;
    }

    void Y0() {
        this.onLowMemory();
    }

    // 去混淆评级： 低(30)
    public final boolean Z() {
        return this.A || this.t != null && this.t.J0(this.w);
    }

    void Z0(boolean z) {
    }

    @Override  // androidx.lifecycle.g
    public x.a a() {
        Application application0;
        for(Context context0 = this.n1().getApplicationContext(); true; context0 = ((ContextWrapper)context0).getBaseContext()) {
            application0 = null;
            if(!(context0 instanceof ContextWrapper)) {
                break;
            }
            if(context0 instanceof Application) {
                application0 = (Application)context0;
                break;
            }
        }
        if(application0 == null && x.G0(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + this.n1().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        x.a a0 = new x.d();
        if(application0 != null) {
            ((x.d)a0).b(androidx.lifecycle.z.a.d, application0);
        }
        ((x.d)a0).b(v.a, this);
        ((x.d)a0).b(v.b, this);
        if(this.r() != null) {
            ((x.d)a0).b(v.c, this.r());
        }
        return a0;
    }

    final boolean a0() {
        return this.s > 0;
    }

    boolean a1(MenuItem menuItem0) {
        return this.A ? false : this.v.J(menuItem0);
    }

    // 去混淆评级： 低(30)
    public final boolean b0() {
        return this.F && (this.t == null || this.t.K0(this.w));
    }

    void b1(Menu menu0) {
        if(!this.A) {
            this.v.K(menu0);
        }
    }

    boolean c0() {
        return this.L == null ? false : this.L.t;
    }

    void c1() {
        this.v.M();
        if(this.I != null) {
            this.U.b(androidx.lifecycle.h.b.ON_PAUSE);
        }
        this.T.h(androidx.lifecycle.h.b.ON_PAUSE);
        this.a = 6;
        this.G = false;
        this.C0();
        if(!this.G) {
            throw new n0("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    @Override  // z.e
    public final z.c d() {
        return this.X.b();
    }

    public final boolean d0() {
        return this.m;
    }

    void d1(boolean z) {
    }

    public final boolean e0() {
        return this.t == null ? false : this.t.N0();
    }

    boolean e1(Menu menu0) {
        boolean z = false;
        if(!this.A) {
            if(this.E && this.F) {
                z = true;
            }
            return z | this.v.O(menu0);
        }
        return false;
    }

    @Override
    public final boolean equals(Object object0) {
        return super.equals(object0);
    }

    void f0() {
        this.v.V0();
    }

    void f1() {
        boolean z = this.t.L0(this);
        if(this.k == null || this.k.booleanValue() != z) {
            this.k = Boolean.valueOf(z);
            this.v.P();
        }
    }

    // 检测为 Lambda 实现
    void g(boolean z) [...]

    public void g0(Bundle bundle0) {
        this.G = true;
    }

    void g1() {
        this.v.V0();
        this.v.a0(true);
        this.a = 7;
        this.G = false;
        this.H0();
        throw new n0("Fragment " + this + " did not call through to super.onResume()");
    }

    androidx.fragment.app.l h() {
        class androidx.fragment.app.Fragment.e extends androidx.fragment.app.l {
            final Fragment a;

            @Override  // androidx.fragment.app.l
            public View i(int v) {
                View view0 = Fragment.this.I;
                if(view0 == null) {
                    throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
                }
                return view0.findViewById(v);
            }

            @Override  // androidx.fragment.app.l
            public boolean s() {
                return Fragment.this.I != null;
            }
        }

        return new androidx.fragment.app.Fragment.e(this);
    }

    public void h0(int v, int v1, Intent intent0) {
        if(x.G0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + v + " resultCode: " + v1 + " data: " + intent0);
        }
    }

    void h1(Bundle bundle0) {
        this.I0(bundle0);
        this.X.e(bundle0);
        Bundle bundle1 = this.v.i1();
        if(bundle1 != null) {
            bundle0.putParcelable("android:support:fragments", bundle1);
        }
    }

    @Override
    public final int hashCode() {
        return super.hashCode();
    }

    public void i(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        printWriter0.print(s);
        printWriter0.print("mFragmentId=#");
        printWriter0.print(Integer.toHexString(this.x));
        printWriter0.print(" mContainerId=#");
        printWriter0.print(Integer.toHexString(this.y));
        printWriter0.print(" mTag=");
        printWriter0.println(this.z);
        printWriter0.print(s);
        printWriter0.print("mState=");
        printWriter0.print(this.a);
        printWriter0.print(" mWho=");
        printWriter0.print(this.f);
        printWriter0.print(" mBackStackNesting=");
        printWriter0.println(this.s);
        printWriter0.print(s);
        printWriter0.print("mAdded=");
        printWriter0.print(this.l);
        printWriter0.print(" mRemoving=");
        printWriter0.print(this.m);
        printWriter0.print(" mFromLayout=");
        printWriter0.print(this.o);
        printWriter0.print(" mInLayout=");
        printWriter0.println(this.p);
        printWriter0.print(s);
        printWriter0.print("mHidden=");
        printWriter0.print(this.A);
        printWriter0.print(" mDetached=");
        printWriter0.print(this.B);
        printWriter0.print(" mMenuVisible=");
        printWriter0.print(this.F);
        printWriter0.print(" mHasMenu=");
        printWriter0.println(this.E);
        printWriter0.print(s);
        printWriter0.print("mRetainInstance=");
        printWriter0.print(this.C);
        printWriter0.print(" mUserVisibleHint=");
        printWriter0.println(this.K);
        if(this.t != null) {
            printWriter0.print(s);
            printWriter0.print("mFragmentManager=");
            printWriter0.println(this.t);
        }
        if(this.u != null) {
            printWriter0.print(s);
            printWriter0.print("mHost=");
            printWriter0.println(this.u);
        }
        if(this.w != null) {
            printWriter0.print(s);
            printWriter0.print("mParentFragment=");
            printWriter0.println(this.w);
        }
        if(this.g != null) {
            printWriter0.print(s);
            printWriter0.print("mArguments=");
            printWriter0.println(this.g);
        }
        if(this.b != null) {
            printWriter0.print(s);
            printWriter0.print("mSavedFragmentState=");
            printWriter0.println(this.b);
        }
        if(this.c != null) {
            printWriter0.print(s);
            printWriter0.print("mSavedViewState=");
            printWriter0.println(this.c);
        }
        if(this.d != null) {
            printWriter0.print(s);
            printWriter0.print("mSavedViewRegistryState=");
            printWriter0.println(this.d);
        }
        Fragment fragment0 = this.S(false);
        if(fragment0 != null) {
            printWriter0.print(s);
            printWriter0.print("mTarget=");
            printWriter0.print(fragment0);
            printWriter0.print(" mTargetRequestCode=");
            printWriter0.println(this.j);
        }
        printWriter0.print(s);
        printWriter0.print("mPopDirection=");
        printWriter0.println(this.H());
        if(this.u() != 0) {
            printWriter0.print(s);
            printWriter0.print("getEnterAnim=");
            printWriter0.println(this.u());
        }
        if(this.x() != 0) {
            printWriter0.print(s);
            printWriter0.print("getExitAnim=");
            printWriter0.println(this.x());
        }
        if(this.I() != 0) {
            printWriter0.print(s);
            printWriter0.print("getPopEnterAnim=");
            printWriter0.println(this.I());
        }
        if(this.J() != 0) {
            printWriter0.print(s);
            printWriter0.print("getPopExitAnim=");
            printWriter0.println(this.J());
        }
        if(this.H != null) {
            printWriter0.print(s);
            printWriter0.print("mContainer=");
            printWriter0.println(this.H);
        }
        if(this.I != null) {
            printWriter0.print(s);
            printWriter0.print("mView=");
            printWriter0.println(this.I);
        }
        if(this.q() != null) {
            printWriter0.print(s);
            printWriter0.print("mAnimatingAway=");
            printWriter0.println(this.q());
        }
        if(this.t() != null) {
            androidx.loader.app.a.b(this).a(s, fileDescriptor0, printWriter0, arr_s);
        }
        printWriter0.print(s);
        printWriter0.println("Child " + this.v + ":");
        this.v.W(s + "  ", fileDescriptor0, printWriter0, arr_s);
    }

    public void i0(Activity activity0) {
        this.G = true;
    }

    void i1() {
        this.v.V0();
        this.v.a0(true);
        this.a = 5;
        this.G = false;
        this.J0();
        throw new n0("Fragment " + this + " did not call through to super.onStart()");
    }

    private f j() {
        if(this.L == null) {
            this.L = new f();
        }
        return this.L;
    }

    public void j0(Context context0) {
        this.G = true;
        Activity activity0 = this.u == null ? null : this.u.t();
        if(activity0 != null) {
            this.G = false;
            this.i0(activity0);
        }
    }

    void j1() {
        this.v.T();
        if(this.I != null) {
            this.U.b(androidx.lifecycle.h.b.ON_STOP);
        }
        this.T.h(androidx.lifecycle.h.b.ON_STOP);
        this.a = 4;
        this.G = false;
        this.K0();
        if(!this.G) {
            throw new n0("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    // 去混淆评级： 低(20)
    Fragment k(String s) {
        return s.equals(this.f) ? this : this.v.i0(s);
    }

    public void k0(Fragment fragment0) {
    }

    void k1() {
        this.v.U();
    }

    @Override  // androidx.lifecycle.d0
    public c0 l() {
        if(this.t == null) {
            throw new IllegalStateException("Can\'t access ViewModels from detached fragment");
        }
        if(this.D() == c.f.ordinal()) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        return this.t.B0(this);
    }

    public boolean l0(MenuItem menuItem0) [...] // Inlined contents

    private void l1(i fragment$i0) {
        if(this.a >= 0) {
            fragment$i0.a();
            return;
        }
        this.a0.add(fragment$i0);
    }

    public final androidx.fragment.app.j m() {
        return this.u == null ? null : ((androidx.fragment.app.j)this.u.t());
    }

    public void m0(Bundle bundle0) {
        this.G = true;
        this.p1(bundle0);
        if(!this.v.M0(1)) {
            this.v.B();
        }
    }

    public final androidx.fragment.app.j m1() {
        androidx.fragment.app.j j0 = this.m();
        if(j0 == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
        }
        return j0;
    }

    public boolean n() {
        f fragment$f0 = this.L;
        if(fragment$f0 != null) {
            return fragment$f0.q == null ? true : fragment$f0.q.booleanValue();
        }
        return true;
    }

    public Animation n0(int v, boolean z, int v1) [...] // Inlined contents

    public final Context n1() {
        Context context0 = this.t();
        if(context0 == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to a context.");
        }
        return context0;
    }

    @Override  // androidx.lifecycle.l
    public androidx.lifecycle.h o() {
        return this.T;
    }

    public Animator o0(int v, boolean z, int v1) [...] // Inlined contents

    public final View o1() {
        View view0 = this.T();
        if(view0 == null) {
            throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
        }
        return view0;
    }

    @Override  // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration0) {
        this.G = true;
    }

    @Override  // android.view.View$OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu0, View view0, ContextMenu.ContextMenuInfo contextMenu$ContextMenuInfo0) {
        this.m1().onCreateContextMenu(contextMenu0, view0, contextMenu$ContextMenuInfo0);
    }

    @Override  // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.G = true;
    }

    public boolean p() {
        f fragment$f0 = this.L;
        if(fragment$f0 != null) {
            return fragment$f0.p == null ? true : fragment$f0.p.booleanValue();
        }
        return true;
    }

    public void p0(Menu menu0, MenuInflater menuInflater0) {
    }

    void p1(Bundle bundle0) {
        if(bundle0 != null) {
            Parcelable parcelable0 = bundle0.getParcelable("android:support:fragments");
            if(parcelable0 != null) {
                this.v.g1(parcelable0);
                this.v.B();
            }
        }
    }

    View q() {
        return this.L == null ? null : this.L.a;
    }

    public View q0(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return this.Y == 0 ? null : layoutInflater0.inflate(this.Y, viewGroup0, false);
    }

    private void q1() {
        if(x.G0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if(this.I != null) {
            this.r1(this.b);
        }
        this.b = null;
    }

    public final Bundle r() {
        return this.g;
    }

    public void r0() {
        this.G = true;
    }

    final void r1(Bundle bundle0) {
        SparseArray sparseArray0 = this.c;
        if(sparseArray0 != null) {
            this.I.restoreHierarchyState(sparseArray0);
            this.c = null;
        }
        if(this.I != null) {
            this.U.g(this.d);
            this.d = null;
        }
        this.G = false;
        this.M0(bundle0);
        if(!this.G) {
            throw new n0("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
        if(this.I != null) {
            this.U.b(androidx.lifecycle.h.b.ON_CREATE);
        }
    }

    public final x s() {
        if(this.u == null) {
            throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
        }
        return this.v;
    }

    public void s0() {
    }

    void s1(int v, int v1, int v2, int v3) {
        if(this.L == null && v == 0 && v1 == 0 && v2 == 0 && v3 == 0) {
            return;
        }
        this.j().c = v;
        this.j().d = v1;
        this.j().e = v2;
        this.j().f = v3;
    }

    public void startActivityForResult(Intent intent0, int v) {
        this.z1(intent0, v, null);
    }

    public Context t() {
        return this.u == null ? null : this.u.u();
    }

    public void t0() {
        this.G = true;
    }

    public void t1(Bundle bundle0) {
        if(this.t != null && this.e0()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.g = bundle0;
    }

    @Override
    public String toString() [...] // 潜在的解密器

    int u() {
        return this.L == null ? 0 : this.L.c;
    }

    public void u0() {
        this.G = true;
    }

    void u1(View view0) {
        this.j().s = view0;
    }

    public Object v() {
        return this.L == null ? null : this.L.j;
    }

    public LayoutInflater v0(Bundle bundle0) {
        return this.C(bundle0);
    }

    void v1(int v) {
        if(this.L == null && v == 0) {
            return;
        }
        this.j();
        this.L.g = v;
    }

    h0 w() {
        f fragment$f0 = this.L;
        if(fragment$f0 == null) {
            return null;
        }
        fragment$f0.getClass();
        return null;
    }

    public void w0(boolean z) {
    }

    void w1(boolean z) {
        if(this.L == null) {
            return;
        }
        this.j().b = z;
    }

    int x() {
        return this.L == null ? 0 : this.L.d;
    }

    public void x0(Activity activity0, AttributeSet attributeSet0, Bundle bundle0) {
        this.G = true;
    }

    void x1(float f) {
        this.j().r = f;
    }

    public Object y() {
        return this.L == null ? null : this.L.l;
    }

    public void y0(Context context0, AttributeSet attributeSet0, Bundle bundle0) {
        this.G = true;
        Activity activity0 = this.u == null ? null : this.u.t();
        if(activity0 != null) {
            this.G = false;
            this.x0(activity0, attributeSet0, bundle0);
        }
    }

    void y1(ArrayList arrayList0, ArrayList arrayList1) {
        this.j();
        this.L.h = arrayList0;
        this.L.i = arrayList1;
    }

    h0 z() {
        f fragment$f0 = this.L;
        if(fragment$f0 == null) {
            return null;
        }
        fragment$f0.getClass();
        return null;
    }

    public void z0(boolean z) {
    }

    public void z1(Intent intent0, int v, Bundle bundle0) {
        if(this.u == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.G().T0(this, intent0, v, bundle0);
    }
}

