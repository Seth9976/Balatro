package com.google.android.gms.auth.api.signin;

import a1.p;
import android.content.Context;
import g1.q;

public abstract class a {
    public static b a(Context context0, GoogleSignInOptions googleSignInOptions0) {
        return new b(context0, ((GoogleSignInOptions)q.i(googleSignInOptions0)));
    }

    public static GoogleSignInAccount b(Context context0) {
        return p.b(context0).a();
    }
}

