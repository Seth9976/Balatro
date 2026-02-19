package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    public interface com.google.android.gms.common.api.internal.a.a {
        void a(boolean arg1);
    }

    private final AtomicBoolean a;
    private final AtomicBoolean b;
    private final ArrayList c;
    private boolean d;
    private static final a e;

    static {
        a.e = new a();
    }

    private a() {
        this.a = new AtomicBoolean();
        this.b = new AtomicBoolean();
        this.c = new ArrayList();
        this.d = false;
    }

    public void a(com.google.android.gms.common.api.internal.a.a a$a0) {
        synchronized(a.e) {
            this.c.add(a$a0);
        }
    }

    public static a b() {
        return a.e;
    }

    public static void c(Application application0) {
        a a0 = a.e;
        synchronized(a0) {
            if(!a0.d) {
                application0.registerActivityLifecycleCallbacks(a0);
                application0.registerComponentCallbacks(a0);
                a0.d = true;
            }
        }
    }

    public boolean d() {
        return this.a.get();
    }

    public boolean e(boolean z) {
        if(!this.b.get()) {
            ActivityManager.RunningAppProcessInfo activityManager$RunningAppProcessInfo0 = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(activityManager$RunningAppProcessInfo0);
            if(!this.b.getAndSet(true) && activityManager$RunningAppProcessInfo0.importance > 100) {
                this.a.set(true);
            }
        }
        return this.d();
    }

    private final void f(boolean z) {
        synchronized(a.e) {
            for(Object object0: this.c) {
                ((com.google.android.gms.common.api.internal.a.a)object0).a(z);
            }
        }
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity0, Bundle bundle0) {
        boolean z = this.a.compareAndSet(true, false);
        this.b.set(true);
        if(z) {
            this.f(false);
        }
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity0) {
        boolean z = this.a.compareAndSet(true, false);
        this.b.set(true);
        if(z) {
            this.f(false);
        }
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity0, Bundle bundle0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity0) {
    }

    @Override  // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration0) {
    }

    @Override  // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override  // android.content.ComponentCallbacks2
    public final void onTrimMemory(int v) {
        if(v == 20 && this.a.compareAndSet(false, true)) {
            this.b.set(true);
            this.f(true);
        }
    }
}

