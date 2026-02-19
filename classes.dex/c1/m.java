package c1;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import g1.q;

public class m {
    private final Context a;
    private static m b;

    public m(Context context0) {
        this.a = context0.getApplicationContext();
    }

    public static m a(Context context0) {
        q.i(context0);
        synchronized(m.class) {
            if(m.b == null) {
                a0.a(context0);
                m.b = new m(context0);
            }
            return m.b;
        }
    }

    public boolean b(PackageInfo packageInfo0) {
        if(packageInfo0 == null) {
            return false;
        }
        if(m.d(packageInfo0, false)) {
            return true;
        }
        if(m.d(packageInfo0, true)) {
            if(l.c(this.a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren\'t accepted on this build.");
        }
        return false;
    }

    static final w c(PackageInfo packageInfo0, w[] arr_w) {
        Signature[] arr_signature = packageInfo0.signatures;
        if(arr_signature != null) {
            if(arr_signature.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            x x0 = new x(packageInfo0.signatures[0].toByteArray());
            for(int v = 0; v < arr_w.length; ++v) {
                if(arr_w[v].equals(x0)) {
                    return arr_w[v];
                }
            }
        }
        return null;
    }

    public static final boolean d(PackageInfo packageInfo0, boolean z) {
        if(z) {
            if(packageInfo0 == null) {
                throw new NullPointerException();
            }
            if("com.android.vending".equals(packageInfo0.packageName) || "com.google.android.gms".equals(packageInfo0.packageName)) {
                if(packageInfo0.applicationInfo != null && (packageInfo0.applicationInfo.flags & 0x81) != 0) {
                    return packageInfo0 == null || packageInfo0.signatures == null ? false : m.c(packageInfo0, z.a) != null;
                }
                return packageInfo0 == null || packageInfo0.signatures == null ? false : m.c(packageInfo0, new w[]{z.a[0]}) != null;
            }
        }
        return packageInfo0 == null || packageInfo0.signatures == null ? false : (z ? m.c(packageInfo0, z.a) : m.c(packageInfo0, new w[]{z.a[0]})) != null;
    }
}

