package androidx.core.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.DisplayCutout;
import androidx.core.util.b;
import java.util.List;

public final class d {
    static abstract class a {
        static DisplayCutout a(Rect rect0, List list0) {
            return new DisplayCutout(rect0, list0);
        }

        static List b(DisplayCutout displayCutout0) {
            return displayCutout0.getBoundingRects();
        }

        static int c(DisplayCutout displayCutout0) {
            return displayCutout0.getSafeInsetBottom();
        }

        static int d(DisplayCutout displayCutout0) {
            return displayCutout0.getSafeInsetLeft();
        }

        static int e(DisplayCutout displayCutout0) {
            return displayCutout0.getSafeInsetRight();
        }

        static int f(DisplayCutout displayCutout0) {
            return displayCutout0.getSafeInsetTop();
        }
    }

    private final DisplayCutout a;

    private d(DisplayCutout displayCutout0) {
        this.a = displayCutout0;
    }

    public int a() {
        return Build.VERSION.SDK_INT < 28 ? 0 : a.c(this.a);
    }

    public int b() {
        return Build.VERSION.SDK_INT < 28 ? 0 : a.d(this.a);
    }

    public int c() {
        return Build.VERSION.SDK_INT < 28 ? 0 : a.e(this.a);
    }

    public int d() {
        return Build.VERSION.SDK_INT < 28 ? 0 : a.f(this.a);
    }

    static d e(DisplayCutout displayCutout0) {
        return displayCutout0 == null ? null : new d(displayCutout0);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return d.class == class0 ? b.a(this.a, ((d)object0).a) : false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public String toString() {
        return "DisplayCutoutCompat{" + this.a + "}";
    }
}

