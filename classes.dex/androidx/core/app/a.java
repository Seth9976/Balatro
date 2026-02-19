package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;

public abstract class a extends androidx.core.content.a {
    static abstract class androidx.core.app.a.a {
        static void a(Activity activity0) {
            activity0.finishAffinity();
        }

        static void b(Activity activity0, Intent intent0, int v, Bundle bundle0) {
            activity0.startActivityForResult(intent0, v, bundle0);
        }

        static void c(Activity activity0, IntentSender intentSender0, int v, Intent intent0, int v1, int v2, int v3, Bundle bundle0) {
            activity0.startIntentSenderForResult(intentSender0, v, intent0, v1, v2, v3, bundle0);
        }
    }

    static abstract class b {
        static void a(Object object0) {
            ((SharedElementCallback.OnSharedElementsReadyListener)object0).onSharedElementsReady();
        }

        static void b(Activity activity0, String[] arr_s, int v) {
            activity0.requestPermissions(arr_s, v);
        }

        static boolean c(Activity activity0, String s) {
            return activity0.shouldShowRequestPermissionRationale(s);
        }
    }

    public interface c {
        void b(int arg1);
    }

    public static void e(Activity activity0, String[] arr_s, int v) {
        HashSet hashSet0 = new HashSet();
        for(int v2 = 0; v2 < arr_s.length; ++v2) {
            if(TextUtils.isEmpty(arr_s[v2])) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(arr_s) + " must not contain null or empty values");
            }
        }
        int v3 = hashSet0.size();
        String[] arr_s1 = v3 <= 0 ? arr_s : new String[arr_s.length - v3];
        if(v3 > 0) {
            if(v3 == arr_s.length) {
                return;
            }
            int v4 = 0;
            for(int v1 = 0; v1 < arr_s.length; ++v1) {
                if(!hashSet0.contains(v1)) {
                    arr_s1[v4] = arr_s[v1];
                    ++v4;
                }
            }
        }
        if(activity0 instanceof c) {
            ((c)activity0).b(v);
        }
        b.b(activity0, arr_s, v);
    }

    // 去混淆评级： 低(40)
    public static boolean f(Activity activity0, String s) {
        return b.c(activity0, s);
    }

    public static void g(Activity activity0, Intent intent0, int v, Bundle bundle0) {
        androidx.core.app.a.a.b(activity0, intent0, v, bundle0);
    }

    public static void h(Activity activity0, IntentSender intentSender0, int v, Intent intent0, int v1, int v2, int v3, Bundle bundle0) {
        androidx.core.app.a.a.c(activity0, intentSender0, v, intent0, v1, v2, v3, bundle0);
    }
}

