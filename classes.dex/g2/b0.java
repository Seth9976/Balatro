package g2;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import e1.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

final class b0 extends LifecycleCallback {
    private final List b;

    private b0(f f0) {
        super(f0);
        this.b = new ArrayList();
        this.a.b("TaskOnStopCallback", this);
    }

    @Override  // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void k() {
        synchronized(this.b) {
            for(Object object0: this.b) {
                x x0 = (x)((WeakReference)object0).get();
                if(x0 != null) {
                    x0.c();
                }
            }
            this.b.clear();
        }
    }

    public static b0 l(Activity activity0) {
        f f0 = LifecycleCallback.c(activity0);
        synchronized(f0) {
            b0 b00 = (b0)f0.e("TaskOnStopCallback", b0.class);
            if(b00 == null) {
                b00 = new b0(f0);
            }
            return b00;
        }
    }

    public final void m(x x0) {
        synchronized(this.b) {
            WeakReference weakReference0 = new WeakReference(x0);
            this.b.add(weakReference0);
        }
    }
}

