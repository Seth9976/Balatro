package e1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import b2.e;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.WeakHashMap;
import k.a;

public final class g0 extends Fragment implements f {
    private final Map d0;
    private int e0;
    private Bundle f0;
    private static final WeakHashMap g0;

    static {
        g0.g0 = new WeakHashMap();
    }

    public g0() {
        this.d0 = Collections.synchronizedMap(new a());
        this.e0 = 0;
    }

    public static g0 D1(j j0) {
        g0 g01;
        WeakHashMap weakHashMap0 = g0.g0;
        WeakReference weakReference0 = (WeakReference)weakHashMap0.get(j0);
        if(weakReference0 != null) {
            g0 g00 = (g0)weakReference0.get();
            if(g00 != null) {
                return g00;
            }
        }
        try {
            g01 = (g0)j0.M().h0("SupportLifecycleFragmentImpl");
        }
        catch(ClassCastException classCastException0) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", classCastException0);
        }
        if(g01 == null || g01.d0()) {
            g01 = new g0();
            j0.M().o().d(g01, "SupportLifecycleFragmentImpl").g();
        }
        weakHashMap0.put(j0, new WeakReference(g01));
        return g01;
    }

    @Override  // androidx.fragment.app.Fragment
    public final void H0() {
        super.H0();
        this.e0 = 3;
        for(Object object0: this.d0.values()) {
            ((LifecycleCallback)object0).h();
        }
    }

    @Override  // androidx.fragment.app.Fragment
    public final void I0(Bundle bundle0) {
        super.I0(bundle0);
        if(bundle0 != null) {
            for(Object object0: this.d0.entrySet()) {
                Bundle bundle1 = new Bundle();
                ((LifecycleCallback)((Map.Entry)object0).getValue()).i(bundle1);
                bundle0.putBundle(((String)((Map.Entry)object0).getKey()), bundle1);
            }
        }
    }

    @Override  // androidx.fragment.app.Fragment
    public final void J0() {
        super.J0();
        this.e0 = 2;
        for(Object object0: this.d0.values()) {
            ((LifecycleCallback)object0).j();
        }
    }

    @Override  // androidx.fragment.app.Fragment
    public final void K0() {
        super.K0();
        this.e0 = 4;
        for(Object object0: this.d0.values()) {
            ((LifecycleCallback)object0).k();
        }
    }

    @Override  // e1.f
    public final void b(String s, LifecycleCallback lifecycleCallback0) {
        if(this.d0.containsKey(s)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + s + " already added to this fragment.");
        }
        this.d0.put(s, lifecycleCallback0);
        if(this.e0 > 0) {
            new e(Looper.getMainLooper()).post(new f0(this, lifecycleCallback0, s));
        }
    }

    @Override  // e1.f
    public final LifecycleCallback e(String s, Class class0) {
        return (LifecycleCallback)class0.cast(this.d0.get(s));
    }

    @Override  // e1.f
    public final Activity f() {
        return this.m();
    }

    @Override  // androidx.fragment.app.Fragment
    public final void h0(int v, int v1, Intent intent0) {
        super.h0(v, v1, intent0);
        for(Object object0: this.d0.values()) {
            ((LifecycleCallback)object0).e(v, v1, intent0);
        }
    }

    @Override  // androidx.fragment.app.Fragment
    public final void i(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        super.i(s, fileDescriptor0, printWriter0, arr_s);
        for(Object object0: this.d0.values()) {
            ((LifecycleCallback)object0).a(s, fileDescriptor0, printWriter0, arr_s);
        }
    }

    @Override  // androidx.fragment.app.Fragment
    public final void m0(Bundle bundle0) {
        super.m0(bundle0);
        this.e0 = 1;
        this.f0 = bundle0;
        for(Object object0: this.d0.entrySet()) {
            ((LifecycleCallback)((Map.Entry)object0).getValue()).f((bundle0 == null ? null : bundle0.getBundle(((String)((Map.Entry)object0).getKey()))));
        }
    }

    @Override  // androidx.fragment.app.Fragment
    public final void r0() {
        super.r0();
        this.e0 = 5;
        Iterator iterator0 = this.d0.values().iterator();
        while(iterator0.hasNext()) {
            iterator0.next();
        }
    }
}

