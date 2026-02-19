package androidx.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build.VERSION;
import android.os.Bundle;

public class u extends Fragment {
    interface a {
        void a();

        void b();

        void c();
    }

    static class b implements Application.ActivityLifecycleCallbacks {
        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity0, Bundle bundle0) {
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity0) {
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity0) {
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity0, Bundle bundle0) {
            u.a(activity0, androidx.lifecycle.h.b.ON_CREATE);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity0) {
            u.a(activity0, androidx.lifecycle.h.b.ON_RESUME);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity0) {
            u.a(activity0, androidx.lifecycle.h.b.ON_START);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity0) {
            u.a(activity0, androidx.lifecycle.h.b.ON_DESTROY);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity0) {
            u.a(activity0, androidx.lifecycle.h.b.ON_PAUSE);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity0) {
            u.a(activity0, androidx.lifecycle.h.b.ON_STOP);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity0) {
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity0, Bundle bundle0) {
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity0) {
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity0) {
        }

        static void registerIn(Activity activity0) {
            activity0.registerActivityLifecycleCallbacks(new b());
        }
    }

    private a a;

    static void a(Activity activity0, androidx.lifecycle.h.b h$b0) {
        if(activity0 instanceof l) {
            h h0 = ((l)activity0).o();
            if(h0 instanceof m) {
                ((m)h0).h(h$b0);
            }
        }
    }

    private void b(androidx.lifecycle.h.b h$b0) {
        if(Build.VERSION.SDK_INT < 29) {
            u.a(this.getActivity(), h$b0);
        }
    }

    private void c(a u$a0) {
        if(u$a0 != null) {
            u$a0.a();
        }
    }

    private void d(a u$a0) {
        if(u$a0 != null) {
            u$a0.b();
        }
    }

    private void e(a u$a0) {
        if(u$a0 != null) {
            u$a0.c();
        }
    }

    static u f(Activity activity0) {
        return (u)activity0.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public static void g(Activity activity0) {
        if(Build.VERSION.SDK_INT >= 29) {
            b.registerIn(activity0);
        }
        FragmentManager fragmentManager0 = activity0.getFragmentManager();
        if(fragmentManager0.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager0.beginTransaction().add(new u(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager0.executePendingTransactions();
        }
    }

    void h(a u$a0) {
        this.a = u$a0;
    }

    @Override  // android.app.Fragment
    public void onActivityCreated(Bundle bundle0) {
        super.onActivityCreated(bundle0);
        this.c(this.a);
        this.b(androidx.lifecycle.h.b.ON_CREATE);
    }

    @Override  // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.b(androidx.lifecycle.h.b.ON_DESTROY);
        this.a = null;
    }

    @Override  // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.b(androidx.lifecycle.h.b.ON_PAUSE);
    }

    @Override  // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.d(this.a);
        this.b(androidx.lifecycle.h.b.ON_RESUME);
    }

    @Override  // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.e(this.a);
        this.b(androidx.lifecycle.h.b.ON_START);
    }

    @Override  // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.b(androidx.lifecycle.h.b.ON_STOP);
    }
}

