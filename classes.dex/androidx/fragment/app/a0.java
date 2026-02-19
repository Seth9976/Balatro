package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.c0;
import androidx.lifecycle.y;
import androidx.lifecycle.z.b;
import androidx.lifecycle.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

final class a0 extends y {
    class a implements b {
        a() {
            super();
        }

        @Override  // androidx.lifecycle.z$b
        public y a(Class class0) {
            return new a0(true);
        }

        @Override  // androidx.lifecycle.z$b
        public y b(Class class0, x.a a0) {
            return androidx.lifecycle.a0.b(this, class0, a0);
        }
    }

    private final HashMap d;
    private final HashMap e;
    private final HashMap f;
    private final boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private static final b k;

    static {
        a0.k = new a();
    }

    a0(boolean z) {
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.h = false;
        this.i = false;
        this.j = false;
        this.g = z;
    }

    @Override  // androidx.lifecycle.y
    protected void d() {
        if(x.G0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.h = true;
    }

    void e(Fragment fragment0) {
        if(this.j) {
            if(x.G0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
            return;
        }
        if(this.d.containsKey(fragment0.f)) {
            return;
        }
        this.d.put(fragment0.f, fragment0);
        if(x.G0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment0);
        }
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return a0.class == class0 && (this.d.equals(((a0)object0).d) && this.e.equals(((a0)object0).e) && this.f.equals(((a0)object0).f));
        }
        return false;
    }

    void f(Fragment fragment0) {
        if(x.G0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment0);
        }
        this.h(fragment0.f);
    }

    void g(String s) {
        if(x.G0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + s);
        }
        this.h(s);
    }

    private void h(String s) {
        a0 a00 = (a0)this.e.get(s);
        if(a00 != null) {
            a00.d();
            this.e.remove(s);
        }
        c0 c00 = (c0)this.f.get(s);
        if(c00 != null) {
            c00.a();
            this.f.remove(s);
        }
    }

    @Override
    public int hashCode() {
        return (this.d.hashCode() * 0x1F + this.e.hashCode()) * 0x1F + this.f.hashCode();
    }

    Fragment i(String s) {
        return (Fragment)this.d.get(s);
    }

    a0 j(Fragment fragment0) {
        a0 a00 = (a0)this.e.get(fragment0.f);
        if(a00 == null) {
            a00 = new a0(this.g);
            this.e.put(fragment0.f, a00);
        }
        return a00;
    }

    static a0 k(c0 c00) {
        return (a0)new z(c00, a0.k).a(a0.class);
    }

    Collection l() {
        return new ArrayList(this.d.values());
    }

    c0 m(Fragment fragment0) {
        c0 c00 = (c0)this.f.get(fragment0.f);
        if(c00 == null) {
            c00 = new c0();
            this.f.put(fragment0.f, c00);
        }
        return c00;
    }

    boolean n() {
        return this.h;
    }

    void o(Fragment fragment0) {
        if(this.j) {
            if(x.G0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
            return;
        }
        if(this.d.remove(fragment0.f) != null && x.G0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment0);
        }
    }

    void p(boolean z) {
        this.j = z;
    }

    boolean q(Fragment fragment0) {
        if(!this.d.containsKey(fragment0.f)) {
            return true;
        }
        return this.g ? this.h : !this.i;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("FragmentManagerViewModel{");
        stringBuilder0.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder0.append("} Fragments (");
        Iterator iterator0 = this.d.values().iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            stringBuilder0.append(object0);
            if(iterator0.hasNext()) {
                stringBuilder0.append(", ");
            }
        }
        stringBuilder0.append(") Child Non Config (");
        Iterator iterator1 = this.e.keySet().iterator();
        while(iterator1.hasNext()) {
            Object object1 = iterator1.next();
            stringBuilder0.append(((String)object1));
            if(iterator1.hasNext()) {
                stringBuilder0.append(", ");
            }
        }
        stringBuilder0.append(") ViewModelStores (");
        Iterator iterator2 = this.f.keySet().iterator();
        while(iterator2.hasNext()) {
            Object object2 = iterator2.next();
            stringBuilder0.append(((String)object2));
            if(iterator2.hasNext()) {
                stringBuilder0.append(", ");
            }
        }
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

