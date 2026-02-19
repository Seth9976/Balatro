package androidx.core.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

public abstract class b {
    static abstract class a {
        static void a(EdgeEffect edgeEffect0, float f, float f1) {
            edgeEffect0.onPull(f, f1);
        }
    }

    static abstract class androidx.core.widget.b.b {
        public static EdgeEffect a(Context context0, AttributeSet attributeSet0) {
            try {
                return new EdgeEffect(context0, attributeSet0);
            }
            catch(Throwable unused_ex) {
                return new EdgeEffect(context0);
            }
        }

        public static float b(EdgeEffect edgeEffect0) {
            try {
                return edgeEffect0.getDistance();
            }
            catch(Throwable unused_ex) {
                return 0.0f;
            }
        }

        public static float c(EdgeEffect edgeEffect0, float f, float f1) {
            try {
                return edgeEffect0.onPullDistance(f, f1);
            }
            catch(Throwable unused_ex) {
                edgeEffect0.onPull(f, f1);
                return 0.0f;
            }
        }
    }

    public static EdgeEffect a(Context context0, AttributeSet attributeSet0) {
        return Build.VERSION.SDK_INT < 0x1F ? new EdgeEffect(context0) : androidx.core.widget.b.b.a(context0, attributeSet0);
    }

    public static float b(EdgeEffect edgeEffect0) {
        return Build.VERSION.SDK_INT < 0x1F ? 0.0f : androidx.core.widget.b.b.b(edgeEffect0);
    }

    public static void c(EdgeEffect edgeEffect0, float f, float f1) {
        a.a(edgeEffect0, f, f1);
    }

    public static float d(EdgeEffect edgeEffect0, float f, float f1) {
        if(Build.VERSION.SDK_INT >= 0x1F) {
            return androidx.core.widget.b.b.c(edgeEffect0, f, f1);
        }
        b.c(edgeEffect0, f, f1);
        return f;
    }
}

