package a1;

import android.content.Context;
import android.util.Log;
import d1.f;
import e1.k;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import y.a;

public final class g extends a implements k {
    private final Semaphore o;
    private final Set p;

    public g(Context context0, Set set0) {
        super(context0);
        this.o = new Semaphore(0);
        this.p = set0;
    }

    @Override  // y.a
    public final Object C() {
        int v = 0;
        for(Object object0: this.p) {
            if(((f)object0).d(this)) {
                ++v;
            }
        }
        try {
            this.o.tryAcquire(v, 5L, TimeUnit.SECONDS);
        }
        catch(InterruptedException interruptedException0) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", interruptedException0);
            Thread.currentThread().interrupt();
        }
        return null;
    }

    @Override  // y.b
    protected final void p() {
        this.o.drainPermits();
        this.h();
    }
}

