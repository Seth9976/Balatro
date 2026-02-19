package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Animation;
import androidx.core.os.b;
import androidx.core.view.t;
import androidx.core.view.v;
import androidx.core.view.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

class d extends l0 {
    static abstract class a {
        static final int[] a;

        static {
            int[] arr_v = new int[c.values().length];
            a.a = arr_v;
            try {
                arr_v[c.g.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[c.h.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[c.e.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[c.f.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

    static class k extends l {
        private boolean c;
        private boolean d;
        private androidx.fragment.app.k.a e;

        k(e l0$e0, b b0, boolean z) {
            super(l0$e0, b0);
            this.d = false;
            this.c = z;
        }

        androidx.fragment.app.k.a e(Context context0) {
            if(this.d) {
                return this.e;
            }
            androidx.fragment.app.k.a k$a0 = androidx.fragment.app.k.b(context0, this.b().f(), this.b().e() == c.f, this.c);
            this.e = k$a0;
            this.d = true;
            return k$a0;
        }
    }

    static abstract class l {
        private final e a;
        private final b b;

        l(e l0$e0, b b0) {
            this.a = l0$e0;
            this.b = b0;
        }

        void a() {
            this.a.d(this.b);
        }

        e b() {
            return this.a;
        }

        b c() {
            return this.b;
        }

        boolean d() {
            c l0$e$c0 = c.k(this.a.f().I);
            c l0$e$c1 = this.a.e();
            return l0$e$c0 == l0$e$c1 || l0$e$c0 != c.f && l0$e$c1 != c.f;
        }
    }

    static class m extends l {
        private final Object c;
        private final boolean d;
        private final Object e;

        m(e l0$e0, b b0, boolean z, boolean z1) {
            super(l0$e0, b0);
            Object object0;
            boolean z2;
            if(l0$e0.e() == c.f) {
                Fragment fragment0 = l0$e0.f();
                this.c = z ? fragment0.L() : fragment0.v();
                Fragment fragment1 = l0$e0.f();
                z2 = z ? fragment1.p() : fragment1.n();
            }
            else {
                Fragment fragment2 = l0$e0.f();
                this.c = z ? fragment2.N() : fragment2.y();
                z2 = true;
            }
            this.d = z2;
            if(z1) {
                Fragment fragment3 = l0$e0.f();
                object0 = z ? fragment3.P() : fragment3.O();
            }
            else {
                object0 = null;
            }
            this.e = object0;
        }

        i0 e() {
            i0 i00 = this.f(this.c);
            i0 i01 = this.f(this.e);
            if(i00 != null && i01 != null && i00 != i01) {
                throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + this.b().f() + " returned Transition " + this.c + " which uses a different Transition  type than its shared element transition " + this.e);
            }
            return i00 == null ? i01 : i00;
        }

        private i0 f(Object object0) {
            if(object0 == null) {
                return null;
            }
            i0 i00 = g0.a;
            if(i00 != null && i00.e(object0)) {
                return i00;
            }
            i0 i01 = g0.b;
            if(i01 == null || !i01.e(object0)) {
                throw new IllegalArgumentException("Transition " + object0 + " for fragment " + this.b().f() + " is not a valid framework Transition or AndroidX Transition");
            }
            return i01;
        }

        public Object g() {
            return this.e;
        }

        Object h() {
            return this.c;
        }

        public boolean i() {
            return this.e != null;
        }

        boolean j() {
            return this.d;
        }
    }

    d(ViewGroup viewGroup0) {
        super(viewGroup0);
    }

    @Override  // androidx.fragment.app.l0
    void f(List list0, boolean z) {
        class androidx.fragment.app.d.b implements Runnable {
            final List e;
            final e f;
            final d g;

            androidx.fragment.app.d.b(List list0, e l0$e0) {
                this.e = list0;
                this.f = l0$e0;
                super();
            }

            @Override
            public void run() {
                if(this.e.contains(this.f)) {
                    this.e.remove(this.f);
                    d.this.s(this.f);
                }
            }
        }

        e l0$e0 = null;
        e l0$e1 = null;
        for(Object object0: list0) {
            e l0$e2 = (e)object0;
            c l0$e$c0 = c.k(l0$e2.f().I);
            int v = a.a[l0$e2.e().ordinal()];
            if(v != 1 && v != 2 && v != 3) {
                if(v != 4 || l0$e$c0 == c.f) {
                    continue;
                }
                l0$e1 = l0$e2;
            }
            else if(l0$e$c0 == c.f && l0$e0 == null) {
                l0$e0 = l0$e2;
            }
        }
        if(x.G0(2)) {
            Log.v("FragmentManager", "Executing operations from " + l0$e0 + " to " + l0$e1);
        }
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list0);
        this.y(list0);
        for(Object object1: list0) {
            e l0$e3 = (e)object1;
            b b0 = new b();
            l0$e3.j(b0);
            arrayList0.add(new k(l0$e3, b0, z));
            b b1 = new b();
            l0$e3.j(b1);
            boolean z1 = false;
            if(!z) {
                if(l0$e3 == l0$e1) {
                    z1 = true;
                }
            }
            else if(l0$e3 == l0$e0) {
                z1 = true;
            }
            arrayList1.add(new m(l0$e3, b1, z, z1));
            l0$e3.a(new androidx.fragment.app.d.b(this, arrayList2, l0$e3));
        }
        Map map0 = this.x(arrayList1, arrayList2, z, l0$e0, l0$e1);
        this.w(arrayList0, arrayList2, map0.containsValue(Boolean.TRUE), map0);
        for(Object object2: arrayList2) {
            this.s(((e)object2));
        }
        arrayList2.clear();
        if(x.G0(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + l0$e0 + " to " + l0$e1);
        }
    }

    void s(e l0$e0) {
        l0$e0.e().c(l0$e0.f().I);
    }

    void t(ArrayList arrayList0, View view0) {
        if(view0 instanceof ViewGroup) {
            if(!y.a(((ViewGroup)view0))) {
                int v = ((ViewGroup)view0).getChildCount();
                for(int v1 = 0; v1 < v; ++v1) {
                    View view1 = ((ViewGroup)view0).getChildAt(v1);
                    if(view1.getVisibility() == 0) {
                        this.t(arrayList0, view1);
                    }
                }
            }
            else if(!arrayList0.contains(view0)) {
                arrayList0.add(((ViewGroup)view0));
            }
        }
        else if(!arrayList0.contains(view0)) {
            arrayList0.add(view0);
        }
    }

    void u(Map map0, View view0) {
        String s = v.s(view0);
        if(s != null) {
            map0.put(s, view0);
        }
        if(view0 instanceof ViewGroup) {
            int v = ((ViewGroup)view0).getChildCount();
            for(int v1 = 0; v1 < v; ++v1) {
                View view1 = ((ViewGroup)view0).getChildAt(v1);
                if(view1.getVisibility() == 0) {
                    this.u(map0, view1);
                }
            }
        }
    }

    void v(k.a a0, Collection collection0) {
        Iterator iterator0 = a0.entrySet().iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            if(!collection0.contains(v.s(((View)((Map.Entry)object0).getValue())))) {
                iterator0.remove();
            }
        }
    }

    private void w(List list0, List list1, boolean z, Map map0) {
        class androidx.fragment.app.d.c extends AnimatorListenerAdapter {
            final ViewGroup a;
            final View b;
            final boolean c;
            final e d;
            final k e;
            final d f;

            androidx.fragment.app.d.c(ViewGroup viewGroup0, View view0, boolean z, e l0$e0, k d$k0) {
                this.a = viewGroup0;
                this.b = view0;
                this.c = z;
                this.d = l0$e0;
                this.e = d$k0;
                super();
            }

            @Override  // android.animation.AnimatorListenerAdapter
            public void onAnimationEnd(Animator animator0) {
                this.a.endViewTransition(this.b);
                if(this.c) {
                    this.d.e().c(this.b);
                }
                this.e.a();
                if(x.G0(2)) {
                    Log.v("FragmentManager", "Animator from operation " + this.d + " has ended.");
                }
            }
        }


        class androidx.fragment.app.d.d implements androidx.core.os.b.b {
            final Animator a;
            final e b;
            final d c;

            androidx.fragment.app.d.d(Animator animator0, e l0$e0) {
                this.a = animator0;
                this.b = l0$e0;
                super();
            }

            @Override  // androidx.core.os.b$b
            public void a() {
                this.a.end();
                if(x.G0(2)) {
                    Log.v("FragmentManager", "Animator from operation " + this.b + " has been canceled.");
                }
            }
        }


        class androidx.fragment.app.d.e implements Animation.AnimationListener {
            final e a;
            final ViewGroup b;
            final View c;
            final k d;
            final d e;

            androidx.fragment.app.d.e(e l0$e0, ViewGroup viewGroup0, View view0, k d$k0) {
                this.a = l0$e0;
                this.b = viewGroup0;
                this.c = view0;
                this.d = d$k0;
                super();
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationEnd(Animation animation0) {
                class androidx.fragment.app.d.e.a implements Runnable {
                    final androidx.fragment.app.d.e e;

                    @Override
                    public void run() {
                        androidx.fragment.app.d.e.this.b.endViewTransition(androidx.fragment.app.d.e.this.c);
                        androidx.fragment.app.d.e.this.d.a();
                    }
                }

                androidx.fragment.app.d.e.a d$e$a0 = new androidx.fragment.app.d.e.a(this);
                this.b.post(d$e$a0);
                if(x.G0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + this.a + " has ended.");
                }
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationRepeat(Animation animation0) {
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationStart(Animation animation0) {
                if(x.G0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + this.a + " has reached onAnimationStart.");
                }
            }
        }


        class f implements androidx.core.os.b.b {
            final View a;
            final ViewGroup b;
            final k c;
            final e d;
            final d e;

            f(View view0, ViewGroup viewGroup0, k d$k0, e l0$e0) {
                this.a = view0;
                this.b = viewGroup0;
                this.c = d$k0;
                this.d = l0$e0;
                super();
            }

            @Override  // androidx.core.os.b$b
            public void a() {
                this.a.clearAnimation();
                this.b.endViewTransition(this.a);
                this.c.a();
                if(x.G0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + this.d + " has been cancelled.");
                }
            }
        }

        View view2;
        e l0$e1;
        ViewGroup viewGroup0 = this.m();
        Context context0 = viewGroup0.getContext();
        ArrayList arrayList0 = new ArrayList();
        boolean z1 = false;
        for(Object object0: list0) {
            k d$k0 = (k)object0;
            if(!d$k0.d()) {
                androidx.fragment.app.k.a k$a0 = d$k0.e(context0);
                if(k$a0 != null) {
                    Animator animator0 = k$a0.b;
                    if(animator0 == null) {
                        arrayList0.add(d$k0);
                    }
                    else {
                        e l0$e0 = d$k0.b();
                        Fragment fragment0 = l0$e0.f();
                        Object object1 = map0.get(l0$e0);
                        if(Boolean.TRUE.equals(object1)) {
                            if(x.G0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragment0 + " as this Fragment was involved in a Transition.");
                            }
                            d$k0.a();
                        }
                        else {
                            boolean z2 = l0$e0.e() == c.g;
                            if(z2) {
                                list1.remove(l0$e0);
                            }
                            View view0 = fragment0.I;
                            viewGroup0.startViewTransition(view0);
                            animator0.addListener(new androidx.fragment.app.d.c(this, viewGroup0, view0, z2, l0$e0, d$k0));
                            animator0.setTarget(view0);
                            animator0.start();
                            if(x.G0(2)) {
                                l0$e1 = l0$e0;
                                Log.v("FragmentManager", "Animator from operation " + l0$e1 + " has started.");
                            }
                            else {
                                l0$e1 = l0$e0;
                            }
                            d$k0.c().b(new androidx.fragment.app.d.d(this, animator0, l0$e1));
                            z1 = true;
                        }
                    }
                    continue;
                }
            }
            d$k0.a();
        }
        for(Object object2: arrayList0) {
            k d$k1 = (k)object2;
            e l0$e2 = d$k1.b();
            Fragment fragment1 = l0$e2.f();
            if(!z) {
                if(!z1) {
                    goto label_56;
                }
                else if(x.G0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment1 + " as Animations cannot run alongside Animators.");
                }
            }
            else if(x.G0(2)) {
                Log.v("FragmentManager", "Ignoring Animation set on " + fragment1 + " as Animations cannot run alongside Transitions.");
            }
            d$k1.a();
            continue;
        label_56:
            View view1 = fragment1.I;
            Animation animation0 = (Animation)androidx.core.util.c.d(((androidx.fragment.app.k.a)androidx.core.util.c.d(d$k1.e(context0))).a);
            if(l0$e2.e() == c.e) {
                viewGroup0.startViewTransition(view1);
                androidx.fragment.app.k.b k$b0 = new androidx.fragment.app.k.b(animation0, viewGroup0, view1);
                view2 = view1;
                k$b0.setAnimationListener(new androidx.fragment.app.d.e(this, l0$e2, viewGroup0, view1, d$k1));
                view2.startAnimation(k$b0);
                if(x.G0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + l0$e2 + " has started.");
                }
            }
            else {
                view1.startAnimation(animation0);
                d$k1.a();
                view2 = view1;
            }
            d$k1.c().b(new f(this, view2, viewGroup0, d$k1, l0$e2));
            z1 = false;
        }
    }

    private Map x(List list0, List list1, boolean z, e l0$e0, e l0$e1) {
        class g implements Runnable {
            final e e;
            final e f;
            final boolean g;
            final k.a h;
            final d i;

            g(e l0$e0, e l0$e1, boolean z, k.a a0) {
                this.e = l0$e0;
                this.f = l0$e1;
                this.g = z;
                this.h = a0;
                super();
            }

            @Override
            public void run() {
                g0.a(this.e.f(), this.f.f(), this.g, this.h, false);
            }
        }


        class h implements Runnable {
            final i0 e;
            final View f;
            final Rect g;
            final d h;

            h(i0 i00, View view0, Rect rect0) {
                this.e = i00;
                this.f = view0;
                this.g = rect0;
                super();
            }

            @Override
            public void run() {
                this.e.h(this.f, this.g);
            }
        }


        class i implements Runnable {
            final ArrayList e;
            final d f;

            i(ArrayList arrayList0) {
                this.e = arrayList0;
                super();
            }

            @Override
            public void run() {
                g0.d(this.e, 4);
            }
        }


        class j implements Runnable {
            final m e;
            final e f;
            final d g;

            j(m d$m0, e l0$e0) {
                this.e = d$m0;
                this.f = l0$e0;
                super();
            }

            @Override
            public void run() {
                this.e.a();
                if(x.G0(2)) {
                    Log.v("FragmentManager", "Transition for operation " + this.f + "has completed");
                }
            }
        }

        Object object14;
        Object object13;
        View view9;
        Map map3;
        Object object12;
        View view8;
        ArrayList arrayList12;
        ArrayList arrayList11;
        View view5;
        Map map1;
        e l0$e5;
        i0 i02;
        View view2;
        Rect rect1;
        ArrayList arrayList7;
        e l0$e4;
        ArrayList arrayList6;
        k.a a3;
        e l0$e2 = l0$e0;
        e l0$e3 = l0$e1;
        Map map0 = new HashMap();
        i0 i00 = null;
        for(Object object0: list0) {
            m d$m0 = (m)object0;
            if(!d$m0.d()) {
                i0 i01 = d$m0.e();
                if(i00 == null) {
                    i00 = i01;
                }
                else {
                    if(i01 != null && i00 != i01) {
                        throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + d$m0.b().f() + " returned Transition " + d$m0.h() + " which uses a different Transition  type than other Fragments.");
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }
        if(i00 == null) {
            for(Object object1: list0) {
                map0.put(((m)object1).b(), Boolean.FALSE);
                ((m)object1).a();
            }
            return map0;
        }
        View view0 = new View(this.m().getContext());
        Rect rect0 = new Rect();
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        k.a a0 = new k.a();
        Object object2 = null;
        View view1 = null;
        boolean z1 = false;
        for(Object object3: list0) {
            m d$m1 = (m)object3;
            if(!d$m1.i() || l0$e2 == null || l0$e3 == null) {
                a3 = a0;
                arrayList6 = arrayList1;
                l0$e4 = l0$e2;
                arrayList7 = arrayList0;
                rect1 = rect0;
                i02 = i00;
                map1 = map0;
                l0$e5 = l0$e3;
                view2 = view0;
            }
            else {
                Object object4 = i00.u(i00.f(d$m1.g()));
                ArrayList arrayList2 = l0$e1.f().Q();
                ArrayList arrayList3 = l0$e0.f().Q();
                Object object5 = object4;
                ArrayList arrayList4 = l0$e0.f().R();
                for(int v = 0; v < arrayList4.size(); ++v) {
                    int v1 = arrayList2.indexOf(arrayList4.get(v));
                    if(v1 != -1) {
                        arrayList2.set(v1, ((String)arrayList3.get(v)));
                    }
                }
                ArrayList arrayList5 = l0$e1.f().R();
                Fragment fragment0 = l0$e0.f();
                if(z) {
                    fragment0.w();
                    l0$e1.f().z();
                }
                else {
                    fragment0.z();
                    l0$e1.f().w();
                }
                int v2 = arrayList2.size();
                for(int v3 = 0; v3 < v2; ++v3) {
                    a0.put(((String)arrayList2.get(v3)), ((String)arrayList5.get(v3)));
                }
                if(x.G0(2)) {
                    Log.v("FragmentManager", ">>> entering view names <<<");
                    for(Object object6: arrayList5) {
                        Log.v("FragmentManager", "Name: " + ((String)object6));
                    }
                    Log.v("FragmentManager", ">>> exiting view names <<<");
                    for(Object object7: arrayList2) {
                        Log.v("FragmentManager", "Name: " + ((String)object7));
                    }
                }
                k.a a1 = new k.a();
                this.u(a1, l0$e0.f().I);
                a1.n(arrayList2);
                a0.n(a1.keySet());
                k.a a2 = new k.a();
                this.u(a2, l0$e1.f().I);
                a2.n(arrayList5);
                a2.n(a0.values());
                g0.c(a0, a2);
                this.v(a1, a0.keySet());
                this.v(a2, a0.values());
                if(a0.isEmpty()) {
                    arrayList0.clear();
                    arrayList1.clear();
                    a3 = a0;
                    arrayList6 = arrayList1;
                    l0$e4 = l0$e2;
                    arrayList7 = arrayList0;
                    rect1 = rect0;
                    view2 = view0;
                    i02 = i00;
                    object2 = null;
                    l0$e5 = l0$e1;
                    map1 = map0;
                }
                else {
                    g0.a(l0$e1.f(), l0$e0.f(), z, a1, true);
                    a3 = a0;
                    t.a(this.m(), new g(this, l0$e1, l0$e0, z, a2));
                    arrayList0.addAll(a1.values());
                    if(!arrayList2.isEmpty()) {
                        View view3 = (View)a1.get(((String)arrayList2.get(0)));
                        i00.p(object5, view3);
                        view1 = view3;
                    }
                    arrayList6 = arrayList1;
                    arrayList6.addAll(a2.values());
                    if(arrayList5.isEmpty()) {
                        view5 = view0;
                    }
                    else {
                        View view4 = (View)a2.get(((String)arrayList5.get(0)));
                        if(view4 != null) {
                            t.a(this.m(), new h(this, i00, view4, rect0));
                            view5 = view0;
                            z1 = true;
                        }
                    }
                    i00.s(object5, view5, arrayList0);
                    arrayList7 = arrayList0;
                    rect1 = rect0;
                    view2 = view5;
                    i02 = i00;
                    i00.n(object5, null, null, null, null, object5, arrayList6);
                    l0$e4 = l0$e0;
                    map1 = map0;
                    map1.put(l0$e4, Boolean.TRUE);
                    l0$e5 = l0$e1;
                    map1.put(l0$e5, Boolean.TRUE);
                    object2 = object5;
                }
            }
            l0$e2 = l0$e4;
            arrayList0 = arrayList7;
            rect0 = rect1;
            map0 = map1;
            a0 = a3;
            arrayList1 = arrayList6;
            i00 = i02;
            view0 = view2;
            l0$e3 = l0$e5;
        }
        View view6 = view1;
        ArrayList arrayList8 = arrayList1;
        ArrayList arrayList9 = arrayList0;
        Map map2 = map0;
        e l0$e6 = l0$e3;
        View view7 = view0;
        ArrayList arrayList10 = new ArrayList();
        Object object8 = null;
        Object object9 = null;
        for(Object object10: list0) {
            m d$m2 = (m)object10;
            if(d$m2.d()) {
                map2.put(d$m2.b(), Boolean.FALSE);
                d$m2.a();
            }
            else {
                Object object11 = i00.f(d$m2.h());
                e l0$e7 = d$m2.b();
                boolean z2 = object2 != null && (l0$e7 == l0$e2 || l0$e7 == l0$e6);
                if(object11 == null) {
                    if(!z2) {
                        map2.put(l0$e7, Boolean.FALSE);
                        d$m2.a();
                    }
                    arrayList11 = arrayList8;
                    arrayList12 = arrayList9;
                    view8 = view7;
                    object12 = object8;
                    map3 = map2;
                    view9 = view6;
                }
                else {
                    ArrayList arrayList13 = new ArrayList();
                    this.t(arrayList13, l0$e7.f().I);
                    if(z2) {
                        if(l0$e7 == l0$e2) {
                            arrayList13.removeAll(arrayList9);
                        }
                        else {
                            arrayList13.removeAll(arrayList8);
                        }
                    }
                    if(arrayList13.isEmpty()) {
                        i00.a(object11, view7);
                        arrayList11 = arrayList8;
                        arrayList12 = arrayList9;
                        view8 = view7;
                        object13 = object9;
                        map3 = map2;
                        object14 = object8;
                    }
                    else {
                        i00.b(object11, arrayList13);
                        view8 = view7;
                        object14 = object8;
                        arrayList12 = arrayList9;
                        object13 = object9;
                        arrayList11 = arrayList8;
                        map3 = map2;
                        i00.n(object11, object11, arrayList13, null, null, null, null);
                        if(l0$e7.e() == c.g) {
                            list1.remove(l0$e7);
                            ArrayList arrayList14 = new ArrayList(arrayList13);
                            arrayList14.remove(l0$e7.f().I);
                            i00.m(object11, l0$e7.f().I, arrayList14);
                            t.a(this.m(), new i(this, arrayList13));
                        }
                    }
                    if(l0$e7.e() == c.f) {
                        arrayList10.addAll(arrayList13);
                        if(z1) {
                            i00.o(object11, rect0);
                        }
                        view9 = view6;
                    }
                    else {
                        view9 = view6;
                        i00.p(object11, view9);
                    }
                    map3.put(l0$e7, Boolean.TRUE);
                    if(d$m2.j()) {
                        object9 = i00.k(object13, object11, null);
                        object12 = object14;
                    }
                    else {
                        object12 = i00.k(object14, object11, null);
                        object9 = object13;
                    }
                }
                l0$e6 = l0$e1;
                map2 = map3;
                object8 = object12;
                view6 = view9;
                view7 = view8;
                arrayList9 = arrayList12;
                arrayList8 = arrayList11;
            }
        }
        Object object15 = i00.j(object9, object8, object2);
        if(object15 == null) {
            return map2;
        }
        for(Object object16: list0) {
            m d$m3 = (m)object16;
            if(!d$m3.d()) {
                e l0$e8 = d$m3.b();
                if(d$m3.h() == null && (object2 == null || l0$e8 != l0$e2 && l0$e8 != l0$e1)) {
                }
                else if(v.w(this.m())) {
                    i00.q(d$m3.b().f(), object15, d$m3.c(), new j(this, d$m3, l0$e8));
                }
                else {
                    if(x.G0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + this.m() + " has not been laid out. Completing operation " + l0$e8);
                    }
                    d$m3.a();
                }
            }
        }
        if(!v.w(this.m())) {
            return map2;
        }
        g0.d(arrayList10, 4);
        ArrayList arrayList15 = i00.l(arrayList8);
        if(x.G0(2)) {
            Log.v("FragmentManager", ">>>>> Beginning transition <<<<<");
            Log.v("FragmentManager", ">>>>> SharedElementFirstOutViews <<<<<");
            for(Object object17: arrayList9) {
                Log.v("FragmentManager", "View: " + ((View)object17) + " Name: " + v.s(((View)object17)));
            }
            Log.v("FragmentManager", ">>>>> SharedElementLastInViews <<<<<");
            for(Object object18: arrayList8) {
                Log.v("FragmentManager", "View: " + ((View)object18) + " Name: " + v.s(((View)object18)));
            }
        }
        i00.c(this.m(), object15);
        i00.r(this.m(), arrayList9, arrayList8, arrayList15, a0);
        g0.d(arrayList10, 0);
        i00.t(object2, arrayList9, arrayList8);
        return map2;
    }

    private void y(List list0) {
        Fragment fragment0 = ((e)list0.get(list0.size() - 1)).f();
        for(Object object0: list0) {
            ((e)object0).f().L.c = fragment0.L.c;
            ((e)object0).f().L.d = fragment0.L.d;
            ((e)object0).f().L.e = fragment0.L.e;
            ((e)object0).f().L.f = fragment0.L.f;
        }
    }
}

