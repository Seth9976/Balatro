package com.google.android.gms.auth.api.signin.internal;

import a1.g;
import a1.x;
import android.content.Intent;
import android.os.Bundle;
import d1.f;
import java.util.Set;
import y.b;

final class a implements androidx.loader.app.a.a {
    final SignInHubActivity a;

    a(SignInHubActivity signInHubActivity0, x x0) {
        this.a = signInHubActivity0;
        super();
    }

    @Override  // androidx.loader.app.a$a
    public final void a(b b0) {
    }

    @Override  // androidx.loader.app.a$a
    public final b b(int v, Bundle bundle0) {
        Set set0 = f.b();
        return new g(this.a, set0);
    }

    @Override  // androidx.loader.app.a$a
    public final void c(b b0, Object object0) {
        Void void0 = (Void)object0;
        int v = this.a.A;
        Intent intent0 = this.a.B;
        this.a.setResult(v, intent0);
        this.a.finish();
    }
}

