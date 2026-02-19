package x2;

import android.os.Handler;
import android.os.HandlerThread;

public class o0 extends HandlerThread {
    private Handler e;

    public o0(String s) {
        super(s);
    }

    private void a() {
        synchronized(this) {
            if(this.e == null) {
                this.e = new Handler(this.getLooper());
            }
        }
    }

    Handler b() {
        this.a();
        return this.e;
    }

    public void c(Runnable runnable0) {
        this.b().post(runnable0);
    }

    public void d(Runnable runnable0) {
        this.b().postAtFrontOfQueue(runnable0);
    }

    public void e(Runnable runnable0, int v) {
        this.b().postDelayed(runnable0, ((long)v));
    }
}

