package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.h.c;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class f0 {
    static final class a {
        int a;
        Fragment b;
        boolean c;
        int d;
        int e;
        int f;
        int g;
        c h;
        c i;

        a() {
        }

        a(int v, Fragment fragment0) {
            this.a = v;
            this.b = fragment0;
            this.c = false;
            this.h = c.i;
            this.i = c.i;
        }

        a(int v, Fragment fragment0, boolean z) {
            this.a = v;
            this.b = fragment0;
            this.c = z;
            this.h = c.i;
            this.i = c.i;
        }
    }

    private final o a;
    private final ClassLoader b;
    ArrayList c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    boolean j;
    String k;
    int l;
    CharSequence m;
    int n;
    CharSequence o;
    ArrayList p;
    ArrayList q;
    boolean r;
    ArrayList s;

    f0(o o0, ClassLoader classLoader0) {
        this.c = new ArrayList();
        this.j = true;
        this.r = false;
        this.a = o0;
        this.b = classLoader0;
    }

    public f0 b(int v, Fragment fragment0, String s) {
        this.k(v, fragment0, s, 1);
        return this;
    }

    f0 c(ViewGroup viewGroup0, Fragment fragment0, String s) {
        fragment0.H = viewGroup0;
        return this.b(viewGroup0.getId(), fragment0, s);
    }

    public f0 d(Fragment fragment0, String s) {
        this.k(0, fragment0, s, 1);
        return this;
    }

    void e(a f0$a0) {
        this.c.add(f0$a0);
        f0$a0.d = this.d;
        f0$a0.e = this.e;
        f0$a0.f = this.f;
        f0$a0.g = this.g;
    }

    public abstract int f();

    public abstract int g();

    public abstract void h();

    public abstract void i();

    public f0 j() {
        if(this.i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.j = false;
        return this;
    }

    void k(int v, Fragment fragment0, String s, int v1) {
        String s1 = fragment0.R;
        if(s1 != null) {
            v.c.f(fragment0, s1);
        }
        Class class0 = fragment0.getClass();
        int v2 = class0.getModifiers();
        if(class0.isAnonymousClass() || !Modifier.isPublic(v2) || class0.isMemberClass() && !Modifier.isStatic(v2)) {
            throw new IllegalStateException("Fragment " + class0.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if(s != null) {
            if(fragment0.z != null && !s.equals(fragment0.z)) {
                throw new IllegalStateException("Can\'t change tag of fragment " + fragment0 + ": was " + fragment0.z + " now " + s);
            }
            fragment0.z = s;
        }
        switch(v) {
            case -1: {
                throw new IllegalArgumentException("Can\'t add fragment " + fragment0 + " with tag " + s + " to container view with no id");
            label_13:
                if(fragment0.x != 0 && fragment0.x != v) {
                    throw new IllegalStateException("Can\'t change container ID of fragment " + fragment0 + ": was " + fragment0.x + " now " + v);
                }
                fragment0.x = v;
                fragment0.y = v;
                break;
            }
            case 0: {
                break;
            }
            default: {
                goto label_13;
            }
        }
        this.e(new a(v1, fragment0));
    }

    public f0 l(Fragment fragment0) {
        this.e(new a(3, fragment0));
        return this;
    }

    public f0 m(boolean z) {
        this.r = z;
        return this;
    }
}

