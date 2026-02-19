package r3;

import java.util.concurrent.locks.LockSupport;

public abstract class p extends m {
    protected abstract Thread j();

    protected final void k() {
        Thread thread0 = this.j();
        if(Thread.currentThread() != thread0) {
            LockSupport.unpark(thread0);
        }
    }
}

