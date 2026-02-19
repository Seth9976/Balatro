package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;

public abstract class g0 {
    static abstract class a {
        static void a(Object object0, Intent intent0, Bundle bundle0) {
            RemoteInput.addResultsToIntent(((RemoteInput[])object0), intent0, bundle0);
        }

        public static RemoteInput b(g0 g00) {
            throw null;
        }

        static Bundle c(Intent intent0) {
            return RemoteInput.getResultsFromIntent(intent0);
        }
    }

    static RemoteInput a(g0 g00) {
        return a.b(g00);
    }

    static RemoteInput[] b(g0[] arr_g0) {
        if(arr_g0 == null) {
            return null;
        }
        RemoteInput[] arr_remoteInput = new RemoteInput[arr_g0.length];
        for(int v = 0; v < arr_g0.length; ++v) {
            g0 g00 = arr_g0[v];
            arr_remoteInput[v] = g0.a(null);
        }
        return arr_remoteInput;
    }
}

