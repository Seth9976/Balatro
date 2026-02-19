package l1;

import android.content.Context;
import android.content.pm.PackageManager;

public abstract class e {
    private static Boolean a;
    private static Boolean b;
    private static Boolean c;
    private static Boolean d;

    public static boolean a(Context context0) {
        boolean z = false;
        PackageManager packageManager0 = context0.getPackageManager();
        if(e.d == null) {
            if(packageManager0.hasSystemFeature("android.hardware.type.automotive")) {
                z = true;
            }
            e.d = Boolean.valueOf(z);
        }
        return e.d.booleanValue();
    }

    public static boolean b() [...] // 潜在的解密器

    public static boolean c(Context context0) {
        return e.g(context0.getPackageManager());
    }

    // 去混淆评级： 中等(110)
    public static boolean d(Context context0) {
        return e.c(context0) && false || e.e(context0);
    }

    public static boolean e(Context context0) {
        boolean z = false;
        if(e.b == null) {
            if(context0.getPackageManager().hasSystemFeature("cn.google")) {
                z = true;
            }
            e.b = Boolean.valueOf(z);
        }
        return e.b.booleanValue();
    }

    public static boolean f(Context context0) {
        boolean z = true;
        if(e.c == null) {
            if(!context0.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context0.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z = false;
            }
            e.c = Boolean.valueOf(z);
        }
        return e.c.booleanValue();
    }

    public static boolean g(PackageManager packageManager0) {
        boolean z = false;
        if(e.a == null) {
            if(packageManager0.hasSystemFeature("android.hardware.type.watch")) {
                z = true;
            }
            e.a = Boolean.valueOf(z);
        }
        return e.a.booleanValue();
    }
}

