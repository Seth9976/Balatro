package com.google.android.gms.dynamite;

import android.content.Context;
import android.util.Log;
import g1.o;
import java.lang.reflect.Field;

public abstract class DynamiteModule {
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;

    }

    public interface a {
        public interface com.google.android.gms.dynamite.DynamiteModule.a.a {
        }

    }

    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;
    public static final a e;
    public static final a f;
    private static final ThreadLocal g;
    private static final ThreadLocal h;
    private static final com.google.android.gms.dynamite.DynamiteModule.a.a i;
    public static final a j;

    static {
        DynamiteModule.g = new ThreadLocal();
        DynamiteModule.h = new com.google.android.gms.dynamite.a();
        DynamiteModule.i = new b();
        DynamiteModule.a = new c();
        DynamiteModule.b = new d();
        DynamiteModule.c = new e();
        DynamiteModule.d = new f();
        DynamiteModule.e = new g();
        DynamiteModule.f = new h();
        DynamiteModule.j = new i();
    }

    public static int a(Context context0, String s) {
        try {
            Class class0 = context0.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + s + ".ModuleDescriptor");
            Field field0 = class0.getDeclaredField("MODULE_ID");
            Field field1 = class0.getDeclaredField("MODULE_VERSION");
            if(!o.a(field0.get(null), s)) {
                Log.e("DynamiteModule", "Module descriptor id \'" + field0.get(null) + "\' didn\'t match expected id \'" + s + "\'");
                return 0;
            }
            return field1.getInt(null);
        }
        catch(ClassNotFoundException unused_ex) {
            Log.w("DynamiteModule", "Local module descriptor class for " + s + " not found.");
            return 0;
        }
        catch(Exception exception0) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: " + exception0.getMessage());
            return 0;
        }
    }
}

