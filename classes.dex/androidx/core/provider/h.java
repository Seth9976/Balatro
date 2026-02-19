package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

abstract class h {
    static class a implements ThreadFactory {
        static class androidx.core.provider.h.a.a extends Thread {
            private final int e;

            androidx.core.provider.h.a.a(Runnable runnable0, String s, int v) {
                super(runnable0, s);
                this.e = v;
            }

            @Override
            public void run() {
                Process.setThreadPriority(this.e);
                super.run();
            }
        }

        private String a;
        private int b;

        a(String s, int v) {
            this.a = s;
            this.b = v;
        }

        @Override
        public Thread newThread(Runnable runnable0) {
            return new androidx.core.provider.h.a.a(runnable0, this.a, this.b);
        }
    }

    static class b implements Runnable {
        private Callable e;
        private androidx.core.util.a f;
        private Handler g;

        b(Handler handler0, Callable callable0, androidx.core.util.a a0) {
            this.e = callable0;
            this.f = a0;
            this.g = handler0;
        }

        @Override
        public void run() {
            class androidx.core.provider.h.b.a implements Runnable {
                final androidx.core.util.a e;
                final Object f;
                final b g;

                androidx.core.provider.h.b.a(androidx.core.util.a a0, Object object0) {
                    this.e = a0;
                    this.f = object0;
                    super();
                }

                @Override
                public void run() {
                    this.e.accept(this.f);
                }
            }

            Object object0 = null;
            try {
                object0 = this.e.call();
            }
            catch(Exception unused_ex) {
            }
            this.g.post(new androidx.core.provider.h.b.a(this, this.f, object0));
        }
    }

    static ThreadPoolExecutor a(String s, int v, int v1) {
        a h$a0 = new a(s, v);
        ThreadPoolExecutor threadPoolExecutor0 = new ThreadPoolExecutor(0, 1, ((long)v1), TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), h$a0);
        threadPoolExecutor0.allowCoreThreadTimeOut(true);
        return threadPoolExecutor0;
    }

    static void b(Executor executor0, Callable callable0, androidx.core.util.a a0) {
        executor0.execute(new b(androidx.core.provider.b.a(), callable0, a0));
    }

    static Object c(ExecutorService executorService0, Callable callable0, int v) {
        Future future0 = executorService0.submit(callable0);
        try {
            return future0.get(((long)v), TimeUnit.MILLISECONDS);
        }
        catch(ExecutionException executionException0) {
            throw new RuntimeException(executionException0);
        }
        catch(InterruptedException interruptedException0) {
            throw interruptedException0;
        }
        catch(TimeoutException unused_ex) {
            throw new InterruptedException("timeout");
        }
    }
}

