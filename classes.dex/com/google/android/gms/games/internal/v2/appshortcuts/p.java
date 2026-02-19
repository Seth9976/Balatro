package com.google.android.gms.games.internal.v2.appshortcuts;

import android.app.Activity;
import android.content.Context;
import d1.a.a;
import d1.a.d;
import d1.a.g;
import d1.e;

final class p extends e {
    private static final g k;
    private static final a l;
    private static final d1.a m;

    static {
        g a$g0 = new g();
        p.k = a$g0;
        l l0 = new l();
        p.l = l0;
        p.m = new d1.a("GamesAppShortcuts.API", l0, a$g0);
    }

    p(Activity activity0) {
        super(activity0, p.m, d.a, d1.e.a.c);
    }

    p(Context context0) {
        super(context0, p.m, d.a, d1.e.a.c);
    }
}

