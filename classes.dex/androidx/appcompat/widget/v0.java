package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import androidx.core.view.v;
import java.lang.reflect.Method;

public abstract class v0 {
    private static Method a;
    static final boolean b;

    static {
        try {
            v0.b = Build.VERSION.SDK_INT >= 27;
            Method method0 = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            v0.a = method0;
            if(!method0.isAccessible()) {
                v0.a.setAccessible(true);
            }
        }
        catch(NoSuchMethodException unused_ex) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    public static boolean a(View view0) {
        return v.o(view0) == 1;
    }
}

