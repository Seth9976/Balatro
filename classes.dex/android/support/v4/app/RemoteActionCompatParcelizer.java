package android.support.v4.app;

import androidx.core.app.RemoteActionCompat;
import androidx.versionedparcelable.a;

public final class RemoteActionCompatParcelizer extends androidx.core.app.RemoteActionCompatParcelizer {
    @Override  // androidx.core.app.RemoteActionCompatParcelizer
    public static RemoteActionCompat read(a a0) {
        return androidx.core.app.RemoteActionCompatParcelizer.read(a0);
    }

    @Override  // androidx.core.app.RemoteActionCompatParcelizer
    public static void write(RemoteActionCompat remoteActionCompat0, a a0) {
        androidx.core.app.RemoteActionCompatParcelizer.write(remoteActionCompat0, a0);
    }
}

