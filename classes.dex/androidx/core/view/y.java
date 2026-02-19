package androidx.core.view;

import android.view.ViewGroup;

public abstract class y {
    static abstract class a {
        static int a(ViewGroup viewGroup0) {
            return viewGroup0.getNestedScrollAxes();
        }

        static boolean b(ViewGroup viewGroup0) {
            return viewGroup0.isTransitionGroup();
        }

        static void c(ViewGroup viewGroup0, boolean z) {
            viewGroup0.setTransitionGroup(z);
        }
    }

    public static boolean a(ViewGroup viewGroup0) {
        return a.b(viewGroup0);
    }
}

