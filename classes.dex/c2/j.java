package c2;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application;
import android.os.Bundle;
import java.util.Objects;

final class j implements Application.ActivityLifecycleCallbacks {
    private final Application a;
    private boolean b;
    private boolean c;
    final k d;

    j(k k0, Application application0, i i0) {
        this.d = k0;
        super();
        this.b = false;
        this.a = application0;
    }

    static void a(j j0) {
        if(j0.b) {
            return;
        }
        j0.a.registerActivityLifecycleCallbacks(j0);
        j0.b = true;
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity0, Bundle bundle0) {
        String s = activity0.getComponentName().getClassName();
        if(this.c) {
            if(!Objects.equals(s, "com.epicgames.unreal.GameActivity")) {
                return;
            }
        }
        else if(Objects.equals(s, "com.epicgames.unreal.SplashActivity") && l.c.a(activity0)) {
            this.c = true;
            return;
        }
        this.a.unregisterActivityLifecycleCallbacks(this);
        if(!this.b) {
            return;
        }
        this.b = false;
        f1.a("AutomaticGamesAuthenticator", "Automatic connection attempt triggered");
        this.d.b.a();
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity0) {
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
}

