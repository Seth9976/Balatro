package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

abstract class l0 {
    static abstract class c {
        static final int[] a;
        static final int[] b;

        static {
            int[] arr_v = new int[b.values().length];
            c.b = arr_v;
            try {
                arr_v[b.f.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                c.b[b.g.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                c.b[b.e.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            int[] arr_v1 = new int[androidx.fragment.app.l0.e.c.values().length];
            c.a = arr_v1;
            try {
                arr_v1[androidx.fragment.app.l0.e.c.e.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                c.a[androidx.fragment.app.l0.e.c.f.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                c.a[androidx.fragment.app.l0.e.c.g.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                c.a[androidx.fragment.app.l0.e.c.h.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

    static class d extends e {
        private final d0 h;

        d(androidx.fragment.app.l0.e.c l0$e$c0, b l0$e$b0, d0 d00, androidx.core.os.b b0) {
            super(l0$e$c0, l0$e$b0, d00.k(), b0);
            this.h = d00;
        }

        @Override  // androidx.fragment.app.l0$e
        public void c() {
            super.c();
            this.h.m();
        }

        @Override  // androidx.fragment.app.l0$e
        void l() {
            if(this.g() == b.f) {
                Fragment fragment0 = this.h.k();
                View view0 = fragment0.I.findFocus();
                if(view0 != null) {
                    fragment0.u1(view0);
                    if(x.G0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + view0 + " for Fragment " + fragment0);
                    }
                }
                View view1 = this.f().o1();
                if(view1.getParent() == null) {
                    this.h.b();
                    view1.setAlpha(0.0f);
                }
                if(view1.getAlpha() == 0.0f && view1.getVisibility() == 0) {
                    view1.setVisibility(4);
                }
                view1.setAlpha(fragment0.K());
                return;
            }
            if(this.g() == b.g) {
                Fragment fragment1 = this.h.k();
                View view2 = fragment1.o1();
                if(x.G0(2)) {
                    Log.v("FragmentManager", "Clearing focus " + view2.findFocus() + " on view " + view2 + " for Fragment " + fragment1);
                }
                view2.clearFocus();
            }
        }
    }

    static abstract class e {
        static enum b {
            NONE,
            ADDING,
            REMOVING;

        }

        static enum androidx.fragment.app.l0.e.c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            void c(View view0) {
                int v;
                switch(this) {
                    case 1: {
                        ViewGroup viewGroup0 = (ViewGroup)view0.getParent();
                        if(viewGroup0 != null) {
                            if(x.G0(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view0 + " from container " + viewGroup0);
                            }
                            viewGroup0.removeView(view0);
                        }
                        return;
                    }
                    case 2: {
                        if(x.G0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view0 + " to VISIBLE");
                        }
                        v = 0;
                        break;
                    }
                    case 3: {
                        if(x.G0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view0 + " to GONE");
                        }
                        v = 8;
                        break;
                    }
                    case 4: {
                        if(x.G0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view0 + " to INVISIBLE");
                        }
                        view0.setVisibility(4);
                        return;
                    }
                    default: {
                        return;
                    }
                }
                view0.setVisibility(v);
            }

            static androidx.fragment.app.l0.e.c j(int v) {
                switch(v) {
                    case 0: {
                        return androidx.fragment.app.l0.e.c.f;
                    }
                    case 4: {
                        return androidx.fragment.app.l0.e.c.h;
                    }
                    case 8: {
                        return androidx.fragment.app.l0.e.c.g;
                    }
                    default: {
                        throw new IllegalArgumentException("Unknown visibility " + v);
                    }
                }
            }

            static androidx.fragment.app.l0.e.c k(View view0) {
                return view0.getAlpha() != 0.0f || view0.getVisibility() != 0 ? androidx.fragment.app.l0.e.c.j(view0.getVisibility()) : androidx.fragment.app.l0.e.c.h;
            }
        }

        private androidx.fragment.app.l0.e.c a;
        private b b;
        private final Fragment c;
        private final List d;
        private final HashSet e;
        private boolean f;
        private boolean g;

        e(androidx.fragment.app.l0.e.c l0$e$c0, b l0$e$b0, Fragment fragment0, androidx.core.os.b b0) {
            class a implements androidx.core.os.b.b {
                final e a;

                @Override  // androidx.core.os.b$b
                public void a() {
                    e.this.b();
                }
            }

            this.d = new ArrayList();
            this.e = new HashSet();
            this.f = false;
            this.g = false;
            this.a = l0$e$c0;
            this.b = l0$e$b0;
            this.c = fragment0;
            b0.b(() -> {
                if(e.this.h()) {
                    return;
                }
                e.this.f = true;
                if(e.this.e.isEmpty()) {
                    e.this.c();
                    return;
                }
                for(Object object0: new ArrayList(e.this.e)) {
                    ((androidx.core.os.b)object0).a();
                }
            });
        }

        final void a(Runnable runnable0) {
            this.d.add(runnable0);
        }

        // 检测为 Lambda 实现
        final void b() [...]

        public void c() {
            if(this.g) {
                return;
            }
            if(x.G0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.g = true;
            for(Object object0: this.d) {
                ((Runnable)object0).run();
            }
        }

        public final void d(androidx.core.os.b b0) {
            if(this.e.remove(b0) && this.e.isEmpty()) {
                this.c();
            }
        }

        public androidx.fragment.app.l0.e.c e() {
            return this.a;
        }

        public final Fragment f() {
            return this.c;
        }

        b g() {
            return this.b;
        }

        final boolean h() {
            return this.f;
        }

        final boolean i() {
            return this.g;
        }

        public final void j(androidx.core.os.b b0) {
            this.l();
            this.e.add(b0);
        }

        final void k(androidx.fragment.app.l0.e.c l0$e$c0, b l0$e$b0) {
            b l0$e$b1;
            switch(l0$e$b0) {
                case 1: {
                    if(this.a == androidx.fragment.app.l0.e.c.e) {
                        if(x.G0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.b + " to ADDING.");
                        }
                        this.a = androidx.fragment.app.l0.e.c.f;
                        l0$e$b1 = b.f;
                        this.b = l0$e$b1;
                        return;
                    }
                    break;
                }
                case 2: {
                    if(x.G0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.a + " -> REMOVED. mLifecycleImpact  = " + this.b + " to REMOVING.");
                    }
                    this.a = androidx.fragment.app.l0.e.c.e;
                    l0$e$b1 = b.g;
                    this.b = l0$e$b1;
                    return;
                }
                case 3: {
                    if(this.a != androidx.fragment.app.l0.e.c.e) {
                        if(x.G0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.a + " -> " + l0$e$c0 + ". ");
                        }
                        this.a = l0$e$c0;
                        return;
                    }
                    break;
                }
            }
        }

        abstract void l();

        // 去混淆评级： 低(20)
        @Override
        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} " + "{" + "mFinalState = " + this.a + "} " + "{" + "mLifecycleImpact = " + this.b + "} " + "{" + "mFragment = " + this.c + "}";
        }
    }

    private final ViewGroup a;
    final ArrayList b;
    final ArrayList c;
    boolean d;
    boolean e;

    l0(ViewGroup viewGroup0) {
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = false;
        this.e = false;
        this.a = viewGroup0;
    }

    private void a(androidx.fragment.app.l0.e.c l0$e$c0, b l0$e$b0, d0 d00) {
        class androidx.fragment.app.l0.a implements Runnable {
            final d e;
            final l0 f;

            androidx.fragment.app.l0.a(d l0$d0) {
                this.e = l0$d0;
                super();
            }

            @Override
            public void run() {
                if(l0.this.b.contains(this.e)) {
                    this.e.e().c(this.e.f().I);
                }
            }
        }


        class androidx.fragment.app.l0.b implements Runnable {
            final d e;
            final l0 f;

            androidx.fragment.app.l0.b(d l0$d0) {
                this.e = l0$d0;
                super();
            }

            @Override
            public void run() {
                l0.this.b.remove(this.e);
                l0.this.c.remove(this.e);
            }
        }

        synchronized(this.b) {
            androidx.core.os.b b0 = new androidx.core.os.b();
            e l0$e0 = this.h(d00.k());
            if(l0$e0 != null) {
                l0$e0.k(l0$e$c0, l0$e$b0);
                return;
            }
            d l0$d0 = new d(l0$e$c0, l0$e$b0, d00, b0);
            this.b.add(l0$d0);
            l0$d0.a(new androidx.fragment.app.l0.a(this, l0$d0));
            l0$d0.a(new androidx.fragment.app.l0.b(this, l0$d0));
        }
    }

    void b(androidx.fragment.app.l0.e.c l0$e$c0, d0 d00) {
        if(x.G0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + d00.k());
        }
        this.a(l0$e$c0, b.f, d00);
    }

    void c(d0 d00) {
        if(x.G0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + d00.k());
        }
        this.a(androidx.fragment.app.l0.e.c.g, b.e, d00);
    }

    void d(d0 d00) {
        if(x.G0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + d00.k());
        }
        this.a(androidx.fragment.app.l0.e.c.e, b.g, d00);
    }

    void e(d0 d00) {
        if(x.G0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + d00.k());
        }
        this.a(androidx.fragment.app.l0.e.c.f, b.e, d00);
    }

    abstract void f(List arg1, boolean arg2);

    void g() {
        if(this.e) {
            return;
        }
        if(!v.v(this.a)) {
            this.j();
            this.d = false;
            return;
        }
        synchronized(this.b) {
            if(!this.b.isEmpty()) {
                ArrayList arrayList1 = new ArrayList(this.c);
                this.c.clear();
                for(Object object0: arrayList1) {
                    e l0$e0 = (e)object0;
                    if(x.G0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + l0$e0);
                    }
                    l0$e0.b();
                    if(!l0$e0.i()) {
                        this.c.add(l0$e0);
                    }
                }
                this.q();
                ArrayList arrayList2 = new ArrayList(this.b);
                this.b.clear();
                this.c.addAll(arrayList2);
                if(x.G0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                }
                for(Object object1: arrayList2) {
                    ((e)object1).l();
                }
                this.f(arrayList2, this.d);
                this.d = false;
                if(x.G0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                }
            }
        }
    }

    private e h(Fragment fragment0) {
        for(Object object0: this.b) {
            e l0$e0 = (e)object0;
            if(l0$e0.f().equals(fragment0) && !l0$e0.h()) {
                return l0$e0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    private e i(Fragment fragment0) {
        for(Object object0: this.c) {
            e l0$e0 = (e)object0;
            if(l0$e0.f().equals(fragment0) && !l0$e0.h()) {
                return l0$e0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    void j() {
        if(x.G0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean z = v.v(this.a);
        synchronized(this.b) {
            this.q();
            for(Object object0: this.b) {
                ((e)object0).l();
            }
            for(Object object1: new ArrayList(this.c)) {
                e l0$e0 = (e)object1;
                if(x.G0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + (z ? "" : "Container " + this.a + " is not attached to window. ") + "Cancelling running operation " + l0$e0);
                }
                l0$e0.b();
            }
            for(Object object2: new ArrayList(this.b)) {
                e l0$e1 = (e)object2;
                if(x.G0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + (z ? "" : "Container " + this.a + " is not attached to window. ") + "Cancelling pending operation " + l0$e1);
                }
                l0$e1.b();
            }
        }
    }

    void k() {
        if(this.e) {
            if(x.G0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.e = false;
            this.g();
        }
    }

    b l(d0 d00) {
        e l0$e0 = this.h(d00.k());
        b l0$e$b0 = l0$e0 == null ? null : l0$e0.g();
        e l0$e1 = this.i(d00.k());
        return l0$e1 == null || l0$e$b0 != null && l0$e$b0 != b.e ? l0$e$b0 : l0$e1.g();
    }

    public ViewGroup m() {
        return this.a;
    }

    static l0 n(ViewGroup viewGroup0, x x0) {
        return l0.o(viewGroup0, x0.y0());
    }

    static l0 o(ViewGroup viewGroup0, m0 m00) {
        Object object0 = viewGroup0.getTag(u.b.b);
        if(object0 instanceof l0) {
            return (l0)object0;
        }
        l0 l00 = m00.a(viewGroup0);
        viewGroup0.setTag(u.b.b, l00);
        return l00;
    }

    void p() {
        synchronized(this.b) {
            this.q();
            this.e = false;
            for(int v1 = this.b.size() - 1; v1 >= 0; --v1) {
                e l0$e0 = (e)this.b.get(v1);
                androidx.fragment.app.l0.e.c l0$e$c0 = androidx.fragment.app.l0.e.c.k(l0$e0.f().I);
                if(l0$e0.e() == androidx.fragment.app.l0.e.c.f && l0$e$c0 != androidx.fragment.app.l0.e.c.f) {
                    this.e = l0$e0.f().c0();
                    break;
                }
            }
        }
    }

    private void q() {
        for(Object object0: this.b) {
            e l0$e0 = (e)object0;
            if(l0$e0.g() == b.f) {
                l0$e0.k(androidx.fragment.app.l0.e.c.j(l0$e0.f().o1().getVisibility()), b.e);
            }
        }
    }

    void r(boolean z) {
        this.d = z;
    }
}

