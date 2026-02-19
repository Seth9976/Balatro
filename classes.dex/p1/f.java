package p1;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import d1.c;

public abstract class f extends c {
    @Override  // d1.c
    public static String a(int v) [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public static Status b(int v) {
        return new Status(4, "SIGN_IN_REQUIRED");
    }

    public static Status c(int v, PendingIntent pendingIntent0) {
        return new Status(v, f.a(v), pendingIntent0);
    }
}

