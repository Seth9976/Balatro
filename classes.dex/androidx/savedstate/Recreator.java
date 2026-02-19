package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import k3.d;
import k3.f;
import z.c.c;
import z.e;

public final class Recreator implements j {
    public static final class a {
        private a() {
        }

        public a(d d0) {
        }
    }

    public static final class b implements c {
        private final Set a;

        public b(z.c c0) {
            f.e(c0, "registry");
            super();
            this.a = new LinkedHashSet();
            c0.h("androidx.savedstate.Restarter", this);
        }

        @Override  // z.c$c
        public Bundle a() {
            Bundle bundle0 = new Bundle();
            bundle0.putStringArrayList("classes_to_restore", new ArrayList(this.a));
            return bundle0;
        }

        public final void b(String s) {
            f.e(s, "className");
            this.a.add(s);
        }
    }

    private final e a;
    public static final a b;

    static {
        Recreator.b = new a(null);
    }

    public Recreator(e e0) {
        f.e(e0, "owner");
        super();
        this.a = e0;
    }

    @Override  // androidx.lifecycle.j
    public void d(l l0, androidx.lifecycle.h.b h$b0) {
        f.e(l0, "source");
        f.e(h$b0, "event");
        if(h$b0 != androidx.lifecycle.h.b.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        l0.o().c(this);
        Bundle bundle0 = this.a.d().b("androidx.savedstate.Restarter");
        if(bundle0 == null) {
            return;
        }
        ArrayList arrayList0 = bundle0.getStringArrayList("classes_to_restore");
        if(arrayList0 == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        for(Object object0: arrayList0) {
            this.h(((String)object0));
        }
    }

    private final void h(String s) {
        z.c.a c$a0;
        Constructor constructor0;
        Class class0;
        try {
            class0 = Class.forName(s, false, Recreator.class.getClassLoader()).asSubclass(z.c.a.class);
            f.d(class0, "{\n                Class.…class.java)\n            }");
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw new RuntimeException("Class " + s + " wasn\'t found", classNotFoundException0);
        }
        try {
            constructor0 = class0.getDeclaredConstructor();
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new IllegalStateException("Class " + class0.getSimpleName() + " must have default constructor in order to be automatically recreated", noSuchMethodException0);
        }
        constructor0.setAccessible(true);
        try {
            Object object0 = constructor0.newInstance();
            f.d(object0, "{\n                constr…wInstance()\n            }");
            c$a0 = (z.c.a)object0;
        }
        catch(Exception exception0) {
            throw new RuntimeException("Failed to instantiate " + s, exception0);
        }
        c$a0.a(this.a);
    }
}

