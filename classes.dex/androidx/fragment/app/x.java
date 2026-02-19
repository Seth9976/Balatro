package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.h;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.app.d0;
import androidx.core.app.f0;
import androidx.core.view.i;
import androidx.core.view.l;
import androidx.lifecycle.c0;
import b.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class x {
    class b extends h {
        final x d;

        b(boolean z) {
            super(z);
        }

        @Override  // androidx.activity.h
        public void b() {
            x.this.C0();
        }
    }

    class c implements l {
        final x a;

        @Override  // androidx.core.view.l
        public void a(Menu menu0, MenuInflater menuInflater0) {
            x.this.C(menu0, menuInflater0);
        }

        @Override  // androidx.core.view.l
        public void b(Menu menu0) {
            x.this.O(menu0);
        }

        @Override  // androidx.core.view.l
        public boolean c(MenuItem menuItem0) {
            return x.this.J(menuItem0);
        }

        @Override  // androidx.core.view.l
        public void d(Menu menu0) {
            x.this.K(menu0);
        }
    }

    class d extends o {
        final x b;

        @Override  // androidx.fragment.app.o
        public Fragment a(ClassLoader classLoader0, String s) {
            return x.this.t0().b(x.this.t0().u(), s, null);
        }
    }

    class e implements m0 {
        final x a;

        @Override  // androidx.fragment.app.m0
        public l0 a(ViewGroup viewGroup0) {
            return new androidx.fragment.app.d(viewGroup0);
        }
    }

    class f implements Runnable {
        final x e;

        @Override
        public void run() {
            x.this.a0(true);
        }
    }

    static class j extends a {
        @Override  // b.a
        public Intent a(Context context0, Object object0) {
            return this.d(context0, ((androidx.activity.result.e)object0));
        }

        @Override  // b.a
        public Object c(int v, Intent intent0) {
            return this.e(v, intent0);
        }

        public Intent d(Context context0, androidx.activity.result.e e0) {
            Intent intent0 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intent1 = e0.o();
            if(intent1 != null) {
                Bundle bundle0 = intent1.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if(bundle0 != null) {
                    intent0.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle0);
                    intent1.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if(intent1.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        e0 = new androidx.activity.result.e.b(e0.z()).b(null).c(e0.x(), e0.s()).a();
                    }
                }
            }
            intent0.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", e0);
            if(x.G0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent0);
            }
            return intent0;
        }

        public androidx.activity.result.a e(int v, Intent intent0) {
            return new androidx.activity.result.a(v, intent0);
        }
    }

    static class k implements Parcelable {
        class androidx.fragment.app.x.k.a implements Parcelable.Creator {
            androidx.fragment.app.x.k.a() {
                super();
            }

            public k a(Parcel parcel0) {
                return new k(parcel0);
            }

            public k[] b(int v) {
                return new k[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.a(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.b(v);
            }
        }

        public static final Parcelable.Creator CREATOR;
        String e;
        int f;

        static {
            k.CREATOR = new androidx.fragment.app.x.k.a();
        }

        k(Parcel parcel0) {
            this.e = parcel0.readString();
            this.f = parcel0.readInt();
        }

        k(String s, int v) {
            this.e = s;
            this.f = v;
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeString(this.e);
            parcel0.writeInt(this.f);
        }
    }

    interface androidx.fragment.app.x.l {
        boolean a(ArrayList arg1, ArrayList arg2);
    }

    class m implements androidx.fragment.app.x.l {
        final String a;
        final int b;
        final int c;
        final x d;

        m(String s, int v, int v1) {
            this.a = s;
            this.b = v;
            this.c = v1;
        }

        @Override  // androidx.fragment.app.x$l
        public boolean a(ArrayList arrayList0, ArrayList arrayList1) {
            Fragment fragment0 = x.this.y;
            return fragment0 == null || this.b >= 0 || this.a != null || !fragment0.s().Z0() ? x.this.c1(arrayList0, arrayList1, this.a, this.b, this.c) : false;
        }
    }

    private o A;
    private m0 B;
    private m0 C;
    private androidx.activity.result.c D;
    private androidx.activity.result.c E;
    private androidx.activity.result.c F;
    ArrayDeque G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private ArrayList M;
    private ArrayList N;
    private ArrayList O;
    private a0 P;
    private v.c.c Q;
    private Runnable R;
    private static boolean S;
    private final ArrayList a;
    private boolean b;
    private final e0 c;
    ArrayList d;
    private ArrayList e;
    private final q f;
    private OnBackPressedDispatcher g;
    private final h h;
    private final AtomicInteger i;
    private final Map j;
    private final Map k;
    private final Map l;
    private ArrayList m;
    private final r n;
    private final CopyOnWriteArrayList o;
    private final androidx.core.util.a p;
    private final androidx.core.util.a q;
    private final androidx.core.util.a r;
    private final androidx.core.util.a s;
    private final l t;
    int u;
    private p v;
    private androidx.fragment.app.l w;
    private Fragment x;
    Fragment y;
    private o z;

    static {
    }

    public x() {
        this.a = new ArrayList();
        this.c = new e0();
        this.f = new q(this);
        this.h = new b(this, false);
        this.i = new AtomicInteger();
        this.j = Collections.synchronizedMap(new HashMap());
        this.k = Collections.synchronizedMap(new HashMap());
        this.l = Collections.synchronizedMap(new HashMap());
        this.n = new r(this);
        this.o = new CopyOnWriteArrayList();
        this.p = (Configuration configuration0) -> if(this.I0()) {
            this.z(configuration0, false);
        };
        this.q = (Integer integer0) -> if(this.I0() && ((int)integer0) == 80) {
            this.F(false);
        };
        this.r = (androidx.core.app.d d0) -> if(this.I0()) {
            this.G(d0.a(), false);
        };
        this.s = (f0 f00) -> if(this.I0()) {
            this.N(f00.a(), false);
        };
        this.t = new c(this);
        this.u = -1;
        this.z = null;
        this.A = new d(this);
        this.B = null;
        this.C = new e(this);
        this.G = new ArrayDeque();
        this.R = () -> {
            x.this.Z(true);
            boolean z1 = false;
            while(x.this.m0(x.this.M, x.this.N)) {
                try {
                    z1 = true;
                    x.this.b = true;
                    x.this.e1(x.this.M, x.this.N);
                }
                finally {
                    x.this.r();
                }
            }
            x.this.r1();
            x.this.V();
            x.this.c.b();
            return z1;
        };
    }

    boolean A(MenuItem menuItem0) {
        if(this.u < 1) {
            return false;
        }
        for(Object object0: this.c.o()) {
            if(((Fragment)object0) != null && ((Fragment)object0).Q0(menuItem0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    static Fragment A0(View view0) {
        Object object0 = view0.getTag(u.b.a);
        return object0 instanceof Fragment ? ((Fragment)object0) : null;
    }

    void B() {
        this.I = false;
        this.J = false;
        this.P.p(false);
        this.S(1);
    }

    c0 B0(Fragment fragment0) {
        return this.P.m(fragment0);
    }

    boolean C(Menu menu0, MenuInflater menuInflater0) {
        if(this.u < 1) {
            return false;
        }
        ArrayList arrayList0 = null;
        boolean z = false;
        for(Object object0: this.c.o()) {
            Fragment fragment0 = (Fragment)object0;
            if(fragment0 != null && this.K0(fragment0) && fragment0.S0(menu0, menuInflater0)) {
                if(arrayList0 == null) {
                    arrayList0 = new ArrayList();
                }
                arrayList0.add(fragment0);
                z = true;
            }
        }
        if(this.e != null) {
            for(int v = 0; v < this.e.size(); ++v) {
                boolean z1 = arrayList0 != null && arrayList0.contains(((Fragment)this.e.get(v)));
            }
        }
        this.e = arrayList0;
        return z;
    }

    void C0() {
        this.a0(true);
        if(this.h.c()) {
            this.Z0();
            return;
        }
        this.g.f();
    }

    void D() {
        this.K = true;
        this.a0(true);
        this.X();
        this.s();
        this.S(-1);
        p p0 = this.v;
        if(p0 instanceof androidx.core.content.c) {
            ((androidx.core.content.c)p0).p(this.q);
        }
        p p1 = this.v;
        if(p1 instanceof androidx.core.content.b) {
            ((androidx.core.content.b)p1).r(this.p);
        }
        p p2 = this.v;
        if(p2 instanceof d0) {
            ((d0)p2).m(this.r);
        }
        p p3 = this.v;
        if(p3 instanceof androidx.core.app.e0) {
            ((androidx.core.app.e0)p3).n(this.s);
        }
        p p4 = this.v;
        if(p4 instanceof i && this.x == null) {
            ((i)p4).f(this.t);
        }
        this.v = null;
        this.w = null;
        this.x = null;
        if(this.g != null) {
            this.h.d();
            this.g = null;
        }
        androidx.activity.result.c c0 = this.D;
        if(c0 != null) {
            c0.c();
            this.E.c();
            this.F.c();
        }
    }

    void D0(Fragment fragment0) {
        if(x.G0(2)) {
            Log.v("FragmentManager", "hide: " + fragment0);
        }
        if(!fragment0.A) {
            fragment0.A = true;
            fragment0.O ^= true;
            this.n1(fragment0);
        }
    }

    void E() {
        this.S(1);
    }

    void E0(Fragment fragment0) {
        if(fragment0.l && this.H0(fragment0)) {
            this.H = true;
        }
    }

    void F(boolean z) {
        if(z && this.v instanceof androidx.core.content.c) {
            this.q1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for(Object object0: this.c.o()) {
            Fragment fragment0 = (Fragment)object0;
            if(fragment0 != null) {
                fragment0.Y0();
                if(z) {
                    fragment0.v.F(true);
                }
            }
        }
    }

    public boolean F0() {
        return this.K;
    }

    void G(boolean z, boolean z1) {
        if(z1 && this.v instanceof d0) {
            this.q1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for(Object object0: this.c.o()) {
            Fragment fragment0 = (Fragment)object0;
            if(fragment0 != null && z1) {
                fragment0.v.G(z, true);
            }
        }
    }

    // 去混淆评级： 低(20)
    public static boolean G0(int v) {
        return x.S || Log.isLoggable("FragmentManager", v);
    }

    void H(Fragment fragment0) {
        for(Object object0: this.o) {
            ((b0)object0).a(this, fragment0);
        }
    }

    // 去混淆评级： 低(30)
    private boolean H0(Fragment fragment0) {
        return fragment0.E && fragment0.F || fragment0.v.p();
    }

    void I() {
        for(Object object0: this.c.l()) {
            Fragment fragment0 = (Fragment)object0;
            if(fragment0 != null) {
                fragment0.w0(fragment0.Z());
                fragment0.v.I();
            }
        }
    }

    // 去混淆评级： 低(30)
    private boolean I0() {
        return this.x == null ? true : this.x.Y() && this.x.G().I0();
    }

    boolean J(MenuItem menuItem0) {
        if(this.u < 1) {
            return false;
        }
        for(Object object0: this.c.o()) {
            if(((Fragment)object0) != null && ((Fragment)object0).a1(menuItem0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    boolean J0(Fragment fragment0) {
        return fragment0 == null ? false : fragment0.Z();
    }

    void K(Menu menu0) {
        if(this.u < 1) {
            return;
        }
        for(Object object0: this.c.o()) {
            Fragment fragment0 = (Fragment)object0;
            if(fragment0 != null) {
                fragment0.b1(menu0);
            }
        }
    }

    boolean K0(Fragment fragment0) {
        return fragment0 == null ? true : fragment0.b0();
    }

    private void L(Fragment fragment0) {
        if(fragment0 != null && fragment0.equals(this.e0(fragment0.f))) {
            fragment0.f1();
        }
    }

    boolean L0(Fragment fragment0) {
        if(fragment0 == null) {
            return true;
        }
        x x0 = fragment0.t;
        return fragment0.equals(x0.x0()) && this.L0(x0.x);
    }

    void M() {
        this.S(5);
    }

    boolean M0(int v) {
        return this.u >= v;
    }

    void N(boolean z, boolean z1) {
        if(z1 && this.v instanceof androidx.core.app.e0) {
            this.q1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for(Object object0: this.c.o()) {
            Fragment fragment0 = (Fragment)object0;
            if(fragment0 != null && z1) {
                fragment0.v.N(z, true);
            }
        }
    }

    // 去混淆评级： 低(20)
    public boolean N0() {
        return this.I || this.J;
    }

    boolean O(Menu menu0) {
        boolean z = false;
        if(this.u < 1) {
            return false;
        }
        for(Object object0: this.c.o()) {
            Fragment fragment0 = (Fragment)object0;
            if(fragment0 != null && this.K0(fragment0) && fragment0.e1(menu0)) {
                z = true;
            }
        }
        return z;
    }

    // 检测为 Lambda 实现
    private Bundle O0() [...]

    void P() {
        this.r1();
        this.L(this.y);
    }

    // 检测为 Lambda 实现
    private void P0(Configuration configuration0) [...]

    void Q() {
        this.I = false;
        this.J = false;
        this.P.p(false);
        this.S(7);
    }

    // 检测为 Lambda 实现
    private void Q0(Integer integer0) [...]

    void R() {
        this.I = false;
        this.J = false;
        this.P.p(false);
        this.S(5);
    }

    // 检测为 Lambda 实现
    private void R0(androidx.core.app.d d0) [...]

    private void S(int v) {
        try {
            this.b = true;
            this.c.d(v);
            this.U0(v, false);
            for(Object object0: this.t()) {
                ((l0)object0).j();
            }
        }
        finally {
            this.b = false;
        }
        this.a0(true);
    }

    // 检测为 Lambda 实现
    private void S0(f0 f00) [...]

    void T() {
        this.J = true;
        this.P.p(true);
        this.S(4);
    }

    void T0(Fragment fragment0, Intent intent0, int v, Bundle bundle0) {
        if(this.D != null) {
            k x$k0 = new k(fragment0.f, v);
            this.G.addLast(x$k0);
            if(intent0 != null && bundle0 != null) {
                intent0.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle0);
            }
            this.D.a(intent0);
            return;
        }
        this.v.z(fragment0, intent0, v, bundle0);
    }

    void U() {
        this.S(2);
    }

    void U0(int v, boolean z) {
        if(this.v == null && v != -1) {
            throw new IllegalStateException("No activity");
        }
        if(!z && v == this.u) {
            return;
        }
        this.u = v;
        this.c.t();
        this.p1();
        if(this.H) {
            p p0 = this.v;
            if(p0 != null && this.u == 7) {
                p0.A();
                this.H = false;
            }
        }
    }

    private void V() {
        if(this.L) {
            this.L = false;
            this.p1();
        }
    }

    void V0() {
        if(this.v == null) {
            return;
        }
        this.I = false;
        this.J = false;
        this.P.p(false);
        for(Object object0: this.c.o()) {
            Fragment fragment0 = (Fragment)object0;
            if(fragment0 != null) {
                fragment0.f0();
            }
        }
    }

    public void W(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        this.c.e(s, fileDescriptor0, printWriter0, arr_s);
        ArrayList arrayList0 = this.e;
        if(arrayList0 != null) {
            int v1 = arrayList0.size();
            if(v1 > 0) {
                printWriter0.print(s);
                printWriter0.println("Fragments Created Menus:");
                for(int v2 = 0; v2 < v1; ++v2) {
                    Fragment fragment0 = (Fragment)this.e.get(v2);
                    printWriter0.print(s);
                    printWriter0.print("  #");
                    printWriter0.print(v2);
                    printWriter0.print(": ");
                    printWriter0.println("Fragment{3e75db11} (49b0b8d9-46e5-4f98-8981-e9938d8e2c7e)");
                }
            }
        }
        ArrayList arrayList1 = this.d;
        if(arrayList1 != null) {
            int v3 = arrayList1.size();
            if(v3 > 0) {
                printWriter0.print(s);
                printWriter0.println("Back Stack:");
                for(int v4 = 0; v4 < v3; ++v4) {
                    androidx.fragment.app.a a0 = (androidx.fragment.app.a)this.d.get(v4);
                    printWriter0.print(s);
                    printWriter0.print("  #");
                    printWriter0.print(v4);
                    printWriter0.print(": ");
                    printWriter0.println(a0.toString());
                    a0.p(s + "    ", printWriter0);
                }
            }
        }
        printWriter0.print(s);
        printWriter0.println("Back Stack Index: " + this.i.get());
        synchronized(this.a) {
            int v6 = this.a.size();
            if(v6 > 0) {
                printWriter0.print(s);
                printWriter0.println("Pending Actions:");
                for(int v = 0; v < v6; ++v) {
                    androidx.fragment.app.x.l x$l0 = (androidx.fragment.app.x.l)this.a.get(v);
                    printWriter0.print(s);
                    printWriter0.print("  #");
                    printWriter0.print(v);
                    printWriter0.print(": ");
                    printWriter0.println(x$l0);
                }
            }
        }
        printWriter0.print(s);
        printWriter0.println("FragmentManager misc state:");
        printWriter0.print(s);
        printWriter0.print("  mHost=");
        printWriter0.println(this.v);
        printWriter0.print(s);
        printWriter0.print("  mContainer=");
        printWriter0.println(this.w);
        if(this.x != null) {
            printWriter0.print(s);
            printWriter0.print("  mParent=");
            printWriter0.println(this.x);
        }
        printWriter0.print(s);
        printWriter0.print("  mCurState=");
        printWriter0.print(this.u);
        printWriter0.print(" mStateSaved=");
        printWriter0.print(this.I);
        printWriter0.print(" mStopped=");
        printWriter0.print(this.J);
        printWriter0.print(" mDestroyed=");
        printWriter0.println(this.K);
        if(this.H) {
            printWriter0.print(s);
            printWriter0.print("  mNeedMenuInvalidate=");
            printWriter0.println(this.H);
        }
    }

    void W0(androidx.fragment.app.m m0) {
        for(Object object0: this.c.k()) {
            androidx.fragment.app.d0 d00 = (androidx.fragment.app.d0)object0;
            Fragment fragment0 = d00.k();
            if(fragment0.y == m0.getId() && (fragment0.I != null && fragment0.I.getParent() == null)) {
                fragment0.H = m0;
                d00.b();
            }
        }
    }

    private void X() {
        for(Object object0: this.t()) {
            ((l0)object0).j();
        }
    }

    void X0(androidx.fragment.app.d0 d00) {
        Fragment fragment0 = d00.k();
        if(fragment0.J) {
            if(this.b) {
                this.L = true;
                return;
            }
            fragment0.J = false;
            d00.m();
        }
    }

    void Y(androidx.fragment.app.x.l x$l0, boolean z) {
        if(!z) {
            if(this.v == null) {
                throw this.K ? new IllegalStateException("FragmentManager has been destroyed") : new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            this.q();
        }
        synchronized(this.a) {
            if(this.v == null) {
                if(!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
                return;
            }
            this.a.add(x$l0);
            this.j1();
        }
    }

    void Y0(int v, int v1, boolean z) {
        if(v < 0) {
            throw new IllegalArgumentException("Bad id: " + v);
        }
        this.Y(new m(this, null, v, v1), z);
    }

    private void Z(boolean z) {
        if(this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if(this.v == null) {
            throw this.K ? new IllegalStateException("FragmentManager has been destroyed") : new IllegalStateException("FragmentManager has not been attached to a host.");
        }
        if(Looper.myLooper() != this.v.v().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if(!z) {
            this.q();
        }
        if(this.M == null) {
            this.M = new ArrayList();
            this.N = new ArrayList();
        }
    }

    public boolean Z0() {
        return this.b1(null, -1, 0);
    }

    // 检测为 Lambda 实现
    boolean a0(boolean z) [...]

    public boolean a1(int v, int v1) {
        if(v < 0) {
            throw new IllegalArgumentException("Bad id: " + v);
        }
        return this.b1(null, v, v1);
    }

    void b0(androidx.fragment.app.x.l x$l0, boolean z) {
        if(z && (this.v == null || this.K)) {
            return;
        }
        this.Z(z);
        if(x$l0.a(this.M, this.N)) {
            try {
                this.b = true;
                this.e1(this.M, this.N);
            }
            finally {
                this.r();
            }
        }
        this.r1();
        this.V();
        this.c.b();
    }

    private boolean b1(String s, int v, int v1) {
        this.a0(false);
        this.Z(true);
        if(this.y != null && v < 0 && s == null && this.y.s().Z0()) {
            return true;
        }
        boolean z = this.c1(this.M, this.N, s, v, v1);
        if(z) {
            try {
                this.b = true;
                this.e1(this.M, this.N);
            }
            finally {
                this.r();
            }
        }
        this.r1();
        this.V();
        this.c.b();
        return z;
    }

    private static void c0(ArrayList arrayList0, ArrayList arrayList1, int v, int v1) {
        while(v < v1) {
            androidx.fragment.app.a a0 = (androidx.fragment.app.a)arrayList0.get(v);
            if(((Boolean)arrayList1.get(v)).booleanValue()) {
                a0.n(-1);
                a0.s();
            }
            else {
                a0.n(1);
                a0.r();
            }
            ++v;
        }
    }

    boolean c1(ArrayList arrayList0, ArrayList arrayList1, String s, int v, int v1) {
        int v2 = this.f0(s, v, (v1 & 1) != 0);
        if(v2 < 0) {
            return false;
        }
        for(int v3 = this.d.size() - 1; v3 >= v2; --v3) {
            arrayList0.add(((androidx.fragment.app.a)this.d.remove(v3)));
            arrayList1.add(Boolean.TRUE);
        }
        return true;
    }

    private void d0(ArrayList arrayList0, ArrayList arrayList1, int v, int v1) {
        boolean z = ((androidx.fragment.app.a)arrayList0.get(v)).r;
        ArrayList arrayList2 = this.O;
        if(arrayList2 == null) {
            this.O = new ArrayList();
        }
        else {
            arrayList2.clear();
        }
        this.O.addAll(this.c.o());
        Fragment fragment0 = this.x0();
        int v2 = v;
        boolean z1 = false;
        while(v2 < v1) {
            androidx.fragment.app.a a0 = (androidx.fragment.app.a)arrayList0.get(v2);
            fragment0 = ((Boolean)arrayList1.get(v2)).booleanValue() ? a0.w(this.O, fragment0) : a0.t(this.O, fragment0);
            z1 = z1 || a0.i;
            ++v2;
        }
        this.O.clear();
        if(!z && this.u >= 1) {
            for(int v3 = v; v3 < v1; ++v3) {
                for(Object object0: ((androidx.fragment.app.a)arrayList0.get(v3)).c) {
                    Fragment fragment1 = ((androidx.fragment.app.f0.a)object0).b;
                    if(fragment1 != null && fragment1.t != null) {
                        androidx.fragment.app.d0 d00 = this.v(fragment1);
                        this.c.r(d00);
                    }
                }
            }
        }
        x.c0(arrayList0, arrayList1, v, v1);
        boolean z2 = ((Boolean)arrayList1.get(v1 - 1)).booleanValue();
        for(int v4 = v; v4 < v1; ++v4) {
            androidx.fragment.app.a a1 = (androidx.fragment.app.a)arrayList0.get(v4);
            if(z2) {
                for(int v5 = a1.c.size() - 1; v5 >= 0; --v5) {
                    Fragment fragment2 = ((androidx.fragment.app.f0.a)a1.c.get(v5)).b;
                    if(fragment2 != null) {
                        this.v(fragment2).m();
                    }
                }
            }
            else {
                for(Object object1: a1.c) {
                    Fragment fragment3 = ((androidx.fragment.app.f0.a)object1).b;
                    if(fragment3 != null) {
                        this.v(fragment3).m();
                    }
                }
            }
        }
        this.U0(this.u, true);
        for(Object object2: this.u(arrayList0, v, v1)) {
            ((l0)object2).r(z2);
            ((l0)object2).p();
            ((l0)object2).g();
        }
        while(v < v1) {
            androidx.fragment.app.a a2 = (androidx.fragment.app.a)arrayList0.get(v);
            if(((Boolean)arrayList1.get(v)).booleanValue() && a2.v >= 0) {
                a2.v = -1;
            }
            a2.v();
            ++v;
        }
        if(z1) {
            this.f1();
        }
    }

    void d1(Fragment fragment0) {
        if(x.G0(2)) {
            Log.v("FragmentManager", "remove: " + fragment0 + " nesting=" + fragment0.s);
        }
        boolean z = fragment0.a0();
        if(!fragment0.B || !z != 0) {
            this.c.u(fragment0);
            if(this.H0(fragment0)) {
                this.H = true;
            }
            fragment0.m = true;
            this.n1(fragment0);
        }
    }

    Fragment e0(String s) {
        return this.c.f(s);
    }

    private void e1(ArrayList arrayList0, ArrayList arrayList1) {
        if(arrayList0.isEmpty()) {
            return;
        }
        if(arrayList0.size() != arrayList1.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int v = arrayList0.size();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            if(!((androidx.fragment.app.a)arrayList0.get(v1)).r) {
                if(v2 != v1) {
                    this.d0(arrayList0, arrayList1, v2, v1);
                }
                v2 = v1 + 1;
                if(((Boolean)arrayList1.get(v1)).booleanValue()) {
                    while(v2 < v && ((Boolean)arrayList1.get(v2)).booleanValue() && !((androidx.fragment.app.a)arrayList0.get(v2)).r) {
                        ++v2;
                    }
                }
                this.d0(arrayList0, arrayList1, v1, v2);
                v1 = v2 - 1;
            }
        }
        if(v2 != v) {
            this.d0(arrayList0, arrayList1, v2, v);
        }
    }

    private int f0(String s, int v, boolean z) {
        if(this.d != null && !this.d.isEmpty()) {
            if(s == null && v < 0) {
                return z ? 0 : this.d.size() - 1;
            }
            int v1;
            for(v1 = this.d.size() - 1; v1 >= 0; --v1) {
                androidx.fragment.app.a a0 = (androidx.fragment.app.a)this.d.get(v1);
                if(s != null && s.equals(a0.u()) || v >= 0 && v == a0.v) {
                    break;
                }
            }
            if(v1 < 0) {
                return v1;
            }
            if(z) {
                while(v1 > 0) {
                    androidx.fragment.app.a a1 = (androidx.fragment.app.a)this.d.get(v1 - 1);
                    if((s == null || !s.equals(a1.u())) && (v < 0 || v != a1.v)) {
                        break;
                    }
                    --v1;
                }
                return v1;
            }
            return v1 == this.d.size() - 1 ? -1 : v1 + 1;
        }
        return -1;
    }

    private void f1() {
        if(this.m != null && this.m.size() > 0) {
            h.d.a(this.m.get(0));
            throw null;
        }
    }

    public Fragment g0(int v) {
        return this.c.g(v);
    }

    void g1(Parcelable parcelable0) {
        androidx.fragment.app.d0 d00;
        if(parcelable0 == null) {
            return;
        }
        for(Object object0: ((Bundle)parcelable0).keySet()) {
            String s = (String)object0;
            if(s.startsWith("result_")) {
                Bundle bundle0 = ((Bundle)parcelable0).getBundle(s);
                if(bundle0 != null) {
                    bundle0.setClassLoader(this.v.u().getClassLoader());
                    this.k.put(s.substring(7), bundle0);
                }
            }
        }
        ArrayList arrayList0 = new ArrayList();
        for(Object object1: ((Bundle)parcelable0).keySet()) {
            String s1 = (String)object1;
            if(s1.startsWith("fragment_")) {
                Bundle bundle1 = ((Bundle)parcelable0).getBundle(s1);
                if(bundle1 != null) {
                    bundle1.setClassLoader(this.v.u().getClassLoader());
                    arrayList0.add(((androidx.fragment.app.c0)bundle1.getParcelable("state")));
                }
            }
        }
        this.c.x(arrayList0);
        z z0 = (z)((Bundle)parcelable0).getParcelable("state");
        if(z0 == null) {
            return;
        }
        this.c.v();
        for(Object object2: z0.e) {
            androidx.fragment.app.c0 c00 = this.c.B(((String)object2), null);
            if(c00 != null) {
                Fragment fragment0 = this.P.i(c00.f);
                if(fragment0 == null) {
                    ClassLoader classLoader0 = this.v.u().getClassLoader();
                    o o0 = this.r0();
                    d00 = new androidx.fragment.app.d0(this.n, this.c, classLoader0, o0, c00);
                }
                else {
                    if(x.G0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment0);
                    }
                    d00 = new androidx.fragment.app.d0(this.n, this.c, fragment0, c00);
                }
                Fragment fragment1 = d00.k();
                fragment1.t = this;
                if(x.G0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragment1.f + "): " + fragment1);
                }
                d00.o(this.v.u().getClassLoader());
                this.c.r(d00);
                d00.t(this.u);
            }
        }
        for(Object object3: this.P.l()) {
            Fragment fragment2 = (Fragment)object3;
            if(!this.c.c(fragment2.f)) {
                if(x.G0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment2 + " that was not found in the set of active Fragments " + z0.e);
                }
                this.P.o(fragment2);
                fragment2.t = this;
                androidx.fragment.app.d0 d01 = new androidx.fragment.app.d0(this.n, this.c, fragment2);
                d01.t(1);
                d01.m();
                fragment2.m = true;
                d01.m();
            }
        }
        this.c.w(z0.f);
        if(z0.g == null) {
            this.d = null;
        }
        else {
            this.d = new ArrayList(z0.g.length);
            for(int v1 = 0; true; ++v1) {
                androidx.fragment.app.b[] arr_b = z0.g;
                if(v1 >= arr_b.length) {
                    break;
                }
                androidx.fragment.app.a a0 = arr_b[v1].s(this);
                if(x.G0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + v1 + " (index " + a0.v + "): " + a0);
                    PrintWriter printWriter0 = new PrintWriter(new k0("FragmentManager"));
                    a0.q("  ", printWriter0, false);
                    printWriter0.close();
                }
                this.d.add(a0);
            }
        }
        this.i.set(z0.h);
        String s2 = z0.i;
        if(s2 != null) {
            Fragment fragment3 = this.e0(s2);
            this.y = fragment3;
            this.L(fragment3);
        }
        ArrayList arrayList1 = z0.j;
        if(arrayList1 != null) {
            for(int v = 0; v < arrayList1.size(); ++v) {
                String s3 = (String)arrayList1.get(v);
                androidx.fragment.app.c c0 = (androidx.fragment.app.c)z0.k.get(v);
                this.j.put(s3, c0);
            }
        }
        this.G = new ArrayDeque(z0.l);
    }

    public Fragment h0(String s) {
        return this.c.h(s);
    }

    static int h1(int v) {
        int v1 = 0x2002;
        int v2 = 0x1001;
        switch(v) {
            case 0x1001: {
                break;
            }
            case 0x2002: {
                return v2;
            }
            default: {
                v1 = 4100;
                v2 = 0x2005;
                if(v != 0x2005) {
                    switch(v) {
                        case 0x1003: {
                            return 0x1003;
                        }
                        case 4100: {
                            return v2;
                        }
                        default: {
                            return 0;
                        }
                    }
                }
            }
        }
        return v1;
    }

    void i(androidx.fragment.app.a a0) {
        if(this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(a0);
    }

    Fragment i0(String s) {
        return this.c.i(s);
    }

    Bundle i1() {
        androidx.fragment.app.b[] arr_b;
        Bundle bundle0 = new Bundle();
        this.l0();
        this.X();
        this.a0(true);
        this.I = true;
        this.P.p(true);
        ArrayList arrayList0 = this.c.y();
        ArrayList arrayList1 = this.c.m();
        if(!arrayList1.isEmpty()) {
            ArrayList arrayList2 = this.c.z();
            ArrayList arrayList3 = this.d;
            if(arrayList3 == null) {
                arr_b = null;
            }
            else {
                int v = arrayList3.size();
                if(v > 0) {
                    arr_b = new androidx.fragment.app.b[v];
                    for(int v1 = 0; v1 < v; ++v1) {
                        arr_b[v1] = new androidx.fragment.app.b(((androidx.fragment.app.a)this.d.get(v1)));
                        if(x.G0(2)) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + v1 + ": " + this.d.get(v1));
                        }
                    }
                }
                else {
                    arr_b = null;
                }
            }
            z z0 = new z();
            z0.e = arrayList0;
            z0.f = arrayList2;
            z0.g = arr_b;
            z0.h = this.i.get();
            Fragment fragment0 = this.y;
            if(fragment0 != null) {
                z0.i = fragment0.f;
            }
            z0.j.addAll(this.j.keySet());
            z0.k.addAll(this.j.values());
            z0.l = new ArrayList(this.G);
            bundle0.putParcelable("state", z0);
            for(Object object0: this.k.keySet()) {
                bundle0.putBundle("result_" + ((String)object0), ((Bundle)this.k.get(((String)object0))));
            }
            for(Object object1: arrayList1) {
                Bundle bundle1 = new Bundle();
                bundle1.putParcelable("state", ((androidx.fragment.app.c0)object1));
                bundle0.putBundle("fragment_" + ((androidx.fragment.app.c0)object1).f, bundle1);
            }
        }
        else if(x.G0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle0;
        }
        return bundle0;
    }

    androidx.fragment.app.d0 j(Fragment fragment0) {
        String s = fragment0.R;
        if(s != null) {
            v.c.f(fragment0, s);
        }
        if(x.G0(2)) {
            Log.v("FragmentManager", "add: " + fragment0);
        }
        androidx.fragment.app.d0 d00 = this.v(fragment0);
        fragment0.t = this;
        this.c.r(d00);
        if(!fragment0.B) {
            this.c.a(fragment0);
            fragment0.m = false;
            if(fragment0.I == null) {
                fragment0.O = false;
            }
            if(this.H0(fragment0)) {
                this.H = true;
            }
        }
        return d00;
    }

    static x j0(View view0) {
        androidx.fragment.app.j j0;
        Fragment fragment0 = x.k0(view0);
        if(fragment0 != null) {
            if(!fragment0.Y()) {
                throw new IllegalStateException("The Fragment " + fragment0 + " that owns View " + view0 + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
            return fragment0.s();
        }
        for(Context context0 = view0.getContext(); true; context0 = ((ContextWrapper)context0).getBaseContext()) {
            j0 = null;
            if(!(context0 instanceof ContextWrapper)) {
                break;
            }
            if(context0 instanceof androidx.fragment.app.j) {
                j0 = (androidx.fragment.app.j)context0;
                break;
            }
        }
        if(j0 == null) {
            throw new IllegalStateException("View " + view0 + " is not within a subclass of FragmentActivity.");
        }
        return j0.M();
    }

    void j1() {
        synchronized(this.a) {
            if(this.a.size() == 1) {
                this.v.v().removeCallbacks(this.R);
                this.v.v().post(this.R);
                this.r1();
            }
        }
    }

    public void k(b0 b00) {
        this.o.add(b00);
    }

    private static Fragment k0(View view0) {
        while(view0 != null) {
            Fragment fragment0 = x.A0(view0);
            if(fragment0 != null) {
                return fragment0;
            }
            ViewParent viewParent0 = view0.getParent();
            view0 = viewParent0 instanceof View ? ((View)viewParent0) : null;
        }
        return null;
    }

    void k1(Fragment fragment0, boolean z) {
        ViewGroup viewGroup0 = this.q0(fragment0);
        if(viewGroup0 != null && viewGroup0 instanceof androidx.fragment.app.m) {
            ((androidx.fragment.app.m)viewGroup0).setDrawDisappearingViewsLast(!z);
        }
    }

    int l() {
        return this.i.getAndIncrement();
    }

    private void l0() {
        for(Object object0: this.t()) {
            ((l0)object0).k();
        }
    }

    void l1(Fragment fragment0, androidx.lifecycle.h.c h$c0) {
        if(!fragment0.equals(this.e0(fragment0.f)) || fragment0.u != null && fragment0.t != this) {
            throw new IllegalArgumentException("Fragment " + fragment0 + " is not an active fragment of FragmentManager " + this);
        }
        fragment0.S = h$c0;
    }

    void m(p p0, androidx.fragment.app.l l0, Fragment fragment0) {
        class androidx.fragment.app.x.a implements androidx.activity.result.b {
            final x a;

            @Override  // androidx.activity.result.b
            public void a(Object object0) {
                this.b(((Map)object0));
            }

            public void b(Map map0) {
                String[] arr_s = (String[])map0.keySet().toArray(new String[0]);
                ArrayList arrayList0 = new ArrayList(map0.values());
                int[] arr_v = new int[arrayList0.size()];
                for(int v = 0; v < arrayList0.size(); ++v) {
                    arr_v[v] = ((Boolean)arrayList0.get(v)).booleanValue() ? 0 : -1;
                }
                k x$k0 = (k)x.this.G.pollFirst();
                if(x$k0 == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                    return;
                }
                String s = x$k0.e;
                int v1 = x$k0.f;
                Fragment fragment0 = x.this.c.i(s);
                if(fragment0 == null) {
                    Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + s);
                    return;
                }
                fragment0.G0(v1, arr_s, arr_v);
            }
        }


        class g implements b0 {
            final Fragment a;
            final x b;

            g(Fragment fragment0) {
                this.a = fragment0;
                super();
            }

            @Override  // androidx.fragment.app.b0
            public void a(x x0, Fragment fragment0) {
            }
        }


        class androidx.fragment.app.x.h implements androidx.activity.result.b {
            final x a;

            @Override  // androidx.activity.result.b
            public void a(Object object0) {
                this.b(((androidx.activity.result.a)object0));
            }

            public void b(androidx.activity.result.a a0) {
                k x$k0 = (k)x.this.G.pollFirst();
                if(x$k0 == null) {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                    return;
                }
                String s = x$k0.e;
                int v = x$k0.f;
                Fragment fragment0 = x.this.c.i(s);
                if(fragment0 == null) {
                    Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + s);
                    return;
                }
                fragment0.h0(v, a0.s(), a0.o());
            }
        }


        class androidx.fragment.app.x.i implements androidx.activity.result.b {
            final x a;

            @Override  // androidx.activity.result.b
            public void a(Object object0) {
                this.b(((androidx.activity.result.a)object0));
            }

            public void b(androidx.activity.result.a a0) {
                k x$k0 = (k)x.this.G.pollFirst();
                if(x$k0 == null) {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                    return;
                }
                String s = x$k0.e;
                int v = x$k0.f;
                Fragment fragment0 = x.this.c.i(s);
                if(fragment0 == null) {
                    Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + s);
                    return;
                }
                fragment0.h0(v, a0.s(), a0.o());
            }
        }

        a0 a00;
        if(this.v != null) {
            throw new IllegalStateException("Already attached");
        }
        this.v = p0;
        this.w = l0;
        this.x = fragment0;
        if(fragment0 != null) {
            this.k(new g(this, fragment0));
        }
        else if(p0 instanceof b0) {
            this.k(((b0)p0));
        }
        if(this.x != null) {
            this.r1();
        }
        if(p0 instanceof androidx.activity.l) {
            androidx.activity.l l1 = (androidx.activity.l)p0;
            OnBackPressedDispatcher onBackPressedDispatcher0 = l1.c();
            this.g = onBackPressedDispatcher0;
            if(fragment0 != null) {
                l1 = fragment0;
            }
            onBackPressedDispatcher0.b(l1, this.h);
        }
        if(fragment0 == null) {
            a00 = p0 instanceof androidx.lifecycle.d0 ? a0.k(((androidx.lifecycle.d0)p0).l()) : new a0(false);
        }
        else {
            a00 = fragment0.t.o0(fragment0);
        }
        this.P = a00;
        this.P.p(this.N0());
        this.c.A(this.P);
        p p1 = this.v;
        if(p1 instanceof z.e && fragment0 == null) {
            z.c c0 = ((z.e)p1).d();
            c0.h("android:support:fragments", () -> this.i1());
            Bundle bundle0 = c0.b("android:support:fragments");
            if(bundle0 != null) {
                this.g1(bundle0);
            }
        }
        p p2 = this.v;
        if(p2 instanceof androidx.activity.result.d) {
            ActivityResultRegistry activityResultRegistry0 = ((androidx.activity.result.d)p2).h();
            String s = fragment0 == null ? "" : fragment0.f + ":";
            this.D = activityResultRegistry0.j("FragmentManager:" + s + "StartActivityForResult", new b.c(), new androidx.fragment.app.x.h(this));
            this.E = activityResultRegistry0.j("FragmentManager:" + s + "StartIntentSenderForResult", new j(), new androidx.fragment.app.x.i(this));
            this.F = activityResultRegistry0.j("FragmentManager:" + s + "RequestPermissions", new b.b(), new androidx.fragment.app.x.a(this));
        }
        p p3 = this.v;
        if(p3 instanceof androidx.core.content.b) {
            ((androidx.core.content.b)p3).k(this.p);
        }
        p p4 = this.v;
        if(p4 instanceof androidx.core.content.c) {
            ((androidx.core.content.c)p4).q(this.q);
        }
        p p5 = this.v;
        if(p5 instanceof d0) {
            ((d0)p5).j(this.r);
        }
        p p6 = this.v;
        if(p6 instanceof androidx.core.app.e0) {
            ((androidx.core.app.e0)p6).e(this.s);
        }
        p p7 = this.v;
        if(p7 instanceof i && fragment0 == null) {
            ((i)p7).g(this.t);
        }
    }

    private boolean m0(ArrayList arrayList0, ArrayList arrayList1) {
        synchronized(this.a) {
            if(this.a.isEmpty()) {
                return false;
            }
            try {
                int v3 = this.a.size();
                boolean z = false;
                for(int v = 0; v < v3; ++v) {
                    z |= ((androidx.fragment.app.x.l)this.a.get(v)).a(arrayList0, arrayList1);
                }
                return z;
            }
            finally {
                this.a.clear();
                this.v.v().removeCallbacks(this.R);
            }
        }
    }

    void m1(Fragment fragment0) {
        if(fragment0 != null && (!fragment0.equals(this.e0(fragment0.f)) || fragment0.u != null && fragment0.t != this)) {
            throw new IllegalArgumentException("Fragment " + fragment0 + " is not an active fragment of FragmentManager " + this);
        }
        Fragment fragment1 = this.y;
        this.y = fragment0;
        this.L(fragment1);
        this.L(this.y);
    }

    void n(Fragment fragment0) {
        if(x.G0(2)) {
            Log.v("FragmentManager", "attach: " + fragment0);
        }
        if(fragment0.B) {
            fragment0.B = false;
            if(!fragment0.l) {
                this.c.a(fragment0);
                if(x.G0(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment0);
                }
                if(this.H0(fragment0)) {
                    this.H = true;
                }
            }
        }
    }

    public int n0() {
        return this.d == null ? 0 : this.d.size();
    }

    private void n1(Fragment fragment0) {
        ViewGroup viewGroup0 = this.q0(fragment0);
        if(viewGroup0 != null && fragment0.u() + fragment0.x() + fragment0.I() + fragment0.J() > 0) {
            if(viewGroup0.getTag(u.b.c) == null) {
                viewGroup0.setTag(u.b.c, fragment0);
            }
            ((Fragment)viewGroup0.getTag(u.b.c)).w1(fragment0.H());
        }
    }

    public androidx.fragment.app.f0 o() {
        return new androidx.fragment.app.a(this);
    }

    private a0 o0(Fragment fragment0) {
        return this.P.j(fragment0);
    }

    void o1(Fragment fragment0) {
        if(x.G0(2)) {
            Log.v("FragmentManager", "show: " + fragment0);
        }
        if(fragment0.A) {
            fragment0.A = false;
            fragment0.O = !fragment0.O;
        }
    }

    boolean p() {
        boolean z = false;
        for(Object object0: this.c.l()) {
            Fragment fragment0 = (Fragment)object0;
            if(fragment0 != null) {
                z = this.H0(fragment0);
            }
            if(z) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    androidx.fragment.app.l p0() {
        return this.w;
    }

    private void p1() {
        for(Object object0: this.c.k()) {
            this.X0(((androidx.fragment.app.d0)object0));
        }
    }

    private void q() {
        if(this.N0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private ViewGroup q0(Fragment fragment0) {
        ViewGroup viewGroup0 = fragment0.H;
        if(viewGroup0 != null) {
            return viewGroup0;
        }
        if(fragment0.y <= 0) {
            return null;
        }
        if(this.w.s()) {
            View view0 = this.w.i(fragment0.y);
            return view0 instanceof ViewGroup ? ((ViewGroup)view0) : null;
        }
        return null;
    }

    private void q1(RuntimeException runtimeException0) {
        Log.e("FragmentManager", runtimeException0.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter0 = new PrintWriter(new k0("FragmentManager"));
        p p0 = this.v;
        try {
            if(p0 == null) {
                this.W("  ", null, printWriter0, new String[0]);
            }
            else {
                p0.w("  ", null, printWriter0, new String[0]);
            }
        }
        catch(Exception exception0) {
            Log.e("FragmentManager", "Failed dumping state", exception0);
        }
        throw runtimeException0;
    }

    private void r() {
        this.b = false;
        this.N.clear();
        this.M.clear();
    }

    public o r0() {
        o o0 = this.z;
        if(o0 != null) {
            return o0;
        }
        return this.x == null ? this.A : this.x.t.r0();
    }

    private void r1() {
        boolean z = true;
        synchronized(this.a) {
            if(!this.a.isEmpty()) {
                this.h.f(true);
                return;
            }
        }
        h h0 = this.h;
        if(this.n0() <= 0 || !this.L0(this.x)) {
            z = false;
        }
        h0.f(z);
    }

    private void s() {
        boolean z;
        p p0 = this.v;
        if(p0 instanceof androidx.lifecycle.d0) {
            z = this.c.p().n();
        }
        else {
            z = p0.u() instanceof Activity ? !((Activity)this.v.u()).isChangingConfigurations() : true;
        }
        if(z) {
            for(Object object0: this.j.values()) {
                for(Object object1: ((androidx.fragment.app.c)object0).e) {
                    this.c.p().g(((String)object1));
                }
            }
        }
    }

    public List s0() {
        return this.c.o();
    }

    private Set t() {
        Set set0 = new HashSet();
        for(Object object0: this.c.k()) {
            ViewGroup viewGroup0 = ((androidx.fragment.app.d0)object0).k().H;
            if(viewGroup0 != null) {
                set0.add(l0.o(viewGroup0, this.y0()));
            }
        }
        return set0;
    }

    public p t0() {
        return this.v;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(0x80);
        stringBuilder0.append("FragmentManager{");
        stringBuilder0.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder0.append(" in ");
        Fragment fragment0 = this.x;
        if(fragment0 == null) {
            p p0 = this.v;
            if(p0 == null) {
                stringBuilder0.append("null");
            }
            else {
                stringBuilder0.append(p0.getClass().getSimpleName());
                stringBuilder0.append("{");
                stringBuilder0.append(Integer.toHexString(System.identityHashCode(this.v)));
                stringBuilder0.append("}");
            }
        }
        else {
            stringBuilder0.append(fragment0.getClass().getSimpleName());
            stringBuilder0.append("{");
            stringBuilder0.append(Integer.toHexString(System.identityHashCode(this.x)));
            stringBuilder0.append("}");
        }
        stringBuilder0.append("}}");
        return stringBuilder0.toString();
    }

    private Set u(ArrayList arrayList0, int v, int v1) {
        Set set0 = new HashSet();
        while(v < v1) {
            for(Object object0: ((androidx.fragment.app.a)arrayList0.get(v)).c) {
                Fragment fragment0 = ((androidx.fragment.app.f0.a)object0).b;
                if(fragment0 != null) {
                    ViewGroup viewGroup0 = fragment0.H;
                    if(viewGroup0 != null) {
                        set0.add(l0.n(viewGroup0, this));
                    }
                }
            }
            ++v;
        }
        return set0;
    }

    LayoutInflater.Factory2 u0() {
        return this.f;
    }

    androidx.fragment.app.d0 v(Fragment fragment0) {
        androidx.fragment.app.d0 d00 = this.c.n(fragment0.f);
        if(d00 != null) {
            return d00;
        }
        androidx.fragment.app.d0 d01 = new androidx.fragment.app.d0(this.n, this.c, fragment0);
        d01.o(this.v.u().getClassLoader());
        d01.t(this.u);
        return d01;
    }

    r v0() {
        return this.n;
    }

    void w(Fragment fragment0) {
        if(x.G0(2)) {
            Log.v("FragmentManager", "detach: " + fragment0);
        }
        if(!fragment0.B) {
            fragment0.B = true;
            if(fragment0.l) {
                if(x.G0(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment0);
                }
                this.c.u(fragment0);
                if(this.H0(fragment0)) {
                    this.H = true;
                }
                this.n1(fragment0);
            }
        }
    }

    Fragment w0() {
        return this.x;
    }

    void x() {
        this.I = false;
        this.J = false;
        this.P.p(false);
        this.S(4);
    }

    public Fragment x0() {
        return this.y;
    }

    void y() {
        this.I = false;
        this.J = false;
        this.P.p(false);
        this.S(0);
    }

    m0 y0() {
        m0 m00 = this.B;
        if(m00 != null) {
            return m00;
        }
        return this.x == null ? this.C : this.x.t.y0();
    }

    void z(Configuration configuration0, boolean z) {
        if(z && this.v instanceof androidx.core.content.b) {
            this.q1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for(Object object0: this.c.o()) {
            Fragment fragment0 = (Fragment)object0;
            if(fragment0 != null) {
                fragment0.P0(configuration0);
                if(z) {
                    fragment0.v.z(configuration0, true);
                }
            }
        }
    }

    public v.c.c z0() {
        return this.Q;
    }
}

