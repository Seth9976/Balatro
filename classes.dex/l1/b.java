package l1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import m1.d;

public abstract class b {
    public static int a(Context context0, String s) {
        PackageInfo packageInfo0 = b.b(context0, s);
        if(packageInfo0 != null) {
            ApplicationInfo applicationInfo0 = packageInfo0.applicationInfo;
            if(applicationInfo0 != null) {
                return applicationInfo0.metaData == null ? -1 : applicationInfo0.metaData.getInt("com.google.android.gms.version", -1);
            }
        }
        return -1;
    }

    public static PackageInfo b(Context context0, String s) {
        try {
            return d.a(context0).c(s, 0x80);
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return null;
        }
    }
}

