package androidx.startup;

import a0.c;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import b0.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a {
    final Map a;
    final Set b;
    final Context c;
    private static volatile a d;
    private static final Object e;

    static {
        a.e = new Object();
    }

    a(Context context0) {
        this.c = context0.getApplicationContext();
        this.b = new HashSet();
        this.a = new HashMap();
    }

    void a() {
        try {
            b.a("Startup");
            ComponentName componentName0 = new ComponentName("com.playstack.balatro.android", "androidx.startup.InitializationProvider");
            this.b(this.c.getPackageManager().getProviderInfo(componentName0, 0x80).metaData);
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            throw new c(packageManager$NameNotFoundException0);
        }
        finally {
            b.b();
        }
    }

    void b(Bundle bundle0) {
        String s = this.c.getString(a0.b.a);
        if(bundle0 == null) {
            return;
        }
        else {
            try {
                HashSet hashSet0 = new HashSet();
                for(Object object0: bundle0.keySet()) {
                    String s1 = (String)object0;
                    if(s.equals(bundle0.getString(s1, null))) {
                        Class class0 = Class.forName(s1);
                        if(a0.a.class.isAssignableFrom(class0)) {
                            this.b.add(class0);
                        }
                    }
                }
                for(Object object1: this.b) {
                    this.d(((Class)object1), hashSet0);
                }
                return;
            }
            catch(ClassNotFoundException classNotFoundException0) {
            }
        }
        throw new c(classNotFoundException0);
    }

    Object c(Class class0) {
        synchronized(a.e) {
            Object object1 = this.a.get(class0);
            if(object1 == null) {
                object1 = this.d(class0, new HashSet());
            }
            return object1;
        }
    }

    private Object d(Class class0, Set set0) {
        Object object1;
        boolean z = !b.d();
        try {
            if(!z) {
                b.a(class0.getSimpleName());
            }
            if(!set0.contains(class0)) {
                if(this.a.containsKey(class0)) {
                    object1 = this.a.get(class0);
                }
                else {
                    set0.add(class0);
                    try {
                        a0.a a0 = (a0.a)class0.getDeclaredConstructor().newInstance();
                        List list0 = a0.a();
                        if(!list0.isEmpty()) {
                            for(Object object0: list0) {
                                Class class1 = (Class)object0;
                                if(!this.a.containsKey(class1)) {
                                    this.d(class1, set0);
                                }
                            }
                        }
                        object1 = a0.b(this.c);
                        set0.remove(class0);
                        this.a.put(class0, object1);
                    }
                    catch(Throwable throwable0) {
                        throw new c(throwable0);
                    }
                }
                return object1;
            }
        }
        finally {
            b.b();
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", class0.getName()));
    }

    public static a e(Context context0) {
        if(a.d == null) {
            Object object0 = a.e;
            synchronized(object0) {
                if(a.d == null) {
                    a.d = new a(context0);
                }
                return a.d;
            }
        }
        return a.d;
    }

    public Object f(Class class0) {
        return this.c(class0);
    }

    public boolean g(Class class0) {
        return this.b.contains(class0);
    }
}

