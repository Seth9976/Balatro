package androidx.core.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class f {
    public interface a {
        boolean i(KeyEvent arg1);
    }

    private static boolean a;
    private static Method b;
    private static boolean c;
    private static Field d;

    static {
    }

    private static boolean a(ActionBar actionBar0, KeyEvent keyEvent0) {
        if(!f.a) {
            try {
                f.b = actionBar0.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            }
            catch(NoSuchMethodException unused_ex) {
            }
            f.a = true;
        }
        Method method0 = f.b;
        if(method0 != null) {
            try {
                Object object0 = method0.invoke(actionBar0, keyEvent0);
                return object0 == null ? false : ((Boolean)object0).booleanValue();
            }
            catch(IllegalAccessException | InvocationTargetException unused_ex) {
            }
        }
        return false;
    }

    private static boolean b(Activity activity0, KeyEvent keyEvent0) {
        activity0.onUserInteraction();
        Window window0 = activity0.getWindow();
        if(window0.hasFeature(8)) {
            ActionBar actionBar0 = activity0.getActionBar();
            if(keyEvent0.getKeyCode() == 82 && actionBar0 != null && f.a(actionBar0, keyEvent0)) {
                return true;
            }
        }
        if(window0.superDispatchKeyEvent(keyEvent0)) {
            return true;
        }
        View view0 = window0.getDecorView();
        if(v.d(view0, keyEvent0)) {
            return true;
        }
        return view0 == null ? keyEvent0.dispatch(activity0, null, activity0) : keyEvent0.dispatch(activity0, view0.getKeyDispatcherState(), activity0);
    }

    private static boolean c(Dialog dialog0, KeyEvent keyEvent0) {
        DialogInterface.OnKeyListener dialogInterface$OnKeyListener0 = f.f(dialog0);
        if(dialogInterface$OnKeyListener0 != null && dialogInterface$OnKeyListener0.onKey(dialog0, keyEvent0.getKeyCode(), keyEvent0)) {
            return true;
        }
        Window window0 = dialog0.getWindow();
        if(window0.superDispatchKeyEvent(keyEvent0)) {
            return true;
        }
        View view0 = window0.getDecorView();
        if(v.d(view0, keyEvent0)) {
            return true;
        }
        return view0 == null ? keyEvent0.dispatch(dialog0, null, dialog0) : keyEvent0.dispatch(dialog0, view0.getKeyDispatcherState(), dialog0);
    }

    public static boolean d(View view0, KeyEvent keyEvent0) {
        return v.e(view0, keyEvent0);
    }

    public static boolean e(a f$a0, View view0, Window.Callback window$Callback0, KeyEvent keyEvent0) {
        if(f$a0 == null) {
            return false;
        }
        if(Build.VERSION.SDK_INT >= 28) {
            return f$a0.i(keyEvent0);
        }
        if(window$Callback0 instanceof Activity) {
            return f.b(((Activity)window$Callback0), keyEvent0);
        }
        return window$Callback0 instanceof Dialog ? f.c(((Dialog)window$Callback0), keyEvent0) : view0 != null && v.d(view0, keyEvent0) || f$a0.i(keyEvent0);
    }

    private static DialogInterface.OnKeyListener f(Dialog dialog0) {
        if(!f.c) {
            try {
                Field field0 = Dialog.class.getDeclaredField("mOnKeyListener");
                f.d = field0;
                field0.setAccessible(true);
            }
            catch(NoSuchFieldException unused_ex) {
            }
            f.c = true;
        }
        Field field1 = f.d;
        if(field1 != null) {
            try {
                return (DialogInterface.OnKeyListener)field1.get(dialog0);
            }
            catch(IllegalAccessException unused_ex) {
            }
        }
        return null;
    }
}

