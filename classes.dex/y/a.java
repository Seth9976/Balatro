package y;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.text.format.DateUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class a extends b {
    final class y.a.a extends c implements Runnable {
        boolean j;
        final a k;

        @Override  // y.c
        protected Object b() {
            return a.this.E();
        }

        @Override  // y.c
        protected void g(Object object0) {
            a.this.y(this, object0);
        }

        @Override  // y.c
        protected void h(Object object0) {
            a.this.z(this, object0);
        }

        @Override
        public void run() {
            this.j = false;
            a.this.A();
        }
    }

    private Executor i;
    private volatile y.a.a j;
    private volatile y.a.a k;
    private long l;
    private long m;
    private Handler n;

    public a(Context context0) {
        super(context0);
        this.m = -10000L;
    }

    void A() {
        if(this.k == null && this.j != null) {
            if(this.j.j) {
                this.j.j = false;
                this.n.removeCallbacks(this.j);
            }
            if(this.l > 0L && SystemClock.uptimeMillis() < this.m + this.l) {
                this.j.j = true;
                this.n.postAtTime(this.j, this.m + this.l);
                return;
            }
            if(this.i == null) {
                this.i = this.B();
            }
            this.j.c(this.i);
        }
    }

    protected Executor B() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }

    public abstract Object C();

    public void D(Object object0) {
    }

    protected Object E() {
        return this.C();
    }

    @Override  // y.b
    public void g(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        super.g(s, fileDescriptor0, printWriter0, arr_s);
        if(this.j != null) {
            printWriter0.print(s);
            printWriter0.print("mTask=");
            printWriter0.print(this.j);
            printWriter0.print(" waiting=");
            printWriter0.println(this.j.j);
        }
        if(this.k != null) {
            printWriter0.print(s);
            printWriter0.print("mCancellingTask=");
            printWriter0.print(this.k);
            printWriter0.print(" waiting=");
            printWriter0.println(this.k.j);
        }
        if(this.l != 0L) {
            printWriter0.print(s);
            printWriter0.print("mUpdateThrottle=");
            TimeUnit timeUnit0 = TimeUnit.MILLISECONDS;
            printWriter0.print(DateUtils.formatElapsedTime(timeUnit0.toSeconds(this.l)));
            printWriter0.print(" mLastLoadCompleteTime=");
            printWriter0.print((this.m == -10000L ? "--" : "-" + DateUtils.formatElapsedTime(timeUnit0.toSeconds(SystemClock.uptimeMillis() - this.m))));
            printWriter0.println();
        }
    }

    @Override  // y.b
    protected boolean l() {
        if(this.j != null) {
            if(!this.j()) {
                this.m();
            }
            if(this.k != null) {
                if(this.j.j) {
                    this.j.j = false;
                    this.n.removeCallbacks(this.j);
                }
                this.j = null;
                return false;
            }
            if(this.j.j) {
                this.j.j = false;
                this.n.removeCallbacks(this.j);
                this.j = null;
                return false;
            }
            boolean z = this.j.a(false);
            if(z) {
                this.k = this.j;
            }
            this.j = null;
            return z;
        }
        return false;
    }

    @Override  // y.b
    protected void n() {
        super.n();
        this.b();
        this.j = new y.a.a(this);
        this.A();
    }

    public void x() {
    }

    void y(y.a.a a$a0, Object object0) {
        if(this.k == a$a0) {
            this.t();
            this.m = SystemClock.uptimeMillis();
            this.k = null;
            this.A();
        }
    }

    void z(y.a.a a$a0, Object object0) {
        if(this.j != a$a0) {
            this.y(a$a0, object0);
            return;
        }
        if(!this.i()) {
            this.c();
            this.m = SystemClock.uptimeMillis();
            this.j = null;
            this.f(object0);
        }
    }
}

