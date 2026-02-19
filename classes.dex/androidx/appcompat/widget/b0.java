package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.e;
import java.lang.reflect.Method;

public class b0 extends z implements a0 {
    static abstract class a {
        static void a(PopupWindow popupWindow0, Transition transition0) {
            popupWindow0.setEnterTransition(transition0);
        }

        static void b(PopupWindow popupWindow0, Transition transition0) {
            popupWindow0.setExitTransition(transition0);
        }
    }

    static abstract class b {
        static void a(PopupWindow popupWindow0, boolean z) {
            popupWindow0.setTouchModal(z);
        }
    }

    public static class c extends v {
        static abstract class androidx.appcompat.widget.b0.c.a {
            static int a(Configuration configuration0) {
                return configuration0.getLayoutDirection();
            }
        }

        final int m;
        final int n;
        private a0 o;
        private MenuItem p;

        public c(Context context0, boolean z) {
            super(context0, z);
            if(1 == androidx.appcompat.widget.b0.c.a.a(context0.getResources().getConfiguration())) {
                this.m = 21;
                this.n = 22;
                return;
            }
            this.m = 22;
            this.n = 21;
        }

        @Override  // androidx.appcompat.widget.v
        public int d(int v, int v1, int v2, int v3, int v4) {
            return super.d(v, v1, v2, v3, v4);
        }

        @Override  // androidx.appcompat.widget.v
        public boolean e(MotionEvent motionEvent0, int v) {
            return super.e(motionEvent0, v);
        }

        @Override  // androidx.appcompat.widget.v
        public boolean hasFocus() {
            return super.hasFocus();
        }

        @Override  // androidx.appcompat.widget.v
        public boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override  // androidx.appcompat.widget.v
        public boolean isFocused() {
            return super.isFocused();
        }

        @Override  // androidx.appcompat.widget.v
        public boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override  // androidx.appcompat.widget.v
        public boolean onHoverEvent(MotionEvent motionEvent0) {
            MenuItem menuItem0;
            d d0;
            int v;
            if(this.o != null) {
                ListAdapter listAdapter0 = this.getAdapter();
                if(listAdapter0 instanceof HeaderViewListAdapter) {
                    v = ((HeaderViewListAdapter)listAdapter0).getHeadersCount();
                    d0 = (d)((HeaderViewListAdapter)listAdapter0).getWrappedAdapter();
                }
                else {
                    d0 = (d)listAdapter0;
                    v = 0;
                }
                if(motionEvent0.getAction() == 10) {
                    menuItem0 = null;
                }
                else {
                    int v1 = this.pointToPosition(((int)motionEvent0.getX()), ((int)motionEvent0.getY()));
                    if(v1 == -1) {
                        menuItem0 = null;
                    }
                    else {
                        int v2 = v1 - v;
                        menuItem0 = v2 < 0 || v2 >= d0.getCount() ? null : d0.c(v2);
                    }
                }
                MenuItem menuItem1 = this.p;
                if(menuItem1 != menuItem0) {
                    e e0 = d0.b();
                    if(menuItem1 != null) {
                        this.o.c(e0, menuItem1);
                    }
                    this.p = menuItem0;
                    if(menuItem0 != null) {
                        this.o.a(e0, menuItem0);
                    }
                }
            }
            return super.onHoverEvent(motionEvent0);
        }

        @Override  // android.widget.ListView
        public boolean onKeyDown(int v, KeyEvent keyEvent0) {
            ListMenuItemView listMenuItemView0 = (ListMenuItemView)this.getSelectedView();
            if(listMenuItemView0 != null && v == this.m) {
                if(listMenuItemView0.isEnabled() && listMenuItemView0.getItemData().hasSubMenu()) {
                    this.performItemClick(listMenuItemView0, this.getSelectedItemPosition(), this.getSelectedItemId());
                }
                return true;
            }
            if(listMenuItemView0 != null && v == this.n) {
                this.setSelection(-1);
                ListAdapter listAdapter0 = this.getAdapter();
                if(listAdapter0 instanceof HeaderViewListAdapter) {
                    listAdapter0 = ((HeaderViewListAdapter)listAdapter0).getWrappedAdapter();
                }
                ((d)listAdapter0).b().d(false);
                return true;
            }
            return super.onKeyDown(v, keyEvent0);
        }

        @Override  // androidx.appcompat.widget.v
        public boolean onTouchEvent(MotionEvent motionEvent0) {
            return super.onTouchEvent(motionEvent0);
        }

        public void setHoverListener(a0 a00) {
            this.o = a00;
        }

        @Override  // androidx.appcompat.widget.v
        public void setSelector(Drawable drawable0) {
            super.setSelector(drawable0);
        }
    }

    private a0 J;
    private static Method K;

    static {
        if(Build.VERSION.SDK_INT <= 28) {
            try {
                b0.K = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
            catch(NoSuchMethodException unused_ex) {
                Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    public b0(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
    }

    public void E(Object object0) {
        a.a(this.F, ((Transition)object0));
    }

    public void F(Object object0) {
        a.b(this.F, ((Transition)object0));
    }

    public void G(a0 a00) {
        this.J = a00;
    }

    public void H(boolean z) {
        if(Build.VERSION.SDK_INT <= 28) {
            Method method0 = b0.K;
            if(method0 != null) {
                try {
                    method0.invoke(this.F, Boolean.valueOf(z));
                }
                catch(Exception unused_ex) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                }
            }
        }
        else {
            b.a(this.F, z);
        }
    }

    @Override  // androidx.appcompat.widget.a0
    public void a(e e0, MenuItem menuItem0) {
        a0 a00 = this.J;
        if(a00 != null) {
            a00.a(e0, menuItem0);
        }
    }

    @Override  // androidx.appcompat.widget.a0
    public void c(e e0, MenuItem menuItem0) {
        a0 a00 = this.J;
        if(a00 != null) {
            a00.c(e0, menuItem0);
        }
    }

    @Override  // androidx.appcompat.widget.z
    v h(Context context0, boolean z) {
        v v0 = new c(context0, z);
        ((c)v0).setHoverListener(this);
        return v0;
    }
}

