package kotlinx.coroutines.scheduling;

import r3.g;

public final class k extends h {
    public final Runnable g;

    public k(Runnable runnable0, long v, i i0) {
        super(v, i0);
        this.g = runnable0;
    }

    @Override
    public void run() {
        try {
            this.g.run();
        }
        finally {
            this.f.b();
        }
    }

    @Override
    public String toString() {
        return "Task[" + g.a(this.g) + '@' + g.b(this.g) + ", " + this.e + ", " + this.f + ']';
    }
}

