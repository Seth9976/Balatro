package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import androidx.core.content.a;
import androidx.core.util.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class p extends l {
    private final Activity a;
    private final Context b;
    private final Handler c;
    private final int d;
    final x e;

    p(Activity activity0, Context context0, Handler handler0, int v) {
        this.e = new y();
        this.a = activity0;
        this.b = (Context)c.e(context0, "context == null");
        this.c = (Handler)c.e(handler0, "handler == null");
        this.d = v;
    }

    p(j j0) {
        this(j0, j0, new Handler(), 0);
    }

    public abstract void A();

    Activity t() {
        return this.a;
    }

    Context u() {
        return this.b;
    }

    public Handler v() {
        return this.c;
    }

    public abstract void w(String arg1, FileDescriptor arg2, PrintWriter arg3, String[] arg4);

    public abstract Object x();

    public abstract LayoutInflater y();

    public void z(Fragment fragment0, Intent intent0, int v, Bundle bundle0) {
        if(v != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        a.d(this.b, intent0, bundle0);
    }
}

