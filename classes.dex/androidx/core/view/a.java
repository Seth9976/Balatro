package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.u;
import androidx.core.view.accessibility.v;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class a {
    static final class androidx.core.view.a.a extends View.AccessibilityDelegate {
        final a a;

        androidx.core.view.a.a(a a0) {
            this.a = a0;
        }

        @Override  // android.view.View$AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
            return this.a.a(view0, accessibilityEvent0);
        }

        @Override  // android.view.View$AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view0) {
            v v0 = this.a.b(view0);
            return v0 == null ? null : ((AccessibilityNodeProvider)v0.a());
        }

        @Override  // android.view.View$AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
            this.a.f(view0, accessibilityEvent0);
        }

        @Override  // android.view.View$AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
            u u0 = u.P(accessibilityNodeInfo0);
            u0.L(androidx.core.view.v.x(view0));
            u0.J(androidx.core.view.v.u(view0));
            u0.K(androidx.core.view.v.k(view0));
            u0.N(androidx.core.view.v.r(view0));
            this.a.g(view0, u0);
            u0.c(accessibilityNodeInfo0.getText(), view0);
            List list0 = a.c(view0);
            for(int v = 0; v < list0.size(); ++v) {
                u0.a(((androidx.core.view.accessibility.u.a)list0.get(v)));
            }
        }

        @Override  // android.view.View$AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
            this.a.h(view0, accessibilityEvent0);
        }

        @Override  // android.view.View$AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup0, View view0, AccessibilityEvent accessibilityEvent0) {
            return this.a.i(viewGroup0, view0, accessibilityEvent0);
        }

        @Override  // android.view.View$AccessibilityDelegate
        public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
            return this.a.j(view0, v, bundle0);
        }

        @Override  // android.view.View$AccessibilityDelegate
        public void sendAccessibilityEvent(View view0, int v) {
            this.a.l(view0, v);
        }

        @Override  // android.view.View$AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view0, AccessibilityEvent accessibilityEvent0) {
            this.a.m(view0, accessibilityEvent0);
        }
    }

    static abstract class b {
        static AccessibilityNodeProvider a(View.AccessibilityDelegate view$AccessibilityDelegate0, View view0) {
            return view$AccessibilityDelegate0.getAccessibilityNodeProvider(view0);
        }

        static boolean b(View.AccessibilityDelegate view$AccessibilityDelegate0, View view0, int v, Bundle bundle0) {
            return view$AccessibilityDelegate0.performAccessibilityAction(view0, v, bundle0);
        }
    }

    private final View.AccessibilityDelegate a;
    private final View.AccessibilityDelegate b;
    private static final View.AccessibilityDelegate c;

    static {
        a.c = new View.AccessibilityDelegate();
    }

    public a() {
        this(a.c);
    }

    public a(View.AccessibilityDelegate view$AccessibilityDelegate0) {
        this.a = view$AccessibilityDelegate0;
        this.b = new androidx.core.view.a.a(this);
    }

    public boolean a(View view0, AccessibilityEvent accessibilityEvent0) {
        return this.a.dispatchPopulateAccessibilityEvent(view0, accessibilityEvent0);
    }

    public v b(View view0) {
        AccessibilityNodeProvider accessibilityNodeProvider0 = b.a(this.a, view0);
        return accessibilityNodeProvider0 == null ? null : new v(accessibilityNodeProvider0);
    }

    static List c(View view0) {
        List list0 = (List)view0.getTag(l.b.H);
        return list0 == null ? Collections.emptyList() : list0;
    }

    View.AccessibilityDelegate d() {
        return this.b;
    }

    private boolean e(ClickableSpan clickableSpan0, View view0) {
        if(clickableSpan0 != null) {
            ClickableSpan[] arr_clickableSpan = u.k(view0.createAccessibilityNodeInfo().getText());
            for(int v = 0; arr_clickableSpan != null && v < arr_clickableSpan.length; ++v) {
                if(clickableSpan0.equals(arr_clickableSpan[v])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void f(View view0, AccessibilityEvent accessibilityEvent0) {
        this.a.onInitializeAccessibilityEvent(view0, accessibilityEvent0);
    }

    public void g(View view0, u u0) {
        AccessibilityNodeInfo accessibilityNodeInfo0 = u0.O();
        this.a.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
    }

    public void h(View view0, AccessibilityEvent accessibilityEvent0) {
        this.a.onPopulateAccessibilityEvent(view0, accessibilityEvent0);
    }

    public boolean i(ViewGroup viewGroup0, View view0, AccessibilityEvent accessibilityEvent0) {
        return this.a.onRequestSendAccessibilityEvent(viewGroup0, view0, accessibilityEvent0);
    }

    public boolean j(View view0, int v, Bundle bundle0) {
        List list0 = a.c(view0);
        for(int v1 = 0; v1 < list0.size() && ((androidx.core.view.accessibility.u.a)list0.get(v1)).a() != v; ++v1) {
        }
        boolean z = b.b(this.a, view0, v, bundle0);
        return z || v != l.b.a || bundle0 == null ? z : this.k(bundle0.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view0);
    }

    private boolean k(int v, View view0) {
        SparseArray sparseArray0 = (SparseArray)view0.getTag(l.b.I);
        if(sparseArray0 != null) {
            WeakReference weakReference0 = (WeakReference)sparseArray0.get(v);
            if(weakReference0 != null) {
                ClickableSpan clickableSpan0 = (ClickableSpan)weakReference0.get();
                if(this.e(clickableSpan0, view0)) {
                    clickableSpan0.onClick(view0);
                    return true;
                }
            }
        }
        return false;
    }

    public void l(View view0, int v) {
        this.a.sendAccessibilityEvent(view0, v);
    }

    public void m(View view0, AccessibilityEvent accessibilityEvent0) {
        this.a.sendAccessibilityEventUnchecked(view0, accessibilityEvent0);
    }
}

