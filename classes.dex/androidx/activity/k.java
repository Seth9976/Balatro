package androidx.activity;

import android.window.OnBackInvokedCallback;

public final class k implements OnBackInvokedCallback {
    public final Runnable a;

    public k(Runnable runnable0) {
        this.a = runnable0;
    }

    @Override  // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.a.run();
    }
}

