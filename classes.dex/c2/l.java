package c2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import java.util.Objects;
import m1.d;

final class l {
    private boolean a;
    private boolean b;
    static final l c;

    static {
        l.c = new l();
    }

    final boolean a(Activity activity0) {
        ActivityInfo activityInfo0;
        if(!this.b) {
            try {
                activityInfo0 = null;
                ApplicationInfo applicationInfo0 = d.a(activity0).a("com.playstack.balatro.android", 0x80);
                Bundle bundle0 = null;
                if(applicationInfo0 != null) {
                    bundle0 = applicationInfo0.metaData;
                }
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
            }
            boolean z = false;
            if(bundle0 != null && bundle0.getString("com.epicgames.unreal.GameActivity.EngineVersion", "").startsWith("5.")) {
                ComponentName componentName0 = new ComponentName(activity0, "com.epicgames.unreal.GameActivity");
                try {
                    activityInfo0 = activity0.getPackageManager().getActivityInfo(componentName0, 0x80);
                }
                catch(PackageManager.NameNotFoundException unused_ex) {
                }
                if(activityInfo0 != null) {
                    Bundle bundle1 = activityInfo0.metaData;
                    if(bundle1 != null) {
                        z = Objects.equals(bundle1.getString("android.app.lib_name", ""), "Unreal");
                    }
                }
            }
            this.a = z;
            this.b = true;
            return z;
        }
        return this.a;
    }
}

