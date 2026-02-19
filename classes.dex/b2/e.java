package b2;

import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;

public class e extends Handler {
    private final Looper a;

    public e(Looper looper0) {
        super(looper0);
        this.a = Looper.getMainLooper();
    }

    public e(Looper looper0, Handler.Callback handler$Callback0) {
        super(looper0, handler$Callback0);
        this.a = Looper.getMainLooper();
    }
}

