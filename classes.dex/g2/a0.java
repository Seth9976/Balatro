package g2;

import android.os.Handler;
import android.os.Looper;
import d2.a;
import java.util.concurrent.Executor;

final class a0 implements Executor {
    private final Handler e;

    public a0() {
        this.e = new a(Looper.getMainLooper());
    }

    @Override
    public final void execute(Runnable runnable0) {
        this.e.post(runnable0);
    }
}

