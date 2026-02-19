package androidx.activity;

import androidx.core.util.a;

public final class i implements a {
    public final OnBackPressedDispatcher a;

    public i(OnBackPressedDispatcher onBackPressedDispatcher0) {
        this.a = onBackPressedDispatcher0;
    }

    @Override  // androidx.core.util.a
    public final void accept(Object object0) {
        this.a.e(((Boolean)object0));
    }
}

