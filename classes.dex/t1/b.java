package t1;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.gms.games.internal.v2.resolution.GamesResolutionActivity;
import g2.h;

public final class b {
    public static b a() {
        return new b();
    }

    public static final h b(Activity activity0, PendingIntent pendingIntent0) {
        a a0 = new a();
        Intent intent0 = new Intent(activity0, GamesResolutionActivity.class);
        intent0.putExtra("pendingIntent", pendingIntent0);
        intent0.putExtra("resultReceiver", a0);
        activity0.startActivity(intent0);
        return a0.o();
    }
}

