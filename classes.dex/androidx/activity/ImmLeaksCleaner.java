package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.h.b;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import java.lang.reflect.Field;

final class ImmLeaksCleaner implements j {
    private Activity a;
    private static int b;
    private static Field c;
    private static Field d;
    private static Field e;

    static {
    }

    ImmLeaksCleaner(Activity activity0) {
        this.a = activity0;
    }

    @Override  // androidx.lifecycle.j
    public void d(l l0, b h$b0) {
        Object object0;
        if(h$b0 != b.ON_DESTROY) {
            return;
        }
        if(ImmLeaksCleaner.b == 0) {
            ImmLeaksCleaner.h();
        }
        if(ImmLeaksCleaner.b == 1) {
            InputMethodManager inputMethodManager0 = (InputMethodManager)this.a.getSystemService("input_method");
            try {
                object0 = ImmLeaksCleaner.c.get(inputMethodManager0);
                if(object0 == null) {
                    return;
                }
            }
            catch(IllegalAccessException unused_ex) {
                return;
            }
            synchronized(object0) {
                try {
                    View view0 = (View)ImmLeaksCleaner.d.get(inputMethodManager0);
                }
                catch(IllegalAccessException unused_ex) {
                    return;
                }
                catch(ClassCastException unused_ex) {
                    return;
                }
            }
            if(view0 == null) {
                return;
            }
            if(view0.isAttachedToWindow()) {
                return;
            }
            try {
                ImmLeaksCleaner.e.set(inputMethodManager0, null);
            }
            catch(IllegalAccessException unused_ex) {
                return;
            }
            inputMethodManager0.isActive();
        }
    }

    private static void h() {
        try {
            ImmLeaksCleaner.b = 2;
            Field field0 = InputMethodManager.class.getDeclaredField("mServedView");
            ImmLeaksCleaner.d = field0;
            field0.setAccessible(true);
            Field field1 = InputMethodManager.class.getDeclaredField("mNextServedView");
            ImmLeaksCleaner.e = field1;
            field1.setAccessible(true);
            Field field2 = InputMethodManager.class.getDeclaredField("mH");
            ImmLeaksCleaner.c = field2;
            field2.setAccessible(true);
            ImmLeaksCleaner.b = 1;
        }
        catch(NoSuchFieldException unused_ex) {
        }
    }
}

