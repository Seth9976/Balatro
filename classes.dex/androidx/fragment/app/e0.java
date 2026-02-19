package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class e0 {
    private final ArrayList a;
    private final HashMap b;
    private final HashMap c;
    private a0 d;

    e0() {
        this.a = new ArrayList();
        this.b = new HashMap();
        this.c = new HashMap();
    }

    void A(a0 a00) {
        this.d = a00;
    }

    c0 B(String s, c0 c00) {
        return c00 == null ? ((c0)this.c.remove(s)) : ((c0)this.c.put(s, c00));
    }

    void a(Fragment fragment0) {
        if(this.a.contains(fragment0)) {
            throw new IllegalStateException("Fragment already added: " + fragment0);
        }
        synchronized(this.a) {
            this.a.add(fragment0);
        }
        fragment0.l = true;
    }

    void b() {
        this.b.values().removeAll(Collections.singleton(null));
    }

    boolean c(String s) {
        return this.b.get(s) != null;
    }

    void d(int v) {
        for(Object object0: this.b.values()) {
            d0 d00 = (d0)object0;
            if(d00 != null) {
                d00.t(v);
            }
        }
    }

    void e(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        if(!this.b.isEmpty()) {
            printWriter0.print(s);
            printWriter0.println("Active Fragments:");
            for(Object object0: this.b.values()) {
                d0 d00 = (d0)object0;
                printWriter0.print(s);
                if(d00 == null) {
                    printWriter0.println("null");
                }
                else {
                    Fragment fragment0 = d00.k();
                    printWriter0.println(fragment0);
                    fragment0.i(s + "    ", fileDescriptor0, printWriter0, arr_s);
                }
            }
        }
        int v = this.a.size();
        if(v > 0) {
            printWriter0.print(s);
            printWriter0.println("Added Fragments:");
            for(int v1 = 0; v1 < v; ++v1) {
                Fragment fragment1 = (Fragment)this.a.get(v1);
                printWriter0.print(s);
                printWriter0.print("  #");
                printWriter0.print(v1);
                printWriter0.print(": ");
                printWriter0.println("Fragment{449d3c1b} (01a27ba7-b8bf-438b-a38d-eda048382a87)");
            }
        }
    }

    Fragment f(String s) {
        d0 d00 = (d0)this.b.get(s);
        return d00 == null ? null : d00.k();
    }

    Fragment g(int v) {
        for(int v1 = this.a.size() - 1; v1 >= 0; --v1) {
            Fragment fragment0 = (Fragment)this.a.get(v1);
            if(fragment0 != null && fragment0.x == v) {
                return fragment0;
            }
        }
        for(Object object0: this.b.values()) {
            d0 d00 = (d0)object0;
            if(d00 != null) {
                Fragment fragment1 = d00.k();
                if(fragment1.x == v) {
                    return fragment1;
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    Fragment h(String s) {
        if(s != null) {
            for(int v = this.a.size() - 1; v >= 0; --v) {
                Fragment fragment0 = (Fragment)this.a.get(v);
                if(fragment0 != null && s.equals(fragment0.z)) {
                    return fragment0;
                }
            }
        }
        if(s != null) {
            for(Object object0: this.b.values()) {
                d0 d00 = (d0)object0;
                if(d00 != null) {
                    Fragment fragment1 = d00.k();
                    if(s.equals(fragment1.z)) {
                        return fragment1;
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }
        return null;
    }

    Fragment i(String s) {
        for(Object object0: this.b.values()) {
            d0 d00 = (d0)object0;
            if(d00 != null) {
                Fragment fragment0 = d00.k().k(s);
                if(fragment0 != null) {
                    return fragment0;
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    int j(Fragment fragment0) {
        View view1;
        ViewGroup viewGroup0 = fragment0.H;
        if(viewGroup0 == null) {
            return -1;
        }
        int v = this.a.indexOf(fragment0);
        for(int v1 = v - 1; v1 >= 0; --v1) {
            Fragment fragment1 = (Fragment)this.a.get(v1);
            if(fragment1.H == viewGroup0) {
                View view0 = fragment1.I;
                if(view0 != null) {
                    return viewGroup0.indexOfChild(view0) + 1;
                }
            }
        }
    alab1:
        while(true) {
            do {
                ++v;
                if(v >= this.a.size()) {
                    break alab1;
                }
                Fragment fragment2 = (Fragment)this.a.get(v);
                if(fragment2.H != viewGroup0) {
                    continue alab1;
                }
                view1 = fragment2.I;
            }
            while(view1 == null);
            return viewGroup0.indexOfChild(view1);
        }
        return -1;
    }

    List k() {
        List list0 = new ArrayList();
        for(Object object0: this.b.values()) {
            d0 d00 = (d0)object0;
            if(d00 != null) {
                ((ArrayList)list0).add(d00);
            }
        }
        return list0;
    }

    List l() {
        List list0 = new ArrayList();
        for(Object object0: this.b.values()) {
            d0 d00 = (d0)object0;
            ((ArrayList)list0).add((d00 == null ? null : d00.k()));
        }
        return list0;
    }

    ArrayList m() {
        return new ArrayList(this.c.values());
    }

    d0 n(String s) {
        return (d0)this.b.get(s);
    }

    List o() {
        if(this.a.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList0 = this.a;
        return new ArrayList(this.a);
    }

    a0 p() {
        return this.d;
    }

    c0 q(String s) {
        return (c0)this.c.get(s);
    }

    void r(d0 d00) {
        Fragment fragment0 = d00.k();
        if(this.c(fragment0.f)) {
            return;
        }
        this.b.put(fragment0.f, d00);
        if(fragment0.D) {
            if(fragment0.C) {
                this.d.e(fragment0);
            }
            else {
                this.d.o(fragment0);
            }
            fragment0.D = false;
        }
        if(x.G0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment0);
        }
    }

    void s(d0 d00) {
        Fragment fragment0 = d00.k();
        if(fragment0.C) {
            this.d.o(fragment0);
        }
        if(((d0)this.b.put(fragment0.f, null)) == null) {
            return;
        }
        if(x.G0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment0);
        }
    }

    void t() {
        for(Object object0: this.a) {
            d0 d00 = (d0)this.b.get(((Fragment)object0).f);
            if(d00 != null) {
                d00.m();
            }
        }
        for(Object object1: this.b.values()) {
            d0 d01 = (d0)object1;
            if(d01 != null) {
                d01.m();
                Fragment fragment0 = d01.k();
                if(fragment0.m && !fragment0.a0()) {
                    if(fragment0.n && !this.c.containsKey(fragment0.f)) {
                        d01.r();
                    }
                    this.s(d01);
                }
            }
        }
    }

    void u(Fragment fragment0) {
        synchronized(this.a) {
            this.a.remove(fragment0);
        }
        fragment0.l = false;
    }

    void v() {
        this.b.clear();
    }

    void w(List list0) {
        this.a.clear();
        if(list0 != null) {
            for(Object object0: list0) {
                String s = (String)object0;
                Fragment fragment0 = this.f(s);
                if(fragment0 == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + s + ")");
                }
                if(x.G0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + s + "): " + fragment0);
                }
                this.a(fragment0);
            }
        }
    }

    void x(ArrayList arrayList0) {
        this.c.clear();
        for(Object object0: arrayList0) {
            this.c.put(((c0)object0).f, ((c0)object0));
        }
    }

    ArrayList y() {
        ArrayList arrayList0 = new ArrayList(this.b.size());
        for(Object object0: this.b.values()) {
            d0 d00 = (d0)object0;
            if(d00 != null) {
                Fragment fragment0 = d00.k();
                d00.r();
                arrayList0.add(fragment0.f);
                if(x.G0(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragment0 + ": " + fragment0.b);
                }
            }
        }
        return arrayList0;
    }

    ArrayList z() {
        synchronized(this.a) {
            if(this.a.isEmpty()) {
                return null;
            }
            ArrayList arrayList1 = new ArrayList(this.a.size());
            for(Object object0: this.a) {
                Fragment fragment0 = (Fragment)object0;
                arrayList1.add(fragment0.f);
                if(x.G0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment0.f + "): " + fragment0);
                }
            }
            return arrayList1;
        }
    }
}

