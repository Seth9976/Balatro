package k1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import g1.o1;
import g1.q;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import m1.d;

public class b {
    public final ConcurrentHashMap a;
    private static final Object b;
    private static volatile b c;

    static {
        b.b = new Object();
    }

    private b() {
        this.a = new ConcurrentHashMap();
    }

    public static b a() {
        if(b.c == null) {
            Object object0 = b.b;
            synchronized(object0) {
                if(b.c == null) {
                    b.c = new b();
                }
            }
        }
        b b0 = b.c;
        q.i(b0);
        return b0;
    }

    public void b(Context context0, ServiceConnection serviceConnection0) {
        if(b.f(serviceConnection0) && this.a.containsKey(serviceConnection0)) {
            try {
                b.d(context0, ((ServiceConnection)this.a.get(serviceConnection0)));
            }
            finally {
                this.a.remove(serviceConnection0);
            }
            return;
        }
        b.d(context0, serviceConnection0);
    }

    public final boolean c(Context context0, String s, Intent intent0, ServiceConnection serviceConnection0, int v, Executor executor0) {
        return this.e(context0, s, intent0, serviceConnection0, 0x1081, true, executor0);
    }

    private static void d(Context context0, ServiceConnection serviceConnection0) {
        try {
            context0.unbindService(serviceConnection0);
        }
        catch(IllegalArgumentException | IllegalStateException | NoSuchElementException unused_ex) {
        }
    }

    private final boolean e(Context context0, String s, Intent intent0, ServiceConnection serviceConnection0, int v, boolean z, Executor executor0) {
        ComponentName componentName0 = intent0.getComponent();
        if(componentName0 != null) {
            String s1 = componentName0.getPackageName();
            "com.google.android.gms".equals(s1);
            try {
                if((d.a(context0).a(s1, 0).flags & 0x200000) != 0) {
                    goto label_5;
                }
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
            }
            goto label_7;
        label_5:
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
    label_7:
        if(b.f(serviceConnection0)) {
            ServiceConnection serviceConnection1 = (ServiceConnection)this.a.putIfAbsent(serviceConnection0, serviceConnection0);
            if(serviceConnection1 != null && serviceConnection0 != serviceConnection1) {
                Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection0, s, intent0.getAction()));
            }
            try {
                if(!b.g(context0, intent0, serviceConnection0, v, executor0)) {
                    goto label_16;
                }
                return true;
            }
            catch(Throwable throwable0) {
                this.a.remove(serviceConnection0, serviceConnection0);
                throw throwable0;
            }
        label_16:
            this.a.remove(serviceConnection0, serviceConnection0);
            return false;
        }
        return b.g(context0, intent0, serviceConnection0, v, executor0);
    }

    private static boolean f(ServiceConnection serviceConnection0) {
        return !(serviceConnection0 instanceof o1);
    }

    private static final boolean g(Context context0, Intent intent0, ServiceConnection serviceConnection0, int v, Executor executor0) {
        if(executor0 == null) {
            executor0 = null;
        }
        return executor0 == null ? context0.bindService(intent0, serviceConnection0, v) : context0.bindService(intent0, v, executor0, serviceConnection0);
    }
}

