package j0;

import java.util.concurrent.Executor;

class m implements Executor {
    static class a implements Runnable {
        private final Runnable e;

        a(Runnable runnable0) {
            this.e = runnable0;
        }

        @Override
        public void run() {
            try {
                this.e.run();
            }
            catch(Exception exception0) {
                n0.a.d("Executor", "Background execution failure.", exception0);
            }
        }
    }

    private final Executor e;

    m(Executor executor0) {
        this.e = executor0;
    }

    @Override
    public void execute(Runnable runnable0) {
        a m$a0 = new a(runnable0);
        this.e.execute(m$a0);
    }
}

