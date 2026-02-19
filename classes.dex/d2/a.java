package d2;

import android.os.Handler;
import android.os.Looper;

public final class a extends Handler {
    private final Looper a;

    public a(Looper looper0) {
        super(looper0);
        this.a = Looper.getMainLooper();
    }
}

