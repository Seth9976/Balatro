package e1;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class p implements Executor {
    public final Handler e;

    public p(Handler handler0) {
        this.e = handler0;
    }

    @Override
    public final void execute(Runnable runnable0) {
        this.e.post(runnable0);
    }
}

