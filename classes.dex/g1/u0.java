package g1;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import m1.c;
import m1.d;

public abstract class u0 {
    private static final Object a;
    private static boolean b;
    private static String c;
    private static int d;

    static {
        u0.a = new Object();
    }

    public static int a(Context context0) {
        u0.b(context0);
        return u0.d;
    }

    private static void b(Context context0) {
        synchronized(u0.a) {
            if(u0.b) {
                return;
            }
            u0.b = true;
            c c0 = d.a(context0);
            try {
                Bundle bundle0 = c0.a("com.playstack.balatro.android", 0x80).metaData;
                if(bundle0 == null) {
                    return;
                }
                u0.c = bundle0.getString("com.google.app.id");
                u0.d = bundle0.getInt("com.google.android.gms.version");
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                Log.wtf("MetadataValueReader", "This should never happen.", packageManager$NameNotFoundException0);
            }
        }
    }
}

