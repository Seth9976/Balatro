package org.love2d.android;

public final class j implements k {
    public final PlatformActivity a;
    public final String b;

    public j(PlatformActivity platformActivity0, String s) {
        this.a = platformActivity0;
        this.b = s;
    }

    @Override  // org.love2d.android.PlatformActivity$k
    public final void a(boolean z) {
        this.a.lambda$checkProductOwnership$8(this.b, z);
    }
}

