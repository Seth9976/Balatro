package l1;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.util.Log;
import c1.m;
import m1.d;

public abstract class i {
    public static boolean a(Context context0, int v) {
        if(i.b(context0, v, "com.google.android.gms")) {
            PackageManager packageManager0 = context0.getPackageManager();
            try {
                PackageInfo packageInfo0 = packageManager0.getPackageInfo("com.google.android.gms", 0x40);
                return m.a(context0).b(packageInfo0);
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
                if(Log.isLoggable("UidVerifier", 3)) {
                    Log.d("UidVerifier", "Package manager can\'t find google play services package, defaulting to false");
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean b(Context context0, int v, String s) {
        return d.a(context0).d(v, s);
    }
}

