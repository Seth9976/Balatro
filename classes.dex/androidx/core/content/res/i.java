package androidx.core.content.res;

import android.graphics.Typeface;

public final class i implements Runnable {
    public final e e;
    public final Typeface f;

    public i(e h$e0, Typeface typeface0) {
        this.e = h$e0;
        this.f = typeface0;
    }

    @Override
    public final void run() {
        this.e.g(this.f);
    }
}

