package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a a0) {
        RemoteActionCompat remoteActionCompat0 = new RemoteActionCompat();
        remoteActionCompat0.a = (IconCompat)a0.v(remoteActionCompat0.a, 1);
        remoteActionCompat0.b = a0.l(remoteActionCompat0.b, 2);
        remoteActionCompat0.c = a0.l(remoteActionCompat0.c, 3);
        remoteActionCompat0.d = (PendingIntent)a0.r(remoteActionCompat0.d, 4);
        remoteActionCompat0.e = a0.h(remoteActionCompat0.e, 5);
        remoteActionCompat0.f = a0.h(remoteActionCompat0.f, 6);
        return remoteActionCompat0;
    }

    public static void write(RemoteActionCompat remoteActionCompat0, a a0) {
        a0.M(remoteActionCompat0.a, 1);
        a0.D(remoteActionCompat0.b, 2);
        a0.D(remoteActionCompat0.c, 3);
        a0.H(remoteActionCompat0.d, 4);
        a0.z(remoteActionCompat0.e, 5);
        a0.z(remoteActionCompat0.f, 6);
    }
}

