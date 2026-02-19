package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public abstract class x {
    static abstract class a {
        static int a(ViewConfiguration viewConfiguration0) {
            return viewConfiguration0.getScaledHoverSlop();
        }

        static boolean b(ViewConfiguration viewConfiguration0) {
            return viewConfiguration0.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    private static Method a;

    static {
        if(Build.VERSION.SDK_INT == 25) {
            try {
                x.a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor");
            }
            catch(Exception unused_ex) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    public static int a(ViewConfiguration viewConfiguration0) {
        return Build.VERSION.SDK_INT < 28 ? viewConfiguration0.getScaledTouchSlop() / 2 : a.a(viewConfiguration0);
    }

    public static boolean b(ViewConfiguration viewConfiguration0, Context context0) {
        if(Build.VERSION.SDK_INT >= 28) {
            return a.b(viewConfiguration0);
        }
        Resources resources0 = context0.getResources();
        int v = resources0.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
        return v != 0 && resources0.getBoolean(v);
    }
}

