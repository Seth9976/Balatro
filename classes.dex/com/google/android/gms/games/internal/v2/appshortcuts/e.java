package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Context;
import android.os.Build.VERSION;
import s1.q;

public abstract class e {
    e(q q0) {
    }

    public void a() {
    }

    public static e b(Context context0) {
        return Build.VERSION.SDK_INT < 25 ? new a() : new d(context0);
    }
}

