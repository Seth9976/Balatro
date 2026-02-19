package androidx.emoji2.text;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

abstract class b {
    static abstract class a {
        public static Handler a(Looper looper0) {
            return Handler.createAsync(looper0);
        }
    }

    static ThreadPoolExecutor b(String s) {
        androidx.emoji2.text.a a0 = (Runnable runnable0) -> {
            Thread thread0 = new Thread(runnable0, s);
            thread0.setPriority(10);
            return thread0;
        };
        ThreadPoolExecutor threadPoolExecutor0 = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), a0);
        threadPoolExecutor0.allowCoreThreadTimeOut(true);
        return threadPoolExecutor0;
    }

    // 检测为 Lambda 实现
    private static Thread c(String s, Runnable runnable0) [...]

    static Handler d() {
        return Build.VERSION.SDK_INT < 28 ? new Handler(Looper.getMainLooper()) : a.a(Looper.getMainLooper());
    }
}

