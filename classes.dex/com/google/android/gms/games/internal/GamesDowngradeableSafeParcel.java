package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import l1.f;

public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel {
    protected static boolean m0(Integer integer0) {
        return integer0 == null ? false : f.a(((int)integer0));
    }
}

