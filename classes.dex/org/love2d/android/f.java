package org.love2d.android;

import com.android.billingclient.api.d;
import d0.c;
import java.util.List;

public final class f implements c {
    public final PlatformActivity a;
    public final String b;

    public f(PlatformActivity platformActivity0, String s) {
        this.a = platformActivity0;
        this.b = s;
    }

    @Override  // d0.c
    public final void a(d d0, List list0) {
        this.a.lambda$checkProductOwnership$7(this.b, d0, list0);
    }
}

