package d0;

import com.google.android.gms.internal.play_billing.a0;
import java.util.concurrent.Future;

public final class d0 implements Runnable {
    public final Future e;
    public final Runnable f;

    public d0(Future future0, Runnable runnable0) {
        this.e = future0;
        this.f = runnable0;
    }

    @Override
    public final void run() {
        Future future0 = this.e;
        if(!future0.isDone() && !future0.isCancelled()) {
            Runnable runnable0 = this.f;
            future0.cancel(true);
            a0.i("BillingClient", "Async task is taking too long, cancel it!");
            if(runnable0 != null) {
                runnable0.run();
            }
        }
    }
}

