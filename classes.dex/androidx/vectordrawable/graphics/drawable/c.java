package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class c {
    public static Interpolator a(Context context0, int v) {
        return AnimationUtils.loadInterpolator(context0, v);
    }
}

