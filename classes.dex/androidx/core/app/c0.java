package androidx.core.app;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public final class c0 {
    private final Context a;
    private final NotificationManager b;
    private static final Object c;
    private static Set d;
    private static final Object e;

    static {
        c0.c = new Object();
        c0.d = new HashSet();
        c0.e = new Object();
    }

    private c0(Context context0) {
        this.a = context0;
        this.b = (NotificationManager)context0.getSystemService("notification");
    }

    public boolean a() {
        if(Build.VERSION.SDK_INT >= 24) {
            return this.b.areNotificationsEnabled();
        }
        AppOpsManager appOpsManager0 = (AppOpsManager)this.a.getSystemService("appops");
        int v = this.a.getApplicationInfo().uid;
        try {
            if(((int)(((Integer)AppOpsManager.class.getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager0, new Object[]{((int)(((Integer)AppOpsManager.class.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)))), v, "com.playstack.balatro.android"})))) != 0) {
                return false;
            }
        }
        catch(ClassNotFoundException | NoSuchMethodException | NoSuchFieldException | InvocationTargetException | IllegalAccessException | RuntimeException unused_ex) {
        }
        return true;
    }

    public static c0 b(Context context0) {
        return new c0(context0);
    }
}

