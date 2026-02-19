package androidx.core.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnUnhandledKeyEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import h.d;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import l.b;

public abstract class v {
    static class e implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        private final WeakHashMap a;

        e() {
            this.a = new WeakHashMap();
        }

        void a(View view0) {
            boolean z = view0.isShown() && view0.getWindowVisibility() == 0;
            this.a.put(view0, Boolean.valueOf(z));
            view0.addOnAttachStateChangeListener(this);
            if(i.b(view0)) {
                this.c(view0);
            }
        }

        private void b(View view0, boolean z) {
            boolean z1 = view0.isShown() && view0.getWindowVisibility() == 0;
            if(z != z1) {
                v.y(view0, (z1 ? 16 : 0x20));
                this.a.put(view0, Boolean.valueOf(z1));
            }
        }

        private void c(View view0) {
            view0.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        void d(View view0) {
            this.a.remove(view0);
            view0.removeOnAttachStateChangeListener(this);
            this.e(view0);
        }

        private void e(View view0) {
            g.o(view0.getViewTreeObserver(), this);
        }

        @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onGlobalLayout() {
            if(Build.VERSION.SDK_INT < 28) {
                for(Object object0: this.a.entrySet()) {
                    this.b(((View)((Map.Entry)object0).getKey()), ((Boolean)((Map.Entry)object0).getValue()).booleanValue());
                }
            }
        }

        @Override  // android.view.View$OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view0) {
            this.c(view0);
        }

        @Override  // android.view.View$OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view0) {
        }
    }

    static abstract class f {
        private final int a;
        private final Class b;
        private final int c;
        private final int d;

        f(int v, Class class0, int v1) {
            this(v, class0, 0, v1);
        }

        f(int v, Class class0, int v1, int v2) {
            this.a = v;
            this.b = class0;
            this.d = v1;
            this.c = v2;
        }

        // 去混淆评级： 低(20)
        boolean a(Boolean boolean0, Boolean boolean1) {
            return (boolean0 == null || !boolean0.booleanValue() ? 0 : 1) == (boolean1 == null || !boolean1.booleanValue() ? 0 : 1);
        }

        private boolean b() [...] // Inlined contents

        private boolean c() {
            return Build.VERSION.SDK_INT >= this.c;
        }

        abstract Object d(View arg1);

        abstract void e(View arg1, Object arg2);

        Object f(View view0) {
            if(this.c()) {
                return this.d(view0);
            }
            Object object0 = view0.getTag(this.a);
            return this.b.isInstance(object0) ? object0 : null;
        }

        void g(View view0, Object object0) {
            if(this.c()) {
                this.e(view0, object0);
                return;
            }
            if(this.h(this.f(view0), object0)) {
                v.f(view0);
                view0.setTag(this.a, object0);
                v.y(view0, this.d);
            }
        }

        abstract boolean h(Object arg1, Object arg2);
    }

    static abstract class g {
        static AccessibilityNodeProvider a(View view0) {
            return view0.getAccessibilityNodeProvider();
        }

        static boolean b(View view0) {
            return view0.getFitsSystemWindows();
        }

        static int c(View view0) {
            return view0.getImportantForAccessibility();
        }

        static int d(View view0) {
            return view0.getMinimumHeight();
        }

        static int e(View view0) {
            return view0.getMinimumWidth();
        }

        static ViewParent f(View view0) {
            return view0.getParentForAccessibility();
        }

        static int g(View view0) {
            return view0.getWindowSystemUiVisibility();
        }

        static boolean h(View view0) {
            return view0.hasOverlappingRendering();
        }

        static boolean i(View view0) {
            return view0.hasTransientState();
        }

        static boolean j(View view0, int v, Bundle bundle0) {
            return view0.performAccessibilityAction(v, bundle0);
        }

        static void k(View view0) {
            view0.postInvalidateOnAnimation();
        }

        static void l(View view0, int v, int v1, int v2, int v3) {
            view0.postInvalidateOnAnimation(v, v1, v2, v3);
        }

        static void m(View view0, Runnable runnable0) {
            view0.postOnAnimation(runnable0);
        }

        static void n(View view0, Runnable runnable0, long v) {
            view0.postOnAnimationDelayed(runnable0, v);
        }

        static void o(ViewTreeObserver viewTreeObserver0, ViewTreeObserver.OnGlobalLayoutListener viewTreeObserver$OnGlobalLayoutListener0) {
            viewTreeObserver0.removeOnGlobalLayoutListener(viewTreeObserver$OnGlobalLayoutListener0);
        }

        static void p(View view0) {
            view0.requestFitSystemWindows();
        }

        static void q(View view0, Drawable drawable0) {
            view0.setBackground(drawable0);
        }

        static void r(View view0, boolean z) {
            view0.setHasTransientState(z);
        }

        static void s(View view0, int v) {
            view0.setImportantForAccessibility(v);
        }
    }

    static abstract class h {
        static int a() {
            return View.generateViewId();
        }

        static Display b(View view0) {
            return view0.getDisplay();
        }

        static int c(View view0) {
            return view0.getLabelFor();
        }

        static int d(View view0) {
            return view0.getLayoutDirection();
        }

        static int e(View view0) {
            return view0.getPaddingEnd();
        }

        static int f(View view0) {
            return view0.getPaddingStart();
        }

        static boolean g(View view0) {
            return view0.isPaddingRelative();
        }

        static void h(View view0, int v) {
            view0.setLabelFor(v);
        }

        static void i(View view0, Paint paint0) {
            view0.setLayerPaint(paint0);
        }

        static void j(View view0, int v) {
            view0.setLayoutDirection(v);
        }

        static void k(View view0, int v, int v1, int v2, int v3) {
            view0.setPaddingRelative(v, v1, v2, v3);
        }
    }

    static abstract class i {
        static int a(View view0) {
            return view0.getAccessibilityLiveRegion();
        }

        static boolean b(View view0) {
            return view0.isAttachedToWindow();
        }

        static boolean c(View view0) {
            return view0.isLaidOut();
        }

        static boolean d(View view0) {
            return view0.isLayoutDirectionResolved();
        }

        static void e(ViewParent viewParent0, View view0, View view1, int v) {
            viewParent0.notifySubtreeAccessibilityStateChanged(view0, view1, v);
        }

        static void f(View view0, int v) {
            view0.setAccessibilityLiveRegion(v);
        }

        static void g(AccessibilityEvent accessibilityEvent0, int v) {
            accessibilityEvent0.setContentChangeTypes(v);
        }
    }

    static abstract class j {
        static WindowInsets a(View view0, WindowInsets windowInsets0) {
            return view0.dispatchApplyWindowInsets(windowInsets0);
        }

        static WindowInsets b(View view0, WindowInsets windowInsets0) {
            return view0.onApplyWindowInsets(windowInsets0);
        }

        static void c(View view0) {
            view0.requestApplyInsets();
        }
    }

    static abstract class k {
        static void a(WindowInsets windowInsets0, View view0) {
            View.OnApplyWindowInsetsListener view$OnApplyWindowInsetsListener0 = (View.OnApplyWindowInsetsListener)view0.getTag(b.Q);
            if(view$OnApplyWindowInsetsListener0 != null) {
                view$OnApplyWindowInsetsListener0.onApplyWindowInsets(view0, windowInsets0);
            }
        }

        static a0 b(View view0, a0 a00, Rect rect0) {
            WindowInsets windowInsets0 = a00.s();
            if(windowInsets0 != null) {
                return a0.u(view0.computeSystemWindowInsets(windowInsets0, rect0), view0);
            }
            rect0.setEmpty();
            return a00;
        }

        static boolean c(View view0, float f, float f1, boolean z) {
            return view0.dispatchNestedFling(f, f1, z);
        }

        static boolean d(View view0, float f, float f1) {
            return view0.dispatchNestedPreFling(f, f1);
        }

        static boolean e(View view0, int v, int v1, int[] arr_v, int[] arr_v1) {
            return view0.dispatchNestedPreScroll(v, v1, arr_v, arr_v1);
        }

        static boolean f(View view0, int v, int v1, int v2, int v3, int[] arr_v) {
            return view0.dispatchNestedScroll(v, v1, v2, v3, arr_v);
        }

        static ColorStateList g(View view0) {
            return view0.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view0) {
            return view0.getBackgroundTintMode();
        }

        static float i(View view0) {
            return view0.getElevation();
        }

        public static a0 j(View view0) {
            return a.a(view0);
        }

        static String k(View view0) {
            return view0.getTransitionName();
        }

        static float l(View view0) {
            return view0.getTranslationZ();
        }

        static float m(View view0) {
            return view0.getZ();
        }

        static boolean n(View view0) {
            return view0.hasNestedScrollingParent();
        }

        static boolean o(View view0) {
            return view0.isImportantForAccessibility();
        }

        static boolean p(View view0) {
            return view0.isNestedScrollingEnabled();
        }

        static void q(View view0, ColorStateList colorStateList0) {
            view0.setBackgroundTintList(colorStateList0);
        }

        static void r(View view0, PorterDuff.Mode porterDuff$Mode0) {
            view0.setBackgroundTintMode(porterDuff$Mode0);
        }

        static void s(View view0, float f) {
            view0.setElevation(f);
        }

        static void t(View view0, boolean z) {
            view0.setNestedScrollingEnabled(z);
        }

        static void u(View view0, r r0) {
            class androidx.core.view.v.k.a implements View.OnApplyWindowInsetsListener {
                a0 a;
                final View b;

                androidx.core.view.v.k.a(View view0, r r0) {
                    this.a = null;
                }

                @Override  // android.view.View$OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view0, WindowInsets windowInsets0) {
                    a0 a00 = a0.u(windowInsets0, view0);
                    if(Build.VERSION.SDK_INT < 30) {
                        k.a(windowInsets0, this.b);
                        if(a00.equals(this.a)) {
                            throw null;
                        }
                    }
                    this.a = a00;
                    throw null;
                }
            }

            if(Build.VERSION.SDK_INT < 30) {
                view0.setTag(b.L, r0);
            }
            if(r0 == null) {
                view0.setOnApplyWindowInsetsListener(((View.OnApplyWindowInsetsListener)view0.getTag(b.Q)));
                return;
            }
            view0.setOnApplyWindowInsetsListener(new androidx.core.view.v.k.a(view0, r0));
        }

        static void v(View view0, String s) {
            view0.setTransitionName(s);
        }

        static void w(View view0, float f) {
            view0.setTranslationZ(f);
        }

        static void x(View view0, float f) {
            view0.setZ(f);
        }

        static boolean y(View view0, int v) {
            return view0.startNestedScroll(v);
        }

        static void z(View view0) {
            view0.stopNestedScroll();
        }
    }

    static abstract class l {
        public static a0 a(View view0) {
            WindowInsets windowInsets0 = view0.getRootWindowInsets();
            if(windowInsets0 == null) {
                return null;
            }
            a0 a00 = a0.t(windowInsets0);
            a00.q(a00);
            a00.d(view0.getRootView());
            return a00;
        }

        static int b(View view0) {
            return view0.getScrollIndicators();
        }

        static void c(View view0, int v) {
            view0.setScrollIndicators(v);
        }

        static void d(View view0, int v, int v1) {
            view0.setScrollIndicators(v, v1);
        }
    }

    static abstract class m {
        static void a(View view0, p v$p0) {
            k.g g0 = (k.g)view0.getTag(b.P);
            if(g0 == null) {
                g0 = new k.g();
                view0.setTag(b.P, g0);
            }
            Objects.requireNonNull(v$p0);
            w w0 = new w(v$p0);
            g0.put(v$p0, w0);
            view0.addOnUnhandledKeyEventListener(w0);
        }

        static CharSequence b(View view0) {
            return view0.getAccessibilityPaneTitle();
        }

        static boolean c(View view0) {
            return view0.isAccessibilityHeading();
        }

        static boolean d(View view0) {
            return view0.isScreenReaderFocusable();
        }

        static void e(View view0, p v$p0) {
            k.g g0 = (k.g)view0.getTag(b.P);
            if(g0 == null) {
                return;
            }
            View.OnUnhandledKeyEventListener view$OnUnhandledKeyEventListener0 = (View.OnUnhandledKeyEventListener)g0.get(v$p0);
            if(view$OnUnhandledKeyEventListener0 != null) {
                view0.removeOnUnhandledKeyEventListener(view$OnUnhandledKeyEventListener0);
            }
        }

        static Object f(View view0, int v) {
            return view0.requireViewById(v);
        }

        static void g(View view0, boolean z) {
            view0.setAccessibilityHeading(z);
        }

        static void h(View view0, CharSequence charSequence0) {
            view0.setAccessibilityPaneTitle(charSequence0);
        }

        static void i(View view0, boolean z) {
            view0.setScreenReaderFocusable(z);
        }
    }

    static abstract class n {
        static View.AccessibilityDelegate a(View view0) {
            return view0.getAccessibilityDelegate();
        }

        static List b(View view0) {
            return view0.getSystemGestureExclusionRects();
        }

        static void c(View view0, Context context0, int[] arr_v, AttributeSet attributeSet0, TypedArray typedArray0, int v, int v1) {
            view0.saveAttributeDataForStyleable(context0, arr_v, attributeSet0, typedArray0, v, v1);
        }

        static void d(View view0, List list0) {
            view0.setSystemGestureExclusionRects(list0);
        }
    }

    static abstract class o {
        static CharSequence a(View view0) {
            return view0.getStateDescription();
        }

        static void b(View view0, CharSequence charSequence0) {
            view0.setStateDescription(charSequence0);
        }
    }

    public interface p {
    }

    static class q {
        private WeakHashMap a;
        private SparseArray b;
        private WeakReference c;
        private static final ArrayList d;

        static {
            q.d = new ArrayList();
        }

        q() {
            this.a = null;
            this.b = null;
            this.c = null;
        }

        static q a(View view0) {
            q v$q0 = (q)view0.getTag(b.O);
            if(v$q0 == null) {
                v$q0 = new q();
                view0.setTag(b.O, v$q0);
            }
            return v$q0;
        }

        boolean b(View view0, KeyEvent keyEvent0) {
            if(keyEvent0.getAction() == 0) {
                this.g();
            }
            View view1 = this.c(view0, keyEvent0);
            if(keyEvent0.getAction() == 0) {
                int v = keyEvent0.getKeyCode();
                if(view1 != null && !KeyEvent.isModifierKey(v)) {
                    this.d().put(v, new WeakReference(view1));
                }
            }
            return view1 != null;
        }

        private View c(View view0, KeyEvent keyEvent0) {
            if(this.a != null && this.a.containsKey(view0)) {
                if(view0 instanceof ViewGroup) {
                    for(int v = ((ViewGroup)view0).getChildCount() - 1; v >= 0; --v) {
                        View view1 = this.c(((ViewGroup)view0).getChildAt(v), keyEvent0);
                        if(view1 != null) {
                            return view1;
                        }
                    }
                }
                return this.e(view0, keyEvent0) ? view0 : null;
            }
            return null;
        }

        private SparseArray d() {
            if(this.b == null) {
                this.b = new SparseArray();
            }
            return this.b;
        }

        private boolean e(View view0, KeyEvent keyEvent0) {
            ArrayList arrayList0 = (ArrayList)view0.getTag(b.P);
            if(arrayList0 != null) {
                int v = arrayList0.size();
                if(v - 1 >= 0) {
                    d.a(arrayList0.get(v - 1));
                    throw null;
                }
            }
            return false;
        }

        boolean f(KeyEvent keyEvent0) {
            WeakReference weakReference0;
            if(this.c != null && this.c.get() == keyEvent0) {
                return false;
            }
            this.c = new WeakReference(keyEvent0);
            SparseArray sparseArray0 = this.d();
            if(keyEvent0.getAction() == 1) {
                int v = sparseArray0.indexOfKey(keyEvent0.getKeyCode());
                if(v >= 0) {
                    weakReference0 = (WeakReference)sparseArray0.valueAt(v);
                    sparseArray0.removeAt(v);
                }
                else {
                    weakReference0 = null;
                }
            }
            else {
                weakReference0 = null;
            }
            if(weakReference0 == null) {
                weakReference0 = (WeakReference)sparseArray0.get(keyEvent0.getKeyCode());
            }
            if(weakReference0 != null) {
                View view0 = (View)weakReference0.get();
                if(view0 != null && v.v(view0)) {
                    this.e(view0, keyEvent0);
                }
                return true;
            }
            return false;
        }

        private void g() {
            WeakHashMap weakHashMap0 = this.a;
            if(weakHashMap0 != null) {
                weakHashMap0.clear();
            }
            ArrayList arrayList0 = q.d;
            if(arrayList0.isEmpty()) {
                return;
            }
            synchronized(arrayList0) {
                if(this.a == null) {
                    this.a = new WeakHashMap();
                }
                for(int v1 = arrayList0.size() - 1; v1 >= 0; --v1) {
                    ArrayList arrayList1 = q.d;
                    View view0 = (View)((WeakReference)arrayList1.get(v1)).get();
                    if(view0 == null) {
                        arrayList1.remove(v1);
                    }
                    else {
                        this.a.put(view0, Boolean.TRUE);
                        for(ViewParent viewParent0 = view0.getParent(); viewParent0 instanceof View; viewParent0 = viewParent0.getParent()) {
                            this.a.put(((View)viewParent0), Boolean.TRUE);
                        }
                    }
                }
            }
        }
    }

    private static final AtomicInteger a;
    private static WeakHashMap b;
    private static Field c;
    private static boolean d;
    private static final int[] e;
    private static final s f;
    private static final e g;

    static {
        v.a = new AtomicInteger(1);
        v.b = null;
        v.d = false;
        v.e = new int[]{b.b, b.c, b.n, b.y, b.B, b.C, b.D, b.E, b.F, b.G, b.d, b.e, b.f, b.g, b.h, b.i, b.j, b.k, b.l, b.m, b.o, b.p, b.q, b.r, b.s, b.t, b.u, b.v, b.w, b.x, b.z, b.A};
        v.f = new u();
        v.g = new e();
    }

    private static f A() {
        class androidx.core.view.v.b extends f {
            androidx.core.view.v.b(int v, Class class0, int v1, int v2) {
                super(v, class0, v1, v2);
            }

            @Override  // androidx.core.view.v$f
            Object d(View view0) {
                return this.i(view0);
            }

            @Override  // androidx.core.view.v$f
            void e(View view0, Object object0) {
                this.j(view0, ((CharSequence)object0));
            }

            @Override  // androidx.core.view.v$f
            boolean h(Object object0, Object object1) {
                return this.k(((CharSequence)object0), ((CharSequence)object1));
            }

            CharSequence i(View view0) {
                return m.b(view0);
            }

            void j(View view0, CharSequence charSequence0) {
                m.h(view0, charSequence0);
            }

            boolean k(CharSequence charSequence0, CharSequence charSequence1) {
                return !TextUtils.equals(charSequence0, charSequence1);
            }
        }

        return new androidx.core.view.v.b(b.K, CharSequence.class, 8, 28);
    }

    public static void B(View view0) {
        g.k(view0);
    }

    public static void C(View view0, Runnable runnable0) {
        g.m(view0, runnable0);
    }

    public static void D(View view0, Runnable runnable0, long v) {
        g.n(view0, runnable0, v);
    }

    public static void E(View view0) {
        j.c(view0);
    }

    public static void F(View view0, Context context0, int[] arr_v, AttributeSet attributeSet0, TypedArray typedArray0, int v, int v1) {
        if(Build.VERSION.SDK_INT >= 29) {
            n.c(view0, context0, arr_v, attributeSet0, typedArray0, v, v1);
        }
    }

    private static f G() {
        class androidx.core.view.v.a extends f {
            androidx.core.view.v.a(int v, Class class0, int v1) {
                super(v, class0, v1);
            }

            @Override  // androidx.core.view.v$f
            Object d(View view0) {
                return this.i(view0);
            }

            @Override  // androidx.core.view.v$f
            void e(View view0, Object object0) {
                this.j(view0, ((Boolean)object0));
            }

            @Override  // androidx.core.view.v$f
            boolean h(Object object0, Object object1) {
                return this.k(((Boolean)object0), ((Boolean)object1));
            }

            Boolean i(View view0) {
                return Boolean.valueOf(m.d(view0));
            }

            void j(View view0, Boolean boolean0) {
                m.i(view0, boolean0.booleanValue());
            }

            boolean k(Boolean boolean0, Boolean boolean1) {
                return !this.a(boolean0, boolean1);
            }
        }

        return new androidx.core.view.v.a(b.M, Boolean.class, 28);
    }

    public static void H(View view0, androidx.core.view.a a0) {
        if(a0 == null && v.h(view0) instanceof androidx.core.view.a.a) {
            a0 = new androidx.core.view.a();
        }
        view0.setAccessibilityDelegate((a0 == null ? null : a0.d()));
    }

    public static void I(View view0, CharSequence charSequence0) {
        v.A().g(view0, charSequence0);
        if(charSequence0 != null) {
            v.g.a(view0);
            return;
        }
        v.g.d(view0);
    }

    public static void J(View view0, Drawable drawable0) {
        g.q(view0, drawable0);
    }

    public static void K(View view0, ColorStateList colorStateList0) {
        k.q(view0, colorStateList0);
    }

    public static void L(View view0, PorterDuff.Mode porterDuff$Mode0) {
        k.r(view0, porterDuff$Mode0);
    }

    public static void M(View view0, int v) {
        g.s(view0, v);
    }

    public static void N(View view0, String s) {
        k.v(view0, s);
    }

    private static void O(View view0) {
        if(v.n(view0) == 0) {
            v.M(view0, 1);
        }
        for(ViewParent viewParent0 = view0.getParent(); viewParent0 instanceof View; viewParent0 = viewParent0.getParent()) {
            if(v.n(((View)viewParent0)) == 4) {
                v.M(view0, 2);
                return;
            }
        }
    }

    private static f P() {
        class c extends f {
            c(int v, Class class0, int v1, int v2) {
                super(v, class0, v1, v2);
            }

            @Override  // androidx.core.view.v$f
            Object d(View view0) {
                return this.i(view0);
            }

            @Override  // androidx.core.view.v$f
            void e(View view0, Object object0) {
                this.j(view0, ((CharSequence)object0));
            }

            @Override  // androidx.core.view.v$f
            boolean h(Object object0, Object object1) {
                return this.k(((CharSequence)object0), ((CharSequence)object1));
            }

            CharSequence i(View view0) {
                return o.a(view0);
            }

            void j(View view0, CharSequence charSequence0) {
                o.b(view0, charSequence0);
            }

            boolean k(CharSequence charSequence0, CharSequence charSequence1) {
                return !TextUtils.equals(charSequence0, charSequence1);
            }
        }

        return new c(b.N, CharSequence.class, 0x40, 30);
    }

    public static void Q(View view0) {
        k.z(view0);
    }

    private static f a() {
        class androidx.core.view.v.d extends f {
            androidx.core.view.v.d(int v, Class class0, int v1) {
                super(v, class0, v1);
            }

            @Override  // androidx.core.view.v$f
            Object d(View view0) {
                return this.i(view0);
            }

            @Override  // androidx.core.view.v$f
            void e(View view0, Object object0) {
                this.j(view0, ((Boolean)object0));
            }

            @Override  // androidx.core.view.v$f
            boolean h(Object object0, Object object1) {
                return this.k(((Boolean)object0), ((Boolean)object1));
            }

            Boolean i(View view0) {
                return Boolean.valueOf(m.c(view0));
            }

            void j(View view0, Boolean boolean0) {
                m.g(view0, boolean0.booleanValue());
            }

            boolean k(Boolean boolean0, Boolean boolean1) {
                return !this.a(boolean0, boolean1);
            }
        }

        return new androidx.core.view.v.d(b.J, Boolean.class, 28);
    }

    public static a0 b(View view0, a0 a00, Rect rect0) {
        return k.b(view0, a00, rect0);
    }

    public static a0 c(View view0, a0 a00) {
        WindowInsets windowInsets0 = a00.s();
        if(windowInsets0 != null) {
            WindowInsets windowInsets1 = j.a(view0, windowInsets0);
            return windowInsets1.equals(windowInsets0) ? a00 : a0.u(windowInsets1, view0);
        }
        return a00;
    }

    static boolean d(View view0, KeyEvent keyEvent0) {
        return Build.VERSION.SDK_INT < 28 ? q.a(view0).b(view0, keyEvent0) : false;
    }

    static boolean e(View view0, KeyEvent keyEvent0) {
        return Build.VERSION.SDK_INT < 28 ? q.a(view0).f(keyEvent0) : false;
    }

    static void f(View view0) {
        androidx.core.view.a a0 = v.g(view0);
        if(a0 == null) {
            a0 = new androidx.core.view.a();
        }
        v.H(view0, a0);
    }

    public static androidx.core.view.a g(View view0) {
        View.AccessibilityDelegate view$AccessibilityDelegate0 = v.h(view0);
        if(view$AccessibilityDelegate0 == null) {
            return null;
        }
        return view$AccessibilityDelegate0 instanceof androidx.core.view.a.a ? ((androidx.core.view.a.a)view$AccessibilityDelegate0).a : new androidx.core.view.a(view$AccessibilityDelegate0);
    }

    private static View.AccessibilityDelegate h(View view0) {
        return Build.VERSION.SDK_INT < 29 ? v.i(view0) : n.a(view0);
    }

    private static View.AccessibilityDelegate i(View view0) {
        if(v.d) {
            return null;
        }
        if(v.c == null) {
            try {
                Field field0 = View.class.getDeclaredField("mAccessibilityDelegate");
                v.c = field0;
                field0.setAccessible(true);
            }
            catch(Throwable unused_ex) {
                v.d = true;
                return null;
            }
        }
        try {
            Object object0 = v.c.get(view0);
            return object0 instanceof View.AccessibilityDelegate ? ((View.AccessibilityDelegate)object0) : null;
        }
        catch(Throwable unused_ex) {
            v.d = true;
            return null;
        }
    }

    public static int j(View view0) {
        return i.a(view0);
    }

    public static CharSequence k(View view0) {
        return (CharSequence)v.A().f(view0);
    }

    public static ColorStateList l(View view0) {
        return k.g(view0);
    }

    public static PorterDuff.Mode m(View view0) {
        return k.h(view0);
    }

    public static int n(View view0) {
        return g.c(view0);
    }

    public static int o(View view0) {
        return h.d(view0);
    }

    public static int p(View view0) {
        return g.d(view0);
    }

    public static a0 q(View view0) {
        return l.a(view0);
    }

    public static CharSequence r(View view0) {
        return (CharSequence)v.P().f(view0);
    }

    public static String s(View view0) {
        return k.k(view0);
    }

    public static int t(View view0) {
        return g.g(view0);
    }

    public static boolean u(View view0) {
        Boolean boolean0 = (Boolean)v.a().f(view0);
        return boolean0 != null && boolean0.booleanValue();
    }

    public static boolean v(View view0) {
        return i.b(view0);
    }

    public static boolean w(View view0) {
        return i.c(view0);
    }

    public static boolean x(View view0) {
        Boolean boolean0 = (Boolean)v.G().f(view0);
        return boolean0 != null && boolean0.booleanValue();
    }

    static void y(View view0, int v) {
        AccessibilityManager accessibilityManager0 = (AccessibilityManager)view0.getContext().getSystemService("accessibility");
        if(!accessibilityManager0.isEnabled()) {
            return;
        }
        boolean z = v.k(view0) != null && view0.isShown() && view0.getWindowVisibility() == 0;
        int v1 = 0x20;
        if(v.j(view0) != 0 || z) {
            AccessibilityEvent accessibilityEvent1 = AccessibilityEvent.obtain();
            if(!z) {
                v1 = 0x800;
            }
            accessibilityEvent1.setEventType(v1);
            i.g(accessibilityEvent1, v);
            if(z) {
                accessibilityEvent1.getText().add(v.k(view0));
                v.O(view0);
            }
            view0.sendAccessibilityEventUnchecked(accessibilityEvent1);
        }
        else {
            if(v == 0x20) {
                AccessibilityEvent accessibilityEvent0 = AccessibilityEvent.obtain();
                view0.onInitializeAccessibilityEvent(accessibilityEvent0);
                accessibilityEvent0.setEventType(0x20);
                i.g(accessibilityEvent0, 0x20);
                accessibilityEvent0.setSource(view0);
                view0.onPopulateAccessibilityEvent(accessibilityEvent0);
                accessibilityEvent0.getText().add(v.k(view0));
                accessibilityManager0.sendAccessibilityEvent(accessibilityEvent0);
                return;
            }
            if(view0.getParent() != null) {
                ViewParent viewParent0 = view0.getParent();
                try {
                    i.e(viewParent0, view0, view0, v);
                }
                catch(AbstractMethodError abstractMethodError0) {
                    Log.e("ViewCompat", view0.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", abstractMethodError0);
                }
            }
        }
    }

    public static a0 z(View view0, a0 a00) {
        WindowInsets windowInsets0 = a00.s();
        if(windowInsets0 != null) {
            WindowInsets windowInsets1 = j.b(view0, windowInsets0);
            return windowInsets1.equals(windowInsets0) ? a00 : a0.u(windowInsets1, view0);
        }
        return a00;
    }
}

