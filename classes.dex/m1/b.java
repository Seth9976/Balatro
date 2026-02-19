package m1;

import android.content.Context;

public abstract class b {
    private static Context a;
    private static Boolean b;

    public static boolean a(Context context0) {
        synchronized(b.class) {
            Context context1 = context0.getApplicationContext();
            Context context2 = b.a;
            if(context2 != null) {
                Boolean boolean0 = b.b;
                if(boolean0 != null && context2 == context1) {
                    return boolean0.booleanValue();
                }
            }
            b.b = Boolean.valueOf(context1.getPackageManager().isInstantApp());
            b.a = context1;
            return b.b.booleanValue();
        }
    }
}

