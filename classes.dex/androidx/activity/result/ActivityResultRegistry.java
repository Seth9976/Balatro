package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import b.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class ActivityResultRegistry {
    static class c {
        final b a;
        final a b;

        c(b b0, a a0) {
            this.a = b0;
            this.b = a0;
        }
    }

    static class d {
        final h a;
        private final ArrayList b;

        d(h h0) {
            this.a = h0;
            this.b = new ArrayList();
        }

        void a(j j0) {
            this.a.a(j0);
            this.b.add(j0);
        }

        void b() {
            for(Object object0: this.b) {
                this.a.c(((j)object0));
            }
            this.b.clear();
        }
    }

    private Random a;
    private final Map b;
    final Map c;
    private final Map d;
    ArrayList e;
    final transient Map f;
    final Map g;
    final Bundle h;

    public ActivityResultRegistry() {
        this.a = new Random();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new ArrayList();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new Bundle();
    }

    private void a(int v, String s) {
        this.b.put(v, s);
        this.c.put(s, v);
    }

    public final boolean b(int v, int v1, Intent intent0) {
        String s = (String)this.b.get(v);
        if(s == null) {
            return false;
        }
        this.d(s, v1, intent0, ((c)this.f.get(s)));
        return true;
    }

    public final boolean c(int v, Object object0) {
        String s = (String)this.b.get(v);
        if(s == null) {
            return false;
        }
        c activityResultRegistry$c0 = (c)this.f.get(s);
        if(activityResultRegistry$c0 == null) {
            this.h.remove(s);
            this.g.put(s, object0);
        }
        else {
            b b0 = activityResultRegistry$c0.a;
            if(b0 == null) {
                this.h.remove(s);
                this.g.put(s, object0);
                return true;
            }
            else if(this.e.remove(s)) {
                b0.a(object0);
                return true;
            }
        }
        return true;
    }

    private void d(String s, int v, Intent intent0, c activityResultRegistry$c0) {
        if(activityResultRegistry$c0 != null && activityResultRegistry$c0.a != null && this.e.contains(s)) {
            Object object0 = activityResultRegistry$c0.b.c(v, intent0);
            activityResultRegistry$c0.a.a(object0);
            this.e.remove(s);
            return;
        }
        this.g.remove(s);
        androidx.activity.result.a a0 = new androidx.activity.result.a(v, intent0);
        this.h.putParcelable(s, a0);
    }

    private int e() {
        int v;
        for(v = this.a.nextInt(0x7FFF0000); this.b.containsKey(((int)(v + 0x10000))); v = this.a.nextInt(0x7FFF0000)) {
        }
        return v + 0x10000;
    }

    public abstract void f(int arg1, a arg2, Object arg3, androidx.core.app.b arg4);

    public final void g(Bundle bundle0) {
        if(bundle0 == null) {
            return;
        }
        ArrayList arrayList0 = bundle0.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList arrayList1 = bundle0.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if(arrayList1 != null && arrayList0 != null) {
            this.e = bundle0.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            this.a = (Random)bundle0.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
            Bundle bundle1 = bundle0.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
            this.h.putAll(bundle1);
            for(int v = 0; v < arrayList1.size(); ++v) {
                String s = (String)arrayList1.get(v);
                if(this.c.containsKey(s)) {
                    Integer integer0 = (Integer)this.c.remove(s);
                    if(!this.h.containsKey(s)) {
                        this.b.remove(integer0);
                    }
                }
                this.a(((int)(((Integer)arrayList0.get(v)))), ((String)arrayList1.get(v)));
            }
        }
    }

    public final void h(Bundle bundle0) {
        bundle0.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.c.values()));
        bundle0.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.c.keySet()));
        bundle0.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(this.e));
        bundle0.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", ((Bundle)this.h.clone()));
        bundle0.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.a);
    }

    public final androidx.activity.result.c i(String s, l l0, a a0, b b0) {
        class androidx.activity.result.ActivityResultRegistry.a extends androidx.activity.result.c {
            final String a;
            final a b;
            final ActivityResultRegistry c;

            androidx.activity.result.ActivityResultRegistry.a(String s, a a0) {
                this.a = s;
                this.b = a0;
                super();
            }

            @Override  // androidx.activity.result.c
            public void b(Object object0, androidx.core.app.b b0) {
                Integer integer0 = (Integer)ActivityResultRegistry.this.c.get(this.a);
                if(integer0 != null) {
                    ActivityResultRegistry.this.e.add(this.a);
                    try {
                        ActivityResultRegistry.this.f(((int)integer0), this.b, object0, b0);
                        return;
                    }
                    catch(Exception exception0) {
                        ActivityResultRegistry.this.e.remove(this.a);
                        throw exception0;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.b + " and input " + object0 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            }

            @Override  // androidx.activity.result.c
            public void c() {
                ActivityResultRegistry.this.l(this.a);
            }
        }

        h h0 = l0.o();
        if(h0.b().c(androidx.lifecycle.h.c.h)) {
            throw new IllegalStateException("LifecycleOwner " + l0 + " is attempting to register while current state is " + h0.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        this.k(s);
        d activityResultRegistry$d0 = (d)this.d.get(s);
        if(activityResultRegistry$d0 == null) {
            activityResultRegistry$d0 = new d(h0);
        }
        activityResultRegistry$d0.a(new j() {
            final ActivityResultRegistry d;

            @Override  // androidx.lifecycle.j
            public void d(l l0, androidx.lifecycle.h.b h$b0) {
                if(androidx.lifecycle.h.b.ON_START.equals(h$b0)) {
                    c activityResultRegistry$c0 = new c(b0, a0);
                    ActivityResultRegistry.this.f.put(s, activityResultRegistry$c0);
                    if(ActivityResultRegistry.this.g.containsKey(s)) {
                        Object object0 = ActivityResultRegistry.this.g.get(s);
                        ActivityResultRegistry.this.g.remove(s);
                        b0.a(object0);
                    }
                    androidx.activity.result.a a0 = (androidx.activity.result.a)ActivityResultRegistry.this.h.getParcelable(s);
                    if(a0 != null) {
                        ActivityResultRegistry.this.h.remove(s);
                        Object object1 = a0.c(a0.s(), a0.o());
                        b0.a(object1);
                    }
                }
                else {
                    if(androidx.lifecycle.h.b.ON_STOP.equals(h$b0)) {
                        ActivityResultRegistry.this.f.remove(s);
                        return;
                    }
                    if(androidx.lifecycle.h.b.ON_DESTROY.equals(h$b0)) {
                        ActivityResultRegistry.this.l(s);
                    }
                }
            }
        });
        this.d.put(s, activityResultRegistry$d0);
        return new androidx.activity.result.ActivityResultRegistry.a(this, s, a0);
    }

    public final androidx.activity.result.c j(String s, a a0, b b0) {
        class androidx.activity.result.ActivityResultRegistry.b extends androidx.activity.result.c {
            final String a;
            final a b;
            final ActivityResultRegistry c;

            androidx.activity.result.ActivityResultRegistry.b(String s, a a0) {
                this.a = s;
                this.b = a0;
                super();
            }

            @Override  // androidx.activity.result.c
            public void b(Object object0, androidx.core.app.b b0) {
                Integer integer0 = (Integer)ActivityResultRegistry.this.c.get(this.a);
                if(integer0 != null) {
                    ActivityResultRegistry.this.e.add(this.a);
                    try {
                        ActivityResultRegistry.this.f(((int)integer0), this.b, object0, b0);
                        return;
                    }
                    catch(Exception exception0) {
                        ActivityResultRegistry.this.e.remove(this.a);
                        throw exception0;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.b + " and input " + object0 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            }

            @Override  // androidx.activity.result.c
            public void c() {
                ActivityResultRegistry.this.l(this.a);
            }
        }

        this.k(s);
        c activityResultRegistry$c0 = new c(b0, a0);
        this.f.put(s, activityResultRegistry$c0);
        if(this.g.containsKey(s)) {
            Object object0 = this.g.get(s);
            this.g.remove(s);
            b0.a(object0);
        }
        androidx.activity.result.a a1 = (androidx.activity.result.a)this.h.getParcelable(s);
        if(a1 != null) {
            this.h.remove(s);
            b0.a(a0.c(a1.s(), a1.o()));
        }
        return new androidx.activity.result.ActivityResultRegistry.b(this, s, a0);
    }

    private void k(String s) {
        if(((Integer)this.c.get(s)) != null) {
            return;
        }
        this.a(this.e(), s);
    }

    final void l(String s) {
        if(!this.e.contains(s)) {
            Integer integer0 = (Integer)this.c.remove(s);
            if(integer0 != null) {
                this.b.remove(integer0);
            }
        }
        this.f.remove(s);
        if(this.g.containsKey(s)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + s + ": " + this.g.get(s));
            this.g.remove(s);
        }
        if(this.h.containsKey(s)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + s + ": " + this.h.getParcelable(s));
            this.h.remove(s);
        }
        d activityResultRegistry$d0 = (d)this.d.get(s);
        if(activityResultRegistry$d0 != null) {
            activityResultRegistry$d0.b();
            this.d.remove(s);
        }
    }
}

