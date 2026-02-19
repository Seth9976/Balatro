package c1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesMissingManifestValueException;
import g1.q;
import g1.u0;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import l1.e;
import l1.j;
import m1.d;

public abstract class l {
    public static final int a = 12451000;
    static final AtomicBoolean b;
    private static boolean c;
    static boolean d;
    private static final AtomicBoolean e;

    static {
        l.b = new AtomicBoolean();
        l.e = new AtomicBoolean();
    }

    public static String a(int v) {
        return a.o0(v);
    }

    public static Resources b(Context context0) {
        try {
            return context0.getPackageManager().getResourcesForApplication("com.google.android.gms");
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return null;
        }
    }

    public static boolean c(Context context0) {
        if(!l.d) {
            try {
                PackageInfo packageInfo0 = d.a(context0).c("com.google.android.gms", 0x40);
                m.a(context0);
                l.c = packageInfo0 == null || m.d(packageInfo0, false) || !m.d(packageInfo0, true) ? false : true;
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", packageManager$NameNotFoundException0);
            }
            finally {
                l.d = true;
            }
        }
        return true;
    }

    public static int d(Context context0, int v) {
        PackageInfo packageInfo1;
        String s;
        PackageInfo packageInfo0;
        try {
            context0.getResources().getString(n.a);
        }
        catch(Throwable unused_ex) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if(!l.e.get()) {
            int v1 = u0.a(context0);
            if(v1 == 0) {
                throw new GooglePlayServicesMissingManifestValueException();
            }
            if(v1 != l.a) {
                throw new GooglePlayServicesIncorrectManifestValueException(v1);
            }
        }
        boolean z = !e.d(context0) && !e.f(context0);
        q.a(v >= 0);
        PackageManager packageManager0 = context0.getPackageManager();
        if(z) {
            try {
                packageInfo0 = packageManager0.getPackageInfo("com.android.vending", 0x2040);
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
                s = " requires the Google Play Store, but it is missing.";
                Log.w("GooglePlayServicesUtil", "com.playstack.balatro.android" + s);
                return 9;
            }
        }
        else {
            packageInfo0 = null;
        }
        try {
            packageInfo1 = packageManager0.getPackageInfo("com.google.android.gms", 0x40);
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            Log.w("GooglePlayServicesUtil", "com.playstack.balatro.android requires Google Play services, but they are missing.");
            return 1;
        }
        m.a(context0);
        if(!m.d(packageInfo1, true)) {
            s = " requires Google Play services, but their signature is invalid.";
            Log.w("GooglePlayServicesUtil", "com.playstack.balatro.android" + s);
            return 9;
        }
        if(z) {
            q.i(packageInfo0);
            if(!m.d(packageInfo0, true)) {
                s = " requires Google Play Store, but its signature is invalid.";
                Log.w("GooglePlayServicesUtil", "com.playstack.balatro.android" + s);
                return 9;
            }
        }
        if(z && packageInfo0 != null && !packageInfo0.signatures[0].equals(packageInfo1.signatures[0])) {
            s = " requires Google Play Store, but its signature doesn\'t match that of Google Play services.";
            Log.w("GooglePlayServicesUtil", "com.playstack.balatro.android" + s);
            return 9;
        }
        if(j.a(packageInfo1.versionCode) < j.a(v)) {
            Log.w("GooglePlayServicesUtil", "Google Play services out of date for com.playstack.balatro.android.  Requires " + v + " but found " + packageInfo1.versionCode);
            return 2;
        }
        ApplicationInfo applicationInfo0 = packageInfo1.applicationInfo;
        if(applicationInfo0 == null) {
            try {
                return packageManager0.getApplicationInfo("com.google.android.gms", 0).enabled ? 0 : 3;
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                Log.wtf("GooglePlayServicesUtil", "com.playstack.balatro.android requires Google Play services, but they\'re missing when getting application info.", packageManager$NameNotFoundException0);
                return 1;
            }
        }
        return applicationInfo0.enabled ? 0 : 3;
    }

    public static boolean e(Context context0, int v) {
        switch(v) {
            case 1: {
                return l.h(context0, "com.google.android.gms");
            }
            case 18: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static boolean f(Context context0) {
        Object object0 = context0.getSystemService("user");
        q.i(object0);
        Bundle bundle0 = ((UserManager)object0).getApplicationRestrictions("com.playstack.balatro.android");
        return bundle0 != null && "true".equals(bundle0.getString("restricted_profile"));
    }

    public static boolean g(int v) {
        return v == 1 || v == 2 || v == 3 || v == 9;
    }

    static boolean h(Context context0, String s) {
        boolean z = s.equals("com.google.android.gms");
        try {
            List list0 = context0.getPackageManager().getPackageInstaller().getAllSessions();
        }
        catch(Exception unused_ex) {
            return false;
        }
        for(Object object0: list0) {
            if(s.equals(((PackageInstaller.SessionInfo)object0).getAppPackageName())) {
                return true;
            }
            if(false) {
                break;
            }
        }
        PackageManager packageManager0 = context0.getPackageManager();
        try {
            ApplicationInfo applicationInfo0 = packageManager0.getApplicationInfo(s, 0x2000);
            if(z) {
                return applicationInfo0.enabled;
            }
            if(applicationInfo0.enabled && !l.f(context0)) {
                return true;
            }
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        return false;
    }
}

