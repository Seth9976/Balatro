package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class v extends ListView {
    static abstract class a {
        static void a(View view0, float f, float f1) {
            view0.drawableHotspotChanged(f, f1);
        }
    }

    static abstract class b {
        private static Method a;
        private static Method b;
        private static Method c;
        private static boolean d;

        static {
            try {
                Class[] arr_class = new Class[5];
                Class class0 = Integer.TYPE;
                arr_class[0] = class0;
                arr_class[1] = View.class;
                arr_class[2] = Boolean.TYPE;
                arr_class[3] = Float.TYPE;
                arr_class[4] = Float.TYPE;
                Method method0 = AbsListView.class.getDeclaredMethod("positionSelector", arr_class);
                b.a = method0;
                method0.setAccessible(true);
                Method method1 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", class0);
                b.b = method1;
                method1.setAccessible(true);
                Method method2 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", class0);
                b.c = method2;
                method2.setAccessible(true);
                b.d = true;
            }
            catch(NoSuchMethodException noSuchMethodException0) {
                noSuchMethodException0.printStackTrace();
            }
        }

        static boolean a() [...] // 潜在的解密器

        static void b(v v0, int v1, View view0) {
            try {
                b.a.invoke(v0, v1, view0, Boolean.FALSE, -1, -1);
                b.b.invoke(v0, v1);
                b.c.invoke(v0, v1);
            }
            catch(IllegalAccessException | InvocationTargetException illegalAccessException0) {
                illegalAccessException0.printStackTrace();
            }
        }
    }

    static abstract class c {
        static boolean a(AbsListView absListView0) {
            return absListView0.isSelectedChildViewEnabled();
        }

        static void b(AbsListView absListView0, boolean z) {
            absListView0.setSelectedChildViewEnabled(z);
        }
    }

    static class d extends f.c {
        private boolean b;

        d(Drawable drawable0) {
            super(drawable0);
            this.b = true;
        }

        void b(boolean z) {
            this.b = z;
        }

        @Override  // f.c
        public void draw(Canvas canvas0) {
            if(this.b) {
                super.draw(canvas0);
            }
        }

        @Override  // f.c
        public void setHotspot(float f, float f1) {
            if(this.b) {
                super.setHotspot(f, f1);
            }
        }

        @Override  // f.c
        public void setHotspotBounds(int v, int v1, int v2, int v3) {
            if(this.b) {
                super.setHotspotBounds(v, v1, v2, v3);
            }
        }

        // 去混淆评级： 低(20)
        @Override  // f.c
        public boolean setState(int[] arr_v) {
            return this.b ? super.setState(arr_v) : false;
        }

        // 去混淆评级： 低(20)
        @Override  // f.c
        public boolean setVisible(boolean z, boolean z1) {
            return this.b ? super.setVisible(z, z1) : false;
        }
    }

    static abstract class e {
        private static final Field a;

        static {
            Field field0 = null;
            try {
                field0 = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                field0.setAccessible(true);
            }
            catch(NoSuchFieldException noSuchFieldException0) {
                noSuchFieldException0.printStackTrace();
            }
            e.a = field0;
        }

        static boolean a(AbsListView absListView0) {
            Field field0 = e.a;
            if(field0 != null) {
                try {
                    return field0.getBoolean(absListView0);
                }
                catch(IllegalAccessException illegalAccessException0) {
                    illegalAccessException0.printStackTrace();
                }
            }
            return false;
        }

        static void b(AbsListView absListView0, boolean z) {
            Field field0 = e.a;
            if(field0 != null) {
                try {
                    field0.set(absListView0, Boolean.valueOf(z));
                }
                catch(IllegalAccessException illegalAccessException0) {
                    illegalAccessException0.printStackTrace();
                }
            }
        }
    }

    class f implements Runnable {
        final v e;

        public void a() {
            v.this.l = null;
            v.this.removeCallbacks(this);
        }

        public void b() {
            v.this.post(this);
        }

        @Override
        public void run() {
            v.this.l = null;
            v.this.drawableStateChanged();
        }
    }

    private final Rect a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private d g;
    private boolean h;
    private boolean i;
    private boolean j;
    private androidx.core.widget.d k;
    f l;

    v(Context context0, boolean z) {
        super(context0, null, c.a.n);
        this.a = new Rect();
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.i = z;
        this.setCacheColorHint(0);
    }

    private void a() {
        this.j = false;
        this.setPressed(false);
        this.drawableStateChanged();
        View view0 = this.getChildAt(this.f - this.getFirstVisiblePosition());
        if(view0 != null) {
            view0.setPressed(false);
        }
    }

    private void b(View view0, int v) {
        this.performItemClick(view0, v, this.getItemIdAtPosition(v));
    }

    private void c(Canvas canvas0) {
        if(!this.a.isEmpty()) {
            Drawable drawable0 = this.getSelector();
            if(drawable0 != null) {
                drawable0.setBounds(this.a);
                drawable0.draw(canvas0);
            }
        }
    }

    public int d(int v, int v1, int v2, int v3, int v4) {
        int v5 = this.getListPaddingTop();
        int v6 = this.getListPaddingBottom();
        int v7 = this.getDividerHeight();
        Drawable drawable0 = this.getDivider();
        ListAdapter listAdapter0 = this.getAdapter();
        int v8 = v5 + v6;
        if(listAdapter0 == null) {
            return v8;
        }
        if(v7 <= 0 || drawable0 == null) {
            v7 = 0;
        }
        int v9 = listAdapter0.getCount();
        int v11 = 0;
        int v12 = 0;
        View view0 = null;
        for(int v10 = 0; v10 < v9; ++v10) {
            int v13 = listAdapter0.getItemViewType(v10);
            if(v13 != v11) {
                view0 = null;
                v11 = v13;
            }
            view0 = listAdapter0.getView(v10, view0, this);
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
            if(viewGroup$LayoutParams0 == null) {
                viewGroup$LayoutParams0 = this.generateDefaultLayoutParams();
                view0.setLayoutParams(viewGroup$LayoutParams0);
            }
            view0.measure(v, (viewGroup$LayoutParams0.height <= 0 ? 0 : View.MeasureSpec.makeMeasureSpec(viewGroup$LayoutParams0.height, 0x40000000)));
            view0.forceLayout();
            if(v10 > 0) {
                v8 += v7;
            }
            v8 += view0.getMeasuredHeight();
            if(v8 >= v3) {
                return v4 < 0 || v10 <= v4 || v12 <= 0 || v8 == v3 ? v3 : v12;
            }
            if(v4 >= 0 && v10 >= v4) {
                v12 = v8;
            }
        }
        return v8;
    }

    @Override  // android.widget.ListView
    protected void dispatchDraw(Canvas canvas0) {
        this.c(canvas0);
        super.dispatchDraw(canvas0);
    }

    @Override  // android.widget.AbsListView
    protected void drawableStateChanged() {
        if(this.l != null) {
            return;
        }
        super.drawableStateChanged();
        this.j(true);
        this.n();
    }

    public boolean e(MotionEvent motionEvent0, int v) {
        boolean z1;
        boolean z;
        int v1 = motionEvent0.getActionMasked();
        switch(v1) {
            case 1: {
                z = false;
                goto label_8;
            }
            case 2: {
                z = true;
            label_8:
                int v2 = motionEvent0.findPointerIndex(v);
                if(v2 >= 0) {
                    int v3 = (int)motionEvent0.getX(v2);
                    int v4 = (int)motionEvent0.getY(v2);
                    int v5 = this.pointToPosition(v3, v4);
                    if(v5 == -1) {
                        z1 = true;
                    }
                    else {
                        View view0 = this.getChildAt(v5 - this.getFirstVisiblePosition());
                        this.i(view0, v5, ((float)v3), ((float)v4));
                        if(v1 == 1) {
                            this.b(view0, v5);
                        }
                        z = true;
                        z1 = false;
                    }
                }
                else {
                    z1 = false;
                    z = false;
                }
                break;
            }
            case 3: {
                z1 = false;
                z = false;
                break;
            }
            default: {
                z = true;
                z1 = false;
            }
        }
        if(!z || z1) {
            this.a();
        }
        if(z) {
            if(this.k == null) {
                this.k = new androidx.core.widget.d(this);
            }
            this.k.m(true);
            this.k.onTouch(this, motionEvent0);
            return true;
        }
        androidx.core.widget.d d0 = this.k;
        if(d0 != null) {
            d0.m(false);
        }
        return false;
    }

    private void f(int v, View view0) {
        int v1 = view0.getLeft();
        int v2 = view0.getTop();
        int v3 = view0.getRight();
        int v4 = view0.getBottom();
        this.a.set(v1, v2, v3, v4);
        this.a.left -= this.b;
        this.a.top -= this.c;
        this.a.right += this.d;
        this.a.bottom += this.e;
        boolean z = this.k();
        if(view0.isEnabled() != z) {
            this.l(!z);
            if(v != -1) {
                this.refreshDrawableState();
            }
        }
    }

    private void g(int v, View view0) {
        Drawable drawable0 = this.getSelector();
        boolean z = true;
        boolean z1 = drawable0 != null && v != -1;
        if(z1) {
            drawable0.setVisible(false, false);
        }
        this.f(v, view0);
        if(z1) {
            float f = this.a.exactCenterX();
            float f1 = this.a.exactCenterY();
            if(this.getVisibility() != 0) {
                z = false;
            }
            drawable0.setVisible(z, false);
            androidx.core.graphics.drawable.a.j(drawable0, f, f1);
        }
    }

    private void h(int v, View view0, float f, float f1) {
        this.g(v, view0);
        Drawable drawable0 = this.getSelector();
        if(drawable0 != null && v != -1) {
            androidx.core.graphics.drawable.a.j(drawable0, f, f1);
        }
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public boolean hasFocus() {
        return this.i || super.hasFocus();
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.View
    public boolean hasWindowFocus() {
        return this.i || super.hasWindowFocus();
    }

    private void i(View view0, int v, float f, float f1) {
        this.j = true;
        a.a(this, f, f1);
        if(!this.isPressed()) {
            this.setPressed(true);
        }
        this.layoutChildren();
        int v1 = this.f;
        if(v1 != -1) {
            View view1 = this.getChildAt(v1 - this.getFirstVisiblePosition());
            if(view1 != null && view1 != view0 && view1.isPressed()) {
                view1.setPressed(false);
            }
        }
        this.f = v;
        a.a(view0, f - ((float)view0.getLeft()), f1 - ((float)view0.getTop()));
        if(!view0.isPressed()) {
            view0.setPressed(true);
        }
        this.h(v, view0, f, f1);
        this.j(false);
        this.refreshDrawableState();
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.View
    public boolean isFocused() {
        return this.i || super.isFocused();
    }

    // 去混淆评级： 低(30)
    @Override  // android.view.View
    public boolean isInTouchMode() {
        return this.i && this.h || super.isInTouchMode();
    }

    private void j(boolean z) {
        d v$d0 = this.g;
        if(v$d0 != null) {
            v$d0.b(z);
        }
    }

    // 去混淆评级： 低(30)
    private boolean k() {
        return c.a(this);
    }

    private void l(boolean z) {
        c.b(this, z);
    }

    private boolean m() {
        return this.j;
    }

    private void n() {
        Drawable drawable0 = this.getSelector();
        if(drawable0 != null && this.m() && this.isPressed()) {
            drawable0.setState(this.getDrawableState());
        }
    }

    @Override  // android.widget.ListView
    protected void onDetachedFromWindow() {
        this.l = null;
        super.onDetachedFromWindow();
    }

    @Override  // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent0) {
        if(Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent0);
        }
        int v = motionEvent0.getActionMasked();
        if(v == 10 && this.l == null) {
            f v$f0 = new f(this);
            this.l = v$f0;
            v$f0.b();
        }
        boolean z = super.onHoverEvent(motionEvent0);
        if(v != 7 && v != 9) {
            this.setSelection(-1);
            return z;
        }
        int v1 = this.pointToPosition(((int)motionEvent0.getX()), ((int)motionEvent0.getY()));
        if(v1 != -1 && v1 != this.getSelectedItemPosition()) {
            View view0 = this.getChildAt(v1 - this.getFirstVisiblePosition());
            if(view0.isEnabled()) {
                this.requestFocus();
                this.setSelectionFromTop(v1, view0.getTop() - this.getTop());
            }
            this.n();
        }
        return z;
    }

    @Override  // android.widget.AbsListView
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        if(motionEvent0.getAction() == 0) {
            this.f = this.pointToPosition(((int)motionEvent0.getX()), ((int)motionEvent0.getY()));
        }
        f v$f0 = this.l;
        if(v$f0 != null) {
            v$f0.a();
        }
        return super.onTouchEvent(motionEvent0);
    }

    void setListSelectionHidden(boolean z) {
        this.h = z;
    }

    @Override  // android.widget.AbsListView
    public void setSelector(Drawable drawable0) {
        d v$d0 = drawable0 == null ? null : new d(drawable0);
        this.g = v$d0;
        super.setSelector(v$d0);
        Rect rect0 = new Rect();
        if(drawable0 != null) {
            drawable0.getPadding(rect0);
        }
        this.b = rect0.left;
        this.c = rect0.top;
        this.d = rect0.right;
        this.e = rect0.bottom;
    }
}

