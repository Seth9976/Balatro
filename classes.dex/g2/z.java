package g2;

import java.util.concurrent.Executor;

final class z implements Executor {
    @Override
    public final void execute(Runnable runnable0) {
        runnable0.run();
    }
}

