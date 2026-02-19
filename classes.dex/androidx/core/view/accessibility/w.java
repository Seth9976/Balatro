package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityRecord;

public abstract class w {
    static abstract class a {
        static int a(AccessibilityRecord accessibilityRecord0) {
            return accessibilityRecord0.getMaxScrollX();
        }

        static int b(AccessibilityRecord accessibilityRecord0) {
            return accessibilityRecord0.getMaxScrollY();
        }

        static void c(AccessibilityRecord accessibilityRecord0, int v) {
            accessibilityRecord0.setMaxScrollX(v);
        }

        static void d(AccessibilityRecord accessibilityRecord0, int v) {
            accessibilityRecord0.setMaxScrollY(v);
        }
    }

    public static void a(AccessibilityRecord accessibilityRecord0, int v) {
        a.c(accessibilityRecord0, v);
    }

    public static void b(AccessibilityRecord accessibilityRecord0, int v) {
        a.d(accessibilityRecord0, v);
    }
}

