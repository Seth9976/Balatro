package org.love2d.android;

public final class h implements Runnable {
    public final PlatformActivity e;
    public final k f;

    public h(PlatformActivity platformActivity0, k platformActivity$k0) {
        this.e = platformActivity0;
        this.f = platformActivity$k0;
    }

    @Override
    public final void run() {
        this.e.lambda$performBillingOperation$2(this.f);
    }
}

