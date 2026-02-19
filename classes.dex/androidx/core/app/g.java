package androidx.core.app;

import android.app.Notification.Builder;
import android.content.Context;

public abstract class g {
    public static Notification.Builder a(Context context0, String s) {
        return new Notification.Builder(context0, s);
    }
}

