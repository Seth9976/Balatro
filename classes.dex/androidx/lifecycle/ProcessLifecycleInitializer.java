package androidx.lifecycle;

import a0.a;
import android.content.Context;
import java.util.Collections;
import java.util.List;

public final class ProcessLifecycleInitializer implements a {
    @Override  // a0.a
    public List a() {
        return Collections.emptyList();
    }

    @Override  // a0.a
    public Object b(Context context0) {
        return this.c(context0);
    }

    public l c(Context context0) {
        if(!androidx.startup.a.e(context0).g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name=\'androidx.lifecycle.ProcessLifecycleInitializer\' \n    android:value=\'androidx.startup\' /> \nunder InitializationProvider in your AndroidManifest.xml");
        }
        i.a(context0);
        s.k(context0);
        return s.j();
    }
}

