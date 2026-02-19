package c1;

import a2.h;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class p extends h {
    private final Context b;
    final i c;

    public p(i i0, Context context0) {
        this.c = i0;
        super((Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper()));
        this.b = context0.getApplicationContext();
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        int v = message0.what;
        if(v != 1) {
            Log.w("GoogleApiAvailability", "Don\'t know how to handle this message: " + v);
            return;
        }
        int v1 = this.c.f(this.b);
        if(this.c.i(v1)) {
            this.c.n(this.b, v1);
        }
    }
}

