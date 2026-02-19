package z;

import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.lifecycle.l;
import java.util.Map.Entry;
import k3.d;
import k3.f;

public final class c {
    public interface a {
        void a(e arg1);
    }

    static final class b {
        private b() {
        }

        public b(d d0) {
        }
    }

    public interface z.c.c {
        Bundle a();
    }

    private final j.b a;
    private boolean b;
    private Bundle c;
    private boolean d;
    private androidx.savedstate.Recreator.b e;
    private boolean f;
    private static final b g;

    static {
        c.g = new b(null);
    }

    public c() {
        this.a = new j.b();
        this.f = true;
    }

    public final Bundle b(String s) {
        f.e(s, "key");
        if(!this.d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle0 = this.c;
        if(bundle0 != null) {
            Bundle bundle1 = bundle0.getBundle(s);
            Bundle bundle2 = this.c;
            if(bundle2 != null) {
                bundle2.remove(s);
            }
            if(this.c == null || this.c.isEmpty()) {
                this.c = null;
            }
            return bundle1;
        }
        return null;
    }

    public final z.c.c c(String s) {
        f.e(s, "key");
        for(Object object0: this.a) {
            f.d(((Map.Entry)object0), "components");
            String s1 = (String)((Map.Entry)object0).getKey();
            z.c.c c$c0 = (z.c.c)((Map.Entry)object0).getValue();
            if(f.a(s1, s)) {
                return c$c0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    // 检测为 Lambda 实现
    private static final void d(c c0, l l0, androidx.lifecycle.h.b h$b0) [...]

    public final void e(h h0) {
        f.e(h0, "lifecycle");
        if(!this.b == 0) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        h0.a((l l0, androidx.lifecycle.h.b h$b0) -> {
            boolean z;
            f.e(this, "this$0");
            f.e(l0, "<anonymous parameter 0>");
            f.e(h$b0, "event");
            if(h$b0 == androidx.lifecycle.h.b.ON_START) {
                z = true;
            }
            else if(h$b0 == androidx.lifecycle.h.b.ON_STOP) {
                z = false;
            }
            else {
                return;
            }
            this.f = z;
        });
        this.b = true;
    }

    public final void f(Bundle bundle0) {
        if(!this.b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if(!this.d == 0) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        this.c = bundle0 == null ? null : bundle0.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        this.d = true;
    }

    public final void g(Bundle bundle0) {
        f.e(bundle0, "outBundle");
        Bundle bundle1 = new Bundle();
        Bundle bundle2 = this.c;
        if(bundle2 != null) {
            bundle1.putAll(bundle2);
        }
        j.b.d b$d0 = this.a.p();
        f.d(b$d0, "this.components.iteratorWithAdditions()");
        while(b$d0.hasNext()) {
            Object object0 = b$d0.next();
            bundle1.putBundle(((String)((Map.Entry)object0).getKey()), ((z.c.c)((Map.Entry)object0).getValue()).a());
        }
        if(!bundle1.isEmpty()) {
            bundle0.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle1);
        }
    }

    public final void h(String s, z.c.c c$c0) {
        f.e(s, "key");
        f.e(c$c0, "provider");
        if(((z.c.c)this.a.s(s, c$c0)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void i(Class class0) {
        androidx.savedstate.Recreator.b recreator$b1;
        f.e(class0, "clazz");
        if(!this.f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        androidx.savedstate.Recreator.b recreator$b0 = this.e == null ? new androidx.savedstate.Recreator.b(this) : this.e;
        try {
            this.e = recreator$b0;
            class0.getDeclaredConstructor();
            recreator$b1 = this.e;
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new IllegalArgumentException("Class " + class0.getSimpleName() + " must have default constructor in order to be automatically recreated", noSuchMethodException0);
        }
        if(recreator$b1 != null) {
            String s = class0.getName();
            f.d(s, "clazz.name");
            recreator$b1.b(s);
        }
    }
}

