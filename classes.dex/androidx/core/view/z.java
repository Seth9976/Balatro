package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public abstract class z {
    static abstract class a {
        static boolean a(ViewParent viewParent0, View view0, float f, float f1, boolean z) {
            return viewParent0.onNestedFling(view0, f, f1, z);
        }

        static boolean b(ViewParent viewParent0, View view0, float f, float f1) {
            return viewParent0.onNestedPreFling(view0, f, f1);
        }

        static void c(ViewParent viewParent0, View view0, int v, int v1, int[] arr_v) {
            viewParent0.onNestedPreScroll(view0, v, v1, arr_v);
        }

        static void d(ViewParent viewParent0, View view0, int v, int v1, int v2, int v3) {
            viewParent0.onNestedScroll(view0, v, v1, v2, v3);
        }

        static void e(ViewParent viewParent0, View view0, View view1, int v) {
            viewParent0.onNestedScrollAccepted(view0, view1, v);
        }

        static boolean f(ViewParent viewParent0, View view0, View view1, int v) {
            return viewParent0.onStartNestedScroll(view0, view1, v);
        }

        static void g(ViewParent viewParent0, View view0) {
            viewParent0.onStopNestedScroll(view0);
        }
    }

    public static boolean a(ViewParent viewParent0, View view0, float f, float f1, boolean z) {
        try {
            return a.a(viewParent0, view0, f, f1, z);
        }
        catch(AbstractMethodError abstractMethodError0) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent0 + " does not implement interface method onNestedFling", abstractMethodError0);
            return false;
        }
    }

    public static boolean b(ViewParent viewParent0, View view0, float f, float f1) {
        try {
            return a.b(viewParent0, view0, f, f1);
        }
        catch(AbstractMethodError abstractMethodError0) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent0 + " does not implement interface method onNestedPreFling", abstractMethodError0);
            return false;
        }
    }

    public static void c(ViewParent viewParent0, View view0, int v, int v1, int[] arr_v, int v2) {
        if(viewParent0 instanceof o) {
            ((o)viewParent0).c(view0, v, v1, arr_v, v2);
            return;
        }
        if(v2 == 0) {
            try {
                a.c(viewParent0, view0, v, v1, arr_v);
            }
            catch(AbstractMethodError abstractMethodError0) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent0 + " does not implement interface method onNestedPreScroll", abstractMethodError0);
            }
        }
    }

    public static void d(ViewParent viewParent0, View view0, int v, int v1, int v2, int v3, int v4, int[] arr_v) {
        if(viewParent0 instanceof p) {
            ((p)viewParent0).d(view0, v, v1, v2, v3, v4, arr_v);
            return;
        }
        arr_v[0] += v2;
        arr_v[1] += v3;
        if(viewParent0 instanceof o) {
            ((o)viewParent0).e(view0, v, v1, v2, v3, v4);
            return;
        }
        if(v4 == 0) {
            try {
                a.d(viewParent0, view0, v, v1, v2, v3);
            }
            catch(AbstractMethodError abstractMethodError0) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent0 + " does not implement interface method onNestedScroll", abstractMethodError0);
            }
        }
    }

    public static void e(ViewParent viewParent0, View view0, View view1, int v, int v1) {
        if(viewParent0 instanceof o) {
            ((o)viewParent0).a(view0, view1, v, v1);
            return;
        }
        if(v1 == 0) {
            try {
                a.e(viewParent0, view0, view1, v);
            }
            catch(AbstractMethodError abstractMethodError0) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent0 + " does not implement interface method onNestedScrollAccepted", abstractMethodError0);
            }
        }
    }

    public static boolean f(ViewParent viewParent0, View view0, View view1, int v, int v1) {
        if(viewParent0 instanceof o) {
            return ((o)viewParent0).f(view0, view1, v, v1);
        }
        if(v1 == 0) {
            try {
                return a.f(viewParent0, view0, view1, v);
            }
            catch(AbstractMethodError abstractMethodError0) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent0 + " does not implement interface method onStartNestedScroll", abstractMethodError0);
            }
        }
        return false;
    }

    public static void g(ViewParent viewParent0, View view0, int v) {
        if(viewParent0 instanceof o) {
            ((o)viewParent0).b(view0, v);
            return;
        }
        if(v == 0) {
            try {
                a.g(viewParent0, view0);
            }
            catch(AbstractMethodError abstractMethodError0) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent0 + " does not implement interface method onStopNestedScroll", abstractMethodError0);
            }
        }
    }
}

