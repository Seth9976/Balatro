package m1;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

public class c {
    protected final Context a;

    public c(Context context0) {
        this.a = context0;
    }

    public ApplicationInfo a(String s, int v) {
        return this.a.getPackageManager().getApplicationInfo(s, v);
    }

    public CharSequence b(String s) {
        return this.a.getPackageManager().getApplicationLabel(this.a.getPackageManager().getApplicationInfo(s, 0));
    }

    public PackageInfo c(String s, int v) {
        return this.a.getPackageManager().getPackageInfo(s, v);
    }

    public final boolean d(int v, String s) {
        try {
            AppOpsManager appOpsManager0 = (AppOpsManager)this.a.getSystemService("appops");
            if(appOpsManager0 == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager0.checkPackage(v, s);
            return true;
        }
        catch(SecurityException unused_ex) {
            return false;
        }
    }
}

