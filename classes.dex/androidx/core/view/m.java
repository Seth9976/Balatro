package androidx.core.view;

import android.view.MotionEvent;

public abstract class m {
    public static boolean a(MotionEvent motionEvent0, int v) {
        return (motionEvent0.getSource() & v) == v;
    }
}

