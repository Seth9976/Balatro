package e1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class t extends BroadcastReceiver {
    Context a;
    private final s b;

    public t(s s0) {
        this.b = s0;
    }

    public final void a(Context context0) {
        this.a = context0;
    }

    public final void b() {
        synchronized(this) {
            Context context0 = this.a;
            if(context0 != null) {
                context0.unregisterReceiver(this);
            }
            this.a = null;
        }
    }

    public static boolean equals$003(String s, Object object0) {
        return s.equals(object0);
    }

    public static Uri getData$001(Intent intent0) {
        return intent0.getData();
    }

    public static String getSchemeSpecificPart$002(Uri uri0) {
        return uri0.getSchemeSpecificPart();
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        Uri uri0 = intent0.getData();
        if("com.google.android.gms".equals((uri0 == null ? null : uri0.getSchemeSpecificPart()))) {
            this.b.a();
            this.b();
        }
    }
}

