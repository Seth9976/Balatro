package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class u {
    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;
        public static final a Q;
        public static final a R;
        public static final a S;
        public static final a T;
        final Object a;
        private final int b;
        private final Class c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final a j;
        public static final a k;
        public static final a l;
        public static final a m;
        public static final a n;
        public static final a o;
        public static final a p;
        public static final a q;
        public static final a r;
        public static final a s;
        public static final a t;
        public static final a u;
        public static final a v;
        public static final a w;
        public static final a x;
        public static final a y;
        public static final a z;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityNodeInfo$AccessibilityAction0 = null;
            a.d = new a(1, null);
            a.e = new a(2, null);
            a.f = new a(4, null);
            a.g = new a(8, null);
            a.h = new a(16, null);
            a.i = new a(0x20, null);
            a.j = new a(0x40, null);
            a.k = new a(0x80, null);
            a.l = new a(0x100, null, b.class);
            a.m = new a(0x200, null, b.class);
            a.n = new a(0x400, null, c.class);
            a.o = new a(0x800, null, c.class);
            a.p = new a(0x1000, null);
            a.q = new a(0x2000, null);
            a.r = new a(0x4000, null);
            a.s = new a(0x8000, null);
            a.t = new a(0x10000, null);
            a.u = new a(0x20000, null, g.class);
            a.v = new a(0x40000, null);
            a.w = new a(0x80000, null);
            a.x = new a(0x100000, null);
            a.y = new a(0x200000, null, h.class);
            int v = Build.VERSION.SDK_INT;
            a.z = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, 0x1020036, null, null, null);
            a.A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, 0x1020037, null, null, e.class);
            a.B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, 0x1020038, null, null, null);
            a.C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, 0x1020039, null, null, null);
            a.D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, 0x102003A, null, null, null);
            a.E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, 0x102003B, null, null, null);
            a.F = new a((v < 29 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP), 0x1020046, null, null, null);
            a.G = new a((v < 29 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN), 0x1020047, null, null, null);
            a.H = new a((v < 29 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT), 0x1020048, null, null, null);
            a.I = new a((v < 29 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT), 0x1020049, null, null, null);
            a.J = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, 0x102003C, null, null, null);
            a.K = new a((v < 24 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS), 0x102003D, null, null, f.class);
            a.L = new a((v < 26 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW), 0x1020042, null, null, d.class);
            a.M = new a((v < 28 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP), 0x1020044, null, null, null);
            a.N = new a((v < 28 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP), 0x1020045, null, null, null);
            a.O = new a((v < 30 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD), 0x102004A, null, null, null);
            a.P = new a((v < 30 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER), 0x1020054, null, null, null);
            a.Q = new a((v < 0x20 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START), 0x1020055, null, null, null);
            a.R = new a((v < 0x20 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP), 0x1020056, null, null, null);
            a.S = new a((v < 0x20 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL), 0x1020057, null, null, null);
            if(v >= 33) {
                accessibilityNodeInfo$AccessibilityAction0 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
            }
            a.T = new a(accessibilityNodeInfo$AccessibilityAction0, 0x1020058, null, null, null);
        }

        public a(int v, CharSequence charSequence0) {
            this(null, v, charSequence0, null, null);
        }

        private a(int v, CharSequence charSequence0, Class class0) {
            this(null, v, charSequence0, null, class0);
        }

        a(Object object0) {
            this(object0, 0, null, null, null);
        }

        a(Object object0, int v, CharSequence charSequence0, x x0, Class class0) {
            this.b = v;
            if(object0 == null) {
                object0 = new AccessibilityNodeInfo.AccessibilityAction(v, charSequence0);
            }
            this.a = object0;
            this.c = class0;
        }

        public int a() {
            return ((AccessibilityNodeInfo.AccessibilityAction)this.a).getId();
        }

        public CharSequence b() {
            return ((AccessibilityNodeInfo.AccessibilityAction)this.a).getLabel();
        }

        public boolean c(View view0, Bundle bundle0) [...] // Inlined contents

        @Override
        public boolean equals(Object object0) {
            if(!(object0 instanceof a)) {
                return false;
            }
            Object object1 = ((a)object0).a;
            return this.a == null ? object1 == null : this.a.equals(object1);
        }

        @Override
        public int hashCode() {
            return this.a == null ? 0 : this.a.hashCode();
        }
    }

    private final AccessibilityNodeInfo a;
    public int b;
    private int c;
    private static int d;

    static {
    }

    private u(AccessibilityNodeInfo accessibilityNodeInfo0) {
        this.b = -1;
        this.c = -1;
        this.a = accessibilityNodeInfo0;
    }

    public boolean A() {
        return this.a.isFocused();
    }

    public boolean B() {
        return this.a.isLongClickable();
    }

    public boolean C() {
        return this.a.isPassword();
    }

    public boolean D() {
        return this.a.isScrollable();
    }

    public boolean E() {
        return this.a.isSelected();
    }

    public boolean F(int v, Bundle bundle0) {
        return this.a.performAction(v, bundle0);
    }

    private void G(View view0) {
        SparseArray sparseArray0 = this.p(view0);
        if(sparseArray0 != null) {
            ArrayList arrayList0 = new ArrayList();
            for(int v1 = 0; v1 < sparseArray0.size(); ++v1) {
                if(((WeakReference)sparseArray0.valueAt(v1)).get() == null) {
                    arrayList0.add(v1);
                }
            }
            for(int v = 0; v < arrayList0.size(); ++v) {
                sparseArray0.remove(((int)(((Integer)arrayList0.get(v)))));
            }
        }
    }

    private void H(int v, boolean z) {
        Bundle bundle0 = this.m();
        if(bundle0 != null) {
            int v1 = bundle0.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & ~v;
            if(!z) {
                v = 0;
            }
            bundle0.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", v | v1);
        }
    }

    public void I(CharSequence charSequence0) {
        this.a.setClassName(charSequence0);
    }

    public void J(boolean z) {
        if(Build.VERSION.SDK_INT >= 28) {
            this.a.setHeading(z);
            return;
        }
        this.H(2, z);
    }

    public void K(CharSequence charSequence0) {
        if(Build.VERSION.SDK_INT >= 28) {
            this.a.setPaneTitle(charSequence0);
            return;
        }
        this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence0);
    }

    public void L(boolean z) {
        if(Build.VERSION.SDK_INT >= 28) {
            this.a.setScreenReaderFocusable(z);
            return;
        }
        this.H(1, z);
    }

    public void M(boolean z) {
        this.a.setScrollable(z);
    }

    public void N(CharSequence charSequence0) {
        this.a.setStateDescription(charSequence0);
    }

    public AccessibilityNodeInfo O() {
        return this.a;
    }

    public static u P(AccessibilityNodeInfo accessibilityNodeInfo0) {
        return new u(accessibilityNodeInfo0);
    }

    public void a(a u$a0) {
        this.a.addAction(((AccessibilityNodeInfo.AccessibilityAction)u$a0.a));
    }

    private void b(ClickableSpan clickableSpan0, Spanned spanned0, int v) {
        this.e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(spanned0.getSpanStart(clickableSpan0));
        this.e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(spanned0.getSpanEnd(clickableSpan0));
        this.e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(spanned0.getSpanFlags(clickableSpan0));
        this.e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(v);
    }

    public void c(CharSequence charSequence0, View view0) {
        if(Build.VERSION.SDK_INT < 26) {
            this.d();
            this.G(view0);
            ClickableSpan[] arr_clickableSpan = u.k(charSequence0);
            if(arr_clickableSpan != null && arr_clickableSpan.length > 0) {
                this.m().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", l.b.a);
                SparseArray sparseArray0 = this.n(view0);
                for(int v = 0; v < arr_clickableSpan.length; ++v) {
                    int v1 = this.u(arr_clickableSpan[v], sparseArray0);
                    sparseArray0.put(v1, new WeakReference(arr_clickableSpan[v]));
                    this.b(arr_clickableSpan[v], ((Spanned)charSequence0), v1);
                }
            }
        }
    }

    private void d() {
        this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private List e(String s) {
        List list0 = this.a.getExtras().getIntegerArrayList(s);
        if(list0 == null) {
            list0 = new ArrayList();
            this.a.getExtras().putIntegerArrayList(s, ((ArrayList)list0));
        }
        return list0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof u)) {
            return false;
        }
        AccessibilityNodeInfo accessibilityNodeInfo0 = this.a;
        if(accessibilityNodeInfo0 == null) {
            if(((u)object0).a != null) {
                return false;
            }
        }
        else if(!accessibilityNodeInfo0.equals(((u)object0).a)) {
            return false;
        }
        return this.c == ((u)object0).c ? this.b == ((u)object0).b : false;
    }

    public List f() {
        List list0 = this.a.getActionList();
        if(list0 != null) {
            List list1 = new ArrayList();
            int v = list0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                list1.add(new a(list0.get(v1)));
            }
            return list1;
        }
        return Collections.emptyList();
    }

    private static String g(int v) {
        switch(v) {
            case 1: {
                return "ACTION_FOCUS";
            }
            case 2: {
                return "ACTION_CLEAR_FOCUS";
            }
            case 4: {
                return "ACTION_SELECT";
            }
            case 8: {
                return "ACTION_CLEAR_SELECTION";
            }
            case 16: {
                return "ACTION_CLICK";
            }
            case 0x20: {
                return "ACTION_LONG_CLICK";
            }
            case 0x40: {
                return "ACTION_ACCESSIBILITY_FOCUS";
            }
            case 0x80: {
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            }
            case 0x100: {
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            }
            case 0x200: {
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            }
            case 0x400: {
                return "ACTION_NEXT_HTML_ELEMENT";
            }
            case 0x800: {
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            }
            case 0x1000: {
                return "ACTION_SCROLL_FORWARD";
            }
            case 0x2000: {
                return "ACTION_SCROLL_BACKWARD";
            }
            case 0x4000: {
                return "ACTION_COPY";
            }
            case 0x8000: {
                return "ACTION_PASTE";
            }
            case 0x10000: {
                return "ACTION_CUT";
            }
            case 0x20000: {
                return "ACTION_SET_SELECTION";
            }
            case 0x40000: {
                return "ACTION_EXPAND";
            }
            case 0x80000: {
                return "ACTION_COLLAPSE";
            }
            case 0x200000: {
                return "ACTION_SET_TEXT";
            }
            case 0x1020036: {
                return "ACTION_SHOW_ON_SCREEN";
            }
            case 0x1020037: {
                return "ACTION_SCROLL_TO_POSITION";
            }
            case 0x1020038: {
                return "ACTION_SCROLL_UP";
            }
            case 0x1020039: {
                return "ACTION_SCROLL_LEFT";
            }
            case 0x102003A: {
                return "ACTION_SCROLL_DOWN";
            }
            case 0x102003B: {
                return "ACTION_SCROLL_RIGHT";
            }
            case 0x102003C: {
                return "ACTION_CONTEXT_CLICK";
            }
            case 0x102003D: {
                return "ACTION_SET_PROGRESS";
            }
            case 0x1020042: {
                return "ACTION_MOVE_WINDOW";
            }
            case 0x1020044: {
                return "ACTION_SHOW_TOOLTIP";
            }
            case 0x1020045: {
                return "ACTION_HIDE_TOOLTIP";
            }
            case 0x1020046: {
                return "ACTION_PAGE_UP";
            }
            case 0x1020047: {
                return "ACTION_PAGE_DOWN";
            }
            case 0x1020048: {
                return "ACTION_PAGE_LEFT";
            }
            case 0x1020049: {
                return "ACTION_PAGE_RIGHT";
            }
            case 0x102004A: {
                return "ACTION_PRESS_AND_HOLD";
            }
            case 0x1020054: {
                return "ACTION_IME_ENTER";
            }
            case 0x1020055: {
                return "ACTION_DRAG_START";
            }
            case 0x1020056: {
                return "ACTION_DRAG_DROP";
            }
            case 0x1020057: {
                return "ACTION_DRAG_CANCEL";
            }
            default: {
                return "ACTION_UNKNOWN";
            }
        }
    }

    public void h(Rect rect0) {
        this.a.getBoundsInParent(rect0);
    }

    @Override
    public int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    public void i(Rect rect0) {
        this.a.getBoundsInScreen(rect0);
    }

    public CharSequence j() {
        return this.a.getClassName();
    }

    // 去混淆评级： 低(20)
    public static ClickableSpan[] k(CharSequence charSequence0) {
        return charSequence0 instanceof Spanned ? ((ClickableSpan[])((Spanned)charSequence0).getSpans(0, charSequence0.length(), ClickableSpan.class)) : null;
    }

    public CharSequence l() {
        return this.a.getContentDescription();
    }

    public Bundle m() {
        return this.a.getExtras();
    }

    private SparseArray n(View view0) {
        SparseArray sparseArray0 = this.p(view0);
        if(sparseArray0 == null) {
            sparseArray0 = new SparseArray();
            view0.setTag(l.b.I, sparseArray0);
        }
        return sparseArray0;
    }

    public CharSequence o() {
        return this.a.getPackageName();
    }

    private SparseArray p(View view0) {
        return (SparseArray)view0.getTag(l.b.I);
    }

    public CharSequence q() {
        if(this.t()) {
            List list0 = this.e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List list1 = this.e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List list2 = this.e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List list3 = this.e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            CharSequence charSequence0 = new SpannableString(TextUtils.substring(this.a.getText(), 0, this.a.getText().length()));
            for(int v = 0; v < list0.size(); ++v) {
                ((Spannable)charSequence0).setSpan(new androidx.core.view.accessibility.a(((int)(((Integer)list3.get(v)))), this, this.m().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((int)(((Integer)list0.get(v)))), ((int)(((Integer)list1.get(v)))), ((int)(((Integer)list2.get(v)))));
            }
            return charSequence0;
        }
        return this.a.getText();
    }

    // 去混淆评级： 低(30)
    public String r() {
        return this.a.getUniqueId();
    }

    public String s() {
        return this.a.getViewIdResourceName();
    }

    private boolean t() {
        return !this.e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(super.toString());
        Rect rect0 = new Rect();
        this.h(rect0);
        stringBuilder0.append("; boundsInParent: " + rect0);
        this.i(rect0);
        stringBuilder0.append("; boundsInScreen: " + rect0);
        stringBuilder0.append("; packageName: ");
        stringBuilder0.append(this.o());
        stringBuilder0.append("; className: ");
        stringBuilder0.append(this.j());
        stringBuilder0.append("; text: ");
        stringBuilder0.append(this.q());
        stringBuilder0.append("; contentDescription: ");
        stringBuilder0.append(this.l());
        stringBuilder0.append("; viewId: ");
        stringBuilder0.append(this.s());
        stringBuilder0.append("; uniqueId: ");
        stringBuilder0.append(this.r());
        stringBuilder0.append("; checkable: ");
        stringBuilder0.append(this.v());
        stringBuilder0.append("; checked: ");
        stringBuilder0.append(this.w());
        stringBuilder0.append("; focusable: ");
        stringBuilder0.append(this.z());
        stringBuilder0.append("; focused: ");
        stringBuilder0.append(this.A());
        stringBuilder0.append("; selected: ");
        stringBuilder0.append(this.E());
        stringBuilder0.append("; clickable: ");
        stringBuilder0.append(this.x());
        stringBuilder0.append("; longClickable: ");
        stringBuilder0.append(this.B());
        stringBuilder0.append("; enabled: ");
        stringBuilder0.append(this.y());
        stringBuilder0.append("; password: ");
        stringBuilder0.append(this.C());
        stringBuilder0.append("; scrollable: " + this.D());
        stringBuilder0.append("; [");
        List list0 = this.f();
        for(int v = 0; v < list0.size(); ++v) {
            a u$a0 = (a)list0.get(v);
            String s = u.g(u$a0.a());
            if(s.equals("ACTION_UNKNOWN") && u$a0.b() != null) {
                s = u$a0.b().toString();
            }
            stringBuilder0.append(s);
            if(v != list0.size() - 1) {
                stringBuilder0.append(", ");
            }
        }
        stringBuilder0.append("]");
        return stringBuilder0.toString();
    }

    private int u(ClickableSpan clickableSpan0, SparseArray sparseArray0) {
        if(sparseArray0 != null) {
            for(int v = 0; v < sparseArray0.size(); ++v) {
                if(clickableSpan0.equals(((ClickableSpan)((WeakReference)sparseArray0.valueAt(v)).get()))) {
                    return sparseArray0.keyAt(v);
                }
            }
        }
        int v1 = u.d;
        u.d = v1 + 1;
        return v1;
    }

    public boolean v() {
        return this.a.isCheckable();
    }

    public boolean w() {
        return this.a.isChecked();
    }

    public boolean x() {
        return this.a.isClickable();
    }

    public boolean y() {
        return this.a.isEnabled();
    }

    public boolean z() {
        return this.a.isFocusable();
    }
}

