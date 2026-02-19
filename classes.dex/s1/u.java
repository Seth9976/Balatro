package s1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Pair;
import c2.w1;
import c2.z1;
import java.util.List;
import m1.d;

public abstract class u {
    public static s a(Context context0, Class class0) {
        ActivityInfo activityInfo2;
        Bundle bundle0;
        try {
            ApplicationInfo applicationInfo0 = d.a(context0).a("com.playstack.balatro.android", 0x80);
            bundle0 = null;
            if(applicationInfo0 != null) {
                bundle0 = applicationInfo0.metaData;
            }
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        String s = "";
        Long long0 = null;
        if(bundle0 != null) {
            try {
                long0 = Long.parseLong(bundle0.getString("com.google.android.gms.games.APP_ID", ""));
            }
            catch(NumberFormatException unused_ex) {
            }
        }
        if(long0 == null) {
            return null;
        }
        Intent intent0 = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").setPackage("com.playstack.balatro.android");
        List list0 = context0.getPackageManager().queryIntentActivities(intent0, 0xC2200);
        w1 w10 = new w1();
        for(Object object0: list0) {
            ResolveInfo resolveInfo0 = (ResolveInfo)object0;
            ActivityInfo activityInfo0 = resolveInfo0.activityInfo;
            if(activityInfo0 != null) {
                int v = context0.getPackageManager().getComponentEnabledSetting(new ComponentName(activityInfo0.packageName, activityInfo0.name));
                if(v != 0) {
                    if(v == 1) {
                        goto label_24;
                    }
                    continue;
                }
                else if(!activityInfo0.enabled) {
                    continue;
                }
            label_24:
                if(resolveInfo0.activityInfo.exported) {
                    w10.a(resolveInfo0);
                }
            }
        }
        z1 z10 = w10.b();
        int v1 = z10.size();
        int v3 = 0x7FFFFFFF;
        for(int v2 = 0; v2 < v1; ++v2) {
            ActivityInfo activityInfo1 = ((ResolveInfo)z10.get(v2)).activityInfo;
            if(activityInfo1 != null) {
                ComponentName componentName0 = new ComponentName(activityInfo1.packageName, activityInfo1.name);
                try {
                    activityInfo2 = null;
                    activityInfo2 = context0.getPackageManager().getActivityInfo(componentName0, 0xC2280);
                }
                catch(PackageManager.NameNotFoundException unused_ex) {
                }
                if(activityInfo2 != null) {
                    Bundle bundle1 = activityInfo2.metaData;
                    if(bundle1 != null) {
                        v3 = Math.min(v3, bundle1.getInt("com.google.android.gms.games.APP_SHORTCUTS_MAX_NUMBER", 0x7FFFFFFF));
                        s = bundle1.getString("com.google.android.gms.games.APP_SHORTCUTS_TARGET_ACTIVITY", s);
                    }
                }
            }
        }
        Pair pair0 = new Pair(v3, s);
        return new s(((long)long0), "com.playstack.balatro.android", ((int)(((Integer)pair0.first))), new ComponentName(context0, class0), ((String)pair0.second).trim());
    }
}

