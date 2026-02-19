package x1;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import g1.q;
import g2.h;
import g2.i;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import l1.d;
import w0.b;
import w0.c;

public final class l implements b {
    private final Context a;
    private boolean b;
    private final ScheduledExecutorService c;
    private final ExecutorService d;
    private static b e;

    static {
    }

    l(Context context0) {
        this.b = false;
        ScheduledExecutorService scheduledExecutorService0 = Executors.newSingleThreadScheduledExecutor();
        this.c = scheduledExecutorService0;
        this.d = Executors.newSingleThreadExecutor();
        this.a = context0;
        if(!this.b) {
            scheduledExecutorService0.scheduleAtFixedRate(new j(this, null), 0L, 86400L, TimeUnit.SECONDS);
            this.b = true;
        }
    }

    protected final long a() {
        long v = l.g(this.a).getLong("app_set_id_last_used_time", -1L);
        return v == -1L ? -1L : v + 33696000000L;
    }

    @Override  // w0.b
    public final h b() {
        i i0 = new i();
        x1.h h0 = () -> {
            String s = l.g(this.a).getString("app_set_id", null);
            long v = this.a();
            if(s == null || d.b().a() > v) {
                try {
                    s = "2e260a21-52cf-41f1-a014-ddcf4db5e469";
                    Context context0 = this.a;
                    if(!l.g(context0).edit().putString("app_set_id", "2e260a21-52cf-41f1-a014-ddcf4db5e469").commit()) {
                        Log.e("AppSet", "Failed to store app set ID generated for App com.playstack.balatro.android");
                        throw new k("Failed to store the app set ID.");
                    }
                    l.h(context0);
                    SharedPreferences sharedPreferences0 = l.g(this.a);
                    long v1 = d.b().a();
                    if(!sharedPreferences0.edit().putLong("app_set_id_creation_time", v1).commit()) {
                        Log.e("AppSet", "Failed to store app set ID creation time for App com.playstack.balatro.android");
                        throw new k("Failed to store the app set ID creation time.");
                    }
                }
                catch(k k1) {
                    i0.b(k1);
                    return;
                }
            }
            else {
                try {
                    l.h(this.a);
                }
                catch(k k0) {
                    i0.b(k0);
                    return;
                }
            }
            i0.c(new c(s, 1));
        };
        this.d.execute(h0);
        return i0.a();
    }

    static b d(Context context0) {
        synchronized(l.class) {
            q.j(context0, "Context must not be null");
            if(l.e == null) {
                l.e = new l(context0.getApplicationContext());
            }
            return l.e;
        }
    }

    // 检测为 Lambda 实现
    final void e(i i0) [...]

    protected static final void f(Context context0) {
        if(!l.g(context0).edit().remove("app_set_id").commit()) {
            Log.e("AppSet", "Failed to clear app set ID generated for App com.playstack.balatro.android");
        }
        if(!l.g(context0).edit().remove("app_set_id_last_used_time").commit()) {
            Log.e("AppSet", "Failed to clear app set ID last used time for App com.playstack.balatro.android");
        }
    }

    private static final SharedPreferences g(Context context0) {
        return context0.getSharedPreferences("app_set_id_storage", 0);
    }

    private static final void h(Context context0) {
        SharedPreferences sharedPreferences0 = l.g(context0);
        long v = d.b().a();
        if(!sharedPreferences0.edit().putLong("app_set_id_last_used_time", v).commit()) {
            Log.e("AppSet", "Failed to store app set ID last used time for App com.playstack.balatro.android");
            throw new k("Failed to store the app set ID last used time.");
        }
    }
}

