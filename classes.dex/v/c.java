package v;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.x;
import c3.e0;
import c3.q;
import c3.z;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import k3.d;
import k3.f;

public final class c {
    public static enum a {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER;

        private static final a[] c() [...] // Inlined contents
    }

    public interface b {
    }

    public static final class v.c.c {
        public static final class v.c.c.a {
            private v.c.c.a() {
            }

            public v.c.c.a(d d0) {
            }
        }

        private final Set a;
        private final Map b;
        public static final v.c.c.a c;
        public static final v.c.c d;

        static {
            v.c.c.c = new v.c.c.a(null);
            v.c.c.d = new v.c.c(e0.b(), null, z.d());
        }

        public v.c.c(Set set0, b c$b0, Map map0) {
            f.e(set0, "flags");
            f.e(map0, "allowedViolations");
            super();
            this.a = set0;
            LinkedHashMap linkedHashMap0 = new LinkedHashMap();
            for(Object object0: map0.entrySet()) {
                linkedHashMap0.put(((String)((Map.Entry)object0).getKey()), ((Set)((Map.Entry)object0).getValue()));
            }
            this.b = linkedHashMap0;
        }

        public final Set a() {
            return this.a;
        }

        public final b b() [...] // Inlined contents

        public final Map c() {
            return this.b;
        }
    }

    public static final c a;
    private static v.c.c b;

    static {
        c.a = new c();
        c.b = v.c.c.d;
    }

    private final v.c.c b(Fragment fragment0) {
        while(fragment0 != null) {
            if(fragment0.Y()) {
                x x0 = fragment0.G();
                f.d(x0, "declaringFragment.parentFragmentManager");
                if(x0.z0() != null) {
                    v.c.c c$c0 = x0.z0();
                    f.b(c$c0);
                    return c$c0;
                }
            }
            fragment0 = fragment0.F();
        }
        return c.b;
    }

    private final void c(v.c.c c$c0, g g0) {
        Fragment fragment0 = g0.a();
        String s = fragment0.getClass().getName();
        if(c$c0.a().contains(a.e)) {
            Log.d("FragmentStrictMode", "Policy violation in " + s, g0);
        }
        if(c$c0.a().contains(a.f)) {
            this.j(fragment0, () -> {
                f.e(g0, "$violation");
                Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + s, g0);
                throw g0;
            });
        }
    }

    // 检测为 Lambda 实现
    private static final void d(String s, g g0) [...]

    private final void e(g g0) {
        if(x.G0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + g0.a().getClass().getName(), g0);
        }
    }

    public static final void f(Fragment fragment0, String s) {
        f.e(fragment0, "fragment");
        f.e(s, "previousFragmentId");
        v.a a0 = new v.a(fragment0, s);
        c c0 = c.a;
        c0.e(a0);
        v.c.c c$c0 = c0.b(fragment0);
        if(c$c0.a().contains(a.g) && c0.k(c$c0, fragment0.getClass(), a0.getClass())) {
            c0.c(c$c0, a0);
        }
    }

    public static final void g(Fragment fragment0, ViewGroup viewGroup0) {
        f.e(fragment0, "fragment");
        v.d d0 = new v.d(fragment0, viewGroup0);
        c c0 = c.a;
        c0.e(d0);
        v.c.c c$c0 = c0.b(fragment0);
        if(c$c0.a().contains(a.h) && c0.k(c$c0, fragment0.getClass(), d0.getClass())) {
            c0.c(c$c0, d0);
        }
    }

    public static final void h(Fragment fragment0) {
        f.e(fragment0, "fragment");
        e e0 = new e(fragment0);
        c c0 = c.a;
        c0.e(e0);
        v.c.c c$c0 = c0.b(fragment0);
        if(c$c0.a().contains(a.k) && c0.k(c$c0, fragment0.getClass(), e0.getClass())) {
            c0.c(c$c0, e0);
        }
    }

    public static final void i(Fragment fragment0, ViewGroup viewGroup0) {
        f.e(fragment0, "fragment");
        f.e(viewGroup0, "container");
        h h0 = new h(fragment0, viewGroup0);
        c c0 = c.a;
        c0.e(h0);
        v.c.c c$c0 = c0.b(fragment0);
        if(c$c0.a().contains(a.l) && c0.k(c$c0, fragment0.getClass(), h0.getClass())) {
            c0.c(c$c0, h0);
        }
    }

    private final void j(Fragment fragment0, Runnable runnable0) {
        if(fragment0.Y()) {
            Handler handler0 = fragment0.G().t0().v();
            f.d(handler0, "fragment.parentFragmentManager.host.handler");
            if(!f.a(handler0.getLooper(), Looper.myLooper())) {
                handler0.post(runnable0);
                return;
            }
        }
        runnable0.run();
    }

    private final boolean k(v.c.c c$c0, Class class0, Class class1) {
        Set set0 = (Set)c$c0.c().get(class0.getName());
        if(set0 == null) {
            return true;
        }
        return f.a(class1.getSuperclass(), g.class) || !q.h(set0, class1.getSuperclass()) ? !set0.contains(class1) : false;
    }
}

