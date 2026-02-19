package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import androidx.core.content.res.h;
import java.io.File;

public abstract class a {
    static abstract class androidx.core.content.a.a {
        static void a(Context context0, Intent[] arr_intent, Bundle bundle0) {
            context0.startActivities(arr_intent, bundle0);
        }

        static void b(Context context0, Intent intent0, Bundle bundle0) {
            context0.startActivity(intent0, bundle0);
        }
    }

    static abstract class b {
        static File a(Context context0) {
            return context0.getCodeCacheDir();
        }

        static Drawable b(Context context0, int v) {
            return context0.getDrawable(v);
        }

        static File c(Context context0) {
            return context0.getNoBackupFilesDir();
        }
    }

    private static final Object a;
    private static final Object b;

    static {
        a.a = new Object();
        a.b = new Object();
    }

    // 去混淆评级： 低(25)
    public static int a(Context context0, String s) {
        androidx.core.util.b.d(s, "permission must be non-null");
        return context0.checkPermission(s, Process.myPid(), Process.myUid());
    }

    public static ColorStateList b(Context context0, int v) {
        return h.c(context0.getResources(), v, context0.getTheme());
    }

    public static Drawable c(Context context0, int v) {
        return b.b(context0, v);
    }

    public static void d(Context context0, Intent intent0, Bundle bundle0) {
        androidx.core.content.a.a.b(context0, intent0, bundle0);
    }
}

