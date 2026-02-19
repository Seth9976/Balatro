package e1;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
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

public final class e0 extends Fragment implements f {
    private final Map a;
    private int b;
    private Bundle c;
    private static final WeakHashMap d;

    static {
        e0.d = new WeakHashMap();
    }

    public e0() {
        this.a = Collections.synchronizedMap(new a());
        this.b = 0;
    }

    @Override  // e1.f
    public final void b(String s, LifecycleCallback lifecycleCallback0) {
        if(this.a.containsKey(s)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + s + " already added to this fragment.");
        }
        this.a.put(s, lifecycleCallback0);
        if(this.b > 0) {
            new e(Looper.getMainLooper()).post(new d0(this, lifecycleCallback0, s));
        }
    }

    public static e0 d(Activity activity0) {
        e0 e01;
        WeakHashMap weakHashMap0 = e0.d;
        WeakReference weakReference0 = (WeakReference)weakHashMap0.get(activity0);
        if(weakReference0 != null) {
            e0 e00 = (e0)weakReference0.get();
            if(e00 != null) {
                return e00;
            }
        }
        try {
            e01 = (e0)activity0.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
        }
        catch(ClassCastException classCastException0) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", classCastException0);
        }
        if(e01 == null || e01.isRemoving()) {
            e01 = new e0();
            activity0.getFragmentManager().beginTransaction().add(e01, "LifecycleFragmentImpl").commitAllowingStateLoss();
        }
        weakHashMap0.put(activity0, new WeakReference(e01));
        return e01;
    }

    @Override  // android.app.Fragment
    public final void dump(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        super.dump(s, fileDescriptor0, printWriter0, arr_s);
        for(Object object0: this.a.values()) {
            ((LifecycleCallback)object0).a(s, fileDescriptor0, printWriter0, arr_s);
        }
    }

    @Override  // e1.f
    public final LifecycleCallback e(String s, Class class0) {
        return (LifecycleCallback)class0.cast(this.a.get(s));
    }

    @Override  // e1.f
    public final Activity f() {
        return this.getActivity();
    }

    @Override  // android.app.Fragment
    public final void onActivityResult(int v, int v1, Intent intent0) {
        super.onActivityResult(v, v1, intent0);
        for(Object object0: this.a.values()) {
            ((LifecycleCallback)object0).e(v, v1, intent0);
        }
    }

    @Override  // android.app.Fragment
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.b = 1;
        this.c = bundle0;
        for(Object object0: this.a.entrySet()) {
            ((LifecycleCallback)((Map.Entry)object0).getValue()).f((bundle0 == null ? null : bundle0.getBundle(((String)((Map.Entry)object0).getKey()))));
        }
    }

    @Override  // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.b = 5;
        Iterator iterator0 = this.a.values().iterator();
        while(iterator0.hasNext()) {
            iterator0.next();
        }
    }

    @Override  // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.b = 3;
        for(Object object0: this.a.values()) {
            ((LifecycleCallback)object0).h();
        }
    }

    @Override  // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            for(Object object0: this.a.entrySet()) {
                Bundle bundle1 = new Bundle();
                ((LifecycleCallback)((Map.Entry)object0).getValue()).i(bundle1);
                bundle0.putBundle(((String)((Map.Entry)object0).getKey()), bundle1);
            }
        }
    }

    @Override  // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.b = 2;
        for(Object object0: this.a.values()) {
            ((LifecycleCallback)object0).j();
        }
    }

    @Override  // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.b = 4;
        for(Object object0: this.a.values()) {
            ((LifecycleCallback)object0).k();
        }
    }
}

