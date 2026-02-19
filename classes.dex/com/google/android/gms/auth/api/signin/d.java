package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

final class d implements Comparator {
    @Override
    public final int compare(Object object0, Object object1) {
        return ((Scope)object0).j0().compareTo(((Scope)object1).j0());
    }
}

