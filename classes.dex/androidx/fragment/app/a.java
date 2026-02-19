package androidx.fragment.app;

import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;

final class a extends f0 implements l {
    final x t;
    boolean u;
    int v;
    boolean w;

    a(x x0) {
        super(x0.r0(), (x0.t0() == null ? null : x0.t0().u().getClassLoader()));
        this.v = -1;
        this.w = false;
        this.t = x0;
    }

    @Override  // androidx.fragment.app.x$l
    public boolean a(ArrayList arrayList0, ArrayList arrayList1) {
        if(x.G0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList0.add(this);
        arrayList1.add(Boolean.FALSE);
        if(this.i) {
            this.t.i(this);
        }
        return true;
    }

    @Override  // androidx.fragment.app.f0
    public int f() {
        return this.o(false);
    }

    @Override  // androidx.fragment.app.f0
    public int g() {
        return this.o(true);
    }

    @Override  // androidx.fragment.app.f0
    public void h() {
        this.j();
        this.t.b0(this, false);
    }

    @Override  // androidx.fragment.app.f0
    public void i() {
        this.j();
        this.t.b0(this, true);
    }

    @Override  // androidx.fragment.app.f0
    void k(int v, Fragment fragment0, String s, int v1) {
        super.k(v, fragment0, s, v1);
        fragment0.t = this.t;
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.fragment.app.f0
    public f0 l(Fragment fragment0) {
        if(fragment0.t != null && fragment0.t != this.t) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment Fragment{51cb0a6a} (ec354e42-fce1-4e15-8fd1-887c051301e7) is already attached to a FragmentManager.");
        }
        return super.l(fragment0);
    }

    void n(int v) {
        if(!this.i) {
            return;
        }
        if(x.G0(2)) {
            Log.v("FragmentManager", "Bump nesting in " + this + " by " + v);
        }
        int v1 = this.c.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            androidx.fragment.app.f0.a f0$a0 = (androidx.fragment.app.f0.a)this.c.get(v2);
            Fragment fragment0 = f0$a0.b;
            if(fragment0 != null) {
                fragment0.s += v;
                if(x.G0(2)) {
                    Log.v("FragmentManager", "Bump nesting of " + f0$a0.b + " to " + f0$a0.b.s);
                }
            }
        }
    }

    int o(boolean z) {
        if(this.u) {
            throw new IllegalStateException("commit already called");
        }
        if(x.G0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter0 = new PrintWriter(new k0("FragmentManager"));
            this.p("  ", printWriter0);
            printWriter0.close();
        }
        this.u = true;
        this.v = this.i ? this.t.l() : -1;
        this.t.Y(this, z);
        return this.v;
    }

    public void p(String s, PrintWriter printWriter0) {
        this.q(s, printWriter0, true);
    }

    public void q(String s, PrintWriter printWriter0, boolean z) {
        String s1;
        if(z) {
            printWriter0.print(s);
            printWriter0.print("mName=");
            printWriter0.print(this.k);
            printWriter0.print(" mIndex=");
            printWriter0.print(this.v);
            printWriter0.print(" mCommitted=");
            printWriter0.println(this.u);
            if(this.h != 0) {
                printWriter0.print(s);
                printWriter0.print("mTransition=#");
                printWriter0.print(Integer.toHexString(this.h));
            }
            if(this.d != 0 || this.e != 0) {
                printWriter0.print(s);
                printWriter0.print("mEnterAnim=#");
                printWriter0.print(Integer.toHexString(this.d));
                printWriter0.print(" mExitAnim=#");
                printWriter0.println(Integer.toHexString(this.e));
            }
            if(this.f != 0 || this.g != 0) {
                printWriter0.print(s);
                printWriter0.print("mPopEnterAnim=#");
                printWriter0.print(Integer.toHexString(this.f));
                printWriter0.print(" mPopExitAnim=#");
                printWriter0.println(Integer.toHexString(this.g));
            }
            if(this.l != 0 || this.m != null) {
                printWriter0.print(s);
                printWriter0.print("mBreadCrumbTitleRes=#");
                printWriter0.print(Integer.toHexString(this.l));
                printWriter0.print(" mBreadCrumbTitleText=");
                printWriter0.println(this.m);
            }
            if(this.n != 0 || this.o != null) {
                printWriter0.print(s);
                printWriter0.print("mBreadCrumbShortTitleRes=#");
                printWriter0.print(Integer.toHexString(this.n));
                printWriter0.print(" mBreadCrumbShortTitleText=");
                printWriter0.println(this.o);
            }
        }
        if(!this.c.isEmpty()) {
            printWriter0.print(s);
            printWriter0.println("Operations:");
            int v = this.c.size();
            for(int v1 = 0; v1 < v; ++v1) {
                androidx.fragment.app.f0.a f0$a0 = (androidx.fragment.app.f0.a)this.c.get(v1);
                switch(f0$a0.a) {
                    case 0: {
                        s1 = "NULL";
                        break;
                    }
                    case 1: {
                        s1 = "ADD";
                        break;
                    }
                    case 2: {
                        s1 = "REPLACE";
                        break;
                    }
                    case 3: {
                        s1 = "REMOVE";
                        break;
                    }
                    case 4: {
                        s1 = "HIDE";
                        break;
                    }
                    case 5: {
                        s1 = "SHOW";
                        break;
                    }
                    case 6: {
                        s1 = "DETACH";
                        break;
                    }
                    case 7: {
                        s1 = "ATTACH";
                        break;
                    }
                    case 8: {
                        s1 = "SET_PRIMARY_NAV";
                        break;
                    }
                    case 9: {
                        s1 = "UNSET_PRIMARY_NAV";
                        break;
                    }
                    case 10: {
                        s1 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    }
                    default: {
                        s1 = "cmd=" + f0$a0.a;
                    }
                }
                printWriter0.print(s);
                printWriter0.print("  Op #");
                printWriter0.print(v1);
                printWriter0.print(": ");
                printWriter0.print(s1);
                printWriter0.print(" ");
                printWriter0.println(f0$a0.b);
                if(z) {
                    if(f0$a0.d != 0 || f0$a0.e != 0) {
                        printWriter0.print(s);
                        printWriter0.print("enterAnim=#");
                        printWriter0.print(Integer.toHexString(f0$a0.d));
                        printWriter0.print(" exitAnim=#");
                        printWriter0.println(Integer.toHexString(f0$a0.e));
                    }
                    if(f0$a0.f != 0 || f0$a0.g != 0) {
                        printWriter0.print(s);
                        printWriter0.print("popEnterAnim=#");
                        printWriter0.print(Integer.toHexString(f0$a0.f));
                        printWriter0.print(" popExitAnim=#");
                        printWriter0.println(Integer.toHexString(f0$a0.g));
                    }
                }
            }
        }
    }

    void r() {
        int v = this.c.size();
        for(int v1 = 0; v1 < v; ++v1) {
            androidx.fragment.app.f0.a f0$a0 = (androidx.fragment.app.f0.a)this.c.get(v1);
            Fragment fragment0 = f0$a0.b;
            if(fragment0 != null) {
                fragment0.n = this.w;
                fragment0.w1(false);
                fragment0.v1(this.h);
                fragment0.y1(this.p, this.q);
            }
            switch(f0$a0.a) {
                case 1: {
                    fragment0.s1(f0$a0.d, f0$a0.e, f0$a0.f, f0$a0.g);
                    this.t.k1(fragment0, false);
                    this.t.j(fragment0);
                    break;
                }
                case 3: {
                    fragment0.s1(f0$a0.d, f0$a0.e, f0$a0.f, f0$a0.g);
                    this.t.d1(fragment0);
                    break;
                }
                case 4: {
                    fragment0.s1(f0$a0.d, f0$a0.e, f0$a0.f, f0$a0.g);
                    this.t.D0(fragment0);
                    break;
                }
                case 5: {
                    fragment0.s1(f0$a0.d, f0$a0.e, f0$a0.f, f0$a0.g);
                    this.t.k1(fragment0, false);
                    this.t.o1(fragment0);
                    break;
                }
                case 6: {
                    fragment0.s1(f0$a0.d, f0$a0.e, f0$a0.f, f0$a0.g);
                    this.t.w(fragment0);
                    break;
                }
                case 7: {
                    fragment0.s1(f0$a0.d, f0$a0.e, f0$a0.f, f0$a0.g);
                    this.t.k1(fragment0, false);
                    this.t.n(fragment0);
                    break;
                }
                case 8: {
                    this.t.m1(fragment0);
                    break;
                }
                case 9: {
                    this.t.m1(null);
                    break;
                }
                case 10: {
                    this.t.l1(fragment0, f0$a0.i);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unknown cmd: " + f0$a0.a);
                }
            }
        }
    }

    void s() {
        for(int v = this.c.size() - 1; v >= 0; --v) {
            androidx.fragment.app.f0.a f0$a0 = (androidx.fragment.app.f0.a)this.c.get(v);
            Fragment fragment0 = f0$a0.b;
            if(fragment0 != null) {
                fragment0.n = this.w;
                fragment0.w1(true);
                fragment0.v1(x.h1(this.h));
                fragment0.y1(this.q, this.p);
            }
            switch(f0$a0.a) {
                case 1: {
                    fragment0.s1(f0$a0.d, f0$a0.e, f0$a0.f, f0$a0.g);
                    this.t.k1(fragment0, true);
                    this.t.d1(fragment0);
                    break;
                }
                case 3: {
                    fragment0.s1(f0$a0.d, f0$a0.e, f0$a0.f, f0$a0.g);
                    this.t.j(fragment0);
                    break;
                }
                case 4: {
                    fragment0.s1(f0$a0.d, f0$a0.e, f0$a0.f, f0$a0.g);
                    this.t.o1(fragment0);
                    break;
                }
                case 5: {
                    fragment0.s1(f0$a0.d, f0$a0.e, f0$a0.f, f0$a0.g);
                    this.t.k1(fragment0, true);
                    this.t.D0(fragment0);
                    break;
                }
                case 6: {
                    fragment0.s1(f0$a0.d, f0$a0.e, f0$a0.f, f0$a0.g);
                    this.t.n(fragment0);
                    break;
                }
                case 7: {
                    fragment0.s1(f0$a0.d, f0$a0.e, f0$a0.f, f0$a0.g);
                    this.t.k1(fragment0, true);
                    this.t.w(fragment0);
                    break;
                }
                case 8: {
                    this.t.m1(null);
                    break;
                }
                case 9: {
                    this.t.m1(fragment0);
                    break;
                }
                case 10: {
                    this.t.l1(fragment0, f0$a0.h);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unknown cmd: " + f0$a0.a);
                }
            }
        }
    }

    Fragment t(ArrayList arrayList0, Fragment fragment0) {
        for(int v = 0; v < this.c.size(); ++v) {
            androidx.fragment.app.f0.a f0$a0 = (androidx.fragment.app.f0.a)this.c.get(v);
            int v1 = f0$a0.a;
            if(v1 == 1) {
                arrayList0.add(f0$a0.b);
            }
            else {
                switch(v1) {
                    case 2: {
                        Fragment fragment1 = f0$a0.b;
                        int v2 = fragment1.y;
                        int v3 = arrayList0.size() - 1;
                        boolean z = false;
                        while(v3 >= 0) {
                            Fragment fragment2 = (Fragment)arrayList0.get(v3);
                            if(fragment2.y == v2) {
                                if(fragment2 == fragment1) {
                                    z = true;
                                }
                                else {
                                    if(fragment2 == fragment0) {
                                        this.c.add(v, new androidx.fragment.app.f0.a(9, fragment2, true));
                                        ++v;
                                        fragment0 = null;
                                    }
                                    androidx.fragment.app.f0.a f0$a1 = new androidx.fragment.app.f0.a(3, fragment2, true);
                                    f0$a1.d = f0$a0.d;
                                    f0$a1.f = f0$a0.f;
                                    f0$a1.e = f0$a0.e;
                                    f0$a1.g = f0$a0.g;
                                    this.c.add(v, f0$a1);
                                    arrayList0.remove(fragment2);
                                    ++v;
                                }
                            }
                            --v3;
                        }
                        if(z) {
                            this.c.remove(v);
                            --v;
                        }
                        else {
                            f0$a0.a = 1;
                            f0$a0.c = true;
                            arrayList0.add(fragment1);
                        }
                        break;
                    }
                    case 3: 
                    case 6: {
                        arrayList0.remove(f0$a0.b);
                        Fragment fragment3 = f0$a0.b;
                        if(fragment3 == fragment0) {
                            this.c.add(v, new androidx.fragment.app.f0.a(9, fragment3));
                            ++v;
                            fragment0 = null;
                        }
                        break;
                    }
                    case 7: {
                        arrayList0.add(f0$a0.b);
                        break;
                    }
                    case 8: {
                        this.c.add(v, new androidx.fragment.app.f0.a(9, fragment0, true));
                        f0$a0.c = true;
                        ++v;
                        fragment0 = f0$a0.b;
                    }
                }
            }
        }
        return fragment0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(0x80);
        stringBuilder0.append("BackStackEntry{");
        stringBuilder0.append(Integer.toHexString(System.identityHashCode(this)));
        if(this.v >= 0) {
            stringBuilder0.append(" #");
            stringBuilder0.append(this.v);
        }
        if(this.k != null) {
            stringBuilder0.append(" ");
            stringBuilder0.append(this.k);
        }
        stringBuilder0.append("}");
        return stringBuilder0.toString();
    }

    public String u() {
        return this.k;
    }

    public void v() {
        if(this.s != null) {
            for(int v = 0; v < this.s.size(); ++v) {
                ((Runnable)this.s.get(v)).run();
            }
            this.s = null;
        }
    }

    Fragment w(ArrayList arrayList0, Fragment fragment0) {
        for(int v = this.c.size() - 1; v >= 0; --v) {
            androidx.fragment.app.f0.a f0$a0 = (androidx.fragment.app.f0.a)this.c.get(v);
            switch(f0$a0.a) {
                case 3: 
                case 6: {
                    arrayList0.add(f0$a0.b);
                    break;
                }
                case 1: 
                case 7: {
                    arrayList0.remove(f0$a0.b);
                    break;
                }
                case 8: {
                    fragment0 = null;
                    break;
                }
                case 9: {
                    fragment0 = f0$a0.b;
                    break;
                }
                case 10: {
                    f0$a0.i = f0$a0.h;
                }
            }
        }
        return fragment0;
    }
}

