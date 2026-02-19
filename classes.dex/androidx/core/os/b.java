package androidx.core.os;

import android.os.CancellationSignal;

public final class b {
    static abstract class a {
        static void a(Object object0) {
            ((CancellationSignal)object0).cancel();
        }

        static CancellationSignal b() {
            return new CancellationSignal();
        }
    }

    public interface androidx.core.os.b.b {
        void a();
    }

    private boolean a;
    private androidx.core.os.b.b b;
    private Object c;
    private boolean d;

    public void a() {
        Object object0;
        androidx.core.os.b.b b$b0;
        synchronized(this) {
            if(this.a) {
                return;
            }
            this.a = true;
            this.d = true;
            b$b0 = this.b;
            object0 = this.c;
        }
        try {
            if(b$b0 != null) {
                b$b0.a();
            }
            if(object0 != null) {
                a.a(object0);
            }
            goto label_24;
        }
        catch(Throwable throwable0) {
        }
        synchronized(this) {
            this.d = false;
            this.notifyAll();
        }
        throw throwable0;
    label_24:
        synchronized(this) {
            this.d = false;
            this.notifyAll();
        }
    }

    public void b(androidx.core.os.b.b b$b0) {
        synchronized(this) {
            this.c();
            if(this.b == b$b0) {
                return;
            }
            this.b = b$b0;
            if(this.a && b$b0 != null) {
                b$b0.a();
            }
        }
    }

    private void c() {
        while(this.d) {
            try {
                this.wait();
            }
            catch(InterruptedException unused_ex) {
            }
        }
    }
}

