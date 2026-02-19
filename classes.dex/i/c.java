package i;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class c extends d {
    class a implements ThreadFactory {
        private final AtomicInteger a;
        final c b;

        a() {
            this.a = new AtomicInteger(0);
        }

        @Override
        public Thread newThread(Runnable runnable0) {
            Thread thread0 = new Thread(runnable0);
            thread0.setName(String.format("arch_disk_io_%d", this.a.getAndIncrement()));
            return thread0;
        }
    }

    private final Object a;
    private final ExecutorService b;
    private volatile Handler c;

    public c() {
        this.a = new Object();
        this.b = Executors.newFixedThreadPool(4, new a(this));
    }

    @Override  // i.d
    public void a(Runnable runnable0) {
        this.b.execute(runnable0);
    }

    @Override  // i.d
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override  // i.d
    public void c(Runnable runnable0) {
        if(this.c == null) {
            Object object0 = this.a;
            synchronized(object0) {
                if(this.c == null) {
                    this.c = c.d(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable0);
    }

    private static Handler d(Looper looper0) {
        if(Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper0);
        }
        try {
            return (Handler)Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper0, null, Boolean.TRUE);
        }
        catch(IllegalAccessException | InstantiationException | NoSuchMethodException unused_ex) {
            return new Handler(looper0);
        }
        catch(InvocationTargetException unused_ex) {
            return new Handler(looper0);
        }
    }
}

