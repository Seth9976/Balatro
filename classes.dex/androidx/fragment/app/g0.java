package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import k.a;

abstract class g0 {
    static final i0 a;
    static final i0 b;

    static {
        g0.a = new h0();
        g0.b = g0.b();
    }

    static void a(Fragment fragment0, Fragment fragment1, boolean z, a a0, boolean z1) {
        if(z) {
            fragment1.w();
            return;
        }
        fragment0.w();
    }

    private static i0 b() {
        try {
            return (i0)Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor().newInstance();
        }
        catch(Exception unused_ex) {
            return null;
        }
    }

    static void c(a a0, a a1) {
        for(int v = a0.size() - 1; v >= 0; --v) {
            if(!a1.containsKey(((String)a0.l(v)))) {
                a0.j(v);
            }
        }
    }

    static void d(ArrayList arrayList0, int v) {
        if(arrayList0 == null) {
            return;
        }
        for(int v1 = arrayList0.size() - 1; v1 >= 0; --v1) {
            ((View)arrayList0.get(v1)).setVisibility(v);
        }
    }
}

