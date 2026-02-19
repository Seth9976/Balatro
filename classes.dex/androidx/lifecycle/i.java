package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class i {
    static class a extends d {
        @Override  // androidx.lifecycle.d
        public void onActivityCreated(Activity activity0, Bundle bundle0) {
            u.g(activity0);
        }

        @Override  // androidx.lifecycle.d
        public void onActivitySaveInstanceState(Activity activity0, Bundle bundle0) {
        }

        @Override  // androidx.lifecycle.d
        public void onActivityStopped(Activity activity0) {
        }
    }

    private static AtomicBoolean a;

    static {
        i.a = new AtomicBoolean(false);
    }

    static void a(Context context0) {
        if(i.a.getAndSet(true)) {
            return;
        }
        ((Application)context0.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
    }
}

