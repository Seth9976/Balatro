package y;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class c {
    static abstract class d {
        static final int[] a;

        static {
            int[] arr_v = new int[e.values().length];
            d.a = arr_v;
            try {
                arr_v[e.f.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                d.a[e.g.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

    public static enum e {
        PENDING,
        RUNNING,
        FINISHED;

    }

    private final FutureTask e;
    private volatile e f;
    final AtomicBoolean g;
    final AtomicBoolean h;
    private static Handler i;

    c() {
        class a implements Callable {
            final c a;

            @Override
            public Object call() {
                c.this.h.set(true);
                Object object0 = null;
                try {
                    Process.setThreadPriority(10);
                    object0 = c.this.b();
                    Binder.flushPendingCommands();
                }
                catch(Throwable throwable0) {
                    try {
                        c.this.g.set(true);
                        throw throwable0;
                    }
                    catch(Throwable throwable1) {
                        c.this.i(object0);
                        throw throwable1;
                    }
                }
                c.this.i(object0);
                return object0;
            }
        }


        class b extends FutureTask {
            final c e;

            b(Callable callable0) {
                super(callable0);
            }

            @Override
            protected void done() {
                try {
                    Object object0 = this.get();
                    c.this.j(object0);
                }
                catch(InterruptedException interruptedException0) {
                    Log.w("AsyncTask", interruptedException0);
                }
                catch(ExecutionException executionException0) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", executionException0.getCause());
                }
                catch(CancellationException unused_ex) {
                    c.this.j(null);
                }
                catch(Throwable throwable0) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", throwable0);
                }
            }
        }

        this.f = e.e;
        this.g = new AtomicBoolean();
        this.h = new AtomicBoolean();
        this.e = new b(this, new a(this));
    }

    public final boolean a(boolean z) {
        this.g.set(true);
        return this.e.cancel(z);
    }

    protected abstract Object b();

    public final void c(Executor executor0) {
        if(this.f != e.e) {
            switch(this.f) {
                case 1: {
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                }
                case 2: {
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                }
                default: {
                    throw new IllegalStateException("We should never reach this state");
                }
            }
        }
        this.f = e.f;
        executor0.execute(this.e);
    }

    void d(Object object0) {
        if(this.f()) {
            this.g(object0);
        }
        else {
            this.h(object0);
        }
        this.f = e.g;
    }

    private static Handler e() {
        synchronized(c.class) {
            if(c.i == null) {
                c.i = new Handler(Looper.getMainLooper());
            }
            return c.i;
        }
    }

    public final boolean f() {
        return this.g.get();
    }

    protected abstract void g(Object arg1);

    protected abstract void h(Object arg1);

    void i(Object object0) {
        class y.c.c implements Runnable {
            final Object e;
            final c f;

            y.c.c(Object object0) {
                this.e = object0;
                super();
            }

            @Override
            public void run() {
                c.this.d(this.e);
            }
        }

        c.e().post(new y.c.c(this, object0));
    }

    void j(Object object0) {
        if(!this.h.get()) {
            this.i(object0);
        }
    }
}

